import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

// 
// Decompiled by Procyon v0.5.36
// 

public class StartMain extends Canvas implements KeyListener, MouseListener, MouseMotionListener
{
    private static final long serialVersionUID = 1L;
    static StartMain sg;
    Frame f;
    static Dimension kepernyomeret;
    Dimension offDimension;
    Image offImage;
    Graphics offGraphics;
    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;
    private Image image5;
    private Image image6;
    private Image image7;
    private Image image8;
    private Image image9;
    private Image image10;
    private Image image11;
    private boolean set1;
    private boolean set2;
    private boolean set3;
    private boolean set4;
    private boolean set5;
    protected static boolean set6;
    protected static boolean arrowVisible;
    protected static boolean timerStarted;
    private boolean set7;
    private boolean set8;
    private boolean set9;
    private boolean pressing;
    private boolean pressing2;
    private boolean pressing3;
    private boolean pressing4;
    private boolean pressing5;
    private boolean pressing6;
    private boolean xPressed;
    protected static boolean settingAllowed;
    protected static boolean clicked;
    protected static int allSeconds;
    private int counter;
    private int testCount;
    private int counter2;
    private int pressCount;
    protected static int h;
    protected static int m;
    protected static int s;
    protected static boolean started;
    private int xh;
    ResetTimer resetTimer;
    StartTimer startTimer;
    
    static {
        StartMain.sg = new StartMain();
        StartMain.kepernyomeret = Toolkit.getDefaultToolkit().getScreenSize();
        StartMain.set6 = false;
        StartMain.arrowVisible = false;
        StartMain.timerStarted = false;
        StartMain.settingAllowed = false;
        StartMain.clicked = false;
        StartMain.allSeconds = 0;
        StartMain.h = 0;
        StartMain.m = 0;
        StartMain.s = 0;
        StartMain.started = false;
    }
    
    public StartMain() {
        this.f = new Frame();
        this.set1 = false;
        this.set2 = false;
        this.set3 = false;
        this.set4 = false;
        this.set5 = false;
        this.set7 = false;
        this.set8 = false;
        this.set9 = false;
        this.pressing = false;
        this.pressing2 = false;
        this.pressing3 = false;
        this.pressing4 = false;
        this.pressing5 = false;
        this.pressing6 = false;
        this.xPressed = false;
        this.counter = 0;
        this.testCount = 0;
        this.counter2 = 0;
        this.pressCount = 0;
        this.xh = 0;
        this.resetTimer = new ResetTimer();
    }
    
    public void start(final StartMain ab) {
        final ImageIcon img = new ImageIcon("resources/icon2.png");
        this.f.setIconImage(img.getImage());
        this.f.setUndecorated(true);
        this.f.addKeyListener(this);
        this.f.addMouseListener(this);
        this.f.addMouseMotionListener(this);
        this.f.setSize(800, 400);
        this.f.setBackground(new Color(188, 179, 199));
        this.f.setAlwaysOnTop(true);
        this.f.setLocationRelativeTo(null);
        this.f.add(this);
        this.f.setVisible(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public static void main(final String[] args) {
        StartMain.sg.init();
        StartMain.sg.start(StartMain.sg);
    }
    
    @Override
    public void paint(final Graphics g) {
        this.update(g);
        if (this.offImage != null) {
            g.drawImage(this.offImage, 0, 0, null);
        }
    }
    
    public void init() {
        this.image1 = Toolkit.getDefaultToolkit().getImage("resources/bcg8.png");
        this.image2 = Toolkit.getDefaultToolkit().getImage("resources/set.png");
        this.image3 = Toolkit.getDefaultToolkit().getImage("resources/reset.png");
        this.image4 = Toolkit.getDefaultToolkit().getImage("resources/start.png");
        this.image5 = Toolkit.getDefaultToolkit().getImage("resources/x3.png");
        this.image6 = Toolkit.getDefaultToolkit().getImage("resources/tray.png");
        this.image7 = Toolkit.getDefaultToolkit().getImage("resources/xb.png");
        this.image8 = Toolkit.getDefaultToolkit().getImage("resources/tb.png");
        this.image9 = Toolkit.getDefaultToolkit().getImage("resources/shade2.png");
        this.image10 = Toolkit.getDefaultToolkit().getImage("resources/darkShade.png");
        this.image11 = Toolkit.getDefaultToolkit().getImage("resources/arrow2.png");
    }
    
    @Override
    public void update(final Graphics g) {
        final Dimension d = StartMain.kepernyomeret;
        if (this.offGraphics == null || d.width != this.offDimension.width || d.height != this.offDimension.height) {
            this.offDimension = d;
            this.offImage = this.createImage(d.width, d.height);
            this.offGraphics = this.offImage.getGraphics();
        }
        this.offGraphics.setColor(this.getBackground());
        this.offGraphics.fillRect(0, 0, d.width, d.height);
        this.offGraphics.setColor(Color.black);
        this.paintFrame(this.offGraphics);
        g.drawImage(this.offImage, 0, 0, null);
        try {
            Thread.sleep(20L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.repaint();
    }
    
    public void paintFrame(final Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(this.image1, 0, 0, this);
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", 1, 25));
        g2.drawString("System Shutdown Timer", 25, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", 1, 10));
        g.drawString("B. Bertalan   TM", 670, 380);
        g.drawImage(this.image2, 60, 120, this);
        g.drawImage(this.image3, 305, 120, this);
        g.drawImage(this.image4, 545, 120, this);
        g.drawImage(this.image5, 750, 15, this);
        g.drawImage(this.image6, 710, 15, this);
        if (StartMain.timerStarted) {
            g.setFont(new Font("Calibri", 1, 27));
            g.setColor(new Color(212, 0, 0));
            g.drawString("Please save all your work!", 235, 370);
        }
        g.setFont(new Font("Calibri", 1, 25));
        if (this.xPressed) {
            ++this.testCount;
            if (this.testCount <= 250) {
                g.setColor(new Color(103, 96, 110));
                g2.drawString("Reset timer first", 500, 38);
            }
            else if (this.testCount > 250) {
                this.xPressed = false;
                this.testCount = 0;
            }
        }
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced bold", 1, 120));
        if (StartMain.h > 99) {
            this.xh = 90;
            final DecimalFormat formatter2 = new DecimalFormat("000");
            final String hFormatted = formatter2.format(StartMain.h);
            final DecimalFormat formatter3 = new DecimalFormat("00");
            final String mFormatted = formatter3.format(StartMain.m);
            final String sFormatted = formatter3.format(StartMain.s);
            g2.drawString(String.valueOf(hFormatted) + ":" + mFormatted + ":" + sFormatted, this.xh, 330);
        }
        else {
            this.xh = 150;
            final DecimalFormat formatter2 = new DecimalFormat("00");
            final String hFormatted = formatter2.format(StartMain.h);
            final DecimalFormat formatter3 = new DecimalFormat("00");
            final String mFormatted = formatter3.format(StartMain.m);
            final String sFormatted = formatter3.format(StartMain.s);
            g2.drawString(String.valueOf(hFormatted) + ":" + mFormatted + ":" + sFormatted, this.xh, 330);
        }
        if (this.set1) {
            g.drawImage(this.image7, 750, 15, this);
        }
        if (this.set2) {
            g.drawImage(this.image8, 710, 15, this);
        }
        if (this.set3) {
            g.drawImage(this.image9, 41, 104, this);
        }
        if (this.set4) {
            g.drawImage(this.image9, 286, 104, this);
        }
        if (this.set5) {
            g.drawImage(this.image9, 526, 104, this);
        }
        if (StartMain.set6) {
            ++this.counter;
            ++this.counter2;
            if (this.counter < 5) {
                g.drawImage(this.image10, 40, 105, this);
            }
            else {
                StartMain.set6 = false;
            }
            if (this.counter2 % 5 == 0) {
                this.counter = 0;
            }
        }
        if (this.set7) {
            ++this.counter;
            ++this.counter2;
            if (this.counter < 5) {
                g.drawImage(this.image10, 286, 104, this);
            }
            else {
                this.set7 = false;
            }
            if (this.counter2 % 5 == 0) {
                this.counter = 0;
            }
        }
        if (this.set8) {
            ++this.counter;
            ++this.counter2;
            if (this.counter < 5) {
                g.drawImage(this.image10, 525, 104, this);
            }
            else {
                this.set8 = false;
            }
            if (this.counter2 % 5 == 0) {
                this.counter = 0;
            }
        }
        if (this.set9) {
            this.setButton(g, 195, 206, 50, 25);
            this.setButton(g, 195, 370, 50, -25);
            this.setButton(g, 370, 206, 50, 25);
            this.setButton(g, 370, 370, 50, -25);
            this.setButton(g, 545, 206, 50, 25);
            this.setButton(g, 545, 370, 50, -25);
        }
        ++this.pressCount;
        if (this.pressing && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.h <= 100) {
            if (StartMain.h < 100) {
                ++StartMain.h;
            }
            if (StartMain.h == 100) {
                StartMain.h = 0;
            }
        }
        if (this.pressing2 && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.m <= 59) {
            if (StartMain.m < 60) {
                ++StartMain.m;
            }
            if (StartMain.m == 60) {
                StartMain.m = 0;
            }
        }
        if (this.pressing3 && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.s <= 59) {
            if (StartMain.s < 60) {
                ++StartMain.s;
            }
            if (StartMain.s == 60) {
                StartMain.s = 0;
            }
        }
        if (this.pressing4 && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.h >= 0) {
            if (StartMain.h > 0) {
                --StartMain.h;
            }
            if (StartMain.h == 0) {
                StartMain.h = 99;
            }
        }
        if (this.pressing5 && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.m >= 0) {
            if (StartMain.m > 0) {
                --StartMain.m;
            }
            if (StartMain.m == 0) {
                StartMain.m = 59;
            }
        }
        if (this.pressing6 && this.pressCount > 20 && this.pressCount % 5 == 0 && StartMain.s >= 0) {
            if (StartMain.s > 0) {
                --StartMain.s;
            }
            if (StartMain.s == 0) {
                StartMain.s = 59;
            }
        }
        ++this.testCount;
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", 1, 10));
    }
    
    void setButton(final Graphics g, final int x, final int y, final int w, final int h) {
        if (StartMain.arrowVisible && !StartMain.timerStarted) {
            g.drawImage(this.image11, x, y, w, h, this);
            if (x == 195) {}
        }
    }
    
    @Override
    public void mouseDragged(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseMoved(final MouseEvent arg0) {
        if (arg0.getX() > 749 && arg0.getX() < 776 && arg0.getY() > 10 && arg0.getY() < 42) {
            this.set1 = true;
        }
        else {
            this.set1 = false;
        }
        if (arg0.getX() > 708 && arg0.getX() < 737 && arg0.getY() > 10 && arg0.getY() < 45) {
            this.set2 = true;
        }
        else {
            this.set2 = false;
        }
        if (arg0.getX() > 60 && arg0.getX() < 238 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set3 = true;
        }
        else {
            this.set3 = false;
        }
        if (arg0.getX() > 304 && arg0.getX() < 484 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set4 = true;
        }
        else {
            this.set4 = false;
        }
        if (arg0.getX() > 545 && arg0.getX() < 722 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set5 = true;
        }
        else {
            this.set5 = false;
        }
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
        if (arg0.getX() > 749 && arg0.getX() < 776 && arg0.getY() > 10 && arg0.getY() < 42) {
            this.testCount = 0;
            this.xPressed = true;
            if (!StartMain.timerStarted) {
                System.exit(0);
            }
        }
        if (arg0.getX() > 708 && arg0.getX() < 737 && arg0.getY() > 8 && arg0.getY() < 45) {
            this.f.setExtendedState(1);
        }
        if (arg0.getX() > 60 && arg0.getX() < 238 && arg0.getY() > 120 && arg0.getY() < 178) {
            StartMain.arrowVisible = true;
            StartMain.settingAllowed = true;
            StartMain.set6 = true;
        }
        else {
            StartMain.set6 = false;
        }
        if (arg0.getX() > 304 && arg0.getX() < 484 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set7 = true;
            this.resetTimer.reset();
            StartMain.started = false;
        }
        else {
            this.set7 = false;
        }
        if (arg0.getX() > 545 && arg0.getX() < 722 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set8 = true;
            if (!StartMain.started) {
                (this.startTimer = new StartTimer()).start();
            }
        }
        else {
            this.set8 = false;
        }
        if (arg0.getX() > 60 && arg0.getX() < 238 && arg0.getY() > 120 && arg0.getY() < 178) {
            this.set9 = true;
        }
        if (!StartMain.timerStarted && StartMain.settingAllowed) {
            if (this.set9 && arg0.getX() > 195 && arg0.getX() < 245 && arg0.getY() > 206 && arg0.getY() < 231) {
                this.pressing = true;
                if (StartMain.h <= 99) {
                    ++StartMain.h;
                    if (StartMain.h == 100) {
                        StartMain.h = 0;
                    }
                    this.pressCount = 0;
                }
            }
            if (this.set9 && arg0.getX() > 370 && arg0.getX() < 420 && arg0.getY() > 206 && arg0.getY() < 231) {
                this.pressing2 = true;
                if (StartMain.m <= 59) {
                    ++StartMain.m;
                    if (StartMain.m == 60) {
                        StartMain.m = 0;
                    }
                    this.pressCount = 0;
                }
            }
            if (this.set9 && arg0.getX() > 545 && arg0.getX() < 595 && arg0.getY() > 206 && arg0.getY() < 231) {
                this.pressing3 = true;
                if (StartMain.s <= 59) {
                    ++StartMain.s;
                    if (StartMain.s == 60) {
                        StartMain.s = 0;
                    }
                    this.pressCount = 0;
                }
            }
            if (this.set9 && arg0.getX() > 195 && arg0.getX() < 245 && arg0.getY() > 345 && arg0.getY() < 370) {
                this.pressing4 = true;
                if (StartMain.h >= 0) {
                    --StartMain.h;
                    if (StartMain.h < 0) {
                        StartMain.h = 99;
                    }
                    this.pressCount = 0;
                }
            }
            if (this.set9 && arg0.getX() > 370 && arg0.getX() < 420 && arg0.getY() > 345 && arg0.getY() < 370) {
                this.pressing5 = true;
                if (StartMain.m >= 0) {
                    --StartMain.m;
                    if (StartMain.m < 0) {
                        StartMain.m = 59;
                    }
                    this.pressCount = 0;
                }
            }
            if (this.set9 && arg0.getX() > 545 && arg0.getX() < 595 && arg0.getY() > 345 && arg0.getY() < 370) {
                this.pressing6 = true;
                if (StartMain.s >= 0) {
                    --StartMain.s;
                    if (StartMain.s < 0) {
                        StartMain.s = 59;
                    }
                    this.pressCount = 0;
                }
            }
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
        if (this.set9 && arg0.getX() > 195 && arg0.getX() < 245 && arg0.getY() > 206 && arg0.getY() < 231) {
            this.pressCount = 0;
            this.pressing = false;
        }
        if (this.set9 && arg0.getX() > 370 && arg0.getX() < 420 && arg0.getY() > 206 && arg0.getY() < 231) {
            this.pressCount = 0;
            this.pressing2 = false;
        }
        if (this.set9 && arg0.getX() > 545 && arg0.getX() < 595 && arg0.getY() > 206 && arg0.getY() < 231) {
            this.pressCount = 0;
            this.pressing3 = false;
        }
        if (this.set9 && arg0.getX() > 195 && arg0.getX() < 245 && arg0.getY() > 345 && arg0.getY() < 370) {
            this.pressCount = 0;
            this.pressing4 = false;
        }
        if (this.set9 && arg0.getX() > 370 && arg0.getX() < 420 && arg0.getY() > 345 && arg0.getY() < 370) {
            this.pressCount = 0;
            this.pressing5 = false;
        }
        if (this.set9 && arg0.getX() > 545 && arg0.getX() < 595 && arg0.getY() > 345 && arg0.getY() < 370) {
            this.pressCount = 0;
            this.pressing6 = false;
        }
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
    }
    
    @Override
    public void keyReleased(final KeyEvent arg0) {
    }
    
    @Override
    public void keyTyped(final KeyEvent arg0) {
    }
}
