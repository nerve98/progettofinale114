/*document.addEventListener('DOMContentLoaded', function() {
    // Salva l'URL della pagina precedente in una variabile
    var previousUrl = document.referrer;

    // Verifica se l'URL della pagina precedente non è vuoto
    if (previousUrl) {
        console.log('URL della pagina precedente:', previousUrl);

        // Salva l'URL della pagina precedente nel localStorage
        localStorage.setItem('previousUrl', previousUrl);
    } else {
        console.log('Nessuna pagina precedente trovata.');
    }

    // Recupera l'URL della pagina precedente dal localStorage
    var storedPreviousUrl = localStorage.getItem('previousUrl');
    if (storedPreviousUrl) {
        document.getElementById('previousUrl').textContent = 'URL della pagina precedente: ' + storedPreviousUrl;
    }
});*/

function goBack() {
    /*var storedPreviousUrl=localStorage.getItem('previousUrl');
    console.log(storedPreviousUrl);*/
    //window.history.go(-1);
    /*while(storedPreviousUrl.includes("lista-carrello")){
        storedPreviousUrl=storedPreviousUrl.substring(0,storedPreviousUrl.lastIndexOf('/'));
        
    }
    // Recupera l'URL della pagina precedente dal localStorage
    //var storedPreviousUrl = localStorage.getItem('previousUrl');
    window.location.href = storedPreviousUrl;

    // Verifica se l'URL della pagina precedente non è vuoto
    /*if (storedPreviousUrl) {
        console.log(storedPreviousUrl);
        var indexUrl=storedPreviousUrl.lastIndexOf('/');
        var page=storedPreviousUrl.substring(indexUrl+1);
        if(page=="lista-carrello"){
    
        }
        // Reindirizza l'utente alla pagina precedente
        //window.location.href = storedPreviousUrl;
    } else {
        console.log('Nessuna pagina precedente trovata.');
    }*/
    /*var storedPreviousUrl=localStorage.getItem('carrelloPreviousUrl');
    console.log(storedPreviousUrl);
    window.location.assign(storedPreviousUrl);*/
    console.log(localStorage.getItem('previousUrl'));
    window.location.assign(localStorage.getItem('previousUrl'));
}

function removeHistoryPage(){
    /*console.log(localStorage.getItem('previousUrl'));
    try {
        localStorage.setItem('carrelloPreviousUrl',localStorage.getItem('previousUrl'));
    history.replaceState(null, null, localStorage.getItem('previousUrl'));
    } catch (error) {
        console.error('Error setting item in localStorage:', error);
    }*/
    history.replaceState(null, null, window.location.href);
    
}