package knf.fisicsnator.Operaciones;

public class Basico {

    public static float suma(float ob1, float ob2) {
        return ob1 + ob2;
    }

    public static float resta(float ob1, float ob2) {
        return ob1 - ob2;
    }

    public static float multi(float ob1, float ob2) {
        return ob1 * ob2;
    }

    public static float div(float ob1, float ob2) {
        return ob1 / ob2;
    }

    public static float seno(float angulo) {
        return (float)Math.sin((double) angulo);
    }

    public static float cos(float angulo) {
        return (float) Math.cos((double) angulo);
    }

    public static float tan(float angulo) {
        return (float) Math.tan((double) angulo);
    }

    public static float arcseno(float angulo) {
        return (float) Math.asin((double) angulo);
    }

    public static float arccos(float angulo) {
        return (float) Math.acos((double) angulo);
    }

    public static float arctan(float angulo) {
        return (float) Math.atan((double) angulo);
    }

    public static float hypot(float cop, float cad) {
        return (float) Math.hypot(((double) cop), ((double) cad));
    }
}
