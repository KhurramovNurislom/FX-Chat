package uz.lb.models;

public class CountryPhoneNumberForm {


    Integer id;
    String country;
    String countryISO;
    String dialCode;
    String mask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public CountryPhoneNumberForm() {

    }
    public CountryPhoneNumberForm(Integer id, String country, String countryISO, String dialCode, String mask) {
        this.id = id;
        this.country = country;
        this.countryISO = countryISO;
        this.dialCode = dialCode;
        this.mask = mask;
    }
    @Override
    public String toString() {
        return "CountryPhoneNumberForm{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", countryISO='" + countryISO + '\'' +
                ", dialCode='" + dialCode + '\'' +
                ", mask='" + mask + '\'' +
                '}';
    }
}