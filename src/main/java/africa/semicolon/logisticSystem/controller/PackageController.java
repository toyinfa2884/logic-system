package africa.semicolon.logisticSystem.controller;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.services.PackageService;
import africa.semicolon.logisticSystem.data.services.PackageServiceImpl;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.exceptions.SenderDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
private PackageService packageService = new PackageServiceImpl();
    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest) {
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (SenderDoesNotExistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id) {
        return packageService.findMyPackageWithMy(id);
    }

}
