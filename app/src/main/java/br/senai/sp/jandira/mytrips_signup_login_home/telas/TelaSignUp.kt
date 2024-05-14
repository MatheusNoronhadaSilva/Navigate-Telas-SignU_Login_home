package br.senai.sp.jandira.mytrips_signup_login_home.telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips_signup_login_home.R
import br.senai.sp.jandira.mytrips_signup_login_home.model.Usuario
import br.senai.sp.jandira.mytrips_signup_login_home.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips_signup_login_home.ui.theme.MyTripsSignUp_Login_HomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaSignUp(controleDeNavegacao:NavHostController) {

    var isChecked by remember { mutableStateOf(false) }

    val ur = UsuarioRepository(LocalContext.current)

    val nomeState = remember {
        mutableStateOf("")
    }

    val foneState = remember {
        mutableStateOf("")
    }

    val emailState = remember {
        mutableStateOf("")
    }

    val senhaState = remember {
        mutableStateOf("")
    }

    val over18State = remember {
        mutableStateOf(false)
    }

    var nomeError = remember {
        mutableStateOf(false)
    }

    MyTripsSignUp_Login_HomeTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
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
                Spacer(modifier = Modifier.height(20.dp))
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Sign up",
                        fontSize = 32.sp,
                        color = Color(0xffcf08ef),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Create a new account",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box (
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.foto),
                        contentDescription = "",
                        modifier = Modifier
                            .zIndex(2f)
                            .height(30.dp)
                            .width(30.dp)
                            .offset(x = 35.dp, y = 35.dp)
                    )
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color(0xfff6f6f6), shape = RoundedCornerShape(360.dp))
                            .border(
                                BorderStroke(
                                    1.dp,
                                    brush = Brush.horizontalGradient(
                                        0.0f to Color(0xffcf08ef),
                                        0.93f to Color(0xFFffffff),
                                        0.2f to Color.White,
                                        startX = 0.0f,
                                        endX = 300.0f
                                    )
                                ), shape = RoundedCornerShape(360.dp)
                            )
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "",
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        value = nomeState.value,
                        onValueChange = { nomeState.value = it},
                        label = {
                            Text(text = "Username")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Face,
                                contentDescription = "",
                                tint = Color(0xffcf08ef)
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xffcf08ef),
                            focusedBorderColor = Color(0xffcf08ef)
                        ),
                        modifier = Modifier
                            .width(400.dp)
                    )
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        value = foneState.value,
                        onValueChange = { foneState.value = it },
                        label = {
                            Text(text = "Phone")
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Filled.Call,
                                contentDescription = "",
                                tint = Color(0xffcf08ef)
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xffcf08ef),
                            focusedBorderColor = Color(0xffcf08ef)
                        ),
                        modifier = Modifier
                            .width(400.dp)
                    )
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        value = emailState.value,
                        onValueChange = { emailState.value = it},
                        label = {
                            Text(text = "E-mail")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "",
                                tint = Color(0xffcf08ef)
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xffcf08ef),
                            focusedBorderColor = Color(0xffcf08ef)
                        ),
                        modifier = Modifier
                            .width(400.dp)
                    )
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        value = senhaState.value,
                        onValueChange = { senhaState.value = it},
                        label = {
                            Text(text = "Password")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = "",
                                tint = Color(0xffcf08ef)
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xffcf08ef),
                            focusedBorderColor = Color(0xffcf08ef)
                        ),
                        modifier = Modifier
                            .width(400.dp)
                    )
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Checkbox(
                            checked = over18State.value,
                            onCheckedChange = { over18State.value = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xffcf08ef),
                                uncheckedColor = Color(0xffcf08ef)
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Over 18?")
                    }
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xffcf08ef), shape = RoundedCornerShape(15.dp))
                            .clickable {

                                val usuario = Usuario(
                                    nome = nomeState.value,
                                    email = emailState.value,
                                    telefone = foneState.value,
                                    senha = senhaState.value,
                                    isOver18 = over18State.value
                                )



                                if(nomeState.value == ""){
                                    nomeError.value == true
                                } else{
                                    ur.salvar(usuario = usuario)
                                    controleDeNavegacao.navigate("login")
                                }
                            }
                    ){
                        Text(
                            text = "CREATE ACCOUNT",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                controleDeNavegacao.navigate("login")
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        Text(
                            text = "Already have an account?",
                            color = Color.Gray
                        )
                        Text(
                            text = "Sign in",
                            color = Color(0xffcf08ef),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                controleDeNavegacao.navigate("login")
                            }
                        )
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
fun TelaSignUpPreview(){
    MyTripsSignUp_Login_HomeTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF03A9f4)
        ) {
//            TelaSignUp()
        }
    }
}