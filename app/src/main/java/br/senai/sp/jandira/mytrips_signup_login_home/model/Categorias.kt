package br.senai.sp.jandira.mytrips_signup_login_home.model

import androidx.compose.ui.graphics.painter.Painter

data class Categorias(

    var id:Int = 0,
    var imagem: Painter? = null,
    var titulo:String = ""

)
