public class Point3d extends Point2d{

    //private double xCoord;
    //private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z) {
        super(x,y);
        //xCoord = x;
        //yCoord = y;
        zCoord = z;
    }

    public Point3d() {
        this(0, 0, 0);
    }

    /**public double getX() {
     return xCoord;
     }

     public double getY() {
     return yCoord;
     }**/

    public double getZ() {
        return zCoord;
    }

    /**public void setX(double val) {
     xCoord = val;
     }

     public void setY(double val) {
     yCoord = val;
     }**/

    public void setZ(double val) {
        zCoord = val;
    }

    public boolean compareVal(Point3d obj) {
        if ((super.getX() == obj.getX()) && (super.getY() == obj.getY()) && (this.getZ() == obj.getZ()))
            return true;
        else
            return false;
    }

    public double distanceTo(Point3d obj) {
        return Double.parseDouble(String.format("%.2f", Math.sqrt((Math.pow(obj.getX() - super.getX(), 2) + Math.pow(obj.getY() - super.getY(), 2) + Math.pow(obj.getZ() - this.getZ(), 2)))).replace(',', '.'));
    }
}