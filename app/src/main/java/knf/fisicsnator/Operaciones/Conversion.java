package knf.fisicsnator.Operaciones;

public class Conversion {
    public static class fromVelocidad {
        public static float MS_TO_KMH(Number velocidad) {
            return 3.6f * (float) velocidad;
        }

        public static float MS_TO_KMS(Number velocidad) {
            return (float) velocidad / 1000f;
        }

        public static float KMH_TO_MS(Number velocidad) {
            return (float) velocidad / 3.6f;
        }

        public static float KMH_TO_KMS(Number velocidad) {
            return (float) velocidad * 3600f;
        }

        public static float KMS_TO_MS(Number velocidad) {
            return (float) velocidad * 1000f;
        }

        public static float KMS_TO_KMH(Number velocidad) {
            return (float) velocidad / 3600f;
        }
    }
}
