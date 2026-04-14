/**
 * TaskFlow - Logica Applicativa (Italiano)
 * Gestione reattiva di Utenti, Todo e Commenti
 */

const API = {
    todos: '/todo',
    users: '/utenti',
    comments: '/commenti'
};

let state = {
    users: [],
    todos: [],
    activeUserId: null
};

// Inizializzazione
document.addEventListener('DOMContentLoaded', async () => {
    console.log('🚀 TaskFlow in caricamento...');
    setupEventListeners();
    await refreshData();
});

async function refreshData() {
    await fetchUsers();
    await fetchTodos();
    renderUI();
}

// FETCH DATA
async function fetchUsers() {
    try {
        const res = await fetch(API.users);
        if (!res.ok) throw new Error('Errore caricamento utenti');
        state.users = await res.json();
    } catch (err) {
        showToast(err.message, 'error');
    }
}

async function fetchTodos() {
    try {
        let url = API.todos;
        if (state.activeUserId) {
            url = `${API.users}/${state.activeUserId}/todo`;
        }
        const res = await fetch(url);
        if (!res.ok) throw new Error('Errore caricamento task');
        state.todos = await res.json();
        
        // Carica i commenti per ogni todo (visto che sono stati svuotati dal JsonProperty WRITE_ONLY o simili)
        for (let todo of state.todos) {
            todo.commenti = await fetchCommentsForTodo(todo.id);
        }
    } catch (err) {
        showToast(err.message, 'error');
    }
}

async function fetchCommentsForTodo(todoId) {
    try {
        const res = await fetch(`${API.todos}/${todoId}/commenti`);
        return res.ok ? await res.json() : [];
    } catch {
        return [];
    }
}

// UI RENDERING
function renderUI() {
    renderUserBar();
    renderTodoGrid();
    populateUserSelects();
}

function renderUserBar() {
    const bar = document.getElementById('userBar');
    bar.innerHTML = '';
    
    // Chip "Tutti"
    const allChip = createChip({ id: null, nome: 'Tutti' }, state.activeUserId === null);
    bar.appendChild(allChip);

    state.users.forEach(user => {
        const chip = createChip(user, state.activeUserId === user.id);
        bar.appendChild(chip);
    });
}

function createChip(user, isActive) {
    const chip = document.createElement('div');
    chip.className = `user-chip ${isActive ? 'active' : ''}`;
    chip.innerHTML = `<i class="fas ${user.id ? 'fa-user' : 'fa-users'}"></i> ${user.nome}`;
    chip.onclick = () => {
        state.activeUserId = user.id;
        refreshData();
    };
    return chip;
}

function renderTodoGrid() {
    const grid = document.getElementById('todoGrid');
    if (state.todos.length === 0) {
        grid.innerHTML = '<div class="empty-state"><p>Nessuna missione trovata. Inizia ora!</p></div>';
        return;
    }

    grid.innerHTML = state.todos.map(todo => `
        <div class="glass-card todo-card">
            <div class="todo-header">
                <h3>${escapeHtml(todo.nome)}</h3>
                <span class="badge ${todo.completato ? 'badge-done' : 'badge-todo'}">
                    ${todo.completato ? 'COMPLETATA' : 'IN CORSO'}
                </span>
            </div>
            <p>${escapeHtml(todo.descrizione || 'Nessuna descrizione.')}</p>
            
            <div class="comments-section">
                <h4>Commenti (${todo.commenti?.length || 0})</h4>
                <div class="comments-list">
                    ${(todo.commenti || []).map(c => `<div class="comment-item">💬 ${escapeHtml(c.testo)}</div>`).join('')}
                </div>
                <div class="comment-input-group">
                    <input type="text" placeholder="Aggiungi un commento..." id="cmt-${todo.id}">
                    <button onclick="addComment(${todo.id})"><i class="fas fa-paper-plane"></i></button>
                </div>
            </div>

            <div class="todo-footer">
                <div class="actions">
                    <button onclick="editTodo(${todo.id})" title="Modifica"><i class="fas fa-edit"></i></button>
                    <button onclick="deleteTodo(${todo.id})" class="delete-btn" title="Elimina"><i class="fas fa-trash"></i></button>
                </div>
            </div>
        </div>
    `).join('');
}

function populateUserSelects() {
    const select = document.getElementById('taskUtente');
    select.innerHTML = '<option value="" disabled selected>Scegli un operativo...</option>';
    state.users.forEach(u => {
        const opt = document.createElement('option');
        opt.value = u.id;
        opt.textContent = u.nome;
        select.appendChild(opt);
    });
}

// EVENT HANDLERS
async function handleTodoSubmit(e) {
    e.preventDefault();
    const id = document.getElementById('taskId').value;
    const data = {
        nome: document.getElementById('taskNome').value,
        descrizione: document.getElementById('taskDesc').value,
        completato: document.getElementById('taskCompletato').checked,
        utente: { id: parseInt(document.getElementById('taskUtente').value) }
    };

    try {
        const method = id ? 'PUT' : 'POST';
        const url = id ? `${API.todos}/${id}` : API.todos;
        const res = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (!res.ok) throw new Error('Errore nel salvataggio del task');
        
        closeModal('taskModal');
        showToast(id ? 'Task aggiornato!' : 'Task creato!', 'success');
        refreshData();
    } catch (err) {
        showToast(err.message, 'error');
    }
}

async function handleUserSubmit(e) {
    e.preventDefault();
    const nome = document.getElementById('userNome').value;

    try {
        const res = await fetch(API.users, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome: nome })
        });

        if (!res.ok) throw new Error('Errore nella creazione dell\'utente');
        
        closeModal('userModal');
        showToast('Nuovo operativo reclutato!', 'success');
        refreshData();
    } catch (err) {
        showToast(err.message, 'error');
    }
}

async function addComment(todoId) {
    const input = document.getElementById(`cmt-${todoId}`);
    const testo = input.value.trim();
    if (!testo) return;

    try {
        const res = await fetch(API.comments, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                testo: testo,
                todo: { id: todoId }
            })
        });

        if (!res.ok) throw new Error('Errore nel salvataggio del commento');
        
        input.value = '';
        showToast('Commento aggiunto!');
        refreshData();
    } catch (err) {
        showToast(err.message, 'error');
    }
}

// DELETE/EDIT
async function deleteTodo(id) {
    if (!confirm('Sei sicuro? Questa azione è irreversibile.')) return;
    try {
        const res = await fetch(`${API.todos}/${id}`, { method: 'DELETE' });
        if (res.ok) {
            showToast('Missione eliminata.');
            refreshData();
        }
    } catch (err) {
        showToast('Errore eliminazione task', 'error');
    }
}

async function editTodo(id) {
    const todo = state.todos.find(t => t.id === id);
    if (!todo) return;
    
    document.getElementById('taskId').value = todo.id;
    document.getElementById('taskNome').value = todo.nome;
    document.getElementById('taskDesc').value = todo.descrizione || '';
    document.getElementById('taskCompletato').checked = todo.completato;
    document.getElementById('taskUtente').value = todo.utente?.id || '';
    document.getElementById('modalTitle').textContent = 'Modifica Missione';
    openTodoModal();
}

// MODAL CONTROLS
function openTodoModal() {
    document.getElementById('taskModal').style.display = 'flex';
}

function openUserModal() {
    document.getElementById('userModal').style.display = 'flex';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
    if (modalId === 'taskModal') {
        document.getElementById('taskForm').reset();
        document.getElementById('taskId').value = '';
        document.getElementById('modalTitle').textContent = 'Nuova Missione';
    } else {
        document.getElementById('userForm').reset();
    }
}

function setupEventListeners() {
    document.getElementById('taskForm').onsubmit = handleTodoSubmit;
    document.getElementById('userForm').onsubmit = handleUserSubmit;
}

function showToast(msg, type = 'success') {
    const toast = document.getElementById('toast');
    toast.textContent = msg;
    toast.className = `toast show ${type}`;
    setTimeout(() => { toast.className = 'toast'; }, 3000);
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

window.onclick = (e) => {
    if (e.target.className === 'modal') {
        e.target.style.display = 'none';
    }
};
