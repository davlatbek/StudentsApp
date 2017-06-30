package innopolis.studentsapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import innopolis.studentsapp.R;
import innopolis.studentsapp.adapters.RVContactAdapter;
import innopolis.studentsapp.utilities.TempData;

/**
 * Created by davlet on 6/30/17.
 */

public class ContactListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RVContactAdapter rvContactAdapter;
    private LinearLayoutManager layoutManager;
    private TempData tempData = TempData.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recylerView);
        rvContactAdapter = new RVContactAdapter(getActivity().getBaseContext(),
                tempData.getContactsForStudentById(
                        getActivity().getIntent().getLongExtra("student_id", 0L)));
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvContactAdapter);
    }
}
