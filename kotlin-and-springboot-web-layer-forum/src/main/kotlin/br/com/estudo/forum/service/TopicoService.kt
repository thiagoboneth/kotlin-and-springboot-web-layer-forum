package br.com.estudo.forum.service

import br.com.estudo.forum.dto.AtualizacaoTopicForm
import br.com.estudo.forum.dto.NovoTopicForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.exception.NotFoundException
import br.com.estudo.forum.mapper.TopicoFormMapper
import br.com.estudo.forum.mapper.TopicoViewMapper
import br.com.estudo.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}