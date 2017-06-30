package innopolis.studentsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Contact;

/**
 * Created by davlet on 6/30/17.
 */

public class RVContactAdapter extends RecyclerView.Adapter<RVContactAdapter.ItemHolder> {
    private List<Contact> contactList;
    private LayoutInflater layoutInflater;

    public RVContactAdapter(Context context, List<Contact> contactList) {
        this.contactList = contactList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_contact_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.textContactType.setText(contactList.get(position).getType().toString());
        holder.editContactValue.setText(contactList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView textContactType;
        EditText editContactValue;

        public ItemHolder(View itemView) {
            super(itemView);
            textContactType = (TextView) itemView.findViewById(R.id.rvStudentContactType);
            editContactValue = (EditText) itemView.findViewById(R.id.editStudentContactValue);
        }
    }
}
