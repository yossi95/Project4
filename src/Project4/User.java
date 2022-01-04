package Project4;

public class User {
    private String username;
    private String password;
    private String phoneNum;
    private boolean isMeditor;

    public User (String userName, String password, String phoneNum, boolean isMeditor){
        this.username= userName;
        this.password= password;
        this.phoneNum= phoneNum;
        this.isMeditor = isMeditor;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isMeditor() {
        return isMeditor;
    }

    public void setMeditor(boolean isMeditor) {
        this.isMeditor = isMeditor;
    }
}
