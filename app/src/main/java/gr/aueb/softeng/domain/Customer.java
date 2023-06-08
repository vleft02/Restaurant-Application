package gr.aueb.softeng.domain;

public class Customer extends User {
    private String cardNumber, cardHolderName, CVV;
    private double balance; // the balance can only be changed by the topUp method
    public Customer(String username, String name, String surname, String telephone, String email, String password, int Id, String cardNumber, String cardHolderName, String CVV)
    {
        super(username, name, surname, telephone, email, password, Id); // calling the father constructor(User)

        this.cardNumber=cardNumber;
        this.cardHolderName= cardHolderName;
        this.CVV= CVV;
        this.balance= 0;
    }
    public void changeBankDetails(String cardNumber, String cardHolderName, String cvv){ //used by the controller if the user has inputted wrong Bank Details and wants to change them
        this.cardNumber=cardNumber;
        this.cardHolderName=cardHolderName;
        this.CVV=cvv;
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

    public void resetBalance()
    {
        balance = 0;
    }
    public void transaction(double money)  { // called by the controller when the order is completed and needs to bhe paid
        if (balance>=money) {
            this.balance -= money;
        }
    }
    public void topUp(double money) {// The only method the customer can use to increase his balance
        if(money>0){this.balance+=money;}
    }
}
