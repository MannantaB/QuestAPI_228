package com.example.questapi_228.uicontroller.route

import com.example.questapi_228.R

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa

    const val itemIdArg = "idSiswa"
    val routewithArgs = "$route/{$itemIdArg}"
}
