package com.yahoo.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by srikanthv on 6/3/16.
 */
public class FlickrLoginTest {
    
    
    //adb shell screencap /sdcard/Movies/homescreen.png
    //adb pull /sdcard/Movies/homescreen.png /Users/srikanthv/1.png

    //adb shell screenrecord --bit-rate 8000000 /sdcard/Movies/mytest2.mp4
    //adb pull /sdcard/Movies/mytest2.mp4 /Users/srikanthv/3.mp4
    @Rule
    public TestName name= new TestName();
    
    @Before
    public void setUp() throws Exception{
        AndroidUtil.startVideoCapture();
    }
    @Test
    public void testLogin() throws Exception{
        //Start Video
        
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("deviceName","Galaxy S6");
        capabilities.setCapability("platform","Android");
        capabilities.setCapability("platformVersion","6.0.1");
        capabilities.setCapability("appActivity","com.yahoo.mobile.client.android.flickr.activity.MainActivity");
        capabilities.setCapability("appPackage","com.yahoo.mobile.client.android.flickr");
        capabilities.setCapability("newCommandTimeout",60);
        AppiumDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        Thread.sleep(5000);
        //Take Screenshot
        //Stop Video
        AndroidUtil.takeScreenShot(this.getClass().getSimpleName() + "-" + name.getMethodName());
        driver.quit();
    }
    
    @After
    public void tearDown() throws Exception{
        AndroidUtil.stopVideoCapture(this.getClass().getSimpleName() + "-" + name.getMethodName());
        
    }
}
