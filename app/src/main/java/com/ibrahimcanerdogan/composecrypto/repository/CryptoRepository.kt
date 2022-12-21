package com.ibrahimcanerdogan.composecrypto.repository

import com.ibrahimcanerdogan.composecrypto.model.CryptoList
import com.ibrahimcanerdogan.composecrypto.service.CryptoAPI
import com.ibrahimcanerdogan.composecrypto.util.Constants
import com.ibrahimcanerdogan.composecrypto.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Scope

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api : CryptoAPI
) {
    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList()
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

}