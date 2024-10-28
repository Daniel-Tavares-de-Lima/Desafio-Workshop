//----URL padrão----
const url = "http://localhost:8080";

//---APENAS PARA TESTE, VERIFICA OS DADOS
fetch(`${url}/colaboradores`).then(responde => responde.json()).then(data =>{
    console.log("Colaboradores DATA:", data).catch(error => console.error("Erro ao buscar workshop:", error))
});

  //---APENAS PARA TESTE, VERIFICA OS DADOS
  fetch(`${url}/workshops`).then(response => response.json()).then(workshops => {workshops.forEach(workshop => {
        console.log(`Data formatada: ${formatDate(workshop.dataRealizacao)}`);});
});


 //---Função para formatar a data

function formatDate(timestamp) {
    const data = new Date(timestamp);
    return data.toLocaleDateString("pt-BR", {day: "2-digit",month: "2-digit",year: "numeric"});
  }

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

// Função para buscar e exibir a lista de workshops
function workshop(){
    fetch(`${url}/workshop`).then(response => response.json()).then(workshops =>{
        const tabelaWorkshop = document.querySelector("#tabelaWorkshop tbody");
        tabelaWorkshop.innerHTML = "";
        workshops.forEach(workshopTaag =>{
            const linha = document.createElement("tr");
            linha.innerHTML = `
                <td>${workshopTaag.id}</td>
                <td><a href="#" onclick="showWorkshopDetails(${workshopTaag.id})">${workshopTaag.nome}</a></td>
                <td>${formatDate(workshopTaag.dataRealizacao)}</td>
            `;
            tabelaWorkshop.appendChild(linha);

        });
    }).catch(error => console.error("Erro ao carregar workshops:", error))
}

// Carregar dados ao carregar as páginas
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("tabelaColaboradores")) colaboradores();
    if (document.getElementById("tabelaWorkshop")) workshop();
});