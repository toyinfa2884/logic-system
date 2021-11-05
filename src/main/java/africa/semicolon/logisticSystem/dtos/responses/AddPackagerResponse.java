package africa.semicolon.logisticSystem.dtos.responses;

import lombok.Data;

@Data
public class AddPackagerResponse {
    private Integer trackingNumber;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private double packageWeight;
    private String receiverAddress;
}
