document.addEventListener( "DOMContentLoaded", () => {
    let url = "http://localhost:8080/postman-echo/get"

    fetch('http://localhost:8080/postman-echo/get')
        .then(response => response.text())
        .then(data => document.getElementById("content").innerHTML = data);
});