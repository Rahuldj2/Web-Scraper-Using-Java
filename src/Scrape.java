package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class Scrape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a URL input
        System.out.print("Enter a URL to scrape: ");
        String url = scanner.nextLine();

        try {
            // Fetch the HTML content from the URL
            Document document = Jsoup.connect(url).get();

            // Extract and print the page title
            String title = document.title();
            System.out.println("Title: " + title);
        } catch (IOException e) {
            System.err.println("An error occurred while fetching or parsing the URL.");
            e.printStackTrace();
        }
        scanner.close();
    }
}
