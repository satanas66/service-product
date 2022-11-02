# Prueba técnica de desarrollo de back-end

## Proyecto service-product"

El siguiente proyecto ha sido realizado siguiendo los requerimientos del fichero readme.md localizado en la siguiente ruta: https://github.com/dalogax/backendDevTest/blob/main/readme.md

### Marco de trabajo

Las tecnologías más relevantes para el desarrollo del proyecto service-product son:

* IDE Intellij Ultimate 2020.3
* Spring boot 2.7.5
* JDK 11
* JPA 2.2.3
* H2
* Spring WEB 5.3.23
* Lombok 1.18.24
* POSTMAN: Para probar el servicio publicado.

### Arquitectura

El patrón de diseño de software es el de "Arquitecturas limpias" en el cual se modulariza y separa claramente el negocio/dominio de la insfraestructura/tecnologia.

En este tipo de arquitectura hexagonal se cumplen las reglas de dependencia de fuera hacia dentro:

* INFRAESTRUCTURE => APPLICATION => DOMAIN

## Análisis y desarrollo

Después de un breve análisis de los requerimientos (contratos) he concluido que tengo que consumir y exponer un servicio.

El servicio a consumir se expondrá en la url: "http://localhost:3001/product/{productId}/similarids"

El servicio que se ofrece arrancando esta aplicación estará expuesto en la url: http://localhost:5000/product/{productId}/similar

Siendo {productId} en los dos casos el identificador del producto a consultar.

### Entidades de negocio

* ProductDetail: Representa al producto detallado con los 4 atributos del contrato.

Este ente de negocio lo he modelado en Java y los he creado mediante un script sql lanzado en tiempo de ejecución en base de datos H2

### Caso de uso

* Devolver un listado de Productos detallados  

### Módulos

Siguiendo la arquitectura hexagonal el proyecto está modularizado en tres niveles que únicamente se comunican de fuera hacia dentro.

En cada múdulo se definen, programan y desarrollan todas aquellas funcionalidades para cumplir con los requisitos del readme.md y contratos.

Para facilitar la cohesión entre los entes de negocio por cada uno se genera una estructura de carpetas que contendra infraestructure, application y domain.

#### Domain

En esta carpeta se detalla la entidad de negocio e interfaces

En cuanto a las Interfaces son las abstracciones que uso para la conexión a base de datos, definición de caso de uso.

* Interfaz de repositorio: Se refiere a la interfaz JPARepository.
* Interfaz de servicio: Se refiere a la interfaz de casos de uso

#### Application

En esta carpeta se implementan los casos de uso definidos en las interfaces de los servicios.

Aquí se realiza la comunicación con el servicio externo.

#### Infraestructure

En esta carpeta se implementan las clases que publicaran los servicios que serán consumidos a posteriori.

### Servicio "product/{productId}/similar"

Previa cosumisión del servicio se debe arrancar el proyecto cuyo núcleo es la clase "ServiceProductApplication"

Este servicio se publicará en la siguiente url: http://localhost:5000/product/{productId}/similar

### Fichero de configuración application.yml

Enl fichero application.yml he configurado el puerto de despliegue así cómo los parámetros de conexión a una base de datos en memoria H2 para realizar pruebas.

En cuanto a la implementación de Spring JPA uso Hibernate que también está configurado en este mismo fichero.

## Author Computer Enginner
* Edwin Patricio Arévalo Angulo
* edwinarevaloangulo@gmail.com


