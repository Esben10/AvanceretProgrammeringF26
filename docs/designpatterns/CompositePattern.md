# 🧩 Composite Pattern – Kort Forklaring (Spilversion)

## 🔹 Idéen
Composite-mønstret bruges, når du vil behandle **individuelle objekter og grupper af objekter ens**.  
I spil betyder det f.eks., at du kan kalde `update()` på både én fjende og en hel fjendegruppe.

## 🔹 I praksis
Du laver et interface (f.eks. `GameObject`) med én metode som alle skal implementere (f.eks. `update()`).

### Leaf – Én fjende:
```java
public class Enemy implements GameObject {
    private String name;
    public Enemy(String name) { this.name = name; }
    public void update() {
        System.out.println("Enemy [" + name + "] tager sin tur...");
    }
}
```

### Composite – Gruppe af fjender:
```java
public class EnemyGroup implements GameObject {
    private List<GameObject> members = new ArrayList<>();
    public void add(GameObject obj) { members.add(obj); }
    public void update() {
        for (GameObject obj : members) {
            obj.update();
        }
    }
}
```

## 🔹 Pointen
- Du kan behandle enkelte og sammensatte objekter **på samme måde**
- Du slipper for if-else og `instanceof`
- Du får et fleksibelt system som er let at udvide

## 🔹 Virkelighedsnært
Composite Pattern bruges bl.a. i:
- 🎮 Spil: scener, fjender, partikeleffekter
- 🧠 AI-strukturer (f.eks. behavior trees)
- 📁 Filstrukturer med mapper og filer
- 🧾 UI-komponenter og widgets
- 🛒 E-commerce: Produktpakker og individuelle varer
- 📄 Dokument-editorer (en side indeholder tekst, billeder og tabeller)


