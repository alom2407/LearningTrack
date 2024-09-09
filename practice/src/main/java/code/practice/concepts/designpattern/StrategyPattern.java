package code.practice.concepts.designpattern;

//Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently from the clients that use it.

interface PaymentStrategy{
    void pay(int ammount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(int ammount) {
        System.out.println("Paid "+ammount +" via credit card");
    }
}

class Cashpayment implements PaymentStrategy{

    @Override
    public void pay(int ammount) {
        System.out.println("Paid "+ammount+ " via Cash");
    }
}

class ShoppingCart{
    private PaymentStrategy paymentStrategy;

    public  void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int ammount){
        if(paymentStrategy == null)
            throw new IllegalStateException("Invalid payment strategy");

        paymentStrategy.pay(ammount);
    }
}
public class StrategyPattern {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new Cashpayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(1000);
    }

}
