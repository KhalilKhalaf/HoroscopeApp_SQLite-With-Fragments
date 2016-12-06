package com.Khalil.MyHoroscope;


public class Horoscope {

    private String name;
    private String sign;
    private String description;
    private String month;
    private String horoscope;

    public static final Horoscope[] horoscopes = new Horoscope[] {
        new Horoscope("Class", "Ram", "Aries Description Here", "April", "Aries Story Here"),
        new Horoscope("Taurus", "Bull", "Taurus Description Here", "May", "Taurus Story Here"),
        new Horoscope("Gemini", "Twins", "Gemini Description Here", "June", "Gemini Story Here"),
        new Horoscope("Cancer", "Crab", "Cancer Description Here", "July", "Cancer Story Here"),
        new Horoscope("Leo", "Lion", "Leo Description Here", "August", "Leo Story Here"),
        new Horoscope("Virgo", "Virgin", "Virgo Description Here", "September", "Virgo Story Here"),
        new Horoscope("Libra", "Scales", "Libra Description Here", "October", "Libra Story Here"),
        new Horoscope("Scorpio", "Scorpion", "Scorpio Description Here", "November", "Scorpio Story Here"),
        new Horoscope("Sagittarius", "Archer", "Sagittarius Description Here", "December", "Sagittarius Story Here"),
        new Horoscope("Capricorn", "Goat", "Capricorn Description Here", "January", "Capricorn Story Here"),
        new Horoscope("Aquarius", "Water Bearer", "Aquarius Description Here", "February", "Aquarius Story Here"),
        new Horoscope("Pisces", "Fish", "Pisces Description Here", "March", "Pisces Story Here")
    };

    private Horoscope(String name, String sign, String description, String month, String horoscope) {
        this.name = name;
        this.sign = sign;
        this.description = description;
        this.month = month;
        this.horoscope = horoscope;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public String getDescription() {
        return description;
    }

    public String getMonth() {
        return month;
    }

    public String getHoroscope() {
        return horoscope;
    }

}
