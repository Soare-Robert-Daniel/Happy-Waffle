interface Actions{
    public void Attack();
    public void Move();
    public void Stand();
}

interface Warrior{
    public void Slash();
    public void Charge();
}

interface Brawler extends Warrior{
    public void Leap();
}
class Player implements Actions, Brawler {
    public void Attack()
    {
        System.out.println("Attack!");
    }

    public void Move()
    {
        System.out.println("Move!");
    }

    public void Stand()
    {
        System.out.println("Stand!");
    }

    public void Slash()
    {
        System.out.println("Slash!");
    }

    public void Charge()
    {
        System.out.println("Charge!");
    }

    public void Leap()
    {
        System.out.println("Leap!");
    }
}
public class Interface {
    public static void main(String[] args)
    {
        Player p = new Player();
        p.Attack();
        p.Charge();
        p.Move();
        p.Slash();
        p.Stand();
        p.Leap();
    }
}
