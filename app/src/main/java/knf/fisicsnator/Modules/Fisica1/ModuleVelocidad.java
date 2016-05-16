package knf.fisicsnator.Modules.Fisica1;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Modules.BaseModule;
import knf.fisicsnator.Operaciones.Fisica1.Velocidad;
import knf.fisicsnator.R;
import knf.fisicsnator.Utils.Common;
import xdroid.toaster.Toaster;

public class ModuleVelocidad extends BaseModule {

    /**
     * Usando la libreria ButterKnife se declaran todos los objectos en
     * R.layout.sub_item_2_var_1_resp.
     * <p/>
     * Se usa el @Bind(R.id.-) seguido del objeto y el nombre, cerrando con un ;
     * <p/>
     * Ejemplo: @Bind(R.id.edit1)EditText distancia;
     */

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
    private View view;
    private Context context;
    private int ConversionType;

    /**
     * El Modulo debe extender de {@link BaseModule} y debe de Sobreescribir sus 4 funciones:
     *
     * @see #inflateView(LinearLayout)
     * @see #setUpViews()
     * @see #setUpListeners()
     * @see #checkElements()
     */

    public ModuleVelocidad(Context context) {
        this.context = context;
    }

    /**
     * Aqui se crea la vista del modulo con View.inflate().
     *
     * @param layout Es la vista en donde se agregara el modulo.
     * @return Se debe regresar la vista generada por View.inflate(context,Layout,null)
     * y guardarla como una variable.
     */

    @Override
    public View inflateView(LinearLayout layout) {
        this.view = View.inflate(context, R.layout.sub_item_2_var_1_resp, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        setUpViews();
        return view;
    }

    /**
     * Aqui se pone toda la configuracion inicial de las vistas usadas por el modulo.
     * ya sea informacion, textos iniciales, Hints iniciales, elementos del spinner
     * <p/>
     * Antes que nada, se debe invocar ButterKnife.bind(this, View), donde View es la
     * vista generala por View.inflate() en
     *
     * @
     * @see #inflateView(LinearLayout).
     * <p/>
     * Al final se debe invocar:
     * @see #setUpListeners()
     */

    @Override
    public void setUpViews() {
        ButterKnife.bind(this, view);//<----Obligatorio!!!!!
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
        setUpListeners(); //<----Obligatorio!!!!!
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
                ConversionType = position;
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        actionButton.bringToFront();
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkElements();
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
     * Aqui se debe de poner toda la logica de las operaciones,ya sea completar la operacion, poner errores, y comprobaciones
     * <p/>
     * Esta funcion se debe de invocar al hacer click en el boton flotante de start.
     */

    @Override
    public void checkElements() {
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
