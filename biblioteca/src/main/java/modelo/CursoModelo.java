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
		if (listaDeCursos.contains(curso)) {
			
		}
		return true ;
	}
		
	}
}
