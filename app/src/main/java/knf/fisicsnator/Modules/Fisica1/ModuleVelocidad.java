package knf.fisicsnator.Modules.Fisica1;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Modules.BaseModule;
import knf.fisicsnator.Operaciones.Conversion;
import knf.fisicsnator.Operaciones.Fisica1.Velocidad;
import knf.fisicsnator.R;
import knf.fisicsnator.Utils.Common;
import xdroid.toaster.Toaster;

public class ModuleVelocidad extends BaseModule {
    @Bind(R.id.edit1)
    EditText distancia;
    @Bind(R.id.edit2)
    EditText tiempo;
    @Bind(R.id.edit3)
    EditText velocidad;
    @Bind(R.id.spinner)
    Spinner types;
    @Bind(R.id.titulo)
    TextView titulo;
    @Bind(R.id.start)
    FloatingActionButton actionButton;
    @Bind(R.id.med_1)
    TextView med1;
    @Bind(R.id.med_2)
    TextView med2;
    @Bind(R.id.med_3)
    TextView med3;

    private int ConversionType;

    /**
     * El Modulo debe extender de {@link BaseModule} y debe de Sobreescribir 3 funciones:
     *
     * @see #setUpViews();
     * @see #setUpListeners();
     * @see #checkElements(boolean)
     * <p>
     * En el constructor de clase se debe invocar {@link #setLayout(int)}
     * donde int es la refrencia al layout que usara el modulo
     */

    public ModuleVelocidad() {
        setLayout(R.layout.sub_item_2_var_1_resp); //Obligatorio!!!!
    }

    /**
     * Se invoca {@link ButterKnife}.bind(this,rootView)
     *
     */

    @Override
    public void setCustomViews() {
        ButterKnife.bind(this,rootView); //Obligatorio!!!!
        super.setCustomViews(); //Obligatorio!!!!
    }

    /**
     * Aqui se pone toda la configuracion inicial de las vistas usadas por el modulo.
     * ya sea informacion, textos iniciales, Hints iniciales, elementos del spinner
     *
     * Al final se debe invocar:
     * super.setUpViews();
     * <p>
     * O invocar {@link #setUpListeners()}
     */

    @Override
    public void setUpViews() {
        ConversionType = Velocidad.M_S;
        med3.setText("m/s");
        titulo.setText("V=d/t");
        distancia.setHint(R.string.distancia);
        tiempo.setHint(R.string.tiempo);
        velocidad.setHint(R.string.velocidad_ms);
        distancia.setTextColor(context.getResources().getColor(android.R.color.black));
        tiempo.setTextColor(context.getResources().getColor(android.R.color.black));
        velocidad.setTextColor(context.getResources().getColor(android.R.color.black));
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
        actionButton.bringToFront();
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkElements(true);
            }
        });
        actionButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                distancia.setText("");
                tiempo.setText("");
                velocidad.setText("");
                return true;
            }
        });
        distancia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med1.setVisibility(View.GONE);
                } else {
                    med1.setVisibility(View.VISIBLE);
                }
            }
        });
        tiempo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med2.setVisibility(View.GONE);
                } else {
                    med2.setVisibility(View.VISIBLE);
                }
            }
        });
        velocidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med3.setVisibility(View.GONE);
                } else {
                    med3.setVisibility(View.VISIBLE);
                }
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
            } else if (vel.length() != 0 && tmp.length() != 0) {
                distancia.setText(String.valueOf(Velocidad.distancia(Float.valueOf(vel), Float.valueOf(tmp), ConversionType)));
                med1.setVisibility(View.VISIBLE);
            } else if (vel.length() != 0 && dist.length() != 0) {
                tiempo.setText(String.valueOf(Velocidad.tiempo(Float.valueOf(vel), Float.valueOf(dist), ConversionType)));
                med2.setVisibility(View.VISIBLE);
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
