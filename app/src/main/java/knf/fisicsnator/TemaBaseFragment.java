package knf.fisicsnator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Modules.BaseAdaptetr;
import knf.fisicsnator.Modules.BaseModule;
import knf.fisicsnator.Modules.Fisica1.ModuleVelocidad;
import knf.fisicsnator.Utils.MainUtil;

/**
 * Created by Jordy on 14/05/2016.
 */
public class TemaBaseFragment extends Fragment {
    View view;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    BaseAdaptetr adaptetr;
    public TemaBaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_tema_base,container,false);
        ButterKnife.bind(this,view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(getAdapter());
        return view;
    }

    private BaseAdaptetr getAdapter(){
        Bundle bundle=getArguments();
        switch (bundle.getInt("tema")){
            case MainUtil.FISICA1_T1:
                return new BaseAdaptetr(getActivity(),getFis1Modules());
            default:
                return new BaseAdaptetr(getActivity(),new ArrayList<BaseModule>());
        }
    }

    private List<BaseModule> getFis1Modules(){
        List<BaseModule> modules=new ArrayList<>();
        modules.add(new ModuleVelocidad());
        modules.add(new ModuleVelocidad());
        return modules;
    }
}
