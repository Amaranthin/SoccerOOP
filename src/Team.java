public class Team {


    private String teamName;
    public Coach coach;
    public int countFootballers = 0;
    public Footballer[] player = new Footballer[25];

    public boolean isTeamCompleted = false;

    private int goalkeepers = 0;
    private int defenders = 0;
    private int midfields = 0;
    private int forwards = 0;

    public Team()
    {
        this.teamName = "New Team";
    }

    public Team(String teamName)
    {
        setTeamName(teamName);
    }

    public void setTeamName(String teamName)
    {
        //изнесох го в пропърти заради евентуална валицадия
        //ако държим да е на латиница или не по-дълго от определена дължина
        this.teamName = teamName;
    }

    public boolean addNewPlayer(int ix)
    {
        if (this.countFootballers<11) {
            if (Main.player[ix].fieldPosition.equals("Goalkeeper") && this.goalkeepers == 1) {
                System.out.println("Не можете да закупите втори вратар!");
                return false;
            } else {
                //увеличаваме играчите в отбора с 1
                this.countFootballers++;

                //нашият играч, кой точно играч от основния склад е
                this.player[this.countFootballers] = Main.player[ix];

                //увеличаваме броя на играчите на съответната позиция
                if (Main.player[ix].fieldPosition.equals("Goalkeeper")) this.goalkeepers++;
                if (Main.player[ix].fieldPosition.equals("Defender")) this.defenders++;
                if (Main.player[ix].fieldPosition.equals("Midfield")) this.midfields++;
                if (Main.player[ix].fieldPosition.equals("Forward")) this.forwards++;

                if (this.countFootballers == 11)
                {
                    this.isTeamCompleted = true;
                    sortPlayerList();
                }
            }
        }
        else {
            System.out.println("Вие вече разполагате с 11 играчи"); return false;
        }
        return true;
    }

    public String getTeamName()
    {
        return this.teamName;
    }

    public String showSquadLineByPositions()
    {
        //помощна линия при закупуването на играчи
        int gk = this.goalkeepers;
        int def = this.defenders;
        int mid = this.midfields;
        int fwd = this.forwards;

        //разполагаме със следните играчи като бройка:
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

                if (p1>p2)  //да им разменим местата за да се покажат подредени по позиции
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

}
