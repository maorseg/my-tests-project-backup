//package com.cellebrite.automation;
import org.testng.annotations.Test;
import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
//import org.junit.Test;
import java.io.IOException;
//extends SystemTestCase4
public class Menu  {

    public enum SimulateTest {

        setBatteryMAX,
        setBatteryHalf,
        setBatteryMin,
        setBatteryUnknown,
        setBatteryDischarging,
        setBatteryCharging,
        setWIFIcharging,
        setACcharging,
        setUSBcharging,
        setChargerDisconnect,
        resetBattery,
        DisableBluetooth,
        EnableBluetooth,
        SimulateWIFIdisconnect,
        SimulateLineDisconnect;

    }

    // Test parameters have default values
    private SimulateTest test1 = SimulateTest.setBatteryMAX;

    @Test
    // change battery level value to 100%
    public void setBatteryMAX() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 100";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 50%
    public void setBatteryHalf() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 50";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 0%
    public void setBatteryMin() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to Unknown
    public void setBatteryUnknown() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Discharging
    public void setBatteryDischarging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 3";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging
    public void setBatteryCharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 2";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by wireless
    public void setWIFIcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set wireless 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by AC
    public void setACcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set ac 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by usb
    public void setUSBcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // make the system think that charger is disconnected
    public void setChargerDisconnect() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }
    @Test
    // “reset” command in order to return the battery to it's real values
    public void resetBattery() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery reset";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // Disable Bluetooth to simulate BT HW issue - works on rooted device
    public void DisableBluetooth() throws InterruptedException, IOException {
        String cmd = "adb shell pm disable com.android.bluetooth";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();



    }
    @Test
    // Enable Bluetooth - works on rooted device
    public void EnableBluetooth() throws InterruptedException, IOException {

        // Disable Bluetooth to simulate BT HW issue - works on rooted device
        String cmd = "adb shell pm enable com.android.bluetooth";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // Simulate WI-FI disconnects i.e. connect and disconnect every 10 seconds
    public void SimulateWIFIdisconnect() throws InterruptedException, IOException {

        for(int i=0; i<50; i++) {
            String cmd = "adb shell svc wifi disable";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
            Thread.sleep(10000);

            String cmd1 = "adb shell svc wifi enable";
            Runtime run1 = Runtime.getRuntime();
            Process pr1 = run1.exec(cmd1);
            pr1.waitFor();
            Thread.sleep(10000);

        }
    }

    @Test
    // Simulate network disconnects i.e. connect and disconnect every 10 seconds
    public void SimulateLineDisconnect() throws InterruptedException, IOException {

        for (int i = 0; i < 50; i++) {
            String cmd = "adb shell settings put global airplane_mode_on 1";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
            Thread.sleep(10000);

            String cmd1 = "adb shell settings put global airplane_mode_on 0";
            Runtime run1 = Runtime.getRuntime();
            Process pr1 = run1.exec(cmd1);
            pr1.waitFor();
            Thread.sleep(10000);

        }

    }

    public SimulateTest getTest() {
        return test1;
    }

    @ParameterProperties(description = "Test case to simulate")
    public void setTest(SimulateTest test) {
        this.test1 = test;
    }

    public String[] SimulateTest() {
        return new String[]

                {
                        SimulateTest.setBatteryMAX.name(),
                        SimulateTest.setBatteryHalf.name(),
                        SimulateTest.setBatteryMin.name(),
                        SimulateTest.setBatteryUnknown.name(),
                        SimulateTest.setBatteryDischarging.name(),
                        SimulateTest.setBatteryCharging.name(),
                        SimulateTest.setWIFIcharging.name(),
                        SimulateTest.setACcharging.name(),
                        SimulateTest.setUSBcharging.name(),
                        SimulateTest.setChargerDisconnect.name(),
                        SimulateTest.resetBattery.name(),
                        SimulateTest. DisableBluetooth.name(),
                        SimulateTest.EnableBluetooth.name(),
                        SimulateTest.SimulateWIFIdisconnect.name(),
                        SimulateTest.SimulateLineDisconnect.name()

               };

        }
}
