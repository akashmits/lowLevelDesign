package machinecodinground;

import lombok.Data;

@Data
public class Address {
    String city;
    long pincode;
    String mark; //near popular location
    String address;
}
