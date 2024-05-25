document.addEventListener('DOMContentLoaded', function() {
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
});

function goBack() {
    // Recupera l'URL della pagina precedente dal localStorage
    var storedPreviousUrl = localStorage.getItem('previousUrl');

    // Verifica se l'URL della pagina precedente non è vuoto
    if (storedPreviousUrl) {
        // Reindirizza l'utente alla pagina precedente
        window.location.href = storedPreviousUrl;
    } else {
        console.log('Nessuna pagina precedente trovata.');
    }
  
}