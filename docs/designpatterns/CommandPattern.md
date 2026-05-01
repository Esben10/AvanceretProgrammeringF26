# 🎮 Command Pattern – Kort Forklaring

## 🔹 Idéen
Command-mønstret bruges, når du vil indkapsle en handling som et objekt. 
Det gør det muligt at gemme, videresende og udskifte handlinger fleksibelt – fx i en fjernbetjening eller et GUI.

## 🔹 I praksis
Du laver et `Command` interface med én metode: `execute()`. 
Derefter laver du konkrete kommando-klasser, som ved hvad de skal gøre.

```java
public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}
```

## 🔹 Brug med fjernbetjening

```java
RemoteControl remote = new RemoteControl(2);
remote.setCommand(0, new LightOnCommand(kitchenLight));
remote.setCommand(1, new LightOffCommand(kitchenLight));

remote.pressButton(0); // tænder
remote.pressButton(1); // slukker
```

## 🔹 Pointen
- Du kan variere adfærd dynamisk
- Du kan gemme, udskyde og kombinere handlinger
- Du slipper for if-else og switch-logik i din controller

## 🔹 Virkelighedsnært
Command bruges ofte når:
- En knap skal udføre forskellig kode afhængigt af situation
- Du bygger GUI, spil eller fjernbetjeninger
- Du vil understøtte undo/redo
- Du vil logge handlinger eller sende dem over netværk

## 💻 Mini-test

```java
public class searchandsort.Main {
    public static void main(String[] args) {
        Light kitchen = new Light();
        Command on = new LightOnCommand(kitchen);
        Command off = new LightOffCommand(kitchen);

        RemoteControl remote = new RemoteControl(2);
        remote.setCommand(0, on);
        remote.setCommand(1, off);

        remote.pressButton(0); // Light is ON 💡
        remote.pressButton(1); // Light is OFF 🌑
    }
}
```
