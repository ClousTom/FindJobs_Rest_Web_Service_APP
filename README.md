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
esigenze. Inoltre è in grado di applicare diversi filtri combinati per far in modo di trovare il lavoro più adatto a colui che utilizza l'applicazione, oltre che a generare delle statistiche utili al client.

Scritto interamente in Java, supportato dalle varie librerie Maven, Spring e Json Simple il programma non appena viene mandato in esecuzione, inizierà a raccogliere i dati
di migliaia di offerte di lavoro(in ambito informatico) dal sito https://findwork.dev/api/jobs/ per poi metterle a disposizione dell'utente che, utilizzando un programma che
effettua richieste HTTP può effettuare diverse tipologie di ricerche tra i vari lavori, filtrandoli a seconda della città in cui si trovano e/o a seconda  dei linguaggi di programmazione utilizzati e/o in base alla tipologia di lavoro(se operano solo in presenza o anche in remoto con smartworking). Il programma quindi restituirà all utente un'elenco delle offerte di lavoro trovate, le quali conterranno diverse informazioni utili all'utente, insieme a delle statistiche sulla ricerca effettuata.


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
[1](#1) | ` GET ` |  [`/help`](#1) | *Questa rotta restituisce al client un messaggio contenente dei suggerimenti riguardo diverse città e linguaggi di programmazione da utilizzare nelle ricerche delle offerte di lavoro.*
[2](#2) | ` GET ` | [`/city/{CityName}`](#2) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[3](#3) | ` GET ` | [`/language/{Language}`](#3) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che utilizzano quel linguaggio di programmazione inserito nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[4](#4) | ` GET ` | [`/isremote/{TrueOrFalse}`](#4) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano in remoto o no, in base a ciò che si è scritto nella rotta. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili.*
[5](#5) | ` GET ` | [`/search/language/{Language}/cities/{City}`](#5) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita in input dal client e che utilizzano quel linguaggio di programmazione richiesto. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*
[6](#6) | ` GET ` | [`/search/language/{Language}/cities/{City}/remote/{TrueOrFalse}`](#6) | *Questa rotta restituisce una stringa contenente tutte le offerte di lavoro di aziende che operano nella città inserita in input dal client, che utilizzano quel linguaggio di programmazione e che operano o meno in smartworking. Per ogni offerta di lavoro trovata verranno mostrate diverse informazioni utili. La ricerca potrà essere estesa fino a 5 città diverse.*

Per effettuare le richieste con successo bisgona assicurarsi che esse siano di tipo GET, altrimenti si riceverà un messaggio di errore. Di seguito verranno spiegate le varie rotte con alcuni esempi.

<a name="1"></a>
## 1.  /help
La prima rotta restituisce al client un semplice messaggio contenente al suo interno 5 suggerimenti di città e 3 suggerimenti di linguaggi di programmazione da utilizzare poi nelle successive rotte per effettuare le varie ricerche.

<a name="2"></a>
## 2. /city/{CityName}
La seconda rotta(di tipo GET) presa in ingresso una città, restituisce all'utente una stringa contenente tutte le offerte di lavoro di imprese che operano in quella città richiesta. All'interno dell offerta di lavoro saranno presenti diverse informazioni utili al client quali: il ruolo dell'azienda nel mercato, la ragione sociale, la località, l'url del sito web, un testo descrittivo, i linguaggi di programmazione utilizzati(situati in keywords), la data di inserimento dell'annuncio e se l'azienda opera anche in remoto o meno.
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
L'utente potrà quindi inserire qualsiasi città esso desideri, purchè questa esista tra gli annunci di lavoro disponibili e sia scritta correttamente(indifferentemente se questa venga scritta in CAPS o meno). 

![postman1](https://user-images.githubusercontent.com/93586306/149310607-ee1008fa-ec71-461c-bb61-81f3be80c9f1.png)



<a name="3"></a>
## 3. /language/{Language}
La terza rotta(di tipo GET) prende in ingresso un linguaggio di programmazione e restituisce all'utente una stringa contenente tutte le offerte di lavoro di aziende informatiche che utilizzano quel linguaggio di programmazione richiesto. Anche in questo caso all'interno di ciascun offerta di lavoro saranno presenti diverse informazioni utili al client quali: il ruolo dell'azienda nel mercato, la ragione sociale, la località, l'url del sito web, un testo descrittivo, i linguaggi di programmazione utilizzati(situati in keywords), la data di inserimento dell'annuncio e se l'azienda opera anche in remoto o meno.
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

Quindi l'utente potrà inserire qualsiasi linguaggio di programmazione esso desideri, purchè questo esista tra gli annunci di lavoro disponibili e sia scritto correttamente(indifferentemente se questo venga scritta in CAPS o meno).

![postman2](https://user-images.githubusercontent.com/93586306/149310722-cc66fd15-a890-45fd-b3e3-76cab0abb4ae.png)



<a name="4"></a>
## 4. /isremote/{TrueOrFalse}

La quarta rotta (di tipo GET) può prendere in ingresso **true** oppure **false**. Nel primo caso, se **true**, il programma restituirà al client una stringa contenente tutti quei lavori che oltre a lavorare in presenza operano anche a distanza in smartworking. Altrimenti se si digita **false** il programma restituirà al client una stringa contenente tutti quei lavori che non adoperano lo smartworking. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

<a name="5"></a>
## 5. /search/language/{Language}/cities/{City}
La quinta rotta (di tipo GET) può prendere in ingresso sia un linguaggio di programmazione e sia una o più città per cui l'utente vuole cercare offerte di lavoro. Nel caso di un linguaggio e una città, il programma restituirà al client tutte le offerte di lavoro di aziende che operano in quella città scelta ed utilizzano quel linguaggio di programmazione. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.

Per effettuare ricerche per più di una città sarà necessario aggiungere uno slash e successivamente inserire il nome di un'altra città. Quindi l'utente potrà richiedere all'applicazione di effettuare ricerche combinate per un linguaggio e da 1 a 5 città diverse.

 **Rotta** | **Descrizione**
 ---------- | ------------
 ` /search/language/{Language}/cities/{City} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione ed operano in una città.*
 ` /search/language/{Language}/cities/{City1}/{City2} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione ed operano in due città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione ed operano in tre città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione ed operano in quattro città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5} ` |*Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione ed operano in cinque città.*
 
Anche in questo caso l'utente potrà inserire qualsiasi linguaggio di programmazione o qualsiasi città a suo piacimento, con la condizione che questi siano presenti tra le offerte di lavoro disponibili e siano scritti correttamente(il programma non tiene conto di input di maiuscole o minuscole).

![postman3](https://user-images.githubusercontent.com/93586306/149310788-1d68c191-d699-4716-bbcb-f6ba4f0460ca.png)


 <a name="6"></a>
## 6. /search/language/{Language}/cities/{City}/remote/{TrueOrFalse}
 La sesta ed ultima rotta(sempre di tipo GET) può prendere in ingresso un linguaggio di programmazione, la tipologia di lavoro(se l'azienda opera o meno anche in remoto) e una o più differenti città(fino a 5) per cui sono pubblicati gli annunci di lavoro. Nel caso vengano digitati un linguaggio, una città e **true** o **false**(alla voce "remote"), il programma restituirà al client tutte le offerte di lavoro di aziende che operano in quella città scelta, utilizzano quel linguaggio di programmazione ed operano o meno in smartworking. 
Tutto questo assieme a delle statistiche che conterranno dei dati riassuntivi sulla ricerca effettuata.
 
 ![postman4](https://user-images.githubusercontent.com/93586306/149310828-eb10e50b-dcdd-4409-a47a-0a27455c5d73.png)



 Per effettuare ricerche per più di una città sarà necessario aggiungere uno slash(dopo l'ultima città digitata) e successivamente inserire il nome di un'altra città. Quindi l'utente potrà richiedere all'applicazione di effettuare ricerche combinate per un linguaggio, lavoro remoto o non e da 1 a 5 città diverse.
 
  **Rotta** | **Descrizione**
 ---------- | ------------
 ` /search/language/{Language}/cities/{City}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione,operando in remoto o non ed operano in una città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione,operando in remoto o non ed operano in due città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione,operando in remoto o non ed operano in tre città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/remote/{TrueOrFalse} ` | *Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione,operando in remoto o non ed operano in quattro città.*
 ` /search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}/remote/{TrueOrFalse} ` |*Rotta che il client può utilizzare per cercare offerte di lavoro di aziende che utilizzano un linguaggio di programmazione,operando in remoto o non ed operano in cinque città.*
 
 
 Anche in questo caso l'utente potrà inserire qualsiasi linguaggio di programmazione o qualsiasi città a suo piacimento, con la condizione che questi siano presenti tra le offerte di lavoro disponibili e siano scritti correttamente(il programma non tiene conto di input di maiuscole o minuscole).
 
![postman5](https://user-images.githubusercontent.com/93586306/149310864-3ff1d599-b5ba-4419-a07f-5d9eb41124f2.png)


<a name="uml"></a>
## Diagrammi UML



### Use Case Diagram


![use-case](https://user-images.githubusercontent.com/93586306/149311703-2c4e6eb3-85f1-4376-a8d1-c1617e396869.png)


### Class Diagram

![class-diagram](https://user-images.githubusercontent.com/93586306/149367416-23f1909e-bc45-4ba1-92f1-9eb4e79d1d9e.jpg)


### Sequence Diagram



<a name="doc"></a>
## Documentazione
La nostra applicazione è interamente documentata in Javadoc. Troverete i vari file html all'interno del progetto. 

<a name="autor"></a>
## Autori del progetto :computer:
Nome  | Contributo
---- | ----
[Leonardo Pescetti](https://github.com/leopes99) | 50%
[CLaudio Tomaiuolo](https://github.com/S1078475) | 50%
