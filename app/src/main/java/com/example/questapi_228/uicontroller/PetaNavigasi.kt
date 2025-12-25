package com.example.questapi_228.uicontroller

import android.os.Build
//import androidx.annotation.RequiresExtension
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questapi_228.modeldata.DetailSiswa
import com.example.questapi_228.uicontroller.route.DestinasiDetail
import com.example.questapi_228.uicontroller.route.DestinasiEdit
import com.example.questapi_228.uicontroller.route.DestinasiEntry
import com.example.questapi_228.uicontroller.route.DestinasiHome
import com.example.questapi_228.view.DetailSiswaScreen
import com.example.questapi_228.view.EditSiswaScreen
import com.example.questapi_228.view.EntrySiswaScreen
import com.example.questapi_228.view.HomeScreen

@Composable
fun DataSiswaApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()){
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = modifier)
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate("${DestinasiDetail.route}/${it}") }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }
        composable(DestinasiDetail.routewithArgs, arguments = listOf(navArgument(DestinasiDetail
            .itemIdArg){
            type = NavType.IntType})
        ) {
            DetailSiswaScreen(navigateToEditItem = {navController.navigate("${DestinasiEdit.route}/${it}")},
                navigateBack = { navController.navigate(DestinasiHome.route) })
        }
        composable(DestinasiEdit.routewithArgs, arguments = listOf(navArgument(DestinasiEdit.itemIdArg
        ){
            type = NavType.IntType})) {
            EditSiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}


