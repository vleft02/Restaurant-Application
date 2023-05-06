package gr.aueb.softeng.team08;

public class ZeroDishQuantityException extends Exception{
    @Override
    public String toString(){
        return "OrderLine dish can't have zero quantity, it will get removed";
    }
}
