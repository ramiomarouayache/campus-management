<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Ajouter-etudiant</title>
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
					<li><a class="dropdown-item" href="#!">Profile</a></li>
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
					<h1 class="mt-4">
						<i class="fa-regular fa-user-check"></i> Ajouter un etudiant :
					</h1>
					<ol class="breadcrumb mb-4 text-muted">
						<small> Formulaire pour ajouter un etudiant
						</small>
					</ol>
					<form action="/campus_mangement/search" method="post"
						class="form-control px-3" id="form1">
						<hr>
						<div class="mb-3">
							<label for="matricule" class="form-label">Matricule
								d'etudiant :</label> <input type="text" class="form-control"
								id="matricule" placeholder="1818*******"
								aria-describedby="MatriculeHelp" name="matricule">
							<div id="MatriculeHelp" class="form-text">Entrer le 10
								nombre entre dans la carte d'etudiant</div>
						</div>
						<div class="mb-3">
							<label for="nom" class="form-label">Nom d'etudiant :</label> <input
								type="text" class="form-control" id="nom" placeholder="Nom"
								name="nom">
						</div>
						<div class="mb-3">
							<label for="prenom" class="form-label">Prenom d'etudiant
								:</label> <input type="text" class="form-control" id="prenom"
								placeholder="Prenom" name="prenom">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email d'etudiant :</label>
							<input type="email" class="form-control" id="email"
								placeholder="Email" name="email">
						</div>
						<div class="mb-3">
							<label for="sexe" class="form-label">male or female ? :</label> <input
								type="text" class="form-control" id="sexe" placeholder="male"
								name="sexe">
						</div>
						<div class="mb-3">
							<label for="birth_date" class="form-label">date de
								naissance :</label> <input type="date" class="form-control"
								id="birth_date" placeholder="2000-01-1" name="birth_date">
						</div>
						<div class="mb-3">
							<label for="prenom_pere" class="form-label">prenom de
								pére :</label> <input type="text" class="form-control" id="prenom_pere"
								placeholder="prenom" name="prenom_pere">
						</div>
						<div class="mb-3">
							<label for="nom_mere" class="form-label">nom de mére :</label> <input
								type="text" class="form-control" id="nom_mere"
								placeholder="nom_mere" name="nom_mere">
						</div>
						<div class="mb-3">
							<label for="prenom_mere" class="form-label">prenom de
								mére :</label> <input type="text" class="form-control" id="prenom_mere"
								placeholder="prenom_mere" name="prenom_mere">
						</div>
						<div class="mb-3">
							<label for="derniere_inscription" class="form-label">derniere
								inscription :</label> <input type="number" class="form-control"
								id="derniere_inscription" placeholder="2020"
								name="derniere_inscription">
						</div>
						<div class="mb-3">
							<label for="faculté_id" class="form-label">faculté :</label> <input
								type="text" class="form-control" id="faculté_id"
								placeholder="Ntic" name="faculté_id">
						</div>
						<div class="mb-3">
							<label for="departement_id" class="form-label">departement
								:</label> <input type="text" class="form-control" id="departement_id"
								placeholder="departement IFA" name="departement_id">
						</div>
						<div class="mb-3">
							<label for="specialité_id" class="form-label">specialité
								:</label> <input type="text" class="form-control" id="specialité_id"
								placeholder="RSD" name="specialité_id">
						</div>
						<div class="mb-3">
							<label for="niveau" class="form-label">niveau :</label> <input
								type="text" class="form-control" id="niveau"
								placeholder="premiere année" name="niveau">
						</div>
						<div class="mb-3">
							<label for="foramtion" class="form-label">formation :</label> <input
								type="text" class="form-control" id="formation"
								placeholder="licence" name="formation">
						</div>
						<button class="btn btn-primary" type="submit">
							<span class='spinner-border spinner-border-sm' role='status'
								aria-hidden='true' id='spinner' style='display: none;'></span>
							Chercher
						</button>
						<hr>
					</form>
				</div>
				<script type="text/javascript"
					src="/campus_mangement/template/js/utilScript.js"></script>
</body>
</html>