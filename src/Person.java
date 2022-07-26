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
        String[] name = new String[58];

        name[1] = "Александър";
        name[2] = "Ангел";
        name[3] = "Антон";
        name[4] = "Ахмед";
        name[5] = "Борис";
        name[6] = "Валентин";
        name[7] = "Валери";
        name[8] = "Виктор";
        name[9] = "Венелин";
        name[10] = "Георги";
        name[11] = "Григор";
        name[12] = "Добрин";
        name[13] = "Дениз";
        name[14] = "Евгени";
        name[15] = "Живко";
        name[16] = "Здравко";
        name[17] = "Ивайло";
        name[18] = "Иван";
        name[19] = "Илия";
        name[20] = "Йордан";
        name[21] = "Калин";
        name[22] = "Камен";
        name[23] = "Лазар";
        name[24] = "Левент";
        name[25] = "Любомир";
        name[26] = "Мартин";
        name[27] = "Милен";
        name[28] = "Мирослав";
        name[29] = "Мерт";
        name[30] = "Мехмед";
        name[31] = "Михаил";
        name[32] = "Найден";
        name[33] = "Никола";
        name[34] = "Николай";
        name[35] = "Огнян";
        name[36] = "Павлин";
        name[37] = "Пресиян";
        name[38] = "Петко";
        name[39] = "Петър";
        name[40] = "Пенчо";
        name[41] = "Росен";
        name[42] = "Ростислав";
        name[43] = "Радостин";
        name[44] = "Светлин";
        name[45] = "Светослав";
        name[46] = "Сведалин";
        name[47] = "Теодор";
        name[48] = "Тихомир";
        name[49] = "Тодор";
        name[50] = "Турхан";
        name[51] = "Тунчай";
        name[52] = "Фикрет";
        name[53] = "Цанко";
        name[54] = "Чавдар";
        name[55] = "Юлиян";
        name[56] = "Явор";
        name[57] = "Ясен";

        int x = rnd.nextInt(56)+1;

        return name[x];

    }

    private String getRandomAlias() {
        String[] alias = new String[41];

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

        int x = rnd.nextInt(39)+1;

        return alias[x];
    }

}

