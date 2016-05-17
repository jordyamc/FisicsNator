package knf.fisicsnator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Recientes.main_fragment;
import knf.fisicsnator.Utils.MainUtil;
import xdroid.toaster.Toaster;

public class Main extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    Drawer drawer;
    FragmentTransaction manager;
    long curretid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setToolTitle(R.string.recientes);
        setUpDrawer();
        openFragment(new main_fragment());
        Log.d("Main","OnCreate");
    }



    private void setUpDrawer() {
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withHeaderDivider(false)
                .withFooterDivider(false)
                .withCloseOnClick(true)
                .addDrawerItems(MainUtil.getDrawerItems())
                .addStickyDrawerItems(MainUtil.getSticky())
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        try {
                            if (drawer.getDrawerItems().get(drawer.getCurrentSelectedPosition()).getIdentifier()!=curretid) {
                                switch (((int) drawerItem.getIdentifier())) {
                                    case MainUtil.RECIENTES:
                                        Toaster.toast("Recientes");
                                        setToolTitle(R.string.recientes);
                                        openFragment(new main_fragment());
                                        break;
                                    case MainUtil.CONFIGURACION:
                                        Toaster.toast("Configuracion");
                                        break;
                                    default:
                                        openFisicaActivity(String.valueOf(drawerItem.getIdentifier()));
                                        break;
                                }
                                curretid=drawerItem.getIdentifier();
                            }
                        }catch (Exception e){
                            Toaster.toast("Configuracion");
                        }
                        return false;
                    }
                })
                .build();
        curretid=MainUtil.RECIENTES;
    }

    public void openFisicaActivity(String id) {
        if (id.startsWith("1")) {
            if (id.equals("10")){
                setToolTitle(R.string.fisica_1);
                Bundle bundle=new Bundle();
                bundle.putInt("type",1);
                FisicsBaseFragment fragment=new FisicsBaseFragment();
                fragment.setArguments(bundle);
                openFragment(fragment);
            }else
            if (id.endsWith("01")) {
                setToolTitle(R.string.fisica_1_t1);
                Bundle bundle=new Bundle();
                bundle.putInt("tema",MainUtil.FISICA1_T1);
                TemaBaseFragment fragment=new TemaBaseFragment();
                fragment.setArguments(bundle);
                openFragment(fragment);
            } else
            if (id.endsWith("02")) {
                Toaster.toast("Fisica 1 Tema 2");
                setToolTitle(R.string.fisica_1_t2);
            }
        } else if (id.startsWith("2")) {
            if (id.equals("20")){
                Toaster.toast("Fisica 2");
                setToolTitle(R.string.fisica_2);
                Bundle bundle=new Bundle();
                bundle.putInt("type",2);
                FisicsBaseFragment fragment=new FisicsBaseFragment();
                fragment.setArguments(bundle);
                openFragment(fragment);
            }else
            if (id.endsWith("01")) {
                Toaster.toast("Fisica 2 Tema 1");
                setToolTitle(R.string.fisica_2_t1);
            } else if (id.endsWith("02")) {
                Toaster.toast("Fisica 2 Tema 2");
                setToolTitle(R.string.fisica_2_t2);
            }
        } else {
            Toaster.toast("Not found " + id);
        }
    }

    private void setToolTitle(int title) {
        getSupportActionBar().setTitle(getResources().getString(title));
    }

    private void openFragment(Fragment fragment){
        manager = getSupportFragmentManager().beginTransaction();
        manager.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        manager.replace(R.id.container,fragment).commitAllowingStateLoss();
        MainUtil.setCurrent(fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MainUtil.getCurrent()!=null){
            openFragment(MainUtil.getCurrent());
        }
    }
}
