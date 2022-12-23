package com.ibrahimcanerdogan.composecrypto.service

import com.ibrahimcanerdogan.composecrypto.model.Crypto
import com.ibrahimcanerdogan.composecrypto.model.CryptoList
import retrofit2.http.GET

interface CryptoAPI {

    @GET("crypto")
    suspend fun getCryptoList() : CryptoList

    @GET("crypto")
    suspend fun getCrypto(id: Int) : Crypto

    /*    @GET("crypto")
        suspend fun getCryptoList(
            @Query("key") key : String
        ) : Unit*/
}