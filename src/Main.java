import java.util.Scanner;

public class Main {

    public static Match curMatch;
    public static int gameSpeed;

    public static Team[] team = new Team[3];
    //team[0] > всички играчи без клуб (свободни агенти)
    //team[1] > нашият отбор,
    //team[2] > противниковият отбор,
    //Това е само декларация, обектите НЕ СА СЪЗДАДЕНИ!!!

    public static Footballer[] player = new Footballer[101];

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i <= 2; i++) {
            //СЪЩИНСКО СЪЗДАВАНЕ НА ОБЕКТИТЕ
            Team newTeam = new Team("Свободен агент", i);   //цветовете ще са поредни като вземаме i
            team[i] = newTeam;
        }

        //МЕНЮ 1
        System.out.println("Моля изберете опции за двата отбора");
        System.out.println("1) Ще въведем имената ръчно");
        System.out.println("2) Хитрите мечоци (с.Хитрино) - Лисиците (с.Лесичери)");
        System.out.println("3) Джедаи (Джаваполис) - Сити (С# Сити)");

        int mOption = scn.nextInt();

        if (mOption == 1) {
            Scanner scn2 = new Scanner(System.in);
            System.out.print("Въведете името на първи отбор: ");
            String teamName = scn2.nextLine();
            team[1].setTeamName(teamName);

            System.out.print("Въведете името на втори отбор: ");
            teamName = scn2.nextLine();
            team[2].setTeamName(teamName);
        }
        if (mOption == 2) {
            team[1].setTeamName("Хитрите мечоци (с.Хитрино)");
            team[2].setTeamName("Лисиците (с.Лесичери)");

        }
        if (mOption == 3) {
            team[1].setTeamName("Джедаи (Джаваполис)");
            team[2].setTeamName("Сити (С# Сити)");
        }

        //ХАРДКОД ТРЕНьОРИ
        team[1].coach = new Coach("Юрген", "Клоп", 55);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("Карло", "Анчелоти", 63);
        team[2].coach.onWhichTeam = 2;

        SquadOperations.createNewPlayers();
        SquadOperations.showSquad();

        //МЕНЮ 2
        System.out.println("Моля изберете опции за избор на играчите");
        System.out.println("1) Ще закупуваме играчите ръчно за всеки отбор");
        System.out.println("2) Закупи автоматично играчите и за двата отбора");

        mOption = scn.nextInt();

        if (mOption == 2) SquadOperations.autoBuyPlayers();
        else {
            SquadOperations.buyPlayers(1);
            SquadOperations.showSquad();
            SquadOperations.buyPlayers(2);
        }

        //Покажи играчите след закупуването
        SquadOperations.showSquad();
        curMatch = new Match(team[1], team[2]);
        curMatch.showTeams();
        curMatch.playGame();
    }
}




