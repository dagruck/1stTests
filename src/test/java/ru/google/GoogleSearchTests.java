package ru.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleSearchTests extends WebDriverSettings {

    @Test
    public void checkSearchResults(){
        chromeDriver.get("https://www.google.com/search?sxsrf=ALeKk010eA_BjvwBltJ9y6HwAvuh5OYIwQ%3A1595311961319&ei=WYcWX6WDE6qyrgTp9LGYAg&q=w");
        PageObjectGoogle GooglePo = new PageObjectGoogle(chromeDriver);

        GooglePo.find("Гладиолус");
        System.out.println(GooglePo.getsearchresult().size());
        Assertions.assertTrue(
                GooglePo.getsearchresult().size() >= 4
                , "Результатов меньше 4-х"
        );
    }

    @Test
    public void checkWiki(){
        chromeDriver.get("https://www.google.com/search?sxsrf=ALeKk010eA_BjvwBltJ9y6HwAvuh5OYIwQ%3A1595311961319&ei=WYcWX6WDE6qyrgTp9LGYAg&q=w");
        PageObjectGoogle GooglePo = new PageObjectGoogle(chromeDriver);

        GooglePo.find("Гладиолус");
        Assertions.assertTrue(
                GooglePo.getsearchresult().stream().anyMatch(x->x.getText().contains("ru.wikipedia.org"))
                , "Ссылка на вики не найдена"
        );

    }

}
