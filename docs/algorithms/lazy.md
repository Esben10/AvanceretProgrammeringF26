# Dovne beregninger

Kig på koden i `algorithms.lazy.lazy.LazyCalculations`. Hvad sker der hvis vi kalder metoden `lazyFactorial(..)` med 5 som argument?
Og hvad sker der, hvis vi efterfølgende kalder metoden med 3 som argument?

Lav din egen metode `lazySum(int i)` som summerer tallene fra 1 - n.

Prøv at sætte counter på dine metoder og se hvor mange beregninger der udføres, når du kalder dem.

Prøv at lave metoden `init()` som laver alle beregninger på forhånd. Lav derefter metoderne `eagerFactorial(..)`
og `eagerSum(..)` som blot slår op i det map, der er lavet i `init()`. Sæt counter på dine metoder og se hvor mange beregninger,
der udføres. Test i `main` hvor lang tid en beregning i de dovne metoder tager i forhold til de eager? Og hvor lang tid opstart
tager (kald til `init()`). Måske skal du lægge kunstig tid ind i beregningsdelene for at se en effekt på små datasæt. 



