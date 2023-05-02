public abstract class User 
{
    private int userId;
    private String username, name, surname, telephone, email, password;
    
    public User(String username, String name, String surname, String telephone, String email, String password, int Id){
        this.username=username;
        this.name = name;
        this.surname= surname;
        this.telephone=telephone;
        this.email=email;
        this.password=password;
        this.userId = Id; //////////////////////////
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
    
    //Setters

    public void setName(String Name) {
        this.name = Name;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }
    
    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public void setTelephone(String Telephone) {
        this.telephone = Telephone;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }
}