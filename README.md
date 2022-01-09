<h1 align="center"> Progetto-Programmazione-Ad-Oggetti </h1>
<h1 align="center"> FindJobs </h1> 
<p align="center">
Questa nostra applicazione ha lo scopo di effettuare ricerche di offerte di lavoro a seconda di filtri desiderati, come ad esempio la città, il linguaggio di programmazione utilizzato oppure la tipologia di lavoro(se in smartworking o meno).
</p>
  
## **Scaletta dei contenuti**

* [Introduzione](#intro)
* [Installazione e configurazione](#install)
* [Rotte](#rotte)
* [Diagrammi UML](#uml)
* [Documentazione](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Introduzione
FindJobs è un applicazione Rest Web Service nata con lo scopo di aiutare studenti neolaureati in ingegneria informatica nella ricerca di un lavoro a seconda delle proprie 
esigenze. Inoltre è in grado di applicare diversi filtri combinati per far in modo di trovare il lavoro più adatto a colui che utilizza l'applicazione.

Scritto interamente in Java, supportato dalle varie librerie Maven, Spring e Json Simple il programma non appena viene mandato in esecuzione, inizierà a raccogliere i dati
di migliaia di offerte di lavoro(in ambito informatico) dal sito https://findwork.dev/api/jobs/ per poi metterle a disposizione dell'utente che, utilizzando un programma che
effettua richieste HTTP può effettuare diverse tipologie di ricerche tra i vari lavori, filtrandoli a seconda della città in cui si trovano e/o a seconda  dei linguaggi di programmazione utilizzati e/o in base alla tipologia di lavoro(se operano solo in presenza o anche in remoto con smartworking). Il programma quindi restituirà all utente un'elenco delle offerte di lavoro trovate in formato JSON, i quali conterranno diverse informazioni utili all'utente. 


<a name="install"></a>
## Installazione e configurazione
La nostra applicazione è facilmente installabile digitando nel promt dei comandi la seguente riga:

```
git clone https://github.com/S1078475/Progetto-prog-a-oggetti

```
O in alternativa utilizzando il seguente [link](https://github.com/S1078475/Progetto-prog-a-oggetti/archive/refs/heads/main.zip).

Per avviarla sarà necessario avere un'ambiente di sviluppo per Java, come ad esempio Eclipse, installabile cliccando nel seguente [link](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers).

Una volta installato l'ambiente di sviluppo, ed importato correttamente il file come Maven Project, si può procedere con l'esecuzione del programma.

Subito dopo l'avvio in console appariranno una serie di stampe che indicano che il programma è in esecuzione, e che sta scansionando le varie pagine dal sito https://findwork.dev/api/jobs/. Verrà mostrato l'avanzamento ogni 20 pagine e quando la scansione sarà terminata, verranno mostrati in console due valori: in numero totale delle pagine scansionate e il totale delle offerte di lavoro trovate(che sono in continuo aggiornamento nel sito da cui vengono attinte tali informazioni).

Terminato ciò l'utente può effettuare le ricerche desiderate utilizzando un software che effettui richieste HTTP, come ad esempio [Postman](https://www.postman.com), immettendo le rotte che verranno spiegate in seguito. 


<a name="rotte"></a>
## Rotte




<a name="uml"></a>
## Diagrammi UML






<a name="doc"></a>
## Documentazione





<a name="autor"></a>
## Autori del progetto :computer:
Nome  | Contributo
---- | ----
[Leonardo Pescetti](https://github.com/leopes99) | 50%
[CLaudio Tomaiuolo](https://github.com/S1078475) | 50%
