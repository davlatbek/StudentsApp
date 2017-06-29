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

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.adapters.RVStudentAdapter;

/**
 * Created by davlet on 6/28/17.
 */

public class StudentListFragment extends Fragment {
    public ArrayAdapter<String> arrayAdapter;
    private EditText editTextGroupNameFilter;

    private RecyclerView rvGroups;
    private LinearLayoutManager layoutManager;
    private RVStudentAdapter rvStudentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> list = new ArrayList<>();
        list.add("asdf");
        list.add("qwer");
        list.add("zxcv");
        list.add("davl");
        list.add("tylasdf");
        rvGroups = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        rvStudentAdapter = new RVStudentAdapter(getActivity().getBaseContext(), list);

        rvGroups.setAdapter(rvStudentAdapter);
        rvGroups.setLayoutManager(layoutManager);

        editTextGroupNameFilter = (EditText) getActivity().findViewById(R.id.editTextGroupNameFilter);
        editTextGroupNameFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rvStudentAdapter.filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
