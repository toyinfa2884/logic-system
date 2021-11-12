package africa.semicolon.logisticSystem.controller;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.data.services.TrackingService;
import africa.semicolon.logisticSystem.data.services.TrackingServiceImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PostMapping("/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);}

    @GetMapping("/api/trackingInfo/{id}")
    public TrackingInformation getTrackingInfo (@PathVariable("id") Integer trackingId) {
        return trackingService.trackPackage(trackingId);
    }

}
