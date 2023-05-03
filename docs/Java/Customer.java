public class Customer extends User {
    private String cardNumber, cardHolderName, CVV; //tin=afm
    private double balance;
    public Customer(String username, String name, String surname, String telephone, String email, String password, int Id, String cardNumber, String cardHolderName, String CVV, double balance)
    {
        super(username, name, surname, telephone, email, password, Id);

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
        return this.cardHolderName;
    }

    public double getBalance(){
        return this.balance;
    }
    // Setters
//    public void setCardNumber(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//    public void setCVV(String cvv){
//        this.CVV=cvv;
//   }
//    public void setCardHolderName(String cardHolderName){
//        this.cardHolderName=cardHolderName;
//    }
//    public void setBalance(double bal){
//        this.balance=bal;
 //   }

}
