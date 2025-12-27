# Proyecto: Módulo de Catálogo - Zapatillas J&R

Este proyecto implementa el módulo de gestión y consulta del catálogo de productos (zapatillas) para la tienda online "Zapatillas J&R". El desarrollo se realizó utilizando el framework **Spring Boot** con el lenguaje **Java**, cumpliendo con los lineamientos del componente formativo "Frameworks para construcción de aplicaciones con JAVA.".

## 1. Tecnologías Utilizadas

| Componente | Tecnología | Versión | Propósito |
| :--- | :--- | :--- | :--- |
| **Framework** | Spring Boot | 3.2.0 | Desarrollo rápido de la API REST. |
| **Lenguaje** | Java | 17 | Lenguaje de programación principal. |
| **Persistencia** | Spring Data JPA | 3.2.0 | Abstracción para el acceso a la base de datos. |
| **Base de Datos** | H2 Database | Última | Base de datos en memoria para desarrollo. |
| **Dependencias** | Lombok | 1.18.30 | Reducción de código boilerplate (getters, setters, constructores). |
| **Build Tool** | Maven | 3.9.5 | Gestión de dependencias y construcción del proyecto. |

## 2. Estructura del Módulo

El módulo sigue la arquitectura de capas estándar de Spring Boot:

*   `com.zapatillasjyr.catalogo.model`: Contiene la entidad `Zapatilla` (el modelo de datos).
*   `com.zapatillasjyr.catalogo.repository`: Contiene la interfaz `ZapatillaRepository` para la capa de persistencia (acceso a datos).
*   `com.zapatillasjyr.catalogo.service`: Contiene la clase `ZapatillaService` que implementa la lógica de negocio (CRUD, filtrado).
*   `com.zapatillasjyr.catalogo.controller`: Contiene la clase `ZapatillaController` que expone la API REST.

## 3. Estándares de Codificación y Comentarios

Todo el código fuente cumple con los estándares de codificación Java (uso de *camelCase* y *PascalCase*) y utiliza comentarios **Javadoc** para documentar clases, métodos y atributos, facilitando la comprensión y el mantenimiento del código.

## 4. Endpoints de la API REST

El módulo expone los siguientes endpoints para la gestión del catálogo:

| Método | URL | Descripción | Historia de Usuario Relacionada |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/zapatillas` | Lista todas las zapatillas. Soporta filtrado por `?marca={valor}` y `?talla={valor}`. | HU-001, HU-002 |
| `GET` | `/api/zapatillas/{id}` | Obtiene los detalles de una zapatilla específica. | HU-003 |
| `POST` | `/api/zapatillas` | Crea una nueva zapatilla (Administrador). | HU-004 |
| `PUT` | `/api/zapatillas/{id}` | Actualiza una zapatilla existente (Administrador). | HU-005 |
| `DELETE` | `/api/zapatillas/{id}` | Elimina una zapatilla (Administrador). | N/A (Función de gestión) |

## 5. Instrucciones de Ejecución

1.  **Requisitos:** Tener instalado Java Development Kit (JDK) 17 o superior y Maven.
2.  **Compilación:** Navegar a la carpeta raíz del proyecto (`/home/ubuntu/zapatillas_jyr`) y ejecutar:
    ```bash
    mvn clean install
    ```
3.  **Ejecución:** Ejecutar el archivo JAR generado en la carpeta `target/`:
    ```bash
    java -jar target/catalogo-0.0.1-SNAPSHOT.jar
    ```
4.  **Acceso:** La aplicación se iniciará en el puerto 8080 por defecto. Los datos iniciales se cargan automáticamente desde `import.sql`.

## 6. Enlace al Repositorio Git

El proyecto ha sido versionado utilizando Git. El historial de commits refleja la creación de artefactos y la implementación del código.

**Enlace del Repositorio:** [ENLACE_DEL_REPOSITORIO_A_GENERAR] https://github.com/jhon5722/JHON-FREDDY-O_AA3_EV01.git


