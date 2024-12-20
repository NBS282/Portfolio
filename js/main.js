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

// Animar elementos al hacer clic
const animatedElements = document.querySelectorAll('.animated-element');

animatedElements.forEach((element) => {
	element.addEventListener('click', () => {
		element.style.transform = 'scale(1.5) rotate(0deg)';
		setTimeout(() => {
			element.style.transform = 'scale(1)';
		}, 200); // Duración del efecto
	});
});

// Detectar el botón de inicio
const homeButton = document.querySelector('.home-icon');

// Función para desplazarse al Hero Section
homeButton.addEventListener('click', (e) => {
	e.preventDefault(); // Evitar comportamiento predeterminado del enlace

	// Desplazarse suavemente a la sección Hero
	const heroSection = document.querySelector('.hero-section');
	if (heroSection) {
		heroSection.scrollIntoView({
			behavior: 'smooth', // Scroll suave
		});
	}
});

// Detectar las flechas de navegación
const arrows = document.querySelectorAll('.arrow');

arrows.forEach((arrow) => {
	arrow.addEventListener('click', (e) => {
		e.preventDefault();

		const isArrowDown = arrow.classList.contains('arrow-down');
		const currentSection = document.elementFromPoint(window.innerWidth / 2, window.innerHeight / 2).closest('section');
		let targetSection;

		if (isArrowDown) {
			// Ir a la siguiente sección
			targetSection = currentSection.nextElementSibling;
		} else {
			// Ir a la sección anterior
			targetSection = currentSection.previousElementSibling;
		}

		if (targetSection) {
			targetSection.scrollIntoView({
				behavior: 'smooth',
			});
		}
	});
});

// Fondo de partículas con Three.js
const particleVertex = `
	attribute float scale;
	uniform float uTime;
  
	void main() {
	  vec3 p = position;
	  float s = scale;
  
	  p.y += (sin(p.x + uTime) * 0.5) + (cos(p.y + uTime) * 0.1) * 2.0;
	  p.x += (sin(p.y + uTime) * 0.5);
	  s += (sin(p.x + uTime) * 0.5) + (cos(p.y + uTime) * 0.1) * 2.0;
  
	  vec4 mvPosition = modelViewMatrix * vec4(p, 1.0);
	  gl_PointSize = s * 15.0 * (1.0 / -mvPosition.z);
	  gl_Position = projectionMatrix * mvPosition;
	}
  `;

const particleFragment = `
	void main() {
	  gl_FragColor = vec4(1.0, 1.0, 1.0, 0.5);
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

		this.animate();
	}

	initCamera() {
		this.camera = new THREE.PerspectiveCamera(
			75,
			this.config.aspectRatio,
			0.01,
			1000
		);
		this.camera.position.set(0, 6, 5);
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
	}

	initParticles() {
		const amountX = 200;
		const amountY = 200;
		const particleNum = amountX * amountY;
		const positions = new Float32Array(particleNum * 3);
		const scales = new Float32Array(particleNum);
		let i = 0,
			j = 0;

		for (let x = 0; x < amountX; x++) {
			for (let y = 0; y < amountY; y++) {
				positions[i] = x * 0.3 - (amountX * 0.3) / 2;
				positions[i + 1] = 0;
				positions[i + 2] = y * 0.3 - (amountY * 0.3) / 2;
				scales[j] = 1;
				i += 3;
				j++;
			}
		}

		this.geometry = new THREE.BufferGeometry();
		this.geometry.setAttribute(
			'position',
			new THREE.BufferAttribute(positions, 3)
		);
		this.geometry.setAttribute(
			'scale',
			new THREE.BufferAttribute(scales, 1)
		);

		this.material = new THREE.ShaderMaterial({
			transparent: true,
			vertexShader: particleVertex,
			fragmentShader: particleFragment,
			uniforms: {
				uTime: { value: 0 },
			},
		});

		this.particles = new THREE.Points(this.geometry, this.material);
		this.scene.add(this.particles);
	}

	animate() {
		this.material.uniforms.uTime.value += 0.05;
		this.renderer.render(this.scene, this.camera);
		requestAnimationFrame(() => this.animate());
	}
}

new Canvas();
