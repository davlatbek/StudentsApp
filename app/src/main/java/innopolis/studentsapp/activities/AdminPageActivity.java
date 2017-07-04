package innopolis.studentsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import innopolis.studentsapp.R;

public class AdminPageActivity extends AppCompatActivity {
    private Button buttonGroups;
    private Button buttonStudents;
    private Button buttonJournals;
    private Button buttonLessons;
    private TextView textViewAdminName;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        context = this;
        textViewAdminName = (TextView) findViewById(R.id.textViewAdminName);
        textViewAdminName.setText(textViewAdminName.getText() + getIntent().getStringExtra("login"));
        buttonGroups = (Button) findViewById(R.id.buttonGroups);
        buttonStudents = (Button) findViewById(R.id.buttonStudents);
        buttonJournals = (Button) findViewById(R.id.buttonJournals);
        buttonLessons = (Button) findViewById(R.id.buttonLessons);
        buttonGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, GroupsActivity.class));
            }
        });
        buttonStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, StudentsActivity.class));
            }
        });
        buttonJournals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, JournalActivity.class));
            }
        });
        buttonLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(context, LessonsActivity.class));
                startActivity(new Intent(context, LessonPageActivity.class));
            }
        });
    }
}
