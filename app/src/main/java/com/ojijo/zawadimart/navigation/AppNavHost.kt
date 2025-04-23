package com.ojijo.zawadimart.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ojijo.zawadimart.data.UserDatabase
import com.ojijo.zawadimart.repository.UserRepository
import com.ojijo.zawadimart.ui.screens.about.AboutScreen
import com.ojijo.zawadimart.ui.screens.assignment.AssignmentScreen
import com.ojijo.zawadimart.ui.screens.auth.LoginScreen
import com.ojijo.zawadimart.ui.screens.auth.RegisterScreen
import com.ojijo.zawadimart.ui.screens.dashboard.DashboardScreen
import com.ojijo.zawadimart.ui.screens.form.FormScreen
import com.ojijo.zawadimart.ui.screens.home.HomeScreen
import com.ojijo.zawadimart.ui.screens.intent.IntentScreen
import com.ojijo.zawadimart.ui.screens.item.ItemScreen
import com.ojijo.zawadimart.ui.screens.products.AddProductScreen
import com.ojijo.zawadimart.ui.screens.products.EditProductScreen
import com.ojijo.zawadimart.ui.screens.products.ProductListScreen
import com.ojijo.zawadimart.ui.screens.service.ServiceScreen
import com.ojijo.zawadimart.ui.screens.splash.SplashScreen
import com.ojijo.zawadimart.ui.screens.start.StartScreen
import com.ojijo.zawadimart.viewmodel.AuthViewModel
import com.ojijo.zawadimart.viewmodel.ProductViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ADD_PRODUCT,
    productViewModel: ProductViewModel = viewModel(),

    ) {

    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_ASSIGNMENT) {
            AssignmentScreen(navController)
        }
        composable(ROUT_FORM) {
            FormScreen(navController)
        }


        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }



        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }










    }
}

