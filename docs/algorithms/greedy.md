# Grådig algoritme

Du skal lave en algoritme, som kan beregne hvor meget træ af forskellige længder vi skal bruge til at opnå en target-længde.
Find evt inspiration i `algorithms.greedy.MoneyHandler`.

Vi har træ liggende i længderne 7, 5 og 2 meter. Så hvis vi skal bruge 12 meter, stykker vi det sammen af 7 og 5 meter.

Opgaven er nu

- Lav en klasse `WoodHandler` med metoden `List<Integer> calculateWood(int target)` som tager en target-længde som parameter
  og returnerer en liste af de længder, vi skal bruge. Fx vil `calculateWood(11)` returnere en liste med tallene 7, 2, 2.
- Hvis metoden ikke kan ramme target præcist, kan du lade den returnere det, der kommer tættest på. Fx skal `calculateWood(13)` returnere
  7, 5, 2.
- Du kan også vælge at returnere `null` hvis metoden ikke kan ramme target præcist.

I hvilke tilfælde giver den grådige algoritme den bedst mulige løsning –
og i hvilke tilfælde kunne færre stykker være muligt med en anden strategi?

Bonus (når du har lært om dovne algoritmer og backtracking):
- Lav en lazy-version af calculateWood(int target), hvor vi husker tidligere beregninger
    - Brug fx Map<Integer, List<Integer>> til at cache løsninger
    - Så hvis vi igen skal bruge 11 meter, slår vi det bare op

- Find den løsning med færrest antal stykker ved hjælp af backtracking
    - Brug rekursion og prøv alle kombinationer
    - Gem den bedste (mindste) løsning
