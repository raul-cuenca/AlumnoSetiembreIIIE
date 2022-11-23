package com.idat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.model.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {

}
