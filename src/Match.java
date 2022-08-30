import java.util.Random;
import java.util.Scanner;

public class Match {

    public int currentMinute = 0;
    public Footballer lastPlayerWithBall;
    private int[] teamNumbersInCattalog = new int[3];
    public Team[] team = new Team[3]; //���� ��������� �� ����������� ��� ��������� ��������� � Main
    public String[] scoreBoard = new String[20];

    public Match(Team team1, Team team2)
    {
        this.team[1] = team1;  //������ �� �� �������� � ���� ������� �� ���� ����������� � ��� �� = Main.team[ix]
        this.team[2] = team2;  //�� ���� � ��-��������������
        this.teamNumbersInCattalog[1] = team1.coach.onWhichTeam;
        this.teamNumbersInCattalog[2] = team2.coach.onWhichTeam;

        team1.currentEnemyTeam = team2;
        team2.currentEnemyTeam = team1;
    }

    public void playGame()
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("�������� ������� �� ������. �������������� ������� [0-200], ���� 200 � ���-�������.");
        Main.gameSpeed = 1000*scn.nextInt();

        System.out.println();
        System.out.println(getColor(3)+"������ �� �������"+getColor(0));

        while (Main.curMatch.currentMinute<90)
        {
            if (currentMinute==0)
            {
                Random x = new Random();
                int ix = x.nextInt(10)+2;
                putBallInPlayer(Main.team[1].player[ix]);
            }
            else
            {
                putBallInPlayer(Main.curMatch.lastPlayerWithBall);
            }
        }

        System.out.println(getColor(3)+"���� �� ����"+getColor(0));
        showCurMatchInfo();
    }


    public static void putBallInPlayer(Footballer currentFootballer)
    {
        Main.curMatch.lastPlayerWithBall = currentFootballer;
        if (Main.curMatch.currentMinute<95) currentFootballer.play();
    }

    public void showTeams()
    {
        printLineIn100('=');
        printCenterIn50(team[1].getTeamName(),team[1].teamColor);
        printCenterIn50(team[2].getTeamName(),team[2].teamColor);
        System.out.println();
        printLineIn100('=');

        for (int pos=1;pos<=11;pos++)
        {
            for (int tm=1;tm<=2;tm++)
            {
                if (pos<10)  printLeftIn50(pos+") " + team[tm].player[pos].shortInfoForTimeList(),team[tm].teamColor);
                else printLeftIn50(pos+")" + team[tm].player[pos].shortInfoForTimeList(), team[tm].teamColor);
            }
            System.out.println();
        }

        printLineIn100('=');
        printCenterIn50("���� ����:" + team[1].totalTeamPrice + "K", team[1].teamColor);
        printCenterIn50("���� ����:" + team[2].totalTeamPrice + "K",team[2].teamColor);
        System.out.println();
        printLineIn100('=');
        printCenterIn50(team[1].coach.toString(), team[1].teamColor);
        printCenterIn50(team[2].coach.toString(), team[2].teamColor);
        System.out.println();
        printLineIn100('=');
    }

    public static void showRandomGoalSituation(Footballer forward, Footballer goalkeeper)
    {
        Random x = new Random();

        String fwPlayer = forward.getFullName();
        String gkPlayer = goalkeeper.getFullName();

        //���� �� ������ ������ �� ���� ��� ������������ �� ������� --------------------------------------------------
        int brGoals = Main.team[1].teamGoalsInCurrentMatch+Main.team[2].teamGoalsInCurrentMatch;
        Main.curMatch.scoreBoard[brGoals] = Main.team[1].teamGoalsInCurrentMatch + ":" + Main.team[2].teamGoalsInCurrentMatch+
                " " +forward.getFullName()+ " "+Main.curMatch.currentMinute+ " ���. ";

        //��� � �� �������, ���� �� ������ ����� ������ � ����
        if (forward.fromTeam.coach.onWhichTeam == 2) Main.curMatch.scoreBoard[brGoals] = "    " + Main.curMatch.scoreBoard[brGoals];
        //-------------------------------------------------------------------------------------------------------------

        System.out.print(getColor(forward.fromTeam.teamColor));
        System.out.print("!!!GOAL!!! " + getColor(0));

        int situation = x.nextInt(6);
        String greda = (x.nextInt(2)==0) ? "�����" : "������";

        switch (situation)
        {
            case 0 -> System.out.println("��������� �� " + fwPlayer + " ����� " + greda + " ��������� ����� � ������� �� ������ � �������.");
            case 1 -> System.out.println(fwPlayer + " ������ ������� ���������� ��� ������� �� " + goalkeeper.fromTeam.getColoredTeamName());
            case 2 -> System.out.println("����������� ���� �� " + fwPlayer + " �� ������ ������� ������� �� " + gkPlayer);
            case 3 -> System.out.println(fwPlayer + " ������ ������� ���� ����� �� ������ �� " + goalkeeper.fromTeam.getColoredTeamName());
            case 4 -> System.out.println(fwPlayer + " ������ ��� � ��� ����� " + gkPlayer + " � �� �� �������� �� �� ������!");
            case 5 -> System.out.println(fwPlayer + " ����� ������� ������� ����� ������� �� " + gkPlayer + "! ��� �� " + forward.fromTeam.getColoredTeamName() + "!");

        }

        situation = x.nextInt(3);
        if (situation==0) System.out.println("����� ��� ���� �� ������� �� " + forward.fromTeam.getColoredTeamName());

        //��� ��� ������� ��-����� ������� ���� �� ������ ������������ �������
        if (forward.fromTeam.teamTimeBallOwnership>2)
        {
            int p = x.nextInt(3);
            if (p==1) System.out.println("��������� ���������� �� ������ �� " + forward.fromTeam.getColoredTeamName());
            if (p==2) System.out.println("�������� �� " + forward.fromTeam.getColoredTeamName() + " �� ������ � �����!");
        }

        //���� �������� ���������� �� �������
        forward.fromTeam.teamTimeBallOwnership=0;

        showCurMatchInfo();

    }

    public static void showCurMatchInfo()
    {
        int totGoals = Main.team[1].teamGoalsInCurrentMatch+Main.team[2].teamGoalsInCurrentMatch;

        Main.curMatch.printLineIn100('=');
        System.out.println(Main.team[1].getColoredTeamName() + " " +
                Main.team[1].teamGoalsInCurrentMatch + ":" + Main.team[2].teamGoalsInCurrentMatch+ " "+
                Main.team[2].getColoredTeamName());
        Main.curMatch.printLineIn100('=');

        for (int goals = 0 ; goals<=totGoals; goals++)
        {
            if (goals>0) System.out.println(Main.curMatch.scoreBoard[goals]);
        }

        Main.curMatch.printLineIn100('=');
    }

    public void printLeftIn50(String txt, int color)
    {
        String clr = getColor(color);
        String finalText="";

        for (int i=0;i<50;i++)
        {
            if (i<txt.length()) finalText += txt.charAt(i);
            else finalText+=" ";
        }

        System.out.print(clr+finalText);
    }

    public static String getColor(int color)
    {
        String clr;
        switch (color) {
            case 0 -> clr = "\u001B[0m"; //normal
            case 1 -> clr = "\u001B[36m";  //cyan
            case 2 -> clr = "\u001B[31m"; //pink
            case 3 -> clr = "\u001B[32m"; //green
            case 4 -> clr = "\u001B[33m"; //yellow
            case 5 -> clr = "\u001B[34m"; //purple
            case 6 -> clr = "\u001B[35m"; //red
            default -> clr = "\u001B[30m"; //����� � ����
        }
        return clr;
    }

    public void printCenterIn50(String txt, int color)
    {
        String clr = getColor(color);
        String finalTxt = "";
        String leftStr = "";
        String rightStr = "";

        int l = (50-txt.length())/2;
        int r = 50-l-txt.length();

        for (int i=1;i<=l;i++)
        {
            finalTxt += " ";
        }

        for (int i=0;i<txt.length();i++)
        {
            finalTxt += txt.charAt(i);
        }

        for (int i=1;i<=r;i++)
        {
            finalTxt += " ";
        }

        System.out.print(clr+finalTxt);
    }

    public void printLineIn100(char c)
    {
        String clr = getColor(0);
        String s100="";

        for (int i=0;i<100;i++)
        {
            s100 += c;
        }

        System.out.print(clr+s100);
        System.out.println();
    }

    public static void spendTime()
    {
        String c = "";
        for (int i=1; i < Main.gameSpeed; i++)
        {
            c += " ";
        }
    }

}
