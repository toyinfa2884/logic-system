package africa.semicolon.logisticSystem.utils;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.responses.AddPackagerResponse;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setSenderPhone(addPackageRequest.getSenderPhone());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setSenderName(addPackageRequest.getSenderName());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());

        return aPackage;
    }
    public  static AddPackagerResponse map(Package savedPackage){
       AddPackagerResponse response = new AddPackagerResponse();

        //convert saved package to addpackage response
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setPackageName(savedPackage.getName());
        response.setTrackingNumber(savedPackage.getId());
        response.setReceiverAddress(savedPackage.getDeliveryAddress());

        //return converted response
        return response;

    }
}
