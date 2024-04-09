package br.senai.sp.jandira.mytrips_signup_login_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips_signup_login_home.telas.TelaHome
import br.senai.sp.jandira.mytrips_signup_login_home.telas.TelaLogin
import br.senai.sp.jandira.mytrips_signup_login_home.telas.TelaSignUp
import br.senai.sp.jandira.mytrips_signup_login_home.ui.theme.MyTripsSignUp_Login_HomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsSignUp_Login_HomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val controleDeNavegacao = rememberNavController()
                    NavHost(
                        navController = controleDeNavegacao,
                        startDestination = "login"
                    ) {
                        composable(route = "SignUp"){TelaSignUp(controleDeNavegacao)}
                        composable(route = "login"){ TelaLogin(controleDeNavegacao)}
                        composable(route = "home"){ TelaHome()}
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsSignUp_Login_HomeTheme {
        Greeting("Android")
    }
}