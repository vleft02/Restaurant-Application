public class Customer extends User {
    private String cardNumber, cardHolderName, CVV; //tin=afm
    private double balance;

    public Owner(String username, String name, String surname, String telephone, String email, String password, int Id, String cardNumber, String cardHolderName, String CVV, double balance)
    {
        super(String username, String name, String surname, String telephone, String email, String password, int Id);
        this.cardNumber=cardNumber;
        this.cardHolderName= cardHolderName;
        this.CVV= CVV;
        this.balance= balance;
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCVV() {
        return this.CVV;
    }

    public String getCardHolderName() {
        return this.CardHolderName;
    }

    public double getBalance(){
        return this.balance;
    }
    // Setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setTin(String Tin) {
        this.tin = Tin;
    }
}
