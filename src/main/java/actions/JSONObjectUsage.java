package actions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Arrays;

public class JSONObjectUsage {

    public static void main(String[] args) {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("name", "Sneha");
//        jsonObject.addProperty("age", 25);
//        JsonArray addresses = new JsonArray();
//        addresses.add("PFS");
//        addresses.add("RV");
//        jsonObject.add("addresses", addresses);
//        JsonArray detailedAddresses = new JsonArray();
//
//        JsonObject myFirstAddress = new JsonObject();
//        myFirstAddress.addProperty("f", "PFS");
//        myFirstAddress.addProperty("zc", 560037);
//        detailedAddresses.add(myFirstAddress);
//
//        JsonObject mySecondAddress = new JsonObject();
//        mySecondAddress.addProperty("f", "RV");
//        mySecondAddress.addProperty("zc", 560037);
//        detailedAddresses.add(mySecondAddress);
//
//        jsonObject.add("da", detailedAddresses);
//
//        System.out.println(jsonObject.toString());

        Person person = new Person("Sneha", 25, Arrays.asList("RV", "PFS"));
        String serialized = new Gson().toJson(person);
        System.out.println(serialized);
        Person deserializedPerson = new Gson().fromJson(serialized, Person.class);
        System.out.println(deserializedPerson);
    }
}
