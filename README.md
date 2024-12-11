# Game of Bones

**Game of Bones** is a text-based adventure game built in Java. In this game, players make choices that impact the story and their progression. It’s a simple but engaging experience with a modular structure that can be expanded with additional features, levels, and characters.

## Features

- **Text-Based Adventure**: Navigate through the game world by making decisions that influence the story.
- **Interactive Gameplay**: Players are given choices at each step of the game, and these choices will lead to different outcomes.
- **Game Loop**: The main game loop continuously asks the player for input until the game reaches an end condition.
- **Story Progression**: The game is driven by a branching narrative where the player's actions determine the storyline's path.

## Requirements

- **Java 8** or higher.

## Installation and Setup

### 1. Clone the Repository

You can clone the repository to your local machine using the following command:


### 2. Compile the Java Files

Once you have the repository on your local machine, navigate to the `src` directory and compile the Java files.

### 3. Start Playing

Once the game starts, you'll be presented with different choices that affect how the story progresses. Continue making decisions and see where your choices take you.

## Code Structure

- **`src/Main.java`**: The entry point of the game, where the main game loop is located. It handles player input and coordinates the progression of the story.
- **`GameLogic.java`** (Assumed file): Handles the internal game logic, including managing the story, decision-making, and potentially the inventory and interactions.
- **Additional Files**: The repository may contain other files for managing the game state, characters, and specific game events.

## Gameplay

The game is a text-based experience that takes place in a world where the player must navigate through various events by choosing between different options. Each decision will lead to different outcomes, and depending on your choices, the game will progress in unique ways.

### Example Game Flow:

1. **Starting the Game**: You'll be prompted with the first choice, which sets the stage for the story.
2. **Making Decisions**: At each decision point, you can choose from multiple options that influence the next set of events.
3. **End of Game**: The game either reaches a conclusion or loops back depending on the story arc or conditions met by the player.

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).
