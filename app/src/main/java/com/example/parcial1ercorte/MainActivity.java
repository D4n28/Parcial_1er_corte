package com.example.parcial1ercorte;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    CheckBox checkTerms;
    Button btnLogin, btnRegister;
    TextView textRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        checkTerms = findViewById(R.id.checkTerms);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        textRemember = findViewById(R.id.textRemember);

        TextWatcher watcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                validarCampos();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        };

        editEmail.addTextChangedListener(watcher);
        editPassword.addTextChangedListener(watcher);
        checkTerms.setOnClickListener(v -> validarCampos());

        btnLogin.setOnClickListener(v ->
                Toast.makeText(this, "Ingresando al sistema", Toast.LENGTH_SHORT).show()
        );

        btnRegister.setOnClickListener(v ->
                Toast.makeText(this, "Proceso de Registro", Toast.LENGTH_SHORT).show()
        );

        textRemember.setOnClickListener(v ->
                Toast.makeText(this, "Recordar Contraseña", Toast.LENGTH_SHORT).show()
        );
    }

    private void validarCampos() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString();
        boolean isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean isPasswordValid = password.length() >= 8;
        boolean isTermsChecked = checkTerms.isChecked();

        btnLogin.setEnabled(isEmailValid && isPasswordValid && isTermsChecked);
    }
}
