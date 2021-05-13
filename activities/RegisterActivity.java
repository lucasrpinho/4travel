package com.example.a4travel.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.helpers.InputValidation;
import com.example.a4travel.model.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputEditText nomeLogin, emailLogin, senhaLogin, senhaLoginConfirmar;

    private Button btnCadastrar;
    private TextInputLayout regEmail, regSenha, regSenhaConfirmar, regNome;
    private TextView cadastrar;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
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
        nomeLogin = (TextInputEditText) findViewById(R.id.nomeLogin);
        emailLogin = (TextInputEditText) findViewById(R.id.emailLogin);
        senhaLogin = (TextInputEditText) findViewById(R.id.senhaLogin);
        senhaLoginConfirmar = (TextInputEditText) findViewById(R.id.senhaLoginConfirmar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        cadastrar = (TextView) findViewById(R.id.cadastrar);
        regEmail = (TextInputLayout) findViewById(R.id.regEmail);
        regNome = (TextInputLayout) findViewById(R.id.regNome);
        regSenha = (TextInputLayout) findViewById(R.id.regSenha);
        regSenhaConfirmar = (TextInputLayout) findViewById(R.id.regSenhaConfirmar);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btnCadastrar.setOnClickListener(this);
        cadastrar.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCadastrar:
                postDataToSQLite();
                break;
            case R.id.cadastrar:
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(nomeLogin, regNome, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(emailLogin, regEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(emailLogin, regEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(senhaLogin, regSenha, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.senhaForca(senhaLogin, regSenha, getString(R.string.error_força_senha))){
            return;
        }
        if (!inputValidation.isInputEditTextFilled(senhaLoginConfirmar, regSenhaConfirmar, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(senhaLogin, senhaLoginConfirmar, regSenhaConfirmar, getString(R.string.error_password_match))) {
            return;
        }
        if (!databaseHelper.checkUser(emailLogin.getText().toString().trim())) {
            user.setNome(nomeLogin.getText().toString().trim());
            user.setEmail(emailLogin.getText().toString().trim());
            user.setSenha(senhaLogin.getText().toString().trim());
            databaseHelper.addUser(user);
            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        nomeLogin.setText(null);
        emailLogin.setText(null);
        senhaLogin.setText(null);
        senhaLoginConfirmar.setText(null);
    }

}
