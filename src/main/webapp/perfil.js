document.addEventListener("DOMContentLoaded", () => {
    fetch("perfil")
            .then(res => {
                if (!res.ok) {
                    if (res.status === 401) {
                        window.location.href = "login.html";
            } else {
                // Outros erros do servidor (ex: erro 500)
                console.error("Erro no servidor:", res.status);
                alert("Erro ao carregar o perfil. Tente novamente mais tarde.");
            }
            return null;
        }
        return res.json();
    })
            .then(data => {
                if (!data) return; // já tratado

        document.getElementById("nomeUsuario").textContent = `Olá, ${data.nome}`;
        document.getElementById("infoUsuario").innerHTML = `
        <li><strong>Email:</strong> ${data.email}</li>
        <li><strong>Telefone:</strong> ${data.telefone}</li>
        <li><strong>Cidade:</strong> ${data.cidade}</li>
      `;
        if (data.campanhas && Array.isArray(data.campanhas)) {
            document.getElementById("listaCampanhas").innerHTML = data.campanhas.map(c => `<li>${c}</li>`).join("");
        } else {
            document.getElementById("listaCampanhas").innerHTML = "<li>Você ainda não participou de campanhas.</li>";
        }

        if (data.doacoes && Array.isArray(data.doacoes)) {
            document.getElementById("listaDoacoes").innerHTML = data.doacoes.map(d => `<li>${d}</li>`).join("");
        } else {
            document.getElementById("listaDoacoes").innerHTML = "<li>Você ainda não realizou doações.</li>";
        }
    })
            .catch(err => {
                console.error("Erro inesperado:", err);
        alert("Erro de conexão. Verifique sua internet ou tente novamente.");
    });
});