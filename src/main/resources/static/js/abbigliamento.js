function modificaAbbigliamento(oggetto){
    
    var form = document.getElementById("form-Modifica");
    form.hidden = false;
    chiudiFormAggiunta();
    var id = document.getElementById("id");
    var nomeAbbigliamento = document.getElementById("nomeAbbigliamento");
    var coloreAbbigliamento = document.getElementById("coloreAbbigliamento");
    var materiale= document.getElementById("materiale");
    var brand= document.getElementById("brand");
    var protezione = document.getElementById("protezione");
    var prezzo = document.getElementById("prezzo");
   

    id.value = oggetto.getAttribute("modifica-id");
    nomeAbbigliamento.value = oggetto.getAttribute("modifica-nomeAbbigliamento");
    coloreAbbigliamento.value = oggetto.getAttribute("modifica-coloreAbbigliamento");
    protezione.value = oggetto.getAttribute("modifica-protezione");
    prezzo.value = oggetto.getAttribute("modifica-prezzo");
    materiale.value = oggetto.getAttribute("modifica-materiale");
    brand.value = oggetto.getAttribute("modifica-brand");
   
}


function chiudiFormModifica(){
    var form = document.getElementById("form-Modifica");
    form.hidden = true;
    var id = document.getElementById("modifica-id");
    id.value = "";
    var nomeAbbigliamento = document.getElementById("modifica-nomeAbbigliamento");
    nomeAbbigliamento.value = "";
    var coloreAbbigliamento = document.getElementById("modifica-coloreAbbigliamento");
    coloreAbbigliamento.value = "";
    var protezione = document.getElementById("modifica-protezione");
    protezione.value = "";
    var prezzo = document.getElementById("modifica-prezzo");
    prezzo.value = "";

}

function checkTheCheckBox(oggetto){
    oggetto.value = oggetto.checked ? "true" : "false";
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

