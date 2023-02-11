import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;

public class Parsing {

    public static ArrayList<String> arrayList1;
    public static ArrayList<String> arrayList2;
    public static ArrayList<String> arrayList3;

    public void pars() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\java_projects\\ParsingKufar\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.kufar.by/l");


        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[2]/button"));
        button.click();

        WebElement lable = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div[1]/div/div/input"));
        lable.sendKeys(MyJPanel.JText);

        Thread.sleep(2000);
        WebElement button1 = webDriver.findElement(By.className("styles_search_button__5p2AJ"));
        button1.click();
        Thread.sleep(11000);

        Document doc = Jsoup.connect(webDriver.getCurrentUrl()).get();

        Elements els1 = doc.getElementsByClass("styles_title__XS_QS");
        Elements els2 = doc.getElementsByClass("styles_price__tiO8k");
        Elements els3 = doc.getElementsByClass("styles_secondary__dylmH");

//        Thread.sleep(10000);


        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();


        for (Element el1 : els1) {
            arrayList1.add(el1.text());
        }

        for (Element el2 : els2) {
            arrayList2.add(el2.text());
        }

        for (Element el3 : els3) {
            arrayList3.add(el3.text());
        }


        while (arrayList2.size()<arrayList1.size()){
            arrayList2.add("Неизвестно");
        }
        while (arrayList3.size()<arrayList1.size()){
            arrayList3.add("Неизвестно");
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(i + " --- " + arrayList1.get(i) + " --- " + arrayList2.get(i) + " --- " + arrayList3.get(i));
        }


    }
}
