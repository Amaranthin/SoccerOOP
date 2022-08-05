import java.util.Random;

public class FForward extends Footballer{

    public FForward()
    {
        super("FWD");
    }

    @Override
    public void play()
    {
        upMinute();
        Random x = new Random();

        int act = x.nextInt(100)+1;
        int dangerAttack = 3*this.fromTeam.teamTimeBallOwnership;
        if (this.fromTeam.teamTimeBallOwnership>=3) System.out.println(this.getFullName() + " е опасно близко до вратата! Да видим какво ще предприеме...");

        act += dangerAttack;
        if (act<40) createPass();
        else if (act<77) makeDribble();
        else makeShoot();
    }

}
