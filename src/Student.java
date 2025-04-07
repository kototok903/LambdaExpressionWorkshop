import java.util.Random;

public class Student {
    private String name;
    private float gpa;
    private Grade grade;

    static String[] namesList = new String[]{"Johnnie Hoga", "Bert Pearso", "Sonny Aceved", "Edmundo Stevenso", "Lesley Tapi", "Michael Jenkin", "Samuel Schmid", "Hipolito Robert", "Vanessa Potte", "Wes Peterso", "Arron May", "Brenton Spence", "Abe Vazque", "Ricky Duart", "Fritz Mannin", "Ezekiel Kir", "Rudolf Tyle", "Antoinette Camero", "Candace Winter", "Louella Rui", "Buford Ponc", "Hilario Boye", "Micheal Erickso", "Sasha Cardena", "Gregg Kin", "Helen Bernar", "Guy Hendrick", "Genaro Loga", "Kerry Holme", "Saul Russ", "Allison Aria", "Elsie Mosle", "Alberta Comb", "Winford Vele", "Cody Berr", "Maurice Flower", "Cindy Owen", "Julian Huyn", "Jamel Sha", "Stewart Castr", "Brian Nelso", "Sergio Aguirr", "Juana Dun", "Tyson Butle", "Leslie Gonzale", "Katie La", "Milton Buc", "Cedric Ferguso", "Ines Edward", "Elton Y"};

    public Student() {
        Random random = new Random();
        name = namesList[random.nextInt(namesList.length)];
        gpa = random.nextFloat(0, 4);
        grade = Grade.values()[random.nextInt(6)];
    }
}

