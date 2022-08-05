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

        names[1] = "����������";
        names[2] = "�����";
        names[3] = "�����";
        names[4] = "�����";
        names[5] = "�����";
        names[6] = "��������";
        names[7] = "������";
        names[8] = "������";
        names[9] = "�������";
        names[10] = "������";
        names[11] = "������";
        names[12] = "������";
        names[13] = "�����";
        names[14] = "������";
        names[15] = "�����";
        names[16] = "�������";
        names[17] = "������";
        names[18] = "����";
        names[19] = "����";
        names[20] = "������";
        names[21] = "�����";
        names[22] = "�����";
        names[23] = "�����";
        names[24] = "������";
        names[25] = "�������";
        names[26] = "������";
        names[27] = "�����";
        names[28] = "��������";
        names[29] = "����";
        names[30] = "������";
        names[31] = "������";
        names[32] = "������";
        names[33] = "������";
        names[34] = "�������";
        names[35] = "�����";
        names[36] = "������";
        names[37] = "�������";
        names[38] = "�����";
        names[39] = "�����";
        names[40] = "�����";
        names[41] = "�����";
        names[42] = "���������";
        names[43] = "��������";
        names[44] = "�������";
        names[45] = "���������";
        names[46] = "��������";
        names[47] = "������";
        names[48] = "�������";
        names[49] = "�����";
        names[50] = "������";
        names[51] = "������";
        names[52] = "������";
        names[53] = "�����";
        names[54] = "������";
        names[55] = "�����";
        names[56] = "����";
        names[57] = "����";
        names[58] = "��������";
        names[59] = "��������";
        names[60] = "���������";

        int x = rnd.nextInt(names.length-1)+1;
        return names[x];
    }

    private String getRandomAlias() {
        String[] alias = new String[45];

        alias[1] = "������";
        alias[2] = "�������";
        alias[3] = "������";
        alias[4] = "��������";
        alias[5] = "��������";
        alias[6] = "������";
        alias[7] = "������";
        alias[8] = "������";
        alias[9] = "�������������";
        alias[10] = "�������";
        alias[11] = "������������";
        alias[12] = "������";
        alias[13] = "����������";
        alias[14] = "��������";
        alias[15] = "������";
        alias[16] = "������";
        alias[17] = "������";
        alias[18] = "�������";
        alias[19] = "�������";
        alias[20] = "�������";
        alias[21] = "�������";
        alias[22] = "�������";
        alias[23] = "��������";
        alias[24] = "����";
        alias[25] = "���������";
        alias[26] = "�������";
        alias[27] = "��������";
        alias[28] = "��������";
        alias[29] = "������";
        alias[30] = "�����";
        alias[31] = "��������";
        alias[32] = "���������";
        alias[33] = "������";
        alias[34] = "������";
        alias[35] = "���������";
        alias[36] = "�������";
        alias[37] = "��������";
        alias[38] = "������";
        alias[39] = "���������";
        alias[40] = "�������";
        alias[41] = "�������";
        alias[42] = "������";
        alias[43] = "���������";
        alias[44] = "���������";

        int x = rnd.nextInt(alias.length-1)+1;
        return alias[x];
    }

}

