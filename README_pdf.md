# individual-project-shakshi

**CMPE 202**  
**Student ID:** 016043105  
**Name:** Shakshi Richhariya

## Primary Problem:

The main challenge we're addressing involves accurately determining different types of cards (VisaCC, MasterCC, AmExCC, etc.) using the provided data. Our goal is to correctly identify legitimate card types when the inputted credit card number is valid. Conversely, if the number is invalid, we aim to display a suitable error message.

## Proposed Approach:

To tackle our issue, we propose using the factory design pattern. This approach is a solid strategy for creating objects, centralizing this function while hiding its complexities from users. By implementing a factory, we simplify our coding, improve maintainability, and increase scalability. Importantly, this method supports easy addition of new object types or changes in the creation process, reducing the reliance on specific implementations in client code.


### Benefits of the Factory Pattern

- **Hides the details of object creation from the user.**
- **Provides an abstraction layer between implementation and client classes through inheritance.**
- **Generates specific objects based on input.**

### Advantages of the Factory Method

- **Reduces the number of application-specific classes.**
- **Facilitates easier class extension or modification.**

## Secondary Problem

The challenge lies in creating a specific credit card class upon the verification of a credit card number.

### Approach

The Factory design pattern offers a structured method to generate objects of the desired card type:

- **Detection:** Identifies a distinct feature, like the initial digits of the credit card number, to classify the card type.
- **Creation:** Develops a method in the Factory class that takes this feature as input and uses conditional statements to match the feature with the appropriate card type.
- **Construction:** Generates a specific credit card class object based on each condition.
- **Implementation:** Allows the client code to interact only with the Factory method, enhancing modularity and maintainability.

## Consequences

- **Simplicity:** The Factory pattern simplifies the process of generating credit card objects from CSV files, improving the readability and maintainability of the client code.
- **Flexibility:** It is resilient to changes, allowing easy addition of new card types without altering the client code.
- **Validation:** Ensures the creation of only valid credit card objects, enhancing data accuracy and reducing errors.
- **Consistency:** Guarantees uniform creation of credit card objects, simplifying debugging and maintenance.
- **Decoupling:** Reduces the client code's dependency on specific credit card classes, leading to a more modular and testable codebase.

---

**GitHub Link:** [Individual Project - Shakshi Richhariya](https://github.com/gopinathsjsu/individual-project-shakshi)
