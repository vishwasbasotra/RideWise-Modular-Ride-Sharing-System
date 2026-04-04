# Project Requirements: RideWise

## 1. Functional Requirements
* **User Management:** * Register and manage Riders with unique IDs.
    * Register and manage Drivers with unique IDs, locations, and vehicle types.
* **Vehicle Types:** Support multiple vehicle categories: `BIKE`, `AUTO`, and `CAR`.
* **Ride Matching:** * Match riders with available drivers based on specific strategies.
    * `NearestDriverStrategy`: Match based on the exact location string.
    * `LeastActiveDriverStrategy`: Match with the driver who has the lowest completion count.
* **Fare Calculation:** * `DefaultFareStrategy`: Base rate per km multiplied by vehicle type.
    * `PeakHourFareStrategy`: Default fare with an additional 1.5x surge.
* **Ride Lifecycle:** * Request a ride (Assignment).
    * Complete a ride (Updating status and driver availability).
    * View ride history and generate fare receipts.

## 2. Non-Functional Requirements
* **Thread Safety:** Use atomic counters for ID generation to prevent duplicates.
* **Scalability:** The system must allow adding new matching or fare algorithms without modifying existing service logic.
* **Encapsulation:** Protect object states using private fields and controlled access (Builders/Setters).