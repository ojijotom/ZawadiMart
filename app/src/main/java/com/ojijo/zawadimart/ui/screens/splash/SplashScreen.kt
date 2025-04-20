package com.ojijo.zawadimart.ui.screens.splash

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojijo.zawadimart.R
import com.ojijo.zawadimart.navigation.ROUT_LOGIN
import com.ojijo.zawadimart.navigation.ROUT_SPLASH
import com.ojijo.zawadimart.navigation.ROUT_START
import com.ojijo.zawadimart.ui.theme.newOrange
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    //Navigation

    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        kotlinx.coroutines.delay(2000)
        navController.navigate(ROUT_LOGIN)
    }


    //End pf Navigation


    Column(
        modifier = Modifier.fillMaxSize().background(newOrange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {

        Image(
            painter = painterResource(R.drawable.img_2),
            contentDescription = "oji1",
            modifier = Modifier.size(300.dp)

        )


    }




}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){

    SplashScreen(rememberNavController())

}