
// Función para obtener los productos del carrito desde el almacenamiento local
function obtenerProductosDelCarrito() {
  const productosEnCarrito = localStorage.getItem('productosEnCarrito');
  if (productosEnCarrito) {
    return JSON.parse(productosEnCarrito);
  } else {
    return [];
  }
}

// Contadores para los botones "Agregar al carrito"
const counters = {};

document.addEventListener("DOMContentLoaded", function () {
  var swiper = new Swiper(".swiper-container", {
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
    autoplay: {
      delay: 4000,
      disableOnInteraction: false,
    },
  });

  cargarEventListeners();
});

function cargarEventListeners() {
  const elementos1 = document.getElementById('lista-1');
  const elementos2 = document.getElementById('lista-2');
  const carrito = document.getElementById('carrito');
  const lista = document.querySelector('#lista-carrito tbody');
  const vaciarCarritoBtn = document.getElementById('vaciar-carrito');
  const comprarBtn = document.querySelector('.btn-4'); // Botón de "Realizar compra"

  elementos1.addEventListener('click', agregarAlCarrito);
  elementos2.addEventListener('click', agregarAlCarrito);
  carrito.addEventListener('click', eliminarCarrito);
  vaciarCarritoBtn.addEventListener('click', vaciarCarrito);
  comprarBtn.addEventListener('click', redireccionarVistaDatosCliente);
}

function agregarAlCarrito(e) {
  e.preventDefault();
  if (e.target.classList.contains('agregar-carrito')) {
    const elemento = e.target.parentElement.parentElement;
    const id = elemento.querySelector('.agregar-carrito').getAttribute('data-id');
    incrementarContador(id);
    leerDatosElemento(elemento);
  }
}

function incrementarContador(id) {
  if (counters[id]) {
    counters[id]++;
  } else {
    counters[id] = 1;
  }
}

function leerDatosElemento(elemento) {
  const infoElemento = {
    imagen: elemento.querySelector('img').src,
    titulo: elemento.querySelector('h3').textContent,
    precio: elemento.querySelector('.precio').textContent,
    id: elemento.querySelector('.agregar-carrito').getAttribute('data-id')
  };
  insertarCarrito(infoElemento);
}

function insertarCarrito(elemento) {
  const lista = document.querySelector('#lista-carrito tbody');
  const row = document.createElement('tr');
  row.innerHTML = `
    <td><img src='${elemento.imagen}' width=100></td>
    <td>${elemento.titulo}</td>
    <td>${elemento.precio}</td>
    <td><a href="#" class="borrar" data-id="${elemento.id}">x</a></td>`;
  lista.appendChild(row);

  const productosEnCarrito = obtenerProductosDelCarrito() || [];
  productosEnCarrito.push(elemento);
  localStorage.setItem('productosEnCarrito', JSON.stringify(productosEnCarrito));
}

function eliminarCarrito(e) {
  e.preventDefault();
  if (e.target.classList.contains('borrar')) {
    const elemento = e.target.parentElement.parentElement;
    elemento.remove();
  }
}

function vaciarCarrito() {
  const lista = document.querySelector('#lista-carrito tbody');
  while (lista.firstChild) {
    lista.removeChild(lista.firstChild);
  }
  return false;
}

function redireccionarVistaDatosCliente(e) {
  e.preventDefault();

  const listaCarrito = document.querySelector('#lista-carrito tbody');
  if (listaCarrito.children.length === 0) {
    alert('El carrito está vacío. Agrega productos antes de realizar la compra.');
    return;
  }

  const url = `http://localhost:8080/zoologico/entradas2?contadores=${encodeURIComponent(JSON.stringify(counters))}`;
  window.location.href = url;
}

document.addEventListener('DOMContentLoaded', function () {
  const agregarCarritoButtons = document.querySelectorAll('.agregar-carrito');
  const mensajeAgregado = document.getElementById('mensaje-agregado');

  agregarCarritoButtons.forEach(button => {
    button.addEventListener('click', function () {
      // Aquí puedes realizar las operaciones de agregar al carrito
      // ...

      // Mostrar el mensaje de notificación
      mensajeAgregado.style.display = 'block';
      setTimeout(() => {
        mensajeAgregado.style.display = 'none';
      }, 2000); // Ocultar el mensaje después de 2 segundos
    });
  });
});

