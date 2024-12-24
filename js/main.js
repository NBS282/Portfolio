/*
// Desactivar scroll con la rueda del mouse
window.addEventListener("wheel", (e) => {
  e.preventDefault();
}, { passive: false });

// Desactivar scroll con las teclas (opcional)
window.addEventListener("keydown", (e) => {
  const keys = ["ArrowUp", "ArrowDown", "PageUp", "PageDown", "Home", "End", " "];
  if (keys.includes(e.key)) {
    e.preventDefault();
  }
}); 
*/
// Detectar las secciones y flechas
const sections = document.querySelectorAll("section");
const snapContainer = document.querySelector(".snap-container");

// Función para actualizar las flechas según la sección actual
function updateArrows() {
  const windowHeight = window.innerHeight;

  let activeSection = null;

  // Detectar la sección visible en el centro de la ventana
  sections.forEach((section) => {
    const rect = section.getBoundingClientRect();
    if (rect.top <= windowHeight / 2 && rect.bottom >= windowHeight / 2) {
      activeSection = section;
    }
  });

  if (activeSection) {
    // Ocultar todas las flechas
    document.querySelectorAll(".arrow").forEach((arrow) => {
      arrow.style.display = "none";
    });

    // Mostrar la flecha correspondiente a la sección activa
    const arrow = activeSection.querySelector(".arrow-down");
    if (arrow) {
      arrow.style.display = "flex";
    }

    // Configurar la flecha de la última sección para redirigir al inicio
    if (activeSection.id === "contact") {
      const lastArrow = document.querySelector("#arrow-contact");
      if (lastArrow) {
        lastArrow.href = ".hero-section"; // Redirige al inicio
        lastArrow.style.display = "flex";
      }
    }
  }
}

// Evento de scroll en el contenedor
snapContainer.addEventListener("scroll", updateArrows);

// Inicializar las flechas en la carga de la página
document.addEventListener("DOMContentLoaded", () => {
  updateArrows();
});

// Scroll suave para flechas
document.querySelectorAll(".arrow").forEach((arrow) => {
  arrow.addEventListener("click", function (e) {
    e.preventDefault();

    // Desplazarse a la sección indicada por el href
    const targetSection = document.querySelector(this.getAttribute("href"));
    if (targetSection) {
      // Agregar un pequeño retraso para un desplazamiento más suave
      setTimeout(() => {
        targetSection.scrollIntoView({
          behavior: "smooth", // Desplazamiento suave
          block: "start",
        });
      }, 150); // Cambia este valor para ajustar el retraso si es necesario
    }
  });
});

// Detectar el botón de inicio
const homeButton = document.querySelector(".home-icon");

// Función para desplazarse al Hero Section
homeButton.addEventListener("click", (e) => {
  e.preventDefault(); // Evitar comportamiento predeterminado del enlace

  // Desplazarse suavemente a la sección Hero
  const heroSection = document.querySelector(".hero-section");
  if (heroSection) {
    heroSection.scrollIntoView({
      behavior: "smooth", // Scroll suave
    });
  }
});

function copyEmail() {
  const emailText = document.getElementById("email-text").innerText;
  const button = document.getElementById("copy-email-btn");

  navigator.clipboard
    .writeText(emailText)
    .then(() => {
      // Cambiar el texto del botón a "Copied ✅"
      button.innerHTML = "Copied ✅";

      // Restaurar el texto original después de 2 segundos
      setTimeout(() => {
        button.innerHTML = "Copy Email";
      }, 2000);
    })
    .catch((err) => {
      console.error("Failed to copy text: ", err);
    });
}


document.addEventListener("DOMContentLoaded", () => {
  const scrollAnimation = document.getElementById("scroll-animation");

  let isScrolling = false;

  // Detectar el inicio y el fin del scroll
  window.addEventListener("scroll", () => {
    if (!isScrolling) {
      scrollAnimation.style.display = "flex"; // Mostrar animación
      isScrolling = true;

      setTimeout(() => {
        scrollAnimation.style.display = "none"; // Ocultar animación
        isScrolling = false;
      }, 1000); // Duración de la animación
    }
  });
});


// Fondo de partículas con un cohete y fuego
const particleVertex = `
  attribute float scale;

  void main() {
    vec3 p = position;
    vec4 mvPosition = modelViewMatrix * vec4(p, 1.0);
    gl_PointSize = scale * 10.0 * (1.0 / -mvPosition.z);
    gl_Position = projectionMatrix * mvPosition;
  }
`;

const particleFragment = `
  void main() {
    gl_FragColor = vec4(0.7, 0.7, 1.2, 100); // Color azul claro con transparencia
  }
`;

class Canvas {
  constructor() {
    this.config = {
      canvas: document.querySelector('#c'),
      winWidth: window.innerWidth,
      winHeight: window.innerHeight,
      aspectRatio: window.innerWidth / window.innerHeight,
    };

    this.initCamera();
    this.initScene();
    this.initRenderer();
    this.initParticles();
    this.initShips();
    this.animate();

    window.addEventListener('resize', () => this.onResize());
  }

  initCamera() {
    this.camera = new THREE.PerspectiveCamera(
      75,
      this.config.aspectRatio,
      0.1,
      1000
    );
    this.camera.position.set(0, 0, 30);
  }

  initScene() {
    this.scene = new THREE.Scene();
  }

  initRenderer() {
    this.renderer = new THREE.WebGLRenderer({
      canvas: this.config.canvas,
      antialias: true,
    });
    this.renderer.setPixelRatio(window.devicePixelRatio);
    this.renderer.setSize(this.config.winWidth, this.config.winHeight);
    this.renderer.setClearColor(0x101010); // Fondo gris oscuro
  }

  initParticles() {
    const particleNum = 2000;
    const positions = new Float32Array(particleNum * 3);
    const velocities = new Float32Array(particleNum * 3);
    const scales = new Float32Array(particleNum);

    for (let i = 0; i < particleNum; i++) {
      positions[i * 3] = (Math.random() - 0.5) * 100;
      positions[i * 3 + 1] = (Math.random() - 0.5) * 100;
      positions[i * 3 + 2] = (Math.random() - 0.5) * 100;

      velocities[i * 3] = (Math.random() - 0.5) * 0.1;
      velocities[i * 3 + 1] = (Math.random() - 0.5) * 0.1;
      velocities[i * 3 + 2] = (Math.random() - 0.5) * 0.1;

      scales[i] = Math.random() * 0.5 + 3;
    }

    this.geometry = new THREE.BufferGeometry();
    this.geometry.setAttribute(
      'position',
      new THREE.BufferAttribute(positions, 3)
    );
    this.geometry.setAttribute(
      'velocity',
      new THREE.BufferAttribute(velocities, 3)
    );
    this.geometry.setAttribute('scale', new THREE.BufferAttribute(scales, 1));

    this.material = new THREE.ShaderMaterial({
      transparent: true,
      vertexShader: particleVertex,
      fragmentShader: particleFragment,
    });

    this.particles = new THREE.Points(this.geometry, this.material);
    this.scene.add(this.particles);
  }

  initShips() {
    this.ships = []; // Arreglo para almacenar naves

    const createShip = (geometry, material, position, speed, type) => {
      const ship = new THREE.Mesh(geometry, material);
      ship.position.set(position.x, position.y, position.z);
      this.ships.push({ mesh: ship, speed, type });
      this.scene.add(ship);
    };

    // Crear un ovni más realista
    const ufoBaseGeometry = new THREE.CylinderGeometry(2, 4, 0.5, 32);
    const ufoBaseMaterial = new THREE.MeshBasicMaterial({ color: 0x00ff00 });
    const ufoBase = new THREE.Mesh(ufoBaseGeometry, ufoBaseMaterial);

    const ufoDomeGeometry = new THREE.SphereGeometry(1.5, 32, 32);
    const ufoDomeMaterial = new THREE.MeshBasicMaterial({ color: 0xaaaaaa, transparent: true, opacity: 0.8 });
    const ufoDome = new THREE.Mesh(ufoDomeGeometry, ufoDomeMaterial);
    ufoDome.position.y = 0.5;

    const ufo = new THREE.Group();
    ufo.add(ufoBase);
    ufo.add(ufoDome);

    this.ships.push({ mesh: ufo, speed: 0.1, type: 'ufo' });
    this.scene.add(ufo);

    // Crear una nave nodriza
    const mothershipGeometry = new THREE.CylinderGeometry(4, 6, 2, 32);
    const mothershipMaterial = new THREE.MeshBasicMaterial({ color: 0x0000ff });
    createShip(
      mothershipGeometry,
      mothershipMaterial,
      { x: -30, y: -50, z: 0 },
      0.05,
      'mothership'
    );

    // Crear un cohete
    const rocketBodyGeometry = new THREE.CylinderGeometry(0.3, 0.3, 2, 32);
    const rocketBodyMaterial = new THREE.MeshBasicMaterial({ color: 0x808080 });
    const rocketBody = new THREE.Mesh(rocketBodyGeometry, rocketBodyMaterial);

    const rocketNoseGeometry = new THREE.ConeGeometry(0.3, 0.6, 32);
    const rocketNoseMaterial = new THREE.MeshBasicMaterial({ color: 0xff0000 });
    const rocketNose = new THREE.Mesh(rocketNoseGeometry, rocketNoseMaterial);
    rocketNose.position.y = 1.3;

    const rocketFinGeometry = new THREE.BoxGeometry(0.2, 0.5, 0.1);
    const rocketFinMaterial = new THREE.MeshBasicMaterial({ color: 0xff0000 });
    const rocketFins = [];
    for (let i = 0; i < 4; i++) {
      const fin = new THREE.Mesh(rocketFinGeometry, rocketFinMaterial);
      fin.position.set(
        Math.cos((i * Math.PI) / 2) * 0.35,
        -1,
        Math.sin((i * Math.PI) / 2) * 0.35
      );
      rocketFins.push(fin);
    }

    const rocket = new THREE.Group();
    rocket.add(rocketBody, rocketNose, ...rocketFins);

    this.ships.push({ mesh: rocket, speed: 0.2, type: 'rocket' });
    this.scene.add(rocket);
  }

  animateShips() {
    this.ships.forEach((ship) => {
      if (ship.mesh.position.y <= 50) {
        ship.mesh.position.y += ship.speed;

        // Comportamiento específico para ovni
        if (ship.type === 'ufo') {
          ship.mesh.rotation.z += 0.02; // Rotación
        }

        // Comportamiento específico para nave nodriza
        if (ship.type === 'mothership') {
          ship.mesh.position.x += Math.sin(ship.mesh.position.y * 0.05) * 0.5; // Movimiento ondulatorio
        }

        // Generar partículas de humo para el cohete
        if (ship.type === 'rocket') {
          const smokeParticle = new THREE.Mesh(
            new THREE.SphereGeometry(0.2, 8, 8),
            new THREE.MeshBasicMaterial({ color: 0x555555, transparent: true, opacity: 0.5 })
          );
          smokeParticle.position.set(
            ship.mesh.position.x,
            ship.mesh.position.y - 2.5,
            ship.mesh.position.z
          );
          this.scene.add(smokeParticle);

          // Animar humo
          const fadeSmoke = () => {
            smokeParticle.material.opacity -= 0.02;
            smokeParticle.position.y -= 0.05;
            if (smokeParticle.material.opacity <= 0) {
              this.scene.remove(smokeParticle);
            } else {
              requestAnimationFrame(fadeSmoke);
            }
          };
          fadeSmoke();
        }
      } else {
        // Reiniciar la posición cuando salen del escenario
        ship.mesh.position.y = -50;
        ship.mesh.position.x = (Math.random() - 0.5) * 100;
      }
    });
  }

  animateParticles() {
    const positions = this.geometry.attributes.position.array;
    const velocities = this.geometry.attributes.velocity.array;

    for (let i = 0; i < positions.length; i += 3) {
      positions[i] += velocities[i];
      positions[i + 1] += velocities[i + 1];
      positions[i + 2] += velocities[i + 2];

      if (positions[i] > 50 || positions[i] < -50) velocities[i] *= -1;
      if (positions[i + 1] > 50 || positions[i + 1] < -50) velocities[i + 1] *= -1;
      if (positions[i + 2] > 50 || positions[i + 2] < -50) velocities[i + 2] *= -1;
    }

    this.geometry.attributes.position.needsUpdate = true;
  }

  animate() {
    this.animateParticles();
    this.animateShips(); // Animar todas las naves
    this.renderer.render(this.scene, this.camera);
    requestAnimationFrame(() => this.animate());
  }

  onResize() {
    this.config.winWidth = window.innerWidth;
    this.config.winHeight = window.innerHeight;
    this.config.aspectRatio = this.config.winWidth / this.config.winHeight;

    this.camera.aspect = this.config.aspectRatio;
    this.camera.updateProjectionMatrix();

    this.renderer.setSize(this.config.winWidth, this.config.winHeight);
  }
}

new Canvas();


