package br.senai.sp.jandira.mytrips_signup_login_home.dao

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips_signup_login_home.model.Usuario

@Dao
interface UsuarioDao {

    //uma funçao que recebe as informaçoes de Contato como contato
    //E retorna um Long ( que seria o Id criado)

    @Insert
    fun salvar(usuario: Usuario): Long


    @Query("SELECT * FROM tbl_usuarios ORDER BY nome ASC")
    fun listarTodosOsUsuarios(): List<Usuario>

    @Query("SELECT * FROM tbl_usuarios WHERE id = :id")
    fun buscarContatoPeloId(id: Long): Usuario

    @Query("SELECT * FROM tbl_usuarios WHERE email = :email AND senha = :senha")
    fun buscarUsuarioPeloEmailSenha(email: String, senha: String): Usuario?

//    @Delete
//    fun deletarContatoPeloId(id: Long)
}