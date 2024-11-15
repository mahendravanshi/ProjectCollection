package com.fordTest1.VehicleAPI.repository;
import com.fordTest1.VehicleAPI.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Test
    public void testFindAvailableVehicles() {
        // Arrange
        Vehicle vehicle1 = new Vehicle(UUID.randomUUID(), "Car", true);
        Vehicle vehicle2 = new Vehicle(UUID.randomUUID(), "Bike", true);
        Vehicle vehicle3 = new Vehicle(UUID.randomUUID(), "Truck", false);

        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);

        // Act
        List<Vehicle> availableVehicles = vehicleRepository.findAllByIsAvailable(true);

        // Assert
        assertEquals(2, availableVehicles.size());
        assertEquals("Car", availableVehicles.get(0).getBrandName());
        assertEquals("Bike", availableVehicles.get(1).getBrandName());
    }


    @Test
    public void testFindUnavailableVehicles() {
        // Arrange
        Vehicle vehicle1 = new Vehicle(UUID.randomUUID(), "Car", true);
        Vehicle vehicle2 = new Vehicle(UUID.randomUUID(), "Bike", true);
        Vehicle vehicle3 = new Vehicle(UUID.randomUUID(), "Truck", false);

        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);

        // Act
        List<Vehicle> unavailableVehicles = vehicleRepository.findAllByIsAvailable(false);

        // Assert
        assertEquals(1, unavailableVehicles.size());
        assertEquals("Truck", unavailableVehicles.get(0).getBrandName());
    }


    @Test
    public void testFindVehiclesByBrand() {
        // Arrange
        Vehicle vehicle1 = new Vehicle(UUID.randomUUID(), "Ford", true);
        Vehicle vehicle2 = new Vehicle(UUID.randomUUID(), "Ford", false);
        Vehicle vehicle3 = new Vehicle(UUID.randomUUID(), "Toyota", true);

        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);

        // Act
        List<Vehicle> fordVehicles = vehicleRepository.findAllByBrandName("Ford");


        // Assert
        assertEquals(2, fordVehicles.size());
        assertEquals("Ford", fordVehicles.get(0).getBrandName());
        assertEquals("Ford", fordVehicles.get(1).getBrandName());
    }

    @Test
    public void testSaveVehicle() {
        // Arrange
        Vehicle vehicle = new Vehicle(UUID.randomUUID(), "Tesla", true);

        // Act
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        // Assert
        assertEquals("Tesla", savedVehicle.getBrandName());
        assertEquals(true, savedVehicle.getIsAvailable());
    }



    @Test
    public void testDeleteVehicleById() {
        // Arrange
        Vehicle vehicle1 = new Vehicle(UUID.randomUUID(), "Honda", true);
        Vehicle savedVehicle = vehicleRepository.save(vehicle1);

        // Act
        vehicleRepository.deleteById(savedVehicle.getId());

        // Assert
        boolean exists = vehicleRepository.findById(savedVehicle.getId()).isPresent();
        assertFalse(exists);
    }


    @Test
    public void testFindByIsAvailableInEmptyDatabase() {
        // Act
        List<Vehicle> availableVehicles = vehicleRepository.findAllByIsAvailable(true);

        // Assert
        assertEquals(0, availableVehicles.size());
    }

    @Test
    public void testFindVehiclesByNonExistingBrand() {
        // Act
        List<Vehicle> nonExistingBrandVehicles = vehicleRepository.findAllByBrandName("NonExistentBrand");

        // Assert
        assertEquals(0, nonExistingBrandVehicles.size());
    }


}
