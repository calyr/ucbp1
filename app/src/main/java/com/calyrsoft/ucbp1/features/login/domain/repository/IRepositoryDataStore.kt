package com.calyrsoft.ucbp1.features.login.domain.repository

interface IRepositoryDataStore {

    suspend fun saveEmail(email: String)
    suspend fun getEmail(): String

    suspend fun saveToken(token: String)
    suspend fun getToken(): String
}