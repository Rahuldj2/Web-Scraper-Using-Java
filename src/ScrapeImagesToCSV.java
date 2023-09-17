package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScrapeImagesToCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a URL input
        System.out.print("Enter a URL to scrape images from: ");
        String url = scanner.nextLine();

        try {
            // Fetch the HTML content from the URL
            Document document = Jsoup.connect(url).get();

            // Find all image elements in the HTML
            Elements imgElements = document.select("img");

            // Create a CSV file to write the image URLs
            FileWriter csvWriter = new FileWriter("image_urls.csv");
            csvWriter.append("Image URL\n"); // CSV header

            // Iterate through the image elements and extract their src attribute
            for (Element imgElement : imgElements) {
                String imageUrl = imgElement.attr("src");
                csvWriter.append(imageUrl + "\n");
            }

            // Close the CSV writer
            csvWriter.close();

            System.out.println("Image URLs have been exported to 'image_urls.csv'");
        } catch (IOException e) {
            System.err.println("An error occurred while fetching or parsing the URL.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
