package knf.fisicsnator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.R;

/**
 * Created by Jordy on 13/05/2016.
 */
public class FisicsBaseFragment extends Fragment {
    View root;
    @Bind(R.id.anuncio)TextView textView;
    public FisicsBaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        root = inflater.inflate(R.layout.fragment_fisica_base,container,false);
        ButterKnife.bind(this,root);
        Bundle bundle=getArguments();
        if (bundle!=null){
            textView.setText("Descripción Fisica "+bundle.getInt("type"));
        }
        return root;
    }
}
