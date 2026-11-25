package com.mx.app.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.mx.app.dto.ClienteRequestDTO;
import com.mx.app.dto.ClienteResponseDTO;
import com.mx.app.entity.Cliente;

@Component
public class ClienteMapper {

	public Cliente toEntity(ClienteRequestDTO request) {

		Cliente cliente = new Cliente();

		cliente.setNombre(request.getNombre());
		cliente.setApp(request.getApp());
		cliente.setApm(request.getApm());
		cliente.setFechaNacimiento(request.getFechaNacimiento());
		cliente.setSexo(request.getSexo());
		cliente.setCorreo(request.getCorreo());

		/*
		 * private Long id; private String nombre; private String app; private String
		 * apm; private LocalDate fechaNacimiento; private Integer edad; private String
		 * sexo; private String correo; private LocalDateTime fechaHoraRegistro;
		 */
		return cliente;

	}

	public ClienteResponseDTO toResponse(Cliente cliente) {

		ClienteResponseDTO response = new ClienteResponseDTO();

		response.setId(cliente.getId());
		response.setNombre(cliente.getNombre());
		response.setApp(cliente.getApp());
		response.setApm(cliente.getApm());
		response.setFechaNacimiento(cliente.getFechaNacimiento());
		response.setEdad(cliente.getEdad());
		response.setSexo(cliente.getSexo());
		response.setCorreo(cliente.getCorreo());
		response.setFechaHoraRegistro(cliente.getFechaHoraRegistro());

		return response;

	}
}
