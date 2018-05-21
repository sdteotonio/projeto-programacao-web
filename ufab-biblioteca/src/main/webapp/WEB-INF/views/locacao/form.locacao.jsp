<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" data-aos="fade-right" data-aos-delay="500" id="form-side">
<form class="box-app" action="usuario" id="form-usuario">

 
    <%-- Form para todos --%>
     <div class="form-group">
    
        <h4 class="text-left">Item:</h4>
        <select name="item" class="form-control">
            <c:forEach var="item" items="${selectItem}">
                     <option 
                     onClick="formPerso('${item.getItem().name()}');">
                    </option>
             </c:forEach>
        </select>
    </div>
    <div class="form-group">
    
        <h4 class="text-left">Aluno:</h4>
         <select name="aluno" class="form-control">
            <c:forEach var="aluno" alunos="${SelectAluno}">
                     <option 
                     	onClick="formPerso('${aluno.getAluno().name()}');">
                    </option>
             </c:forEach>
        </select>
    </div>
 
</form>
    <div class="form-row">
        <div class="col">
            <button class="btn btn-success btn-block" onClick="locar(${tipoForm})">Locar</button>
        </div>
        <div class="col">
            <button class="btn btn-primary btn-block">Atualizar</button>
        </div>
    </div>
</div>
