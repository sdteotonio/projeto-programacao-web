package modelo;

import java.util.ArrayList;

import entidade.Curso;

public class CursoModelo {
	private ArrayList<Curso> listaDeCursos;

	public CursoModelo() {
		this.listaDeCursos = new ArrayList<Curso>();
	}

	public void inserirCurso(Curso curso) {

	}

	public boolean atualizarCurso(Curso curso) {
		// TODO: Atulizar os dados de um curso
		if (listaDeCursos.contains(curso)) {
			
		}
		return true ;
	}
	
	private void validarCurso(Curso curso) {
		
	}
}
