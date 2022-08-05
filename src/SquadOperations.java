public class SquadOperations
{
    public static void createNewPlayers()
    {
        for (int i=1;i<=100;i++) {
            if (i < 15) Main.player[i] = new FGoalkeeper();
            else if (i < 50) Main.player[i] = new FDefender();
            else if (i < 75) Main.player[i] = new FMidfielder();
            else Main.player[i] = new FForward();
        }
    }

    public static void showSquad()
    {
        String s="";
        s+= Match.getColor(3) + "#   ";
        s+= Footballer.addIntervals("Име",12);
        s+= Footballer.addIntervals("Прякор",16);
        s+= Footballer.addIntervals("Age:",10);
        s+= Footballer.addIntervals("Position",9);
        s+= Footballer.addIntervals("Price(K)",9);
        s+= Footballer.addIntervals("speed",9);
        s+= Footballer.addIntervals("defend",9);
        s+= Footballer.addIntervals("stamina",9);
        s+= Footballer.addIntervals("dribble",9);
        s+= Footballer.addIntervals("shoot",9);
        s+= Footballer.addIntervals("clever",9);
        s+= Footballer.addIntervals("headpl",9);
        s+= Footballer.addIntervals("football club",20);
        s += Match.getColor(0);
        System.out.println(s);

        for (int i=1;i<=100;i++)
        {
            String clr = Match.getColor(Main.player[i].playerOnWhichTeam);
            System.out.println(clr+Footballer.addIntervals(i, 4) + Main.player[i].toString());
            if (i%10==0 && i<100) {
                System.out.println();
                System.out.println(s);
            }
        }
    }

    public static void buyPlayers(int iTrainer)
    {
        System.out.println();
        System.out.print(Main.team[iTrainer].coach.firstName + " " + Main.team[iTrainer].coach.familyName);
        System.out.println(", моля закупете играчи");
        System.out.println();

        boolean needFromBuy = true;
        while (needFromBuy)
        {
            boolean needFromGoalkeeper = false;
            if (Main.team[iTrainer].countFootballers == 0)
            {
                System.out.print("Като първи играч задължително трябва да закупите вратар! ");
                needFromGoalkeeper = true;
            }

            System.out.print("Въведете номер на играча, който искате да закупите:");
            int num = Main.scn.nextInt();

            if (needFromGoalkeeper)
            {
                if (num<=100 && Main.player[num].fieldPosition.equals("Goalkeeper"))
                {
                    Main.team[iTrainer].coach.buyPlayer(num);
                }
            }
            else if (num<=100) {Main.team[iTrainer].coach.buyPlayer(num);}
            else needFromBuy = false; //ако искаме да прекратим въвеждането по други причини, въвеждаме над 100

            if (Main.team[iTrainer].countFootballers ==11) needFromBuy = false; //за изход след 11тия закупен
        }
    }

    public static void autoBuyPlayers() {
        for (int tm = 1; tm <= 2; tm++) {
            for (int i = 1; i <= 11; i++) {
                if (i == 1) {   //goalkeeper
                    Main.team[tm].coach.buyPlayer(i + tm-1);
                } else {
                    int number;
                    if (i < 6) {
                        number = 8;
                        Main.team[tm].coach.buyPlayer(number + 5 * tm + i);
                    } else if (i < 10) {
                        number = 39;
                        Main.team[tm].coach.buyPlayer(number + 5 * tm + i);
                    } else {
                        number = 62;
                        Main.team[tm].coach.buyPlayer(number + 3 * tm + i);
                    }
                }
            }
        }
    }
}
