package africa.semicolon.logisticSystem.data.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.SenderRepository;
import africa.semicolon.logisticSystem.data.repositories.SenderRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.DuplicateUserException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServiceImpl implements SenderService{
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();

    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest) {
        Optional<Sender> senderInDatabase = senderRepository.findSenderByEmail(registerSenderRequest.getSenderEmail());
        if(senderInDatabase.isPresent()) throw new DuplicateUserException("Email " + registerSenderRequest.getSenderEmail() + " already exists");
//        convert to sender
        Sender sender = ModelMapper.map(registerSenderRequest);
//        save sender
        Sender returnSavedSender = senderRepository.save(sender);
//        convert sender to dto
//        return dto
        return ModelMapper.map(returnSavedSender);
    }

    @Override
    public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

    @Override
    public void deleteAllSenders() {
        senderRepository.deleteAll();
    }
    @Override
    public Optional<Sender> findSenderByEmail(String email) {
        return senderRepository.findSenderByEmail(email);
    }
}
