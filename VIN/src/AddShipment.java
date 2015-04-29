
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Iterator;

public class AddShipment extends AddShipmentRequest {

    public AddShipment(String mstype, String ymonth) {
            super(mstype,ymonth);
    }

    @Override
    public ObjectResponse addShipment(Data_Store ds) {
        if(Validator.missingValue(this.mst))
            return new ObjectResponse(1018, false, "Type must be provided");
        if(!Validator.isValidMSType(this.mst))
            return new ObjectResponse(1019, false,"Type can be either RW, AW, AR.");
        if(Validator.missingValue(this.ym))
            return new ObjectResponse(1020, false,"Selection month and year must be provided");
        if(!Validator.isValidYearMonth(this.ym))
            return new ObjectResponse(1021, false,"Selection month and year must be yyyy-mm format");
        YearMonth ymonth = YearMonth.parse(ym);
                
        Iterator<Subscriber> sub_itr = ds.subs.iterator();
        int shipmentCounter = 0;
        while(sub_itr.hasNext()){
            Subscriber sub =sub_itr.next();
            if(!ymonth.equals(sub.getDeliveryYearMonth()))
                continue;
            if(!sub.getPreference().name().equalsIgnoreCase(this.mst))
                continue;
            Iterator<Shipment> ship_itr = ds.shipments.iterator();
            boolean shipmentPresent = false;
            while(ship_itr.hasNext()){
                Shipment s = ship_itr.next();
                if(s.isMatch(sub.getID(), sub.getDeliveryDt())){
                    shipmentPresent = true;
                    break;
                }
            }
            if(shipmentPresent)
                continue;
            else{
                Shipment temp = new Shipment(sub.getID(),sub.getDeliveryDt(),sub.getPreference());
                ds.shipments.add(temp);
                shipmentCounter++;
            }                
        }
        return new ObjectResponse(shipmentCounter, true, "Shipments Added.");
    }        
}
