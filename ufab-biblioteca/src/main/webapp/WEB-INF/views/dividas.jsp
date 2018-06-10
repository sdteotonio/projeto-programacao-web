<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <div>
        <nav class="navbar navbar-dark navbar-expand-md navigation-clean" style="background-color:#7ab73d;color:rgb(255,255,255);">
            <div class="container"><a class="navbar-brand" href="#"><i class="fa fa-book"></i></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <p class="navbar-text">Biblioteca UFAB</p>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Sérgio Davi - Administrador</a>
                            <div class="dropdown-menu justify-content-center align-content-center" role="menu"><a class="dropdown-item text-capitalize justify-content-center align-items-center align-self-center" role="presentation" href="#">Sair</a></div>
                        </li>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <div class="justify-content-center align-items-center align-content-center align-self-center" style="/*height:100vh;*/overflow-y:auto;">
        <div class="container-fluid d-flex justify-content-center container-form">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 offset-lg-0 d-inline-flex align-self-end box-app" data-aos="fade-down" data-aos-delay="250">
                <h1>Dívidas-&nbsp;<i class="fa fa-dollar"></i></h1>
            </div>
        </div>
        <div class="col-lg-4 offset-lg-2" style="width:983px;height:54px;">
            <div class="input-group">
                <div class="input-group-prepend"><span class="input-group-text" style="font-size:19px;margin:1px;padding:7px;height:39px;">Matrícula:</span></div><input class="form-control" type="text" style="height:38px;width:89px;margin:2px;">
                <div class="input-group-append"><button class="btn btn-primary" type="button"><i class="fa fa-search"></i></button></div>
            </div>
        </div>
        <hr>
        <div class="container-fluid d-flex justify-content-center container-form" style="height:501px;margin:9px;font-size:16px;">
            <div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 box-overlay-app" data-aos="fade-down" data-aos-delay="250">
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th>Aluno</th>
                                <th>Item</th>
                                <th>Dt. Devolução</th>
                                <th>Dívida</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody class="justify-content-center align-items-center align-content-center">
                            <tr>
                                <td>André Augusto</td>
                                <td>A história da matemática</td>
                                <td>10/04/2018</td>
                                <td><br>R$ 2,00&nbsp;</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Bianca Furtado</td>
                                <td>Revista Teste</td>
                                <td><br>07/05/2018<br><br></td>
                                <td><br>R$ 3,50&nbsp;</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Sérgio Davi</td>
                                <td>Exemplo de TCC</td>
                                <td><br>10/05/2018<br><br></td>
                                <td><br>R$ 1,50&nbsp;</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Samuel Rufino</td>
                                <td>Meu trabalho de Conclusão</td>
                                <td>10/05/2018</td>
                                <td><br>R$ 6,00&nbsp;</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Pablo Monteiro</td>
                                <td>Exemplo de Jornal</td>
                                <td><br>10/05/2018<br><br></td>
                                <td><br>R$ 1,00&nbsp;</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>José George</td>
                                <td>Meu artigo</td>
                                <td><br>10/05/2018<br><br></td>
                                <td><br>R$ 1,50&nbsp;<br><br></td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>