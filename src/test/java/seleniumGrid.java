import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.*;

public class seleniumGrid {

    @Test
    public void HOmePageCheck() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.40:4444").toURL(), caps);
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Dilip Sahu");
        driver.close();

    }

    @Test
    public String[][] ExcelDataRead() throws Exception, IOException {
        File excelFile = new File("src/test/resources/seleniumTestData.xlsx");
        System.out.println(excelFile.exists());

        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Dilip");
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
//        System.out.println(noOfRows + "no of columns" + noOfColumns);

        String[][] data = new String[noOfRows - 1][noOfColumns];
        for (int i = 1; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
            }

        }
        workbook.close();
        fis.close();
        return data;
    }

    @Test
    public void testSeleniumPractice() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
//        Actions action = new Actions(driver);
//        action.dragAndDrop().build().perform();
//        action.move
        driver.get("http://omayo.blogspot.com/");
        File srcScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcScreenshotFile, new File("C:\\Users\\Jyosh\\SeleniumGridPOC\\Screenshots\\google.png"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("alert('Dilip execute Java script!!!!')");
        jse.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,-150)", "");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(250,0)", "");
        Thread.sleep(2000);
        // driver.switchTo().alert().accept();
        driver.close();


    }

    @Test
    public void FindLargestNumber() {
        int[] arr = {10, 3, 5, 11, 17};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The Largest number is : " + max);
    }

    @Test
    public void SmallestNumberInArray() {
        int[] number = {10, 12, 6, 17, 1, 0};
        int smlNumber = number[0];

        for (int i = 1; i < number.length; i++) {
            if (number[i] < smlNumber) {
                smlNumber = number[i];
            }
        }
        System.out.println("The smallest number on Array is :" + smlNumber);
    }

    @Test
    public void StringReverse() {
        String original = "Devisha";
        String reverse = new StringBuilder(original).reverse().toString();
        System.out.println("The reversed String is : " + reverse);
    }

    @Test
    public void PalindromCheck() {
        String str = "Dilip  ";
        Boolean isPalindrom = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.toLowerCase().charAt(i) != str.charAt(str.length() - i - 1)) {
                isPalindrom = false;
                break;
            }
        }
        System.out.println("Is the String Palindrom? : " + isPalindrom);
    }

    @Test
    public void SwapTwoNumbers() {
        int a = 10;
        int b = 20;
        System.out.println("number A is: " + a + " Number B is :" + b);

//        a = a+b;
//         b = a-b;
//        a = a-b;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("number A is: " + a + " Number B is :" + b);
    }

    @Test
    public void FindVowelConsonents() {
        String str = "Automation World";
        str = str.toLowerCase();
        System.out.println(str);
        int vowelCount = 0;
        int consonentsCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonentsCount++;
                }
            }
        }
        System.out.println("The vowel count is :" + vowelCount + " The consonent count is : " + consonentsCount);
    }

    @Test
    public void PrintFibonacci() {
        int n = 10;
        int a = 0;
        int b = 1;

        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    @Test
    public void FindEvenOddNumbers() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList even = new ArrayList<>();
        ArrayList odd = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }
        System.out.println("The even numbers are : "+ even);
        System.out.println("The even numbers are : "+ odd);
    }

    @Test
    public void reverseString() {
        String str = "Automation";
        String revStr = "";
        for (int i =str.length()-1 ; i>=0;  i--)
        {
            revStr = revStr+ str.charAt(i);
        }
        System.out.println("The original String is: " + str + " After the reverse login the new reversed String is: " + revStr);
    }

    @Test
    public void DuplicateElementInArray() {
        int[] arr = {1, 2, 5, 2, 1, 6, 7, 6};
        HashSet set = new HashSet<>();
        for(int num : arr) {
            if(!set.add(num)) {
                System.out.println("Duplciate : " + num);
            }
        }
    }

    @Test
    public void CharacterCount() {
        String str = "Automation";
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(char c :str.toLowerCase().toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(countMap);
    }

    @Test
    public void AnagramCheck() {
        String str = "listen";
        String str2 = "silent";
        char[] charArr1 = str.toCharArray();
        char[] charArr2 = str2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        System.out.println(charArr1);
        System.out.println(charArr2);
        if(Arrays.equals(charArr1, charArr2)){
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not an Anagram");
        }
    }

    @Test
    public void DbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("", "", "");

        if (connection.isClosed())
        {
            System.out.println("DB connection is not established");
        }
        else {
            System.out.println("DB connection is established");
        }

        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("");

        while(resultset.next()) {
            System.out.println(resultset.getInt("id"));
        }
    }



}
