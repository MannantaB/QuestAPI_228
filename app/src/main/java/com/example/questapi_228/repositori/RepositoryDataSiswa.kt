package com.example.questapi_228.repositori

import android.provider.ContactsContract
import com.example.questapi_228.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
}