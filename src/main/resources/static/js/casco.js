function modificaCasco(oggetto){
    var form = document.getElementById("form-Modifica");
    chiudiFormAggiunta();
    form.hidden = false;
   
    var id = document.getElementById("id");
    var nomeCasco = document.getElementById("nomeCasco");
    var coloreCasco = document.getElementById("coloreCasco");
    var visieraOscurata= document.getElementById("visieraOscurata");
    var prezzo = document.getElementById("prezzo");
    var modello = document.getElementById("modello");


    id.value = oggetto.getAttribute("modifica-id");
    nomeCasco.value = oggetto.getAttribute("modifica-nomeCasco");
    coloreCasco.value = oggetto.getAttribute("modifica-coloreCasco");
    visieraOscurata.value = oggetto.getAttribute("modifica-visieraOscurata");
    prezzo.value = oggetto.getAttribute("modifica-prezzo");
    modello.value = oggetto.getAttribute("modifica-modello");
    
}

function chiudiFormModifica(){
    var form = document.getElementById("form-Modifica");
    form.hidden = true;
    var id = document.getElementById("modifica-id");
    id.value = "";
    var nomeCasco = document.getElementById("modifica-nomeCasco");
    nomeCasco.value = "";
    var coloreCasco = document.getElementById("modifica-coloreCasco");
    coloreCasco.value = "";
    var visieraOscurata = document.getElementById("modifica-visieraOscurata");
    visieraOscurata.value = "";
    var prezzo = document.getElementById("modifica-prezzo");
    prezzo.value = "";
    var modello = document.getElementById("modifica-modello");
    modello.value = "";

}

function apriFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = false;
    chiudiFormModifica();
}

function chiudiFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = true;
}
function checkTheCheckBox(oggetto){
    oggetto.value = oggetto.checked ? "true" : "false";
}

function updateTextInput(val) {
    document.getElementById('textInput').value=val; 
  }

 