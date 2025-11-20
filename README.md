Vehicle Rental Management System
Java | Swing GUI | OOP | SOLID | File Handling
Project Overview

The Vehicle Rental Management System is a Java-based desktop application developed using Java Swing, Object-Oriented Programming, SOLID principles, and text-file-based persistent storage.

The system provides the following functionalities:

Add new vehicles (Car, Bike, ElectricBike, LuxuryCar)

Auto-generate unique vehicle IDs (CAR1, BIKE1, EBIKE1, LUX1, etc.)

Book a vehicle with payment options (Cash, Online)

Return or free a vehicle

View all vehicles

Maintain data in text files using file handling

Project Architecture

This project follows a 4-layer architecture:

GUI Layer       → Swing Interfaces (Add, View, Book, Return)
Service Layer   → Application Logic (VehicleService, BookingService)
Model Layer     → POJO Classes (Vehicle, Car, Bike, ElectricBike, LuxuryCar)
Data Layer      → File Handling (FileManager)

Directory Structure
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

Key Features
Vehicle Management

Add Car, Bike, ElectricBike, or LuxuryCar

Auto-generated vehicle IDs

Dynamic fields for special vehicle types:

ElectricBike: battery range

LuxuryCar: luxury tax

Booking System

Customer booking

Hours and amount calculation

Payment options using strategy pattern:

CashPayment

OnlinePayment

Saves booking details into bookings.txt

Updates vehicle availability

Return Vehicle

Mark a rented vehicle as available again

View Vehicles

Reads vehicle data from vehicles.txt

Safely skips invalid or empty lines

Persistent Storage

Text files store all application data:

vehicles.txt

bookings.txt

Object-Oriented Concepts Used
Encapsulation

All fields in model classes are private or protected, accessed through getters and setters.

Inheritance

Vehicle is an abstract parent class for:

Car

Bike

ElectricBike

LuxuryCar

Polymorphism

Method overriding:

getType()

toString()

LuxuryCar overrides getPricePerHour()

Abstraction

Two abstractions are used:

Abstract class Vehicle

Interface PaymentProcessor

SOLID Principles Used
Single Responsibility Principle (SRP)

Each class has one responsibility:

VehicleService manages vehicles

BookingService manages bookings

FileManager handles file I/O

GUI classes only handle user interaction

Open/Closed Principle (OCP)

New vehicle types or payment methods can be added without modifying existing core classes.

Liskov Substitution Principle (LSP)

Subtypes (Car, Bike, ElectricBike, LuxuryCar) can replace Vehicle without issues.

Interface Segregation Principle (ISP)

PaymentProcessor contains only one required method: pay().

Dependency Inversion Principle (DIP)

High-level classes (GUI) depend on the PaymentProcessor interface, not specific payment classes.

How to Run
Step 1: Compile
javac --release 8 -d bin src/main/*.java src/model/*.java src/service/*.java src/data/*.java gui/*.java

Step 2: Run
java -cp bin main.App

Sample Data
vehicles.txt
Car,CAR1,Toyota,Fortuner,800.0,true
Bike,BIKE1,Honda,Unicorn,100.0,true
ElectricBike,EBIKE1,Ather,450X,150.0,true,80
LuxuryCar,LUX1,BMW,7Series,3000.0,true,500

bookings.txt
B1001,CAR1,Amit Sharma,3,2400.0
B1002,BIKE1,Rohit Verma,2,200.0

Future Enhancements

User authentication system

Search and filter vehicles

Integration with a real database (MySQL)

Payment gateways (UPI, card)

PDF receipt generation

Admin dashboard
