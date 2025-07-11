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