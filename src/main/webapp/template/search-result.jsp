<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="/campus_mangement/template/css/styles.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/741788fb77.js"
	crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="index.jsp">Admin dashboard</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="index.jsp">
							<div class="sb-nav-link-icon">
								<i class="fa-regular fa-user"></i>
							</div> Chercher un etudiant
						</a>
						<div class="sb-sidenav-menu-heading">Administaration</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fa-regular fa-wrench-simple"></i>
							</div> Gerer les etudiants
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="layout-static.jsp">Liste des
									Ã©tudiants</a> <a class="nav-link"
									href="/campus_mangement/template/add_etudiant.jsp">ajouter
									un Ã©tudiant</a> <a class="nav-link"
									href="layout-sidenav-light.jsp">Supprimer un Ã©tudiant</a>
							</nav>
						</div>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Authentifier comme :</div>
					Admin-departement
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i>Résultat de la recherche :
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th></th>
										<th>Matricule</th>
										<th>Nom</th>
										<th>Prenom</th>
										<th>Email</th>
										<th>Sexe</th>
										<th>Date de naissance</th>
										<th>Prenom de pere</th>
										<th>Nom de mere</th>
										<th>Prenom de mere</th>
										<th>Faculte id</th>
										<th>Departement id</th>
										<th>Specialite id</th>
										<th>Niveau</th>
										<th>Foramtion</th>
										<th>Derniere inscription</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="counter" scope="session" value="${0}" />
									<c:forEach items="${data}" var="etudiant">
										<tr>
											<td><c:out value="${counter+1}" /></td>
											<td><c:out value="${etudiant.matricule}" /></td>
											<td><c:out value="${etudiant.nom}" /></td>
											<td><c:out value="${etudiant.prenom}" /></td>
											<td><c:out value="${etudiant.email}" /></td>
											<td><c:out value="${etudiant.sexe}" /></td>
											<td><c:out value="${etudiant.birth_date}" /></td>
											<td><c:out value="${etudiant.prenom_pere}" /></td>
											<td><c:out value="${etudiant.nom_mere}" /></td>
											<td><c:out value="${etudiant.prenom_mere}" /></td>
											<td><c:out value="${etudiant.faculté_id}" /></td>
											<td><c:out value="${etudiant.departement_id}" /></td>
											<td><c:out value="${etudiant.specialité_id}" /></td>
											<td><c:out value="${etudiant.niveau}" /></td>
											<td><c:out value="${etudiant.formation}" /></td>
											<td><c:out value="${etudiant.derniere_inscription}" /></td>
										</tr>
										<c:set var="counter" scope="session" value="${counter+1}" />
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy;
							Campus-administration 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="/campus_mangement/template/js/scripts.js"></script>
	<script type="text/javascript"
		src="/campus_mangement/template/js/utilScript.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="/campus_mangement/template/js/datatables-simple-demo.js"></script>
</body>

</html>