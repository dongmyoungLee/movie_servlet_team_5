package dto;

public class UserDto {
    private int user_seq;
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_pwd;
    private String user_birthdate;
    private String user_phone_number;

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public UserDto() {

    }

    public void createUser (int user_seq, String user_id, String user_name, String user_email, String user_pwd, String user_birthdate, String user_phone_number) {
        this.user_seq = user_seq;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_pwd = user_pwd;
        this.user_birthdate = user_birthdate;
        this.user_phone_number = user_phone_number;

    }

    public int getUser_seq() {
        return user_seq;
    }

    public void setUser_seq(int user_seq) {
        this.user_seq = user_seq;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_birthdate() {
        return user_birthdate;
    }

    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String user_phone_number() {
        return user_phone_number;
    }

    public void user_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public UserDto(int user_seq, String user_id, String user_name, String user_email, String user_pwd, String user_birthdate, String user_phone_number) {
        this.user_seq = user_seq;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_pwd = user_pwd;
        this.user_birthdate = user_birthdate;
        this.user_phone_number = user_phone_number;
    }
}
