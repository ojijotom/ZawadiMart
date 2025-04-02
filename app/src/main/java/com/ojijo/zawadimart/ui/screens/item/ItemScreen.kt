package com.ojijo.zawadimart.ui.screens.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ojijo.zawadimart.ui.theme.newOrange
import com.ojijo.zawadimart.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(){

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        //TopAppBar
        TopAppBar(
            title = { Text(text = "Products") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newOrange,
                titleContentColor = newWhite
            )
        )
        //End


    }

}
@Preview(showBackground = true)
@Composable
fun ItemScreenPreview(){

    ItemScreen()

}