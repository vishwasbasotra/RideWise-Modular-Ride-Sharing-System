# Object Relationships

## 1. Association
* **Ride** has a "Has-A" relationship with **Rider** and **Driver**. It acts as the link between the two during an active session.

## 2. Dependency Injection
* **RideService** depends on **DriverRepository**, **RiderRepository**, and **RidesRepository**. These are injected via the constructor to ensure the service has access to the data layer.
* **RideService.requestRide()** depends on **RideMatchingStrategy** and **FareStrategy** interfaces. This allows the behavior of the method to change at runtime based on the passed implementation.

## 3. Composition
* **Driver** contains a **VehicleType** enum, which defines its multiplier and classification.
* **Ride** contains a **RideStatus** enum to track its lifecycle.