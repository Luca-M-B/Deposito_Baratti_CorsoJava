const API_URL = '/todo';
const todoListElement = document.getElementById('todo-list');
const todoForm = document.getElementById('todo-form');

// Fetch all task on load
document.addEventListener('DOMContentLoaded', fetchTodos);

async function fetchTodos() {
    try {
        const response = await fetch(API_URL);
        const todos = await response.json();
        renderTodos(todos);
    } catch (error) {
        console.error('Errore nel recupero dei todo:', error);
        todoListElement.innerHTML = `<p style="color: var(--danger); text-align: center;">Impossibile caricare l'agenda.</p>`;
    }
}

function renderTodos(todos) {
    if (todos.length === 0) {
        todoListElement.innerHTML = `
            <div style="text-align: center; color: var(--text-muted); padding: 40px;">
                <i data-lucide="clipboard-list" style="width: 48px; height: 48px; margin-bottom: 12px; opacity: 0.5;"></i>
                <p>Nessun task in agenda. Inizia aggiungendone uno!</p>
            </div>
        `;
        lucide.createIcons();
        return;
    }

    todoListElement.innerHTML = '';
    todos.forEach(todo => {
        const item = document.createElement('div');
        item.className = 'todo-item';
        item.innerHTML = `
            <div class="todo-content">
                <div class="todo-header">
                    <span class="todo-title">${todo.titolo}</span>
                    <span class="badge badge-priority-${todo.priorita}">${todo.priorita}</span>
                    <span class="badge badge-status-${todo.stato}">${todo.stato.replace('_', ' ')}</span>
                </div>
                <p class="todo-description">${todo.descrizione || 'Nessuna descrizione.'}</p>
            </div>
            <div class="todo-actions">
                <button class="action-btn edit" onclick="updateStatus(${todo.id}, '${todo.stato}')" title="Avanza Stato">
                    <i data-lucide="arrow-right-circle"></i>
                </button>
                <button class="action-btn delete" onclick="deleteTodo(${todo.id})" title="Elimina">
                    <i data-lucide="trash-2"></i>
                </button>
            </div>
        `;
        todoListElement.appendChild(item);
    });
    lucide.createIcons();
}

// Add new todo
todoForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const nuevoToDo = {
        titolo: document.getElementById('titolo').value,
        descrizione: document.getElementById('descrizione').value,
        priorita: document.getElementById('priorita').value,
        stato: document.getElementById('stato').value
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoToDo)
        });

        if (response.ok) {
            todoForm.reset();
            fetchTodos();
        }
    } catch (error) {
        console.error('Errore nella creazione del todo:', error);
    }
});

// Delete todo
async function deleteTodo(id) {
    if (!confirm('Sei sicuro di voler eliminare questo task?')) return;
    
    try {
        await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        fetchTodos();
    } catch (error) {
        console.error('Errore nell\'eliminazione:', error);
    }
}

// Simple state advancement logic for demonstration
async function updateStatus(id, currentStatus) {
    let nextStatus = '';
    
    if (currentStatus === 'TO_DO') nextStatus = 'IN_PROGRESS';
    else if (currentStatus === 'IN_PROGRESS') nextStatus = 'DONE';
    else if (currentStatus === 'DONE') return; // No advancement from DONE
    else return;

    try {
        // Fetch current todo to get full object (or just send partial if backend supports it)
        // Here we send partial based on our update logic in ToDoService
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ stato: nextStatus })
        });

        if (response.ok) {
            fetchTodos();
        } else {
            const err = await response.json();
            alert(err.message || 'Errore nell\'aggiornamento dello stato');
        }
    } catch (error) {
        console.error('Errore nell\'aggiornamento:', error);
    }
}
