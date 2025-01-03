document.addEventListener("DOMContentLoaded", () => {
    const configSection = document.getElementById("config");
    const gameBoard = document.getElementById("game-board");
    gameBoard.style.display = "none";
    
    const winMessage = document.getElementById("win-message");
    winMessage.style.display = "none";
    const historyList = document.getElementById("history-list");
    const solutionList = document.getElementById("solution-list");
    historyList.style.display = "none";
    solutionList.style.display = "none";

    const historyBtn = document.getElementById("history-btn");
    const solutionBtn = document.getElementById("solution-btn");
    let isHistoryVisible = false;
    let isSolutionVisible = false;


    const helpBtn = document.getElementById("help-btn");
    const helpPopup = document.getElementById("help-popup");
    const closeHelpBtn = document.getElementById("close-help-btn");


    // Mostrar la ventana de ayuda
    helpBtn.addEventListener("click", () => {
        helpPopup.classList.remove("hidden");
    });

    // Cerrar la ventana de ayuda
    closeHelpBtn.addEventListener("click", () => {
        helpPopup.classList.add("hidden");
    });

    // Cerrar la ventana si se hace clic fuera del contenido
    helpPopup.addEventListener("click", (e) => {
        if (e.target === helpPopup) {
            helpPopup.classList.add("hidden");
        }
    });

    function updateHistory() {
        historyList.innerHTML = "";
        gameState.history.forEach(move => {
            const listItem = document.createElement("li");
            listItem.textContent = move;
            historyList.appendChild(listItem);
        });
    }

    function updateSolution() {
        solutionList.innerHTML = "";
        gameState.solution.forEach(step => {
            const listItem = document.createElement("li");
            listItem.textContent = step;
            solutionList.appendChild(listItem);
        });
    }

    function toggleList(button, list, state, target) {
        state = !state;
        if (state) {
            list.style.display = "block";
            button.textContent = `No mostrar ${target}`;
        } else {
            list.style.display = "none";
            button.textContent = `Mostrar ${target}`;
        }
        return state;
    }

    historyBtn.addEventListener("click", () => {
        isHistoryVisible = toggleList(historyBtn, historyList, isHistoryVisible, "historial");
    });

    solutionBtn.addEventListener("click", () => {
        isSolutionVisible = toggleList(solutionBtn, solutionList, isSolutionVisible, "solución");
    });

    document.getElementById("start-game").addEventListener("click", () => {
        gameBoard.style.display = "grid";
        startGame();
        configSection.classList.add("hidden");
    });

    document.getElementById("restart-btn").addEventListener("click", () => {
        configSection.classList.remove("hidden"); // Mostrar configuración
        startGame(); // Reiniciar el juego
    });

    let gameState = {
        matrix: [],
        history: [],
        solution: []
    };
    function startGame() {
        const rows = parseInt(document.getElementById("rows").value);
        const cols = parseInt(document.getElementById("cols").value);
        const levels = parseInt(document.getElementById("level").value);
        const errorMessage = document.getElementById("error-message");

        // Validación de las dimensiones
        if (rows < 3 || cols < 3) {
            errorMessage.textContent = "Las filas y columnas deben tener un mínimo de 3.";
            errorMessage.style.marginTop = "10px";
            errorMessage.style.color = "red";
            errorMessage.classList.remove("hidden");
            return;
        }

        if (rows > 9 || cols > 9) {
            errorMessage.textContent = "Las filas y columnas no pueden ser mayores de 9.";
            errorMessage.style.color = "red";
            errorMessage.classList.remove("hidden");

            return;
        }

        // Ocultar mensaje de error si la configuración es válida
        errorMessage.classList.add("hidden");

        // Ocultar mensaje de victoria
        winMessage.style.display = "none";
        winMessage.classList.add("hidden");

        // Reset panels for history and solution
        document.getElementById("history-list").innerHTML = "";
        document.getElementById("solution-list").innerHTML = "";

        // Reset game state
        gameState.history = [];
        gameState.solution = [];
        gameState.matrix = generateRandomMatrix(rows, cols, levels);

        console.log("Tablero inicial:", gameState.matrix);
        console.log("Nueva solución generada:", gameState.solution);

        // Renderizar el tablero
        renderBoard(gameState.matrix);

    }



    function generateRandomMatrix(rows, cols, levels) {
        const signs = ["-", "|", "\\", "/"];
        const colors = ["red", "blue"];
        let matrix = Array.from({ length: rows }, () =>
            Array.from({ length: cols }, () => ({
                sign: signs[Math.floor(Math.random() * signs.length)],
                color: colors[0] // Initial color set to 'red'
            }))
        );

        const levelsArray = [];
        const usedIndices = new Set();

        while (levelsArray.length < levels) {
            let row, col, key;
            do {
                row = Math.floor(Math.random() * rows);
                col = Math.floor(Math.random() * cols);
                key = `${row},${col}`;
            } while (usedIndices.has(key));

            usedIndices.add(key);
            levelsArray.push({ row, col });
        }

        gameState.solution = levelsArray.map(
            ({ row, col }) => `(${row + 1}, ${col + 1})`
        );

        // Apply moves to simulate the solution
        levelsArray.forEach(({ row, col }) => {
            matrix = applyMove(matrix, row, col);
        });

        // Ensure matrix is not already solved
        if (checkWinCondition(matrix)) {
            return generateRandomMatrix(rows, cols, levels);
        }

        return matrix;
    } function renderBoard(matrix) {
        const board = document.getElementById("game-board");
        board.innerHTML = "";
        board.style.gridTemplateRows = `repeat(${matrix.length}, 1fr)`;
        board.style.gridTemplateColumns = `repeat(${matrix[0].length}, 1fr)`;

        // Determinar el tamaño de las celdas según el tamaño del tablero
        const cellSize = matrix.length > 7 || matrix[0].length > 7 ? 40 : 60;

        matrix.forEach((row, rowIndex) => {
            row.forEach((cell, colIndex) => {
                const div = document.createElement("div");
                div.classList.add("cell", cell.color);
                div.textContent = cell.sign;
                div.style.width = `${cellSize}px`;
                div.style.height = `${cellSize}px`;
                div.addEventListener("click", () => makeMove(rowIndex, colIndex));
                board.appendChild(div);
            });
        });
    }


    function makeMove(row, col) {
        const moveKey = `(${row + 1}, ${col + 1})`;
        gameState.history.push(moveKey); // Permitir movimientos repetidos en el historial

        if (gameState.solution.includes(moveKey)) {
            gameState.solution = gameState.solution.filter(
                step => step !== moveKey
            );
        } else {
            gameState.solution.push(moveKey);
        }

        gameState.matrix = applyMove(gameState.matrix, row, col);
        renderBoard(gameState.matrix);

        updateHistory(); // Actualizar historial
        updateSolution(); // Actualizar soluciones

        if (checkWinCondition(gameState.matrix)) {
            displayWinMessage();
        }
    }
    function displayWinMessage() {
        const mainContent = document.querySelector("main"); // Selecciona el contenido principal
        const header = document.querySelector("header"); // También puede incluir el header
        const footer = document.querySelector("footer"); // Y el footer si aplica

        // Aplicar desenfoque
        mainContent.classList.add("blur-background");
        header.classList.add("blur-background");
        footer.classList.add("blur-background");

        // Mostrar mensaje de victoria
        winMessage.style.display = "block";
        winMessage.classList.remove("hidden");

        // Crear fuegos artificiales
        generateFireworks();

        // Remover desenfoque y mensaje después de 3 segundos
        setTimeout(() => {
            mainContent.classList.remove("blur-background");
            header.classList.remove("blur-background");
            footer.classList.remove("blur-background");
            winMessage.classList.add("hidden");
            winMessage.style.display = "none";
        }, 3000);
    }

    function generateFireworks() {
        const fireworksContainer = document.createElement("div");
        fireworksContainer.classList.add("fireworks-container");
        document.body.appendChild(fireworksContainer);

        for (let i = 0; i < 20; i++) {
            const firework = document.createElement("div");
            firework.classList.add("firework");
            firework.style.top = `${Math.random() * 100}%`;
            firework.style.left = `${Math.random() * 100}%`;
            firework.style.backgroundColor = getRandomColor();
            fireworksContainer.appendChild(firework);

            // Remover los fuegos artificiales después de la animación
            setTimeout(() => {
                firework.remove();
            }, 1500);
        }

        // Remover el contenedor después de los fuegos artificiales
        setTimeout(() => {
            fireworksContainer.remove();
        }, 2000);
    }

    function getRandomColor() {
        const colors = ["#ff0000", "#00ff00", "#0000ff", "#ffff00", "#ff00ff", "#00ffff"];
        return colors[Math.floor(Math.random() * colors.length)];
    }



    function applyMove(matrix, row, col) {
        const cell = matrix[row][col];
        switch (cell.sign) {
            case "-":
                return paintHorizontal(matrix, row);
            case "|":
                return paintVertical(matrix, col);
            case "\\":
                return paintDiagonalLeft(matrix, row, col);
            case "/":
                return paintDiagonalRight(matrix, row, col);
            default:
                return matrix;
        }
    }

    function paintHorizontal(matrix, row) {
        return matrix.map((r, i) =>
            i === row
                ? r.map(cell => ({
                    ...cell,
                    color: toggleColor(cell.color)
                }))
                : r
        );
    }

    function paintVertical(matrix, col) {
        return matrix.map(row =>
            row.map((cell, j) =>
                j === col
                    ? {
                        ...cell,
                        color: toggleColor(cell.color)
                    }
                    : cell
            )
        );
    }

    function paintDiagonalLeft(matrix, row, col) {
        const newMatrix = JSON.parse(JSON.stringify(matrix));
        for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            newMatrix[i][j].color = toggleColor(newMatrix[i][j].color);
        }
        for (let i = row + 1, j = col + 1; i < matrix.length && j < matrix[0].length; i++, j++) {
            newMatrix[i][j].color = toggleColor(newMatrix[i][j].color);
        }
        return newMatrix;
    }

    function paintDiagonalRight(matrix, row, col) {
        const newMatrix = JSON.parse(JSON.stringify(matrix));
        for (let i = row, j = col; i >= 0 && j < matrix[0].length; i--, j++) {
            newMatrix[i][j].color = toggleColor(newMatrix[i][j].color);
        }
        for (let i = row + 1, j = col - 1; i < matrix.length && j >= 0; i++, j--) {
            newMatrix[i][j].color = toggleColor(newMatrix[i][j].color);
        }
        return newMatrix;
    }

    function toggleColor(color) {
        return color === "red" ? "blue" : "red";
    }

    function checkWinCondition(matrix) {
        const firstColor = matrix[0][0].color;
        return matrix.every(row => row.every(cell => cell.color === firstColor));
    }

    function showHistory() {
        const historyList = document.getElementById("history-list");
        historyList.innerHTML = ""; // Limpiar historial previo

        if (gameState.history.length === 0) {
            historyList.innerHTML = "<li>No hay jugadas en el historial.</li>";
            return;
        }

        gameState.history.forEach(move => {
            const listItem = document.createElement("li");
            listItem.textContent = move;
            historyList.appendChild(listItem);
        });
    }

    function showSolution() {
        const solutionList = document.getElementById("solution-list");
        solutionList.innerHTML = ""; // Limpiar solución previa

        if (gameState.solution.length === 0) {
            solutionList.innerHTML = "<li>No hay solución generada.</li>";
            return;
        }

        gameState.solution.forEach(step => {
            const listItem = document.createElement("li");
            listItem.textContent = step;
            solutionList.appendChild(listItem);
        });
    }

    // Event listeners para los botones de historial y solución
    document.getElementById("history-btn").addEventListener("click", showHistory);
    document.getElementById("solution-btn").addEventListener("click", showSolution);
});
