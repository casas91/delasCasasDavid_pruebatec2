<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Turnos</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand ps-3" href="#"><i class="fa-solid fa-people-group"></i> Turnos</a>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Opciones</div>
                        <!-- Cambios realizados para convertir en botones -->
                        <!-- Opción Agregar Ciudadano -->
                        <form action="agregarCiudadano.jsp" method="POST">
                            <button type="submit" class="nav-link" style="border: none; background: none; cursor: pointer;">
                                <div class="sb-nav-link-icon"><i class="fas fa-user-plus"></i></div>
                                Agregar Ciudadano
                            </button>
                        </form>
                        <!-- Opción Agregar Turno -->
                        <form action="agregarTurno.jsp" method="POST">
                            <button type="submit" class="nav-link" style="border: none; background: none; cursor: pointer;">
                                <div class="sb-nav-link-icon"><i class="fas fa-clock"></i></div>
                                Agregar Turno
                            </button>
                        </form>
                        <!-- Opción Ver Turnos -->
                        <form action="filtradoTurnos.jsp" method="POST">
                            <button type="submit" class="nav-link" style="border: none; background: none; cursor: pointer;">
                                <div class="sb-nav-link-icon"><i class="fas fa-list"></i></div>
                                Filtrar Turnos
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
