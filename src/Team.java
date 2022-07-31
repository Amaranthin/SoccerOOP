import java.util.Random;

public class Team {


    private String teamName;
    public Coach coach;
    public int countFootballers = 0;
    public boolean hadGoalkeeper = false;

    public Footballer[] player = new Footballer[12]; //�� ���������� 0


    public boolean isTeamCompleted = false;
    public int totalTeamPrice = 0;

    private int goalkeepers = 0;
    protected int defenders = 0; //���������� �� ��� ������ � ������
    protected int midfields = 0; //���������� �� ��� ������
    private int forwards = 0;
    public int teamColor = 0;
    public int teamTimeBallOwnership;  // ��������� �� � 1 ���� ����� ��������� �� ������� � ������
    public Team currentEnemyTeam;
    public int teamGoalsInCurrentMatch = 0;

    public Team()
    {
        this.teamName = "New Team";
    }

    public Team(String teamName)
    {
        setTeamName(teamName);
    }
    public Team(String teamName, int color)
    {
        setTeamName(teamName);
        this.teamColor = color; //���� ���� �� � � ��������
    }

    public void setTeamName(String teamName)
    {
        //������� �� � �������� ������ ���������� ���������
        //� � ����� �� �������� ������� ���������� ���������� ���� ���� ���� �������� �� ���������
        this.teamName = teamName;
    }

    public boolean addNewPlayer(int ix)
    {
        if (this.countFootballers<11) {
            if (Main.player[ix].fieldPosition.equals("Goalkeeper") && this.goalkeepers == 1) {
                System.out.println("�� ������ �� �������� ����� ������!");
                return false;
            } else {
                //����������� �������� � ������ � 1
                this.countFootballers++;

                //������ �����, ��� ����� ����� �� �������� ����� �
                this.player[this.countFootballers] = Main.player[ix];

                //����������� ���� �� �������� �� ����������� �������
                if (Main.player[ix].fieldPosition.equals("Goalkeeper")) {this.goalkeepers++; this.hadGoalkeeper = true;}
                if (Main.player[ix].fieldPosition.equals("Defender")) this.defenders++;
                if (Main.player[ix].fieldPosition.equals("Midfield")) this.midfields++;
                if (Main.player[ix].fieldPosition.equals("Forward")) this.forwards++;

                if (this.countFootballers == 11)
                {
                    this.isTeamCompleted = true;
                    sortPlayerList();
                    setTotalTeamPrice();
                }
            }
        }
        else {
            System.out.println("��� ���� ����������� � 11 ������"); return false;
        }
        return true;
    }

    public String getTeamName()
    {
        return this.teamName;
    }

    public String getColoredTeamName()
    {
        String clr = Match.getColor(this.teamColor);
        return clr+this.teamName+Match.getColor(0);
    }

    public String showSquadLineByPositions()
    {
        //������� ����� ��� ������������ �� ������
        int gk = this.goalkeepers;
        int def = this.defenders;
        int mid = this.midfields;
        int fwd = this.forwards;

        //����������� ��� �������� ������ ���� ������:
        return "(gk def mid fwd)"+ "\n(" + gk + " " + def + " " + mid + " " + fwd +")";

    }

    public void sortPlayerList()
    {
        for (int i=1; i<=10;i++)
        {
            for (int j=i+1;j<=11;j++)
            {
                int p1 = convertPosition(player[i].fieldPosition);
                int p2 = convertPosition(player[j].fieldPosition);

                if (p1>p2)  //�� �� �������� ������� �� �� �� ������� ��������� �� �������
                {
                    Footballer tempFootballer = player[i];
                    player[i] = player[j];
                    player[j] = tempFootballer;
                }
            }
        }
    }

    private int convertPosition(String txt)
    {
        switch (txt)
        {
            case "Goalkeeper" -> {
                return 1;
            }
            case "Defender" -> {
                return 2;
            }
            case "Midfield" -> {
                return 3;
            }
            case "Forward" -> {
                return 4;
            }
            default -> {
                return 0;
            }
        }
    }

    private void setTotalTeamPrice(){
        int totPrice = 0;
        for (int i=1; i<=11;i++)
        {
           totPrice += this.player[i].priceInThousandsEuro;
        }

        this.totalTeamPrice = totPrice;
    }

    public Footballer getRandomFieldPlayer()
    {
        //������ ����� �� ����� ����� ���� ������� �� ������ �� ����������,
        //����� � ������� ��������� �������
        Random x = new Random();
        int ix = x.nextInt(10)+2; //���� ������ ������, �.�. ��� �������

        return this.player[ix];

    }
}
