package africa.semicolon.logisticSystem.dtos.requests;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String senderEmail;
    private  String receiverName;
    private String deliveryAddress;
    private double packageWeight;
    private String packageDescription;
    private String receiverPhone;
}
