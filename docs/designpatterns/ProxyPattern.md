# 🕵️ Proxy Pattern – Kort Forklaring

## 🔹 Idéen
Proxy Pattern bruges, når du vil **kontrollere adgangen til et andet objekt**.  
En proxy **opfører sig som det oprindelige objekt**, men kan tilføje ekstra funktionalitet som:

- Autentificering
- Caching
- Logging
- Lazy loading (opret først objektet når det skal bruges)

---

## 🔹 I praksis

```java
public interface Service {
    void perform();
}
```

### Ægte objekt:
```java
public class RealService implements Service {
    public void perform() {
        System.out.println("🛠️ Udfører rigtig arbejde");
    }
}
```

### Proxy:
```java
public class ServiceProxy implements Service {
    private RealService realService;

    public void perform() {
        if (realService == null) {
            realService = new RealService(); // lazy loading
        }
        System.out.println("🔒 Proxy: Tjekker adgang...");
        realService.perform();
    }
}
```

---

## 💻 Eksempel i `searchandsort.Main`

```java
Service service = new ServiceProxy();
service.perform();
```

---

## 🔹 Pointen
- Proxy kan **efterligne et objekt** og **kontrollere adgangen** til det
- Den kan **forsinke oprettelsen** (lazy init)
- Den kan tilføje funktionalitet uden at ændre originalklassen

---

## 🔹 Virkelighedsnært

Proxy Pattern bruges i:
- 🧠 Lazy loading af store objekter (fx billeder, dokumenter)
- 🔐 Sikkerhedskontrol før adgang (f.eks. admin-paneler)
- 💾 Cache-proxies (hvis noget allerede er hentet, brug det igen)
- 🌐 Fjernkald (RPC): Klient taler med en proxy, som sender kaldet til en server

