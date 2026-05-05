# 🧠 Strategy Pattern – Kort Forklaring

## 🔹 Idéen
Strategy Pattern bruges, når du vil **skifte algoritme eller opførsel i runtime** uden at ændre koden, der bruger den.

> Objektet har en "hjerne" (strategi), som du kan udskifte.

---

## 🔹 I praksis

```java
public interface SortStrategy {
    void sort(List<Integer> data);
}
```

### Forskellige strategier:
```java
public class BubbleSort implements SortStrategy {
    public void sort(List<Integer> data) {
        System.out.println("🔁 Sorterer med BubbleSort");
    }
}

public class QuickSort implements SortStrategy {
    public void sort(List<Integer> data) {
        System.out.println("⚡ Sorterer med QuickSort");
    }
}
```

### Sorter-klassen:
```java
public class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Integer> data) {
        strategy.sort(data);
    }
}
```

---

## 💻 Eksempel i `searchandsort.Main`

```java
Sorter sorter = new Sorter();
sorter.setStrategy(new BubbleSort());
sorter.sort(myList); // 🔁 BubbleSort

sorter.setStrategy(new QuickSort());
sorter.sort(myList); // ⚡ QuickSort
```

---

## 🔹 Pointen
- Du kan **skifte opførsel uden at ændre kode**
- Du får **lav kobling** og **høj fleksibilitet**
- Du undgår store `if-else` blokke med logikvalg

---

## 🔹 Virkelighedsnært

Strategy Pattern bruges ofte til:
- 📊 Forskellige sorteringer eller søgninger
- 🎮 AI-opførsel i spil: “Aggressiv” vs. “defensiv” fjende
- 🔐 Valg mellem loginstrategier (kodeord, fingeraftryk, oauth)
- 📦 Prisstrategier (rabat, premium, firmakunde)

---

## 🧠 Husk
Du kan bygge et system, hvor adfærden **kan skiftes dynamisk**.  
Et objekt er ikke længere dumt – det kan **tænke forskelligt** alt efter strategi.

