package br.com.estudo.forum.service

import br.com.estudo.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService (var usuarios: List<Usuario>){

    init {
        val usuario = Usuario(
            id = 1,
            nome = "João",
            email = ""
        )
        val usuario2 = Usuario(
            id = 2,
            nome = "Maria",
            email = ""
        )
        val usuario3 = Usuario(
            id = 3,
            nome = "Pedro",
            email = ""
        )
        usuarios = listOf(usuario, usuario2, usuario3)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { u -> u.id == id }.findFirst().get()
    }

}


