package africa.semicolon.logisticSystem.controller;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.services.PackageService;
import africa.semicolon.logisticSystem.data.services.PackageServiceImpl;
import africa.semicolon.logisticSystem.dtos.responses.AddPackagerResponse;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private PackageService packageService = new PackageServiceImpl();
@PostMapping("/api/addpackage")
    public AddPackagerResponse addPackage( @RequestBody AddPackageRequest addPackageRequest){
        return  packageService.addPackage(addPackageRequest);
    }
    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id){
        return packageService.findMyPackageWithMy(id);
    }
}
