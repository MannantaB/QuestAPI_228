package com.example.questapi_228.viewmodel.provider

import android.os.Build
//import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi_228.repositori.AplikasiDataSiswa
import com.example.questapi_228.viewmodel.DetailViewModel
import com.example.questapi_228.viewmodel.EditViewModel
import com.example.questapi_228.viewmodel.EntryViewModel
import com.example.questapi_228.viewmodel.HomeViewModel
import okhttp3.Call

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
            AplikasiDataSiswa
        )

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container
            .repositoryDataSiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container
            .repositoryDataSiswa) }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
    }
}