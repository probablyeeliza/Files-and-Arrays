import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/**
 * The Files class has 2 intialized fields for the cipherDecipherString(String text) method.
 * Includes the main method
 * a method that displays a menu
 * a method that displays an exit message
 * a method that calls the menu method and allows the user to input their choice
 * a method that reads the file entered by a user and displays to the user
 * a method that writes texts inputted by the user to the file of their choosing
 * a method that copies the contents of one file picked by the user to another file picked by the user
 * a method that deciphers the code from the mystery.txt file and writes it to the the mysteryoutput.txt file
 * a method that can be used to decipher text
 * a method that reads the contents of the details.txt file and writes the average and names to the
 * namesandscores.txt file
 * 
 * @author Eliza
 * @version 12/11/2023
 */
public class Files
{
    /** 
     * initializes the crypt1 and crypt2 fields
     **/
    private static final String crypt1 = "cipherabdfgjk";
    private static final String crypt2 = "lmnoqstuvwxyz";
    /** 
     * main method
     * creates an instance of the files class and calls the runFilesTests method
     **/
    public static void main(String[] args)
    {
        Files f = new Files();
        f.runFileTests();
    }
    /** 
     * displays a list of choices to the user
     **/
    public void Menu()
    {
        System.out.println("Please select one of the options below");
        System.out.println("1 - Read from a file");
        System.out.println("2 - Write to a file");
        System.out.println("3 - Copy from one file to another");
        System.out.println("4 - Decipher the text from the mystery file and copy it to the mystery output file");
        System.out.println("5 - Process the name and scores and then find and display the average");
        System.out.println("0 - Exit");
    }
    /** 
     * displays an exit message to the user
     **/
    public void Exit()
    {
        System.out.println("Goodbye");
    }
    /** 
     * initializes the choice variable
     * uses a do while loop to call the menu method, allow the user to input a choice and uses if statements to
     * allows the code to pick the correct corresponding choice, displays a message if the user inputs an invalid
     * choice and does this all while the choice is not equal to 0
     **/
    public void runFileTests()
    {
    /** System.out.println("Running file tests"); **/
    int choice;
        do
        {
        Menu();
        Scanner s = new Scanner(System.in);
        choice = s.nextInt();
        if (choice == 1)
        {readFromFile();}
        if (choice == 2)
        {writeToFile();}
        if (choice == 3)
        {copyToFile();}
        if (choice == 4)
        {decipherFile();}
        if (choice == 5)
        {processDetails();}
        if (choice == 0)
        {Exit();}
        if ((choice < 0) || (choice > 3))
        {System.out.println("Please insert a valid option");}
    } while (choice !=0);
    }
    /** 
     * displays instructions to the user
     * uses a scanner to get the user input for the file name
     * initializes the nextLine, Filereader and BufferedReader variables
     * uses a try, catch, finally statement
     * creates an instance of the FileReader, BufferedReader
     * allows nextLine to equal the lines read from the BufferedReader
     * if an error occur it will display a message
     * if the bufferedReader is not equal to null then close the file
     * 
     * 
     **/
    public void readFromFile()
    {
        System.out.println("Please enter the file name with txt at the end");
        Scanner s = new Scanner(System.in);
        String filename = s.nextLine();
        
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String nextLine;
        try
        {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            nextLine = bufferedReader.readLine();
            while (nextLine != null)
            {
                System.out.println(nextLine);
                nextLine = bufferedReader.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("An error has occured...");
        }
        finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error closing file");
                }
            }
        }
    }
    /** 
     * initializes the outputStream and printWriter and set them equal to null
     * uses a try, catch, finally statement
     * uses a scanner to allow the user to input the file to write to and sets that equal to filename
     * creates an instance of FileOutputStream using the filename as a parameter, PrintWriter using the outputStream
     * initializes values and number variables, set number variable equal to 1
     * use a while loop with the condition of number equal to 1
     * displays a message of instructions to the user
     * sets values equal to the nextLine
     * uses printWriter to write the inputted values into the file that was inputted
     * use an if statement to change the value of the number variable when the values variable is empty
     * When an error occurs displays an error message
     * if the printWriter is not null then it will close the printWriter
     * 
     **/
    public void writeToFile()
    {
        FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        try
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter the name of the file to write to");
            String filename = s.nextLine();
            outputStream = new FileOutputStream(filename);
            printWriter = new PrintWriter(outputStream);
            String values;
            int number = 1;
            while (number == 1)
            {
                System.out.println("Please enter the values you wish to input");
                values = s.nextLine();
                printWriter.print(values + " ");
                if (values.isEmpty())
                {
                    number = 2;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occured while entering your values");
        }
        finally
        {
             if (printWriter != null)
            {
                printWriter.close();
            }
        }
    }
    /** 
     *  initializes the nextLine, Filereader, BufferedReader, outputStream, printWriter, nextLine, input and ouput varaibles
     *  display an instruction message to the user
     *  use a scanner to take in user input and assign them to the input and output variables
     *  use try, catch and finally statement
     *  create instances of FileReader using input as parameter and BufferedReader using fileReader as parameter
     *  use printWriter to write the inputted values into the file that was inputted
     *  use while loop with the condition of the nextLine not being equal to null
     *  display the nextLine to the user
     *  reinitialize the nextLine in the loop so that it will read the nextLine again
     *  use printWriter in the loop to write the nextLine values into the file that was inputted
     *  once the loop is over close the bufferedReader so that the read file is closed
     *  and once the printWriter is null close the printWriter to stop writing values
     *  
     **/
    public void copyToFile()
    {
        FileReader fileReader;
        BufferedReader bufferedReader;
        FileOutputStream outputStream;
        PrintWriter printWriter = null;
        String nextLine;
        String input;
        String output;
            System.out.println("Please enter an input file name");  
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
            System.out.println("Please enter an output file name");
        output = s.nextLine();
        try
        {
            fileReader = new FileReader(input);
            bufferedReader = new BufferedReader(fileReader);
            nextLine = bufferedReader.readLine();
            outputStream = new FileOutputStream(output);
            printWriter = new PrintWriter(outputStream);
            printWriter.println(nextLine);
            while (nextLine != null)
            {
                System.out.println(nextLine);
                nextLine = bufferedReader.readLine();
                printWriter.println(nextLine);    
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occured...");
        }
        finally
        {
            
            if (printWriter != null)
            {
                printWriter.close();               
            }
        }
    }
    /**
     * initialize the FileReader, BufferedReader, FileOutputStream, PrintWriter, nextLine and cipheredMethod variables
     * use try, catch and finally statement
     * create instances of the fileReader, bufferedReader, outputStream, printWriter, nextLine
     * use a while loop with the condition that the nextLine is not equal to null
     * in the loop put the nextLine values through the cipherDecipherString method and set that equal to cipheredMethod
     * then write that to the output file and read the next line of the input file
     * if the printWriter is not equal to null then close it 
     * 
     **/
    public void decipherFile()
    {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        String nextLine;
        String cipheredMethod;
        try
        {
            fileReader = new FileReader("mystery.txt");
            bufferedReader = new BufferedReader(fileReader);
            outputStream = new FileOutputStream("mysteryoutput.txt");
            printWriter = new PrintWriter(outputStream);
            nextLine = bufferedReader.readLine();
            while (nextLine != null)
            {
                cipheredMethod = cipherDecipherString(nextLine);
                System.out.println(cipheredMethod);
                printWriter.println(cipheredMethod + " ");
                nextLine = bufferedReader.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occured...");
        }
        finally
        {
            if (printWriter != null)
            {
                printWriter.close();               
            }
        }
    }
    /**
     * used to decipher the message in the mystery.txt file
     * 
     **/
    private static String cipherDecipherString(String text)
    {
    // declare variables we need
    int i, j;
    boolean found = false;
    String temp="" ; // empty String to hold converted text
    
    for (i = 0; i < text.length(); i++) // look at every character in text
    {
        found = false;
        if ((j = crypt1.indexOf(text.charAt(i))) > -1) // is char in crypt1?
        {           
            found = true; // yes!
            temp = temp + crypt2.charAt(j); // add the cipher character to temp
        } 
        else if ((j = crypt2.indexOf(text.charAt(i))) > -1) // and so on
        {
            found = true;
            temp = temp + crypt1.charAt(j);
        }

        if (! found) // to deal with cases where char is NOT in crypt2 or 2
        {
            temp = temp + text.charAt(i); // just copy across the character
        }
    }
    return temp;
    }
    /**
     * initialize the variables
     * set up an array
     * use try and catch statements
     * create instances of the variables using details.txt and namesandscores.txt for the fileReader and outputStream
     * initialize the averagescore as a float
     * use a while loop with the condition of the nextLine not being null
     * use the split method to split the values from the score array
     * then use the correct split values and turn them into int instead of String
     * display the name and scores to the user and read the nextLine of the input file
     * if the printWriter is not null then close it
     * 
     **/
    public void processDetails()
    {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        FileOutputStream outputStream;
        PrintWriter printWriter;
        String nextLine;
        String[] scores;
        try
        {
            fileReader = new FileReader("details.txt");
            bufferedReader = new BufferedReader(fileReader);
            outputStream = new FileOutputStream("namesandscores.txt");
            printWriter = new PrintWriter(outputStream);
            nextLine = bufferedReader.readLine();
            float averagescore;
            while (nextLine != null)
            {
                scores = nextLine.split(" ", 0);
                averagescore = (Integer.parseInt(scores[2]) + Integer.parseInt(scores[3]) + Integer.parseInt(scores[4])
                + Integer.parseInt(scores[5]) + Integer.parseInt(scores[6]));
                System.out.println(scores[1] + " " + scores[0] + ". The average score is" + " " + averagescore);
                printWriter.println(scores[1] + " " + scores[0] + ". The average score is" + " " + averagescore);
                nextLine = bufferedReader.readLine();
            }
             if (printWriter != null)
            {
                printWriter.close();               
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occured...");
        }
    }
}

    

