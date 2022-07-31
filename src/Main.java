import java.util.Scanner;

public class Main {

    public static Match curMatch;

    public static Team[] team = new Team[3];
    //team[0] > ������ ������ ��� ���� (�������� ������)
    //team[1] > ������ �����,
    //team[2] > �������������� �����,
    //���� � ���� ����������, �������� �� �� ���������!!!

    public static Footballer[] player = new Footballer[101];
    public static FootballerLastGameStats[] playerStats = new FootballerLastGameStats[101];


    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        for (int i=0; i<=2; i++)
        {
            //�������� ��������� �� ��������
            Team newTeam = new Team("�������� �����",i);   //��������� �� �� ������� ���� ������� i
            team[i] = newTeam;
        }

        System.out.print("�������� ����� �� ����� �����: ");
        String teamName  = scn.nextLine();
        team[1].setTeamName(teamName);


        System.out.print("�������� ����� �� ����� �����: ");
        teamName  = scn.nextLine();
        team[2].setTeamName(teamName);

        //������� ��������
        team[1].coach = new Coach("�����", "����", 55);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("�����", "��������", 63);
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
