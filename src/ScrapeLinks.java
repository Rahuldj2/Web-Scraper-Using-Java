package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScrapeLinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a URL input
        System.out.print("Enter a URL to scrape Links from: ");
        String url = scanner.nextLine();

        try {
            Document document = Jsoup.connect(url).get();// connects to dom fetches whole static html
            // System.out.println(document);
            Elements LinkElements = document.select("a");
            FileWriter LinkWriter = new FileWriter("Linkshref.csv");
            LinkWriter.append("URLS\n"); // CSV header
            for (Element LinkElement : LinkElements) {
                String LinkUrl = LinkElement.attr("href");
                LinkWriter.append(LinkUrl + "\n");
            }
            LinkWriter.close();

            System.out.println("LINK URLs have been exported to 'Linkshref.csv'");

        } catch (IOException e) {
            System.err.println("An error occurred while fetching or parsing the URL.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

}
