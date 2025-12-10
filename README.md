# groq-spring
Mini-webapp desarrollada con Srping Boot que utiliza la API de Groq AI para reescribir un texto modificando el tono.

## INSTRUCCIONES

1. El usuario introduce un texto.
2. Selecciona un tono.
3. De forma opcional, indica una temperatura.
4. De forma opcional, indica un top_p.
5. El resultado puede ser muy variado. Si se indica una temperatura más baja, el resultado será más determinista y 
   con cambios mínimos. Si la temperatura es más alta, el resultado será más creativo y variable. Si se indica un 
   top_p más bajo, el resultado será más controlado y sobrio. Si se indica un top_p más alto, el resultado será más 
   variado en cada intento.

## CONFIGURACIÓN

Crear un archivo `.env` con :
```
GROQ_API_KEY=TU_API_KEY
```