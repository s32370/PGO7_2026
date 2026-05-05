//reate class PickupPointShipment extending ShipmentOrder.
//
//Additional fields:
//
//lockerSize - one of "S", "M", "L",
//fragile - whether the package is fragile.
//Business rules:
//
//getShipmentType() should return "Pickup point".
//calculateBasePrice() should return baseFee + distanceKm * 0.75.
//calculateAdditionalFee() should add a size fee: 5 PLN for "S", 10 PLN for "M", and 18 PLN for "L".
//If fragile is true, add 12 PLN to the additional fee.
//Override validateSpecificRules(). If locker size is not "S", "M", or "L", throw IllegalArgumentException.