# 🧱 Builder Pattern – Kort Forklaring

## 🔹 Idéen
Builder-mønstret bruges, når et objekt har mange egenskaber, hvor nogle er obligatoriske og andre valgfrie. 
Det gør koden mere læsbar og fleksibel end lange constructors med mange parametre.

## 🔹 I praksis
Du laver en `Builder` som sætter felterne én for én, og til sidst kalder `.build()` for at få det færdige objekt.

```java
User user = new User.Builder("Anna", "anna@example.com")
    .address("Fyrrevej 7")
    .newsletter(true)
    .build();
```

## 🔹 Pointen
- Gør koden nemmere at læse og vedligeholde
- Undgår lange constructors med mange parametre
- Giver bedre fleksibilitet og struktur

## 🔹 Virkelighedsnært
Builder bruges ofte når:
- Du skal oprette brugere, bestillinger eller konfigurationer
- Du arbejder med frameworks (fx Spring Boot, Lombok)
- Du laver klienter til API’er eller konfigurerbare systemer

