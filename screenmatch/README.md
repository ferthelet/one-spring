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

## @JsonAlias() y @JsonProperty

Son anotaciones de Jackson, una biblioteca Java para procesar JSON, que ayudan a mapear propiedades de clase a campos JSON.

### @JsonProperty()

Esta anotación se utiliza para definir el nombre de la propiedad JSON asociada al campo Java. Cuando el JSON se **serializa**, es decir, se convierte de objetos Java a JSON, el nombre especificado en `@JsonProperty` se utilizará como la clave para el campo en el JSON de salida. De manera similar, cuando el JSON se deserializa (se convierte de JSON a objetos Java), la biblioteca busca el nombre especificado en `@JsonProperty` para mapear el valor JSON al campo Java.

Entonces, si deseas usar un nombre diferente en el JSON, puedes utilizar `@JsonProperty("nombreEnJson")`. Esto es útil, por ejemplo, cuando necesitas trabajar con un JSON que sigue una convención de nomenclatura diferente a la de tu clase Java.

### @JsonAlias()

Se utiliza para definir uno o más alias para el nombre de la propiedad JSON asociada al campo Java. Al **deserializar**, `@JsonAlias` permite que la biblioteca encuentre el valor JSON correspondiente, incluso si el nombre de la propiedad en el JSON no coincide exactamente con el nombre del campo Java.

Esto es útil cuando trabajas con diferentes versiones de un JSON o cuando deseas permitir que una propiedad sea referenciada por nombres diferentes.

## Generics

En Java, los genéricos permiten crear clases, interfaces y métodos que pueden trabajar con tipos desconocidos o parámetros genéricos. Proporcionan una forma de escribir código flexible y reutilizable, haciéndolo independiente de tipos específicos y permitiendo que funcione con diferentes tipos de datos.

Para crear una clase o método genérico, necesitas usar parámetros de tipo (tipos genéricos) que se representan entre corchetes angulares <>. Por lo general, usamos letras mayúsculas únicas para representar los tipos genéricos, pero puedes usar cualquier identificador válido en Java. Aquí tienes un ejemplo de una clase genérica llamada Caja, que almacena un valor de un tipo desconocido:

```java
public class Caja<T> {
    private T contenido;

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}
```

En el ejemplo anterior, podemos crear un objeto del tipo Caja y almacenar cualquier tipo de valor en él. Aquí tienes un ejemplo:

```java
public class TesteaCaja {
    public static void main(String[] args) {
        Caja<String> cajaDeTexto = new Caja();
        cajaDeTexto.setContenido("Guardando texto en mi caja!");

        Caja<Integer> cajaDeEdad = new Caja();
        cajaDeEdad.setContenido(30);

        Caja<Double> cajaDeValor = new Caja<>();
        cajaDeValor.setContenido(150.50);
    }
}
```

Observa que podemos utilizar la clase Caja para incluir valores de diferentes tipos. Para la variable cajaDeTexto, el compilador garantizará que solo se puedan almacenar valores del tipo String. Para la variable cajaDeEdad, el compilador garantizará que solo se puedan almacenar valores del tipo Integer, y así sucesivamente.

### Método Genérico

Para crear un método genérico, puedes usar la misma sintaxis con parámetros de tipo entre corchetes angulares. Aquí tienes un ejemplo de un método genérico, que pertenece a la clase Caja y que debería sumar el valor pasado por parámetro al contenido de la caja:

```java
public <T> T sumaContenidoEnCaja(T valor) {
    if (this.contenido instanceof Integer c && valor instanceof Integer i) {
        Integer resultado = c + i;
        return (T) resultado;
    } else if (this.contenido instanceof Double c && valor instanceof Double d) {
        Double resultado = c + d;
        return (T) resultado;
    } else if (this.contenido instanceof String c && valor instanceof String s) {
        String resultado = c + "\n" + s;
        return (T) resultado;
    }

    return null;
}
```

La finalidad del método anterior es realizar la suma entre el contenido actual de la caja (this.contenido) y el valor pasado como parámetro (valor). El método es genérico y puede usarse para diferentes tipos de contenido que pueden sumarse, como Integer, Double y String.

Veamos paso a paso lo que sucede:

```java
public <T> T sumaContenidoEnCaja(T valor) {
    ...
}
```

El método es genérico y recibe un parámetro valor del tipo genérico T, que es el mismo tipo que se devolverá como resultado de la suma.

Luego, el método comienza con una serie de condicionales if que verifican el tipo del contenido actual de la caja (this.contenido) y el tipo del valor pasado como parámetro (valor).

```java
if (this.contenido instanceof Integer c && valor instanceof Integer i) {
    // Realiza la suma entre los valores y almacena el resultado en una variable
    Integer resultado = c + i;
    // Devuelve el resultado como tipo genérico `T` (en este caso, `Integer`)
    return (T) resultado;
}
```

La verificación se realiza utilizando los operadores instanceof y los operadores de coincidencia de patrones (instanceof con variables de patrón) disponibles a partir de Java 16.

Si el contenido actual (this.contenido) y el valor (valor) son ambos del mismo tipo, se realiza la suma o la concatenación, como en el caso de String. Si el tipo de la variable valor es diferente al tipo del contenido, devolvemos el valor anterior del contenido. Veamos cómo quedaría en nuestra clase TesteaCaja:

```java
public static void main(String[] args) {
    Caja<String> cajaDeTexto = new Caja();
    cajaDeTexto.setContenido("Guardando texto en mi caja!");
    System.out.println(cajaDeTexto.sumaContenidoEnCaja("Otra línea"));

    Caja<Integer> cajaDeEdad = new Caja();
    cajaDeEdad.setContenido(30);
    System.out.println(cajaDeEdad.sumaContenidoEnCaja(26));

    Caja<Double> cajaDeValor = new Caja<>();
    cajaDeValor.setContenido(150.50);
    System.out.println(cajaDeValor.sumaContenidoEnCaja(350.50));
    System.out.println(cajaDeValor.sumaContenidoEnCaja("texto"));
}
```

Al ejecutar el código anterior, obtendremos la siguiente salida en nuestro terminal:

```bash
Guardando texto en mi caja!
Otra línea
56
501.0
null
```

Observa que en la última línea del código, al intentar incluir un String "texto" en nuestra cajaDeValor, al ejecutar este código obtuvimos un retorno nulo, ya que solo realizamos la suma si ambos tipos eran iguales.

## Lo aprendido

- Estructura de un Proyecto Spring: Observamos la estructura inicial de un proyecto Spring y discutimos sobre los paquetes, clases y el método run.
- Inferencia de Tipos en Java: Vimos un ejemplo práctico de inferencia de tipos con 'var' en el código Java.
- Consumo de API: Aprendimos a consumir APIs a través del método 'obtenerDatos', que devuelve los datos deseados en formato Json.
- Modularización de Código: Aprendimos la importancia de tener un código modularizado y de fácil mantenimiento.
- Serialización y Deserialización: Aprendimos cómo transformar JSON en clases y cómo esto es útil para el proyecto.
- Creación de Interfaces e Implementación de Métodos: Se demostró la creación de una interfaz con un método genérico que utiliza Generics, así como la implementación de este método en una clase separada.
- Inclusión de Nuevas Dependencias en el Proyecto: Vimos cómo agregar una nueva dependencia al archivo .pom.xml y cómo este proceso es gestionado por Maven.

## Colecciones

Las colecciones son estructuras de datos fundamentales en Java que nos permiten almacenar y manipular conjuntos de elementos de manera eficiente. Están implementadas a través de la API de colecciones de Java, que forma parte del paquete java.util. Las colecciones proporcionan una variedad de clases e interfaces para almacenar y organizar datos de diferentes maneras, atendiendo a diversas necesidades y escenarios.

La API de colecciones de Java incluye interfaces, clases abstractas y clases concretas para representar diferentes tipos de colecciones. Algunas de las interfaces principales de colecciones son:

- List: Una colección ordenada que permite elementos duplicados. Los elementos se acceden mediante índices.
- Set: Una colección que no permite elementos duplicados y normalmente no tiene un orden definido.
- Queue: Una colección que representa una cola, donde los elementos se agregan al final y se eliminan del principio.
- Map: Una colección de pares clave-valor, donde cada clave es única y mapeada a un valor correspondiente.

Además de estas interfaces, la API de colecciones también incluye varias clases concretas que implementan estas interfaces, como ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, entre otras.

Una de las interfaces más utilizadas es List. Como se mencionó anteriormente, List es una interfaz que define una secuencia ordenada de elementos, donde cada elemento tiene una posición específica. Al declarar una variable de este tipo, indicamos que trabajaremos con una colección que mantiene el orden de los elementos.

Una de las principales razones para usar List es la flexibilidad que ofrece. Podemos agregar, eliminar y acceder a elementos de manera fácil e intuitiva. Además, también permite la duplicación de elementos, es decir, podemos tener elementos repetidos en la colección. Otra ventaja es la posibilidad de recorrer los elementos de manera secuencial, utilizando bucles de repetición como el for-each, lo que facilita la manipulación de los elementos y la realización de operaciones en masa.

Aquí tienes un ejemplo práctico del uso de List en un código Java:

```java
import java.util.List;
import java.util.ArrayList;

public class EjemploList {
    public static void main(String[] args) {
        // Creando un objeto del tipo List para almacenar números enteros
        List<Integer> numeros = new ArrayList<>();

        // Agregando elementos a la lista
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Accediendo a elementos de la lista
        System.out.println("Primer elemento: " + numeros.get(0)); // Salida: 10
        System.out.println("Segundo elemento: " + numeros.get(1)); // Salida: 20
        System.out.println("Tercer elemento: " + numeros.get(2)); // Salida: 30

        // Recorriendo los elementos de la lista
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        // Eliminando un elemento de la lista
        numeros.remove(1); // Elimina el elemento en el índice 1 (20)

        // Verificando el tamaño de la lista
        System.out.println("Tamaño de la lista: " + numeros.size()); // Salida: 2
    }
}
```

Además, Java también tiene otras colecciones como Set y Map. Set es una colección que no permite elementos duplicados, mientras que Map es una colección que asocia claves a valores, permitiendo la recuperación rápida de un elemento a través de su clave.

Las colecciones de Java son extremadamente útiles en diversas situaciones, como almacenar datos en memoria, realizar operaciones de búsqueda, ordenación y filtrado. Nos ayudan a organizar y manipular grandes cantidades de datos de manera eficiente y elegante.

## Folder Structure en VSCode

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: no lib it seems, since working with maven (?)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management en VSCode

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
