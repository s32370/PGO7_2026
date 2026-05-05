public class InternationalShipment extends ShipmentOrder(){


//Create class InternationalShipment extending ShipmentOrder.
//
//Additional fields:
//
//private String destinationCountry; - destination country,
//private boolean customsDocumentsRequired; - whether customs documents are required,
//private booexpressDelivery - whether express delivery is selected.
//Business rules:
//
//getShipmentType() should return "International".
//calculateBasePrice() should return baseFee + distanceKm * 2.10.
//calculateAdditionalFee() should add 45 PLN if customs documents are required.
//If expressDelivery is true, add 80 PLN to the additional fee.
//Override validateSpecificRules(). If destination country is empty, throw IllegalArgumentException.
//Override applyBusinessDiscount(double price). If delivery is not express and distance is greater than 1000 km, reduce the price by 3%.
        }