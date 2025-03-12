public class CelestialObject {
    public double x;
    public double y;
    public double z;
    public String name;

    public CelestialObject() {
        x = 0;
        y = 0;
        z = 0;
        name = "Soleil";
    }

    public CelestialObject(double itemX, double itemY, double itemZ, String itemName) {
        x = itemX;
        y = itemY;
        z = itemZ;
        name = itemName;
    }
}
