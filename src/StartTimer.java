import java.io.IOException;
import java.util.Calendar;

// 
// Decompiled by Procyon v0.5.36
// 

public class StartTimer extends Thread
{
    Calendar calendar;
    
    public StartTimer() {
        this.calendar = Calendar.getInstance();
    }
    
    @Override
    public void run() {
        if (StartMain.h == 0 && StartMain.m == 0 && StartMain.s == 0) {
            StartMain.settingAllowed = false;
        }
        if (StartMain.settingAllowed) {
            StartMain.started = true;
            StartMain.arrowVisible = false;
            StartMain.timerStarted = true;
            try {
                this.startIt();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void startIt() throws IOException {
        final int sec = this.calendar.get(13);
        int stop = 0;
        int pastSec = sec;
        StartMain.allSeconds = StartMain.h * 3600 + StartMain.m * 60 + StartMain.s;
        while (StartMain.started && stop >= 0) {
            stop = StartMain.allSeconds - 1;
            this.calendar = Calendar.getInstance();
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            StartMain.h = StartMain.allSeconds / 3600;
            StartMain.m = StartMain.allSeconds % 3600 / 60;
            StartMain.s = StartMain.allSeconds % 60;
            final int currentSec = this.calendar.get(13);
            if (StartMain.allSeconds != 0 && currentSec != pastSec) {
                --StartMain.allSeconds;
                if (StartMain.allSeconds == 0) {
                    System.out.println("Windows is shutting down.");
                }
                pastSec = currentSec;
            }
        }
        StartMain.h = 0;
        StartMain.m = 0;
        StartMain.s = 0;
        StartMain.timerStarted = false;
        StartMain.started = false;
    }
}
