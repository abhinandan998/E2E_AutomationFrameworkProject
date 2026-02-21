package Abhinandan_Project.UI.POJOS;

public class AddressPOJO {
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String Postcode;
    private String HomePhone;
    private String MobilePhone;
    private String otherInfo;

    public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postcode, String homePhone, String mobilePhone, String otherInfo, String addressAlias, String state) {
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        Postcode = postcode;
        HomePhone = homePhone;
        MobilePhone = mobilePhone;
        this.otherInfo = otherInfo;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    private String addressAlias;
    private String state;

    public String getCompany() {
        return company;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return Postcode;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "AddressPOJO{" +
                "company='" + company + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", Postcode='" + Postcode + '\'' +
                ", HomePhone='" + HomePhone + '\'' +
                ", MobilePhone='" + MobilePhone + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
