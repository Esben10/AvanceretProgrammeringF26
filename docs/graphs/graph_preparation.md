# Forberedelsesspørgsmål til grafer

Vi skal i gang med grafalgoritmer og to klassiske søgestrategier: Breadth-First Search (BFS) og Depth-First Search (DFS).

## 1. Hvad er en graf?

En graf er en datastruktur, der består af:

- Noder (også kaldet "vertices")

- Kanter (edges), som forbinder to noder

Grafer kan være:

- Rettede (f.eks. links på internettet, hvor man kun kan gå den ene vej)

- Urettede (f.eks. venskaber på Facebook, hvor relationen går begge veje)

- Vægtede (hvor kanterne har en værdi, f.eks. afstande)

- Uvægtede (bare forbindelser, ingen værdier)

Anvendelser:

- Kort og navigation

- Netværk (sociale, tekniske, logistik)

- Web-crawling

- Spil og AI

Når vi skal undersøge grafer, bruger vi Breadth-First Search eller (BFS) eller Depth-First Search (DFS).

## 2. Refleksionsspørgsmål til grafer

Du står i en by og vil finde alle byer, du kan nå via veje. Hvordan ville du holde styr på, hvad du har besøgt – og hvad du mangler?
I hvilken rækkefølge ville du besøge noderne?

Tegn en simpel graf med 10-15 noder (byer) og forbindelser mellem dem (veje). Du skal nu anvende to forskellige strategier til at besøge alle byer.

Start i én node og skriv ned i hvilken rækkefølge du ville besøge de øvrige noder, hvis du:

- Undersøger alle nabobyer før du bevæger dig videre ud (BFS strategi)
- Følger en sti så langt du kan, før du backtracker (DFS strategi)

Skriv rækkefølgen ned som en liste af bynavne eller bogstaver – fx A → B → D...
