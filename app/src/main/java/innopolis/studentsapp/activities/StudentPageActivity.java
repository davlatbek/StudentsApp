package innopolis.studentsapp.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Student;
import innopolis.studentsapp.utilities.TempData;

/**
 * Created by davlet on 6/22/17.
 */

public class StudentPageActivity extends AppCompatActivity {
    private ImageView imageViewStudent;
    private EditText editTextStudentName;
    private EditText editTextStudentSurname;
    private EditText editTextStudentMiddleName;
    private EditText editTextDateOfBirth;
    private EditText editTextGroupId;
    private Fragment fragmentContactList;
    public Long studentId;
    private TempData tempData = TempData.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpage);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initFields();
        Intent intent = getIntent();
        studentId = intent.getLongExtra("student_id", 0L);
        Student student = tempData.getStudentById(studentId);
        imageViewStudent.setImageResource(student.getPhotoId());
        editTextStudentName.setText(student.getName());
        editTextStudentSurname.setText(student.getSurname());
        editTextStudentMiddleName.setText(student.getMiddleName());
        editTextDateOfBirth.setText(student.getDateOfBirth().toString());
        editTextGroupId.setText(student.getGroupID().toString());
    }

    public void initFields(){
        imageViewStudent = (ImageView) findViewById(R.id.imageViewStudent);
        editTextStudentName = (EditText) findViewById(R.id.editTextFirstName);
        editTextStudentSurname = (EditText) findViewById(R.id.editTextSecondName);
        editTextStudentMiddleName = (EditText) findViewById(R.id.editTextMiddleName);
        editTextDateOfBirth = (EditText) findViewById(R.id.editTextDateOfBirth);
        editTextGroupId = (EditText) findViewById(R.id.editTextStudentGroupId);
        fragmentContactList = getFragmentManager().findFragmentById(R.id.fragmentContactList);
    }
}
