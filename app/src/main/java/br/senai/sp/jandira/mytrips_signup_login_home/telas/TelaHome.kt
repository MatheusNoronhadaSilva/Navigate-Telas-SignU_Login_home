package br.senai.sp.jandira.mytrips_signup_login_home.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips_signup_login_home.R
import br.senai.sp.jandira.mytrips_signup_login_home.repository.CategoriasRepository
import br.senai.sp.jandira.mytrips_signup_login_home.repository.ViagemRepository
import br.senai.sp.jandira.mytrips_signup_login_home.simplificarData
import br.senai.sp.jandira.mytrips_signup_login_home.ui.theme.MyTripsSignUp_Login_HomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(controleDeNavegacao: NavHostController?) {

    val viagens = ViagemRepository().listarTodasAsViagens()
    val categorias = CategoriasRepository().listarTodasAsCategorias()
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Box (
            modifier = Modifier
                .background(Color.Gray)
                .height(220.dp)
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.paris),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Column (
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.fillMaxHeight()
                ){
                    Column {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier
                                    .height(17.dp)
                                    .width(17.dp)
                            )
                            Text(
                                text = "You're in Paris",
                                fontSize = 12.sp,
                                color = Color.White,
                            )
                        }
                        Text(
                            text = "My Trips",
                            fontSize = 25.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Column (
                    horizontalAlignment = Alignment.End
                ){
                    Image(
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp),
                        painter = painterResource(id = R.drawable.perfi_foto),
                        contentDescription = ""
                    )
                    Text(
                        text = "Susanna Hoffs",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(Color(0xFFf6f6f6))
                .fillMaxSize()
                .padding(start = 18.dp)
        ){
            Text(text = "Categories")
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items(categorias){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color(0xffcf08ef), shape = RoundedCornerShape(10.dp))
                            .width(120.dp)
                            .height(70.dp)
                    ){
                        Image(
                            painter = if(it.imagem == null) painterResource(id = R.drawable.img_4) else it.imagem!!,
                            contentDescription = "",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                        )
                        Text(
                            text = it.titulo,
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column (
                modifier = Modifier
                    .padding(end = 18.dp)
                    .fillMaxSize()
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = "Search your destiny",
                            color = Color.Gray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent, // Cor da borda quando o campo está focado
                        unfocusedBorderColor = Color.Transparent, // Cor da borda quando o campo não está focado
                        disabledBorderColor = Color.Transparent // Cor da borda quando o campo está desativado
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Past Trips")
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn (
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    items(viagens){
                        Box (
                            modifier = Modifier
                                .shadow(8.dp, RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .height(220.dp)
                                .fillMaxWidth()
                        ){
                            Column (
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth()
                            ){
                                Card (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(117.dp)
                                ){
                                    Image(
                                        painter = if(it.imagem == null) painterResource(id = R.drawable.img_4) else it.imagem!!,
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                Text(
                                    text = "${it.destino}, ${it.dataChegada.year}",
                                    color = Color(0xffcf08ef)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "${it.descricao}",
                                    fontSize = 11.sp,
                                    lineHeight = 16.sp,
                                    color = Color.Gray
                                )
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(end = 8.dp)
                                ){
                                    Text(
                                        text = "${simplificarData(it.dataChegada)} - ${simplificarData(it.dataPartida)}",
                                        fontSize = 12.sp,
                                        color = Color(0xffcf08ef)
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaHomePreview() {
    MyTripsSignUp_Login_HomeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF03A9f4)
        ) {
            TelaHome(controleDeNavegacao = null)
        }
    }
}