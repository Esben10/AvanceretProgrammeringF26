# Søgning i grafer

## 1. BFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchBFS(..)`.

Din opgave er

- Tegn den graf, der laves i `main`
- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af køen for hver iteration.
- Overvej hvad det betyder, at vi bruger `Queue` som referencetype (hint: det er en FIFO struktur).
- Er grafen rettet eller urettet? Sammenlign med `undirectedgraphs.Node`.
- Er kanterne vægtede eller uvægtede?
- I `Node` er `neighbors` en `List`. Kunne det give problemer? Hvilken datastruktur ville være mere korrekt, og hvorfor?

## 2. DFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchDFS(..)`.

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af stakken for hver iteration.
- Overvej hvad det betyder, at vi bruger `Deque` som referencetype (hint: det er en LIFO struktur).

Bonusspørgsmål: Hvorfor kan vi bruge `ArrayDeque` som både stak og kø?

## 3. Implementer din egen BFS og DFS

Kig på klasserne `graphs.treesearch.Node` og `graphs.treesearch.SearchStrategies`. Her arbejder vi med et træ. I stedet for `getNeighbors()` bruger vi `getChildren()` — men traversal-logikken er den samme.

Din opgave er nu

- Implementer metoderne `searchBFS(..)` og `searchDFS(..)`.
- Hent inspiration i `graphs.graphsearch.SearchStrategies`. Du skal ikke kopiere koden, men forstå hvordan der traverseres og gøre det samme for træer.

## Bonus: Cycle detection

I grafer kan der opstå cyklusser. Det kan der ikke i træer, som per definition er acykliske.

**Refleksionsspørgsmål:** Da vi arbejdede med hægtede lister brugte vi Floyd's Cycle Detection ("tortoise and hare") til at finde cyklusser. Hvorfor kan vi ikke bruge samme trick på grafer?

Du har prøvet noget lignende i maze solveren. Hvad holdt du styr på der for at undgå at gå i ring?

Kig på klassen `graphs.graphsearchcycles.CycleDetector` og se hvordan vi i stedet bruger DFS med et sæt (`inPath`) til at detektere cyklusser i rettede grafer.

- Gå koden igennem linje for linje og forklar hvad `inPath` holder styr på.
- Hvad sker der når vi backtracker? Hvorfor fjernes noden fra `inPath`?
- Kør `main`-metoden og tegn hvad der sker.
- Tilføj eventuelt nogle udprint af `inPath` for at følge hvad der sker. 

