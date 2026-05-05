public abstract class ShipmentOrder {

    //2. Abstract Class
    //Create exactly one abstract class named ShipmentOrder. This class should implement SummaryPrintable.
    //
    //The class should store common data:
    //
    //orderNumber - unique shipment order number,
    //customerName - customer name,
    //distanceKm - delivery distance in kilometers,
    //baseFee - base shipment fee,
    //insured - information whether the shipment is insured,
    //lastCalculatedPrice - last price calculated during processing.
    //Prepare a constructor and getters needed by subclasses. The class should also contain the template method:

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
//Template Method requirement. The method processOrder() must be implemented only in ShipmentOrder. Subclasses should not override it.
//
//The abstract class should contain these common methods:
//
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
