# Reversed list

## 1. Tegn en hægtet liste

Kig på klassen `algorithms.reversedlinkedlist.ListFactory` som kan bygge hægtede lister til os.

Din opgave er

- Tegn den liste, der returneres fra kaldet `buildList(..)` med et array `{1, 5, 7, 12, 17}`.
    - Tegn de forskellige `Node` objekter med attributter
    - Tegn pile fra attributter til de objekter, der refereres til

Bonusspørgsmål: Hvordan kan man på koden alene se, at listen ender ved null?
Og hvordan kunne man have lavet en cyklus i stedet?

## 2. Reverser listen

Du skal nu lave en metode, som kan vende listen om. Det vil sige, at hvis vi
giver en liste i form af en `Node` (listens head) som parameter til
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
  returnerer head-`Node` i den omvendte liste (du kan lave den i klassen `algorithms.reversedlinkedlist.Main`)
    - Du løser opgaven ved at få hver enkelt `Node` til at pege på sin nuværende foregående `Node` i stedet for sin nuværende næste
    - Du kan med fordel skrive din kode i pseudokode før du implementerer den for at øve dig i at tænke algoritmisk. Det er her pointer-kontrol kommer ind.
    - Test din kode ved at køre `main` i klassen `searchandsort.Main`. (hint: du skal override `toString()` i `Node`)

Vejledende løsning findes i `algorithms.reversedlinkedlistsolution`.
