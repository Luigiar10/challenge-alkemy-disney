
# Challenge Alkemy Disney
Challenge enfocado a realizar un api que permita conocer el screening tecnico con el que se cuenta para la entrada al campus de Alkemy

## Reto
Una empresa te contrata a tí y a tu equipo de developers para desarrollar una aplicación
que le permita a niños y niñas hispanohablantes explorar el mundo de Disney. Para hacer
esto, el cliente te solicita que en la aplicación se puedan conocer y modificar los personajes
que lo componen y entender en qué películas participaron cada uno de esos personajes


## Solución
Se utilizo el lenguaje Java en la version 1.8 y Spring Boot en la version 2.7.3 y MySql para la parte de la base de datos

## Incidencias
Se presento algunas fallas con las relaciones de las tablas, causando un bucle de recursividad en la informacion, esto fue solucionado con la anotacion @JsonBackReferense y @JsonManagedReference, se quito esta ultima anotacion ya que causaba conflictos a la hora de crear un nuevo registro en bd, ademas quedo faltando la parte de la security, aunque se pudo implementar un auth basic con user y password y el envio del correo. Se probo de forma manual y no se encontraron errores.

## Authors
- [@luigiar10](https://www.github.com/luigiar10)

