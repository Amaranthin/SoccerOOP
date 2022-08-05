import java.util.Random;

public class Person {

    Random rnd = new Random();

    public int age;
    public String firstName;
    public String familyName;

    public Person(String firstName, String familyName, int age)
    {
        this.age = age;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public Person()
    {
        this.firstName = getRandomFirstName();
        this.familyName =  getRandomAlias();
        this.age = rnd.nextInt(20)+17;
    }

    public String toString()
    {
        return this.firstName + " " + this.familyName + " Age:" + age;
    }

    private String getRandomFirstName()
    {
        String[] names = new String[61];

        names[1] = "Александър";
        names[2] = "Ангел";
        names[3] = "Антон";
        names[4] = "Ахмед";
        names[5] = "Борис";
        names[6] = "Валентин";
        names[7] = "Валери";
        names[8] = "Виктор";
        names[9] = "Венелин";
        names[10] = "Георги";
        names[11] = "Григор";
        names[12] = "Добрин";
        names[13] = "Дениз";
        names[14] = "Евгени";
        names[15] = "Живко";
        names[16] = "Здравко";
        names[17] = "Ивайло";
        names[18] = "Иван";
        names[19] = "Илия";
        names[20] = "Йордан";
        names[21] = "Калин";
        names[22] = "Камен";
        names[23] = "Лазар";
        names[24] = "Левент";
        names[25] = "Любомир";
        names[26] = "Мартин";
        names[27] = "Милен";
        names[28] = "Мирослав";
        names[29] = "Мерт";
        names[30] = "Мехмед";
        names[31] = "Михаил";
        names[32] = "Найден";
        names[33] = "Никола";
        names[34] = "Николай";
        names[35] = "Огнян";
        names[36] = "Павлин";
        names[37] = "Пресиян";
        names[38] = "Петко";
        names[39] = "Петър";
        names[40] = "Пенчо";
        names[41] = "Росен";
        names[42] = "Ростислав";
        names[43] = "Радостин";
        names[44] = "Светлин";
        names[45] = "Светослав";
        names[46] = "Севдалин";
        names[47] = "Теодор";
        names[48] = "Тихомир";
        names[49] = "Тодор";
        names[50] = "Турхан";
        names[51] = "Тунчай";
        names[52] = "Фикрет";
        names[53] = "Цанко";
        names[54] = "Чавдар";
        names[55] = "Юлиян";
        names[56] = "Явор";
        names[57] = "Ясен";
        names[58] = "Бързомир";
        names[59] = "Дузполюб";
        names[60] = "Финтослав";

        int x = rnd.nextInt(names.length-1)+1;
        return names[x];
    }

    private String getRandomAlias() {
        String[] alias = new String[45];

        alias[1] = "Бързия";
        alias[2] = "Бълхата";
        alias[3] = "Охлюва";
        alias[4] = "Забавния";
        alias[5] = "Машината";
        alias[6] = "Мишока";
        alias[7] = "Кучето";
        alias[8] = "Тигъра";
        alias[9] = "Сладкодумкото";
        alias[10] = "Гларуса";
        alias[11] = "Светкавицата";
        alias[12] = "Бекъма";
        alias[13] = "Бързоногия";
        alias[14] = "Стрелата";
        alias[15] = "Комара";
        alias[16] = "Мечока";
        alias[17] = "Татуса";
        alias[18] = "Кюфтето";
        alias[19] = "Кошмара";
        alias[20] = "Дъвката";
        alias[21] = "Прасеца";
        alias[22] = "Готиния";
        alias[23] = "Стършела";
        alias[24] = "Кеца";
        alias[25] = "Караокето";
        alias[26] = "Нервака";
        alias[27] = "Криптото";
        alias[28] = "Къдравия";
        alias[29] = "Дългия";
        alias[30] = "Финта";
        alias[31] = "Манекена";
        alias[32] = "Животното";
        alias[33] = "Аудито";
        alias[34] = "Мозъка";
        alias[35] = "Професора";
        alias[36] = "Фъстъка";
        alias[37] = "Брадвата";
        alias[38] = "Камата";
        alias[39] = "Левачката";
        alias[40] = "Хитреца";
        alias[41] = "Бандита";
        alias[42] = "Бадема";
        alias[43] = "Петичката";
        alias[44] = "Симуланта";

        int x = rnd.nextInt(alias.length-1)+1;
        return alias[x];
    }

}

