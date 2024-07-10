# Instrucciones

1) Se debe descargar el proyecto neoris-gradle. En este proyecto se centralizan todas las versiones y las dependencias del proyecto.
   Este proyecto debe estar en la misma ruta de los otros proyectos.

`git clone https://github.com/daleonv/neoris-gradle.git`

Este proyecto no necesita ser compilado

2) Se debe descargar el proyecto neoris-entities. En este proyecto está el mapeo de las entidades
   `git clone https://github.com/daleonv/neoris-entities.git`

Este proyecto debe ser compilado.

`gradle clean build publish`

3) Se debe descargar el proyecto neoris-procedures. En este proyecto se hallan las capas principales del proyecto.

`git clone https://github.com/daleonv/neoris-procedures.git`

Para levantar el proyecto se debe usar el siguiente comando:

`gradle bootRun`