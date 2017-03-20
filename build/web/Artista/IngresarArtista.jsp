<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="..\css\style.css" rel="stylesheet" type="text/css">
    </head><body>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">                   
                    <a class="navbar-brand" href="..\index.html"><span>Arquitectura de datos</span></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="..\index.html">Inicio</a>
                        </li>
                        <li>
                            <a href="#">Contacts</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="page-header">
                            <%
                                String stat = null;
                                stat = (String) session.getAttribute("stat2");
                                if (stat == null) {
                                    stat = "Ingresar Administrador";
                                }
                            %>
                            <h1><%=stat%>
                                <small>Ingrese sus datos</small>
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal" method="post" action="../Ingresar" role="form">
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="inputUsuario" class="control-label">Usuario</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="usuario" placeholder="Usuario">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="inputClave" class="control-label">Contraseña</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="clave" placeholder="Contraseña">
                                </div>
                            </div>
                            <input type="text" name="tForm" value="1" hidden>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Ingresar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </body></html>
