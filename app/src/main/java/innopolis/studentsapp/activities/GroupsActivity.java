package innopolis.studentsapp.activities;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;

import innopolis.studentsapp.R;

public class GroupsActivity extends AppCompatActivity {
    private EditText editTextGroupNameFilter;
    private Context context;
    private Fragment fragmentGroupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        context = this;
        editTextGroupNameFilter = (EditText) findViewById(R.id.editTextGroupNameFilter);
        fragmentGroupList = getFragmentManager().findFragmentById(R.id.fragmentGroupList);
    }
}
