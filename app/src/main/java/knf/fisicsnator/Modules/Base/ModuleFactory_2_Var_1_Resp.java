package knf.fisicsnator.Modules.Base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Modules.BaseModule;
import knf.fisicsnator.R;

/**
 * Created by Jordy on 17/05/2016.
 */
public class ModuleFactory_2_Var_1_Resp extends BaseModule {
    @Bind(R.id.edit1)
    public EditText editText1;
    @Bind(R.id.edit2)
    public EditText editText2;
    @Bind(R.id.edit3)
    public EditText editText3;
    @Bind(R.id.spinner)
    public Spinner spinner;
    @Bind(R.id.titulo)
    public TextView titulo;
    @Bind(R.id.start)
    public FloatingActionButton actionButton;
    @Bind(R.id.med_1)
    public TextView med_1;
    @Bind(R.id.med_2)
    public TextView med_2;
    @Bind(R.id.med_3)
    public TextView med_3;
    @Override
    public View inflateView(Context context) {
        setLayout(R.layout.sub_item_2_var_1_resp);
        return super.inflateView(context);
    }

    @Override
    public void setCustomViews() {
        ButterKnife.bind(this,rootView);
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
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                return true;
            }
        });
        editText1.setTextColor(context.getResources().getColor(android.R.color.black));
        editText2.setTextColor(context.getResources().getColor(android.R.color.black));
        editText2.setTextColor(context.getResources().getColor(android.R.color.black));
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med_1.setVisibility(View.GONE);
                } else {
                    med_1.setVisibility(View.VISIBLE);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med_2.setVisibility(View.GONE);
                } else {
                    med_2.setVisibility(View.VISIBLE);
                }
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    med_3.setVisibility(View.GONE);
                } else {
                    med_3.setVisibility(View.VISIBLE);
                }
            }
        });
        super.setCustomViews();
    }

    public void setUnits(String med1,String med2,String med3){
        med_1.setText(med1);
        med_2.setText(med2);
        med_3.setText(med3);
    }
}
