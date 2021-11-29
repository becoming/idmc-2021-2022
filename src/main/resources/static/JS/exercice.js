document.addEventListener( "DOMContentLoaded", () => {
    let url = "http://localhost:8080/postman-echo/get"

    fetch(url)
        .then(response => response.text())
        .then(data => document.getElementById("content").innerHTML = data);

    url = "http://localhost:8080/games/test-api"

    fetch(url)
        .then(response => response.text())
        .then(data => document.getElementById("games").innerHTML = data);
});