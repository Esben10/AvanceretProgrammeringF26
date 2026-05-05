# 🧠 Guide til at vælge det rigtige Design Pattern

Når du står med et problem og tænker:  
*"Hvilket pattern skal jeg bruge?"*  
– så start her 👇

---

## 🔨 **Creational Patterns**
*Skaber nye objekter på fleksible og kontrollerede måder.*

> **Fokus:** Hvordan bliver objekterne skabt?

### Spørgsmål du kan stille:
- Har jeg brug for at kontrollere, hvordan et objekt bliver oprettet?
- Skal jeg undgå at bruge `new` direkte?
- Har objektet mange konfigurationsmuligheder?
- Skal jeg sikre, at der kun findes én instans?

### Typiske mønstre:
- **Singleton** – Én instans, globalt tilgængelig
- **Factory Method** – Udskift `new` med en fleksibel fabrik
- **Builder** – Konstruér trin for trin

---

## 🧱 **Structural Patterns**
*Bestemmer hvordan objekter forbindes og organiseres.*

> **Fokus:** Hvordan hænger objekterne teknisk sammen?

### Spørgsmål du kan stille:
- Skal jeg forbinde to klasser, der ikke passer sammen?
- Skal jeg tilføje ny funktionalitet uden at ændre eksisterende kode?
- Skal objekter grupperes hierarkisk?
- Har jeg brug for en mellemmand (f.eks. cache, sikkerhed, adgangskontrol)?

### Typiske mønstre:
- **Adapter** – Gør inkompatible interfaces kompatible
- **Decorator** – Tilføj funktionalitet dynamisk
- **Composite** – Træstruktur af objekter
- **Proxy** – Mellemmand, som kontrollerer adgang

---

## 🧠 **Behavioral Patterns**
*Styrer hvordan objekter samarbejder og kommunikerer.*

> **Fokus:** Hvordan opfører og interagerer objekterne sig?

### Spørgsmål du kan stille:
- Skal jeg kunne skifte algoritme dynamisk?
- Skal jeg indkapsle en handling som et objekt?
- Skal flere objekter reagere på ændringer i ét objekt?
- Vil jeg decouple afsender og modtager?

### Typiske mønstre:
- **Strategy** – Udskiftbar adfærd
- **Command** – Indkapslede handlinger
- **Observer** – Notifikation til mange lyttere

---

## 🎯 Tommelfingerregler

| Hvis du vil...                                | Så overvej...         |
|----------------------------------------------|------------------------|
| Kontrollere hvordan et objekt oprettes       | **Creational**         |
| Ændre hvordan objekter struktureres          | **Structural**         |
| Ændre hvordan objekter kommunikerer          | **Behavioral**         |

---

## ✨ Bonus-huskere

- **Decorator** tilføjer *funktion* uden at ændre klassen
- **Adapter** får noget gammelt til at *virke med noget nyt*
- **Strategy** vælger *hvordan* noget gøres
- **Command** vælger *hvad* der skal gøres – og *hvornår*
- **Observer** reagerer automatisk på ændringer
- **Composite** gør “del” og “helhed” ens at håndtere
- **Proxy** står i vejen, men med god grund 😇

---

💡 *Design patterns handler ikke om at være smart – men om at være klar i spyttet, fleksibel i design og venlig ved fremtidens vedligeholdere (som oftest er dig selv).*  
