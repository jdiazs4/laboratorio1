# ingenieria-software-lab1

Laboratorio 1 - Ingenieria de Software - UMG

Alumno: Joan Manuel Diaz Salazar

Carne: 1290-15-4845

Proyecto clonado de: https://github.com/jbarillasgarcia/ingenieria-software-lab1

Descripcion:

El repositorio contiene un proyecto creado con springboot y con base de datos H2. Con el objetivo de ejecutar servicios RESTful. Proyecto trabajado por medio de una rama.

EL PROYECTO REALIZA LOS SIGUIENTES PUNTOS (levantado en el puerto 9001)

SERVICIOS

 -  Buscar todos los clientes
 
 - Buscar cliente por NIT
 
 - Buscar cliente por nombres y/o apellidos
 
 - Crear cliente
 
 - Editar cliente
 
 - Reporte de cliente

URL DE SERVICIOS RESTFUL:

- URL: .../clientes/buscarTodos

- URL: .../clientes/buscarPorNit?nit=45684231-4

BUSQUEDA REALIZADA POR MEDIO DE COMODIN *

- URL: .../clientes/buscarPorNombreApellido?query=Juan

- URL: .../clientes/buscarPorNombreApellido?query=Juan Lopez

- URL: .../clientes/buscarPorNombreApellido?query=Lopez

- URL: .../clientes/buscarPorNombreApellido?query=Juan*

- URL: .../clientes/buscarPorNombreApellido?query=*Lopez

- URL: .../clientes/buscarPorNombreApellido?query=Ju*an

- URL: .../clientes/crearCliente

POSIBLES EDICIONES PARA CLIENTE

- URL: .../clientes/editarCliente 

- URL: .../clientes/editarCliente/2/456846-4 

- URL: .../clientes/editarCliente/2/Juan/Lopez 

REGLAS DE NEGOCIO
- No se permitira el registro de clientes menores de edad.  En caso de ocurrir el sistema debera lanzar una excepcion (Exception) con el mensaje "Lo sentimos. El sistema solo permite el registro de usuarios mayores de edad.".

- El NIT debera tener un maximo de 10 caracteres y solo debera contener digitos. No simbolos (ni guion). En caso de ocurrir debera lanzar una excepcion (Exception) con el mensaje "NIT invalido".

- Los nombres y apellidos deberan almacenarse con la primera letra de cada palabra en mayuscula y el resto en minusculas.



