package uz.lb.models;

public class CountryPhoneData {
    private String name;
    private String code;
    private int length;

    public CountryPhoneData(String name, String code, int length) {
        this.name = name;
        this.code = code;
        this.length = length;
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public int getLength() { return length; }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}
