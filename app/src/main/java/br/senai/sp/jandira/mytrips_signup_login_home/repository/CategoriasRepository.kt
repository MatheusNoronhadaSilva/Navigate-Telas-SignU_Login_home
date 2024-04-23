package br.senai.sp.jandira.mytrips_signup_login_home.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips_signup_login_home.R
import br.senai.sp.jandira.mytrips_signup_login_home.model.Categorias
import br.senai.sp.jandira.mytrips_signup_login_home.model.Viagem
import java.time.LocalDate

class CategoriasRepository {

    @Composable
    fun listarTodasAsCategorias():List<Categorias>{

        //Viagem v = new Viagem()
        val CategoriaMontain = Categorias()
        CategoriaMontain.id = 1
        CategoriaMontain.titulo = "Montain"
        CategoriaMontain.imagem = painterResource(id = R.drawable.montanha)

        val CategoriaSnow = Categorias()
        CategoriaSnow.id = 2
        CategoriaSnow.titulo = "Snow"
        CategoriaSnow.imagem = painterResource(id = R.drawable.snow)

        val CategoriaBeach = Categorias()
        CategoriaBeach.id = 3
        CategoriaBeach.titulo = "beach"
        CategoriaBeach.imagem = painterResource(id = R.drawable.praia)

        val CategoriaMontain2 = Categorias()
        CategoriaMontain2.id = 4
        CategoriaMontain2.titulo = "Montain"
        CategoriaMontain2.imagem = painterResource(id = R.drawable.montanha)

        val categorias = listOf(
            CategoriaMontain,
            CategoriaSnow,
            CategoriaBeach,
            CategoriaMontain2
        )

        return categorias
    }
}