const API_BASE = '/api';

let allIngredients = [];
let allUsers = [];
let selectedIngredients = [];
let pizzasInOrder = [];
let currentBasePrice = 4.5;
let isAdminMode = false;

document.addEventListener('DOMContentLoaded', () => {
    fetchUsers();
    fetchIngredients();
    fetchOrders();
    updateTotal();
    
    document.getElementById('user-select').addEventListener('change', (e) => {
        const userId = e.target.value;
        const user = allUsers.find(u => u.id == userId);
        toggleAdminMode(user && user.admin);
    });
});

function toggleAdminMode(admin) {
    isAdminMode = !!admin;
    const adminSection = document.getElementById('admin-section');
    const orderSection = document.getElementById('order-section');
    const orderSummary = document.getElementById('order-summary');
    
    if (isAdminMode) {
        adminSection.style.display = 'block';
        orderSection.style.display = 'none';
        orderSummary.style.display = 'none';
    } else {
        adminSection.style.display = 'none';
        orderSection.style.display = 'block';
        orderSummary.style.display = 'block';
    }
    renderIngredients(); // Re-render to show/hide delete buttons
}

// --- Fetching Data ---

async function fetchUsers() {
    try {
        const response = await fetch(`${API_BASE}/utenti`);
        allUsers = await response.json();
        const select = document.getElementById('user-select');
        select.innerHTML = '<option value="">Seleziona Utente...</option>';
        allUsers.forEach(u => {
            const opt = document.createElement('option');
            opt.value = u.id;
            opt.textContent = `${u.nome} ${u.admin ? '(Admin)' : ''}`;
            select.appendChild(opt);
        });
    } catch (err) { console.error('Error fetching users:', err); }
}

async function fetchIngredients() {
    try {
        const response = await fetch(`${API_BASE}/ingredienti`);
        allIngredients = await response.json();
        renderIngredients();
    } catch (err) { console.error('Error fetching ingredients:', err); }
}

async function fetchOrders() {
    try {
        const response = await fetch(`${API_BASE}/ordini`);
        const orders = await response.json();
        renderOrders(orders);
    } catch (err) { console.error('Error fetching orders:', err); }
}

// --- Rendering ---

function renderIngredients() {
    const list = document.getElementById('ingredient-list');
    list.innerHTML = '';
    allIngredients.forEach(ing => {
        const item = document.createElement('div');
        item.className = 'ingredient-item';
        if (isAdminMode) {
            item.style.position = 'relative';
            item.innerHTML = `
                ${ing.nome} <span class="price">€ ${ing.prezzo.toFixed(2)}</span>
                <span onclick="deleteIngredient(event, ${ing.id})" style="position: absolute; top: 5px; right: 5px; color: var(--accent-primary); cursor: pointer; font-size: 1.2rem;">×</span>
            `;
        } else {
            item.innerHTML = `${ing.nome} <span class="price">€ ${ing.prezzo.toFixed(2)}</span>`;
            item.onclick = () => toggleIngredient(ing.id, item);
        }
        list.appendChild(item);
    });
}

function renderOrders(orders) {
    const list = document.getElementById('orders-list');
    list.innerHTML = '';
    if (orders.length === 0) {
        list.innerHTML = '<p style="color: var(--text-muted); text-align: center;">Nessun ordine trovato</p>';
        return;
    }
    orders.slice().reverse().forEach(o => {
        const div = document.createElement('div');
        div.className = 'order-card';
        div.innerHTML = `
            <div style="display: flex; justify-content: space-between; margin-bottom: 0.5rem">
                <strong>${o.utente ? o.utente.nome : 'Anonimo'}</strong>
                <span style="color: var(--accent-secondary)">€ ${o.prezzoTotale.toFixed(2)}</span>
            </div>
            <div style="font-size: 0.85rem; color: var(--text-muted)">
                ${o.listaPizze.map(p => p.nome).join(', ')}
            </div>
        `;
        list.appendChild(div);
    });
}

// --- Logic ---

async function addIngredient() {
    const name = document.getElementById('new-ingredient-name').value;
    const price = parseFloat(document.getElementById('new-ingredient-price').value);
    
    if (!name || isNaN(price)) {
        alert('Inserisci nome e prezzo validi!');
        return;
    }
    
    try {
        await fetch(`${API_BASE}/ingredienti`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome: name, prezzo: price })
        });
        document.getElementById('new-ingredient-name').value = '';
        document.getElementById('new-ingredient-price').value = '';
        fetchIngredients();
    } catch (err) { console.error('Error adding ingredient:', err); }
}

async function deleteIngredient(event, id) {
    event.stopPropagation();
    if (!confirm('Sei sicuro di voler eliminare questo ingrediente?')) return;
    
    try {
        const response = await fetch(`${API_BASE}/ingredienti/${id}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            fetchIngredients();
        } else {
            alert('Impossibile eliminare l\'ingrediente (potrebbe essere usato in degli ordini)');
        }
    } catch (err) { console.error('Error deleting ingredient:', err); }
}

function toggleIngredient(id, element) {
    const idx = selectedIngredients.findIndex(i => i.id === id);
    if (idx > -1) {
        selectedIngredients.splice(idx, 1);
        element.classList.remove('selected');
    } else {
        const ing = allIngredients.find(i => i.id === id);
        selectedIngredients.push(ing);
        element.classList.add('selected');
    }
    updateTotal();
}

function updateTotal() {
    const baseSelect = document.getElementById('base-select');
    currentBasePrice = baseSelect.value === 'POMODORO' ? 4.5 : 3.5;
    
    const ingredientsPrice = selectedIngredients.reduce((sum, ing) => sum + ing.prezzo, 0);
    const total = currentBasePrice + ingredientsPrice;
    
    document.getElementById('pizza-price').textContent = total.toFixed(2);
    
    // Update preview
    const preview = document.getElementById('pizza-preview');
    const selectedNames = selectedIngredients.map(i => i.nome).join(', ');
    preview.innerHTML = `
        <div style="color: var(--text-muted); font-size: 0.9rem">
            Base ${baseSelect.value} + ${selectedNames || 'nessun ingrediente extra'}
        </div>
    `;
}

async function createUser() {
    const name = document.getElementById('username-input').value;
    const admin = document.getElementById('is-admin-checkbox').checked;
    if (!name) return;
    
    try {
        await fetch(`${API_BASE}/utenti`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome: name, admin: admin })
        });
        document.getElementById('username-input').value = '';
        document.getElementById('is-admin-checkbox').checked = false;
        fetchUsers();
    } catch (err) { console.error('Error creating user:', err); }
}

function addPizzaToOrder() {
    const baseSelect = document.getElementById('base-select');
    const pizza = {
        nome: `Custom (${baseSelect.value})`,
        basePizza: baseSelect.value,
        prezzo: parseFloat(document.getElementById('pizza-price').textContent),
        ingredienti: [...selectedIngredients]
    };
    
    pizzasInOrder.push(pizza);
    renderOrderSummary();
    
    // Reset builder
    selectedIngredients = [];
    document.querySelectorAll('.ingredient-item').forEach(el => el.classList.remove('selected'));
    updateTotal();
}

function renderOrderSummary() {
    const list = document.getElementById('pizzas-in-order');
    list.innerHTML = '';
    let total = 0;
    
    pizzasInOrder.forEach((p, idx) => {
        total += p.prezzo;
        const div = document.createElement('div');
        div.className = 'pizza-entry';
        div.innerHTML = `
            <div>
                <strong>${p.nome}</strong><br>
                <small>${p.ingredienti.map(i => i.nome).join(', ')}</small>
            </div>
            <span>€ ${p.prezzo.toFixed(2)}</span>
            <button onclick="removePizza(${idx})" style="width: auto; padding: 0.2rem 0.5rem; margin-left: 1rem; background: rgba(255,0,0,0.3)">X</button>
        `;
        list.appendChild(div);
    });
    
    document.getElementById('order-total').textContent = total.toFixed(2);
}

function removePizza(idx) {
    pizzasInOrder.splice(idx, 1);
    renderOrderSummary();
}

async function submitOrder() {
    const userId = document.getElementById('user-select').value;
    const user = allUsers.find(u => u.id == userId);
    
    if (!userId) {
        alert('Seleziona un utente prima di inviare l\'ordine!');
        return;
    }
    
    if (user && user.admin) {
        alert('Gli amministratori non possono effettuare ordini!');
        return;
    }

    if (pizzasInOrder.length === 0) {
        alert('Aggiungi almeno una pizza all\'ordine!');
        return;
    }
    
    const orderData = {
        utente: { id: parseInt(userId), admin: user.admin },
        listaPizze: pizzasInOrder,
        prezzoTotale: parseFloat(document.getElementById('order-total').textContent)
    };
    
    try {
        const response = await fetch(`${API_BASE}/ordini`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(orderData)
        });
        
        if (response.ok) {
            alert('Ordine inviato con successo!');
            resetOrder();
            fetchOrders();
        } else {
            const error = await response.text();
            alert('Errore durante l\'invio dell\'ordine: ' + error);
        }
    } catch (err) { console.error('Error submitting order:', err); }
}

function resetOrder() {
    pizzasInOrder = [];
    renderOrderSummary();
    selectedIngredients = [];
    document.querySelectorAll('.ingredient-item').forEach(el => el.classList.remove('selected'));
    updateTotal();
}
