# delasCasasDavid_pruebatec2
# Aplicación de Gestión de Turnos

Esta aplicación de gestión de turnos permite a una entidad gubernamental administrar la asignación de turnos para diferentes trámites, manteniendo un registro de los ciudadanos asociados y brindando funcionalidades de filtrado y visualización de la información.

## Funcionalidades

### Agregar un nuevo ciudadano:

Permite ingresar la información de los nuevos ciudadanos, incluyendo el nombre y el apellido y persistiéndolos en la base de datos con un ID.

### Ver ciudadanos:

Se agrega una tabla para la visualización de los ciudadanos agregados para facilitar el agregado de los turnos con el ID correspondiente.

### Agregar un nuevo turno:

Permite ingresar información sobre un nuevo turno, incluyendo número, fecha, descripción del trámite y estado del trámite. Cada turno está asociado a un ciudadano, y un ciudadano puede tener múltiples turnos en diferentes ocasiones.

### Ver turnos:

Muestra una tabla con la lista de todos los turnos junto con los ciudadanos asignados para facilitar la visualización a la hora de filtrar por fecha y/o estado.

### Filtrado de turnos:

Permite al usuario filtrar los turnos según la fecha y el estado del trámite (En Espera o Ya Atendido). Proporciona una vista detallada de los turnos que cumplen con los criterios de filtrado.

### Cambio de estado:

Permite el cambio de estado de "En espera" a "Ya atendido" para cuando el trámite se haya completado.

## Tecnologías Utilizadas

- **Backend:** Java, Servlets, JPA (Java Persistence API)
- **Frontend:** JSP (JavaServer Pages), Bootstrap (utilizado para mejorar la interfaz gráfica)
- **Base de Datos:** Se utiliza JPA para interactuar con la base de datos.
- **MySQL**

## Supuestos y Consideraciones

**Eliminación de Ciudadanos y Turnos:**
No se implementó la funcionalidad de eliminación de ciudadanos o turnos por simplicidad en la prueba. Puede añadirse según las necesidades del sistema.

**Tablas de Ciudadanos y Turnos:**
La presencia de las tablas de ciudadanos y turnos en la interfaz tiene el propósito de facilitar la visualización de los ciudadanos disponibles para diferentes turnos y las fechas disponibles para el filtrado.
