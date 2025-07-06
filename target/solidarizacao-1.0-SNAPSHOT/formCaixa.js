document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("form-caixa");
  const cepInput = document.getElementById("cep");
  const mensagemErro = document.getElementById("mensagem-erro");

  // Máscara do CEP
  cepInput.addEventListener("input", function () {
    let valor = cepInput.value.replace(/\D/g, "");
    if (valor.length > 5) {
      valor = valor.substring(0, 5) + "-" + valor.substring(5, 8);
    }
    cepInput.value = valor;
  });

  // Validação e busca do endereço ao sair do campo CEP
  cepInput.addEventListener("blur", function () {
    const cep = cepInput.value.replace(/\D/g, "");

    if (!/^\d{8}$/.test(cep)) {
      mostrarErro("CEP inválido. Digite 8 números.");
      limparCamposEndereco();
      return;
    }

    buscarEndereco(cep);
  });

  async function buscarEndereco(cep) {
    try {
      const res = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
      const dados = await res.json();

      if (dados.erro) {
        mostrarErro("CEP não encontrado.");
        limparCamposEndereco();
        return;
      }

      esconderErro();

      document.getElementById("rua").value = dados.logradouro || "";
      document.getElementById("bairro").value = dados.bairro || "";
      document.getElementById("cidade").value = dados.localidade || "";
      document.getElementById("uf").value = dados.uf || "";

    } catch (error) {
      mostrarErro("Erro ao buscar o CEP.");
      limparCamposEndereco();
    }
  }

  function mostrarErro(msg) {
    mensagemErro.innerHTML = `<li>${msg}</li>`;
    mensagemErro.style.display = "block";
  }

  function esconderErro() {
    mensagemErro.textContent = "";
    mensagemErro.style.display = "none";
  }

  function limparCamposEndereco() {
    document.getElementById("rua").value = "";
    document.getElementById("bairro").value = "";
    document.getElementById("cidade").value = "";
    document.getElementById("uf").value = "";
  }

  // Validação do formulário antes de enviar
  form.addEventListener("submit", function (evt) {
    const camposObrigatorios = ["nome", "rua", "numero", "bairro", "telefone", "email", "cep", "complemento", "uf", "rede", "caixa"];
    const erros = [];

    for (let id of camposObrigatorios) {
      const campo = document.getElementById(id);
      if (!campo || campo.value.trim() === "") {
        erros.push(`O campo "${campo ? campo.previousElementSibling?.textContent.trim() || id : id}" deve ser preenchido.`);
      }
    }

    // Validação básica do email
    const email = document.getElementById("email").value.trim();
    if (email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
      erros.push("Email inválido.");
    }

    if (erros.length > 0) {
      evt.preventDefault();
      mensagemErro.innerHTML = erros.map(e => `<li>${e}</li>`).join("");
      mensagemErro.style.display = "block";
    } else {
      esconderErro();
      // Formulário será enviado normalmente para o servlet
    }
  });
});
