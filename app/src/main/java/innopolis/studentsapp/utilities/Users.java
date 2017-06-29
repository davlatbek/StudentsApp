package innopolis.studentsapp.utilities;

/**
 * Created by davlet on 6/20/17.
 */

public class Users {
    private static Users users = null;
    public static String user = "";
    public static String password = "";

    private Users(){

    }

    public static Users getInstance(){
        if (users == null)
            return new Users();
        return users;
    }
}
