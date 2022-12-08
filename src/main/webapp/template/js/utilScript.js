var refForm = document.querySelector('#form1');
var refButton = refForm.querySelector('.btn.btn-primary');
var refAnchor = document.querySelector('#add');
console.log("matricule = " + refAnchor);
refButton.onclick = function() {
	var matricule = refForm.querySelector('#matricule').value;
	var nom = refForm.querySelector('#nom').value;
	var prenom = refForm.querySelector('#prenom').value;
	console.log("matricule = " + matricule);
	console.log("nom = " + nom);
	console.log("prenom = " + prenom);
	if (matricule == "" && nom == "" && prenom == "") {
		alert("Au moins vous devez remplir une entree");
		return false;
	}
	if (matricule && nom && prenom) {
		alert("Il n'est pas possible de rechercher avec trois entrees");
		return false;
	}
	refForm.submit();
	var spinner = refButton.querySelector('#spinner')
	spinner.style.display = "inline-block";
	this.disabled = "disabled"
}
/*refAnchor.onclick = function anchor(){
	var myForm = document.createElement("form");
	document.body.appendChild(myForm);
    myForm.action="/campus_mangement/add_student";
    myForm.method="post";
    myForm.submit();
}*/
