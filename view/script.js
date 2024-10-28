//----URL padrão----
const url = "http://localhost:8080";

//---APENAS PARA TESTE, VERIFICA OS DADOS
fetch(`${url}/colaboradores`).then(responde => responde.json()).then(data =>{
    console.log("Colaboradores DATA:", data).catch(error => console.error("Erro ao buscar workshop:", error))
 })


// Função para buscar e exibir a lista de colaboradores
function colaboradores(){
    fetch(`${url}/colaboradores`).then(response => response.json()).then(colaborador => {
        const tabelaColaboradores = document.querySelector("#tabelaColaboradores tbody");
        tabelaColaboradores.innerHTML = "";
        colaborador.forEach(colaboradorTag =>{
            const linha = document.createElement("tr");
            linha.innerHTML = `
                <td>${colaboradorTag.id}</td>
                <td>${colaboradorTag.nome}</td>
            `;
            tabelaColaboradores.appendChild(linha);
        });
    }).catch(error => console.error("Erro ao carregar colaboradores:", error));
}
 
// Carregar dados ao carregar as páginas
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("tabelaColaboradores")) colaboradores();
});