package com.yahoo.mobile;

/**
 * Created by srikanthv on 6/3/16.
 */
public class AndroidUtil {

    
    

    
    static String videoPath;
    static Process p;
    static long timeStamp;
    
    public static String takeScreenShot(String name) throws Exception{
        long timeStamp=System.currentTimeMillis();
        String input="/sdcard/Pictures/"+timeStamp+".png";
        
        Terminal.runCommand("adb shell screencap "+input);
        //Transfer back to computer
        Terminal.runCommand("adb pull "+input+" /Users/srikanthv/"+timeStamp+".png");
        return "/Users/srikanthv/"+timeStamp+".png";
    }
    
    public static void startVideoCapture() throws Exception{
        timeStamp=System.currentTimeMillis();
        videoPath="/sdcard/Movies/"+timeStamp+".mp4";
        System.out.println("Starting Capture");
        p=Runtime.getRuntime().exec("adb shell screenrecord --bit-rate 8000000 " + videoPath);
    }

    public static void stopVideoCapture(String name) throws Exception{
        System.out.println("Stopping Capture");
        p.destroy();
        //pull
        Thread.sleep(1000);
        Terminal.runCommand("adb pull "+videoPath+" /Users/srikanthv/"+name+"_"+timeStamp+".mp4");
    }

    

}
