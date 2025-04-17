package designpatterns.main;

import designpatterns.builder.User;
import designpatterns.singleton.*;
import designpatterns.factory.*;
import designpatterns.builder.*;
import designpatterns.decorator.*;
import designpatterns.adapter.*;
import designpatterns.composite.*;
import designpatterns.command.*;
import designpatterns.strategy.*;
import designpatterns.observer.*;
import designpatterns.proxy.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Singleton
        Singleton instance = Singleton.getInstance();

        // Factory
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.speak();

        // Builder
      User user = new User.Builder("Anna", "anna@example.com")
                .address("Fyrrevej 7")
                .newsletter(true)
                .build();

      User.Builder us = new User.Builder("Signe", "kong@cph");
      us = us.address("gladsaxevej");
      us = us.newsletter(true);
      User signe = us.build();

        System.out.println("Bruger: " + user);

        // Decorator
        Notifier notifier = new SMSDecorator(new EmailNotifier());
        notifier.send();

        // Adapter
        NewPrinter printer = new PrinterAdapter(new OldPrinter());
        printer.print();

        // Composite
        GameObject goblin = new Enemy("Goblin");
        GameObject orc = new Enemy("Ork");

        EnemyGroup squad = new EnemyGroup("Fjendegruppe A");
        squad.add(goblin);
        squad.add(orc);

        EnemyGroup bossAndMinions = new EnemyGroup("Boss + hjælpere");
        bossAndMinions.add(new Enemy("Demon Boss"));
        bossAndMinions.add(squad);

        bossAndMinions.update(); // Kalder update() rekursivt!

        // Command
        Light kitchenLight = new Light();
        Command onCommand = new LightOnCommand(kitchenLight);
        Command offCommand = new LightOffCommand(kitchenLight);

        RemoteControl remote = new RemoteControl(2);
        remote.setCommand(0, onCommand);
        remote.setCommand(1, offCommand);

        remote.pressButton(0); // tænder lyset
        remote.pressButton(1); // slukker lyset

        // Strategy
        Sorter sorter = new Sorter();
        sorter.setStrategy(new BubbleSort());
        sorter.sort(Arrays.asList(5, 2, 8));

        // Observer
        Subject subject = new Subject();
        designpatterns.observer.Observer user1 = new designpatterns.observer.User("Alice");
        subject.addObserver(user1);
        subject.notifyObservers("New update available!");

        // Proxy
        Service service = new ServiceProxy();
        service.perform();
    }
}