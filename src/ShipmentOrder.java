public abstract class ShipmentOrder implements  SummaryPrintable{

    //2. Abstract Class

    private String orderNumber; // - unique shipment order number,
    private String customerName; // - customer name,
    private doubel distanceKm; // - delivery distance in kilometers,
    private double baseFee; // - base shipment fee,
    private boolean insured; // - information whether the shipment is insured,
    private double lastCalculatedPrice; // - last price calculated during processing.

    //Prepare a constructor and getters needed by subclasses. The class should also contain the template method:

    public ShipmentOrder(String orderNumber, String customerName, double distanceKm,
                         double baseFee, boolean insured){
        this.orderNumber=orderNumber;
        this.customerName=customerName;
        this.distanceKm=distanceKm;
        this.baseFee=baseFee;
        this.insured=insured;
    }

    protected String getOrderNumber(){
        return orderNumber;
    }
    protected String getCustomerName(){
        return customerName;
    }
    protected double getDistanceKm(){
        return distanceKm;
    }
    protected double getBaseFee(){
        return baseFee;
    }
    protected boolean isInsured(){
        return insured;
    }

    public final void processOrder() {
        validateOrder();
        validateSpecificRules();

        double price = calculateBasePrice();
        price += calculateAdditionalFee();
        price = applyInsurance(price);
        price = applyBusinessDiscount(price);

        lastCalculatedPrice = price;
        printProcessingResult();
    }
//Template Method requirement. The method  must be implemented only in ShipmentOrder. Subclasses should not override it.
//
//The abstract class should contain these common methods:


    processOrder()

//private void validateOrder() - checks common fields, for example empty order number or non-positive distance,
//protected void validateSpecificRules() - a hook method with an empty default implementation,
//private double applyInsurance(double price) - if insured is true, adds 7% to the current price,
//protected double applyBusinessDiscount(double price) - a hook method that by default returns the same price,
//private void printProcessingResult() - prints information after processing,
//public String buildSummaryLine() - returns a readable line with order number, customer, type and last calculated price.
//The abstract class should contain these abstract methods:
//
//protected abstract double calculateBasePrice(),
//protected abstract double calculateAdditionalFee(),
//public abstract String getShipmentType().

}
