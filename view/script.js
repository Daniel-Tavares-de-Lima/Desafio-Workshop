//----URL padrão----
const url = "http://localhost:8080";

//---APENAS PARA TESTE, VERIFICA OS DADOS
fetch(`${url}/colaboradores`).then(responde => responde.json()).then(data =>{
    console.log("Colaboradores DATA:", data).catch(error => console.error("Erro ao buscar workshop:", error))
 })



 
  