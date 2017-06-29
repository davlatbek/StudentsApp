package innopolis.studentsapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.activities.GroupPageActivity;
import innopolis.studentsapp.adapters.RVGroupAdapter;
import innopolis.studentsapp.entities.Group;

/**
 * Created by davlet on 6/28/17.
 */

public class GroupListFragment extends Fragment implements RVGroupAdapter.ItemClickListener {
    private EditText editTextGroupNameFilter;
    private RecyclerView rvGroups;
    private RVGroupAdapter rvGroupAdapter;
    private LinearLayoutManager layoutManager;
    private List<Group> tempGroupList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        populateTempData();
        rvGroups = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        rvGroupAdapter = new RVGroupAdapter(getActivity().getBaseContext(), tempGroupList);
        rvGroupAdapter.setItemClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        rvGroups.setAdapter(rvGroupAdapter);
        rvGroups.setLayoutManager(layoutManager);

        editTextGroupNameFilter = (EditText) getActivity().findViewById(R.id.editTextGroupNameFilter);
        setListeners();
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), GroupPageActivity.class);
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

    private void populateTempData() {
        tempGroupList = new ArrayList<>();
        tempGroupList.add(new Group(11L, "Group 1", 2));
        tempGroupList.add(new Group(22L, "group 2", 5));
        tempGroupList.add(new Group(23L, "group 2", 5));
        tempGroupList.add(new Group(24L, "group 2", 5));
        tempGroupList.add(new Group(25L, "group 2", 5));
        tempGroupList.add(new Group(26L, "group 2", 5));
        tempGroupList.add(new Group(27L, "group 2", 5));
        tempGroupList.add(new Group(28L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
        tempGroupList.add(new Group(2L, "group 2", 5));
    }
}
