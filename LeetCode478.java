public class LeetCode478 {
    private double radius;
    private double x_center;
    private double y_center;

    public LeetCode478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {

        double x = 0;
        double y = 0;
        double dist = 0;

        do {
            x = Math.random() * this.radius * 2 - this.radius;
            y = Math.random() * this.radius * 2 - this.radius;
            dist = Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
        } while(dist > this.radius);

        double[] result = new double[2];
        result[0] = this.x_center + x;
        result[1] = this.y_center + y;

        return result;
    }
}
