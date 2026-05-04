## Portfolioopgave: Dijkstra

Lav en implementering af Dijkstras algoritme, der finder den korteste vej mellem byer i et vejnet.

- Design selv dit vejnet med mindst 8 byer og vægtede rettede veje
- Find den korteste vej fra én by til en anden
- Lav en visualisering der giver mening. Hvad er nyttigt at se når man skal forstå algoritmen?

Du kan finde inspiration til koden i `graphs.dijkstra`.

### Visualisering

Tænk over hvad der er meningsfuldt at vise for at forklare nogen hvordan Dijkstra virker. Nogle muligheder:

- Print i konsollen hvad der sker i hvert trin, fx "Afstanden fra Skovby til Lilleby er nu 13 km" eller "Lilleby er nu visited". 
Lav evt. tabeller over hvad der er i kø og/eller i visited. 
- Lav et interaktivt step-by-step mode hvor brugeren trykker y for at gå videre og kan følge med i hvad der er afsøgt indtil videre.
- Lav en grafisk visualisering i JavaScript eller Processing hvor noder skifter farve efterhånden som de bliver visited eller afsøgt.

Hvis du bruger JavaScript eller Processing må du gerne få hjælp af AI til selve koden, men du skal selv beslutte hvad du vil visualisere og hvorfor. 
Det er designbeslutningen der er vigtig, ikke om du skriver koden selv.