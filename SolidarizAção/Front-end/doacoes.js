/*----------PREENCHER CEP----------*/
// Pega os parâmetros da URL
const params = new URLSearchParams(window.location.search);
const cep = params.get('cep');

// Preenche o campo se o CEP existir
if (cep) {
  document.addEventListener('DOMContentLoaded', () => {
  const cepInput = document.getElementById('cep');
  if (cepInput) {
    cepInput.value = cep;
    }
  });
}

/*--BOTAO VOLTAR--------------------------------------------------------*/
function voltarEtapa() {
  document.getElementById("step2").classList.remove("active");
  document.getElementById("step1").classList.add("active");
}

/*--BOTAO PROXIMO--------------------------------------------------------*/
function mostrarMensagem(erro, tipo = "erro") {
  const msg = document.getElementById("mensagem-erro");
  msg.textContent = erro;
  msg.className = tipo === "erro" ? "mensagem-erro erro" : "mensagem-erro sucesso";
  msg.style.display = "block";
}

function proximaEtapa() {
  const checkboxes = document.querySelectorAll('input[name="doacoes"]');
  const quantidades = document.querySelectorAll('.quantidade');
  const outro = document.getElementById("outroItem").value.trim();
  const msg = document.getElementById("mensagem-erro");
  msg.style.display = "none"; // Oculta mensagem ao tentar de novo
  let selecionado = false;

  for (let i = 0; i < checkboxes.length; i++) {
    if (checkboxes[i].checked) {
      const qtd = parseInt(quantidades[i].value);
      if (!qtd || qtd < 1) {
        mostrarMensagem(`Informe a quantidade para "${checkboxes[i].value}".`);
        quantidades[i].focus();
        return;
      }
      selecionado = true;
    }
  }

  if (!selecionado && outro === "") {
    mostrarMensagem("Por favor, selecione ao menos um item ou preencha o campo 'Outro'.");
    return;
  }

  if (outro !== "") {
    const qtdOutro = document.querySelectorAll('.quantidade')[checkboxes.length];
    if (!qtdOutro.value || parseInt(qtdOutro.value) < 1) {
      mostrarMensagem(`Informe a quantidade para o item "Outro".`);
      qtdOutro.focus();
      return;
    }
    selecionado = true;
  }

  // Se tudo estiver certo, avança
  document.getElementById("step1").classList.remove("active");
  document.getElementById("step2").classList.add("active");
}

/*----------ENVIAR FORMULARIO----------*/
function enviarFormulario(evt) {
  evt.preventDefault(); // Impede o envio automático do formulário

  const camposObrigatorios = ["nome", "rua", "numero", "bairro", "telefone", "email", "cep", "complemento"];
  const listaErros = [];

  for (let id of camposObrigatorios) {
    const campo = document.getElementById(id);
    if (campo.value.trim() === "") {
      listaErros.push(`O campo "${id}" deve ser preenchido.`);
    }
  }

  const caixaErros = document.getElementById("caixa-erros");
  caixaErros.innerHTML = ""; // Limpa erros anteriores

  if (listaErros.length > 0) {
    listaErros.forEach(erro => {
      caixaErros.innerHTML += `<li>${erro}</li>`;
    });
    return;
  }

  alert("Doação confirmada com sucesso! Obrigado por contribuir. Você será redirecionado para a página inicial.");
  document.getElementById("form-doacao").reset();
  document.getElementById("step2").classList.remove("active");
  document.getElementById("step1").classList.add("active");
  window.location.href = 'index.html';
}

document.getElementById("form-doacao").addEventListener("submit", enviarFormulario);

/*--NAVBAR COPIADA--------------------------------------------------*/
fetch('navbar.html')
  .then(res => res.text())
  .then(html => {
  document.getElementById('navbar').innerHTML = html;

  // Depois de carregar o HTML, carregar o script
  const script = document.createElement('script');
  script.src = 'navbar.js';
  document.body.appendChild(script);
});











document.addEventListener("DOMContentLoaded", function () {
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

  // Pega o CEP da URL
  const urlParams = new URLSearchParams(window.location.search);
  const cepRecebido = urlParams.get("cep");

  if (cepRecebido && /^\d{8}$/.test(cepRecebido)) {
    cepInput.value = cepRecebido.substring(0, 5) + "-" + cepRecebido.substring(5);
    buscarEndereco(cepRecebido);
  }

  // Quando sai do campo
  cepInput.addEventListener("blur", function () {
    const cep = cepInput.value.replace(/\D/g, "");

    if (!/^\d{8}$/.test(cep)) {
      mostrarErro("CEP inválido. Digite 8 números.");
      limparCamposEndereco();
      return;
    }

    buscarEndereco(cep);
  });

  // Busca o endereço
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
    mensagemErro.textContent = msg;
    mensagemErro.style.display = "block";
    mensagemErro.style.color = "red";
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

    // Máscara para o telefone
  const telefoneInput = document.getElementById("telefone");

  telefoneInput.addEventListener("input", function () {
    let valor = telefoneInput.value.replace(/\D/g, "");

    if (valor.length > 11) {
      valor = valor.substring(0, 11);
    }

    if (valor.length <= 10) {
      // Formato fixo: (99) 9999-9999
      telefoneInput.value = valor
        .replace(/^(\d{2})(\d)/, "($1) $2")
        .replace(/(\d{4})(\d)/, "$1-$2");
    } else {
      // Formato celular: (99) 99999-9999
      telefoneInput.value = valor
        .replace(/^(\d{2})(\d)/, "($1) $2")
        .replace(/(\d{5})(\d)/, "$1-$2");
    }
  });

});




