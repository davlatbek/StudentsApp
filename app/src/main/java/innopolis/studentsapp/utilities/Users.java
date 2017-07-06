package innopolis.studentsapp.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davlet on 6/20/17.
 */

public class Users {
    private static Users users;
    public static String user = "";
    public static String password = "";
    public static Map<String, String> userPasswordMap;

    private Users(){
        userPasswordMap = new HashMap<>();
        userPasswordMap.put("", "");
        userPasswordMap.put("albert", "einstein");
        userPasswordMap.put("lillie", "clinton");
        userPasswordMap.put("admin", "admin");
    }

    public static Users getInstance(){
        if (users == null)
            return new Users();
        return users;
    }
}
