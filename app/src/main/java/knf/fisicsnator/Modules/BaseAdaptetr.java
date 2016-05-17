package knf.fisicsnator.Modules;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import knf.fisicsnator.R;

/**
 * Created by Jordy on 17/08/2015.
 */
public class BaseAdaptetr extends RecyclerView.Adapter<BaseAdaptetr.ViewHolder> {

    List<BaseModule> elements;

    private Context context;
    public BaseAdaptetr(Context context, List<BaseModule> elements) {
        this.context = context;
        this.elements = elements;
    }


    @Override
    public BaseAdaptetr.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.item_tema_empty, parent, false);
        return new BaseAdaptetr.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseAdaptetr.ViewHolder holder, final int position) {
        holder.root.addView(elements.get(holder.getAdapterPosition()).inflateView(context));
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.root)
        public LinearLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}