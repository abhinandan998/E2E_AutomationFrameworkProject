package Abhinandan_Project.Utility;

import Abhinandan_Project.UI.POJOS.AddressPOJO;
import com.github.javafaker.Faker;
import org.apache.commons.math3.analysis.function.Add;

import java.util.Locale;

public class FakeAddressUtility{


    public static void main(String[] args) {
        getFakeAddress();
    }
    public static AddressPOJO getFakeAddress(){
        Faker faker = new Faker(Locale.US);
        return new AddressPOJO(faker.company().name(),faker.address().buildingNumber(),
                faker.address().streetAddress(), "Kharagpur", faker.numerify("721304"),
                faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "Random1234",
                "My HomeAddress", "West Bengal");

    }
}
