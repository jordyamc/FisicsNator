package knf.fisicsnator.Utils;

import android.content.Context;

/**
 * Created by Jordy on 14/05/2016.
 */
public class Common {
    public static String[] getArray(Context context,int resource){
        return context.getResources().getStringArray(resource);
    }

    public static boolean isNumber(Object object){
        return object instanceof Number;
    }
}
