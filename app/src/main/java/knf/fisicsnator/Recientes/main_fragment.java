package knf.fisicsnator.Recientes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.R;

/**
 * Created by Jordy on 13/05/2016.
 */
public class main_fragment extends Fragment {
    View root;
    @Bind(R.id.recyclerview)RecyclerView recyclerView;
    @Bind(R.id.clear)FloatingActionButton button;
    @Bind(R.id.no_info)TextView noInfo;
    public main_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        root=inflater.inflate(R.layout.fragment_recientes,container,false);
        ButterKnife.bind(this,root);
        noInfo.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        return root;
    }
}
