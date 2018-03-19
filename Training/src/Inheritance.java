/**
 * <h1>Learning the Inheritance</h1>
 * Creating 2 classes which inherit another class
 */
class Humanoid{
    Humanoid()
    {
        System.out.print("This is a humanoid! ");
    }

    /**
     * This method is used to write a massage to console.
     * @param msg The massage!
     */
    protected void yell(String msg)
    {
        System.out.println(msg);
    }
}

class Elf extends Humanoid{
    Elf()
    {
        super();
        System.out.println("Also an elf!");
        yell("Glory for the Alliance!");
    }
}

class Ork extends Humanoid{
    Ork()
    {
        super();
        System.out.println("Also an ork!");
        yell("Glory for the Horde!");
    }
}

class HighElf extends Elf{
    HighElf()
    {
        System.out.println("Hi!");
    }

    @Override
    protected void yell(String msg) {
        System.out.println("Die!");
    }
}

public class Inheritance {
    public static void main(String[] args)
    {
        Elf elf = new Elf();
        Ork ork = new Ork();

        System.out.println("----------------------");

        HighElf marky = new HighElf();
        Elf joe = new HighElf(); // even the object is an Elf reference, the method yell is used from the HighElf class

        System.out.println("----------------------");

        marky.yell("I got this!");
        joe.yell("Hahah!");
    }
}
