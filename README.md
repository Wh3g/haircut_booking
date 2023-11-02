# Booking application API

This is an API for a booking application. It can be used by a front end application to store data in a database and retrieve data as needed, in this application, the users are a Hairdressing business and their customers.

## User Stories

```Text
As a User,
So I can get a haircut,
I want to make a booking.

As a User, 
So I can see my hairdresser regularly, 
I want to create an account.

As a Hairdresser,
So I can plan my time,
I want to see all my bookings in a calendar.

As a User,
So I can get the haircut I want,
I want to select a service.
```

## Tech stack

This project is being built using the following technologies:

- Java
- Spring Boot
- Maven
- JUnit
- MySQL

## Installation and Use

To install this application, simply clone this repository and open the directory in the IDE of your choice (I've used VS Code personally, but Eclipse will work as well).

Before running the application, it is important you have a running local MySQL server, if you don't you will get an error message similar to this one:

```Text
com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
```

To use a MySQL database on your machine, you will need a local server environment such as MAMP, though there are alternatives. Then set the MySQL port to `3306` and start the server. Finally you can run the Spring Boot application, in VS Code, you can do this by right-clicking the file `haircut-booking/src/main/java/com/wh/haircutbooking/HaircutBookingApplication.java` and selecting the option `Run Java`, whichever IDE you use, it is important you run the programme from this file because this is the file with the `main` method.