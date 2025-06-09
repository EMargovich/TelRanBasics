package telran.user.model;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        //TO DO Set email
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(validateEmail(email)) {
            this.email = email;
        }
    }
    //
    /* TODO:
    +1. @ exist and only one
    2. dot after @
    3. after last dot min 2 symbol
    4. alphabetic, digits, _ , - , ., @

     */
    private boolean validateEmail(String email) {
        //1. @ exist and only one
        int indexAt = email.indexOf("@");
        int indexLastAt = email.lastIndexOf("@");
        if (indexAt == -1 || indexLastAt != indexAt) {
            return false;
        }

        //2. dot after @
        String strAfterAt = email.substring(indexAt);
        int indexDotAfterAt = strAfterAt.indexOf('.');
        if(indexDotAfterAt == -1) {
            return false;
        }

        //3. after last dot min 2 symbol
        int indexLastDot = email.lastIndexOf('.');
        if( indexLastDot + 3 > email.length()) {
            return false;
        }

        //4. alphabetic, digits, _ , - , ., @
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if( !(ch == 45 ||
                    ch == 46 ||
                    (ch >= 48 && ch <= 57) ||
                    (ch >= 64 && ch <= 90) ||
                    ch == 95 ||
                    (ch >= 97 && ch <= 122))) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
