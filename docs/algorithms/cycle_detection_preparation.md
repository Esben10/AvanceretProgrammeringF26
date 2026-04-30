# Forberedelsesspørgsmål til cycle detection

Vi skal i gang med algoritmik og starter med Floyd's Cycle Detection og grådige algoritmer.
Inden vi ses, vil jeg gerne have, at I forbereder jer med et par korte opgaver og lidt refleksion. 
Formålet er at I forstår de grundlæggende ideer bag cycle detection så vi kan fokusere mest på koden i timen.  

## 1. Hvad er cycle detection?
I kender problematikken at jeres kode går i uendelig løkke. Vi kan komme til at kode en cyklus, som vi 
ikke kan komme ud af igen. 

Cycle detection handler om at finde ud af om man er i en cyklisk struktur. Hvad sker der, hvis man traverserer en 
cyklisk liste uden at opdage det?

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










