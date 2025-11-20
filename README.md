# Vehicle Rental Management System  
Java · Swing GUI · OOP · SOLID · File Handling

---

## 1. Project Overview

The **Vehicle Rental Management System** is a desktop application developed in Java using:

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
- Store all data in text files (`vehicles.txt`, `bookings.txt`)

---

## 2. Project Architecture

The project follows a **4-layer architecture**:

GUI Layer → Java Swing Interfaces (Add, View, Book, Return)
Service Layer → Business Logic (VehicleService, BookingService)
Model Layer → POJO Classes (Vehicle hierarchy)
Data Layer → File Handling (FileManager)

yaml
Copy code

---

## 3. Directory Structure

src/
│
├── main/
│ └── App.java
│
├── model/
│ ├── Vehicle.java
│ ├── Car.java
│ ├── Bike.java
│ ├── ElectricBike.java
│ ├── LuxuryCar.java
│ └── Booking.java
│
├── service/
│ ├── VehicleService.java
│ ├── BookingService.java
│ ├── PaymentProcessor.java
│ ├── CashPayment.java
│ └── OnlinePayment.java
│
├── data/
│ └── FileManager.java
│
└── gui/
├── MainMenuGUI.java
├── AddVehicleGUI.java
├── ViewVehiclesGUI.java
├── BookingGUI.java
└── ReturnVehicleGUI.java

database/
│ vehicles.txt
│ bookings.txt


---

## 4. Key Features

### 4.1 Vehicle Management
- Add Car, Bike, ElectricBike, or LuxuryCar  
- Auto-generated vehicle IDs  
- Dynamic fields:  
  - **ElectricBike:** battery range  
  - **LuxuryCar:** luxury tax  

### 4.2 Booking System
- Customer booking  
- Hours and billing calculation  
- Payment Strategy Pattern:  
  - `CashPayment`  
  - `OnlinePayment`  
- Saves bookings to `bookings.txt`  
- Updates vehicle availability  

### 4.3 Return Vehicle
- Mark any booked vehicle as available again  

### 4.4 View Vehicles
- Loads all vehicles from `vehicles.txt`  
- Skips invalid or empty lines safely  

### 4.5 Persistent Storage
Files used:
vehicles.txt
bookings.txt

yaml
Copy code

---

## 5. Object-Oriented Concepts Used

### 5.1 Encapsulation
All fields in the model classes are **private/protected**, accessed via getters and setters.

### 5.2 Inheritance
`Vehicle` is an **abstract base class**, extended by:

- Car  
- Bike  
- ElectricBike  
- LuxuryCar  

### 5.3 Polymorphism
- `getType()` overridden  
- `toString()` overridden  
- `LuxuryCar` overrides `getPricePerHour()`  

### 5.4 Abstraction
- `Vehicle` is an abstract class  
- `PaymentProcessor` is an interface  

---

## 6. SOLID Principles Used

### 6.1 Single Responsibility Principle (SRP)
- `VehicleService` → vehicle management  
- `BookingService` → booking logic  
- `FileManager` → file I/O  
- GUI classes → only user interface  

### 6.2 Open/Closed Principle (OCP)
Can add new vehicle types or payment methods without modifying core logic.

### 6.3 Liskov Substitution Principle (LSP)
Every subclass can replace `Vehicle` without breaking behavior.

### 6.4 Interface Segregation Principle (ISP)
`PaymentProcessor` interface contains only one required method `pay()`.

### 6.5 Dependency Inversion Principle (DIP)
BookingGUI depends on the `PaymentProcessor` interface—not concrete classes.

---

## 7. How to Run

### Step 1 — Compile the project
```sh
javac --release 8 -d bin src/main/*.java src/model/*.java src/service/*.java src/data/*.java gui/*.java
Step 2 — Run the application
sh
Copy code
java -cp bin main.App
8. Sample Data
8.1 vehicles.txt
objectivec
Copy code
Car,CAR1,Toyota,Fortuner,800.0,true
Bike,BIKE1,Honda,Unicorn,100.0,true
ElectricBike,EBIKE1,Ather,450X,150.0,true,80
LuxuryCar,LUX1,BMW,7Series,3000.0,true,500
8.2 bookings.txt
objectivec
Copy code
B1001,CAR1,Amit Sharma,3,2400.0
B1002,BIKE1,Rohit Verma,2,200.0
9. Future Enhancements
Admin authentication

Search and filter vehicles

Migrate storage to MySQL database

Add more payment options (UPI, card)

Generate PDF receipts

Create admin dashboard and analytics

10. License
This project is created for academic use and learning purposes.

