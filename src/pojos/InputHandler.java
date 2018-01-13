package pojos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler implements AutoCloseable {

    private static final Scanner inputReader = new Scanner(System.in);

    public String readString(String msg){
        System.out.print(msg);
        String str = inputReader.next();
        return str;
    }

    public int readInt(String msg){
        int number = 0;
        boolean isValid = false;
        do{
            System.out.print(msg);
            try{
                number = inputReader.nextInt();
                isValid = true;
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println(e.getMessage());
                inputReader.next();
            }
        }while (!isValid);
        return number;
    }

    public int readInt(){
        return readInt("Please give me the number - ","Please give me again the correct number - ");
    }

    public int readInt(String askMessage,String askAgain){
        return readInt(askMessage,askAgain,IntRange.UNLIMITED);
    }

    public int readInt(String askMessage,String askAgain,IntRange range){
        int number = 0;
        boolean isValid = false;
        System.out.print(askMessage);
        do{
            try{
                number = inputReader.nextInt();
                validateInputRange(number,range);
                isValid = true;
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println(askAgain);
                inputReader.next();
            }
        }while (!isValid);
        return number;

    }

    private void validateInputRange(int number, IntRange range) {
        if(!range.isWithInRange(number)){
            throw new IllegalArgumentException("Input is out of Range");
        }
    }


    public long readLong(String msg){
        long number = 0;
        boolean isValid = false;
        do{
            System.out.print(msg);
            try{
                number = inputReader.nextLong();
                isValid = true;
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println(e.getMessage());
                inputReader.next();
            }
        }while (!isValid);
        return number;
    }


    public double readDouble(String msg,int rage){
        double number = 0;
        boolean isValid = false;
        do{
            System.out.print(msg);
            try{
                number = inputReader.nextDouble();
                isValid = true;
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println(e.getStackTrace());
                inputReader.next();
            }
        }while (!isValid);
        return number;
    }

    @Override
    public void close(){
        try{
            inputReader.close();
        }
        catch (IllegalStateException e){
            System.err.println(e.getStackTrace());
        }
    }



}
