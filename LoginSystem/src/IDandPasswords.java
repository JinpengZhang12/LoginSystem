import java.util.HashMap;

public class IDandPasswords {
    // call hash map function to restore login information
    HashMap<String, String> logininfo = new HashMap<String, String>();

    // create constructor for ID and password class
    IDandPasswords() {
        // input user ids and passwords, store them in hashmap
        logininfo.put("Username1", "passwords1");
        logininfo.put("Username2", "passwords2");
        logininfo.put("Username3", "passwords3");
        logininfo.put("Username4", "passwords4");
        logininfo.put("123", "123");

    }

    // get the information from hash map
    // protected means this function is not private and not allow everyone to access
    protected HashMap getLogininfo() {
        return logininfo;
    }
}