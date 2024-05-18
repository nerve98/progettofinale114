function modificaUtente(oggetto) {
    var form = document.getElementById("form-Modifica");
    form.hidden = false;
    
    var id = document.getElementById("modifica-id");
    var nome = document.getElementById("modifica-nome");
    var cognome = document.getElementById("modifica-cognome");
    var email = document.getElementById("modifica-email");
    var password = document.getElementById("modifica-password");
    
    var numeroCellulare = document.getElementById("modifica-numeroCellulare");
    
    var dataNascita = document.getElementById("modifica-dataNascita");
    
    
    id.value = oggetto.getAttribute("modifica-id");
    nome.value = oggetto.getAttribute("modifica-nome");
    cognome.value = oggetto.getAttribute("modifica-cognome");
    email.value = oggetto.getAttribute("modifica-email");
    password.value = oggetto.getAttribute("modifica-password");
    
    numeroCellulare.value = oggetto.getAttribute("modifica-numeroCellulare");
   
    dataNascita.value = oggetto.getAttribute("modifica-dataNascita");
   
    
}

function chiudiFormModifica(){
    var form = document.getElementById("form-Modifica");
    form.hidden = true;
    var id = document.getElementById("modifica-id");
    id.value = "";
    var nome = document.getElementById("modifica-nome");
    nome.value = "";
    var cognome = document.getElementById("modifica-cognome");
    cognome.value = "";
    var email = document.getElementById("modifica-email");
    email.value = "";
    var password = document.getElementById("modifica-password");
    password.value = "";
    var numeroCellulare = document.getElementById("modifica-numeroCellulare");
    numeroCellulare.value = "";
    var dataNascita = document.getElementById("modifica-dataNascita");
    dataNascita.value = "";
    

}





function apriFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = false;
}

function chiudiFrmAggiunta(){
    var form = documento.getElementById("Inserisci");
    form.hidden = true;
}