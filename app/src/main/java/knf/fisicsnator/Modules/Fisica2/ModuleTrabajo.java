package knf.fisicsnator.Modules.Fisica2;

import android.view.View;

import knf.fisicsnator.Modules.Base.ModuleFactory_2_Var_1_Resp;
import knf.fisicsnator.Operaciones.Fisica2.Trabajo;
import knf.fisicsnator.R;
import xdroid.toaster.Toaster;

public class ModuleTrabajo extends ModuleFactory_2_Var_1_Resp {

    @Override
    public void setUpViews() {
        titulo.setText("T=F*d");
        setUnits("N","m","J");
        editText1.setHint(R.string.fuerza);
        editText2.setHint(R.string.distancia);
        editText3.setHint(R.string.trabajo);
        spinner.setVisibility(View.GONE);
        super.setUpViews();
    }

    @Override
    public void checkElements(boolean showWarning) {
        String fuerza = editText1.getText().toString().trim();
        String distancia = editText2.getText().toString().trim();
        String trabajo = editText3.getText().toString().trim();
        if (fuerza.length() == 0 || distancia.length() == 0 || trabajo.length() == 0) {
            if (fuerza.length() != 0 && distancia.length() != 0) {
                editText3.setText(String.valueOf(Trabajo.trabajo(Float.valueOf(fuerza), Float.valueOf(distancia))));
                med_3.setVisibility(View.VISIBLE);
                editText3.setError(null);
            } else if (trabajo.length() != 0 && distancia.length() != 0) {
                editText1.setText(String.valueOf(Trabajo.fuerza(Float.valueOf(trabajo), Float.valueOf(distancia))));
                med_1.setVisibility(View.VISIBLE);
                editText1.setError(null);
            } else if (trabajo.length() != 0 && fuerza.length() != 0) {
                editText2.setText(String.valueOf(Trabajo.distancia(Float.valueOf(trabajo), Float.valueOf(fuerza))));
                med_2.setVisibility(View.VISIBLE);
                editText2.setError(null);
            } else {
                if (fuerza.length() == 0) editText1.setError(context.getString(R.string.falta_dato));
                if (distancia.length() == 0) editText2.setError(context.getString(R.string.falta_dato));
                if (trabajo.length() == 0) editText3.setError(context.getString(R.string.falta_dato));
            }
        } else {
            if (Trabajo.trabajo(Float.valueOf(fuerza), Float.valueOf(distancia)) != Float.valueOf(trabajo)) {
                editText3.setError(context.getResources().getString(R.string.error_comprobacion));
                editText3.requestFocus();
                med_3.setVisibility(View.GONE);
            } else {
                Toaster.toast(R.string.ok_comprobacion);
            }
        }
    }
}
