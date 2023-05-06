package gr.aueb.softeng.team08;

public class Customer extends User {
    private final String cardNumber, cardHolderName, CVV; //tin=afm
    private double balance;
    public Customer(String username, String name, String surname, String telephone, String email, String password, int Id, String cardNumber, String cardHolderName, String CVV)
    {
        super(username, name, surname, telephone, email, password, Id);

        this.cardNumber=cardNumber;
        this.cardHolderName= cardHolderName;
        this.CVV= CVV;
        this.balance= 0;
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCVV() {
        return this.CVV;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public double getBalance(){
        return this.balance;
    }
    // Setters
    public void transaction(double money){// we dont need to check if the balance is neggative because when we call this method we are sure that the customer has enough money
        this.balance-=money;
    } //called by the controller
    public void topUp(int money){
        this.balance+=money;
    }

}
