# Øvelser: Concurrency

## 1. Gør BankAccount trådsikker

Kig på klasserne `BankAccount`, `BankRunnable` og `Main` i pakken `concurrency.bankaccount`. 
Hvad sker der i `main`? Og i `deposit()` og `withdraw()` i `BankAccunt`? 

Opgaven er nu:

- Prøv at køre `main` flere gange
  og se hvad saldoen bliver på vores konto. Forklar til din sidemand hvad problemet er. 
- Løs problemet med synkronisering. 
- Kør `main` igen for at se om din løsning virker. 
- Ekstra: Find ud af hvad `join()` gør i `main`. Kig på dokumentationen for tråde. 

