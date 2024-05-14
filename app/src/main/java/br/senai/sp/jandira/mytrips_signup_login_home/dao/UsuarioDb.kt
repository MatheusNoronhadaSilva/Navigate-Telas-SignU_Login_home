package br.senai.sp.jandira.mytrips_signup_login_home.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips_signup_login_home.model.Usuario

@Database(entities = [Usuario::class], version = 2)
abstract class UsuarioDb: RoomDatabase() {

    abstract fun usuarioDao() : UsuarioDao


    companion object {
        private lateinit var instancia: UsuarioDb

        fun getBancoDeDados(context: Context): UsuarioDb{
            instancia = Room
                .databaseBuilder(
                    context,
                    UsuarioDb::class.java,
                    "db_usuarios",
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia
        }
    }
}