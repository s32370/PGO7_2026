public class PickupPointShipment extends ShipmentOrder{

private String lockerSize;
private boolean fragile;

//
public PickupPointShipment(String orderNumber, String customerName,
                           double distanceKm, double baseFee, boolean insured,
                           String lockerSize, boolean fragile) {
    super(orderNumber, customerName, distanceKm, baseFee, insured);
    this.lockerSize = lockerSize;
    this.fragile = fragile;
}
//
//lockerSize - one of "S", "M", "L", sting
//fragile - whether the package is fragile.
//Business rules:
//
//getShipmentType() should return "Pickup point".

@Override
public String getShipmentType() {
    return "Pickup point";
}

//calculateBasePrice() should return baseFee + distanceKm * 0.75.

@Override
public String getShipmentType() {
    return "Pickup point";
}

//calculateAdditionalFee() should add a size fee: 5 PLN for "S",
// 10 PLN for "M",
// and 18 PLN for "L".

@Override
protected double calculateAdditionalFee() {
    double fee = 0;

    switch (lockerSize) {
        case "S": fee += 5; break;
        case "M": fee += 10; break;
        case "L": fee += 18; break;
    }
//If fragile is true, add 12 PLN to the additional fee.

    if (fragile) {
        fee += 12;
    }

    return fee;
}


//Override validateSpecificRules(). If locker size is not "S", "M", or "L", throw IllegalArgumentException.
@Override
protected void validateSpecificRules() {
    if (!lockerSize.equals("S") &&
            !lockerSize.equals("M") &&
            !lockerSize.equals("L")) {
        throw new IllegalArgumentException("Invalid locker size");
    }
}

}