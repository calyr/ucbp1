package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.github.domain.model.UrlPath
import com.calyrsoft.ucbp1.features.login.domain.model.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Summary
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class GetProfileUseCaseTest {

    val repository: IProfileRepository = mockk()
    val getProfileUseCase = GetProfileUseCase(repository)

    @Test
    fun `should return profile successfully when repository returns data`() = runTest {
        //arrange
        val profile = ProfileModel(
            UrlPath("https://github.com/users/juan"),
            Name.create("Juan"),
            Email.create("john.catron@example-pet-store.com"),
            Cellphone("70710152"),
            Summary.create("  Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        )
        val expected = Result.success(profile)

        coEvery { repository.fetchData() } returns expected
        //act
        val actual = getProfileUseCase.invoke()
        //asert (actual  -----> expect)
        assertEquals(expected, actual)
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", actual.getOrNull()?.summary?.value)

    }

    @Test
    fun `should return profile failure when repository return exception`() = runTest {

        //arrange
        val exception = Exception("Error fetching profile")
        val expected = Result.failure<Exception>(exception)
        coEvery { repository.fetchData() } returns Result.failure(exception)
        //act
        val actual = getProfileUseCase.invoke()

        //assert
        assertEquals(expected, actual)


    }

}