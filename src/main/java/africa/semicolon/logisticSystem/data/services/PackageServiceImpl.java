package africa.semicolon.logisticSystem.data.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.responses.AddPackagerResponse;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.utils.ModelMapper;

public class PackageServiceImpl implements PackageService{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    @Override
    public AddPackagerResponse addPackage(AddPackageRequest addPackageRequest) {
        //convert addpackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);
        Package savedPackage = packageRepository.save(aPackage);
        AddPackagerResponse response = ModelMapper.map(savedPackage);

        return response;
    }
    public  Package findMyPackageWithMy(Integer id){
        return packageRepository.findById(id);
    }


}
