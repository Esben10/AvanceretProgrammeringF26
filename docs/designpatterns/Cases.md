# 🧩 Design Pattern Cases

## 📄 Case 1: Fleksibel logging
Vi skal kunne logge beskeder til både fil og konsol – og helst på en fleksibel måde,  
så vi kan tilføje flere destinationsformer senere.

---

## 🖱️ Case 2: Knapper med handlinger
Vi har en GUI med knapper, der skal kunne udløse forskellige handlinger,  
og vi skal kunne fortryde nogle af dem.

---

## 🧾 Case 3: Ukompatible interfaces
Vi har et gammelt regnskabssystem med en `printInvoiceOld()`-metode,  
men det nye system forventer `generateInvoice()`.  
Vi kan ikke ændre det gamle.

---

## 🧠 Case 4: Fælles konfiguration
Vi har brug for ét fælles `ConfigManager`-objekt,  
som alle klasser skal kunne læse fra og ændre i.

---

## 🧱 Case 5: Dokumentbygger
Vi bygger et dokumentgenerator-værktøj,  
hvor brugeren selv kan vælge header, footer og indhold i deres dokument.

---

## 📣 Case 6: Følgere og statusopdatering
Når en bruger opdaterer sin status i en app,  
skal alle deres følgere automatisk få besked.

---

## 👥 Case 7: Forskellige brugertyper
Vi har et system med forskellige typer brugere: `Admin`, `Guest`, `Member`.  
De skal alle implementere en `login()`-metode, men oprettes forskelligt.

---

## 🗂️ Case 8: Filer og mapper
Vi har en app med komplekse menuhierarkier –  
men filer og mapper skal behandles ens i brugergrænsefladen.

---

## ⏳ Case 9: Tung service
Vi har en service, som tager lang tid at starte op,  
og vi vil kun instantiere den, hvis den faktisk skal bruges – og kun én gang.

---

## 🔀 Case 10: Skiftbar sortering
Vi skal kunne sortere data,  
men vil gerne skifte mellem forskellige sorteringsalgoritmer afhængigt af dataset.
