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
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.interfaces.GroupItemClickListener;

/**
 * Created by davlet on 6/29/17.
 */

public class RVGroupAdapter extends RecyclerView.Adapter<RVGroupAdapter.ItemHolder>{

    private List<Group> items;
    private List<Group> itemsCopy = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private GroupItemClickListener onGroupItemClickListener;

    public RVGroupAdapter(Context context, List<Group> list) {
        this.items = list;
        itemsCopy.addAll(items);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RVGroupAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_group_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RVGroupAdapter.ItemHolder holder, int position) {
        holder.setTextViewGroupName(items.get(position).getName());
        holder.setTextViewGroupCourse(items.get(position).getCourseNumber().toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewGroupName;
        private TextView textViewGroupCourse;

        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewGroupName = (TextView) itemView.findViewById(R.id.rvTextGroupName);
            textViewGroupCourse = (TextView) itemView.findViewById(R.id.rvTextCourseNumber);
        }

        public void setTextViewGroupName(CharSequence charSequence){
            textViewGroupName.setText(charSequence);
        }

        public void setTextViewGroupCourse(CharSequence charSequence){
            textViewGroupCourse.setText(charSequence);
        }

        public CharSequence getTextViewGroupName(){
            return textViewGroupName.getText();
        }

        public CharSequence getTextViewGroupCourse(){
            return textViewGroupCourse.getText();
        }

        @Override
        public void onClick(View v) {
            if (onGroupItemClickListener != null)
                onGroupItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setItemClickListener(GroupItemClickListener groupItemClickListener){
        this.onGroupItemClickListener = groupItemClickListener;
    }

    public void filter(CharSequence text){
        text = text.toString().toLowerCase();
        items.clear();
        for (Group group: itemsCopy){
            if  (group.getName().toLowerCase().contains(text))
                items.add(group);
        }
        notifyDataSetChanged();
    }

    public Group getGroupAtPosition(int id){
        return items.get(id);
    }
}
