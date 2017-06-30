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
import java.util.Date;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.activities.StudentPageActivity;
import innopolis.studentsapp.adapters.RVStudentAdapter;
import innopolis.studentsapp.interfaces.StudentItemClickListener;
import innopolis.studentsapp.entities.Student;
import innopolis.studentsapp.utilities.TempData;

/**
 * Created by davlet on 6/28/17.
 */

public class StudentListFragment extends Fragment implements StudentItemClickListener {
    private EditText editTextStudentNameFilter;
    private RecyclerView recyclerView;
    private RVStudentAdapter rvStudentAdapter;
    private LinearLayoutManager layoutManager;
    private TempData tempData = TempData.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        rvStudentAdapter = new RVStudentAdapter(getActivity(), TempData.getStudents());
        rvStudentAdapter.setStudentItemClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(rvStudentAdapter);
        recyclerView.setLayoutManager(layoutManager);

        if (getActivity().findViewById(R.id.editTextStudentNameFilter) != null){
            editTextStudentNameFilter = (EditText) getActivity().findViewById(R.id.editTextStudentNameFilter);
            setListeners();
        }
    }

    public void setListeners(){
        editTextStudentNameFilter.addTextChangedListener(new TextWatcher() {
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

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), StudentPageActivity.class);
        intent.putExtra("student_id", rvStudentAdapter.getStudentIdAtPosition(position));
        startActivity(intent);
    }
}
