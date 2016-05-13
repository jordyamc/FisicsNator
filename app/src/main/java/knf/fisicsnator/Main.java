package knf.fisicsnator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.Utils.MainUtil;
import xdroid.toaster.Toaster;

public class Main extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setToolTitle(R.string.recientes);
        setUpDrawer();
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
                        switch (((int) drawerItem.getIdentifier())) {
                            case MainUtil.RECIENTES:
                                Toaster.toast("Recientes");
                                break;
                            case MainUtil.CONFIGURACION:
                                Toaster.toast("Configuracion");
                                break;
                            default:
                                openFisicaActivity(String.valueOf(drawerItem.getIdentifier()));
                                break;
                        }
                        return false;
                    }
                })
                .build();
    }

    public void openFisicaActivity(String id) {
        if (id.startsWith("1")) {
            if (id.endsWith("01")) {
                Toaster.toast("Fisica 1 Tema 1");
                setToolTitle(R.string.fisica_1_t1);
            } else if (id.endsWith("02")) {
                Toaster.toast("Fisica 1 Tema 2");
                setToolTitle(R.string.fisica_1_t2);
            }
        } else if (id.startsWith("2")) {
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
}
