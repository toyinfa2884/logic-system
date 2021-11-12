package africa.semicolon.logisticSystem.data.services;

import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.DuplicateUserException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderServiceImplTest {
    private SenderService senderService;


    @BeforeEach
    void setUp() {
        senderService = new SenderServiceImpl();
    }

    @AfterEach
    void tearDown() {
        senderService.deleteAllSenders();
    }

    @Test
    void registerSender() {
        RegisterSenderResponse response = registerSenderTestHelper();
//        assertEquals(response.getSenderEmail(), registerSenderRequest.getSenderEmail());
        assertEquals(1, senderService.getSenders().size());
    }
    public RegisterSenderResponse registerSenderTestHelper() {
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("jerry");
        registerSenderRequest.setSenderEmail(("jerry@email.com"));
        registerSenderRequest.setPhoneNumber("0927254885");
        return senderService.registerSender(registerSenderRequest);
    }
    @Test
    void duplicateEmail_throwsExceptionTest() {
        registerSenderTestHelper();
        assertThrows(DuplicateUserException.class, ()-> registerSenderTestHelper());
    }

}