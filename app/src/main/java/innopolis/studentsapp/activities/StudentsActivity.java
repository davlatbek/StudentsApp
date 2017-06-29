package innopolis.studentsapp.activities;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.EditText;

import innopolis.studentsapp.R;

public class StudentsActivity extends AppCompatActivity {
    private EditText editTextFilterStudentName;
    private Fragment fragmentStudentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        editTextFilterStudentName = (EditText) findViewById(R.id.editTextStudentNameFilter);
        fragmentStudentsList = getFragmentManager().findFragmentById(R.layout.fragment_list);
    }
}
