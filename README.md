# Lenguaje C - 0

#### Especificación del Lenguaje

  - Tokens: operadores, delimitadores, identiﬁcadores, palabras reservadas, constantes, etc. Por ejemplo, la secuencia de caracteres abc123 representa un único token. Dos tokens se pueden separar mediante un espacio en blanco, un operador o un delimitador.

  - Constantes: C −0 tiene solo un tipo de constantes,las constantes decadena.Una constante de cadena escualquier secuencia de caracteres tipo ASCII entre comillas dobles. 
    - El caracter «\» sirve para destacar caracteres especiales como puede ser \n que representa un salto de línea.

  - Operadores y delimitadores: 
    -  Delimitadores: “();{} 
    -  Operadores aritméticos: +(suma) -(resta) *(producto) /(división) 
    -  Operadores relacionales: <(menor) >(mayor) ==(igual) ¡=(distinto) 
    -  Operadores lógicos: ||(or) &&(and) 
    -  Operador de asignación: = 
    -  La precedencia de los operadores es la siguiente de mayor a menor prioridad: ( ) * / + - > < == ¡= && || =

-  Identiﬁcadores y palabras reservadas: secuencia de caracteres, dígitos o caracteres de subrayado que comienzan por una letra o por un caracter de subrayado. Los identiﬁcadores son utilizados para nombrar las entidades del programa como las variables. Dos identiﬁcadores con los mismos caracteres sólo que unos están en mayúsculas y otros están en minúsculas son considerados diferentes. Las palabras reservadas son identiﬁcadores que tienen un signiﬁcado especial. 
    -  Las palabras reservadas de C −0 son: main, if, while, else, putw, puts, int, break

-  Tipos de datos: solo vamos a considerar un tipo de dato, el tipo entero, que se representa con la palabra reservada int.
-  Sentencias de control de ﬂujo: 
    -  if(condición)sentencia1;else sentencia2; 
        -  else no siempre aparece, por lo que se puede omitir
    -  while(condición)sentencia; La parte . 
        -  Si aparece un break dentro de un bloque while, se deberá salir inmediatamente de dicho bloque.
-  Instrucciones de entrada-salida: solo se consideran funciones de salida por pantalla: 
    -  puts para salida de cadenas de caracteres.
    -  putw para salida de expresiones enteras.
-  Declaración de variables: se debe hacer al principio de las sentencias del programa. Las variables sólo pueden ser de tipo entero y se declaran de una en una. Se pone delante del identiﬁcador de la variable el tipo. En nuestro caso, sólo int. 
    -  Las variables no se inicializan al ser declaradas, por lo que si no les damos valor a lo largo del programa, su valor será impredecible.

#### Programa principal 
En C −0 no se admiten subprogramas, sólo el programa principal. Este comienza con main(){ y termina con}.


#### IDE (Integrated Development Environment) 
Se inclutye una interfaz en la que podrá programar. Se hará uso de archivos (guardar, cargar) y una zona en la que podamos visualizar nuestros archivos abiertos y un espacio para digitar nuestro código; así como un lugar dónde estén nuestras barras de herramientas. Esta interfaz provee pantallas para ver la salida de las diferentes etapas del proceso de compilación.
