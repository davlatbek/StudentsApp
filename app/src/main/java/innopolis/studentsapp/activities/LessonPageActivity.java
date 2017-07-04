package innopolis.studentsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Lesson;
import innopolis.studentsapp.utilities.TempData;

public class LessonPageActivity extends AppCompatActivity {
    private EditText editTextLessonName;
    private EditText editTextLessonDate;
    private EditText editTextLessonStartTime;
    private EditText editTextLessonEndTime;
    private EditText editTextLessonSubject;
    private EditText editTextLessonDescription;
    private EditText editTextLessonLector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_page);
        initializeViews();
//        Lesson lesson = TempData.getLessonById(getIntent().getLongExtra("lesson_id", 0L));
        Lesson lesson = TempData.getLessonById(1L);
        setViewValues(lesson);
    }

    private void setViewValues(Lesson lesson) {
        editTextLessonName.setText(lesson.getName());
        editTextLessonDate.setText(lesson.getDate().toString() + "");
        editTextLessonStartTime.setText(lesson.getStartTime().toString() + "");
        editTextLessonEndTime.setText(lesson.getEndTime().toString() + "");
        editTextLessonSubject.setText(lesson.getSubject());
        editTextLessonDescription.setText(lesson.getDescription());
        editTextLessonLector.setText(lesson.getLector());
    }

    public void initializeViews(){
        editTextLessonName = (EditText) findViewById(R.id.editTextLessonName);
        editTextLessonDate = (EditText) findViewById(R.id.editTextLessonDate);
        editTextLessonStartTime = (EditText) findViewById(R.id.editTextLessonStartTime);
        editTextLessonEndTime = (EditText) findViewById(R.id.editTextLessonEndTime);
        editTextLessonSubject = (EditText) findViewById(R.id.editTextLessonSubject);
        editTextLessonDescription  = (EditText) findViewById(R.id.editTextLessonDescription);
        editTextLessonLector = (EditText) findViewById(R.id.editLessonLector);
    }
}
