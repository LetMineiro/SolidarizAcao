document.addEventListener("DOMContentLoaded", () => {
  fetch("perfil")
    .then(res => res.json())
    .then(data => {
      document.getElementById("nomeUsuario").textContent = `Olá, ${data.nome}`;
      document.getElementById("infoUsuario").innerHTML = `
        <li><strong>Email:</strong> ${data.email}</li>
        <li><strong>Telefone:</strong> ${data.telefone}</li>
        <li><strong>Cidade:</strong> ${data.cidade}</li>
      `;
      document.getElementById("listaCampanhas").innerHTML = data.campanhas.map(c => `<li>${c}</li>`).join("");
      document.getElementById("listaDoacoes").innerHTML = data.doacoes.map(d => `<li>${d}</li>`).join("");
    })
    .catch(err => {
      window.location.href = "login.html";
    });
});

function logout() {
  fetch("logout", { method: "POST" })
    .then(() => window.location.href = "login.html");
}