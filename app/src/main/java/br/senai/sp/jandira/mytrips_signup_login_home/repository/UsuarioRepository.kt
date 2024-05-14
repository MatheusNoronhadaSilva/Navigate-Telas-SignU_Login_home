package br.senai.sp.jandira.mytrips_signup_login_home.repository

import android.content.Context
import br.senai.sp.jandira.mytrips_signup_login_home.dao.UsuarioDb
import br.senai.sp.jandira.mytrips_signup_login_home.model.Usuario

class UsuarioRepository(context: Context) {

    private val db = UsuarioDb.getBancoDeDados(context).usuarioDao()

    fun salvar(usuario: Usuario): Long{
        return  db.salvar(usuario)
    }

//    fun deletarContatoPeloId(id: Long){
//        return db.deletarContatoPeloId(id)
//    }

    fun buscarTodosOsUsuarios(): List<Usuario>{
        return db.listarTodosOsUsuarios()
    }

    fun buscarUsuarioPeloEmailSenha(email:String, senha:String): Pair<Boolean, Usuario?> {
        val usuario = db.buscarUsuarioPeloEmailSenha(email, senha)
        return Pair(usuario != null, usuario)
    }

    fun buscarContatoPeloId(id: Long): Usuario {
        return db.buscarContatoPeloId(id)
    }
}