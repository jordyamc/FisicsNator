package knf.fisicsnator.Modules;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.LinearLayout;

public class BaseModule {
    public View rootView;
    public Context context;
    public int resLayout;

    public void setLayout(@LayoutRes int layout){
        this.resLayout = layout;
    }

    public View inflateView(Context context) {
        this.rootView = View.inflate(context, resLayout, null);
        rootView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        this.context = context;
        setCustomViews();
        return rootView;
    }

    public void setCustomViews(){
        setViewNames();
    }

    public void setUpViews() {
        setUpListeners();
    }

    public void setUpListeners() {

    }

    public void checkElements(boolean showWarning){

    }

    public void setViewNames(){
        setUpViews();
    }
}
