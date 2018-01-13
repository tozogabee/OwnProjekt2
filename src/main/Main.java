package main;

import pojos.InputHandler;
import pojos.Menu;
import pojos.MenuOptions;

public class Main {


    public static void main(String[] args){
        try(InputHandler userInputHandler = new InputHandler()){
            Menu menu = new Menu(userInputHandler);
            menu.display();
            MenuOptions menuOptions = menu.readUserSelection();
        }

    }

}
