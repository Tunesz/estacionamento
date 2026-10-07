FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copia TODOS os arquivos do projeto para o container (incluindo o mvnw)
COPY . .

# Executa a limpeza e compilação do projeto com o Maven Wrapper (mvnw)
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

# O Maven gera o ficheiro .jar dentro da pasta /target
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
