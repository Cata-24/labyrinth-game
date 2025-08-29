# LDTS_T13_G08 - BoyGirl Game

## Game Description

This game is puzzle platform game where two players have to work together to complete the levels, by stepping into some buttons that opens doors and allows the other to continue, while escaping the monsters.
The players have the possibility to increment their lives by collecting hearts and are able to go to the next level after catching the stars.
The variety of levels will have some increased difficulty.

This project was developed by Catarina Bastos (up202307631@up.pt). Nuno Costa (up202305503@up.pt) and Vasco Gonçalves (up202305513@up.pt).

## Implemented Features

- **Keyboard control** - The keyboard inputs are received and interpreted according to the current state of the game.
- **Player Control** - Players can move left, right, up and down using keyboard controls (w,a,s,d for player1 and Arrows for player2).
- **Collisions detection** - The collisions between the players and the obstacles/monsters are detected.
- **Multiplayer Mode**: Enable cooperative or competitive gameplay for two players.
- **Different Levels** - x different levels with soe increasing difficulty.
- **Enemies** - NPCs like monsters that are moving randomly throughout the game and arrows that follow a straight path.
- **Buttons** - When players go to these buttons it opens doors that allows the other player to continue.
- **Checkpoints** - Allows the player, in case of their death, to go back yo a certain point in the game without having to restart it.
- **Lives** - There´s a system that keeps track os the players' lives and some hearts spread through the game that gives the player that catches it another life.
- **Risky Floor** - There are some parts of this floor that are safe and others that can kill the players.

## Design Patterns

### General Structure
#### Problem:
The first problem we encountered while doing our project was the disposition of its structure. 
However, since our game is divided by different gameStates and has a GUI we decided to implement two patterns to solve this issue: **_Architectural Pattern_**, **_State Pattern_**.

#### Patterns:
Two main patterns were applied to the project, the **_Architectural Pattern_**, more specifically the Model-View-Controller style which is commonly used in a GUI and the **_State Pattern_** which is a behavioral design pattern that lets an object alter its behavior when its internal state changes.

#### Implementation:
We created classes which we use to store data (model), to control the logic of the game (controllers) and that are responsible for the visual effects on the screen (viewers).
As for the different states, they are divided with the same methodology as the mvc style, and allows the game to alter its behavior in a simple and efficient way.

#### Consequences:
The use of these patterns in the current design allow the following benefits:
- Makes state transitions explicit.
- MVC is ideal for applications with clear separation between UI and business logic, promoting scalability and testability.
- Easy to add new features throughout the development stage.

### Observers/Listener Pattern
#### Problem:
Our game is controlled by the keyboard, and there are several ways to handle input. 
For example, there's polling, a thread that constantly checks for input signals and sends them to the game. 
This method can be inefficient because the game might keep asking for input even when there’s none, leading to unnecessary processing. 
There is another way to do this, that is our approach, the **_Observer/Listener Pattern_**.

#### Pattern:
Instead of polling, we implemented the **_Observer/Listener Pattern_**, that uses observers or listeners that detect input and distribute it efficiently. 
This reduces the program’s workload since it no longer has to repeatedly check for input.

#### Implementation:
We store the observers in the main class (game class) and change its state according to the respective input processed by the available listener.
In addiction, it is also used for updating the UI when the player's state changes, keeping track of the player's lives and triggering a game over screen when the players die.

#### Consequences:
Some consequences of using the stated pattern are:
- Promotes a well organized code that follows the Single Responsibility Principle.
- The game logic is separated from the input handling, making the code easier to manage.
- You can easily add more observers or listeners without changing the existing code.
- Has an efficient input handling, which makes the game only react to events when they happen, avoiding unnecessary checks.

### Composite Pattern
#### Problem:
In our game, we need to draw multiple elements, like game objects, which can be composed of smaller parts. Managing and drawing each element individually can lead to repetitive, complex, and unstructured code. To deal with this problem we resorted to the **_Composite Pattern_**.

#### Pattern:
The Composite Pattern is a structural design pattern that allows you to treat individual objects and compositions of objects uniformly. 
It is used to represent part-whole hierarchies, enabling you to build complex structures by composing objects into tree-like arrangements. 
This pattern makes it easy to work with both simple and complex objects using the same interface, simplifying operations like rendering, updating, or managing a group of related objects.

#### Implementation:
In our game, we use this pattern primarily to draw game objects like the boy, girl, walls, stars, etc. Each object, whether simple (ex: a single boy) or complex (ex: a list of walls), is treated as a component with a unified interface. 
By organizing these objects into a tree-like structure, we can render all game elements consistently and efficiently. 
This allows us to manage and update groups of objects, like a cluster of walls or multiple stars, with the same ease as individual objects.

#### Consequences:
Here are some consequences of using this pattern:
- Simplifies code by allowing individual objects and groups of objects to be treated the same way, using a common interface.
- Makes it easy to add new types of components without modifying existing code, adhering to the Open/Closed Principle.
- Clean code.
- Simplifies the drawing logic.

### Singleton Pattern
#### Problem:
While developing our game, we encountered several issues related to managing shared resources, maintaining consistent game states, and ensuring efficient communication between controllers and views.
Multiple instances of key components, such as GameController, MenuController, and LanternaGui, were causing conflicts and inconsistencies in state management and resource allocation. 
Additionally, accessing these components globally across different parts of the code became increasingly difficult. 
To address these problems, we implemented the **_Singleton pattern_**.

#### Pattern:
We implemented the **_Singleton pattern_** to ensure that a class has only one instance while providing a global point of access to it. 
It also provides a global point of access to that instance. 
It restricts direct instantiation by making the class's constructor private and provides a static method to retrieve the single instance.

#### Implementation:
This pattern was implemented in key components like GameController, MenuController, and LanternaGui by restricting their constructors to prevent direct instantiation. 
Each class provides a static method that returns the single instance, ensuring that only one object of each exists throughout the game.

#### Consequences:
The use of this patterns comes with some consequences such as:
- Simplified access to shared resources without needing to pass references around.
- Avoidance of redundant memory allocation for multiple instances of a class.
- There's a single point of control for managing specific functionality or resources.
- Only one instance of a class exists, preventing conflicts from multiple instances.

## UML Diagram
This UML diagram illustrates the structure of our game, showing how different states, controllers, viewers, and elements interact to create a cohesive system.

<p align="center" justify="center">
  <img src="Images/UML/ClassDiagram.png"/>
</p>
<p align="center">
  <b><i>Fig 1. UML Diagram</i></b>
</p>

## Code Structure
In addiction, we also built a diagram that shows how the code is organized. 
It breaks down the controllers, models, GUI helpers, states, and viewers, and how they all work together in our game.

<p align="center" justify="center">
  <img src="Images/UML/CodeStructure.png"/>
</p>
<p align="center">
  <b><i>Fig 2. Code Structure</i></b>
</p>

## Known-code smells
There isn't any code smell identified, as we have fixed all errors.

---

## Testing

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="Images/screenshots/TestCoverage.png"/>
</p>
<p align="center">
  <b><i>Fig 3. Code coverage screenshot</i></b>
</p>

### Link to testing report
[Tests](../docs/tests/test/index.html)

---

## Self-Evalution
The work was divided in an equal way, and we all contributed with our best. 

- Catarina Bastos: 33.3%
- Nuno Costa: 33.3%
- Vasco Gonçalves: 33.3%
