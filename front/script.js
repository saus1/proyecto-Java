// fetch devuelve una promesa — una operación que todavía no terminó.
// .then() se ejecuta cuando la promesa se resuelve.
// .catch() se ejecuta si ocurre un error de red.

fetch("http://localhost:8080/libros", {
    method: "DELETE"
})
    .then(response => {
        if (response.ok) {
            console.log("Libro eliminado.");
        } else {
            console.log("No se encontró el libro.");
        }
    })
    .catch(error => console.error("Error:", error));
