package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;

import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);

    List<Package> findById();

    void delete(Package aPackage);

    void delete(Integer id);

    Package findById(Integer id);
}
