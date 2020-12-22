public class ComplexNum {
    public double rl;        //действительная часть числа
    public double im;           //мнимая

    public ComplexNum(double rl, double im){
        this.rl = rl;
        this.im = im;
    }

    public double getSquaredModule() {
        return (this.rl * this.rl + this.im * this.im);           //число в квадрате по модулю
    }

    public void makeSquaredInPoint(double x, double y) {
        double real = (rl * rl) - (im * im) + x;                        //считаем комплексное число
        double imagine = 2 * rl * im + y;

        rl = real;
        im = imagine;
    }
}