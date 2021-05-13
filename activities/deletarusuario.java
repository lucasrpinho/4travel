package com.example.a4travel.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.model.User;

public class deletarusuario extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = deletarusuario.this;
    private Button btnRemover;
    private Button btnVoltar;
    private EditText edtUserID;
    private DatabaseHelper databaseHelper;
    private User user;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletarusuario);
        getSupportActionBar().hide();
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews () {
        btnRemover = (Button) findViewById(R.id.btnRemover);
        edtUserID = (EditText) findViewById(R.id.edtUserID);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
    }

    private void initListeners () {
        btnRemover.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRemover:
                AlertDialog.Builder builder = new AlertDialog.Builder(deletarusuario.this);

                builder.setTitle("Deletar usuário")
              .setMessage("Tem certeza que deseja deletar este usuario?")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databaseHelper.deleteUser(edtUserID.getText().toString());
                        Toast.makeText(view.getContext(),"Usuário deletado com sucesso", Toast.LENGTH_LONG).show();
                        }
                })
                       .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
                break;
            case R.id.btnVoltar:
                Intent i = new Intent(this, UsersListActivity.class);
                startActivity(i);
                break;
        }
    }

}
