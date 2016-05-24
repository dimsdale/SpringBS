package ukr.dsa.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ukr.dsa.model.Contact;
import ukr.dsa.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Surger on 14.05.2016.
 */
public class JSONConverter {
    public static final String userFile = "User.json";
    public static final String contactFile = "Contact.json";

    public static void toJSON(Contact contact){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileOutputStream(contactFile), contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toJSON(User user){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileOutputStream(userFile), user);
            System.out.println("Yes!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
