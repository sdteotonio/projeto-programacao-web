<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" data-aos="fade-right" data-aos-delay="500" id="form-usu">
<form class="box-app">
    <div class="form-group">
        <h4 class="text-left">Tipo de aluno:</h4>
        <select class="form-control">
            <option value="">Graduação</option>
            <option value="">Mestrado</option>
            <option value="">Doutorado</option>
            <option value="">Especialização</option>
        </select>
    </div>
    <div class="form-group">
        <h4 class="text-left">Matrícula:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Nome da mãe:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <hr>
    <hr>
    <div class="form-group">
        <h4 class="text-left">Usuário:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <hr>
    <div class="form-group">
        <h4 class="text-left">CPF:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="11" minlength="11" autofocus="">
    </div>
    <div class="form-group">
        <h4 class="text-left">Nome:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Senha:</h4>
        <input class="form-control" type="password">
    </div>
    <div class="form-group">
        <h4 class="text-left">Data de nascimento:</h4>
        <input class="form-control form-control" type="text" required="" placeholder="##/##/###"
            maxlength="10" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Endereço:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="100" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">Telefone celular:</h4>
        <input class="form-control form-control" type="text" required="" placeholder="(###) # ####-####"
            maxlength="15" minlength="14">
    </div>
    <div class="form-group">
        <h4 class="text-left">Naturalidade:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="50" minlength="10">
    </div>
    <div class="form-group">
        <h4 class="text-left">RG:</h4>
        <input class="form-control form-control" type="text" required="" maxlength="50" minlength="10">
    </div>
    <div class="form-row">
        <div class="col">
            <button class="btn btn-success btn-block" type="button">Inserir</button>
        </div>
        <div class="col">
            <button class="btn btn-primary btn-block" type="button">Atualizar</button>
        </div>
    </div>
</form>
</div>