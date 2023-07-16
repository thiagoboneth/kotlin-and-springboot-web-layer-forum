package br.com.estudo.forum.mapper

import br.com.estudo.forum.dto.NovoTopicForm
import br.com.estudo.forum.model.Topico
import br.com.estudo.forum.service.CursoService
import br.com.estudo.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper (
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicForm, Topico> {
    override fun map(t: NovoTopicForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}