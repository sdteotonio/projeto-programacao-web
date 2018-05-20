<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th>Aluno</th>
                                <th>Item</th>
                                <th>Dt.Empréstimo</th>
                                <th>Dt.Devolucao</th>
                                <th>Renovado</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody class="justify-content-center align-items-center align-content-center">
                        <c:forEach var="locAtual" items="${locacoes}">
                            <tr>
                                <td>${locAtual.getAluno().getNomecompleto()}</td>
                                <td>${locAtual.getItem().getNome()}</td>
                                <td>${locAtual.getDt_locacao()}</td>
                                <td>${locAtual.getDt_devolucao()}</td>
                                <td>${locAtual.Renovado()}</td>
                                <td class="d-inline float-left"><button onClick="editarLocacao('${locAtual.getCod_locacao()}')" class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             </c:forEach>
                        </tbody>
</table>