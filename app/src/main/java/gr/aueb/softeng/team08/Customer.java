package gr.aueb.softeng.team08;

public class Customer extends User {
    private String cardNumber, cardHolderName, CVV; //tin=afm , we dont declare them as final because they can be changed by the controller if he desides the input data is wrong
    private double balance;
    public Customer(String username, String name, String surname, String telephone, String email, String password, int Id, String cardNumber, String cardHolderName, String CVV)
    {
        super(username, name, surname, telephone, email, password, Id);

        this.cardNumber=cardNumber;
        this.cardHolderName= cardHolderName;
        this.CVV= CVV;
        this.balance= 0;
    }
    public void changeBankDetails(String cardNumber, String cardHolderName, String cvv){
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
    // Setters
    public void transaction(double money) throws IllegalStateException {// we dont need to check if the balance is neggative because when we call this method we are sure that the customer has enough money
        if (balance>=money) {
            this.balance -= money;
        }
        else
        {
            throw new IllegalStateException();
        }
    } //called by the controller
    public void topUp(int money){
        this.balance+=money;
    }

}
