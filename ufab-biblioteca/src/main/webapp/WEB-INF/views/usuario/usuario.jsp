<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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
            <div class="container"><a class="navbar-brand" href="<c:url value='/dash'/>"><i class="fa fa-book"></i></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
    <div class="justify-content-center align-items-center align-content-center align-self-center" style="/*height:100vh;*/overflow-y:auto;">
        <div class="container-fluid d-flex justify-content-center container-form">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 d-inline-flex align-self-end box-app" data-aos="fade-down" data-aos-delay="250">
                <h1>Usuários -&nbsp;<i class="fa fa-users"></i></h1>
            </div>
        </div>
        <hr>
        
        <div class="container-fluid d-flex justify-content-center container-form">
            <div id="form-side"></div>
            <div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 box-overlay-app" data-aos="fade-down" data-aos-delay="250">
                <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4" style="margin-bottom: 2%;">
                     <h4 class="text-left">Adicionar usuário:</h4>
                    <select class="form-control" onchange="formPerso(this.value);">
                            <option value="" selected>
                            Selecione
                            </option>
                        <c:forEach var="tipoUsu" items="${selectTipoUsu}">
                            <option value="${tipoUsu.getTipoPerfil().name()}">
                                    <c:out value="${tipoUsu.getTipoPerfil().name()}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="table-responsive"  id="table-side">
                    
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>
    <script>
        $( document ).ready(function() {
            window.scrollTo(0,0);
            atualizarTabela();
        });
        function formPerso(tipoForm) {
            if(tipoForm != "" && tipoForm != null){
                $.get( "usuario/form?tipoForm="+tipoForm, function( data ) {
                    $("#form-side").replaceWith( data );
                });
            }
        }

        function editarUsuario(cpfUsu,tipoForm) {
            console.log("Editar Usuario",cpfUsu);
             $.get( "usuario/form?tipoForm="+tipoForm+"&cpfUsu="+cpfUsu, function( data ) {
                    $("#form-side").replaceWith( data );
                });
        }

        function atualizarTabela() {
             $.get( "usuario/tabela", function( data ) {
                $("#table-side").html( data );
            });
        }

        function inserirUsuario(tipoForm){
            var form = $("#form-usuario");
            var dados = $("#form-usuario").serialize(); 
            $.post( "usuario/inserir?tipoForm="+tipoForm, dados, function(){
                console.log("Teste");
                form.trigger("reset");
                atualizarTabela();
                alert( "Usuário inserido.");
            }
            ).fail(function() {
                alert( "Erro ao inserir usuário" );
            })
        }

    </script>

</html>