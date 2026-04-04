# SOLID Principles Reflection

## 1. Single Responsibility Principle (SRP)
* **Evidence:** Each class has one job. `IdGenerator` only handles IDs, `InputValidator` only handles validation, and `RideRepository` only handles data storage.
* **Benefit:** Changes to the UI (Scanner) do not affect the business logic in the Service.

## 2. Open/Closed Principle (OCP)
* **Evidence:** The use of `FareStrategy` and `RideMatchingStrategy` interfaces.
* **Benefit:** We can add a "RatingBasedMatchingStrategy" by creating a new class without changing a single line of code in the `RideService`.

## 3. Liskov Substitution Principle (LSP)
* **Evidence:** Any implementation of `FareStrategy` (Default or Peak) can be passed into `RideService` without breaking the application. They all adhere to the `calculateFare(Ride)` contract.

## 4. Interface Segregation Principle (ISP)
* **Evidence:** We separated Matching logic and Fare logic into two distinct interfaces.
* **Benefit:** A matching algorithm is not forced to know anything about how money is calculated.

## 5. Dependency Inversion Principle (DIP)
* **Evidence:** `RideService` depends on the `FareStrategy` interface, not the concrete `DefaultFareStrategy` class.
* **Benefit:** The high-level service is decoupled from the low-level implementation details of the algorithms.