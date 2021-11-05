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
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }
    @Test
    void updatePackageTest() {
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

    @Test
    void findAll() {
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());
        Package savedPacked = packageRepository.save(aPackage);
        assertEquals(1 , packageRepository.findAll().size());

    }

    @Test
    void delete() {
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());
        Package savedPacked = packageRepository.save(aPackage);
        assertEquals(1 , packageRepository.findAll().size());
        //when
        packageRepository.delete(savedPacked);
        assertEquals(0, packageRepository.findAll().size());

    }

    @Test
    void deleteById() {
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());
        Package savedPacked = packageRepository.save(aPackage);
        assertEquals(1 , packageRepository.findAll().size());
        //when
        packageRepository.deleteById(1);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void findPackageById() {
        Package aPackage = new Package();
        aPackage.setDeliveryAddress("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("09078564523");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way");
        aPackage.setNetWeight(23.5);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());
        Package savedPacked = packageRepository.save(aPackage);

        //when

        assertEquals(savedPacked, packageRepository.findById(1));
    }
}