package TestData;

import java.util.HashMap;
import java.util.Map;

public class BuggyCarAppData {
    public static Map<String,String>BuggyAppData() {
        return new HashMap<String,String>() {{

            put("Expected Page title","Buggy Cars Rating");
            put("Login", "Loginname");
            put("First name","Paul");
            put("Last name", "Max");
            put("Password", "Password@123");
            put("Confirm password", "Password@123");

            put("Loginname","LoginUserName");
            put("Login Password","Reset@123");

            put("gender","Male");
            put("age","30");
            put("address","11 High street");
        }};
    }
}
