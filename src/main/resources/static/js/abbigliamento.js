function modificaAbbigliamento(oggetto){
    var form = document.getElementById("form-Modifica");
    form.hidden = false;

    var id = document.getElementById("modifica-id");
    var nomeAbbigliamento = document.getElementById("modifica-nomeAbbigliamento");
    var coloreAbbigliamento = document.getElementById("modifica-coloreAbbigliamento");
    var protezione = document.getElementById("modifica-protezione");
    var prezzo = document.getElementById("modifica-prezzo");


    id.value = oggetto.getAttribute("modifica-id");
    nomeAbbigliamento.value = oggetto.getAttribute("modifica-nomeAbbigliamento");
    coloreAbbigliamento.value = oggetto.getAttribute("modifica-coloreAbbigliamento");
    protezione.value = oggetto.getAttribute("modifica-protezione");
    prezzo.value = oggetto.getAttribute("modifica-prezzo");
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

/*function eliminaAbbigliamento(oggetto){
    var id = oggetto.getAttribute("elimina-id");
    var url = "/abbigliamento/elimina/"+id;
    window.location.href    = url;  
}*/

/*function eliminaAbbigliamento(oggetto){
    var id = oggetto.getAttribute("elimina-id");
    var url = "/abbigliamento/elimina/"+id;
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.send();
    location.reload();
}*/


