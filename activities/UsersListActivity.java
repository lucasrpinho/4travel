package com.example.a4travel.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.adapters.UsersRecyclerAdapter;
import com.example.a4travel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatActivity activity = UsersListActivity.this;
    private TextView txtNome;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    private Button btnX;
    private Button btnVoltar2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();
        initListeners();
    }
    /**
     * This method is to initialize views
     */
    private void initViews() {
        txtNome = (TextView) findViewById(R.id.txtNome);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        btnX = (Button) findViewById(R.id.btnX);
        btnVoltar2 = (Button) findViewById(R.id.btnVoltar2);
    }
    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        txtNome.setText(emailFromIntent);
        getDataFromSQLite();
    }

    private void initListeners(){
        btnX.setOnClickListener(this);
        btnVoltar2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnX:
                Intent intent = new Intent(this, deletarusuario.class);
                startActivity(intent);
                break;
            case R.id.btnVoltar2:
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
        }
    }
    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}