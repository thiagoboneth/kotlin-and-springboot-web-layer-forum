package br.com.estudo.forum.controller

import br.com.estudo.forum.dto.AtualizacaoTopicForm
import br.com.estudo.forum.dto.NovoTopicForm
import br.com.estudo.forum.dto.TopicoView
import br.com.estudo.forum.service.TopicoService
import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/topicos/")
class TopicoController (private val service: TopicoService){

    @GetMapping("/listar")
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView{
        return service.buscarPorId(id)
    }

    @PostMapping("/cadastrar")
    fun cadastrar(
            @RequestBody @Valid form: NovoTopicForm,
            uriBuilder: UriComponentsBuilder
        ): ResponseEntity<TopicoView> {
            val topicoView = service.cadatrar(form)
            val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
            return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicForm):ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}