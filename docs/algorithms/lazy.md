# Dovne beregninger

Kig på koden i `algorithms.lazy.LazyCalculations`.

Klassen bruger **memoization** – den beregner factorial når den bliver bedt om det (lazy),
og gemmer resultatet så den ikke behøver at beregne det igen.

Hvad sker der hvis vi kalder `lazyFactorial(5)`? Og hvad sker der hvis vi efterfølgende kalder den med 3?

Lav din egen metode `lazySum(int n)` som summerer tallene fra 1 til n med memoization.

Prøv at sætte en counter på dine metoder og se hvor mange beregninger der udføres.

Lav derefter metoden `init()` som beregner alle resultater på forhånd (**eager**).
Lav metoderne `eagerFactorial(..)` og `eagerSum(..)` som blot slår op i det map som `init()` har bygget.

Sæt counter på og sammenlign: hvor mange beregninger laver lazy vs. eager?
Og hvad tager længst tid – selve beregningerne, eller opstart med `init()`?
Måske skal du lægge kunstig forsinkelse ind for at se effekten på små datasæt.