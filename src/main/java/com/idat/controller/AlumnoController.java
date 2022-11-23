package com.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.dto.AlumnoDto;
import com.idat.servicio.AlumnoServicio;

@Controller
@RequestMapping("/api/alumno/v1")
public class AlumnoController {

	@Autowired
	private AlumnoServicio servicio;

	@GetMapping("/hola")
	public @ResponseBody String hola() {
		return "api de prueba HOLA";
	}

	@GetMapping("/listar")
	public @ResponseBody List<AlumnoDto> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody AlumnoDto obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody AlumnoDto dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody AlumnoDto dto) {
		servicio.actualizar(dto);
	}

	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
