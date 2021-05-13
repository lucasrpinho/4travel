package com.example.a4travel.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.model.User;

import java.util.List;
public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> implements View.OnClickListener {
    private List<User> listUsers;
    private DatabaseHelper databaseHelper;
    private User user;


    public UsersRecyclerAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);
        return new UserViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.txtId.setText(String.valueOf(listUsers.get(position).getId()));
        holder.txtNome.setText(listUsers.get(position).getNome());
        holder.txtEmail.setText(listUsers.get(position).getEmail());
        holder.txtSenha.setText(listUsers.get(position).getSenha());
        databaseHelper = new DatabaseHelper(null);
        user = new User();

        View v = holder.itemView;


    }
    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNome;
        public TextView txtEmail;
        public TextView txtSenha;
        public TextView txtId;



        public UserViewHolder(View view) {
            super(view);
            txtNome = (TextView) view.findViewById(R.id.txtNome);
            txtEmail = (TextView) view.findViewById(R.id.txtEmail);
            txtSenha = (TextView) view.findViewById(R.id.txtSenha);
            txtId = (TextView) view.findViewById(R.id.txtId);
        }
    }
}