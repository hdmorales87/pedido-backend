# pedido-backend

Backend Java con arquitectura de puertos y adaptadores, organizado como proyecto Maven multi-modulo.

## Modulos

- `core`: dominio compartido
- `app-sync`: capa de aplicacion sincronica, entrada REST y persistencia JPA
- `app-reactive`: capa de aplicacion reactiva, entrada WebFlux y persistencia R2DBC

## Estructura

- `core`
  - `domain/model`
  - `domain/port/out`
- `app-sync`
  - `application`
  - `application/port/in`
  - `infrastructure/adapter/in/rest`
  - `infrastructure/adapter/out/persistence`
  - `infrastructure/config`
- `app-reactive`
  - `application/reactive`
  - `application/reactive/port/in`
  - `infrastructure/adapter/in/rest`
  - `infrastructure/adapter/out/persistence/reactive`
  - `infrastructure/config`

## Criterio arquitectonico

- El dominio compartido vive en `core`.
- Cada aplicacion compone sus propios casos de uso.
- La persistencia pertenece a cada app, no a un modulo compartido.
- La app reactiva no depende de JPA.
- Reactor no se expone desde `core`.
- El esquema SQL de la app sincronica se controla con Flyway.
- `app-sync` es el owner actual de las migraciones del esquema compartido.
- `app-reactive` consume el esquema existente y no ejecuta migraciones.

## Compilar

```bash
mvn clean compile
```

## Ejecutar la app sincronica

```bash
mvn -pl app-sync spring-boot:run
```

## Ejecutar la app reactiva

```bash
mvn -pl app-reactive spring-boot:run
```

## Docker

- `app-sync/Dockerfile`: imagen de la app sincronica
- `app-reactive/Dockerfile`: imagen de la app reactiva
- `docker-compose.yml`: orquesta MySQL, `app-sync` y `app-reactive`
