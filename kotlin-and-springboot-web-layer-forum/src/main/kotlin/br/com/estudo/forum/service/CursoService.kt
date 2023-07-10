package br.com.estudo.forum.service

import br.com.estudo.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        val curso2 = Curso(
            id = 2,
            nome = "Java",
            categoria = "Programação"
        )
        val curso3 = Curso(
            id = 3,
            nome = "C#",
            categoria = "Programação"
        )
        cursos = Arrays.asList(curso, curso2, curso3)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { c -> c.id == id }.findFirst().get()
    }


}
