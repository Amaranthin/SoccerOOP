public class Footballer extends Person{

    public String fieldPosition;

    //Skils
    private int headplaying; //игра с глава
    private int speed; //бързина
    private int defence; //защита
    private int stamina; //издържливост
    private int dribble; //дрибъл
    private int cleverness; //хитрост
    private int shoot; //стрелба

    private int priceInThousandsEuro;

    public int playerOnWhichTeam; //0 - free agent

    public int fresh = 100;



    private int passing; //пасове
    
    private String shortPosition;

    public Footballer()
    {

        super();
        this.fieldPosition = setRandomPosition();
        this.headplaying = setRandomSkill();
        this.speed = setRandomSkill();
        this.defence = setRandomSkill();
        this.stamina = setRandomSkill();
        this.dribble = setRandomSkill();
        this.cleverness = setRandomSkill();
        this.shoot = setRandomSkill();
        this.playerOnWhichTeam = 0;

        double avgSkill = (2*speed+defence+2*stamina+dribble+2*cleverness+shoot+headplaying)/10;
        int price = (int) (50 + 5*(avgSkill-50) + 10*((int) complexSkill()));
        this.priceInThousandsEuro = price;

        if (this.fieldPosition.equals("Defender")) {
            this.defence +=15;
            this.headplaying +=10;
        }

        if (this.fieldPosition.equals("Midfield")) {
            this.stamina +=10;
            this.passing +=15;
            this.cleverness +=10;
            this.shoot +=10;
        }

        if (this.fieldPosition.equals("Forward")) {
            this.headplaying +=5;
            this.dribble +=15;
            this.passing +=7;
            this.shoot +=20;
        }

        if (this.fieldPosition.equals("Goalkeeper")) {
            this.defence +=30;
        }
        
    }

    private String setRandomPosition()
    {
        int ps = rnd.nextInt(10)+1;

        String position = "";
        switch (ps) {
            case 1,2 -> {position = "Goalkeeper"; this.shortPosition = "GK";}
            case 3,4,5 -> {position = "Defender"; this.shortPosition = "DEF";}
            case 6,7,8 -> {position =  "Midfield"; this.shortPosition = "MID";}
            case 9,10,11 -> {position = "Forward"; this.shortPosition = "FWD";}
        }

        return position;
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
        s+= addIntervals(this.speed,9);
        s+= addIntervals(this.defence,9);
        s+= addIntervals(this.stamina,9);
        s+= addIntervals(this.dribble,9);
        s+= addIntervals(this.shoot,9);
        s+= addIntervals(this.cleverness,9);
        s+= addIntervals(this.headplaying,9);
        s+= addIntervals(Main.team[this.playerOnWhichTeam].getTeamName(),20);
        return s;
    }

    public String shortInfo()
    {
        String s = "";
        s += addIntervals(this.firstName,12);
        s += addIntervals(this.familyName,16);
        s += addIntervals(this.shortPosition,9);
        s += addIntervals(this.priceInThousandsEuro, 9);
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
    {
        if (skill>50) return Math.sqrt(skill-50);
        else return 1;
    }


}

