public class CelestialObject {
    public static final double KM_IN_ONE_AU = 150_000_000d;

    private double x;
    private double y;
    private double z;
    private String name;

    public CelestialObject() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject c1, CelestialObject c2) {
        double dx = c2.getX() - c1.getX();
        double dy = c2.getY() - c1.getY();
        double dz = c2.getZ() - c1.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject c1, CelestialObject c2) {
        return getDistanceBetween(c1, c2) * KM_IN_ONE_AU;
    }

    public static void main(String[] args) {
        CelestialObject earth = new CelestialObject("Earth", 1, 0, 0);
        System.out.println(earth.getName() + " is at " + earth.getX() + " AU from the Sun.");
        System.out.println(KM_IN_ONE_AU);
    }
}
