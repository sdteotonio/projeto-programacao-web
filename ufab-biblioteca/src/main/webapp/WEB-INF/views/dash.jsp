<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca UFAB</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <%-- NavBar --%>
    <div>
        <nav class="navbar navbar-dark navbar-expand-md navigation-clean" style="background-color:#7ab73d;color:rgb(255,255,255);">
            <div class="container"><a class="navbar-brand" href="#"><i class="fa fa-book"></i></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <p class="navbar-text">Biblioteca UFAB</p>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">${usuarioAuth.getNomeCompleto()} - ${usuarioAuth.getPerfil().getTipoPerfil().toString()}</a>
                            <div class="dropdown-menu justify-content-center align-content-center" role="menu">
                            <a class="dropdown-item text-capitalize justify-content-center align-items-center align-self-center" role="presentation" href="<c:url value='/logout'/>">Sair</a></div>
                        </li>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <%-- Fim NavBar --%>
    <div class="features-boxed">
        <div class="container">
            <div class="row justify-content-center features">
              <c:if test="${usuarioAuth.getPerfil().getTipoPerfil().toString()== 'ADMINISTRADOR'}"> 
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-users icon"></i>
                        <h3 class="name">Usuários</h3><a class="btn btn-success btn-block btn-dash" href="<c:url value='/usuario'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-list-alt icon"></i>
                        <h3 class="name">Cursos</h3><a class="btn btn-success btn-block btn-dash" href="<c:url value='/curso'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-handshake-o icon"></i>
                        <h3 class="name">Empréstimos</h3><a class="btn btn-success btn-block btn-dash" href= "<c:url value='/locacao'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-folder-open icon"></i>
                        <h3 class="name">Itens</h3><a class="btn btn-success btn-block btn-dash" href= "<c:url value='/item'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div>
                <%-- <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-sitemap icon"></i>
                        <h3 class="name">Alocação</h3><a class="btn btn-success btn-block btn-dash" href= "<c:url value='/emprestimo'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div> --%>
                
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-bar-chart-o icon"></i>
                        <h3 class="name">Relatórios</h3><a class="btn btn-success btn-block btn-dash" href= "<c:url value='/relatorio'/>"><i class="fa fa-cog"></i>&nbsp;Gerenciar</a></div>
                </div>
                </c:if>
                 <c:if test="${usuarioAuth.getPerfil().getTipoPerfil().toString() != 'ADMINISTRADOR'}"> 
                 <div class="container">
                <div class="jumbotron">
                    <h1>Biblioteca UFAB</h1>
                    <p>Desculpe, mas ainda não há opções para você :(</p>
                </div>
                </div>
                </c:if>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>