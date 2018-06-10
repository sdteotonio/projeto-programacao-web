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
                        <%-- <c:forEach var="locAtual" items="${locacoes}">
                            <tr>
                                <td>${locAtual.getAluno().getNomecompleto()}</td>
                                <td>${locAtual.getItem().getNome()}</td>
                                <td>${locAtual.getDt_locacao()}</td>
                                <td>${locAtual.getDt_devolucao()}</td>
                                <td>${locAtual.Renovado()}</td>
                                <td class="d-inline float-left"><button onClick="editarLocacao('${locAtual.getCod_locacao()}')" class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             </c:forEach> --%>
                             <tr>
                                <td>Aluno Teste do Sistema</td>
                                <td>Item 2</td>
                                <td>20/05/2018</td>
                                <td>20/06/2018</td>
                                <td>Não</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             <tr>
                                <td>Arrumadim Do Site</td>
                                <td>Item 2</td>
                                <td>15/05/2018</td>
                                <td>16/06/2018</td>
                                <td>Não</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             <tr>
                                <td>Renata Ingrata</td>
                                <td>Item 5</td>
                                <td>10/06/2018</td>
                                <td>10/07/2018</td>
                                <td>Não</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                             <tr>
                                <td>Jorge Gorge Giorge</td>
                                <td>Item 45</td>
                                <td>05/05/2018</td>
                                <td>05/06/2018</td>
                                <td>Sim</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                        </tbody>
</table>