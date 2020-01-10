package com.codetriage.scraper.View;

import com.codetriage.scraper.Controller.ExtractInfo;

import java.io.IOException;

public class MainView {

    public static void start() {
        System.out.println("START SCRAPER");
        ExtractInfo page = new ExtractInfo();
        try {
            page.extract();
        } catch (IOException e) {
            System.out.println("Page is not available");
        }
    }

    public void showRepo(String repositoryTitle, String repositoryIssues, String repositoryDescription, String repositoryGithubLink) {
        //Format and print the information of the console
        System.out.println(repositoryTitle + " - " + repositoryIssues);
        System.out.println("\t" + repositoryDescription);
        System.out.println("\t" + repositoryGithubLink);
        System.out.println("\n");
    }

}
