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
import com.google.android.material.textfield.TextInputEditText;

public class ResetarSenha extends AppCompatActivity {

    TextView email_reset_senha;
    TextInputEditText senha_resetar, confirmar_senha_resetar;
    Button btnReset;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetar_senha);

        senha_resetar = (TextInputEditText) findViewById(R.id.senha_resetar);
        confirmar_senha_resetar = (TextInputEditText) findViewById(R.id.confirmar_senha_resetar);
        btnReset = (Button) findViewById(R.id.btnReset);
        email_reset_senha = (TextView) findViewById(R.id.email_reset_senha);
        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        email_reset_senha.setText(intent.getStringExtra("email"));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_reset_senha.getText().toString();
                String senha = senha_resetar.getText().toString();
                String confirmarSenha = confirmar_senha_resetar.getText().toString();

                if(senha.equals(confirmarSenha)) {

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
}