import java.util.Scanner;

public class Main {

    public static Match curMatch;

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
            //СЪЩИНСКО СЪЗДАВАНЕ НА ОБЕКТИТЕ
            Team newTeam = new Team("Свободен агент",i);   //цветовете ще са поредни като вземаме i
            team[i] = newTeam;
        }

        System.out.print("Въведете името на първи отбор: ");
        String teamName  = scn.nextLine();
        team[1].setTeamName(teamName);


        System.out.print("Въведете името на втори отбор: ");
        teamName  = scn.nextLine();
        team[2].setTeamName(teamName);

        //ХАРДКОД ТРЕНьОРИ
        team[1].coach = new Coach("Юрген", "Клоп", 55);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("Карло", "Анчелоти", 63);
        team[2].coach.onWhichTeam = 2;

        SquadOperations.createNewPlayers ();
        SquadOperations.showSquad();

        autoBuyPlayers();
        //SquadOperations.buyPlayers(1);
        //SquadOperations.showSquad();
        //SquadOperations.buyPlayers(2);
        SquadOperations.showSquad();

        curMatch = new Match(team[1],team[2]);
        curMatch.playGame();
    }


    public static void autoBuyPlayers()
    {
        for (int c=1; c<=2;c++)
        {
            for (int i=1;i<=11;i++)
                if (i==1)
                {   //goalkeeper
                    Main.team[c].coach.buyPlayer(i+c);
                }
                else
                {
                    Main.team[c].coach.buyPlayer(11*c+i*7);
                }
        }
    }

}
