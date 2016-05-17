package knf.fisicsnator.Utils;

import android.support.v4.app.Fragment;

import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import knf.fisicsnator.R;

/**
 * Created by Jordy on 13/05/2016.
 */
public class MainUtil {
    public static final int RECIENTES = 0;
    public static final int CONFIGURACION = 999999999;
    public static final int FISICA1 = 10;
    public static final int FISICA1_T1 = 101;
    public static final int FISICA1_T2 = 102;
    public static final int FISICA2 = 20;
    public static final int FISICA2_T1 = 201;
    public static final int FISICA2_T2 = 202;

    public static Fragment current;

    public static IDrawerItem[] getDrawerItems() {
        return new IDrawerItem[]{
                new PrimaryDrawerItem().withName(R.string.recientes).withIcon(FontAwesome.Icon.faw_history).withIdentifier(RECIENTES),
                new DividerDrawerItem(),
                new PrimaryDrawerItem().withName(R.string.fisica_1).withIcon(CommunityMaterial.Icon.cmd_numeric_1_box_outline).withSubItems(subFisica1Items()).withIdentifier(FISICA1),
                new DividerDrawerItem(),
                new PrimaryDrawerItem().withName(R.string.fisica_2).withIcon(CommunityMaterial.Icon.cmd_numeric_2_box_outline).withSubItems(subFisica2Items()).withIdentifier(FISICA2),
        };
    }

    public static IDrawerItem[] getSticky() {
        return new IDrawerItem[]{
                new SecondaryDrawerItem().withName("Configuracion").withIcon(FontAwesome.Icon.faw_cog).withIdentifier(CONFIGURACION)
        };
    }

    private static IDrawerItem[] subFisica1Items() {
        return new IDrawerItem[]{
                new PrimaryDrawerItem().withName(R.string.fisica_1_t1).withIdentifier(FISICA1_T1),
                new PrimaryDrawerItem().withName(R.string.fisica_1_t2).withIdentifier(FISICA1_T2)
        };
    }

    private static IDrawerItem[] subFisica2Items() {
        return new IDrawerItem[]{
                new PrimaryDrawerItem().withName(R.string.fisica_2_t1).withIdentifier(FISICA2_T1),
                new PrimaryDrawerItem().withName(R.string.fisica_2_t2).withIdentifier(FISICA2_T2)
        };
    }

    public static Fragment getCurrent() {
        return current;
    }

    public static void setCurrent(Fragment current) {
        MainUtil.current = current;
    }
}
