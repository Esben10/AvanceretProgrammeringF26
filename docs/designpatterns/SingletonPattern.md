# 🧍 Singleton Pattern – Kort Forklaring

## 🔹 Idéen
Singleton Pattern bruges, når du vil sikre at **der kun findes én instans** af en klasse – og at den er **globalt tilgængelig**.

> Det er den “ene sandhed” i dit system. En slags **chef**, som kun må eksistere én gang.

---

## 🔹 I praksis

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {} // privat constructor

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // opret kun én gang
        }
        return instance;
    }
}
```

---

## 💻 Eksempel i `searchandsort.Main`

```java
Singleton a = Singleton.getInstance();
Singleton b = Singleton.getInstance();

System.out.println(a == b); // true – samme objekt
```

---

## 🔹 Pointen
- Du **kontrollerer antal instanser (kun én!)**
- Du sikrer **global adgang til én delt ressource**
- Du **forhindrer andre i at oprette nye objekter**

---

## 🔹 Virkelighedsnært

Singleton bruges ofte til:
- 🗂️ Konfigurationsfiler
- 🧠 Logging-systemer
- 💾 Databaseforbindelser
- 🧪 Test mocks
- 🕹️ Game engine state / Resource managers

---

## ⚠️ Pas på!
- Singleton er **let at misbruge** → global state er svært at teste
- Overvej om **Dependency Injection** er bedre

