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

## Interfaz CommandLineRunner

Permite ejecutar alguna acción justo después de la inicialización de nuestra aplicación. Puede ser muy útil, por ejemplo, si queremos cargar algunos datos en nuestra base de datos justo al iniciar nuestra aplicación.

Cuando se inicia una aplicación Spring Boot, pueden ocurrir varias operaciones automáticas, como la creación de beans, configuración de la base de datos, entre otras. La apertura para personalizar estas operaciones es limitada, y aquí es donde entra en juego la interfaz CommandLineRunner.

La interfaz CommandLineRunner representa una tarea que se ejecutará después de la inicialización de Spring Boot, es decir, permite definir código que se ejecutará automáticamente cuando se inicie la aplicación.

```java
@SpringBootApplication
public class MyCommandLineRunner implements CommandLineRunner {
   
   @Override
    public void run(String... args) throws Exception {
        System.out.println("¡Hola, Mundo!");
    }
}
```

Observa que en el ejemplo anterior, creamos una clase llamada `MyCommandLineRunner` que implementa la interfaz `CommandLineRunner`. En el método `run`, insertamos la acción que deseamos que se ejecute justo después de que la aplicación se inicie, en este caso, simplemente imprimimos `¡Hola, Mundo!`.

### Uso

La interfaz `CommandLineRunner` es muy versátil y se puede utilizar en diversas situaciones. Como se mencionó anteriormente, se puede utilizar para cargar datos en una base de datos. También puede utilizarse para iniciar recursos, como conexiones de red, y para verificar la integridad de ciertos componentes o servicios con los que la aplicación va a interactuar.

Es importante recordar que `CommandLineRunner` se ejecuta solo en la inicialización de la aplicación, así que no debe utilizarse para tareas que deben ocurrir periódicamente durante el funcionamiento de la aplicación. Para eso, `Spring` ofrece otras herramientas que serán más adecuadas.

### Ejemplo

Imaginemos una situación en la que tenemos que cargar una gran cantidad de datos en nuestra base de datos tan pronto como nuestra aplicación `Spring` inicie. Bueno, manualmente esto sería desafiante y llevaría mucho tiempo; sin embargo, la interfaz `CommandLineRunner` hace que esta tarea sea extremadamente más simple.

Al profundizar en tu conocimiento de `Spring`, tendrás diversas opciones para optimizar tus aplicaciones y hacer que tu código sea más limpio y eficaz. `Spring` es un `framework` que facilita el desarrollo de aplicaciones en Java. Ofrece un modelo de programación completo y simplificado, ocultando muchos de los detalles de bajo nivel. Como resultado, puedes concentrarte en escribir tu código sin preocuparte por una multitud de detalles técnicos.

## Consumo de una API

Crearemos la clase llamada `ConsumoAPI` dentro de un paquete llamado `service`. En esta clase, tendremos un método llamado `obtenerDatos` que devuelve una cadena de texto con el `JSON` correspondiente a la respuesta de la solicitud.

[Codigo visto en clase de Java OO](https://app.aluracursos.com/course/java-consumir-api-escribir-archivos-manejar-errores/task/86624)

```java
public String obtenerDatos(String url) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
    HttpResponse<String> response = null;
    try {
        response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    String json = response.body();
    return json;
}
```

## Folder Structure en VSCode

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: no lib it seems, since working with maven (?)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management en VSCode

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
