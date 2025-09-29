package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.github.domain.model.UrlPath
import com.calyrsoft.ucbp1.features.login.domain.model.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Cellphone

data class ProfileModel(
    val pathUrl: UrlPath,
    val name: String,
    val email: Email,
    val cellphone: Cellphone,
    val summary: String
)
