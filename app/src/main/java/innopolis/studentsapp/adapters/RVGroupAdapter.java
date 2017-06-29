package innopolis.studentsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;

/**
 * Created by davlet on 6/29/17.
 */

public class RVGroupAdapter extends RecyclerView.Adapter<RVGroupAdapter.ItemHolder>{

    private List<String> items;
    private LayoutInflater layoutInflater;

    public RVGroupAdapter(Context context) {
        this.items = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RVGroupAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_item, parent, false);
        return new ItemHolder(view, this);
    }

    @Override
    public void onBindViewHolder(RVGroupAdapter.ItemHolder holder, int position) {
        holder.setTextViewName(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RVGroupAdapter parent;
        private TextView textViewName;

        public ItemHolder(View itemView, RVGroupAdapter parent) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.parent = parent;
            textViewName = (TextView) itemView.findViewById(R.id.textRV);
        }

        public void setTextViewName(CharSequence charSequence){
            textViewName.setText(charSequence);
        }

        public CharSequence getTextViewName(){
            return textViewName.getText();
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void add(int location, String iName){
        items.add(location, iName);
        notifyItemInserted(location);
    }
}
