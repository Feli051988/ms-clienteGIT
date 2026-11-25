package com.mx.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.app.dto.ClienteRequestDTO;
import com.mx.app.dto.ClienteResponseDTO;
import com.mx.app.entity.Cliente;
import com.mx.app.mapper.ClienteMapper;
import com.mx.app.repository.ClienteRepository;



@Service
@Transactional
public class ClienteServiceImp implements ClienteService {

	private final ClienteRepository repo;
	private final ClienteMapper mapper;

	public ClienteServiceImp(ClienteRepository repo, ClienteMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public ClienteResponseDTO guardar(ClienteRequestDTO request) {
		// TODO Auto-generated method stub
		Cliente cliente = mapper.toEntity(request);
		int edadActual = Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();
		System.out.println("Edad Actual: " + edadActual);
		cliente.setEdad(edadActual);
		cliente.setFechaHoraRegistro(LocalDateTime.now());
		Cliente clienteGuardar = repo.save(cliente);
		return mapper.toResponse(clienteGuardar);
	}

	@Override
	public ClienteResponseDTO actualizar(Long id, ClienteRequestDTO request) {
		Cliente cliente = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente no encotrado con el id: " + id));

		cliente.setNombre(request.getNombre());
		cliente.setApp(request.getApp());
		cliente.setApm(request.getApm());
		cliente.setFechaNacimiento(request.getFechaNacimiento());

		int edadActual = Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();
		System.out.println("Edad Actual: " + edadActual);
		cliente.setEdad(edadActual);

		cliente.setSexo(request.getSexo());
		cliente.setCorreo(request.getCorreo());

		//cliente.setFechaHoraRegistro(LocalDateTime.now());

		Cliente clienteActualizar = repo.save(cliente);

		return mapper.toResponse(clienteActualizar);
	}

	@Override
	public void eliminar(Long id) {
		if (!repo.existsById(id)) {
			throw new RuntimeException("No exite el cliente con id " + id);

		}

		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResponseDTO buscar(Long id) {
		Cliente cliente = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente no encotrado con el id: " + id));
		return mapper.toResponse(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResponseDTO buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		
		Cliente cliente = repo.buscarNombre(nombre);
		return mapper.toResponse(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResponseDTO buscarCorreo(String correo) {
		Cliente cliente = repo.findByCorreo(correo);
		return mapper.toResponse(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClienteResponseDTO> listar() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper :: toResponse ).toList();
	}

}
