//var refButton = document.getElementById( 'chercher' );
var refForm = document.querySelector('#form1');
var refButton = refForm.querySelector('.btn.btn-primary');
refButton.onclick = function() {
	var matricule = refForm.querySelector('#matricule').value;
	var nom = refForm.querySelector('#nom').value;
	var prenom = refForm.querySelector('#prenom').value;
	console.log("matricule = " + matricule);
	console.log("nom = " + nom);
	console.log("prenom = " + prenom);
	if (matricule == "" && nom == "" && prenom == "") {
		alert("at least you need fill one input");
		return false;
	}
	refForm.submit();
	var spinner = refButton.querySelector('#spinner')
	spinner.style.display = "inline-block";
	this.disabled = "disabled"
}

//window.onload = function() {

//}