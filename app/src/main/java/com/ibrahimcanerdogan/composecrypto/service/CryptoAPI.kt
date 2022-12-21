package com.ibrahimcanerdogan.composecrypto.service

import com.ibrahimcanerdogan.composecrypto.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    @GET("crypto")
    suspend fun getCryptoList() : CryptoList


/*    @GET("crypto")
    suspend fun getCryptoList(
        @Query("key") key : String
    ) : Unit*/
}