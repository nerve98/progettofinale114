function modificaImmagine(oggetto){
    var form = document.getElementById("form-Modifica");
    form.hidden = false;
    
    var id = document.getElementById("modifica-id");
    var nomeImmagine = document.getElementById("modifica-nomeImmagine");
    var descrizione = document.getElementById("modifica-descrizione");
    var prezzo = document.getElementById("modifica-prezzo");
    var tipo = document.getElementById("modifica-tipo");
}

function chiudiFormModifica(){
    var form = document.getElementById("form-Modifica");
    form.hidden = true;
    var id = document.getElementById("modifica-id");
    id.value = "";
    var nomeImmagine = document.getElementById("modifica-nomeImmagine");
    nomeImmagine.value = "";
    var descrizione = document.getElementById("modifica-descrizione");
    descrizione.value = "";
    var prezzo = document.getElementById("modifica-prezzo");
    prezzo.value = "";
    var tipo = document.getElementById("modifica-tipo");
    tipo.value = "";
}
function apriFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = false;
}

function chiudiFrmAggiunta(){
    var form = documento.getElementById("Inserisci");
    form.hidden = true;
}