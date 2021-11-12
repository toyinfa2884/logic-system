package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;

    @BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveNewPackageTest() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, savedPackage.getId());
    }
    @Test
    void updatePackageTest() {
        Package savedPackage = saveNewPackage();
        savedPackage.setName("Snipper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

    @Test
    void findAll() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findById().size());
    }

    @Test
    void delete() {

        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findById().size());

        packageRepository.delete(savedPackage);
        assertEquals(0, packageRepository.findById().size());
    }

    public Package saveNewPackage(){
        Package aPackage = new Package();
        aPackage.setName("Sleeping mat");
        aPackage.setSenderEmail("Jerry@email.com");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09876444");
        aPackage.setNetWeight(23.5);
        aPackage.setDeliveryAddress("312 Herbert Macauley Way, Sabo Yaba Lagos");

        return packageRepository.save(aPackage);
    }
    @Test
    void deleteById() {
        Package aPackage = saveNewPackage();
        assertEquals(1, packageRepository.findById().size());

        packageRepository.delete(1);
        assertEquals(0, packageRepository.findById().size());
    }

    @Test
    void findPackageById() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findById().size());

//        packageRepository.delete(savedPackage);
//        assertEquals(savedPackage, packageRepository.findById(1));
    }

}