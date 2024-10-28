document.addEventListener("DOMContentLoaded", function () {
    const mainMenu = document.querySelector(".mainMenu");
    const fechaMenu = document.querySelector(".fechaMenu");
    const abraMenu = document.querySelector(".abraMenu");

    abraMenu.addEventListener("click", abrirMenu);
    fechaMenu.addEventListener("click", fecharMenu);

    function abrirMenu() {
        mainMenu.style.display = "flex"; 
        mainMenu.style.top = "0";
    }

    function fecharMenu() {
        mainMenu.style.top = "-100%"; 
    }
});

