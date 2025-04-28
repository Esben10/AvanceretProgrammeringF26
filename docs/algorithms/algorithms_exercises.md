# Øvelser: Algoritmer

## 1. Tegn en hægtet liste

Kig på klassen `reversedlinkedlist.ListFactory` som kan bygge hægtede lister til os.

Din opgave er 

- Tegn den liste, der returneres fra kaldet `buildList(..)` med et array `{1, 5, 7, 12, 17}`. 
  - Tegn de forskellige `Node` objekter med attributter
  - Tegn pile fra attributter til de objekter, der refereres til
    
Bonusspørgsmål: Hvordan kan man på koden alene se, at listen ender ved null? Og hvordan kunne man have lavet en cyklus i stedet?


## 2. Reverser listen

Du skal nu lave en metode, som kan vende listen om. Det vil sige, at hvis vi giver en liste i form af en `Node` (listens head) som parameter til 
metoden, skal den returnere en `Node`  som er head i den omvendte liste.

Fx bliver listen 

```java 
1 ⟶ 2 ⟶ 3 ⟶ 4 ⟶ 5 ⟶ null 
```

til 

```java 
5 ⟶ 4 ⟶ 3 ⟶ 2 ⟶ 1 ⟶ null
```

Opgaven er nu

- Lav en metode `public Node reverseList(Node n)` som tager en `Node` og 
returnerer head-`Node` i den omvendte liste (du kan lave den i `Main`)
  - Du løser opgaven ved at få hver enkelt `Node` til at pege på sin nuværende foregående `Node` i stedet for sin nuværende næste 
  - Du kan med fordel skrive din kode i pseudokode før du implementerer den for at øve dig i at tænke algoritmisk. Det er her pointer-kontrol kommer ind.  
  - Test din kode ved at køre `main` i klassen `Main`. (hint: du skal override `toString()` i `Node`)
  


## 3. Tegn en cyklisk liste
Kig på klassen `circularlinkedList.ListFactory`. 

- Tegn den liste, der returneres fra et kald til `buildListWithCycle()`
    - Tegn de forskellige `Node` objekter med attributter
    - Tegn pile fra attributter til de objekter, der refereres til

## 4. Lav en cycle detector
Du skal nu lave en metode, som kan detektere om en liste er cyklisk. Det vil sige, at hvis vi giver en `Node` (ikke nødvendigvis head) til 
metoden, skal den returnere `true` eller `false` alt efter om listen er cyklisk eller ej. 

Fx vil et kald med listen 

```java 
1 ⟶ 2 ⟶ 3 ⟶ 4 ⟶ 5 ⟶ null 
```

returnere `false` mens et kald med listen

```java 
1 ⟶ 2 ⟶ 3 ⟶ 4 ⟶ 5 ⟶ 1 ⟶ ..osv 
```
vil returnere `true`.

Opgaven er nu

- Lav en metode `public boolean hasCycle (Node head)` (fx i klassen `circularlinkedlist.Main`) som tager en `Node` som parameter og returnerer
en boolean, der angiver om listen er cycklisk. 
  - Du skal bruge to pointere `slow` og `fast`
  - `slow` skal bevæge sig gennem listen ét skridt ad gangen
  - `fast` skal bevæge sig gennem listen to skridt ad gangen
  - Hver gang de to pointere har flyttet sig skal du undersøge om de har ramt hinanden
  - Hvis rammer hinanden returneres `true`.
  - Hvis `fast` når enden af listen returneres `false`
  - Test din kode ved at køre `main` i klassen `Main`

Bonusopgave: Kan du forudse hvad `floydexample.TraversingArrays` vil returnere med inputtet ` int[] test = {2, 0, 1}` og hvorfor?

## 5. BFS

Kig på klassen `graphsearch.SearchStrategies`. I klassen er metoden `searchBFS(..)`. 

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør. 
- Tegn evt indholdet af køen iteration for hver iteration. 
- Overvej hvad det betyder, at vi bruger en `Queue` (hint: det er en FIFO struktur).


## 6. DFS

Kig på klassen `graphsearch.SearchStrategies`. I klassen er metoden `searchDFS(..)`.

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn evt indholdet af stakken iteration for hver iteration.
- Overvej hvad det betyder, at vi bruger et `Deque` (hint: det er en LIFO struktur).

Bonusspørgsmål: Hvordan kan vi bruge `ArrayDeque` som både stak og kø? 

## 7. Implementer din egen BFS og DFS

Kig på klasserne `treesearch.Node` og `treesearch.SearchStrategies`. Klassen `Node` repræsenterer en node i et træ, 
som kan have andre noder som børn. 

Opgaven er nu

- Implementer metoderne `searchBFS(..)` og `searchDFS(..)`
- Hent inspiration i `graphsearch.SearchStrategies`. Du skal ikke kopiere koden fra `graphsearch` pakken,
men forstå hvordan der traverseres gennem grafen og gøre det samme i dine træer. 

Bonusspørgsmål: hvordan udvider vi til at detektere cyklusser? Se klassen `graphsearchcycles.SearchStrategies`.