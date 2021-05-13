package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.helpers.InputValidation;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputEditText emailLogin, senhaLogin;
    private TextInputLayout  textInputLayoutEmail, textInputLayoutPassword;
    private Button btnLogin;
    private TextView cadastrar, esqueciSenha;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        emailLogin = (TextInputEditText) findViewById(R.id.emailLogin);
        senhaLogin = (TextInputEditText) findViewById(R.id.senhaLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cadastrar = (TextView) findViewById(R.id.cadastrar);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        esqueciSenha = (TextView) findViewById(R.id.esqueciSenha);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btnLogin.setOnClickListener(this);
        cadastrar.setOnClickListener(this);
        esqueciSenha.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                verifyFromSQLite();
                break;
            case R.id.cadastrar:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.esqueciSenha:
                Intent intent = new Intent(this, com.example.a4travel.activities.esqueciSenha.class);
                startActivity(intent);
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(emailLogin, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(emailLogin, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(senhaLogin, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (databaseHelper.checkUser(emailLogin.getText().toString().trim()
                , senhaLogin.getText().toString().trim())) {
            Intent telaposlogin = new Intent(activity, TelaPosLogin.class);
            telaposlogin.putExtra("EMAIL", emailLogin.getText().toString().trim());
            emptyInputEditText();
            startActivity(telaposlogin);
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }

        if (emailLogin.getText().toString().equals("admin@admin.com") && senhaLogin.getText().toString().equals("admin123")) {
            Intent listaContas = new Intent(activity, UsersListActivity.class);
            listaContas.putExtra("EMAIL", emailLogin.getText().toString().trim());
            emptyInputEditText();
            startActivity(listaContas);
        }

        /**
         * This method is to empty all input edit text
         */
    }

    private void emptyInputEditText() {
        emailLogin.setText(null);
        senhaLogin.setText(null);
    }

}
