<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" id="form-side" data-aos="fade-right" data-aos-delay="500">
    <form class="box-app" action="curso/inserir" id="form-curso">
        <div class="form-group">
            <h4 class="text-left">Curso:</h4>
            <input class="form-control form-control" name="nomeCurso" value="${curso.getNome()}" type="text" required maxlength="100" minlength="10" autofocus="">
        </div>
        <div class="form-group">
            <h4 class="text-left">Tag:</h4>
            <input class="form-control form-control" name="tagCurso" value="${curso.getTag()}" type="text" required maxlength="2" minlength="2" autofocus="">
        </div>
        <div class="form-group">
        <h4 class="text-left">Área:</h4>
           <select class="form-control" name="areaCurso" required> 
                <c:if test="${curso.getNome() == null}">
                    <option value="" selected>Selecione</option>
                </c:if>
                <option value="EXATAS"  <c:out value="${curso.getArea() == 'EXATAS' ? 'selected' : ''}"/>>Exatas</option>
                <option value="SAUDE"  <c:out value="${curso.getArea() == 'SAUDE' ? 'selected' : ''}"/>>Saúde</option>
                <option value="HUMANAS"  <c:out value="${curso.getArea() == 'HUMANAS' ? 'selected' : ''}"/>>Humanas</option>
            </select>
        </div>
        <div class="form-group">
            <h4 class="text-left">Tipo de Curso:</h4>
            <select class="form-control" name="tipoCurso" required>
                <c:if test="${curso.getNome() == null}">
                    <option value="" selected>Selecione</option>
                </c:if>
                <c:forEach var="tipoCursoAtual" items="${tipoCursoLista}">
                        <option <c:out value="${curso.getTipoCurso().getNome() == tipoCursoAtual.getNome() ? 'selected' : ''}"/> value="${tipoCursoAtual.getCod()}">
                            <c:out value="${tipoCursoAtual.getNome()}" />
                        </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-row">
            <c:if test="${curso.getNome() == null}">
                <div class="col">
                    <button class="btn btn-success btn-block" onClick="inserirCurso()" type="button">Inserir</button>
                </div>
            </c:if>
            <c:if test="${curso.getNome() != null}">
                <div class="col">
                    <button class="btn btn-primary btn-block" onClick="atualizarCurso('${curso.getCod()}')"  type="button">Atualizar</button>
                </div>
            </c:if>
        </div>
    </form>
</div>