package com.mbougar.ejerciciopmdmmanuelbouza.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.mbougar.ejerciciopmdmmanuelbouza.model.Producto
import com.mbougar.ejerciciopmdmmanuelbouza.ui.screens.LoginScreen
import com.mbougar.ejerciciopmdmmanuelbouza.ui.screens.MainScreen
import com.mbougar.ejerciciopmdmmanuelbouza.ui.screens.SignInScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("signin") { SignInScreen(navController) }
        composable("register") {  }
        composable("mainScreen") { MainScreen(navController) }
    }
}