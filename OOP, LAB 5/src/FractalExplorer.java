import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

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

        JButton resetButton = new JButton("Reset");                     //добавляем 2 кнопки
        Resetter resetHandler = new Resetter();                             //эти строчки нужны для их функционирования (по нажатию ссылаемся на метод)
        resetButton.addActionListener(resetHandler);

        JButton saveButton = new JButton("Save Image");
        Saver saveHandler = new Saver();
        saveButton.addActionListener(saveHandler);

        Clicker click = new Clicker();                                      //приближение (вызываем метод)
        display.addMouseListener(click);

        FractalGenerator mandelbrotFractal = new Mandelbrot();               //создаем обьекты классов
        FractalGenerator tricornFractal = new Tricorn();
        FractalGenerator burningShipFractal = new BurningShip();

        JComboBox comboBox = new JComboBox();                               //создаем комбобокс

        comboBox.addItem(mandelbrotFractal);                                //Добавляем элементы комбобокса
        comboBox.addItem(tricornFractal);
        comboBox.addItem(burningShipFractal);

        Chooser fractalChooser = new Chooser();                             //для выбора фрактала
        comboBox.addActionListener(fractalChooser);

        JLabel label = new JLabel("Fractal:");                          //добавляем текст

        JPanel panel = new JPanel();                                         //лабел добавляем на панель
        panel.add(label);
        panel.add(comboBox);

        JPanel myBottomPanel = new JPanel();                                 //нижняя панель
        myBottomPanel.add(saveButton);
        myBottomPanel.add(resetButton);

        JFrame myFrame = new JFrame("Fractal Explorer");                //название окна

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myBottomPanel, BorderLayout.SOUTH);                     //расположение
        myFrame.add(display, BorderLayout.CENTER);
        myFrame.add(panel, BorderLayout.NORTH);

        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setResizable(false);
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
            if (e.getActionCommand().equals("Reset")) {
                fractal.getInitialRange(range);                                       //сбрасывает диапазон и перерисовывает фрактал
                drawFractal();
            }
        }
    }
    private class Chooser implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();                                               //getsource возвращает источник события, так мы и понимаем что нажатие произошло по комбобоксу
            if (source instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) source;                                  //преобразование для того что бы дальше работать как с обьектом а не как с ссылкой

                fractal = (FractalGenerator) comboBox.getSelectedItem();                    // передаем в фрактал генератор тот элемент который мы выбрали
                assert fractal != null;                                                     //убеждаемся что он что то содержит

                fractal.getInitialRange(range);                                             //узнаем размер
                drawFractal();                                                              //рисуем фрактал
            }
        }
    }

    private class Saver implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Save Image")) {                      //Save Image - команда действия эту команду мы считываем с помощью getActionCommand
                JFileChooser fileChooser = new JFileChooser();

                FileFilter extensionFilter = new FileNameExtensionFilter(   //для того что бы отображались файлы только с указанными типами
                        "PNG",
                        "png"
                );

                fileChooser.setFileFilter(extensionFilter);

                fileChooser.setAcceptAllFileFilterUsed(false);

                int userSelection = fileChooser.showSaveDialog(display);             //открывает окно Save File

                if (userSelection == JFileChooser.APPROVE_OPTION) {                  //если пользователь выбрал файл записываем его в строку
                    java.io.File file = fileChooser.getSelectedFile();
                    String filePath = file.getPath();

                    if (!filePath.contains(".png")) file = new File(filePath + ".png"); //не указал расширение файла значит сами добавим........
                    try {                                                                        //try – определяет блок кода, в котором может произойти исключение;
                        BufferedImage displayImage = display.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    } catch (Exception exception) {                                                //catch – определяет блок кода, в котором происходит обработка исключения;
                        JOptionPane.showMessageDialog(display,
                                exception.getMessage(), "Cannot Save Image",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                else return;
            }
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