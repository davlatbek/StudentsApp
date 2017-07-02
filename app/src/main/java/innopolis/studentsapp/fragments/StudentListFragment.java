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

import innopolis.studentsapp.R;
import innopolis.studentsapp.activities.StudentPageActivity;
import innopolis.studentsapp.adapters.RVStudentAdapter;
import innopolis.studentsapp.interfaces.OnItemLongClickListener;
import innopolis.studentsapp.interfaces.StudentItemClickListener;
import innopolis.studentsapp.utilities.TempData;

/**
 * Created by davlet on 6/28/17.
 */

public class StudentListFragment extends Fragment implements StudentItemClickListener, OnItemLongClickListener {
    private EditText editTextStudentNameFilter;
    private RecyclerView recyclerView;
    private RVStudentAdapter rvStudentAdapter;
    private LinearLayoutManager layoutManager;
    private TempData tempData = TempData.getInstance();
    private String phoneNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Long id = getActivity().getIntent().getLongExtra("group_id", 0L);
        if (id > 0L){
            rvStudentAdapter = new RVStudentAdapter(getActivity(), tempData.getStudentsForGroupById(id), this);
        } else {
            rvStudentAdapter = new RVStudentAdapter(getActivity(), TempData.getStudents(), this);
        }
        if (getActivity().findViewById(R.id.editTextStudentNameFilter) != null){
            editTextStudentNameFilter = (EditText) getActivity().findViewById(R.id.editTextStudentNameFilter);
            setListeners();
        }
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        rvStudentAdapter.setStudentItemClickListener(this);
        rvStudentAdapter.setOnItemLongClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(rvStudentAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_student_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemStudentCall:
                call();
                break;
        }
        return super.onContextItemSelected(item);
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

    public void call(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + this.phoneNumber));
        intent.resolveActivity(getActivity().getPackageManager());
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClicked(View view, int position) {
        this.phoneNumber = rvStudentAdapter.getStudentByPosition(position).getContacts().get(0).getValue();
        return true;
    }
}
