# 🥗 Healthy App — Backend API

API RESTful desarrollada en **Java con Spring Boot** para la gestión de pacientes, seguimiento de mediciones físicas (peso/altura) y cálculo automático de indicadores de salud clínicos (IMC, TMB e Tasa de Hidratación).

---

## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework Backend:** Spring Boot 3+
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL / PostgreSQL
* **Herramientas de Construcción:** Maven
* **Arquitectura:** Arquitectura en capas (Controller, Service, Repository, Mapper, DTO)

---

## 🏗️ Arquitectura del Proyecto

El proyecto está diseñado bajo una arquitectura limpia y desacoplada, separando la lógica de negocio de la transferencia de datos y la persistencia:

```text
src/main/java/com/healthyapp/healthlogic/
├── controller/         # Endpoints REST (PacienteController, MedidaController)
├── dto/                # Objetos de Transferencia de Datos (PacienteDTO, MedidaDTO)
├── exception/          # Excepciones personalizadas (DatoClinicoInvalidoException)
├── mapper/             # Mapeadores Entidad <-> DTO (PacienteMapper, MedidaMapper)
├── model/              # Entidades JPA de Base de Datos (Paciente, Medida)
├── repository/         # Interfaces Spring Data JPA (PacienteRepository, MedidaRepository)
└── service/            # Lógica de negocio (PacienteService, MedidaService, CalculadorSalud)
---
## 🧮 Lógica Clínica Integrada (CalculadorSalud)
El sistema cuenta con un servicio especializado de cálculos en salud que aplica las siguientes fórmulas clínicas:
    ### Índice de Masa Corporal (IMC):
        IMC=  Peso (kg) / Altura (m)2
​	     Clasificación automática: Bajo peso, Peso normal (Eutrófico), Sobrepeso y Obesidad.
    ### Tasa Metabólica Basal (TMB):
        Fórmula de Harris-Benedict ajustada por sexo, peso, altura y edad.
    ### Requerimiento Hídrico Diario:
        Cálculo de hidratación básica estimado según el rango de peso del paciente.

---
## 📌 Endpoints de la API
👤 Pacientes (/api/pacientes)
Método, Endpoint,               Descripción
GET,    /api/pacientes,         Obtiene la lista completa de pacientes con sus DTOs.
POST,   /api/pacientes,         Registra un nuevo paciente en el sistema.
PATCH,  /api/pacientes/{dni},   Actualiza parcialmente los datos de un paciente.
DELETE, /api/pacientes/{dni},   Elimina un paciente por su DNI (retorna 204 No Content).

Ejemplo de Body para crear Paciente (POST /api/pacientes):
{
  "dni": 12345678,
  "nombre": "Ana Pérez",
  "edad": 30,
  "sexo": "Femenino"
}

📏 Mediciones (/api/pacientes/{dni}/medidas)
Método, Endpoint,                       Descripción
GET,    /api/pacientes/{dni}/medidas,   Obtiene el historial de mediciones de un paciente.
POST,   /api/pacientes/{dni}/medidas,   Agrega una nueva medición (peso/altura) a un paciente.


Ejemplo de Body para agregar Medición (POST /api/pacientes/12345678/medidas):
{
  "fechaMedicion": "2026-07-28",
  "peso": 68.5,
  "altura": 1.65
}
---
## ⚙️ Configuración e Instalación
    1. Requisitos Previos
    Java JDK 17 o superior.
    Maven instalado.
    Base de datos MySQL o PostgreSQL activa.
    2. Configurar la Base de Datos
    En el archivo src/main/resources/application.properties, configurá las credenciales de tu base de datos:
    spring.datasource.url=jdbc:mysql://localhost:3306/healthy_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=TU_USUARIO
    spring.datasource.password=TU_CONTRASEÑA

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

    3. Ejecutar la Aplicación
    Podés iniciar la aplicación desde tu IDE o mediante la consola de comandos:
    mvn spring-boot:run