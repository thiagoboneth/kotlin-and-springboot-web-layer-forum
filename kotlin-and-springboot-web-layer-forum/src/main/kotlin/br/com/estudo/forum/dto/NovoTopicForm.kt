package br.com.estudo.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NovoTopicForm (
    @field:NotEmpty(message = "Título não pode ser vazio.")
    @Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres.")
    val titulo: String,

    @field:NotEmpty(message = "Mensagem não pode ser vazia.")
    @Size(min = 5, max = 500, message = "Mensagem deve ter entre 5 e 500 caracteres.")
    val mensagem : String,

    @field:NotNull
    val idCurso: Long,

    @field:NotNull
    val idAutor: Long
)
