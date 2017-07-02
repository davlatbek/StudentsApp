package innopolis.studentsapp.activities;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.utilities.TempData;

public class GroupPageActivity extends AppCompatActivity {
    private EditText editTextGroupName;
    private EditText editTextCourseNumber;
    private Context context;
    private Fragment fragmentStudentList;
    private TempData tempData = TempData.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        context = this;
        editTextGroupName = (EditText) findViewById(R.id.editText_GroupName);
        editTextCourseNumber = (EditText) findViewById(R.id.editText_CourseNumber);
        Long groupId = getIntent().getLongExtra("group_id", 0L);
        Group group = tempData.getGroupById(groupId);
        editTextGroupName.setText(group.getName());
        editTextCourseNumber.setText(group.getCourseNumber().toString());
        fragmentStudentList = getFragmentManager().findFragmentById(R.layout.fragment_list);
    }
}
