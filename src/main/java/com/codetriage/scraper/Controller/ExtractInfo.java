package com.codetriage.scraper.Controller;

import com.codetriage.scraper.Model.MainPage;
import com.codetriage.scraper.View.MainView;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExtractInfo {

    MainPage mainPage;
    Elements repositories;

    public void extract() throws IOException {
        mainPage = new MainPage();

        // Get the list of repositories
        repositories = mainPage.getDoc().getElementsByClass("repo-item");

                    /*
              For each repository, extract the following information:
              1. Title
              2. Number of issues
              3. Description
              4. Full name on github
             */
        for (Element repository : repositories) {

            // Extract the title
            String repositoryTitle = repository.getElementsByClass("repo-item-title").text();

            // Extract the number of issues on the repository
            String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();

            // Extract the description of the repository
            String repositoryDescription = repository.getElementsByClass("repo-item-description").text();

            // Get the full name of the repository
            String repositoryGithubName = repository.getElementsByClass("repo-item-full-name").text();

            // The repository full name contains brackets that we remove first before generating the valid Github link
            String repositoryGithubLink = "https://github.com/" + repositoryGithubName.replaceAll("[()]", "");


            MainView view = new MainView();
            view.showRepo(repositoryTitle, repositoryIssues, repositoryDescription, repositoryGithubLink);
        }
    }
}
