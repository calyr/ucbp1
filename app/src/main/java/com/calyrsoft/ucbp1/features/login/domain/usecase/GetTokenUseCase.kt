package com.calyrsoft.ucbp1.features.login.domain.usecase

import com.calyrsoft.ucbp1.features.login.domain.repository.IRepositoryDataStore

class GetTokenUseCase
    (val repository: IRepositoryDataStore){

    suspend fun invoke(): String {
        return repository.getToken()
    }

}