package innopolis.studentsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Group;

/**
 * Created by davlet on 6/29/17.
 */

public class RVGroupAdapter extends RecyclerView.Adapter<RVGroupAdapter.ItemHolder>{

    private List<String> items;
    private List<String> itemsCopy = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public RVGroupAdapter(Context context, List<String> list) {
        this.items = list;
        itemsCopy.addAll(items);
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
        private TextView textViewLetter;

        public ItemHolder(View itemView, RVGroupAdapter parent) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.parent = parent;
            textViewName = (TextView) itemView.findViewById(R.id.textRV);
            textViewLetter = (TextView) itemView.findViewById(R.id.textLetter);
        }

        public void setTextViewName(CharSequence charSequence){
            textViewName.setText(charSequence);
        }

        public void setTextViewLetter(CharSequence charSequence){
            textViewLetter.setText(charSequence);
        }

        public CharSequence getTextViewName(){
            return textViewName.getText();
        }

        public CharSequence getTextViewLetter(){
            return textViewLetter.getText();
        }

        @Override
        public void onClick(View v) {
            
        }
    }

    public void add(int location, String iName){
        items.add(location, iName);
        notifyItemInserted(location);
    }

    public void filter(CharSequence text){
        text = text.toString().toLowerCase();
        items.clear();
        for (String s: itemsCopy){
            if  (s.toLowerCase().contains(text))
                items.add(s);
        }
        notifyDataSetChanged();
    }
}
