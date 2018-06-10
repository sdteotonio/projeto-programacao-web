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
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 d-inline-flex align-self-end box-app" data-aos="fade-down" data-aos-delay="250">
                <h1>Reservas-&nbsp;<i class="fa fa-calendar-check-o"></i></h1>
            </div>
        </div>
        <hr>
        <div class="container-fluid d-flex justify-content-center container-form">
            <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" data-aos="fade-right" data-aos-delay="500">
                <form class="box-app">
                    <div class="form-group">
                        <h4 class="text-left">Item:</h4><select class="form-control"></select></div>
                    <div class="form-group">
                        <h4 class="text-left">Aluno:</h4><select class="form-control"></select></div>
                    <div class="form-group">
                        <h4 class="text-left">Data da Reserva:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10" autofocus=""></div>
                    <div class="form-group" style="padding:8px;">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Reservado</label></div>
                    </div>
                    <div class="form-row">
                        <div class="col"><button class="btn btn-success btn-block" type="button">Reservar</button></div>
                        <div class="col"><button class="btn btn-primary btn-block" type="button">Atualizar</button></div>
                        <div class="col"><button class="btn btn-danger btn-block" type="button">Remover</button></div>
                    </div>
                </form>
            </div>
            <div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 box-overlay-app" data-aos="fade-down" data-aos-delay="250">
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th>Aluno</th>
                                <th>Item</th>
                                <th>Dt. Reserva</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody class="justify-content-center align-items-center align-content-center">
                            <tr>
                                <td>André Augusto</td>
                                <td>A história da matemática</td>
                                <td>10/04/2018</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Bianca Furtado</td>
                                <td>Revista Teste</td>
                                <td><br>07/05/2018<br><br></td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Sérgio Davi</td>
                                <td>Exemplo de TCC</td>
                                <td><br>10/05/2018<br><br></td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Samuel Rufino</td>
                                <td>Meu trabalho de Conclusão</td>
                                <td>10/05/2018</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>Pablo Monteiro</td>
                                <td>Exemplo de Jornal</td>
                                <td><br>10/05/2018<br><br></td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td><br>José George</td>
                                <td>Meu artigo</td>
                                <td><br>10/05/2018<br><br></td>
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