package julia;

public class Zespolona {

    private double x;
    private double y;

    public Zespolona(double x, double y) {
        super();
        this.x = x;
        this.y = y;

    }

    public Zespolona kwadrat() {
        return new Zespolona(x * x - y * y, 2 * (x * y)); // Liczymy rzeczywista i urojona oddzielnie
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

    public Zespolona dodaj(Zespolona z) {
        return new Zespolona(x + z.x, y + z.y);

    }

    public double getOdleglosc() {
        return Math.sqrt(x * x + y * y);
    }
}