package com.ibrahimcanerdogan.composecrypto.view

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.composecrypto.model.CryptoListItem
import com.ibrahimcanerdogan.composecrypto.repository.CryptoRepository
import com.ibrahimcanerdogan.composecrypto.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    // Compose has a Mutable State therefore don't use livedata.
    var cryptoList = mutableStateOf<List<CryptoListItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun loadCryptos() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCryptoList()
            when(result) {
                is Resource.Success -> {
                    val cryptoItems = result.data?.mapIndexed { _, cryptoListItem ->
                        CryptoListItem(cryptoListItem.currency, cryptoListItem.price)
                    } as List<CryptoListItem>
                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value += cryptoItems
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }

                else -> { Log.i(TAG, "loadCryptos")}
            }
        }
    }

    companion object {
        private const val TAG = "CryptoListViewModel"
    }
}