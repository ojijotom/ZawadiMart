package com.ojijo.zawadimart.ui.screens.form

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojijo.zawadimart.R
import com.ojijo.zawadimart.navigation.ROUT_DASHBOARD
import com.ojijo.zawadimart.ui.theme.newOrange


@Composable
fun FormScreen(navController: NavController){

    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_10),
            contentDescription = "",
            modifier = Modifier.size(100.dp),


            )

        Spacer(modifier = Modifier.height(20.dp))
        Text(

            text = "CREATE AN ACCOUNT",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        //Variables

        var fullname by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }


        //Fullname

        OutlinedTextField(
            value =fullname,
            onValueChange = {fullname = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = newOrange) },
            label = { Text("Fullname") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newOrange,
                focusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)


        )


        //End of

        Spacer(modifier = Modifier.height(20.dp))


        //Username

        OutlinedTextField(
            value =username,
            onValueChange = {username = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = "", tint = newOrange) },
            label = { Text("Username") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newOrange,
                focusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)


        )


        //End of Username

        Spacer(modifier = Modifier.height(20.dp))




        //Email

        OutlinedTextField(
            value =email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = newOrange) },
            label = { Text("Email") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newOrange,
                focusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)


        )

        //End of Email

        Spacer(modifier = Modifier.height(20.dp))

        //Password

        OutlinedTextField(
            value =password,
            onValueChange = {password = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = newOrange) },
            label = { Text("Password") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newOrange,
                focusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()


        )
        //End of Password

        Spacer(modifier = Modifier.height(20.dp))


        //Password

        OutlinedTextField(
            value =confirmpassword,
            onValueChange = {confirmpassword = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = newOrange) },
            label = { Text("ConfirmPassword") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = newOrange,
                focusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()


        )


        //End of Fullname

        Spacer(modifier = Modifier.height(20.dp))




        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(newOrange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Register")
        }















    }


}
@Preview(showBackground = true)
@Composable
fun FormScreenPreview(){

    FormScreen(rememberNavController())

}