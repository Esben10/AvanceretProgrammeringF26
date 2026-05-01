# 🏭 Factory Pattern – Kort Forklaring

## 🔹 Idéen
Factory Pattern bruges, når du vil **centralisere og abstrahere oprettelsen af objekter**.  
I stedet for at bruge `new` direkte i hele din kode, samler du det i én metode – en fabrik!

## 🔹 I praksis
Du laver en **Factory-klasse**, som returnerer objekter baseret på input.

```java
public class AnimalFactory {
    public static Animal createAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) return new Dog();
        if ("cat".equalsIgnoreCase(type)) return new Cat();
        if ("cow".equalsIgnoreCase(type)) return new Cow();
        return null;
    }
}
```

## 🔹 Interface + Implementeringer
```java
public interface Animal {
    void speak();
}

public class Dog implements Animal {
    public void speak() { System.out.println("🐶 Woof!"); }
}
```

## 💻 Eksempel i `searchandsort.Main`
```java
Animal dog = AnimalFactory.createAnimal("dog");
dog.speak(); // 🐶 Woof!
```

## 🔹 Pointen
- Du samler **objektskabelse ét sted**
- Du kan **ændre implementering** uden at ændre resten af systemet
- Du undgår at bruge `new` overalt – hvilket øger **fleksibilitet og testbarhed**

## 🔹 Virkelighedsnært
Factory Pattern bruges ofte i:
- ☕ Dependency Injection frameworks (Spring, Guice)
- 🧪 Testværktøjer (mock factories)
- 🧠 Spil: opret fjender, våben eller items ud fra navn/type
- 🌐 Webframeworks: skab kontroller eller komponenter dynamisk



