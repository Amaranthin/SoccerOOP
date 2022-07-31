import java.util.Random;

public class FGoalkeeper extends Footballer{

    public FGoalkeeper()
    {
        super("GK");
    }

    @Override
    public void play()
    {
        upMinute();

        Random x = new Random();
        int act = x.nextInt(100)+1;

        this.createPass();

    }


}
