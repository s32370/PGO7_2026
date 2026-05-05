public class DomesticCourierShipment extends ShipmentOrder{

            private double packageWeightKg;
            private boolean weekendDelivery;
}
//
//Additional fields:
//
//packageWeightKg - package weight in kilograms,
//weekendDelivery - whether the package is delivered during the weekend.

public DomesticCourierShipment(String orderNumber, String customerName, double distanceKm, double baseFee, boolean insured, double packageWeightKg, boolean weekendDelivery){
    super(orderNumber, customerName, distanceKm, baseFee, insured);
    this.packageWeightKg=PackageWeightKg;
    this.weekendDelivery=weekendDelivery;


//getShipmentType() should return "Domestic courier".

    @Override
    public String getShipmentType() {
        return "Domestic courier";
    }

//calculateBasePrice() should return baseFee + distanceKm * 1.20.

    @Override
    protected double calculateBasePrice() {
        return getBaseFee() + getDistanceKm() * 1.20;
    }

//calculateAdditionalFee() should add packageWeightKg * 4.00.
//If weekendDelivery is true, add 25 PLN to the additional fee.

    @Override
    protected double calculateAdditionalFee() {
        double fee = packageWeightKg * 4.00;
        if (weekendDelivery) {
            fee += 25;
        }
        return fee;
    }
//Override applyBusinessDiscount(double price). If distance is at least 300 km, reduce the price by 5%.

    @Override
    protected double applyBusinessDiscount(double price) {
        if (getDistanceKm() >= 300) {
            price *= 0.95;
        }
        return price;
    }

}

void main() {
}

//Business rules:
//
//Task 2: Pickup Point Shipment