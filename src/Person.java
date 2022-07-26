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

        name[1] = "����������";
        name[2] = "�����";
        name[3] = "�����";
        name[4] = "�����";
        name[5] = "�����";
        name[6] = "��������";
        name[7] = "������";
        name[8] = "������";
        name[9] = "�������";
        name[10] = "������";
        name[11] = "������";
        name[12] = "������";
        name[13] = "�����";
        name[14] = "������";
        name[15] = "�����";
        name[16] = "�������";
        name[17] = "������";
        name[18] = "����";
        name[19] = "����";
        name[20] = "������";
        name[21] = "�����";
        name[22] = "�����";
        name[23] = "�����";
        name[24] = "������";
        name[25] = "�������";
        name[26] = "������";
        name[27] = "�����";
        name[28] = "��������";
        name[29] = "����";
        name[30] = "������";
        name[31] = "������";
        name[32] = "������";
        name[33] = "������";
        name[34] = "�������";
        name[35] = "�����";
        name[36] = "������";
        name[37] = "�������";
        name[38] = "�����";
        name[39] = "�����";
        name[40] = "�����";
        name[41] = "�����";
        name[42] = "���������";
        name[43] = "��������";
        name[44] = "�������";
        name[45] = "���������";
        name[46] = "��������";
        name[47] = "������";
        name[48] = "�������";
        name[49] = "�����";
        name[50] = "������";
        name[51] = "������";
        name[52] = "������";
        name[53] = "�����";
        name[54] = "������";
        name[55] = "�����";
        name[56] = "����";
        name[57] = "����";

        int x = rnd.nextInt(56)+1;

        return name[x];

    }

    private String getRandomAlias() {
        String[] alias = new String[41];

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

        int x = rnd.nextInt(39)+1;

        return alias[x];
    }

}

