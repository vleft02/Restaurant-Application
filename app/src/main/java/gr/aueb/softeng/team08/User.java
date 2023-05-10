package gr.aueb.softeng.team08;

public abstract class User
{
    private final int userId;
    private String username,telephone, email, password,name, surname;
    
    public User(String username, String name, String surname, String telephone, String email, String password, int Id){
        this.username=username;
        this.name = name;
        this.surname= surname;
        this.telephone=telephone;
        this.email=email;
        this.password=password;
        this.userId = Id;
    }

    //Getters
    public int getUserId(){
        return this.userId;
    }
    public String getUsername() {
        return this.username;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getTelephone() {
        return this.telephone;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

    public void changePersonalDetails(String username, String name, String surname, String telephone, String email){
        this.username=username;
        this.name = name;
        this.surname= surname;
        this.telephone=telephone;
        this.email=email;
    }
    public void changePassword(String pass){ // this method is called by the controller when the user inputs weak password and needs to change it , the controllers checks if the password is weak , not this class
        this.password=pass;
    }

}