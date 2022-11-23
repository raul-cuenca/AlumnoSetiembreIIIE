package com.idat.servicio;

import java.util.List;

import com.idat.dto.AlumnoDto;

public interface AlumnoServicio {

	List<AlumnoDto> listar();

	AlumnoDto obtenerId(Integer id);

	void guardar(AlumnoDto a);

	void eliminar(Integer id);

	void actualizar(AlumnoDto a);

}
