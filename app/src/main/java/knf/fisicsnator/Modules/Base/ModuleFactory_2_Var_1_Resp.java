package knf.fisicsnator.Modules.Base;

import android.content.Context;
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
        super.setCustomViews();
    }
}
