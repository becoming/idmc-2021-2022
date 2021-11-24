document.addEventListener("DOMContentLoaded", () => {
    let url = "http://localhost:8080/postman-echo/get";

    fetch(url)
        .then((resp) => {
        resp.text().then((text) => {
            document.getElementById("content").textContent = text;
        })
    }).catch(reason => {
        console.log("Erreur")
    })
})