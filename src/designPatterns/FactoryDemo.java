package designPatterns;

interface Bank{
    void getBankName();
}

interface Loan{
    void getLoanName();
}

class Axis implements  Bank{

    @Override
    public void getBankName() {
        System.out.println("Axis Bank");
    }
}

class Icici implements  Bank{

    @Override
    public void getBankName() {
        System.out.println("Icici Bank");
    }
}

class HomeLoan implements Loan{

    @Override
    public void getLoanName() {
        System.out.println("Home Loan");
    }
}


class CarLoan implements Loan{

    @Override
    public void getLoanName() {
        System.out.println("Car Loan");
    }
}

class BankFactory implements Factory{
    Bank getBank(String bankName){
        if(bankName.equalsIgnoreCase("Axis"))
            return new Axis();
        else
            return new Icici();
    }
}

interface Factory {

}

class LoanFactory implements Factory{
    Loan getLoan(String loanName){
        if(loanName.equalsIgnoreCase("Home"))
            return new HomeLoan();
        else
            return new CarLoan();
    }
}

interface AbstractFactoryinterface{

}

class AbstractFactory{
    Factory getFactory(String factory){
        if(factory.equalsIgnoreCase("Bank"))
            return new BankFactory();
        else
            return new LoanFactory();
    }
}

public class FactoryDemo{
    public static void main(String[] args) {
        Factory factory = new AbstractFactory().getFactory("Bank");
        BankFactory bankFactory = (BankFactory) factory;
    }
}