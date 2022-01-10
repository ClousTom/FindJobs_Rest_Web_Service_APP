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
effettua richieste HTTP può effettuare diverse tipologie di ricerche tra i vari lavori, filtrandoli a seconda della città in cui si trovano e/o a seconda  dei linguaggi di programmazione utilizzati e/o in base alla tipologia di lavoro(se operano solo in presenza o anche in remoto con smartworking). Il programma quindi restituirà all utente un'elenco delle offerte di lavoro trovate, le quali conterranno diverse informazioni utili all'utente. 


<a name="install"></a>
## Installazione e configurazione
La nostra applicazione è facilmente installabile digitando nel promt dei comandi la seguente riga:

```
git clone https://github.com/S1078475/Progetto-prog-a-oggetti

```
O in alternativa utilizzando il seguente [link](https://github.com/S1078475/Progetto-prog-a-oggetti/archive/refs/heads/main.zip).

Per avviarla sarà necessario avere un'ambiente di sviluppo per Java, come ad esempio Eclipse, installabile cliccando nel seguente [link](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers).

Una volta installato l'ambiente di sviluppo, ed importato correttamente il file come Maven Project, si può procedere con l'esecuzione del programma come applicazione SpringBoot.

Subito dopo l'avvio in console appariranno una serie di stampe che indicano che il programma è in esecuzione, e che sta scansionando le varie pagine dal sito https://findwork.dev/api/jobs/. Verrà mostrato l'avanzamento ogni 20 pagine e quando la scansione sarà terminata, verranno mostrati in console due valori: in numero totale delle pagine scansionate e il totale delle offerte di lavoro trovate(che sono in continuo aggiornamento nel sito da cui vengono attinte tali informazioni).

Terminato ciò l'utente può effettuare le ricerche desiderate utilizzando un software che effettui richieste HTTP, come ad esempio [Postman](https://www.postman.com), immettendo le rotte che verranno spiegate in seguito. 


<a name="rotte"></a>
## Rotte
L'utente dovrà quindi effettuare le richieste tramite l'applicativo HTTP Postman, e queste dovranno essere all'indirizzo:
```
localhost:8080
```
Per poi proseguire digitando le seguenti rotte:

**N°** | **Tipo** | **Rotta** | **Descrizione**
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` |  `/help` | *Questa rotta restituisce al client un messaggio contenente dei suggerimenti riguardo diverse città e linguaggi di programmazione da utilizzare nelle ricerche delle offerte di lavoro.*
[2](#2) | ` GET ` | `/city/{CityName}` | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[3](#3) | ` GET ` | `/language/{Language}` | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che utilizzano quel linguaggio di programmazione inserito nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[4](#4) | ` GET ` | `/isremote/{TrueOrFalse}` | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano in remoto o no, in base a ciò che si è scritto nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[5](#5) | ` GET ` | `/search/language/{Language}/cities/{City}` | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita in input dal client e che utilizzano quel linguaggio di programmazione richiesto. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*
[6](#6) | ` GET ` | `/search/language/{Language}/cities/{City}/remote/{TrueOrFalse}` | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita in input dal client, che utilizzano quel linguaggio di programmazione e che operano o meno in smartworking. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*

Per effettuare le richieste con successo bisgona assicurarsi che esse siano di tipo GET, altrimenti si riceverà un messaggio di errore. Di seguito verranno spiegate le varie rotte con alcuni esempi.

<a name="1"></a>
## 1.  /help
La prima rotta restituisce al client un semplice messaggio contenente al suo interno 5 suggerimenti di città e 3 suggerimenti di linguaggi di programmazione da utilizzare poi nelle successive rotte per effettuare le varie ricerche.

<a name="2"></a>
## 2. /city/{CityName}
La seconda rotta presa in ingresso una città, restituisce all'utente una stringa contenente tutte le offerte di lavoro di imprese che operano in quella città richiesta. All'interno dell offerta di lavoro saranno presenti diverse informazioni utili al client quali: il ruolo dell'azienda nel mercato, la ragione sociale, la località, l'url del sito web, un testo descrittivo, i linguaggi di programmazione utilizzati(situati in keywords), la data di inserimento dell'annuncio e se l'azienda opera anche in remoto o meno.

Di seguito viene riportato un'esempio di offerta di lavoro che l'applicazione restituisce su postman: 
```
{
Id:102905
Role:Senior Node.js Full-stack developer
Company name:Blueprint.store
Company number of employees:null
Employment type:null
Location:London, UK
Remote:true
Logo:null
Url:https://findwork.dev/102905/senior-nodejs-full-stack-developer-at-blueprintstore
Text:Salary depending on experience: £60k-£90k; href="https:&#x2F;&#x2F;apply.workable.com&#x2F;blueprint-store&#x2F;j&#x2F;EE934DE909&#x2F;" rel="nofollow">https:&#x2F;&#x2F;apply.workable.com&#x2F;blueprint-store&#x2F;j&#x2F;EE934DE909&#x2F. Apply via form or email me at al blueprint.store.
Date posted:2022-01-05T16:33:18Z
Keywords:redux, aws, gcp
Source:Hn
}

```




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
