import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileExample {

    public static void main(String[] args) {
        String filename = "my_text_file.txt";
        List<String> texts = new ArrayList<>();

        // Create the text file and write some texts to it
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println("This is the first line of text.");
            writer.println("This is the second line of text.");
            writer.println("This is the third line of text.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the texts from the file and save them to the list
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                texts.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Change the texts to uppercase
        for (int i = 0; i < texts.size(); i++) {
            texts.set(i, texts.get(i).toUpperCase());
        }

        // Write the uppercase texts to a new file using Buffer and Flux
        String outputFilename = "uppercase_texts.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename));
             PrintWriter writer = new PrintWriter(bw)) {
            for (String text : texts) {
                writer.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}