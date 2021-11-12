package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderRepositoryImplTest {
    SenderRepository senderRepository; // WE NEED A REPOSITORY TO TEST WITH

    @BeforeEach
    void setUp() {
        senderRepository = new SenderRepositoryImpl();
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@email.com");
        sender.setPhoneNumber("09874284");

        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());

    }
    public Sender saveSender(){
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@email.com");
        sender.setPhoneNumber("09874284");

        return senderRepository.save(sender);
    }

    @Test
    void findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(saveSender().getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender.getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDelete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
        assertTrue(senderRepository.findAll().isEmpty());
    }
}