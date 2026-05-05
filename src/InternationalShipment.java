public class InternationalShipment extends ShipmentOrder(){


private String destinationCountry; //- destination country,
private boolean customsDocumentsRequired; //- whether customs documents are required,
private boolean expressDelivery; // - whether express delivery is selected.

public InternationalShipment(String orderNumber, String customerName,
                             double distanceKm, double baseFee, boolean insured,
                             String destinationCountry,
                             boolean customsDocumentsRequired,
                             boolean expressDelivery) {
    super(orderNumber, customerName, distanceKm, baseFee, insured);
    this.destinationCountry = destinationCountry;
    this.customsDocumentsRequired = customsDocumentsRequired;
    this.expressDelivery = expressDelivery;
}

//Business rules:
//
//getShipmentType() should return "International".

@Override
public String getShipmentType() {
    return "International";
}

//calculateBasePrice() should return baseFee + distanceKm * 2.10.

@Override
protected double calculateBasePrice() {
    return getBaseFee() + getDistanceKm() * 2.10;
}


//calculateAdditionalFee() should add 45 PLN if customs documents are required.
//If expressDelivery is true, add 80 PLN to the additional fee.

@Override
protected double calculateAdditionalFee() {
    double fee = 0;

    if (customsDocumentsRequired) {
        fee += 45;
    }
    if (expressDelivery) {
        fee += 80;
    }

    return fee;
}

//Override validateSpecificRules(). If destination country is empty, throw IllegalArgumentException.


@Override
protected void validateSpecificRules() {
    if (destinationCountry == null || destinationCountry.isEmpty()) {
        throw new IllegalArgumentException("Destination country cannot be empty");
    }
}


//Override applyBusinessDiscount(double price). If delivery is not express and distance is greater than 1000 km, reduce the price by 3%.

@Override
protected double applyBusinessDiscount(double price) {
    if (!expressDelivery && getDistanceKm() > 1000) {
        price *= 0.97;
    }
    return price;
}

}