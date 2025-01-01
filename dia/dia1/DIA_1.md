DIA\_1

Delphi Inteligencia Artesanal.

La intención es hacer una especie de diario de bitácora exponiendo temas relacionados con la inteligencia artificial, desde el punto de vista de un programador Delphi.

No quiere decir que todo vaya a ser codigo pascal, usaré mucho python, java , kotlin y cualquier otro lenguaje que surja. Pero el resultado podrá ser usarlo desde Delphi.

Es una forma de seguir explorando formas de conectar delphi y otras cosas…

El primer proyecto va a ser integrar ML-Kit.

[ML Kit  |  Google for Developers](https://developers.google.com/ml-kit/)

Es una librería para java/kotlin enfocada a modelos de IA ligeros que pueden usarse en dispositivos móviles.

Especialmente útil es el traductor. Puede traducir entre cientos de lenguajes en el propio dispositivo. Cuando seleccionas una combinación de idiomas, descarga el modelo en el dispositivo si no lo tiene aun. Cuando tienes varios modelos descargados, puede funcionar sin conexión a internet.

Podemos atacar el problema por varios lados:

* ML\_Kit usa modelos tflite, tensorFlow lite.( o RtLite). Potencialmente estos modelos pueden ser usados desde delphi. Esta opción la exploraremos más adelante, cuando hayamos revisado tensorflow y como integrarlo en delphi. En realidad tendremos que ver muchas cosas antes de llegar ahí, ya que no usariamos ML\_Kit en si, solo los modelos, por lo tanto tendríamos que hacer todo el codigo de adaptación a esos modelos.  
    
* Otra opción es usar la  libreria nativas SDK de Ml\_Kit, pero en la actualidad no son totalmente públicas y están ofuscados los nombres de las clases. Si que podríamos ‘deducir’ algunas cosas investigando en el codigo fuente de las demo, pero la dificultad puede ser grande a la hora de depurar, unido a la dificultad de conseguir un SDK oficial público, unido a que cualquier actualización que hagan pueden cambar esos nombres ofuscados, me hacen desistir de esta ruta, hasta que haya una publicación más abierta del SDK.  
    
* Otra forma más sencilla es comunicar por intents y/o por servicios la aplicación delphi, con la aplicación java/kotlin de mlkit. Podemos partir de algunos ejemplos de la demo, y añadirles un servicio java/kotlin que integre los componentes que quiera usar de mlkit con el que me pueda comunicar fácilmente desde la aplicación delphi.

Esta última opción es la más asequible de desarrollar (al menos de momento). Y es realmente sencillo empezar intercambiando texto para traducir entre la aplicación  delphi y el servicio java/kotlin.

Ya hay muchos recursos que hablan de como hacer los intents entre apps en android:  [http://www.blong.com/Articles/DelphiXE6AndroidActivityResult/ActivityResult.htm](http://www.blong.com/Articles/DelphiXE6AndroidActivityResult/ActivityResult.htm)  
Por eso no no quiero repetir conceptos, pero si que comentaré algunos puntos clave.

Las demos del proyecto mlkit son sencillas pero exponen claramente las funcionalidades de los modelos. No exponen ningún servicio ni tampoco las puedes invocar por intents.

No soy un experto en Andorid Studio, pero hare una pequeña introducción:  
Primero descarga la última versión, en la actualidad ladybug.  
[Cómo descargar Android Studio y App Tools \- Android Developers](https://developer.android.com/studio?hl=es-419)

En mi caso, ya tenía instalada una versión anterior de Android Studio. ,me recomienda desinstalar versiones anteriores, aunque conservará algunas cosas.  
No hay gran problema en la instalación, pero surgen problemas con las versiones de proyectos anteriores, principalmente con Gradle..

Gradle es un proyecto que sirve para sincronizar los recursos necesarios para un proyecto. También para actualizarse a sí mismo. Sería parecido a un pip de python o un npm de node.  
Hay recursos que los puede instalar en la propia carpeta del proyecto, pero normalmente instala las dependencias en una carpeta cache común a todos los proyectos. Es decir, supongamos que varios proyectos necesitan una versión de una librería. Gradle solo la instala una vez en la cache común.

En los proyectos de Android Studio suele haber varios archivos esquemas y scripts relacionados con gradle. Especialmente ‘build.gradle’ donde están definidas las dependencias y versiones 

Versiones más recientes de Android Studio deprecan versiones antiguas de gradle.  
Gradle es bastante riguroso con las versiones. 

Si tienes proyectos ‘legacy’ antiguos que necesitan versiones concretas tienes que tener cuidado, pero en mi caso son proyectos recientes, y puedo elegir las actualizaciones que propone el propio Gradle.

[ML Kit  |  Google for Developers](https://developers.google.com/ml-kit/guides)

Empezaré explorando el proyecto translate-showcase, que ilustra el uso de los modelos de visión ,reconocimiento de idioma y traducción. Todo Integrado en una sevilla aplicación que actúa de ocr sobre una imagen, reconoce el idioma y es capaz de traducir a otros idiomas.

Mi intención es usar esas características desde una app externa, comunicándose con intents. 

Clono el proyecto y le pongo el nombre VidasTraduki, como referencia al esperanto, porque quiero que tenga preconfigurado el esperanto como lenguaje principal y que usaremos desde la APP Voludi.

Básicamente solo he añadido un servicio con el que poder comunicarnos externamente.

El proyecto está en el repositorio:  
[vidastraduki](https://github.com/miteruel/skills-introduction-to-github/tree/main/dia/dia1/vidastraduki)

Una vez instalada  
La APK ejemplo se puede descargar desde  
[vidastraduki.apk](https://github.com/miteruel/skills-introduction-to-github/raw/refs/heads/main/voludi/bin/vidastraduki.apk)

