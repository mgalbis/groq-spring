# Etapa 1: Build
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
# Descarga dependencias (capa cacheada)
RUN mvn dependency:go-offline -B
COPY src ./src
# Compila y empaqueta
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copia solo el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Usuario no-root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Puerto de la aplicación
EXPOSE 8090

# NUNCA pongas la API KEY aquí con ENV
ENTRYPOINT ["java", "-jar", "app.jar"]