package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.helpers.InputValidation;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ResetarSenha extends AppCompatActivity {
    private final AppCompatActivity activity = ResetarSenha.this;

    TextView email_reset_senha;
    TextInputEditText senha_resetar, confirmar_senha_resetar;
    TextInputLayout textInputLayoutSenha, textInputLayoutConfirmarSenhaReset;
    Button btnReset;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetar_senha);

        senha_resetar = (TextInputEditText) findViewById(R.id.senha_resetar);
        confirmar_senha_resetar = (TextInputEditText) findViewById(R.id.confirmar_senha_resetar);
        btnReset = (Button) findViewById(R.id.btnReset);
        email_reset_senha = (TextView) findViewById(R.id.email_reset_senha);
        textInputLayoutSenha = (TextInputLayout) findViewById(R.id.textInputLayoutSenha);
        textInputLayoutConfirmarSenhaReset = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmarSenhaReset);
        initObjects();

        Intent intent = getIntent();
        email_reset_senha.setText(intent.getStringExtra("email"));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inputValidation.isInputEditTextFilled(senha_resetar, textInputLayoutSenha, getString(R.string.error_message_password))){
                    return;
                }

                if (!inputValidation.senhaForca(senha_resetar, textInputLayoutSenha, getString(R.string.error_força_senha))){
                    return;
                }

                if (!inputValidation.isInputEditTextFilled(confirmar_senha_resetar, textInputLayoutConfirmarSenhaReset, getString(R.string.error_message_password))){
                    return;
                }

                String email = email_reset_senha.getText().toString();
                String senha = senha_resetar.getText().toString();
                String confirmarSenha = confirmar_senha_resetar.getText().toString();

                    if (senha.equals(confirmarSenha)) {

                        Boolean checarResetSenha = databaseHelper.updateUser(email, senha);
                        if (checarResetSenha == true) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(ResetarSenha.this, "Senha atualizada com sucesso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ResetarSenha.this, "Senha não atualizada", Toast.LENGTH_LONG).show();

                        }
                    } else {
                        Toast.makeText(ResetarSenha.this, "Senhas diferentes", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

}