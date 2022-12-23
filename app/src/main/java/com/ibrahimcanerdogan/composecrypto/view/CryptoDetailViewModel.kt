package com.ibrahimcanerdogan.composecrypto.view

import androidx.lifecycle.ViewModel
import com.ibrahimcanerdogan.composecrypto.model.Crypto
import com.ibrahimcanerdogan.composecrypto.repository.CryptoRepository
import com.ibrahimcanerdogan.composecrypto.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {
    suspend fun getCrypto(id : Int) : Resource<Crypto> {
        return repository.getCrypto(id)
    }
}