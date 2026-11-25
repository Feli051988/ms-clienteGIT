package com.mx.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteRequestDTO {

	

	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(max = 50,message = "El nombre no puede superar los 50 racteres")
	private String nombre;
	
	@NotBlank(message = "El campo app no puede estar vacio")
	@Size(max = 50,message = "El app no puede superar los 50 racteres")
	private String app;
	
	@NotBlank(message = "El campo apm no puede estar vacio")
	@Size(max = 50,message = "El apm no puede superar los 50 racteres")
	private String apm;
	
	@NotNull(message = "LA fecha na nacimiento no pude ser vacio o nulo")
	@PastOrPresent(message = "Le fecha de nacimiento no pude ser futura")
	private LocalDate fechaNacimiento;
	
	@NotBlank(message = "El sexo no pude ser vacio")
	@Pattern(regexp = "M|F")
	private String sexo;
	
	@NotBlank(message = "El correo no pude ser vacio")
	@Email(message = "El correo debe tener un formato valido")
	private String correo;
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	
	
	
}
