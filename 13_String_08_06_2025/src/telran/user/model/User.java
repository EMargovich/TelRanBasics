package telran.user.model;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(validateEmail(email)) {
            this.email = email;
        }
    }

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
            if( !((ch >= 45 && ch <= 57 && ch!=47) ||
                    (ch >= 64 && ch <= 90) ||
                    (ch >= 95 && ch <= 122 && ch != 96))) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(validatePassword2(password)) {
            this.password = password;
        } else {
            System.out.println("Password not valid!");
        }
    }
    /*
    1. minimum 8 symbols
    2. minimum one digits
    3. minimum one special symbol (!%@)
    4. Lower case
    5. Upper case
     */


    private boolean validatePassword2 (String password) {
        boolean[] res = new boolean[5];
        int len = password.length();
        if(len >= 8) {
            res[0] = true;
        }

        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                res[1] = true;
            }
            if(isSpecSymbols(c)) {
                res[2] = true;
            }
            if(Character.isUpperCase(c)){
                res[3] = true;
            }
            if(Character.isLowerCase(c)){
                res[4] = true;
            }

            if(res[0] && res[1] && res[2] && res[3] && res[4]) {
                return true;
            }
        }



        return false;
    }

    private boolean isSpecSymbols(char c) {
        return "!%@*&".indexOf(c) >= 0;
    }

    private boolean validatePassword(String password) {
        //1. minimum 8 symbols
        if (password.length() < 8) {
            return false;
        }

        //2. minimum one digits
        boolean flag = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                flag = true;
            }
        }
        if (!flag) return false;

        //3. minimum one special symbol (!%@)
        flag = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch == '@' || ch == '!' || ch == '%') {
                flag = true;
            }
        }

        if (!flag) return false;

        //4. Lower case
        flag = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                flag = true;
            }
        }
        if (!flag) return false;

        //5. Upper case
        flag = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                flag = true;
            }
        }

        if (!flag) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
