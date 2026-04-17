## Hvad gør `explore(step, path)`?

Vi laver en rekursiv metode i `algorithms/backtracking/TryBacktrack`, som i hvert kald har to elementer:
- `step`: hvor langt vi er kommet (dybden i træet)
- `path`: den sti vi har fulgt indtil nu (fx "121")

Hver gang vi kalder `explore(...)`, gør vi følgende:

1. Tjekker: Er vi nået til enden (`step == 3`)?  
   → Hvis ja: udskriv `path` og stop.

2. Hvis nej:  
   → Brug en for-løkke til at prøve forskellige muligheder (`i = 1` og `i = 2`)  
   → For hver mulighed kalder vi `explore(...)` med `step + 1` og `path + i`

---

## Sådan tænker programmet (step for step)

1. **Step 0, path ""**
    - "Hvad kan vi gøre herfra?"
    - Prøv `1` → gå videre med `explore(1, "1")`
    - Prøv `2` → gå videre med `explore(1, "2")` *(men først når alt med "1" er færdigt)*

2. **Step 1, path "1"**
    - "Hvad kan vi gøre herfra?"
    - Prøv `1` → `explore(2, "11")`
    - Prøv `2` → `explore(2, "12")` *(men først når alt med "11" er færdigt)*


3. **Step 2, path "11"**
    - Prøv `1` → `explore(3, "111")` → print
    - Prøv `2` → `explore(3, "112")` → print
    - Færdig → gå tilbage til `"1"` og prøv `"12"`

4. **Step 2, path "12"**
    - Prøv `1` → `explore(3, "121")` → print
    - Prøv `2` → `explore(3, "122")` → print
    - Færdig → tilbage til `"1"` → tilbage til `step 0`

5. **Step 1, path "2"**
    - Samme proces med `"21"` og `"22"`

---

## 🧩 Pointen

- For-løkken laver **valgene**
- Rekursionen laver **forgreningen** – den bygger et træ
- Når ét spor er færdigt, **går vi tilbage** og prøver næste

Det er præcis det, vi kalder **backtracking**:  
Vi *prøver én mulighed*, *ser om det virker*, og *går tilbage og prøver noget andet*.
