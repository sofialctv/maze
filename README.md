# Maze
_Practical Assignment I of the Advanced Programming Techniques course [2024/2], taught by Prof. Mateus Costa._

**Authors**
- Manoel Rodrigues Loreiro - [@ManoelRL](https://github.com/ManoelRL)
- Sofia de Alcantara - [@sofialctv](https://github.com/sofialctv)

# Objective
The objective of this assignment is to implement a program in **Java** that
solve mazes represented by matrices of `0` and `1`. In the context of this
maze, the numbers `0` represent walls, while the numbers `1` represent paths. Each maze has a single entrance and a single
exit, ensuring that there is always a path that connects these two points.
**However, the maze may contain dead ends.**

📂 More information about the activity proposal can be read in the file [especificacao.pdf](/especificacao.pdf) [PT-BR].

# Requirements
**Java Development Kit (JDK)**: Make sure the JDK is installed on your system. You can download the latest version of the JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

# Project Structure
The project contains the following files:
- `maze.java`: Main file containing the code to solve the maze.
- `example.csv` (optional): Example file with the representation of the maze (matrix of 0s and 1s).

# Compiling the program
1. Open a terminal/command line.
2. Navigate to the directory where the source code is located.
3. Compile the Java file using the following command:
> javac labyrinth.java

# Running the program
After compiling the program, run it with the command:
> java maze

Depending on how the program was developed, it may read a file with the maze matrix or allow direct input via the terminal. **Make sure to follow the input instructions specified in the code.**

# Output Example
The program will display the path from the entry point to the exit, or an error message if there is no viable path.