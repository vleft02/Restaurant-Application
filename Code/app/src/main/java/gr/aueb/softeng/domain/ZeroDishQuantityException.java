package gr.aueb.softeng.domain;

public class ZeroDishQuantityException extends Exception{
    @Override
    public String toString(){
        return "OrderLine dish can't have zero quantity, it will get removed";
    }
}
