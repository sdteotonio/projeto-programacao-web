<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-hover table-sm">
    <thead>
        <tr>
            <th>Curso</th>
            <th>TAG</th>
            <th>Tipo</th>
            <th>Área</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody class="justify-content-center align-items-center align-content-center">
        <c:forEach var="cursoAtual" items="${listaCursos}">
            <tr>
                <td>${cursoAtual.getNome()}</td>
                <td>${cursoAtual.getTag()}</td>
                <td>${cursoAtual.getTipoCurso().getNome()}</td>
                <td>${cursoAtual.getArea()}</td>
                
                                <td class="d-inline float-left">
                                    <button onClick="editarCurso('${cursoAtual.getCod()}')" class="btn btn-light btn-table" type="button">
                                    <i class="fa fa-edit"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>