package innopolis.studentsapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.activities.GroupPageActivity;
import innopolis.studentsapp.adapters.RVGroupAdapter;
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.interfaces.GroupItemClickListener;
import innopolis.studentsapp.utilities.TempData;

/**
 * Created by davlet on 6/28/17.
 */

public class GroupListFragment extends Fragment implements GroupItemClickListener {
    private EditText editTextGroupNameFilter;
    private RecyclerView rvGroups;
    private RVGroupAdapter rvGroupAdapter;
    private LinearLayoutManager layoutManager;
    public String phoneToSendSms;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvGroups = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        rvGroupAdapter = new RVGroupAdapter(getActivity().getBaseContext(), TempData.getGroups(), this);
        rvGroupAdapter.setItemClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        rvGroups.setAdapter(rvGroupAdapter);
        rvGroups.setLayoutManager(layoutManager);

        editTextGroupNameFilter = (EditText) getActivity().findViewById(R.id.editTextGroupNameFilter);
        setListeners();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_group_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemGroupSMS:
                sendSmsToGroupCurator();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void sendSmsToGroupCurator() {
        if (this.phoneToSendSms == null)
            Toast.makeText(getActivity(),
                    "Curator number doesn't exist. First set it!",
                    Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + this.phoneToSendSms));
            intent.putExtra("sms_body", "Group was created");
            intent.resolveActivity(getActivity().getPackageManager());
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), GroupPageActivity.class);
        intent.putExtra("group_id", rvGroupAdapter.getGroupAtPosition(position).getId());
        startActivity(intent);
    }

    public void setListeners(){
        editTextGroupNameFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rvGroupAdapter.filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
