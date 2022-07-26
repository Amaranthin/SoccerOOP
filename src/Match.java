public class Match {

    public int currentMinute = 0;

    public Team[] team = new Team[3]; //тези инстанции се пренасочват към инстанции създадени в Main

    public Match(Team team1, Team team2)
    {
        this.team[1] = team1;  //можеше да ги предадем и чрез индекси от мейн инстанциите а тук да = Main.team[ix]
        this.team[2] = team2;  //но така е по-демонстративно

    }


    public void playGame()
    {
        showTeams();
    }

    public void showTeams()
    {
        printLineIn100('=');
        System.out.println();
        printCenterIn50(team[1].getTeamName());
        printCenterIn50(team[2].getTeamName());
        System.out.println();
        printLineIn100('=');
        System.out.println();

        for (int pos=1;pos<=11;pos++)
        {
            for (int tm=1;tm<=2;tm++)
            {
                printLeftIn50(team[tm].player[pos].shortInfo());
            }
            System.out.println();
        }

        printLineIn100('=');
        System.out.println();
    }


    public void printLeftIn50(String txt)
    {
        String finalText="";

        for (int i=0;i<50;i++)
        {
            if (i<txt.length()) finalText += txt.charAt(i);
            else finalText+=" ";
        }

        System.out.print(finalText);
    }

    public void printCenterIn50(String txt)
    {
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

        System.out.print(finalTxt);
    }

    public void printLineIn100(char c)
    {
        String s100="";

        for (int i=0;i<100;i++)
        {
            s100 += c;
        }

        System.out.print(s100);
    }


}
