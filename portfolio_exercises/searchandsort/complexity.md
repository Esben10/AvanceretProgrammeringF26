# Portfolio: Kompleksitet og datastrukturer

## 1. Leg med kompleksitet

- Kig på klassen `BigOExamples`, som viser eksempler på fire forskellige kompleksiteter. Kør `main` og se de forskellige metoder
  performe. Prøv at skifte værdien af `n` og observer effekten.
- Kig på metoden `testComplexity()` i klassen `searchandsort.Main`. Her kaldes de samme metoder fra `BigOExamples` og deres performance måles med
  tidsstempler. Kald metoden fra `main` og se forskellen i tid. (Tip: udkommentér udskrift fra metoderne i `BigOExamples` så output bliver mere overskueligt).
- Lav tre metoder i en ny klasse eller i klassen `BigOExamples`. Hver metode skal have én af følgende kompleksiteter: O(1), O(log n) og O(n).
  Du bestemmer selv hvad metoderne skal gøre, men hold dem simple.
- Byt kode med en anden. Analyser hinandens kode og identificer kompleksiteten for hver enkelt metode.

## 2. Datastrukturer og kompleksitet i praksis

I Tech uden Tech-øvelsen fandt vi ud af at forskellige datastrukturer har forskellig kompleksitet for de samme operationer.
Nu skal du kode eksempler der bekræfter det.

### ArrayList vs LinkedList

Opret en `ArrayList<Integer>` og en `LinkedList<Integer>` med 500.000 elementer i hver.
Mål og sammenlign følgende operationer med tidsstempler:

- `get(250000)` — hent elementet midt i listen
- `add(250000, 99)` — indsæt et element midt i listen
- `remove(250000)` — slet elementet midt i listen

Forklar dine resultater med kompleksitet. Hvorfor opfører de sig forskelligt, selvom begge implementerer `List`?

> Hint: Tænk på hvad der sker fysisk i hukommelsen når du indsætter eller sletter midt i et array vs en hægtet liste.

### Søgning: List vs HashSet

Opret en `ArrayList<Integer>` og et `HashSet<Integer>` med de samme 500.000 elementer.
Mål og sammenlign:

- `contains(x)` for et element der findes
- `contains(x)` for et element der *ikke* findes

Forklar forskellen. Hvad er kompleksiteten for hvert kald, og hvorfor?

### Indsættelse og sletning i ArrayList

I øvelsen så vi at både indsættelse og sletning midt i en ArrayList koster O(n) — også selv om listen er sorteret og vi
kan finde elementet hurtigt med O(log n).

Skriv en kort forklaring (som kommentar i koden) på *hvorfor* det er tilfældet. Hvad sker der internt i ArrayList
når du indsætter eller sletter midt i listen? Og hvorfor gælder det samme ikke for LinkedList?