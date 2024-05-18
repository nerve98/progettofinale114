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
form.hidden = false;
var valori = [
    "id","cilindrata","capacitaSerbatoio","potenzaCV","potenzaKV","peso","altezzaSella","consumo",
    "prezzo","elettronico","trasmissioneM","euro","nomeMotore","marca","tipoMoto","coloreMoto","targa",
    "annoProduzione"]
valori.forEach(function(valore){
    var input = document.getElementById("modifica-"+valore);
    if(input){
        input.value = oggetto.getAttribute("modifica-"+valore);
    }else{
        console.error("elemento non trovato per modifica-"+valore+" in apertura");
    }
}
);
/*var id = document.getElementById("modifica-id");
var cilindrata = document.getElementById("modifica-cilindrata");
var capacitaSerbatoio = document.getElementById("modifica-capacitaSerbatoio");
var potenzaCV = document.getElementById("modifica-potenzaCV");
var potenzaKV = document.getElementById("modifica-potenzaKV");
var peso = document.getElementById("modifica-peso");
var altezzaSella = document.getElementById("modifica-altezzaSella");
var consumo = document.getElementById("modifica-consumo");
var prezzo = document.getElementById("modifica-prezzo");
var elettronico = document.getElementById("modifica-elettronico");
var trasmissioneM= document.getElementById("modifica-trasmissioneM");
var euro = document.getElementById("modifica-euro");
var nomeMotore = document.getElementById("modifica-nomeMotore");
var marca = document.getElementById("modifica-marca");
var tipoMoto = document.getElementById("modifica-tipoMoto");
var coloreMoto= document.getElementById("modifica-coloreMoto");
var targa = document.getElementById("modifica-targa");
var annoProduzione = document.getElementById("modifica-annoProduzione");

id.value = oggetto.getAttribute("modifica-id");
cilindrata.value = oggetto.getAttribute("modifica-cilindrata");
capacitaSerbatoio.value = oggetto.getAttribute("modifica-capacitaSerbatoio");
potenzaCV.value = oggetto.getAttribute("modifica-potenzaCV");
potenzaKV.value = oggetto.getAttribute("modifica-potenzaKV");
peso.value = oggetto.getAttribute("modifica-peso");
altezzaSella.value = oggetto.getAttribute("modifica-altezzaSella");
consumo.value = oggetto.getAttribute("modifica-consumo");
prezzo.value = oggetto.getAttribute("modifica-prezzo");
elettronico.value = oggetto.getAttribute("modifica-elettronico");
trasmissioneM.value = oggetto.getAttribute("modifica-trasmissioneM");
euro.value = oggetto.getAttribute("modifica-euro");
nomeMotore.value = oggetto.getAttribute("modifica-nomeMotore");
marca.value = oggetto.getAttribute("modifica-marca");
tipoMoto.value = oggetto.getAttribute("modifica-tipoMoto");
coloreMoto.value = oggetto.getAttribute("modifica-coloreMoto");
targa.value = oggetto.getAttribute("modifica-targa");
annoProduzione.value = oggetto.getAttribute("modifica-annoProduzione");*/
} 


function chiudiFormModifica(){
var form = document.getElementById("form-Modifica");
form.hidden = true;
var valori = [
    "id","cilindrata","capacitaSerbatoio","potenzaCV","potenzaKV","peso","altezzaSella","consumo",
    "prezzo","elettronico","trasmissioneM","euro","nomeMotore","marca","tipoMoto","coloreMoto","targa",
    "annoProduzione"]
valori.forEach(function(valore){
    var input = document.getElementById("modifica-"+valore);
    if(input){
        input.value = "";
    }else{
        console.error("elemento non trovato per modifica-"+valore +" in chiusura");
    }
});
/*var id = document.getElementById("modifica-id");
id.value = "";
var cilindrata = document.getElementById("modifica-cilindrata");
cilindrata.value = "";
var capacitaSerbatoio = document.getElementById("modifica-capacitaSerbatoio");
capacitaSerbatoio.value = "";
var potenzaCV = document.getElementById("modifica-potenzaCV");
potenzaCV.value = "";
var potenzaKV = document.getElementById("modifica-potenzaKV");
potenzaKV.value = "";
var peso = document.getElementById("modifica-peso");
peso.value = "";
var altezzaSella = document.getElementById("modifica-altezzaSella");
altezzaSella.value = "";
var consumo = document.getElementById("modifica-consumo");
consumo.value = "";
var prezzo = document.getElementById("modifica-prezzo");
prezzo.value = "";
var elettronico = document.getElementById("modifica-elettronico");
elettronico.value = "";
var trasmissioneM = document.getElementById("modifica-trasmissioneM");
trasmissioneM.value = "";
var euro = document.getElementById("modifica-euro");
euro.value = "";
var nomeMotore = document.getElementById("modifica-nomeMotore");
nomeMotore.value = "";
var marca = document.getElementById("modifica-marca");
marca.value = "";
var tipoMoto = document.getElementById("modifica-tipoMoto");
tipoMoto.value = "";
var coloreMoto = document.getElementById("modifica-coloreMoto");
coloreMoto.value = "";
var targa = document.getElementById("modifica-targa");
targa.value = "";
var annoProduzione = document.getElementById("modifica-annoProduzione");
annoProduzione.value = "";*/

}

function apriFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = false;
}
    
function chiudiFormAggiunta(){
    var form = document.getElementById("Inserisci");
    form.hidden = true;
}
