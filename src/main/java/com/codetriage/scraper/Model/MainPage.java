package com.codetriage.scraper.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainPage {

    public Document getDoc() throws IOException {
        Document doc = Jsoup.connect("https://www.codetriage.com/?language=Java").get();
        // With the document fetched, we use JSoup's title() method to fetch the title
        System.out.printf("Title: %s\n", doc.title());
        return doc;

    }
}
