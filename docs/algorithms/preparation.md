# Forberedelsesspørgsmål til uge 4: Algorithms

Forberedelse til næste uges undervisning: Floyd's Cycle Detection, grafer, BFS og DFS

Vi skal i gang med cycliske strukturer, grafalgoritmer og to klassiske søgestrategier: Breadth-First Search (BFS) og Depth-First Search (DFS). 
Inden vi ses, vil jeg gerne have, at I forbereder jer med et par korte opgaver og lidt refleksion. 
Formålet er at I forstår de grundlæggende ideer bag cycle detection og grafsøgning, så vi kan fokusere mest på koden i timen.  

## 1. Hvad er cycle detection?
I kender problematikken at jeres kode går i uendelig løkke. Vi kan komme til at kode en cyklus, som vi 
ikke kan komme ud af igen. 

Vi skal kigge på cykliske lister i timen, så læs op på hvad en hægtet liste (LinkedList) er:

- Hvad er en node, og hvordan den peger på den næste?

- Hvordan traverserer man en hægtet liste?

- Hvad det vil sige, at en liste har en cyklus (loop)?

Cycle detection handler om at finde ud af om man er i en cyklisk struktur. Hvad sker der, hvis man traverserer en cyklisk liste uden at opdage det?

Vi kender lister. Vi kan iterere igennem dem ved at starte ved første node (head) og
slutter når listen ikke har flere elementer. Easy-peasy.

Men hvis listen nu er cyklisk? En almindelig hægtet liste er som en ankerkæde: én start og én ende. 
En cyklisk liste er som en halskæde – du kan gå rundt i den for evigt, hvis du ikke passer på. Det er vigtigt, at vi kan detektere en 
cyklus, hvis vi arbejder i et miljø hvor de kan forekommen og ikke er ønskede. 

## 2. Refleksionsspørgsmål til cycle detection:

Forestil dig, at du bevæger dig gennem en kæde af noder, hvor hver node peger på den næste. 
Du kan ikke se hele strukturen på én gang – kun ét skridt frem.
Hvordan vil du kunne opdage, om du er fanget i en cyklus? Hvad ville du holde øje med?
Kan man opdage det uden at huske alle tidligere noder?

Din opgave er nu, at tænke over en strategi til at finde ud af, om vi er i en cyklisk liste eller ej. Skriv i pseudokode 
eller almindeligt sprog, hvordan man kan finde ud af, om man befinder sig i en cyklisk struktur (dette er ingen let opgave, men prøv at komme med et bud).

## 3. Hvad er en graf?

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

## 4. Refleksionsspørgsmål til grafer

Du står i en by og vil finde alle byer, du kan nå via veje. Hvordan ville du holde styr på, hvad du har besøgt – og hvad du mangler?
I hvilken rækkefølge ville du besøge noderne?

Tegn en simpel graf med 10-15 noder (byer) og forbindelser mellem dem (veje). Du skal nu anvende to forskellige strategier til at besøge alle byer. 

Start i én node og skriv ned i hvilken rækkefølge du ville besøge de øvrige noder, hvis du:

- Undersøger alle nabobyer før du bevæger dig videre ud (BFS strategi)
- Følger en sti så langt du kan, før du backtracker (DFS strategi)

Skriv rækkefølgen ned som en liste af bynavne eller bogstaver – fx A → B → D...









