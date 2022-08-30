import java.util.Random;

public class Footballer extends Person{

    public String fieldPosition;
    private String shortPosition;
    public int priceInThousandsEuro;

    public int playerOnWhichTeam; //0 - free agent
    public Team fromTeam; //за бърза обратна връзка

    public int freshness = 100;  //свежест в текущия мач

    //BasicSkills
    protected int headplaying; //игра с глава
    protected int speed; //бързина
    protected int defence; //защита
    private int stamina; //издържливост
    protected int dribble; //дрибъл
    protected int cleverness; //хитрост
    protected int shoot; //стрелба
    protected int passing; //пасове

    public Footballer(){}

    public Footballer(String shortPosition)
    {

        super();
        setPosition(shortPosition);

        this.headplaying = setRandomSkill();
        this.speed = setRandomSkill();
        this.defence = setRandomSkill();
        this.stamina = setRandomSkill();
        this.dribble = setRandomSkill();
        this.cleverness = setRandomSkill();
        this.shoot = setRandomSkill();
        this.passing = setRandomSkill();
        this.playerOnWhichTeam = 0;

        double avgSkill = (2*speed + defence + 2*stamina + dribble + 2*cleverness + shoot + headplaying)/10;
        int price = (int) (50 + 5*(avgSkill-50) + 10*((int) complexSkill()));
        this.priceInThousandsEuro = price;

        if (shortPosition.equals("DEF")) {
            this.defence +=15;
            this.passing +=10;
            this.headplaying +=10;
        }

        if (shortPosition.equals("MID")) {
            this.stamina +=10;
            this.passing +=25;
            this.cleverness +=20;
            this.shoot +=10;
        }

        if (shortPosition.equals("FWD")) {
            this.headplaying +=5;
            this.dribble +=15;
            this.passing +=15;
            this.shoot +=20;
        }

        if (shortPosition.equals("GK")) {
            this.defence +=30;
        }
        
    }

    private  void setPosition(String shortPosition)
    {
        this.shortPosition = shortPosition;

        switch (shortPosition) {
            case "GK" -> this.fieldPosition = "Goalkeeper";
            case "DEF" -> this.fieldPosition = "Defender";
            case "MID" -> this.fieldPosition =  "Midfield";
            case "FWD" -> this.fieldPosition = "Forward";
        }

    }

    private int setRandomSkill()
    {
        int x = rnd.nextInt(30)+40;
        return x;
    }
    
    public String toString()
    {
        String s = "";
        s += addIntervals(this.firstName,12);
        s += addIntervals(this.familyName,16);
        s += addIntervals("Age:"+ this.age,10);
        s += addIntervals(this.shortPosition,9);
        s += addIntervals(this.priceInThousandsEuro, 9);
        s += addIntervals(this.speed,9);
        s += addIntervals(this.defence,9);
        s += addIntervals(this.stamina,9);
        s += addIntervals(this.dribble,9);
        s += addIntervals(this.shoot,9);
        s += addIntervals(this.cleverness,9);
        s += addIntervals(this.headplaying,9);
        s += addIntervals(Main.team[this.playerOnWhichTeam].getTeamName(),20);
        return s;
    }

    public String shortInfoForTimeList()
    {
        String s = "";
        s += addIntervals(this.firstName,12);
        s += addIntervals(this.familyName,16);
        s += addIntervals(this.shortPosition,9);
        s += addIntervals(this.priceInThousandsEuro+"K", 9);
        return s;
    }

    public static String addIntervals(String txt, int len)
    {
        while (txt.length()<len)
        {
            txt += " ";
        }
        
        return txt;
    }

    public static String addIntervals(int value, int len)
    {
        String txt = String.valueOf(value);
        while (txt.length()<len)
        {
            txt += " ";
        }

        return txt;
    }

    public double complexSkill()
    {
        double total = 1;
        total *= singleDiff(headplaying);
        total *= singleDiff(speed);
        total *= singleDiff(defence);
        total *= singleDiff(stamina);
        total *= singleDiff(dribble);
        total *= singleDiff(cleverness);
        total *= singleDiff(shoot);

        total = Math.sqrt(total);
        return total;
    }

    public double singleDiff(int skill)
    {   //с колко уменията му надхвърлят определено ниво

        if (skill>50) return Math.sqrt(skill-50);
        else return 1;
    }

    public void play()
    {
        upMinute();

        Random x = new Random();
        int act = x.nextInt(100)+1;
        int dangerAttack = 5*this.fromTeam.teamTimeBallOwnership;

        act += dangerAttack;
        if (act<60) createPass();
        else if (act<90) makeDribble();
        else makeShoot();
    }

    protected void makeDribble()
    {
        Random x = new Random();
        int ourAct = x.nextInt(100)+1;
        int ourSkill = 2*this.dribble + this.freshness + this.stamina + this.cleverness + ourAct;

        int enemyAct = x.nextInt(100)+1;

        Footballer oponent = this.fromTeam.currentEnemyTeam.getRandomFieldPlayer();
        int enemySkill = 5*oponent.fromTeam.defenders-10 + 2*oponent.defence + oponent.freshness + oponent.stamina + oponent.cleverness + enemyAct;

        if (ourSkill>=enemySkill)
        {
            this.fromTeam.teamTimeBallOwnership++;
            System.out.println(this.getFullName() + " финтира играч " + oponent.getFullName());
        }
        else
        {
            this.fromTeam.teamTimeBallOwnership = 0;
            System.out.println(this.getFullName() + " губи топката от " + oponent.getFullName());
            Match.putBallInPlayer(oponent);
        }
    }

    protected void createPass()
    {
        Random x = new Random();
        int ourAct = x.nextInt(100)+1;
        int ourSkill = 5*this.fromTeam.midfields + 3*this.passing + this.freshness + this.cleverness + ourAct;

        int enemyAct = x.nextInt(100)+1;

        Footballer oponent = this.fromTeam.currentEnemyTeam.getRandomFieldPlayer();
        int enemySkill = 4*oponent.fromTeam.midfields + 3*oponent.fromTeam.defenders + 2*oponent.defence + oponent.freshness + oponent.cleverness + enemyAct;

        if (ourSkill>=enemySkill)
        {
            this.fromTeam.teamTimeBallOwnership++;

            Footballer ourPlayer  =  this.fromTeam.getRandomFieldPlayer();
            while (ourPlayer == Main.curMatch.lastPlayerWithBall)
            {
                ourPlayer = this.fromTeam.getRandomFieldPlayer(); //за да не подава сам на себе си
            }

            if (this.shortPosition.equals("GK"))
            {
                System.out.println(this.getFullName() + " вкарва топката в игра и тя попада в " + ourPlayer.getFullName());
            }
            else
            {
                System.out.println(this.getFullName() + " подава на " + ourPlayer.getFullName());
            }

            Match.putBallInPlayer(ourPlayer);
        }
        else
        {
            this.fromTeam.teamTimeBallOwnership = 0;
            if (this.shortPosition.equals("GK"))
            {
                System.out.println(this.getFullName() + " вкарва топката в игра, но тя попада в " + oponent.getFullName());
            }
            else {
                System.out.println(oponent.getFullName() + " пресича опита за пас на " + this.getFullName());
            }

            Match.putBallInPlayer(oponent);
        }
    }

    protected void makeShoot()
    {
        Random x = new Random();
        int ourAct = x.nextInt(100)+1;
        int ourSkill = 2*this.shoot + this.freshness + this.stamina + ourAct + 3*this.fromTeam.teamTimeBallOwnership;

        int enemyAct = x.nextInt(100)+1;

        Footballer oponent = this.fromTeam.currentEnemyTeam.player[1];
        int enemySkill = 5*oponent.fromTeam.defenders + 2*oponent.defence + oponent.freshness + oponent.cleverness + enemyAct;

        if (ourSkill>=enemySkill)
        {
            this.fromTeam.teamGoalsInCurrentMatch++;
            Match.showRandomGoalSituation(this, oponent);
            Match.putBallInPlayer(this.fromTeam.currentEnemyTeam.getRandomFieldPlayer());
        }
        else
        {
            this.fromTeam.teamTimeBallOwnership = 0;
            int strike = x.nextInt(10);
            if (strike<=5) System.out.println(this.getFullName() + " стреля към вратата, но ударът му е избит от " + oponent.getFullName());
            if (strike>5) System.out.println(this.getFullName() + " стреля към вратата, но ударът му минава далеч от целта");

            Match.putBallInPlayer(oponent);
        }
    }

    protected void upMinute()
    {
        Match.spendTime();

        Main.curMatch.currentMinute ++;
        System.out.print(Match.getColor(this.fromTeam.teamColor));
        //В @ @ отпечатваме колко е задържана топката от отбора, колкото по-дълго е, по-опасна става атаката
        System.out.print("@"+(1+Main.curMatch.lastPlayerWithBall.fromTeam.teamTimeBallOwnership)+"@ ");
        System.out.print(Match.getColor(0));
        System.out.print(Main.curMatch.currentMinute+ "мин. ");

        this.freshness += -2; //всяко действие на този играч да го поизмаря
    }

    public String getFullName() //Colored
    {
        String clr = Match.getColor(this.fromTeam.teamColor);
        return clr+this.firstName + " " + this.familyName+Match.getColor(0);
    }

}

