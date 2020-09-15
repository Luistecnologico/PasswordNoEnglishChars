package com.nippontic.passwordnoenglishchars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.nippontic.passwordnoenglishchars.transformation.FastPasswordTransformationMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();
    }

    private void Initialize() {
        final EditText myPasswordEditText = (EditText) findViewById(R.id.edittext_password);
        myPasswordEditText.setTransformationMethod(new FastPasswordTransformationMethod());

        findViewById(R.id.button_showPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Password writed: " + myPasswordEditText.getText(), Toast.LENGTH_LONG).show();
            }
        });

        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_show_password);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Show Password
                    myPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // Hide Password
                    myPasswordEditText.setTransformationMethod(new FastPasswordTransformationMethod());
                }
            }
        });
    }
}