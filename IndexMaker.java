import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    if (args.length > 0)
    {
      fileName = args[0];
    }
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);

    if (args.length > 1)
    {
      fileName = args[1];
    }
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

    // index is an arraylist of objects of IndexEntry class
    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;

    // Start timing
    long startTime = System.currentTimeMillis();

    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // End timing
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime; // Calculate duration

    // Print timing results
    System.out.println("Indexing completed in " + duration + " milliseconds.");
    System.out.println("Total unique words indexed: " + index.size());

    for (IndexEntry entry : index)
      outputFile.println(entry);

    inputFile.close();
    outputFile.close();
    keyboard.close();

    System.out.println("Done.");
  }
}
