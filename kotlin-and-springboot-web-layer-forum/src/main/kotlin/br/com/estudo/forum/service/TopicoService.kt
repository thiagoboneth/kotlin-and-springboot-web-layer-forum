package br.com.estudo.forum.service

import br.com.estudo.forum.dto.AtualizacaoTopicForm
import br.com.estudo.forum.dto.NovoTopicForm
import br.com.estudo.forum.mapper.TopicoFormMapper
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.exception.NotFoundException
import br.com.estudo.forum.mapper.TopicoViewMapper
import br.com.estudo.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
){
    private val notFoundMessage = "Topico não encontrado"

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->  topicoViewMapper.map(t)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        return topicoViewMapper.map(topicos.stream().filter { t -> t.id == id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)})
    }

    fun cadatrar(form: NovoTopicForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicForm): TopicoView {
        val topido = topicos.stream().filter { t -> t.id == form.id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = topido.curso,
            autor = topido.autor,
            status = topido.status,
            respostas = topido.respostas,
            dataCriacao = topido.dataCriacao
        )
        topicos = topicos.minus(topido).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t -> t.id == id }.findFirst().get()
        topicos = topicos.minus(topico)
    }

}