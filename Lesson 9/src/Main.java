import task.*;
import task.animals.*;
import task.animals.birds.*;
import task.animals.cats.*;
import task.animals.dogs.*;
import task.animals.fishes.*;
import task.animals.rodents.*;

import javax.naming.OperationNotSupportedException;


public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Animal a = new EgyptianMau("Markiz");
        Rodent r = new Hamster("Homa");
        Cat c = new MaineCoon("Barsik");
        Dog d = new Beagle("Tuzik");
        Bird b = new Parrot("Kesha");
        Fish f = new Goldfish("Nemo");
        System.out.printf("%1$s\n%2$s\n%3$s\n%4$s\n%5$s\n%6$s\n", a, b, c, d, f, r);
        c.voice();
        d.voice();
        r.voice();
        a.voice();
        b.voice();
        f.voice();
    }
}
