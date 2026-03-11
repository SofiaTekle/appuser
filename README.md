# 👤 AppUser

Jakarta EE 10-applikation för hantering av användare.

## Funktioner

- Registrera och lista användare
- Inloggning med session-hantering
- WebSocket-chatt efter inloggning
- Utloggning

## Tekniker

- Jakarta EE 10
- JSF / PrimeFaces
- JPA / Hibernate
- PostgreSQL (Neon)
- GlassFish

## Krav

- GlassFish med konfigurerad JDBC connection pool mot Neon
- WebSocket-servern körs parallellt på samma GlassFish

## Context root

/appuser