# Class Model Documentation

## Core Entities
| Class | Responsibility |
| :--- | :--- |
| **Rider** | Represents the customer. Holds location and personal details. |
| **Driver** | Represents the service provider. Tracks availability, location, vehicle type, and total rides. |
| **Ride** | Orchestrates the connection between a Rider and Driver. Stores distance, status, and calculated fare. |
| **FareReceipt** | A read-only record of a completed transaction. |

## Design Patterns Used
* **Builder Pattern:** Used in `Driver` and `Rider` to handle optional parameters and ensure object immutability where necessary.
* **Strategy Pattern:** Used for `RideMatchingStrategy` and `FareStrategy` to decouple algorithms from the `RideService`.
* **Repository Pattern:** `DriverRepository`, `RiderRepository`, and `RidesRepository` handle in-memory data storage (ArrayList).