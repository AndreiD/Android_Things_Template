package com.androidadvance.things;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;
import com.socks.library.KLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

// Blinks a led connected to BCM21 pin on Raspberry PI 3
// Enter in a termianl: "adb connect ip_of_the_board"

//Tip: you can run the app after you disconnect from the computer like this
//adb shell
//rpi3:/ $ am start -n com.androidadvance.thingstest/.MainActivity
//Starting: Intent { cmp=com.androidadvance.thingstest/.MainActivity }
//rpi3:/ $

public class MainActivity extends Activity {

  private static final String GPIO_LED = "BCM21";
  private Gpio ledGPIO;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    PeripheralManagerService service = new PeripheralManagerService();

    try {
      ledGPIO = service.openGpio(GPIO_LED);
      ledGPIO.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
    } catch (IOException e) {
      Log.e("Exception", "Error on PeripheralIO API", e);
    }

    //Method 1: Traditional

    Timer timer = new Timer();
    TimerTask updateBall = new BlinkTheLed();
    timer.scheduleAtFixedRate(updateBall, 0, 1200);

    //Method 2: RxJava Power

    //Observable.interval(1200L, TimeUnit.MILLISECONDS)
    //    .timeInterval()
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(x -> {
    //      KLog.d("Blink " + ledGPIO.getValue());
    //      ledGPIO.setValue(!ledGPIO.getValue());
    //    });
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    try {
      ledGPIO.close();
    } catch (IOException e) {
      Log.e("Exception", "Error on PeripheralIO API", e);
    }
    ledGPIO = null;
  }

  class BlinkTheLed extends TimerTask {
    public void run() {
      try {
        KLog.d("Blink " + ledGPIO.getValue());
        ledGPIO.setValue(!ledGPIO.getValue());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
