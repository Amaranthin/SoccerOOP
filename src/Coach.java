import java.util.Scanner;

public class Coach extends Person{

    public int onWhichTeam;

    Scanner scn = new Scanner(System.in);

    public Coach(String firstName, String familyName, int age)
    {
        super(firstName, familyName , age);
        this.onWhichTeam = 0;
    }

    public void buyPlayer(int ix)
    {
        if (Main.player[ix].playerOnWhichTeam ==0 )
        {

            //�������� ������ � ���������� �����. * ������ ����� ������ ��� ������ � ������� �������
            if(Main.team[this.onWhichTeam].addNewPlayer(ix) ) {
                //������ �� �� ������ ��������������� �� ��������
                Main.player[ix].playerOnWhichTeam = this.onWhichTeam;
            }
            //������� �������� ����� ��� ������� �� ����� �����
            System.out.println(Main.team[this.onWhichTeam].showSquadLineByPositions());
        }
    }

}
