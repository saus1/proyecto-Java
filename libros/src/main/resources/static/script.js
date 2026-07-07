const API_URL = 'http://localhost:8080/empleados';

const form = document.getElementById('empleadoForm');
const idInput = document.getElementById('id');
const nombreInput = document.getElementById('nombre');
const sectorInput = document.getElementById('sector');
const anioInput = document.getElementById('anio');
const saveBtn = document.getElementById('saveBtn');
const cancelBtn = document.getElementById('cancelBtn');
const tbody = document.getElementById('empleadosBody');

let editando = false;

// Cargar lista al iniciar
document.addEventListener('DOMContentLoaded', listarEmpleados);

// Manejar envío del formulario
form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const empleado = {
        nombre: nombreInput.value.trim(),
        sector: sectorInput.value.trim(),
        anio: parseInt(anioInput.value)
    };

    try {
        let response;
        if (editando) {
            // Actualizar (PUT)
            const id = idInput.value;
            response = await fetch(`${API_URL}/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(empleado)
            });
        } else {
            // Crear (POST)
            response = await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(empleado)
            });
        }

        if (response.ok) {
            mostrarMensaje(editando ? 'Empleado actualizado' : 'Empleado creado', 'exito');
            resetForm();
            listarEmpleados();
        } else {
            const texto = await response.text();
            mostrarMensaje(`Error: ${texto}`, 'error');
        }
    } catch (error) {
        mostrarMensaje(`Error de conexión: ${error.message}`, 'error');
    }
});

// Cancelar edición
cancelBtn.addEventListener('click', resetForm);

// Funciones auxiliares
async function listarEmpleados() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error('Error al obtener empleados');
        const empleados = await response.json();
        renderizarTabla(empleados);
    } catch (error) {
        mostrarMensaje(`Error al cargar la lista: ${error.message}`, 'error');
    }
}

function renderizarTabla(empleados) {
    tbody.innerHTML = '';
    empleados.forEach(emp => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${emp.id}</td>
            <td>${emp.nombre}</td>
            <td>${emp.sector}</td>
            <td>${emp.anio}</td>
            <td class="actions">
                <button class="btn-edit" data-id="${emp.id}">✏️ Editar</button>
                <button class="btn-delete" data-id="${emp.id}">🗑️ Eliminar</button>
            </td>
        `;
        tbody.appendChild(tr);
    });

    // Asignar eventos a botones
    document.querySelectorAll('.btn-edit').forEach(btn => {
        btn.addEventListener('click', () => cargarEmpleadoParaEditar(btn.dataset.id));
    });
    document.querySelectorAll('.btn-delete').forEach(btn => {
        btn.addEventListener('click', () => eliminarEmpleado(btn.dataset.id));
    });
}

async function cargarEmpleadoParaEditar(id) {
    try {
        const response = await fetch(`${API_URL}/${id}`);
        if (!response.ok) throw new Error('Empleado no encontrado');
        const emp = await response.json();
        idInput.value = emp.id;
        nombreInput.value = emp.nombre;
        sectorInput.value = emp.sector;
        anioInput.value = emp.anio;
        editando = true;
        saveBtn.textContent = 'Actualizar';
        cancelBtn.style.display = 'inline-block';
        // Desplazar al formulario
        document.querySelector('.form-container').scrollIntoView({ behavior: 'smooth' });
    } catch (error) {
        mostrarMensaje(`Error al cargar empleado: ${error.message}`, 'error');
    }
}

async function eliminarEmpleado(id) {
    if (!confirm('¿Seguro que deseas eliminar este empleado?')) return;
    try {
        const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        if (response.ok) {
            mostrarMensaje('Empleado eliminado', 'exito');
            listarEmpleados();
        } else {
            const texto = await response.text();
            mostrarMensaje(`Error al eliminar: ${texto}`, 'error');
        }
    } catch (error) {
        mostrarMensaje(`Error de conexión: ${error.message}`, 'error');
    }
}

function resetForm() {
    form.reset();
    idInput.value = '';
    editando = false;
    saveBtn.textContent = 'Guardar';
    cancelBtn.style.display = 'none';
    // Limpiar mensajes
    const msj = document.querySelector('.mensaje');
    if (msj) msj.style.display = 'none';
}

function mostrarMensaje(texto, tipo) {
    // Eliminar mensaje anterior
    const anterior = document.querySelector('.mensaje');
    if (anterior) anterior.remove();

    const div = document.createElement('div');
    div.className = `mensaje ${tipo}`;
    div.textContent = texto;
    div.style.display = 'block';
    // Insertar después del título
    const container = document.querySelector('.container');
    container.insertBefore(div, container.querySelector('.form-container'));
    // Ocultar después de 5 segundos
    setTimeout(() => { div.style.display = 'none'; }, 5000);
}