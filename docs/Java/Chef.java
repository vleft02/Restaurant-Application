public class Chef extends User {
    private String iban, tin; //tin=afm

    public Chef(String username, String name, String surname, String telephone, String email, String password, int Id, String iban, String tin)
    {
        super(String username, String name, String surname, String telephone, String email, String password, int Id);
        this.iban=iban;
        this.tin=tin;
    }

    // Getters
    public String getIban() {
        return iban;
    }

    public String getTin() {
        return tin;
    }

    // Setters
    public void setIban(String Iban) {
        this.iban = Iban;
    }

    public void setTin(String Tin) {
        this.tin = Tin;
    }


}

