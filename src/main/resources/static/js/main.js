function cercaAbbigliamento() {
    var id = document.getElementById("cerca-id");
    window.location.href = "/abbigliamento-byid?idAbbigliamento"+id.value;
    if( id.value == "" || id.value == 0){
        window.location.href = "/elimina-abbigliamento?idAbbigliamento=0";

    }

}


function cercaCasco() {
    var id = document.getElementById("cerca-id");
    window.location.href = "/casco-byid?idCasco="+id.value;
    if( id.value == "" || id.value == 0){
        window.location.href = "/elimina-casco?idCasco=0";

    }
}

function cercaImmagine() {
    var id = document.getElementById("cerca-id");
    window.location.href = "/immagine-byid?idImmagine="+id.value;
    if( id.value == "" || id.value == 0){
        window.location.href = "/elimina-immagine?idImmagine=0";

    }
}

function cercaUtente() {
    var id = document.getElementById("cerca-id");
    window.location.href = "/utente-byid?idUtente="+id.value;
    if( id.value == "" || id.value == 0){
        window.location.href = "/elimina-utente?idUtente=0";

    }
}

function cercaMoto() {
    var id = document.getElementById("cerca-id");
    window.location.href = "/moto-byid?idMoto="+id.value;
    if( id.value == "" || id.value == 0){
        window.location.href = "/elimina-moto?idMoto=0";

    }
}


	// Dropdowns.
    $('#nav > ul').dropotron({
        mode: 'fade',
        noOpenerFade: true,
        speed: 300,
        alignment: 'center'
    });