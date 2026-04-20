# ================================
# STAGE 1 - Build
# ================================
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY src/ ./src/

RUN cd src && \
    javac *.java && \
    echo "Main-Class: Biblioteca" > MANIFEST.MF && \
    jar cfm ../biblioteca-virtual.jar MANIFEST.MF *.class

# ================================
# STAGE 2 - Runtime
# ================================
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

COPY --from=build /app/biblioteca-virtual.jar .

CMD ["java", "-jar", "biblioteca-virtual.jar"]
