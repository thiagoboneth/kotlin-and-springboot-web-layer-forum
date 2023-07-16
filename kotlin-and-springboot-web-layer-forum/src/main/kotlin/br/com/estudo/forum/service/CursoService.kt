package br.com.estudo.forum.service

import br.com.estudo.forum.model.Curso
import br.com.estudo.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }


}