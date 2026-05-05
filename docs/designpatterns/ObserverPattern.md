# 👀 Observer Pattern – Kort Forklaring

## 🔹 Idéen
Observer Pattern bruges, når **et objekt skal informere andre objekter om ændringer** – uden at kende dem i detaljer.

Det klassiske eksempel: **“Du abonnerer på noget, og får besked når det ændrer sig.”**

## 🔹 I praksis
Du har:
- Ét `Subject`, som holder styr på sine `Observers`
- Mange `Observers`, som implementerer `update()`

## 📦 Interface og implementering

```java
public interface Observer {
    void update(String message);
}

public class User implements Observer {
    private String name;
    public User(String name) { this.name = name; }
    public void update(String message) {
        System.out.println(name + " modtog: " + message);
    }
}
```

### `Subject` holder listen:

```java
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
```

## 💻 Mini-test i `searchandsort.Main`

```java
Subject blog = new Subject();

Observer alice = new User("Alice");
Observer bob = new User("Bob");

blog.addObserver(alice);
blog.addObserver(bob);

blog.notifyObservers("🎉 Nyt blogindlæg: 'Sådan forstår du Observer Pattern'");
```

## 🔹 Pointen
- Du **kobler objekter løst sammen**
- `Subject` ved ikke hvad observerne gør – kun at de skal have besked
- Du kan **føje og fjerne observers dynamisk**

## 🔹 Virkelighedsnært
Observer bruges typisk i:
- 🔔 Notifikationssystemer
- 🎮 Spil: Når noget i verden ændrer sig (liv, score, timer)
- 📊 UI/data-binding: ændringer i data vises straks
- 📩 Events i frameworks og biblioteker (fx JavaFX, React, Android)

