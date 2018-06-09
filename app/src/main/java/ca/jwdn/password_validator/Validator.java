package ca.jwdn.password_validator;

public class Validator {
    public Validator(){}

    public int validate(String pw){
        int testsPassed = 0;

        /**
         * Rules:
         * (1 & 2 provided in assignment spec)
         * 1 - is not 'password'
         * 2 - at least 8 characters long
         * 3 - contains at least 1 capital and 1 lowercase letter
         * 4 - contains at least 1 number
         * 5 - contains at least 1 non-alphanumeric character
         */

        // Test 1: Password is not 'password'
        if (!pw.toLowerCase().equals("password")){
            testsPassed++;
        }

        // Test 2: Password is at least 8 characters long
        if (pw.length() >= 8){
            testsPassed++;
        }
        
        
        return testsPassed;
    }

}
