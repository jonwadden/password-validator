package ca.jwdn.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButtonPressed(View view){
        EditText passwordField = findViewById(R.id.passwordInput);
        String passwordText = passwordField.getText().toString();
        System.out.println(passwordText);
        TextView resultLabel = findViewById(R.id.resultLabel);

        Validator v = new Validator();
        int testsPassed = v.validate(passwordText);
        resultLabel.setText("Security: " + testsPassed + "/5");
    }


}
