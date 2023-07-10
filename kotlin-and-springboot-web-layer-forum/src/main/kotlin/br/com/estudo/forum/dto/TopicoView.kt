package br.com.estudo.forum.dto

import br.com.estudo.forum.model.StatusTopico
import java.time.LocalDate

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDate
)
