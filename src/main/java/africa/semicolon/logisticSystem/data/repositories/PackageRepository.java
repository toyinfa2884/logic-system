package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;

import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);
    List<Package> findAll();
    void delete(Package id);
    void deleteById(Integer id);
    Package findById(Integer id);
}
