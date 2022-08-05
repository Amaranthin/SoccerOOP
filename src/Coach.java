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
            if (Main.team[this.onWhichTeam].addNewPlayer(ix) ) //addNewPlayer връща истина само ако е ОК закупуването
            {
                //играча ни да се присъедини към тима, чийто принадлежност е на треньора
                Main.player[ix].playerOnWhichTeam = this.onWhichTeam;
                Main.player[ix].fromTeam = Main.team[this.onWhichTeam];
            }
            //Показва наличния склад към момента за същия отбор
            System.out.println(Main.team[this.onWhichTeam].showSquadLineByPositions());
        }
        else
        {
            System.out.print("Този играч вече е закупен от отборът на ");
            System.out.println(Main.team[Main.player[ix].playerOnWhichTeam].getColoredTeamName());
        }
    }

    public String toString()
    {
        return this.firstName + " " + this.familyName + " " + this.age + " г.";
    }
}
