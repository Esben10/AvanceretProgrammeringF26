# Øvelser: Reflection

## 1. Undersøg et hemmeligt object

Kig på koden i klassen `MysteryInspector`. Du skal IKKE åbne kildekoden til `SecretBox`. 
Ved hjælp af klasser fra pakken `java.lang.reflect` skal du nu undersøge klassen `SecretBox`. 

Inden du går i gang skal du ændre i konfigurationen til at køre programmet fordi du skal give et klassenavn
med som argument til main. Det gør du ved at vælge "Edit Configurations" og i "Program arguments" skrive "reflection.fieldsandmethods.SecretBox".

Opgaven er nu
1. Udskriv klassen navn. Brug `clazz` til dette
2. Lav et objekt af klassen. Her skal du bruge `clazz` og klassen `Constructor`. Du kan lade objektet have type `Object`.
3. Print alle metoderne fra klassen inklusive deres synlighed, returtype, navn og parameterliste. Her skal du bruge klasserne
`Parameter` og `Method`. (Hint: modifiers er repræsenteret som `int` når du får dem via `getModifiers()`. Du kan bruge metoden `toString` i 
klassen `Modifier` til at lave dem om til `public`, `private` mv.)
4. Kald metoderne ved at bruge `Method`. Du kan få fat i metoderne ved at bruge `clazz.getDeclaredMetod(..)` kaldt med de metodenavne du fandt i
opgave 3. 
5. Find ud af om der er felter i klassen og skriv deres værdi ud. 

BONUS: Hvis du er hurtigt færdig, så lav en hemmelig klasse og byt med din sidemakker.

## 2. Lav din egen annotation

Kig på koden i pakken `annotations`. Hvordan bruges annotationen `Role` til at styre hvem der må slette alle brugere i systemet?

Din opgave er 
- Lav en annotation `@Log` som man kan give et filename
- Annotation skal kunne sættes på metoder
- Annoter metoden `deleteAllUsers()` med `@Log`.
- Udvid din `AccessController` så kald til metoder med `@Log` bliver skrevet i logfil med tidspunkt, brugernavn og om kaldet blev tilladt.

BONUS: Hvis du er hurtigt færdig, så udvid med flere annotationer. Leg fx med brug af metaannotationen `@Target`.

## Bonusopgave: Kodegenerering

Brug din kode fra opgave 1 til at opbygge koden til klassen `SecretBox` og læg den i en java-fil. 
Du skal
- generere klassens navn og felter
- generere alle metodesignaturer
- lade metoderne være tomme, da vi jo ikke kan 
læse metodekroppen med refleksion, men tilføje kommentaren 
```java
// TODO: implement this later
```