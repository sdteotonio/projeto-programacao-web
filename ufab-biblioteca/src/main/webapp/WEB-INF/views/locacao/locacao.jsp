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
                <h1>Empréstimos -&nbsp;<i class="fa fa-handshake-o icon"></i></h1>
            </div>
        </div>
        <hr>
        
        <div class="container-fluid d-flex justify-content-center container-form">
            <div id="form-side"></div>
            <div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 box-overlay-app" data-aos="fade-down" data-aos-delay="250">
                <div class="table-responsive"  id="table-side">
                    
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>
    <script>
        $( document ).ready(function() {
            window.scrollTo(0,0);
            atualizarTabela();
        });
        
        function formPerso(tipo) {
            $.get( "locacao/form?tipoForm="+tipo, function( data ) {
               $("#form-side").replaceWith( data );
           });
       }


        function editarLocacao(cod_locacao) {
            console.log("Editar Locacao",cod_locacao);
            
        }

        function atualizarTabela() {
             $.get( "locacao/tabela", function( data ) {
                $("#table-side").html( data );
            });
        }
        
        function devolver(cod_locacao) {
            $.get( "locacao/devolver?cod="+cod_locacao, function( data ) {
          	atualizarTabela();
           });
       }

        function locar(tipoForm){
            var form = $("#form-locacao");
            var dados = $("#form-locacao").serialize();
            console.log(form.action);
            
            $.ajax({
                url: "locacao?tipoForm="+tipoForm,
                method: "POST",
                data: dados 
            }).done(function(retorno){
            
                form.trigger("reset");
            }).fail(function(retorno){
            
            });  
        }

    </script>

</html>