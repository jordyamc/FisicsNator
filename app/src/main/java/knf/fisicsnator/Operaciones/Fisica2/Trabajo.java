package knf.fisicsnator.Operaciones.Fisica2;

import knf.fisicsnator.Operaciones.Basico;

/**
 * Created by Jordy on 17/05/2016.
 */
public class Trabajo {
    public static float trabajo(float fuerza, float distancia) {
        return Basico.multi(fuerza, distancia);
    }

    public static float fuerza(float trabajo, float distancia) {
        return Basico.div(trabajo, distancia);
    }

    public static float distancia(float trabajo, float fuerza) {
        return Basico.div(trabajo, fuerza);
    }
}
