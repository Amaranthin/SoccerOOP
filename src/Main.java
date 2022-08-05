import java.util.Scanner;

public class Main {

    public static Match curMatch;
    public static int gameSpeed;

    public static Team[] team = new Team[3];
    //team[0] > ������ ������ ��� ���� (�������� ������)
    //team[1] > ������ �����,
    //team[2] > �������������� �����,
    //���� � ���� ����������, �������� �� �� ���������!!!

    public static Footballer[] player = new Footballer[101];

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i <= 2; i++) {
            //�������� ��������� �� ��������
            Team newTeam = new Team("�������� �����", i);   //��������� �� �� ������� ���� ������� i
            team[i] = newTeam;
        }

        //���� 1
        System.out.println("���� �������� ����� �� ����� ������");
        System.out.println("1) �� ������� ������� �����");
        System.out.println("2) ������� ������ (�.�������) - �������� (�.��������)");
        System.out.println("3) ������ (����������) - ���� (�# ����)");

        int mOption = scn.nextInt();

        if (mOption == 1) {
            Scanner scn2 = new Scanner(System.in);
            System.out.print("�������� ����� �� ����� �����: ");
            String teamName = scn2.nextLine();
            team[1].setTeamName(teamName);

            System.out.print("�������� ����� �� ����� �����: ");
            teamName = scn2.nextLine();
            team[2].setTeamName(teamName);
        }
        if (mOption == 2) {
            team[1].setTeamName("������� ������ (�.�������)");
            team[2].setTeamName("�������� (�.��������)");

        }
        if (mOption == 3) {
            team[1].setTeamName("������ (����������)");
            team[2].setTeamName("���� (�# ����)");
        }

        //������� ��������
        team[1].coach = new Coach("�����", "����", 55);
        team[1].coach.onWhichTeam = 1;
        team[2].coach = new Coach("�����", "��������", 63);
        team[2].coach.onWhichTeam = 2;

        SquadOperations.createNewPlayers();
        SquadOperations.showSquad();

        //���� 2
        System.out.println("���� �������� ����� �� ����� �� ��������");
        System.out.println("1) �� ���������� �������� ����� �� ����� �����");
        System.out.println("2) ������ ����������� �������� � �� ����� ������");

        mOption = scn.nextInt();

        if (mOption == 2) SquadOperations.autoBuyPlayers();
        else {
            SquadOperations.buyPlayers(1);
            SquadOperations.showSquad();
            SquadOperations.buyPlayers(2);
        }

        //������ �������� ���� ������������
        SquadOperations.showSquad();
        curMatch = new Match(team[1], team[2]);
        curMatch.showTeams();
        curMatch.playGame();
    }
}




