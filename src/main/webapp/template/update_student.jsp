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
<title>add student</title>
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
		<a class="navbar-brand ps-3" href="/campus_mangement/search">Admin
			dashboard</a>
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
					<li><a class="dropdown-item" href="/campus_mangement/logout">Logout</a></li>
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
						<a class="nav-link" href="/campus_mangement/search">
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
								<a class="nav-link" href="/campus_mangement/list_students">Liste
									des etudiants</a> <a class="nav-link"
									href="/campus_mangement/add_student">ajouter un etudiant</a>
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
					<h1 class="mt-4">
						<i class="fa-regular fa-user-check"></i> Modifier un etudiant :
					</h1>
					<ol class="breadcrumb mb-4 text-muted">
						<small> remplir les information d'etudiant qui vous pouvez
							modifier </small>
					</ol>
					<form action="/campus_mangement/put_student" method="put"
						class="form-control" id="form1">
						<c:if test="${empty info}">
							<div
								class="toast align-items-center text-white bg-primary border-0"
								role="alert" aria-live="assertive" aria-atomic="true">
								<div class="d-flex">
									<div class="toast-body">
										<c:out value="${info}" />
									</div>
									<button type="button"
										class="btn-close btn-close-white me-2 m-auto"
										data-bs-dismiss="toast" aria-label="Close"></button>
								</div>
							</div>
						</c:if>
						<c:set value="${data}" var="etudiant" />
						<div class="mb-3">
							<label for="matricule" class="form-label">Matricule
								d'etudiant :</label> <input type="text" class="form-control"
								value=<c:out value="${etudiant.matricule}" />
								placeholder="1818*******" aria-describedby="MatriculeHelp"
								name="matricule">
							<div id="MatriculeHelp" class="form-text">Entrer le 10
								nombre entre dans la carte d'etudiant</div>
						</div>
						<div class="row g-3 mb-4">
							<div class="col">
								<label for="nom" class="form-label">Nom d'etudiant :</label> <input
									type="text" value=<c:out value="${etudiant.nom}"/>
									class="form-control" placeholder="Nom" name="nom">
							</div>
							<div class="col">
								<label for="prenom" class="form-label">Prenom d'etudiant
									:</label> <input type="text" class="form-control" placeholder="Prenom"
									name="prenom" value=<c:out value="${etudiant.prenom}"/>>
							</div>
						</div>
						<div class="row g-3 mb-4">
							<div class="col">
								<label for="email" class="form-label">Email :</label> <input
									type="email" class="form-control"
									placeholder="Nom.prenom@gmail.com" name="email"
									value=<c:out value="${etudiant.email}"/>>
							</div>
							<div class="col">
								<label for="sexe" class="form-label">Sexe :</label> <input
									type="text" class="form-control" placeholder="sexe" name="sexe"
									value=<c:out value="${etudiant.sexe}"/>>
							</div>
							<div class="col">
								<label for="birth_date" class="form-label">date de
									naissance :</label> <input type="date" class="form-control"
									placeholder="26-08-2000" name="birth_date"
									value=<c:out value="${etudiant.birth_date}"/>>
							</div>
						</div>
						<div class="row g-3 mb-4">
							<div class="col">
								<label for="prenom_pere" class="form-label">prenom de
									pere :</label> <input type="text" class="form-control"
									placeholder="prenom de pere" name="prenom_pere"
									value=<c:out value="${etudiant.prenom_pere}"/>>
							</div>
							<div class="col">
								<label for="nom_mere" class="form-label">nom de mere :</label> <input
									type="text" class="form-control" placeholder="nom de mere"
									name="nom_mere" value=<c:out value="${etudiant.nom_mere}"/>>
							</div>
							<div class="col">
								<label for="prenom_mere" class="form-label">prenom_mere
									:</label> <input type="text" class="form-control"
									placeholder="prenom de mere" name="prenom_mere"
									value=<c:out value="${etudiant.prenom_mere}"/>>
							</div>
						</div>
						<div class="row g-3 mb-4">
							<div class="col">
								<label for="faculté_id" class="form-label">faculte id :</label>
								<input type="number" class="form-control"
									placeholder="faculte id" name="faculté_id"
									value=<c:out value="${etudiant.faculté_id}"/>>
							</div>
							<div class="col">
								<label for="departement_id" class="form-label">departement
									id :</label> <input type="number" class="form-control"
									placeholder="departement id" name="departement_id"
									value=<c:out value="${etudiant.departement_id}"/>>
							</div>
							<div class="col">
								<label for="specialite_id" class="form-label">specialite
									id :</label> <input type="number" class="form-control"
									placeholder="specialite id" name="specialite_id"
									value=<c:out value="${etudiant.specialite_id}"/>>
							</div>
						</div>
						<div class="row g-3 mb-4">
							<div class="col">
								<label for="niveau" class="form-label">niveau :</label> <input
									type="text" class="form-control" placeholder="niveau"
									name="niveau" value=<c:out value="${etudiant.niveau}"/>>
							</div>
							<div class="col">
								<label for="formation" class="form-label">formation :</label> <input
									type="text" class="form-control" placeholder="formation"
									name="formation" value=<c:out value="${etudiant.formation}"/>>
							</div>
							<div class="col">
								<label for="derniere_inscription" class="form-label">derniere_inscription
									:</label> <input type="number" class="form-control" placeholder="2022"
									name="derniere_inscription"
									value=<c:out value="${etudiant.derniere_inscription}"/>>
							</div>
						</div>
						<button class="btn btn-primary" type="submit">
							<span class='spinner-border spinner-border-sm' role='status'
								aria-hidden='true' id='spinner' style='display: none;'></span>
							Ajouter
						</button>
						<hr>
					</form>
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
	<script src="js/datatables-simple-demo.js"></script>
</body>

</html>