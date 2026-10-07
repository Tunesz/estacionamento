FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# CORREÇÃO: Copia TODOS os arquivos do projeto (incluindo mvnw, pom.xml e a pasta src)
COPY . .

# Agora o mvnw existe no container e o comando vai funcionar perfeitamente
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

# O Maven gera o ficheiro .jar dentro da pasta /target
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
