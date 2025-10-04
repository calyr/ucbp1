package com.calyrsoft.ucbp1.features.login.domain.usecase

import com.calyrsoft.ucbp1.features.login.domain.repository.IRepositoryDataStore

class SaveTokenUseCase(
    val repository: IRepositoryDataStore
) {
    suspend fun invoke(token: String) {
        repository.saveToken(token)
    }
}