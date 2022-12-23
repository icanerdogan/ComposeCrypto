package com.ibrahimcanerdogan.composecrypto.repository

import com.ibrahimcanerdogan.composecrypto.model.Crypto
import com.ibrahimcanerdogan.composecrypto.model.CryptoList
import com.ibrahimcanerdogan.composecrypto.service.CryptoAPI
import com.ibrahimcanerdogan.composecrypto.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

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

    suspend fun getCrypto(id : Int): Resource<Crypto> {
        val response = try {
            api.getCrypto(id)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}