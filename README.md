# Java_JSF

## Ciclo de Vida

## Reglas de Navegación

### Tipos

- **Navegación Estática:** 

Se implementa cuando no se requiere ejecutar código Java en el servidor o no hay lógica a implementar para definir la siguiente página.

``` html
<h:commandButton label="entrar" action="login" />
```
La página se buscará automáticamente de dos posibles maneras:

1. Busca la página login.xhtml
2. Busca en el archivo faces-config.xml la información de la página login.

- **Navegación Dinámica:** 

Utiliza un método action, que tiene la lógica que determina el outcome.

``` html
<h:commandButton label="entrar" action="#{loginBean.verificarUsuario}" />
```

En el action se llama al controlador LoginBean y al método verificarUsuario, el cual determina, según lógica interna, la página a msotrar.

``` java
public String verificarUsuario(){
    if(...){
        return "exito";
    }
    else{
        return "fallo";
    }
}
```

### Formas de configurar navegación:

- **Navegación Implícita:** JSF. Elemento para definir cual será la suguiente página es la salida **outcome**.


- **Navegación Explícita:** En el archivo faces-config.xml

Las reglas de navegación en el archivo faces-config se definen de la siguiente manera:

``` xml
<faces-config ...>
    <navigation-rule>
        <from-view-id> /inicio.xhtml </from-view-id>
        <navigation-case> 
            <from-outcome> entrar </from-outcome>
            <to-view-id> /login.xhtml </to-view-id>
        </navigation-case>
    </navigation-rule>

    ...
    
</faces-config >
```

Se definen dentro de navigation rule. En **from-view-id** se define la página de la cual proviene la petición. Luego se pueden definir varios casos de navegación con **<navigation-case>.** A continuación se define la condición que define que irá por este caso con **<from-outcome>** de valor entrar en el ejemplo. Finalmente se define la página donde se redireccionará en esta caso, con el tag **<to-view-id>.**

## Validaciones

Hay dos formas de ejecutar validaciones:

1. **Individual por campo:** Se consigue de diferentes maneras:
- Agregando atributo required al tag JSF
- Agregando atributo validador al tag JSF
- Agregando validador como tag interno
- Tag h:message se usa para mostrar errores de un componente
2. **Por campos interdependientes:** Se ejecuta dentro de metodos actions
- Tag h:messages se usa para mostrar varios errores a la vez


