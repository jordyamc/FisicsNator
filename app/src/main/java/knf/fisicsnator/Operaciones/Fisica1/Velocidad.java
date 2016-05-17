package knf.fisicsnator.Operaciones.Fisica1;

import knf.fisicsnator.Operaciones.Basico;
import knf.fisicsnator.Operaciones.Conversion.fromVelocidad;

public class Velocidad {
    public static final int M_S = 0;
    public static final int KM_H = 1;
    public static final int KM_S = 2;

    public static float velocidad(float metros, float segundos, int tipo_respuesta) {
        switch (tipo_respuesta) {
            case M_S:
                return Basico.div(metros, segundos);
            case KM_H:
                return fromVelocidad.MS_TO_KMH(Basico.div(metros, segundos));
            case KM_S:
                return fromVelocidad.MS_TO_KMS(Basico.div(metros, segundos));
            default:
                return -1;
        }
    }

    public static float distancia(float velocidad, float tiempo, int tipo_respuesta) {
        switch (tipo_respuesta) {
            case M_S:
                return Basico.multi(velocidad,tiempo);
            case KM_H:
                return Basico.multi(fromVelocidad.KMH_TO_MS(velocidad),tiempo);
            case KM_S:
                return Basico.multi(fromVelocidad.KMS_TO_MS(velocidad),tiempo);
            default:
                return -1;
        }
    }

    public static float tiempo(float velocidad, float distancia, int tipo_respuesta) {
        switch (tipo_respuesta) {
            case M_S:
                return Basico.div(velocidad,distancia);
            case KM_H:
                return Basico.div(fromVelocidad.KMH_TO_MS(velocidad),distancia);
            case KM_S:
                return Basico.div(fromVelocidad.KMS_TO_MS(velocidad),distancia);
            default:
                return -1;
        }
    }

    public static String[] getTipos(){
        return new String[]{
                "M/S",
                "KM/H",
                "KM/S"
        };
    }
}
