package knf.fisicsnator.Modules.Fisica1;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import knf.fisicsnator.Modules.Base.ModuleFactory_2_Var_1_Resp;
import knf.fisicsnator.Operaciones.Conversion;
import knf.fisicsnator.Operaciones.Fisica1.Velocidad;
import knf.fisicsnator.R;
import knf.fisicsnator.Utils.Common;
import xdroid.toaster.Toaster;

/**
 * El Modulo debe extender del ModuleFactory en {@link knf.fisicsnator.Modules.Base} segun
 * los campos que se requieran y debe de Sobreescribir 3 funciones:
 *
 * @see #setUpViews();
 * @see #setUpListeners();
 * @see #checkElements(boolean)
 * <p>
 * Tambien se puede sobreescribir la funcion {@link #setViewNames()} para darle
 * nombres especificos a las variables.
 * <p>
 * Al crear una nueva instancia del modulo el flujo es asi:
 * @see knf.fisicsnator.Modules.BaseModule#inflateView(Context) <-Aqui se crea el layout.
 * @see ModuleFactory_2_Var_1_Resp#setCustomViews() <-Aqui se crean todos los elementos
 * que tendra el Modulo.
 * @see #setViewNames() <-Esta funcion se invoca, es opcional sobreescribirla para darle
 * nombres especificos a los elementos del Modulo.
 * @see #setUpViews() <-Aqui se pone la configuracion inicial de los elemrntos del Modulo
 * @see #setUpListeners() <-Aqui se añaden los listeners que sean necesarios
 * <p>
 * Por Ultimo se sobreescribe la funcion {@link #checkElements(boolean)} en donde ira toda
 * la logica de operaciones del modulo,
 */

public class ModuleVelocidad extends ModuleFactory_2_Var_1_Resp {

    /**
     * Se puede sobreescribir {@link #setViewNames()} para darle nombres a las vistas,
     * o usar directamente las que vienen desde:
     *
     * @see ModuleFactory_2_Var_1_Resp#setCustomViews();
     */

    EditText distancia;
    EditText tiempo;
    EditText velocidad;
    Spinner types;
    TextView med1;
    TextView med2;
    TextView med3;
    private int ConversionType;

    @Override
    public void setViewNames() { //Opcional!
        this.distancia = editText1;
        this.tiempo = editText2;
        this.velocidad = editText3;
        this.types = spinner;
        this.med1 = med_1;
        this.med2 = med_2;
        this.med3 = med_3;
        super.setViewNames();
    }

    /**
     * Aqui se pone toda la configuracion inicial de las vistas usadas por el modulo.
     * ya sea informacion, textos iniciales, Hints iniciales, elementos del spinner
     * <p>
     * Al final se debe invocar:
     * super.setUpViews();
     * <p>
     * O invocar {@link #setUpListeners()}
     *
     * La funcion {@link #setUnits(String, String, String)} es lo mismo que poner:
     * med_1.setText(String);    <---|        |       |
     * med_2.setText(String);    <------------|       |
     * med_3.setText(String);    <--------------------|
     */

    @Override
    public void setUpViews() {
        ConversionType = Velocidad.M_S;
        setUnits("m","s","m/s");
        titulo.setText("V=d/t");
        distancia.setHint(R.string.distancia);
        tiempo.setHint(R.string.tiempo);
        velocidad.setHint(R.string.velocidad_ms);
        types.setAdapter(new ArrayAdapter<>(context, R.layout.simple_list_item, Velocidad.getTipos()));
        super.setUpViews(); //Obligatorio!!!!
    }

    /**
     * Aqui se agregan todos los listeners a las vistas, ya sea:
     * onClickListeners y onLongClickListener para botones
     * onItemSelectedListener para Spinner
     * TextChangedListener para EditTexts
     */

    @Override
    public void setUpListeners() {
        types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                velocidad.setHint(Common.getArray(context, R.array.velocidad_array)[position]);
                switch (position) {
                    case Velocidad.KM_H:
                        med3.setText("km/h");
                        break;
                    case Velocidad.KM_S:
                        med3.setText("km/s");
                        break;
                    case Velocidad.M_S:
                        med3.setText("m/s");
                        break;
                }
                if (velocidad.getText().length() != 0) {
                    switch (ConversionType) {
                        case Velocidad.KM_H:
                            switch (position) {
                                case Velocidad.KM_S:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.KMH_TO_KMS(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                                case Velocidad.M_S:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.KMH_TO_MS(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                            }
                            break;
                        case Velocidad.KM_S:
                            switch (position) {
                                case Velocidad.KM_H:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.KMS_TO_KMH(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                                case Velocidad.M_S:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.KMS_TO_MS(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                            }
                            break;
                        case Velocidad.M_S:
                            switch (position) {
                                case Velocidad.KM_H:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.MS_TO_KMH(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                                case Velocidad.KM_S:
                                    velocidad.setText(String.valueOf(Conversion.fromVelocidad.MS_TO_KMS(Float.valueOf(velocidad.getText().toString()))));
                                    break;
                            }
                            break;
                    }
                }
                ConversionType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Aqui se debe de poner toda la logica de las operaciones,ya sea completar la operacion, poner errores, y/o comprobaciones
     * <p>
     * Esta funcion se debe de invocar al hacer click en el boton flotante de start.
     */

    @Override
    public void checkElements(boolean showWarning) {
        String dist = distancia.getText().toString().trim();
        String tmp = tiempo.getText().toString().trim();
        String vel = velocidad.getText().toString().trim();
        if (dist.length() == 0 || tmp.length() == 0 || vel.length() == 0) {
            if (dist.length() != 0 && tmp.length() != 0) {
                velocidad.setText(String.valueOf(Velocidad.velocidad(Float.valueOf(dist), Float.valueOf(tmp), ConversionType)));
                med3.setVisibility(View.VISIBLE);
                velocidad.setError(null);
            } else if (vel.length() != 0 && tmp.length() != 0) {
                distancia.setText(String.valueOf(Velocidad.distancia(Float.valueOf(vel), Float.valueOf(tmp), ConversionType)));
                med1.setVisibility(View.VISIBLE);
                distancia.setError(null);
            } else if (vel.length() != 0 && dist.length() != 0) {
                tiempo.setText(String.valueOf(Velocidad.tiempo(Float.valueOf(vel), Float.valueOf(dist), ConversionType)));
                med2.setVisibility(View.VISIBLE);
                tiempo.setError(null);
            } else {
                if (dist.length() == 0) distancia.setError(context.getString(R.string.falta_dato));
                if (tmp.length() == 0) tiempo.setError(context.getString(R.string.falta_dato));
                if (vel.length() == 0) velocidad.setError(context.getString(R.string.falta_dato));
            }
        } else {
            if (Velocidad.velocidad(Float.valueOf(dist), Float.valueOf(tmp), ConversionType) != Float.valueOf(vel)) {
                velocidad.setError(context.getResources().getString(R.string.error_comprobacion));
                velocidad.requestFocus();
                med3.setVisibility(View.GONE);
            } else {
                Toaster.toast(R.string.ok_comprobacion);
            }
        }
    }

}