package br.senai.sp.jandira.mytrips_signup_login_home.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips_signup_login_home.ui.theme.MyTripsSignUp_Login_HomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(controleDeNavegacao: NavHostController) {

    var usuarioState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var mensagemErrorState = remember {
        mutableStateOf("")
    }

    MyTripsSignUp_Login_HomeTheme{
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ){
            Column (
                Modifier.fillMaxSize()
            ){
                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()

                ){
                    Box (
                        Modifier
                            .width(150.dp)
                            .background(
                                Color(0xffcf08ef),
                                shape = RoundedCornerShape(bottomStart = 10.dp)
                            )
                            .height(50.dp)
                    ){

                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
                Column (
                    modifier = Modifier.padding(10.dp)
                ){
                    Column {
                        Text(
                            text = "Login",
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffcf08ef)
                        )
                        Text(
                            text = "Please sign in to continue",
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        OutlinedTextField(
                            value = usuarioState.value,
                            onValueChange = {
                                usuarioState.value = it
                            },
                            isError = isErrorState.value,
                            modifier = Modifier.width(400.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color(0xffcf08ef),
                                focusedBorderColor = Color(0xffcf08ef)
                            ),
                            shape = RoundedCornerShape(15.dp),
                            label = {
                                Text(text = "E-mail")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Email,
                                    contentDescription = "",
                                    tint = Color(0xffcf08ef)
                                )
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = senhaState.value,
                            onValueChange = {
                                senhaState.value = it
                            },
                            isError = isErrorState.value,
                            modifier = Modifier.width(400.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color(0xffcf08ef),
                                focusedBorderColor = Color(0xffcf08ef)
                            ),
                            shape = RoundedCornerShape(15.dp),
                            label = {
                                Text(text = "Password")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Lock,
                                    contentDescription = "",
                                    tint = Color(0xffcf08ef)
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Column (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ){
                        Button(
                            onClick = {
                                      if(usuarioState.value == "aluno" && senhaState.value == "1234"){
                                          controleDeNavegacao.navigate("home")
                                      } else {
                                          isErrorState.value = true
                                          mensagemErrorState.value = "Usuário ou senha inválidos!"
                                      }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffcf08ef)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .height(60.dp)
                                .width(160.dp)
                        ){
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                            ){
                                Text(
                                    text = "SIGN IN",
                                    fontSize = 22.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(
                                    imageVector = Icons.Filled.ArrowForward,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                        }
                        Text(
                            text = mensagemErrorState.value,
                            color = Color.Red
                        )
                        Spacer(modifier = Modifier.height(0.dp))
                        Row {
                            Text(
                                text = "Don't have an account?",
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Sign up",
                                color = Color(0xffcf08ef),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.clickable {
                                    controleDeNavegacao.navigate("SignUp")
                                }
                            )
                        }
                    }
                }
                Row (
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    Box (
                        Modifier
                            .width(150.dp)
                            .background(
                                Color(0xffcf08ef),
                                shape = RoundedCornerShape(topEnd = 10.dp)
                            )
                            .height(50.dp)
                    ){

                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TelaLoginPreview(){
    MyTripsSignUp_Login_HomeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF03A9f4)
        ) {
//            TelaLogin()
        }
    }
}
