# 🛡️ RideWise: Modular Ride-Sharing System

**RideWise** is a professional-grade Low-Level Design (LLD) implementation of a ride-sharing platform. Built with Java, it demonstrates high-quality software architecture using the **SOLID** principles and common **Design Patterns**.

## 🚀 Features
* **Plug-and-Play Strategies:** Swap matching and pricing algorithms at runtime.
* **Vehicle Specifics:** Choose between BIKE, AUTO, or CAR with dynamic pricing.
* **Fairness Matching:** Includes a "Least Active Driver" strategy to balance driver workloads.
* **Robust Lifecycle:** Handles requests, assignments, completions, and history tracking.
* **Safe ID Generation:** Uses `AtomicInteger` for thread-safe, sequential IDs.

## 🏗️ Technical Stack
* **Language:** Java 17+
* **Patterns:** Strategy, Builder, Repository, Singleton-Utility.
* **Architecture:** Layered (Model-Repository-Service).

## 📂 Project Structure
* `model/`: Core POJOs with Builder patterns.
* `repository/`: In-memory data management.
* `strategy/`: Encapsulated algorithms for Matching and Fare.
* `service/`: Business logic orchestration.
* `util/`: Validators and ID generators.

## 🛠️ How to Run
1. Clone the repo.
2. Compile and run `Main.java`.
3. Use the CLI menu to register users, request rides, and view history.

## 📝 License
MIT License.
