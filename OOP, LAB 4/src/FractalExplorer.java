import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator fractal;
    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        displaySize = size;                                        //размер экрана

        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();                          //создает комплексную плоскость

        fractal.getInitialRange(range);                            //считывает диапозон
        display = new JImageDisplay(displaySize, displaySize);     //создаем изображение
    }

    public void createAndShowGUI() {
        display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");                //создания рамки кнопки и события щелчок мыши

        myframe.add(display, BorderLayout.CENTER);                           // создаем окно верхнего уровня

        JButton resetButton = new JButton("Reset Display");

        Resetter handler = new Resetter();
        resetButton.addActionListener(handler);                             //вызывает после нажатия класс resetter который сбрасывает изображение

        myframe.add(resetButton, BorderLayout.SOUTH);

        Clicker click = new Clicker();                                      //событие клик
        display.addMouseListener(click);

        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }

    private void drawFractal() {
        for (int x = 0; x < displaySize; x++) {                                     //цикл прохода по всем пикселям изображения
            for (int y = 0; y < displaySize; y++) {

                double xCoord = FractalGenerator.getCoord(range.x,
                        range.x + range.width, displaySize, x);

                double yCoord = FractalGenerator.getCoord(range.y,
                        range.y + range.height, displaySize, y);            //тут происходит генерация фрактала по пикселям и собственно его вывод

                int iteration = fractal.numIterations(xCoord, yCoord);

                if (iteration == -1) {
                    display.drawPixel(x, y, 0);
                } else {
                    float hue = 0.5f + (float) iteration / 50;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    display.drawPixel(x, y, rgbColor);
                }

            }
        }
        display.repaint();                                                         //обновить JimageDisplay в соответствии с текущим изображением
    }

    private class Resetter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);                                       //сбрасывает диапазон и перерисовывает фрактал
            drawFractal();
        }
    }

    private class Clicker extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)                                      //увеличиваем фрактал по щелчку мыши
        {
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}