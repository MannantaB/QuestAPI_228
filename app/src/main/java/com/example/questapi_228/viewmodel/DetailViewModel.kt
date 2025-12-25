@file:OptIn(InternalSerializationApi::class)

package com.example.questapi_228.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_228.modeldata.DataSiswa
import com.example.questapi_228.repositori.RepositoryDataSiswa
import com.example.questapi_228.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa:
    RepositoryDataSiswa): ViewModel(){
        private val idSiswa: Int =
            checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(satusiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
            }
            catch (e: Exception){
                StatusUIDetail.Error
            }
            catch (e: HttpException){
                StatusUIDetail.Error
            }
       }
    }
    }



