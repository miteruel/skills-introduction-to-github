# ElisIA-2

	El nombre no es muy importante, pero de alguna forma hay que llamarlo.

El proyecto es complementar ELISA (ELaboración Informática de Seguros Agrarios), con nuevas herramientas de inteligencia artificial. 	  
	

# Agroseguro

El seguro Agropecuario en España se concentra en [Agroseguro](https://agroseguro.es/) que en un pool de compañías de seguro,  que trabajan los mismos productos y comparten ciertos gastos en conjunto, pero son competencia unas de otras. 

Es un mercado bastante dinámico ya que las pólizas se renuevan cada año,y  a menudo los agentes de seguro cambian de compañía, o los asegurados cambian de agente. 

Los seguros agrarios llevan muchos datos, hay que detallar todas las parcelas o explotaciones ganaderas a asegurar.

* Con datos como la identificación SIGPAC (un código de identificación catastral de una parcela), el cultivo y variedad, superficie , producción, edad o fecha de siembra, etc.. Según que tipo de capital asegurado hay que incluir unos datos u otros.

En muchos casos esos datos ya están en la base de datos o llegan en formatos fácil de leer por los programas de gestión actual.

    
Pero Gran parte del trabajo ‘pesado’ de gestión es cotejar o introducir largas listas de datos  a un programa de tarificación. 

El objetivo es crear agentes ‘inteligentes’ que puedan automatizar diferentes tareas de captura de datos y/o adecuación  posterior, que complementen a ELISA, que es el programa de gestión actual.

Uno de los objetivos es ampliar el rango de tipo de documentos que puedan leerse, especialmente pdf y fotos escaneadas

## Módulos del proyecto.

El proyecto se puede dividir en varias partes independientes, ya que no son específicas  de los seguros agrarios. Pero deben ser combinables.

* X2Agro : Conversor de formatos a Elisa/Agroseguro.  
* OrquestIA: Automatizador de Tareas. Orquestación de tareas IA , Scripting..  
  * MCP conectable.  
* UIAI : Interfaz de usuario . Windows. ¿Android?  
* API : Un Api General (que encapsule o incluya las API hijas).

Iré comentando las partes a medida que sea necesario.

X2Agro

“Convertir cualquier cosa a formato de Agroseguro.”

Herramientas que pueden transformar diferentes tipos de documento a un formato compatible con los programas de gestión.

* Conversión de formatos excel de los SIGPAC o de otras compañías de seguros..  
* Lectura de formatos PDF texto  
* OCR de imágenes o PDF gráfico. 

La parte a desarrollar conjuntamente es la lectura de pdf texto y OCR.  
Especialmente el formato PDF de póliza del propio agroseguro, aunque también  otros formatos.

¿Porque hacer un lector de pdf de pólizas de agroseguro a un formato compatible con agroseguro?   
El usuario es un agente de seguros , que le viene un cliente nuevo.  
Le trae el seguro del año pasado (en papel o formato digital)  hecho en otra compañia, donde ya estan los datos de su explotación agro-pecuaria de 100 parcelas.

Si quiere hacer un presupuesto, tendría que meter a mano en su programa de tarificación todos los datos de parcelas , con una media de 10 variables por parcela son muchos campos a escribir.

Usando X2Agro- PDF, en pocos minutos lo tendría introducido en el programa.

Exploramos varias alternativas

* pdfplumber : [jsvine/pdfplumber: Plumb a PDF](https://github.com/jsvine/pdfplumber)   
* py2pdf: [py-pdf/pypdf:](https://github.com/py-pdf/pypdf)  
* Camelot: [atlanhq/camelot: Camelot: PDF Table Extraction for Humans](https://github.com/atlanhq/camelot)  
* PdfMiner\_ [euske/pdfminer: Python PDF Parser (Not actively maintained). Check out pdfminer.six.](https://github.com/euske/pdfminer)  
* [microsoft/markitdown: Python tool for converting files and office documents to Markdown.](https://github.com/microsoft/markitdown)  
* [markitdown/packages/markitdown-mcp at main · microsoft/markitdown](https://github.com/microsoft/markitdown/tree/main/packages/markitdown-mcp)

  