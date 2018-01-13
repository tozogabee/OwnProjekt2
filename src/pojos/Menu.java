package pojos;

public class Menu {

    private InputHandler inputHandler;

    public Menu(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void display(){
        System.out.println("*******************************************");
        System.out.println("*       KOMPNETT WEBSHOP                  *");
        System.out.println("*******************************************");
        System.out.println("Please select an option from the following");
        System.out.println("1. Add new customer");
        System.out.println("2. Update existing customer");
        System.out.println("3. Delete existing customer");
        System.out.println("4. List all customer");
        System.out.println("5. Exit program");

    }

    public MenuOptions readUserSelection(){
        int selection = this.inputHandler.readInt("Please select an opportunity: ");
        switch (selection){
            case 1:
                return MenuOptions.NEW;
            case 2:
                return MenuOptions.UPDATE;
            case 3:
                return MenuOptions.DELETE;
            case 4:
                return MenuOptions.LIST;
            case 5:
                return MenuOptions.EXIT;
            default:
                return MenuOptions.EXIT;
        }

    }

}
