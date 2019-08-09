package etc;

import java.util.Random;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}

class RealBillingService implements BillingService {
    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        CreditCardProcessor processor = CreditCardProcessorFactory.getInstance();
        ChargeResult result = processor.charge(order, creditCard);
        return result.successful() ? Receipt.successfulCharge() : Receipt.failCharge();
    }
}

// dependency injection
class RealBillingService2 implements BillingService {
    private CreditCardProcessor processor;

    RealBillingService2(CreditCardProcessor processor) {
        this.processor = processor;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        ChargeResult result = processor.charge(order, creditCard);
        return result.successful() ? Receipt.successfulCharge() : Receipt.failCharge();
    }
}

class CreditCardProcessorFactory {
    private CreditCardProcessorFactory() {
    }

    private static CreditCardProcessor instance;

    static CreditCardProcessor getInstance() {
        if (instance == null) {
            return new CreditCardProcessor();
        } else {
            return instance;
        }
    }
}

class Receipt {
    static Receipt successfulCharge() {
        return new Receipt();
    }

    static Receipt failCharge() {
        return new Receipt();
    }

    @Override
    public String toString() {
        return "receipt";
    }
}

class PizzaOrder {
}

class CreditCard {
}

class ChargeResult {
    private int random = new Random().nextInt(10);

    boolean successful() {
        return random > 5;
    }

    @Override
    public String toString() {
        return "ChargeResult";
    }
}

class CreditCardProcessor {
    ChargeResult charge(PizzaOrder order, CreditCard creditCard) {
        return new ChargeResult();
    }
}