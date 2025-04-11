package com.ojijo.zawadimart.ui.screens.assignment

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.handwriting.handwritingHandler
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojijo.zawadimart.R
import com.ojijo.zawadimart.navigation.ROUT_HOME
import com.ojijo.zawadimart.navigation.ROUT_ITEM
import com.ojijo.zawadimart.navigation.ROUT_SERVICE
import com.ojijo.zawadimart.navigation.ROUT_START
import com.ojijo.zawadimart.ui.theme.newOrange
import com.ojijo.zawadimart.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignmentScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("PROJECT") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newWhite,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.White
                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newWhite
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_SERVICE)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_ITEM)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Favorites") },
                    label = { Text("Info") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )

            }
        },

        //Contents
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                val mContext = LocalContext.current



                //Main Contents of the page
                Spacer(modifier = Modifier.height(20.dp))


                //SearchBar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = {search = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                    placeholder = { Text(text = "Search...") }
                )

                //End of SearchBar

                Spacer(modifier = Modifier.height(20.dp))


                }
            Column (
                modifier = Modifier.fillMaxSize()
            ){

                Box (modifier = Modifier.verticalScroll(rememberScrollState())){
                    //Card
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp)
                        ,
                        colors = CardDefaults.cardColors(newWhite)
                    ){

                        Spacer(modifier = Modifier.height(100.dp))


                        Column (modifier = Modifier.fillMaxSize().padding(20.dp)){

                            val mContext = LocalContext.current


                            Text(
                                text = "Hi Ojijo !",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontStyle = FontStyle.Italic,
                                color = Color.Black,
                                fontFamily = FontFamily.Cursive
                            )

                            Text(text = "Here are your projects")

                            Spacer(modifier = Modifier.height(30.dp))



                            //Row1
                            Row (modifier = Modifier
                                .padding(start = 10.dp)
                                .horizontalScroll(rememberScrollState())
                            ){

                                //Card1
                                Card (
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(200.dp)
                                        .clickable{navController.navigate(ROUT_HOME)}
                                ){
                                    Column (
                                        modifier = Modifier.fillMaxSize().background(color = Color.Blue),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Image(
                                            painter = painterResource(R.drawable.img_6),
                                            contentDescription = "Home",
                                            modifier = Modifier.size(500.dp)

                                        )
                                    }
                                }

                                //End of Card1
                                Spacer(modifier = Modifier.width(20.dp))



                                //Card2
                                Card (
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(200.dp)
                                        .clickable{navController.navigate(ROUT_HOME)}
                                ){
                                    Column (
                                        modifier = Modifier.fillMaxSize().background(newOrange),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Image(
                                            painter = painterResource(R.drawable.img_7),
                                            contentDescription = "Home",
                                            modifier = Modifier.size(100.dp)

                                        )
                                    }
                                }

                                //End of Card2

                                Spacer(modifier = Modifier.width(20.dp))

                                //Card3
                                Card (
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(200.dp)
                                        .clickable{navController.navigate(ROUT_HOME)}
                                ){
                                    Column (
                                        modifier = Modifier.fillMaxSize().background(color = Color.Magenta),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Image(
                                            painter = painterResource(R.drawable.img_2),
                                            contentDescription = "Home",
                                            modifier = Modifier.size(100.dp)

                                        )
                                    }
                                }

                                //End of Card3

                                Spacer(modifier = Modifier.width(20.dp))

                                //Card4
                                Card (
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(200.dp)
                                        .clickable{navController.navigate(ROUT_HOME)}
                                ){
                                    Column (
                                        modifier = Modifier.fillMaxSize().background(color = Color.Blue),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Image(
                                            painter = painterResource(R.drawable.background),
                                            contentDescription = "Home",
                                            modifier = Modifier.size(500.dp)

                                        )
                                    }
                                }

                                //End of Card4

                                Spacer(modifier = Modifier.width(20.dp))

                                //Card5
                                Card (
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(200.dp)
                                        .clickable{navController.navigate(ROUT_HOME)}
                                ){
                                    Column (
                                        modifier = Modifier.fillMaxSize().background(Color.Blue),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Image(
                                            painter = painterResource(R.drawable.img_5),
                                            contentDescription = "Home",
                                            modifier = Modifier.size(500.dp)

                                        )
                                    }
                                }

                                //End of Card5

                            }
                            //End of Row1


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                    }
                    //End of Card

                    Spacer(modifier = Modifier.height(30.dp))


                }
                //End of Box



                Column(modifier = Modifier.fillMaxSize()) {

                    val mContext = LocalContext.current

                    Text(
                        text = "Personal Task",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = FontFamily.Cursive

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            navController.navigate(ROUT_START)
                        },
                        colors = ButtonDefaults.buttonColors(newOrange),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),

                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "oji1",
                            modifier = Modifier.size(30.dp)

                        )

                        Text(text = "NDA Review for  Project"
                        )
                        Text(text = " Today-10pm")

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            navController.navigate(ROUT_START)
                        },
                        colors = ButtonDefaults.buttonColors(newOrange),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_2),
                            contentDescription = "oji1",
                            modifier = Modifier.size(30.dp)

                        )

                        Text(text = "Email Reply for Green Project"
                        )
                        Text(text = " Today-10pm")


                    }


                }

                Spacer(modifier = Modifier.height(20.dp))
























            }

        }
    )

    //End of scaffold




    }

@Preview(showBackground = true)
@Composable
fun AssignmentScreenPreview(){

    AssignmentScreen(rememberNavController())

}
