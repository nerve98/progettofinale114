function modificaImmagine(oggetto){
    chiudiFormAggiunta();
    var form = document.getElementById("form-Modifica");
    form.hidden = false;
    var id = document.getElementById("id");
    var nomeImmagine = document.getElementById("nome");
    var descrizione = document.getElementById("url");
    var idM = document.getElementById("idMoto");
    var idC = document.getElementById("idCasco");
    var idA = document.getElementById("idAbbigliamento");

    id.value = oggetto.getAttribute("modifica-id");
    nomeImmagine.value = oggetto.getAttribute("modifica-nome");
    descrizione.value = oggetto.getAttribute("modifica-url");
    idM.value = oggetto.getAttribute("modifica-idMoto");
    idC.value = oggetto.getAttribute("modifica-idCasco");
    idA.value = oggetto.getAttribute("modifica-idAbbigliamento");
}

function chiudiFormModifica(){
    var form = document.getElementById("form-Modifica");
    form.hidden = true;
}

function apriFormAggiunta(){
    chiudiFormModifica();
    var form = document.getElementById("Inserisci");
    form.hidden = false;
}

function chiudiFormAggiunta(){
     var form = document.getElementById("Inserisci");
    form.hidden = true;
}
