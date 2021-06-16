function cambia_bandera() {
	switch (document.getElementById("currencyType").value) {
	case "1":
		document.getElementById("bandera").src = "/img/banderaperu.png";
		document.getElementById("simbolo").innerHTML = "PEN";
		break;
	case "2":
		document.getElementById("bandera").src = "/img/banderausa.png";
		document.getElementById("simbolo").innerHTML = "USD";
		break;
	case "3":
		document.getElementById("bandera").src = "/img/banderaue.png";
		document.getElementById("simbolo").innerHTML = "EUR";
		break;
	}
}

function cambia_tasa(){
	
	switch (document.getElementById("typeRate").value){
	
	case "Tasa Efectiva":

		document.getElementById("capitalization").style.display="none";
				
		break;
		
	case "Tasa Nominal":
		
		document.getElementById("capitalization").style.display="block";
		
		break;
	}
}
