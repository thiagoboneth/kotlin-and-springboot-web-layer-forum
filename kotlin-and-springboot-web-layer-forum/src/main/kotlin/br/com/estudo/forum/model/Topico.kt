package br.com.estudo.forum.model

import java.time.LocalDate

data class Topico (
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDate = LocalDate.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)