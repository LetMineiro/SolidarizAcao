/*----------EFEITO SCROLL----------*/
const header = document.querySelector('header');
const scrollTrigger = 150;

window.addEventListener('scroll', function () {
  if (window.scrollY > scrollTrigger) {
    header.classList.add('scrolled');
  } else {
    header.classList.remove('scrolled');
  }
});

/*----------MASCARA CEP----------*/
document.addEventListener("DOMContentLoaded", function () {
  const cepForm = document.getElementById("cepForm");
  const cepInput = document.getElementById("cep");
  const mensagemErro = document.getElementById("mensagem-erro");

  // Máscara automática: 00000-000
  cepInput.addEventListener("input", function () {
    let valor = cepInput.value.replace(/\D/g, "");

    if (valor.length > 5) {
      valor = valor.substring(0, 5) + "-" + valor.substring(5, 8);
    }

    cepInput.value = valor;
  });

  cepForm.addEventListener("submit", async function (e) {
    e.preventDefault(); // Impede o envio automático

    const cep = cepInput.value.replace(/\D/g, ""); // Tira traço e letras

    // Verificação 1: se não tiver 8 dígitos
    if (!/^\d{8}$/.test(cep)) {
      mostrarErro("Digite 8 números.");
      return;
    }

    try {
      const res = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
      const dados = await res.json();

      // Verificação 2: se o CEP não existir na API
      if (dados.erro) {
        mostrarErro("CEP não encontrado.");
        return;
      }

      // CEP válido e encontrado — agora sim redireciona
      window.location.href = `doações.html?cep=${cep}`;
    } catch (error) {
      mostrarErro("Erro ao buscar o CEP. Tente novamente.");
    }
  });

  function mostrarErro(msg) {
    mensagemErro.textContent = msg;
    mensagemErro.style.display = "block";
    mensagemErro.style.color = "red";
  }
});

