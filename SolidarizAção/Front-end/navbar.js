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