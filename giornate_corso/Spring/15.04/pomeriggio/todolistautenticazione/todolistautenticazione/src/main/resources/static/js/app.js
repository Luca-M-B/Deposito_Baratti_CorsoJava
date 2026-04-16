const API_URL = '';

let currentUser = localStorage.getItem('username');
let token = localStorage.getItem('token');

// Elements
const authView = document.getElementById('auth-view');
const appView = document.getElementById('app-view');
const userGreeting = document.getElementById('user-greeting');
const todoList = document.getElementById('todo-list');

// Auth Switch Logic
function showForm(type) {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');
    const loginTab = document.getElementById('login-tab');
    const registerTab = document.getElementById('register-tab');

    if (type === 'login') {
        loginForm.classList.remove('hidden');
        registerForm.classList.add('hidden');
        loginTab.classList.add('active');
        registerTab.classList.remove('active');
    } else {
        loginForm.classList.add('hidden');
        registerForm.classList.remove('hidden');
        loginTab.classList.remove('active');
        registerTab.classList.add('active');
    }
}

// Check Auth State
function checkAuth() {
    if (token) {
        authView.classList.add('hidden');
        appView.classList.remove('hidden');
        userGreeting.textContent = `Ciao, ${currentUser}!`;
        fetchTodos();
    } else {
        authView.classList.remove('hidden');
        appView.classList.add('hidden');
    }
}

// API Calls
async function login(e) {
    e.preventDefault();
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    try {
        const response = await fetch(`${API_URL}/auth/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.accessToken);
            localStorage.setItem('username', username);
            token = data.accessToken;
            currentUser = username;
            checkAuth();
        } else {
            showError('Credenziali non valide');
        }
    } catch (err) {
        showError('Errore di connessione');
    }
}

async function register(e) {
    e.preventDefault();
    const username = document.getElementById('reg-username').value;
    const password = document.getElementById('reg-password').value;
    const ruolo = document.getElementById('reg-ruolo').value;

    try {
        const response = await fetch(`${API_URL}/auth/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password, ruolo })
        });

        if (response.ok) {
            showMessage('Registrazione effettuata! Ora puoi loggare.');
            showForm('login');
        } else {
            const msg = await response.text();
            showError(msg || 'Errore durante la registrazione');
        }
    } catch (err) {
        showError('Errore di connessione');
    }
}

async function fetchTodos() {
    try {
        const response = await fetch(`${API_URL}/todo`, {
            headers: { 'Authorization': `Bearer ${token}` }
        });

        if (response.status === 401 || response.status === 403) {
            logout();
            return;
        }

        const todos = await response.json();
        renderTodos(todos);
    } catch (err) {
        showError('Impossibile caricare i ToDo');
    }
}

async function createTodo(e) {
    e.preventDefault();
    const nome = document.getElementById('todo-name').value;
    const descrizione = document.getElementById('todo-desc').value;

    try {
        const response = await fetch(`${API_URL}/todo`, {
            method: 'POST',
            headers: { 
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({ nome, descrizione, completato: false })
        });

        if (response.ok) {
            document.getElementById('todo-form').reset();
            fetchTodos();
        } else {
            showError('Errore nella creazione del ToDo');
        }
    } catch (err) {
        showError('Errore di connessione');
    }
}

async function toggleTodo(id, completato, nome, descrizione) {
    try {
        await fetch(`${API_URL}/todo/${id}`, {
            method: 'PUT',
            headers: { 
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({ nome, descrizione, completato: !completato })
        });
        fetchTodos();
    } catch (err) {
        showError('Errore nell\'aggiornamento');
    }
}

async function deleteTodo(id) {
    try {
        await fetch(`${API_URL}/todo/${id}`, {
            method: 'DELETE',
            headers: { 'Authorization': `Bearer ${token}` }
        });
        fetchTodos();
    } catch (err) {
        showError('Errore nell\'eliminazione');
    }
}

function renderTodos(todos) {
    todoList.innerHTML = '';
    todos.forEach(todo => {
        const card = document.createElement('div');
        card.className = `todo-card animate-slide-up ${todo.completato ? 'completed' : ''}`;
        card.innerHTML = `
            <h3>${todo.nome}</h3>
            <p class="subtitle-small">${todo.descrizione || ''}</p>
            <div class="actions">
                <button class="btn btn-sm btn-complete" onclick="toggleTodo(${todo.id}, ${todo.completato}, '${todo.nome}', '${todo.descrizione}')">
                    ${todo.completato ? 'Ripristina' : 'Completa'}
                </button>
                <button class="btn btn-sm btn-delete" onclick="deleteTodo(${todo.id})">Elimina</button>
            </div>
        `;
        todoList.appendChild(card);
    });
}

function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    token = null;
    currentUser = null;
    checkAuth();
}

function showError(msg) {
    const toast = document.getElementById('toast');
    toast.textContent = msg;
    toast.classList.remove('hidden');
    setTimeout(() => toast.classList.add('hidden'), 3000);
}

function showMessage(msg) {
    const msgEl = document.getElementById('auth-message');
    msgEl.textContent = msg;
    setTimeout(() => msgEl.textContent = '', 5000);
}

// Event Listeners
document.getElementById('login-form').addEventListener('submit', login);
document.getElementById('register-form').addEventListener('submit', register);
document.getElementById('todo-form').addEventListener('submit', createTodo);

// Init
checkAuth();
