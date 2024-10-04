package com.pnvpnvpnv.timetesttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list.CityListScreen
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.CityTimeScreen


@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = Screen.CityTime.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.CityTime.route) { backStackEntry ->
            CityTimeScreen(navController = navController)
        }

        composable(route = Screen.CityList.route) { backStackEntry ->
            CityListScreen(navController = navController)
        }
    }
}