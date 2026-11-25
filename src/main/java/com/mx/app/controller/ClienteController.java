package com.mx.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.app.dto.ClienteRequestDTO;
import com.mx.app.dto.ClienteResponseDTO;
import com.mx.app.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin
@Validated
@Tag(name = "MS-CLIENTE", description = "Microservicio relacionado con operaciones de clientes")
public class ClienteController {

	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}

	// http://localhost:9000/api/cliente
	@GetMapping
	@Operation(summary = "Lista de Clientes", description = "Optiene todos los clientes de la base de datos")
	public ResponseEntity<List<ClienteResponseDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	// http://localhost:9000/api/cliente/
	@GetMapping("/{id}")
	@Operation(summary = "Busca un cliente por ID", description = "Optiene un cliente de la base de datos por id")
	public ResponseEntity<ClienteResponseDTO> buscarID(@PathVariable() Long id) {
		return ResponseEntity.ok(service.buscar(id));
	}

	// http://localhost:9000/api/cliente/buscarNombre/
	@GetMapping("buscarNombre/{nombre}")
	@Operation(summary = "Busca un cliente por ID", description = "Optiene un cliente de la base de datos por id")
	public ResponseEntity<ClienteResponseDTO> buscarNombre(@PathVariable() String nombre) {
		return ResponseEntity.ok(service.buscarNombre(nombre));
	}

	// http://localhost:9000/api/cliente/buscarCorreo/
	@GetMapping("buscarCorreo/{correo}")
	@Operation(summary = "Busca un cliente por ID", description = "Optiene un cliente de la base de datos por id")
	public ResponseEntity<ClienteResponseDTO> buscarCorreo(@PathVariable() String correo) {
		return ResponseEntity.ok(service.buscarCorreo(correo));
	}

	// http://localhost:9000/api/cliente
	@PostMapping
	@Operation(summary = "Guarda un nuevo cliente", description = "Permite almacenar un cliente de la base de datos")
	public ResponseEntity<ClienteResponseDTO> guardar(@Valid @RequestBody ClienteRequestDTO request) {
		ClienteResponseDTO clienteGuardar = service.guardar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteGuardar);
	}

	// http://localhost:9000/api/cliente/
	@PutMapping("/{id}")
	@Operation(summary = "Actualiza un cliente completo", description = "Permite actualizar un cliente de la base de datos")
	public ResponseEntity<ClienteResponseDTO> actualizar(@PathVariable() Long id,
			@Valid @RequestBody ClienteRequestDTO request) {
		ClienteResponseDTO clienteActualizar = service.actualizar(id, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteActualizar);
	}

	// http://localhost:9000/api/cliente/
	@DeleteMapping("/{id}")
	@Operation(summary = "Elimina un cliente completo", description = "Permite eliminar un cliente de la base de datos")
	public ResponseEntity<ClienteResponseDTO> eliminar(@PathVariable() Long id) {
		service.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
