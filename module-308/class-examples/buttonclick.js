
function changeText() {
    const p = document.querySelector('#discordConfigPTag');
    p.textContent = "Changed because of an event handler property.";
    
    const button = document.querySelector('button');
    button.textContent = "I was clicked";
}

function gotoLookup() {
    window.location.href = '/lookup.html';
}
