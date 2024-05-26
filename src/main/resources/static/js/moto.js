function modificaMoto(oggetto){
if(!oggetto){
    console.error("valori non validi");
    return;
}
var form = document.getElementById("form-Modifica");
if(!form){
    console.error("form modifica non trovato");
    return;
}
chiudiFormAggiunta();
form.hidden = false;
var valori = [
    "id","cilindrata","capacitaSerbatoio","potenzaCV","potenzaKV","peso","altezzaSella","consumo",
    "prezzo","elettronico","trasmissioneM","euro","nomeMotore","marca","tipoMoto","coloreMoto","targa",
    "annoProduzione"]
valori.forEach(function(valore){
    var input = document.getElementById(valore);
    if(input){
        input.value = oggetto.getAttribute("modifica-"+valore);
    }else{
        console.error("elemento non trovato per modifica-"+valore+" in apertura");
    }
}
);
} 


function chiudiFormModifica(){
var form = document.getElementById("form-Modifica");
form.hidden = true;
var valori = [
    "id","cilindrata","capacitaSerbatoio","potenzaCV","potenzaKV","peso","altezzaSella","consumo",
    "prezzo","elettronico","trasmissioneM","euro","nomeMotore","marca","tipoMoto","coloreMoto","targa",
    "annoProduzione"];
valori.forEach(function(valore){
    var input = document.getElementById("modifica-"+valore);
    if(input){  
        input.value = "";
    }else{
        console.error("elemento non trovato per modifica-"+valore +" in chiusura");
    }
});
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

function checkTheCheckBox(oggetto){
    oggetto.value = oggetto.checked ? "true" : "false";
}
