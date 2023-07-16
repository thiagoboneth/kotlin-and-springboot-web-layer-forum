package br.com.estudo.forum.service

import br.com.estudo.forum.model.Usuario
import br.com.estudo.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }


}

