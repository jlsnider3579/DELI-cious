# DELI-cious 
* Sandwich Shop is a Java application that allows users to create, customize, and order sandwiches, drinks, and chips. The application provides a user-friendly interface to create orders, manage them, and generate receipts.

## Table of Contents

* Project Structure
* Features
* How to Run the Application
* Classes Overview
* Future Enhancements
* Project Structure
* The project is divided into the following main components:

### 1. Order Management
* Order - Manages a list of Product items in each order.
* DataManager - Responsible for handling data-related tasks, such as creating receipts.
#### 2. Sandwich Customization
* BreadType - Enum representing types of bread, such as WHITE, WHEAT, RYE, and WRAP.
* SandwichSize - Enum representing sandwich sizes (SMALL, MEDIUM, LARGE).
* Sandwich - Represents a customizable sandwich with properties like size, bread type, meat, cheese, and toppings.
##### 3. Toppings
* Topping - Interface for different topping types, with subclasses for Regular and Premium toppings.
* RegularToppingType - Includes basic toppings like LETTUCE, TOMATOES, and ONIONS.
* PremiumToppingType - Includes meat and cheese categories.
* Meat - Premium toppings like STEAK, HAM, CHICKEN, and BACON.
* Cheese - Different cheese types, such as AMERICAN, PROVOLONE, and SWISS.
###### 4. Drinks and Chips
* Drink - Represents a drink item with types (e.g., Cola, Lemonade) and sizes (Small, Medium, Large).
* Chips - Represents a chips item with types like LAYS, DORITOS, and BBQ.

### 5. **User Interface**
* UserInterface - Main interface for user interactions, with options for adding sandwiches, drinks, chips, checking out, and viewing orders.
* SandwichView, DrinkView, ChipView - Specialized views for customizing each item type.
######## 6. Product Management
* Product - Abstract class for all items that can be part of an order, such as sandwiches, drinks, and chips.
######### Features
* Create and Customize Sandwiches - Select bread type, size, meat, cheese, and toppings.
* Add Drinks and Chips - Choose drink size and type, and add chips to your order.
* Order Management - View, update, and checkout your orders.
* Receipt Generation - View and print detailed receipts for each order.
* How to Run the Application
* Setup - Ensure you have Java installed and configured on your system.
* Compilation - Compile the Java files.

 
![Screenshot 2024-11-15 084441](https://github.com/user-attachments/assets/9d1c7b35-af4b-4336-9de2-7acf41f6da7f)


![image](https://github.com/user-attachments/assets/f43e0465-a8f3-4ae4-9ef6-f91af09560b7)

* It's not neseccarily the code, but the class itself I like how theres a way to use one method to work amongst other classes returning different values
