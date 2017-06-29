package innopolis.studentsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import innopolis.studentsapp.R;
import innopolis.studentsapp.utilities.Users;

/**
 * Created by davlet on 6/20/17.
 */

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextPass;
    private EditText editTextPassConfirm;
    private Button buttonRegister;
    private Button buttonCancel;
    private Context context;
    private Users users;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        context = this;
        users = Users.getInstance();
        editTextLogin = (EditText) findViewById(R.id.editTextLog);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        editTextPassConfirm = (EditText) findViewById(R.id.editTextPasswordConfirm);
        buttonRegister = (Button) findViewById(R.id.buttonRegistration);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, LoginActivity.class));
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordsIdentical(editTextPass.getText().toString(), editTextPassConfirm.getText().toString())){
                    registerUser(editTextLogin.getText().toString(), editTextPass.getText().toString());
                    startActivity(new Intent(context, LoginActivity.class));
                }
                else Toast.makeText(context, "Passwords are different", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean passwordsIdentical(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    public void registerUser(String login, String pass){
        users.user = login;
        users.password = pass;
    }
}
