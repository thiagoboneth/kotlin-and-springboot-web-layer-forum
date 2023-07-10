package br.com.estudo.forum.model

import java.time.LocalDate

data class Resposta (
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDate = LocalDate.now(),
    val topico: Topico,
    val autor: Usuario,
    val solucao: Boolean = false
)
