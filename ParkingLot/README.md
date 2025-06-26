# Parking Lot Low Level Design

This project is a Low Level Design (LLD) implementation of a Parking Lot Management System in Java. It demonstrates object-oriented design principles and models real-world parking lot operations, including user roles, parking spots, tickets, payments, and more.

## Features
- Multiple user roles: Admin, Parking Attendant
- Different types of parking spots: Compact, Large, Handicapped, Motorcycle
- Vehicle types: Car, Motorcycle, Truck, Van
- Ticketing and payment system (Cash/Card)
- Display boards for spot availability
- UML and use case diagrams for reference

## Folder Structure
```
com/lld/ParkingLot/
├── account/         # User accounts and roles
├── components/      # Core components (Entrance, Exit, DisplayBoard, etc.)
├── media/           # UML and use case diagrams
├── model/           # Supporting models (Address, Person, Status enums)
├── parkingSpot/     # Parking spot types
├── payment/         # Payment methods and status
├── vehicle/         # Vehicle types
```

## Diagrams
- UML Diagram: `media/uml.png`
- Use Case Diagram: `media/usecase.png`

## Getting Started
1. **Clone the repository**
2. **Build the project** (using Maven):
   ```sh
   mvn clean install
   ```
3. **Run the application** (entry point to be implemented as needed)

## Requirements
- Java 8 or higher
- Maven

## Notes
- This project is for educational purposes and demonstrates LLD concepts.
- Extend or modify as needed for specific requirements.



