package africa.semicolon.logisticSystem.data.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.responses.AddPackagerResponse;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;

public interface PackageService {
    AddPackagerResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWithMy(Integer id);
}
