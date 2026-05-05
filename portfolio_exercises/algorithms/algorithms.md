# Portfolio: Algoritmer

## 1. Tegn en cyklisk liste
Kig på klassen `algorithms.circularlinkedList.ListFactory`. 

- Tegn den liste, der returneres fra et kald til `buildListWithCycle()`
    - Tegn de forskellige `Node` objekter med attributter
    - Tegn pile fra attributter til de objekter, der refereres til

## 2. Lav en cycle detector
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
  - Test din kode ved at køre `main` i klassen `circularlinkedlist.Main`

Bonusopgave: Kan du forudse hvad `floydexample.TraversingArrays.hasCycle(..)` vil returnere med inputtet ` int[] test = {2, 0, 1}` og hvorfor?

## 3. Backtracking

Du har en labyrint, du skal gå igennem. Labyrinten er repræsenteret af et to-dimensionelt array hvor
- `1` betyder "du kan gå her"
- `0` betyder "mur - her kan du ikke gå"

Labyrinten kan fx se sådan ud: 

```java
int[][] maze = {
        {1, 0, 1, 1, 1, 0},
        {1, 1, 1, 0, 1, 0},
        {0, 0, 1, 0, 1, 1},
        {0, 1, 1, 1, 0, 1},
        {0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 1, 1}
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

Du kan søge inspiration i `algorithms.backtracking.NQueeens`  
