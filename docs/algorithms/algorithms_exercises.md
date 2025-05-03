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

Bonusopgave: Kan du forudse hvad `floydexample.TraversingArrays.hasCycle(..)` vil returnere med inputtet ` int[] test = {2, 0, 1}` og hvorfor?

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

- Implementer metoderne `searchBFS(..)` og `searchDFS(..)`.
- Hent inspiration i `graphsearch.SearchStrategies`. Du skal ikke kopiere koden fra `graphsearch` pakken,
men forstå hvordan der traverseres gennem grafen og gøre det samme i dine træer. 

Bonusspørgsmål: hvordan udvider vi til at detektere cyklusser? Se klassen `graphsearchcycles.CycleDetector`.

## Bonus

Kig på pakken `undirectedgraphs` hvor der arbejdes med grafer, hvor kanterne er urettede. Det gør, at vi skal 
bruge en anden strategi for at finde ud af om der er cyklus i grafen. 

I pseudokode ser det sådan ud: 
1. Start traversal fra en node
2. Marker den som visited
3. For hver nabo:
   - a. Hvis nabo ikke er visited:
     - DFS på nabo (med current som parent)
   - b. Hvis nabo er visited:
     - Hvis nabo != parent:
       - Cyklus fundet!

Kig på koden og se om du kan tegne på papir hvad der sker. Du kan tilføje nogle udprint
i metoden og se om din tegning stemmer overens med output fra metoden. 

## 8. Prøv alle muligheder - følg koden

Kig på koden i `algorithms/TryBacktrack`. Der er fem metoder, som printer forskellige tal- eller strengkombinationer.
Du skal først gætte, hvad output bliver – og bagefter teste din forståelse. Kig på de første
tre og skriv ned, hvad de vil printe

Opgaven er altså 

- hvad printer `simpleForloop()`?
- hvad printer `innerLoop()`?
- hvad printer `moreInnerLoops()`?
- Kør `main` og se om du har ret. 

Kig dernæst på koden i `explore(..)`. Den printer det samme som `moreInnerLoops()`. Forstår du hvorfor?

Opgaven er 

- hvad bruges parametrene `step` og `path` til?
- hvorfor har vi brug for parametre her, men ikke i fx `moreInnerLoops()`?

Bonus:Se på `exploreWithBacktrack(...)`. Hvad ændrer sig i output? (Se om du kan gennemskue det før du kører koden)

## 9. Maze solver

Du har en labyrint, du skal gå igennem. Labyrinten er repræsenteret af et to-dimensionelt array hvor
- `1` betyder "du kan gå her"
- `0` betyder "mur - her kan du ikke gå"

Labyrinten kan fx se sådan ud: 

```java
int[][] maze = {
{1, 0, 1, 1},
{1, 1, 1, 0},
{0, 0, 1, 1},
{1, 1, 0, 1}
};
```

Du starter i øverste venstre hjørne (0,0) og skal finde vej til nederste højre hjørne (3,3). 

Kig på koden i `maze.MazeExercise`. Der mangler at blive implementeret en metode, der kan gå gennem labyrinten.
I kan med fordel arbejde sammen i par og skrive pseudokode for metoden inden I implementerer. 

Brug `int[][] path = new int[N][N];` til at holde styr på vejen gennem labyrinten. Den skal både bruges, når du 
printer løsningen og når du tjekker for om du allerede har besøgt et felt. 

Opgaven er nu

- Implementer metoden `solveMaze(..)`. For hvert skridt skal du
  - Tjekke om du går udenfor labyrintens grænser
  - Tjekke om feltet er gyldigt ([row][col] == 1)
  - Tjekke om feltet er en del af en sti du har prøvet før (`path`)
  - Tjekke om du har nået målet ([row][col] == 3)
  - Markere feltet som en del af stien (`path`)
  - Prøv de fire retninger én af gangen
    - ned
    - højre
    - op
    - venstre
  - Hvis ingen muligheder virker, så backtrack (og fjern feltet fra `path`)

Du kan søge inspiration i `backtracking/NQueeens` og der er vejledende løsninger i `mazesolution/MazeSolution`. 

## 10 Dovne beregninger

Kig på koden i `lazy.LazyCalculations`. Hvad sker der hvis vi kalder metoden `lazyFactorial(..)` med 5 som argument?
Og hvad sker der, hvis vi efterfølgende kalder metoden med 3 som argument? 

Lav din egen metode `lazySum(int i)` som summerer tallene fra 1 - n. 

Prøv at sætte counter på dine metoder og se hvor mange beregninger der udføres, når du kalder dem. 

Prøv at lave metoden `init()` som laver alle beregninger på forhånd. Lav derefter metoderne `eagerFactorial(..)` 
og `eagerSum(..)` som blot slår op i det map, der er lavet i `init()`. Sæt counter på dine metoder og se hvor mange beregninger, 
der udføres. Test i `main` hvor lang tid en beregning i de dovne metoder tager i forhold til de eager? Og hvor lang tid opstart
tager (kald til `init()`). Måske skal du lægge kunstig tid ind i beregningsdelene for at se en effekt på små datasæt. 

## 11 Grådig algoritme

Du skal lave en algoritme, som kan beregne hvor meget træ af forskellige længder vi skal bruge til at opnå en target-længde.

Vi har træ liggende i længderne 7, 5 og 2 meter. Så hvis vi skal bruge 12 meter, stykker vi det sammen af 7 og 5 meter. 

Opgaven er nu

- Lav en klasse `WoodHandler` med metoden `List<Integer> calculateWood(int target)` som tager en target-længde som parameter 
og returnerer en liste af de længder, vi skal bruge. Fx vil `calculateWood(11)` returnere en liste med tallene 7, 2, 2. 
- Hvis metoden ikke kan ramme target præcist, kan du lade den returnere det, der kommer tættest på. Fx skal `calculateWood(13)` returnere 
7, 5, 2. 
- Du kan også vælge at returnere `null` hvis metoden ikke kan ramme target præcist. 

I hvilke tilfælde giver den grådige algoritme den bedst mulige løsning –
og i hvilke tilfælde kunne færre stykker være muligt med en anden strategi?

Bonus: 
- Lav en lazy-version af calculateWood(int target), hvor vi husker tidligere beregninger
  - Brug fx Map<Integer, List<Integer>> til at cache løsninger
  - Så hvis vi igen skal bruge 11 meter, slår vi det bare op

- Find den løsning med færrest antal stykker ved hjælp af backtracking
  - Brug rekursion og prøv alle kombinationer
  - Gem den bedste (mindste) løsning


