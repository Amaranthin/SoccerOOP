import java.util.Scanner;

public class Main {

    public static Team[] team = new Team[3];
    //team[0] > всички играчи без клуб (свободни агенти)
    //team[1] > нашият отбор,
    //team[2] > противниковият отбор,
    //Това е само декларация, обектите НЕ СА СЪЗДАДЕНИ!!!

    public static Footballer[] player = new Footballer[101];
    public static FootballerLastGameStats[] playerStats = new FootballerLastGameStats[101];


    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        for (int i=0; i<=2; i++)
        {
            Team mmm = new Team();   //същинско създаване на обектите
            team[i] = mmm;
        }

        team[0].setTeamName("Свободен агент");  //показва се като принадлежност на играча

        System.out.print("Въведете името на вашия отбор: ");
        String teamName  = scn.nextLine();
        team[1].setTeamName(teamName);

        System.out.print("Въведете името на противниковия отбор: ");
        teamName  = scn.nextLine();
        team[2].setTeamName(teamName);

        team[1].coach = new Coach("Мартин", "Катев", 45);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("Юрген", "Клоп", 55);
        team[2].coach.onWhichTeam = 2;

        System.out.println(team[1].getTeamName());

        showSquad(true);

        buyPlayers(1);
        buyPlayers(2);
        showSquad(false);

        Match curMatch = new Match(team[1],team[2]);
        curMatch.playGame();
    }

    public static void showSquad(boolean firstTime)
    {
        String s="";
        s+= "#   ";
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
        System.out.println(s);

        for (int i=1;i<=100;i++)
        {
            if (firstTime) player[i] = new Footballer(); //създава и самите играчи но само при първо извикване!!!
            System.out.println(Footballer.addIntervals(i, 4)+player[i].toString());
            if (i%10==0 && i<100) {
                System.out.println();
                System.out.println(s);
            }

        }

    }


    public static void buyPlayers(int iTrainer)
    {
        System.out.println();
        System.out.print(team[iTrainer].coach.firstName + " " + team[iTrainer].coach.familyName);
        System.out.println(", моля закупете играчи");
        System.out.println();

        boolean newBuy = true;
        while (newBuy)
        {
            System.out.print("Въведете номер на играча, който искате да закупите:");
            int num = scn.nextInt();

            if (num<=100) team[iTrainer].coach.buyPlayer(num);
            else newBuy = false;

        }

    }
}
