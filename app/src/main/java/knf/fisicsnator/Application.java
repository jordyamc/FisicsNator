package knf.fisicsnator;

import android.content.Context;
import android.support.multidex.MultiDex;



public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
