<h1 align="center"> Progetto-Programmazione-Ad-Oggetti </h1>
<h1 align="center"> FindJobs :briefcase: </h1> 
<p align="center">
Questa applicazione ha lo scopo di effettuare ricerche di offerte di lavoro a seconda di filtri desiderati, come ad esempio la città, il linguaggio di programmazione utilizzato oppure la tipologia di lavoro (se in smartworking o meno).
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
esigenze. Inoltre è in grado di applicare diversi filtri combinati per far in modo di trovare il lavoro più adatto a colui che utilizza l'applicazione, oltre che a generare delle statistiche utili al client.

Scritto interamente in Java, supportato dalle varie librerie Maven, Spring e Json Simple il programma non appena viene mandato in esecuzione, inizierà a raccogliere i dati
di migliaia di offerte di lavoro(in ambito informatico) dal sito https://findwork.dev/api/jobs/ per poi metterle a disposizione dell'utente che, utilizzando un programma che
effettua richieste HTTP può effettuare diverse tipologie di ricerche tra i vari lavori, filtrandoli a seconda della città in cui si trovano e/o a seconda  dei linguaggi di programmazione utilizzati e/o in base alla tipologia di lavoro (in remoto o in presenza). Il programma quindi restituirà all utente un'elenco delle offerte di lavoro trovate, le quali conterranno diverse informazioni utili all'utente, insieme a delle statistiche sulla ricerca effettuata.


<a name="install"></a>
## Installazione e configurazione
La nostra applicazione è facilmente installabile digitando nel promt dei comandi la seguente riga:

```
git clone https://github.com/S1078475/Progetto-prog-a-oggetti

```
O in alternativa utilizzando il seguente [link](https://github.com/S1078475/Progetto-prog-a-oggetti/archive/refs/heads/main.zip).

Per avviarla sarà necessario avere un'ambiente di sviluppo per Java, come ad esempio Eclipse, installabile cliccando sul seguente [link](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers).

Sarà necessario anche importare la libreria JSON-Simple di Google, scaricabile da questo [link](https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/json-simple/json-simple-1.1.1.jar).

Una volta installato l'ambiente di sviluppo, ed importato correttamente il file come Maven Project, si può procedere con l'esecuzione del programma come applicazione SpringBoot.

Subito dopo l'avvio in console appariranno una serie di stampe che indicano che il programma è in esecuzione, e che sta scansionando le varie pagine dal sito https://findwork.dev/api/jobs/. Verrà mostrato l'avanzamento ogni 20 pagine e quando la scansione sarà terminata, verranno mostrati in console due valori: in numero totale delle pagine scansionate e il totale delle offerte di lavoro trovate (che sono in continuo aggiornamento nel sito da cui vengono estratte le informazioni).

Terminato ciò l'utente può effettuare le ricerche desiderate utilizzando un software che effettui richieste HTTP, come ad esempio [Postman](https://www.postman.com), immettendo le rotte che verranno spiegate in seguito. 


<a name="rotte"></a>
## Rotte
L'utente dovrà quindi effettuare le richieste tramite l'applicativo HTTP [Postman](https://www.postman.com), e queste dovranno essere all'indirizzo:
```
localhost:8080
```
Per poi proseguire digitando le seguenti rotte:

**N°** | **Tipo** | **Rotta** | **Descrizione**
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` |  [`/help`](#1) | *Questa rotta restituisce al client un messaggio contenente dei suggerimenti riguardo diverse città e linguaggi di programmazione da utilizzare nelle ricerche delle offerte di lavoro.*
[2](#2) | ` GET ` | [`/city/{CityName}`](#2) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro nella città inserita nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[3](#3) | ` GET ` | [`/language/{Language}`](#3) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che utilizzano quel linguaggio di programmazione inserito nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[4](#4) | ` GET ` | [`/isremote/{TrueOrFalse}`](#4) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro in remoto o in presenza, in base a ciò che si è scritto nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[5](#5) | ` GET ` | [`/search/language/{Language}/cities/{City}`](#5) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro nella città inserita in input dal client e che utilizzano quel linguaggio di programmazione richiesto. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*
[6](#6) | ` GET ` | [`/search/language/{Language}/cities/{City}/remote/{TrueOrFalse}`](#6) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro nella città inserita in input dal client, che utilizzano quel linguaggio di programmazione, che sono in remoto o meno. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*

Per effettuare le richieste con successo bisgona assicurarsi che esse siano di tipo GET, altrimenti si riceverà un messaggio di errore. Di seguito verranno spiegate le varie rotte con alcuni esempi.

<a name="1"></a>
## 1.  /help
La prima rotta restituisce al client un semplice messaggio contenente al suo interno 5 suggerimenti di città e 3 suggerimenti di linguaggi di programmazione da utilizzare poi nelle successive rotte per effettuare le varie ricerche.

<a name="2"></a>
## 2. /city/{CityName}
La seconda rotta (di tipo GET) presa in ingresso una città, restituisce all'utente una stringa contenente tutte le offerte di lavoro in quella città richiesta. All'interno dell'offerta di lavoro saranno presenti diverse informazioni utili al client quali: il ruolo dell'azienda nel mercato, la ragione sociale, la località, l'url del sito web, un testo descrittivo, i linguaggi di programmazione utilizzati (citati in keywords e nella descrizione), la data di inserimento dell'annuncio e se è un lavoro che si svolge in remoto o meno.
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

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
L'utente potrà quindi inserire qualsiasi città esso desideri, purchè questa esista tra gli annunci di lavoro disponibili e sia scritta correttamente (indifferentemente se questa venga scritta in CAPS o meno). 

![postman1](https://user-images.githubusercontent.com/93586306/149310607-ee1008fa-ec71-461c-bb61-81f3be80c9f1.png)



<a name="3"></a>
## 3. /language/{Language}
La terza rotta (di tipo GET) prende in ingresso un linguaggio di programmazione e restituisce all'utente una stringa contenente tutte le offerte di lavoro di aziende informatiche che utilizzano quel linguaggio di programmazione richiesto. Anche in questo caso all'interno di ciascun offerta di lavoro saranno presenti diverse informazioni utili al client quali: il ruolo dell'azienda nel mercato, la ragione sociale, la località, l'url del sito web, un testo descrittivo, i linguaggi di programmazione utilizzati (citati in keywords e nella descrizione), la data di inserimento dell'annuncio e se il lavoro si svolge in remoto o meno.
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

Quindi l'utente potrà inserire qualsiasi linguaggio di programmazione esso desideri, purchè questo esista tra gli annunci di lavoro disponibili e sia scritto correttamente (indifferentemente se questo venga scritta in CAPS o meno).

![postman2](https://user-images.githubusercontent.com/93586306/149310722-cc66fd15-a890-45fd-b3e3-76cab0abb4ae.png)



<a name="4"></a>
## 4. /isremote/{TrueOrFalse}

La quarta rotta (di tipo GET) può prendere in ingresso **true** oppure **false**. Nel primo caso, se **true**, il programma restituirà al client una stringa contenente tutti quei lavori che oltre a lavorare in presenza si svolgono anche a distanza in smartworking. Altrimenti se si digita **false** il programma restituirà al client una stringa contenente tutti quei lavori che non adoperano lo smartworking. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

<a name="5"></a>
## 5. /search/language/{Language}/cities/{City}
La quinta rotta (di tipo GET) può prendere in ingresso sia un linguaggio di programmazione e sia una o più città per cui l'utente vuole cercare offerte di lavoro. Nel caso di un linguaggio e una città, il programma restituirà al client tutte le offerte di lavoro in quella città scelta ed utilizzano quel linguaggio di programmazione. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

Per effettuare ricerche per più di una città sarà necessario aggiungere uno slash e successivamente inserire il nome di un'altra città. Quindi l'utente potrà richiedere all'applicazione di effettuare ricerche combinate per un linguaggio e da 1 a 5 città diverse.

 **Rotta** | **Descrizione**
 ---------- | ------------
 ` /search/language/{Language}/cities/{City} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in una determinata città, che utilizzano un linguaggio di programmazione.*
 ` /search/language/{Language}/cities/{City1}/{City2} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro nelle due città, che utilizzano un linguaggio di programmazione.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in tre città, che utilizzano un linguaggio di programmazione.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in quattro città, che utilizzano un linguaggio di programmazione.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5} ` |*Rotta che il client può utilizzare per cercare offerte di lavoro in cinque città, che utilizzano un linguaggio di programmazione.*
 
Anche in questo caso l'utente potrà inserire qualsiasi linguaggio di programmazione o qualsiasi città a suo piacimento, con la condizione che questi siano presenti tra le offerte di lavoro disponibili e siano scritti correttamente (il programma non tiene conto di input di maiuscole o minuscole).

![postman3](https://user-images.githubusercontent.com/93586306/149310788-1d68c191-d699-4716-bbcb-f6ba4f0460ca.png)


 <a name="6"></a>
## 6. /search/language/{Language}/cities/{City}/remote/{TrueOrFalse}
 La sesta ed ultima rotta (sempre di tipo GET) può prendere in ingresso un linguaggio di programmazione, la tipologia di lavoro (se si svolge in remoto o meno) e una o più differenti città (fino a 5) per cui sono pubblicati gli annunci di lavoro. Nel caso vengano digitati un linguaggio, una città e **true** o **false** (alla voce "remote"), il programma restituirà al client tutte le offerte di lavoro in quella città scelta, che utilizzano quel linguaggio di programmazione ed che si svolgono o meno in smartworking. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.
 
 ![postman4](https://user-images.githubusercontent.com/93586306/149310828-eb10e50b-dcdd-4409-a47a-0a27455c5d73.png)



 Per effettuare ricerche per più di una città sarà necessario aggiungere uno slash dopo l'ultima città digitata e successivamente inserire il nome di un'altra città. Quindi l'utente potrà richiedere all'applicazione di effettuare ricerche combinate per un linguaggio, lavoro remoto o non e da 1 a 5 città diverse.
 
  **Rotta** | **Descrizione**
 ---------- | ------------
 ` /search/language/{Language}/cities/{City}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in una città, che utilizzano un linguaggio di programmazione, operando in remoto o meno.*
 ` /search/language/{Language}/cities/{City1}/{City2}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in due città, che utilizzano un linguaggio di programmazione, operando in remoto o no.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in tre città, che utilizzano un linguaggio di programmazione, operando in remoto o no.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro in quattro città, che utilizzano un linguaggio di programmazione, operando in remoto o no.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}/remote/{TrueOrFalse} ` |*Rotta che il client può utilizzare per cercare offerte di lavoro in cinque città, che utilizzano un linguaggio di programmazione, operando in remoto o no.*
 
 
 Anche in questo caso l'utente potrà inserire qualsiasi linguaggio di programmazione o qualsiasi città a suo piacimento, con la condizione che questi siano presenti tra le offerte di lavoro disponibili e siano scritti correttamente (il programma non tiene conto di input di maiuscole o minuscole).
 
![postman5](https://user-images.githubusercontent.com/93586306/149310864-3ff1d599-b5ba-4419-a07f-5d9eb41124f2.png)


<a name="uml"></a>
## Diagrammi UML



### Use Case Diagram


![use-case](https://user-images.githubusercontent.com/93586306/149311703-2c4e6eb3-85f1-4376-a8d1-c1617e396869.png)


### Class Diagram

![class-diagram](https://user-images.githubusercontent.com/93586306/149541989-0a4bc03d-4dfb-4e79-a6af-522a4e5911e7.jpg)



### Sequence Diagram

####  :heavy_check_mark:Avvio dell'applicazione
![Sequence2-EXE](https://user-images.githubusercontent.com/93586306/149542242-d19ba612-b791-4323-9a64-2e016318e469.jpg)



####  :heavy_check_mark:Rotta /help
![sequence1-HELP](https://user-images.githubusercontent.com/93586306/149491077-7d53a971-7727-4563-8cb9-6e64c8470a43.png)



#### :heavy_check_mark:Rotta /search/language/{linguaggio}/cities/{city1}
![Sequence3 - RicercaCombinata](https://user-images.githubusercontent.com/93586306/149490621-fe130dcc-23a0-4aa5-b042-bca01783aeaf.jpg)


#### :heavy_check_mark:Rotta /search/language/{linguaggio}/cities/{city1}/remote/{TrueOrFalse}
![Sequence4-RicercaCombinata2](https://user-images.githubusercontent.com/93586306/149490737-7223ec94-c12b-4cd9-9706-cded887abeba.jpg)




<a name="doc"></a>
## Documentazione
La nostra applicazione è interamente documentata in Javadoc. Troverete i vari file html all'interno del progetto. 
