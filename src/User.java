//--- Filename: User.java ---//

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    static int autoUserId = 0;  // For automatic assignment of user IDs

    ///----- ATTRIBUTES -----///
    int userId;
    String name;
    String contactInformation;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    ///----- CONSTRUCTOR -----///
    User(String userName, String userContactInfo) {

        autoUserId++;   // Incrementing the autoUserId variable to assign new IDs to each additional user

        userId = autoUserId;
        name = userName;
        contactInformation = userContactInfo;
    }
}
