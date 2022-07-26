import java.util.Scanner;

public class Main {

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
            Team mmm = new Team();   //�������� ��������� �� ��������
            team[i] = mmm;
        }

        team[0].setTeamName("�������� �����");  //������� �� ���� ������������� �� ������

        System.out.print("�������� ����� �� ����� �����: ");
        String teamName  = scn.nextLine();
        team[1].setTeamName(teamName);

        System.out.print("�������� ����� �� ������������� �����: ");
        teamName  = scn.nextLine();
        team[2].setTeamName(teamName);

        team[1].coach = new Coach("������", "�����", 45);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("�����", "����", 55);
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
        s+= Footballer.addIntervals("���",12);
        s+= Footballer.addIntervals("������",16);
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
            if (firstTime) player[i] = new Footballer(); //������� � ������ ������ �� ���� ��� ����� ���������!!!
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
        System.out.println(", ���� �������� ������");
        System.out.println();

        boolean newBuy = true;
        while (newBuy)
        {
            System.out.print("�������� ����� �� ������, ����� ������ �� ��������:");
            int num = scn.nextInt();

            if (num<=100) team[iTrainer].coach.buyPlayer(num);
            else newBuy = false;

        }

    }
}
