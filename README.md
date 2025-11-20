Vehicle Rental Management System
Java · Swing GUI · OOP · SOLID · File Handling

1. Project Overview

The Vehicle Rental Management System is a desktop application developed in Java using:

- Java Swing GUI
- Object-Oriented Programming
- SOLID Principles
- Text File Handling

The application allows an admin to:
- Add new vehicles (Car, Bike, ElectricBike, LuxuryCar)
- Auto-generate unique IDs (CAR1, BIKE1, EBIKE1, LUX1, etc.)
- Book vehicles with payment options (Cash, Online)
- Return/free a booked vehicle
- View all vehicles
- Store all data in text files (vehicles.txt, bookings.txt)

2. Project Architecture

This project follows a 4-layer architecture:

GUI Layer       → Java Swing Interfaces (Add, View, Book, Return)
Service Layer   → Business Logic (VehicleService, BookingService)
Model Layer     → POJO Classes (Vehicle hierarchy)
Data Layer      → File Handling (FileManager)

3. Directory Structure

src/
│
├── main/
│   └── App.java
│
├── model/
│   ├── Vehicle.java
│   ├── Car.java
│   ├── Bike.java
│   ├── ElectricBike.java
│   ├── LuxuryCar.java
│   └── Booking.java
│
├── service/
│   ├── VehicleService.java
│   ├── BookingService.java
│   ├── PaymentProcessor.java
│   ├── CashPayment.java
│   └── OnlinePayment.java
│
├── data/
│   └── FileManager.java
│
└── gui/
    ├── MainMenuGUI.java
    ├── AddVehicleGUI.java
    ├── ViewVehiclesGUI.java
    ├── BookingGUI.java
    └── ReturnVehicleGUI.java

database/
│   vehicles.txt
│   bookings.txt

4. Key Features

Vehicle Management
- Add Car, Bike, ElectricBike, or LuxuryCar
- Auto-generated vehicle IDs
- Dynamic fields:
  - ElectricBike: battery range
  - LuxuryCar: luxury tax

Booking System
- Customer booking
- Hours & billing calculation
- Payment Strategy Pattern:
  - CashPayment
  - OnlinePayment
- Saves bookings to bookings.txt
- Updates vehicle availability

Return Vehicle
- Mark rented vehicle as available again

View Vehicles
- Loads data from vehicles.txt
- Skips invalid or empty lines safely

5. Object-Oriented Concepts Used

Encapsulation
- Private/protected fields with getters/setters

Inheritance
- Vehicle → Car, Bike, ElectricBike, LuxuryCar

Polymorphism
- Overridden methods: getType(), toString()
- LuxuryCar overrides getPricePerHour()

Abstraction
- Abstract class Vehicle
- Interface PaymentProcessor

6. SOLID Principles Used

SRP
- Separate classes for vehicle logic, booking logic, file I/O, and GUI

OCP
- New vehicle types or payment methods can be added without modifying core logic

LSP
- All subclasses substitute Vehicle safely

ISP
- PaymentProcessor has one method: pay()

DIP
- GUI depends on PaymentProcessor abstraction, not concrete classes

7. How to Run

Compile:
javac --release 8 -d bin src/main/*.java src/model/*.java src/service/*.java src/data/*.java gui/*.java

Run:
java -cp bin main.App

8. Sample Data

vehicles.txt
Car,CAR1,Toyota,Fortuner,800.0,true
Bike,BIKE1,Honda,Unicorn,100.0,true
ElectricBike,EBIKE1,Ather,450X,150.0,true,80
LuxuryCar,LUX1,BMW,7Series,3000.0,true,500

bookings.txt
B1001,CAR1,Amit Sharma,3,2400.0
B1002,BIKE1,Rohit Verma,2,200.0

9. Future Enhancements

- Admin authentication
- Search & filter vehicles
- Database integration
- Additional payment methods
- PDF receipt generation
- Dashboard analytics

