public class FootballerLastGameStats extends Footballer {
    //�� ����������� ������������ �� ������ � ������ ����� �� ����� �� ����

    public int shootsOnGoals =0 ;
    public int goals =0;
    public int passesSuccess =0;
    public int passesFail =0;
    public int takenBalls =0;
    public int saves =0; //just for goalkeepers

    public FootballerLastGameStats(int ix)
    {
        //������� �� �� ������ ����������� � ����������� ����
        //� �� �������� ���� ����� ������ �� ����������� � MAIN ������ �� �� ������ ����� �������� �� ������
        this.firstName = Main.player[ix].firstName;
        this.familyName = Main.player[ix].familyName;
    }
}
