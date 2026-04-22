# Søgning i grafer

## 1. BFS

Kig på klassen `graphsearch.SearchStrategies`. I klassen er metoden `searchBFS(..)`.

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn evt indholdet af køen iteration for hver iteration.
- Overvej hvad det betyder, at vi bruger en `Queue` (hint: det er en FIFO struktur).


## 2. DFS

Kig på klassen `graphsearch.SearchStrategies`. I klassen er metoden `searchDFS(..)`.

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn evt indholdet af stakken iteration for hver iteration.
- Overvej hvad det betyder, at vi bruger et `Deque` (hint: det er en LIFO struktur).

Bonusspørgsmål: Hvordan kan vi bruge `ArrayDeque` som både stak og kø?

## 3. Implementer din egen BFS og DFS

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
i metoden og se om din tegning stemmer overens med output fra metoden. 
