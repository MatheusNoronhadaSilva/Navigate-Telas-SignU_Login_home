package br.senai.sp.jandira.mytrips_signup_login_home.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips_signup_login_home.R
import br.senai.sp.jandira.mytrips_signup_login_home.model.Viagem
import java.time.LocalDate

class ViagemRepository {

    @Composable
    fun listarTodasAsViagens():List<Viagem>{

        //Viagem v = new Viagem()
        val viagemLondres = Viagem()
        viagemLondres.id = 1
        viagemLondres.destino = "London"
        viagemLondres.descricao = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        viagemLondres.dataChegada = LocalDate.of(2019,2,18)
        viagemLondres.dataPartida = LocalDate.of(2019,2,21)
        viagemLondres.imagem = painterResource(R.drawable.london)

        val viagemPorto = Viagem()
        viagemPorto.id = 2
        viagemPorto.destino = "Porto"
        viagemPorto.descricao = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas."
        viagemPorto.dataChegada = LocalDate.of(2022,7,18)
        viagemPorto.dataPartida = LocalDate.of(2022,7,25)
        viagemPorto.imagem = null

        val viagens = listOf(
            viagemLondres,
            viagemPorto
        )

        return viagens
    }
}