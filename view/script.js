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
                <td onclick="mostrarDetalhesWorkshop(event, ${workshopTaag.id})" style="cursor: pointer;">${workshopTaag.nome}</td>
                <td>${formatDate(workshopTaag.dataRealizacao)}</td>
            `;
            tabelaWorkshop.appendChild(linha);

        });
    }).catch(error => console.error("Erro ao carregar workshops:", error))
}


function mostrarDetalhesWorkshop(event, workshopId) {
    event.preventDefault();

    const workshopTabela = document.querySelector("#tabelaWorkshop tbody");
    const verificaDetalhesLinha = document.querySelector(`.details-row[data-workshop-id="${workshopId}"]`);
    
    if (verificaDetalhesLinha) {
        const detailsContent = verificaDetalhesLinha.querySelector(".details-content");
        detailsContent.classList.toggle("show");
        return;
    }

    console.log("Workshop ID para busca de presença:", workshopId);
    
    // Faz a requisição para obter a ata de presença do workshop específico
    fetch(`${url}/ata-de-presenca/${workshopId}`).then(response => {
            if (!response.ok) {
                throw new Error("Erro na resposta do servidor.");
            }
            return response.json();
        }).then(presenca => {
            // Confirma se presenca é um objeto
            if (typeof presenca !== 'object' || presenca === null) {
                console.error("Erro: resposta não é um objeto de presença");
                return;
            }

            // Coloca a presença em um array para facilitar o tratamento
            const ataDePresenca = [presenca]; // Transformando o objeto em um array

            const detalhesLinha = document.createElement("tr");
            detalhesLinha.classList.add("details-row");
            detalhesLinha.setAttribute("data-workshop-id", workshopId);

            detalhesLinha.innerHTML = `
                <td colspan="3">
                    <div class="details-content">
                        <h2>Detalhes do Workshop ${workshopId}</h2>
                        <h3>Colaboradores Presentes:</h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Presente</th>
                                </tr>
                            </thead>
                            <tbody>
                                ${ataDePresenca
                                    .map(presenca => {
                                        return `
                                            <tr>
                                                <td>${presenca.colaborador.id}</td>
                                                <td>${presenca.colaborador.nome}</td>
                                                <td>${presenca.presente ? "Sim" : "Não"}</td>
                                            </tr>`;
                                    })
                                    .join("")}
                            </tbody>
                        </table>
                    </div>
                </td>
            `;

            const workshopRow = event.target.closest("tr");
            workshopRow.insertAdjacentElement("afterend", detalhesLinha);

            const detailsContent = detalhesLinha.querySelector(".details-content");
            setTimeout(() => detailsContent.classList.add("show"), 10);
        }).catch(error => console.error("Erro ao buscar detalhes do workshop:", error));
}




// Carregar dados ao carregar as páginas
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("tabelaColaboradores")) colaboradores();
    if (document.getElementById("tabelaWorkshop")) workshop();
});