package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrackingInformationRepositoryImplTest {
    TrackingInformationRepository trackingInformationRepository;
    @BeforeEach
    void setUp() {
        trackingInformationRepository = new TrackingInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(81137983);
        TrackingData trackingData = new TrackingData("Package ready for delivery");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation saveInfo = trackingInformationRepository.save(trackingInformation);

        assertEquals(saveInfo, trackingInformation);
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    private TrackingInformation saveTestHelper(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(81137983);
        TrackingData trackingData = new TrackingData("Package ready for delivery");
//        trackingData.setEvent("Package ready for delivery");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation saveInfo = trackingInformationRepository.save(trackingInformation);
        return saveInfo;
    }
    @Test
    void findAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    @Test
    void deleteAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void findByPackageId() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional<TrackingInformation> optionalTrackingInformation =
                trackingInformationRepository.findByPackageId(savedTrackingInformation.getPackageId());
        assertTrue(optionalTrackingInformation.isPresent());
        assertEquals(savedTrackingInformation, optionalTrackingInformation.get());
    }

    @Test
    void delete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation.getPackageId());
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void testDelete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation);
        assertEquals(0, trackingInformationRepository.findAll().size());
    }
}
