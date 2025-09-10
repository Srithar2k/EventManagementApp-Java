🎫 Event Management App

  This is a console-based Java application for managing event logistics, including ticket sales, RSVPs, and check-ins. Designed with a strong focus on Object-Oriented Programming (OOP), this project serves as a practical demonstration of core OOP concepts in a real-world context.


📖 Table of Contents

    Key Features
      OOP Principles Applied
      How to Run the Application
      Project Structure


🚀 Key Features

    Event Creation: Define and manage events with key details like name, date, venue, and capacity.
    
    Ticketing System: A robust system to generate and track tickets, supporting different types (Regular and VIP).
    
    Attendee & RSVP Management: Register attendees and link them to sold tickets, capturing essential contact information.
    
    Gate Check-in: A controlled process to validate and check in attendees, preventing duplicate entries and ensuring data integrity.
    
    Reporting: Generate comprehensive attendee lists and calculate total revenue for each event.


💡 OOP Principles Applied
  
  This application's architecture is built around several foundational OOP principles:
  
      Inheritance: The VIPTicket and RegularTicket classes extend the abstract Ticket class, inheriting common attributes while implementing unique behaviors.
      
      Polymorphism: The system manages all tickets through a common Ticket interface. When calculating revenue, the correct getPrice() method is called for each ticket type (Regular or VIP) at runtime, showcasing dynamic polymorphism.
      
      Encapsulation: The check-in process is a prime example of encapsulation. It strictly controls the transition of a ticket's state from Sold to Used, protecting the system from invalid operations.
      
      Method Overloading: The EventService class provides multiple rsvp() methods, allowing for flexible attendee registration based on different input parameters.
      
      Method Overriding: The getPrice() and printBadge() methods are overridden in subclasses to provide specific pricing and badge information for each ticket type.


🛠️ How to Run the Application

  Prerequisites
      Java Development Kit (JDK) 8 or higher installed on your machine.
  Instructions
        
  Clone the Repository:

  Bash
  
          git clone https://github.com/your-username/EventManagementApp-Java.git
          cd EventManagementApp-Java
              
  Compile the Code:

  Bash
  
          javac *.java
          Execute the Application:

  Bash
  
          java EventAppMain
          
The console will display the step-by-step execution of the event management workflow, from creating events to generating final reports.


📂 Project Structure

  Event.java: Defines the Event class.
    
  Attendee.java: Defines the Attendee class.
    
  Ticket.java: Abstract base class for tickets.
    
  EventService.java: Contains the core business logic for event management.
    
  EventAppMain.java: The main class to run the application and test all functionalities.
