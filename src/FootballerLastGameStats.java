public class FootballerLastGameStats extends Footballer {
    //Ще актуализира статистиката на играча в реално време по време на мача

    public int shootsOnGoals =0 ;
    public int goals =0;
    public int passesSuccess =0;
    public int passesFail =0;
    public int takenBalls =0;
    public int saves =0; //just for goalkeepers

    public FootballerLastGameStats(int ix)
    {
        //нуждаем се от празен конструктор в родителския клас
        //и ще копираме само двете полета от инстанцията в MAIN понеже не ни трябва пълно копиране на обекта
        this.firstName = Main.player[ix].firstName;
        this.familyName = Main.player[ix].familyName;
    }
}
