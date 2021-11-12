package africa.semicolon.logisticSystem.data.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exceptions.SenderDoesNotExistException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.Optional;

public class PackageServiceImpl implements PackageService{
//    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
//    private  final SenderService senderService = new SenderServiceImpl();
//    @Override
//    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
//        Sender senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
//        if(senderOptional == null) throw new SenderDoesNotExistException("Sender not registered");
//        //convert addpackage request to a package
//        Package aPackage = ModelMapper.map(addPackageRequest);
//        Package savedPackage = packageRepository.save(aPackage);
//        AddPackageResponse response = ModelMapper.map(savedPackage);
//
//        return response;
//    }
//    public  Package findMyPackageWithMy(Integer id){
//
//        return packageRepository.findById(id);
//    }
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();
    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        //    convert addpackage request to a package
        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
        if(senderOptional == null) throw new SenderDoesNotExistException("Sender not register");
        Package aPackage = ModelMapper.map(addPackageRequest);

//        save package
        Package savedPackage = packageRepository.save(aPackage);

//        convert saved package to addpackage response
//        AddPackageResponse response = ModelMapper.map(savedPackage);
//        return response;
//        or
        return ModelMapper.map(savedPackage);
    }

    @Override
    public Package findMyPackageWithMy(Integer id){
        return packageRepository.findById(id);
    }

}
