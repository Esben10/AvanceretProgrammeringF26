# Øvelser: Design Patterns

## 1. Lav en ny decorator

Kig på klasserne `FileTextWriter` og `TimestampDecorator` i pakken `exercises.decorator`. 
De to klasser implementerer interfaces `TextWriter`. Klassen `TimestampDecorator` tager en 
`TextWriter` i sin konstruktør. I metoden `write` omformer den tekst og sender 
det videre til sin `TextWriter`. Ved at lave en masse små `TextWriter`-klasser kan vi 
mikse dem og få den opførsel, vi har brug for. 

Opgaven er nu

- Lav en klasse UppercaseDecorator, som omdanner teksten til store bogstaver. 
- Lav en klasse CensorDecorator, som fjerner bandeord (du kan lave en liste i klassen med de ord, du vil fjerne).
- Test i `searchandsort.Main` at du kan bruge dine klasser og sætte dem sammen som du vil. 

## 2. Lav en ny command
Kig på klasserne `Command`, `AcceptCommand`, `Button` og `CardReader` i pakken 
exercises.command. Klassen `CardReader` simulerer en dankortterminal som kan gøre 
tre ting; gennemføre en transaktion, rydde input (fx pinkode) eller annullere transaktion.

Vi skal nu have lavet tre knapper (grøn, gul og rød) som skal kobles til de tre funktioner. 
Det gør vi med et command pattern. Vi har en klasse `Button` som skal have en `Command` tilknyttet. 
Knappen ved ikke hvad den pågældende `Command` gør, men kalder blot `excute()` på den. 

Så laver vi vores `Command` klasser. Der er allerede lavet `AcceptCommand`som skal aktiveres, 
når kunden trykker på den grønne knap. I `searchandsort.Main` kan du se hvordan `CardReader`, `AcceptCommand`, og 
`Button` kobles sammen. 

Opgaven er nu

- Lav to nye klasser, som implementerer `Command`: én til at rydde input, én til at annullere transaktion.
- Lav en gul og en rød `Button` i `searchandsort.Main`.
- Kobl dine nye `Command`-klasser sammen med `CardReader` og de nye knapper.
- Test at det hele virker ved at kalde `press()` på knapperne.

## 3. Lav en composite-klasse

Kig på klasserne `Task` og `TaskGroup` i pakken exercises.composit. 

Du skal simulere en projekt-checkliste, hvor nogle opgaver består af flere delopgaver.  
Alle opgaver – både simple og sammensatte – skal kunne kaldes med `complete()`.

Vi bruger composite pattern, så både enkelte opgaver og opgavesamlinger kan behandles ens.

Opgaven er nu

- Lav en klasse `SimpleTask`, som implementerer `Task`
    - Den skal have et navn, der sættes i konstruktøren.
    - Når `complete()` kaldes, skal den udskrive:  
      `"Udfører opgave: <navn>"`
- I `searchandsort.Main.main()` skal du fjerne udkommentering og se om du kan få koden til at køre med din nye klasse. 
    