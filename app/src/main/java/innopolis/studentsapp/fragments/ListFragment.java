package innopolis.studentsapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import innopolis.studentsapp.R;
import innopolis.studentsapp.adapters.RVGroupAdapter;

/**
 * Created by davlet on 6/28/17.
 */

public class ListFragment extends Fragment {
    private ListView listView;
    public ArrayAdapter<String> arrayAdapter;
    private EditText editTextGroupNameFilter;

    private RecyclerView rvGroups;
    private LinearLayoutManager layoutManager;
    private RVGroupAdapter rvGroupAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvGroups = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        rvGroupAdapter = new RVGroupAdapter(getActivity().getBaseContext());

        rvGroups.setAdapter(rvGroupAdapter);
        rvGroups.setLayoutManager(layoutManager);
        rvGroupAdapter.add(0, "one");
        rvGroupAdapter.add(1, "two");
        rvGroupAdapter.add(2, "three");
        rvGroupAdapter.add(3, "one");
        rvGroupAdapter.add(4, "two");
        rvGroupAdapter.add(5, "three");

        editTextGroupNameFilter = (EditText) getActivity().findViewById(R.id.editTextGroupNameFilter);
        editTextGroupNameFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
