<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th>CPF</th>
                                <th>Nome</th>
                                <th>Papel</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody class="justify-content-center align-items-center align-content-center">
                        <c:forEach var="usuAtual" items="${usuarios}">
                            <tr>
                                <td>${usuAtual.getCpf()}</td>
                                <td>${usuAtual.getNomeCompleto()}</td>
                                <td>${usuAtual.getPerfil().getTipoPerfil().toString()}</td>
                                <td class="d-inline float-left"><button onClick="editarUsuario('${usuAtual.getCpf()}')" class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             </c:forEach>
                        </tbody>
</table>