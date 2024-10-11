# Java Spring Boot

Bienvenido al modulo Java Spring Boot

## Links

- [Curso Alura](https://app.aluracursos.com/course/java-trabajando-lambdas-streams-spring-framework)
- [Trello](https://trello.com/b/A1ieTFLO/formacion-java-spring)
- [Spring Initialzr](https://start.spring.io/)
- [Repositorio Maven](https://mvnrepository.com/)

## Maven

- Gestión de Dependencias: Maven es excelente para gestionar las dependencias de un proyecto. Las dependencias se declaran en el archivo pom.xml y Maven se encarga de descargarlas automáticamente desde el repositorio central de Maven o repositorios personalizados.
- Convención sobre Configuración: Maven sigue un conjunto de convenciones, lo que significa que muchas configuraciones están predefinidas y se pueden utilizar directamente sin necesidad de configuración adicional.
- Ciclo de Vida Estándar: Maven tiene un ciclo de vida estándar con diferentes fases (por ejemplo, compile, test, package, install, deploy), y cada fase ejecuta una serie de metas. El ciclo de vida estándar permite construir y probar fácilmente su proyecto mediante comandos como mvn compile, mvn test y mvn package.
- Repositorio Central: Maven tiene un repositorio central que contiene una amplia variedad de bibliotecas Java listas para ser utilizadas. 

## Gradle

- Utiliza un lenguaje de dominio específico (DSL) basado en Groovy o Kotlin para definir la estructura del proyecto y las tareas de construcción.
- Flexibilidad: Gradle es altamente flexible y le permite definir sus propias tareas de construcción y configurar el proceso de construcción según sus necesidades.
- Construcción por Convención: Gradle también sigue algunas convenciones, pero ofrece más libertad que Maven en la forma en que organiza y configura el proyecto.
- Gestión de Dependencias: Al igual que Maven, Gradle también gestiona las dependencias del proyecto y puede descargarlas de repositorios remotos.
- Compilaciones Incrementales: Gradle está diseñado para realizar compilaciones incrementales, lo que significa que puede construir solo las partes del proyecto que han cambiado desde la última compilación, haciendo que el proceso sea más rápido.

## Diferencias entre Maven y Gradle

Es la forma en que gestionan las dependencias y cómo describen la lógica de construcción. Maven utiliza archivos XML para gestionar las dependencias y describe la lógica de construcción mediante complementos, mientras que Gradle utiliza un formato de script y describe la lógica de construcción como código.

## Folder Structure en VSCode

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: no lib it seems, since working with maven (?)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management en VSCode

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
