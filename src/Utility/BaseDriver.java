package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
  public static WebDriver driver;

    static  //static yaptigimiz icin ekstra fonksiyon yazmamiza gerek kalmadi.Artik otomatik olarak driver calisacak.
            // Tabi calisacak olan ilk driver ise bu kuraL Ggecerli.

   {
       KalanOncekileriKapat();


       //output taki gerekmeyen log lari kaldiracagiz

         Logger logger= Logger.getLogger(""); // sisteme(output)  ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
       //Alttaki ekstra olan loglari kaldirmak icin.
       // Ben de zaten o loglar cikmadigi icin yorum icerisine aldim.Olurda lazim olursa diye.

       System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
//       ChromeOptions options = new ChromeOptions();
//       options.addArguments("--remote-allow-origins=*");
//       driver = new ChromeDriver(options);  //Eger Chrome da guncelleme nedeniyle hata olursa acilmazsa
//                                          bu kodlari aktip edebilirim.Altta ki kodu kapatirim
       driver=new ChromeDriver();

       driver.manage().window().maximize();  //Ekrani max yapar.

       Duration dr=Duration.ofSeconds(30);
       driver.manage().timeouts().pageLoadTimeout(dr);
        // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
       //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.:
       // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
       // eğer 2 sn yüklerse 30 sn. beklemez

       driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında,
                                                      // elemente özel işlem yapılmadan önce
                                                       // hazır hale gelmesi verilen mühlet yani süre.
                                                        // eğer 2 sn yüklerse 30 sn. beklemez.
   }

  public static void BekleKapat()
  {
      MyFunc.Bekle(3);
      driver.quit();

}
    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }
}
