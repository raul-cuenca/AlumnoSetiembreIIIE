package com.idat.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.dto.AlumnoDto;
import com.idat.model.Alumno;
import com.idat.repositorio.AlumnoRepositorio;

@Service
public class AlumnoServicioImpl implements AlumnoServicio {

	@Autowired
	private AlumnoRepositorio repositorio;

	@Override
	public List<AlumnoDto> listar() {

		List<AlumnoDto> listadto = new ArrayList<>();
		AlumnoDto dto = null;

		for (Alumno alumno : repositorio.findAll()) {
			dto = new AlumnoDto();
			dto.setApe(alumno.getApellido());
			dto.setNom(alumno.getNombre());
			dto.setCod(alumno.getIdAlumno());
			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public AlumnoDto obtenerId(Integer id) {

		Alumno alumno = repositorio.findById(id).orElse(null);
		AlumnoDto dto = new AlumnoDto();
		dto.setApe(alumno.getApellido());
		dto.setNom(alumno.getNombre());
		dto.setCod(alumno.getIdAlumno());

		return dto;
	}

	@Override
	public void guardar(AlumnoDto a) {

		Alumno alu = new Alumno();
		alu.setApellido(a.getApe());
		alu.setNombre(a.getNom());
		alu.setIdAlumno(a.getCod());

		repositorio.save(alu);
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public void actualizar(AlumnoDto a) {
		Alumno alu = new Alumno();
		alu.setApellido(a.getApe());
		alu.setNombre(a.getNom());
		alu.setIdAlumno(a.getCod());

		repositorio.saveAndFlush(alu);
	}

}
