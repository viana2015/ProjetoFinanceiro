package com.jrcg.jrmoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrcg.jrmoney.api.event.RecursoCriadoEvent;
import com.jrcg.jrmoney.api.model.Categoria;
import com.jrcg.jrmoney.api.repository.CategoriaRepository;

// Seria o recurso de categoria.
// como um controlador que recebe requisições
// para saber como encontrar este recurso usaremos a anotações  

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// Publicador de eventos de aplicação
		@Autowired
		private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar (@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriSalva);

		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPeloId(@PathVariable Long id ) {
		Optional categoria = this.categoriaRepository.findById(id);
		return categoria.isPresent() ?
				ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
		
	}
	
}
