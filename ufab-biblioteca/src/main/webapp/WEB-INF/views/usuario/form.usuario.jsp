<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" data-aos="fade-right" data-aos-delay="500" id="form-side">
<form class="box-app" action="usuario/inserir" id="form-usuario">

    <%-- Formulario para aluno --%>
	<c:if test="${tipoForm == 'ALUNO'}">
  
    <div class="form-group">
        <h4 class="text-left">Matrícula:</h4>
        <input class="form-control form-control" value="${usuario.getMatricula()}"  name="matricula" disabled placeholder="Gerada automaticamente..." type="text" required="" maxlength="100" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Nome da mãe:</h4>
        <input name="nomeDaMae" value="${usuario.getNomeMae()}" class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
     <c:if test="${usuario.getCpf() == null}">
        <div class="form-group">
            <h4 class="text-left">Tipo de aluno:</h4>
            <select name="tipoAluno" class="form-control">
                <c:forEach var="nivelAluno" items="${selectNivelAluno}">
                    <option value="${nivelAluno.name()}">
                        <c:out value="${nivelAluno.name()}" />
                    </option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group">
        <h4 class="text-left">Ano:</h4>
        <input class="form-control form-control" name="ano" placeholder="Ano de entrada..." type="text" required="" maxlength="4" minlength="4">
    </div>
    <div class="form-group">
        <h4 class="text-left">Período:</h4>
          <select class="form-control" required name="periodo">
                <option value="1">
                    1
                </option>
                <option value="2">
                    2
                </option>
        </select>
    </div>
    <div class="form-group">      
     <h4 class="text-left">Curso do aluno:</h4>
        <select class="form-control" required name="cursoAluno">
                <c:if test="${usuario.getCpf() == null}">
                    <option value="" selected>Selecione</option>
                </c:if>
                <c:forEach var="curso" items="${cursoAluno}">
                <option value="${curso.getCod()}">
                    <c:out value="${curso.getNome()}" />
                </option>
                </c:forEach>
        </select>
    </div>
    </c:if>
    <hr>
	</c:if>

    <%-- Form para Funcionario --%>
    <c:if test="${tipoForm == 'FUNCIONARIO'}">
    <div class="form-group">
        <h4 class="text-left">Usuário:</h4>
        <input name="usuario" value="${usuario.getNomeUsuario()}"  class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <hr>
    </c:if>

    <%-- Form para todos --%>
    <div class="form-group">
        <h4 class="text-left">CPF:</h4>
        <input class="form-control form-control" value="${usuario.getCpf()}" name="cpf" type="text" required="" maxlength="11" minlength="11" autofocus="">
    </div>
    <div class="form-group">
        <h4 class="text-left">Nome:</h4>
        <input class="form-control form-control" value="${usuario.getNomeCompleto()}"  name="nome" type="text" required="" maxlength="100" minlength="10">
    </div>
    <c:if test="${usuario.getCpf() == null}">
        <div class="form-group">
            <h4 class="text-left">Senha:</h4>
            <input class="form-control"  name="senha" type="password">
        </div>
    </c:if>
    <div class="form-group">
        <h4 class="text-left">Data de nascimento:</h4>
        <input class="form-control form-control" value="${usuario.getDataNascimento()}" name="dtNascimento" type="text" required="" placeholder="##/##/###"
            maxlength="10" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Endereço:</h4>
        <input class="form-control form-control"  value="${usuario.getEndereco()}" name="endereco" type="text" required="" maxlength="100" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Telefone celular:</h4>
        <input class="form-control form-control"  name="fone" value="${usuario.getFone()}" type="text" required="" placeholder="(###) # ####-####"
            maxlength="15" minlength="14">
    </div>
    <div class="form-group">
        <h4 class="text-left">Naturalidade:</h4>
        <input class="form-control form-control"  name="naturalidade" value="${usuario.getNaturalidade()}" type="text" required="" maxlength="50" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">RG:</h4>
        <input class="form-control form-control"  name="rg" value="${usuario.getRg()}" type="text" required="" maxlength="50" minlength="10">
    </div>
</form>
    <div class="form-row">
        <c:if test="${usuario.getCpf() == null}">
            <div class="col">
                <button class="btn btn-success btn-block" onClick="inserirUsuario('${tipoForm}')">Inserir</button>
            </div>        
        </c:if>
        <c:if test="${usuario.getCpf() != null}">
            <div class="col">
                <button class="btn btn-primary btn-block">Atualizar</button>
            </div>
        </c:if>
    </div>
</div>
