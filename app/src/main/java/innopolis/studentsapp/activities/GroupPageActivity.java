package innopolis.studentsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.entities.Student;
import innopolis.studentsapp.utilities.TempData;
import innopolis.studentsapp.R;

public class GroupPageActivity extends AppCompatActivity {
    private EditText editTextGroupName;
    private EditText editTextCourseNumber;
    private ListView lvListOfStudents;
    private TempData tempData;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        tempData = TempData.getInstance();
        editTextGroupName = (EditText) findViewById(R.id.editText_GroupName);
        editTextCourseNumber = (EditText) findViewById(R.id.editText_CourseNumber);
        lvListOfStudents = (ListView) findViewById(R.id.lv_ListOfStudents);
        editTextGroupName.setText(getIntent().getStringExtra("group_name"));
        editTextCourseNumber.setText("1");

        List<String> studentsNames = new ArrayList<>();
        for (Student student: tempData.groups.get(0).getStudentList()){
            studentsNames.add(student.getName());
        }

        arrayAdapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, studentsNames);
        lvListOfStudents.setAdapter(arrayAdapter);
    }
}
