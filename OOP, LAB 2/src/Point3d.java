public class Point3d {

    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d() {
        this(0, 0, 0);
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public double getZ() {
        return zCoord;
    }

    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    public boolean compareVal(Point3d obj) {
        if ((this.xCoord == obj.xCoord) && (this.yCoord == obj.yCoord) && (this.zCoord == obj.zCoord))
            return true;
        else
            return false;
    }

    public double distanceTo(Point3d obj) {
        return Double.parseDouble(String.format("%.2f", Math.sqrt((Math.pow(obj.xCoord - this.xCoord, 2) + Math.pow(obj.yCoord - this.yCoord, 2) + Math.pow(obj.zCoord - this.zCoord, 2)))).replace(',', '.'));
    }
}