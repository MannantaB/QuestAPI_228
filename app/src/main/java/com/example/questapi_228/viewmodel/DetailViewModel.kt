@file:OptIn(InternalSerializationApi::class)

package com.example.questapi_228.viewmodel

import com.example.questapi_228.modeldata.DataSiswa

sealed interface StatusUIDetail {
    data class Success(val statusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}


