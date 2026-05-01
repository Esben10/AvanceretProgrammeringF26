# 🎁 Decorator Pattern – Kort Forklaring

## 🔹 Idéen
Decorator-mønstret bruges, når du vil **udvide funktionalitet uden at ændre på eksisterende kode**.  
I stedet for at arve, **pakker du objektet ind** i noget, der tilføjer ny opførsel.

## 🔹 I praksis
Du har en fælles interface (f.eks. `Notifier`) og både en **grundklasse** og en eller flere **wrappere**.

```java
public interface Notifier {
    void send();
}
```

### Basis-implementering:
```java
public class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("📧 Sender e-mail");
    }
}
```

### Decorator:
```java
public class SMSDecorator implements Notifier {
    private Notifier wrappee;
    public SMSDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send() {
        wrappee.send(); // først det oprindelige
        System.out.println("📱 Sender SMS");
    }
}
```

## 🔹 Pointen
- Tilføj ny funktionalitet uden at ændre originalen
- Kan kombineres fleksibelt
- Undgår mange subklasser og rigid arv

## 🔹 Virkelighedsnært
Decorator bruges typisk når:
- 📨 Du sender beskeder via flere kanaler
- 🎨 Du udvider UI-elementer (fx med kanter, farver, skygger)
- 🔒 Du pakker streams eller requests ind (f.eks. `BufferedReader`, `HttpServletRequestWrapper`)
- 📦 Du kombinerer features i f.eks. spilsystemer eller komponentarkitektur

