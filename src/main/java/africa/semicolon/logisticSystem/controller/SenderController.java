package africa.semicolon.logisticSystem.controller;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.services.SenderService;
import africa.semicolon.logisticSystem.data.services.SenderServiceImpl;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SenderController {
private final SenderService senderService = new SenderServiceImpl();

    @PostMapping("/api/v1/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest){
        return senderService.registerSender(registerSenderRequest);
    }
    @GetMapping("/api/v1/sender/{email}")
    public Optional<Sender> getSender(@PathVariable String email) {
        return senderService.findSenderByEmail(email);
    }
}
