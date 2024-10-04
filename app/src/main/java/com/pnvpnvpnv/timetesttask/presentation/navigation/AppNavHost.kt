package com.pnvpnvpnv.timetesttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list.CityListScreen
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list.CityListViewModel
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.CityTimeScreen
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.CityTimeViewModel


@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.screenViewModel(
    navController: NavHostController
): T {
    val parentEntry = remember(this) {
        navController.getBackStackEntry(this.destination.route ?: "")
    }
    return hiltViewModel<T>(parentEntry)
}

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = Screen.CityTime.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.CityTime.route) { backStackEntry ->
            val viewModel = backStackEntry.screenViewModel<CityTimeViewModel>(navController)
            CityTimeScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = Screen.CityList.route) { backStackEntry ->
            val viewModel = backStackEntry.screenViewModel<CityListViewModel>(navController)
            CityListScreen(viewModel = viewModel, navController = navController)
        }
    }
}