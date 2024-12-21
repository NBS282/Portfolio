
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

// Scroll suave para enlaces de anclaje
document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
	anchor.addEventListener("click", function (e) {
		e.preventDefault();
		const targetId = this.getAttribute("href");
		document.querySelector(targetId).scrollIntoView({
			behavior: "smooth",
		});
	});
});

// Configuración de las flechas para cada sección
const arrows = document.querySelectorAll(".arrow-down");

// Función para mostrar/ocultar flechas según la sección actual
arrows.forEach((arrow) => {
	arrow.addEventListener("click", function () {
		// Ocultar la flecha actual
		arrow.style.display = "none";

		// Mostrar la siguiente flecha
		const nextArrowId = this.getAttribute("data-next-arrow");
		if (nextArrowId) {
			const nextArrow = document.getElementById(nextArrowId);
			if (nextArrow) {
				nextArrow.style.display = "flex";
			}
		}

		// Reiniciar flechas al llegar al final
		if (arrow.id === "arrow-contact") {
			// Desplazarse suavemente a la sección Hero
			const heroSection = document.querySelector(".hero-section");
			if (heroSection) {
				heroSection.scrollIntoView({
					behavior: "smooth", // Scroll suave
				});
			}
			resetArrows();
		}
	});
});

// Función para reiniciar flechas al estado inicial
function resetArrows() {
	// Ocultar todas las flechas
	arrows.forEach((arrow) => {
		arrow.style.display = "none";
	});

	// Mostrar la flecha inicial
	const initialArrow = document.getElementById("arrow-home");
	if (initialArrow) {
		initialArrow.style.display = "flex";
	}
}

// Animar elementos al hacer clic
const animatedElements = document.querySelectorAll(".animated-element");

animatedElements.forEach((element) => {
	element.addEventListener("click", () => {
		element.style.transform = "scale(1.5) rotate(0deg)";
		setTimeout(() => {
			element.style.transform = "scale(1)";
		}, 200); // Duración del efecto
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

document.addEventListener("keydown", (event) => {
	// Detectar la tecla presionada (ArrowUp o ArrowDown)
	if (event.key === "ArrowDown" || event.key === "ArrowUp") {
		event.preventDefault();

		// Obtener la sección actualmente visible en la ventana
		const currentSection = document
			.elementFromPoint(window.innerWidth / 2, window.innerHeight / 2)
			.closest("section");

		let targetSection;

		if (event.key === "ArrowDown") {
			// Mover hacia abajo
			targetSection = currentSection.nextElementSibling;
		} else if (event.key === "ArrowUp") {
			// Mover hacia arriba
			targetSection = currentSection.previousElementSibling;
		}

		// Si existe la sección objetivo, hacer scroll hacia ella
		if (targetSection) {
			targetSection.scrollIntoView({
				behavior: "smooth",
				block: "start",
			});
		}
	}
});

function copyEmail() {
	const emailText = document.getElementById("email-text").innerText;
	navigator.clipboard
		.writeText(emailText)
		.then(() => {
			//alert("Email copied to clipboard!");
		})
		.catch((err) => {
			//console.error("Failed to copy text: ", err);
		});
}

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
    this.initRocket();

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

  initRocket() {
    const rocketGeometry = new THREE.ConeGeometry(0.5, 2, 16);
    const rocketMaterial = new THREE.MeshBasicMaterial({ color: 0xff0000 });
    this.rocket = new THREE.Mesh(rocketGeometry, rocketMaterial);
    this.scene.add(this.rocket);
	


    const flameGeometry = new THREE.ConeGeometry(0.2, 1, 16);
    const flameMaterial = new THREE.MeshBasicMaterial({ color: 0xffa500 });
    this.flame = new THREE.Mesh(flameGeometry, flameMaterial);
    this.scene.add(this.flame);

    this.rocket.position.set(0, -50, 0);
    this.flame.position.set(0, -51, 0);

    this.rocketSpeed = 0.2;
    this.rocketTimer = 0;
    this.rocketInterval = 30 * 60; 
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

  animateRocket() {
    if (this.rocketTimer === this.rocketInterval) {
      this.rocket.position.y = -50;
      this.rocket.position.x = (Math.random() - 0.5) * 100;
      this.flame.position.x = this.rocket.position.x;
      this.rocketTimer = 0;
    }

    if (this.rocket.position.y <= 50) {
      this.rocket.position.y += this.rocketSpeed;
      this.flame.position.y = this.rocket.position.y - 2;
    }

    this.rocketTimer++;
  }

  animate() {
    this.animateParticles();
    this.animateRocket();
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


