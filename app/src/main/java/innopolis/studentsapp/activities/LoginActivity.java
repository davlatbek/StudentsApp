package innopolis.studentsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.entities.Semester;
import innopolis.studentsapp.utilities.TempData;
import innopolis.studentsapp.utilities.Users;

/**
 * Created by davlet on 6/20/17.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
    private Context context;
    private Users users;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        users = Users.getInstance();
        initViews();
    }

    private void initViews() {
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLoginPassword(editTextLogin.getText().toString(),
                        editTextPassword.getText().toString())){
                    if (editTextLogin.getText().toString().contains("admin")) {
                        Intent intent = new Intent(context, AdminPageActivity.class);
                        intent.putExtra("login", editTextLogin.getText().toString());
                        startActivity(intent);
                    } else {
                        //TODO implement login to user_id map
                        Intent intent = new Intent(context, StudentPageActivity.class);
                        intent.putExtra("student_id", TempData.getStudents().get(0).getId());
                        startActivity(intent);
                    }
                }
                else Toast.makeText(context, "Wrong login or password " + users.user + " " + users.password, Toast.LENGTH_SHORT).show();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, RegistrationActivity.class));
            }
        });
    }

    private boolean validateLoginPassword(String login, String password) {
        return Users.userPasswordMap.containsKey(login)
                && password.equals(Users.userPasswordMap.get(login));
    }
}
