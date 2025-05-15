## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


list of things to do 
- revert main gui to its last pitiful state
- make classes for each option, each extending Jframe
- implementation happens in each class. idk why i didn't think of that. sigh.



ok thinking time
- all options now run in their own respective classes.
- `mainGUI` holds the uni array list. cause u know, its the main place lol.
- when each button is called, an object of their respecive class is created. and the universal array list is sent within the constructor.

now the problem is with option 1, what's our plan of attack
- what im worried is how the universal arraylist is going to return.
  - maybe make another method for main to call after making the option1 object?
- i think plan of attack should be to get option 1 to work later maybe?
- ask for help.