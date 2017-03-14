package com.example.pc.retrofit_server.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.retrofit_server.R;
import com.example.pc.retrofit_server.adapter.RecyclerViewAdapter;
import com.example.pc.retrofit_server.model.User;
import com.example.pc.retrofit_server.network.ApiClient;
import com.example.pc.retrofit_server.service.APIService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayoutManager layoutManager;
    public EditText eName,eEmail,ePhone;
    public Button bSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all_find_Id();
        getUserList();
        all_OnClick();
    }

    private void all_find_Id() {
        eName = (EditText)findViewById(R.id.e_Name);
        eEmail =  (EditText)findViewById(R.id.e_email);
        ePhone = (EditText)findViewById(R.id.e_phone);
        bSave = (Button)findViewById(R.id.b_save);
    }

    private void all_OnClick() {
        bSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        setUserList();
        eName.setText("");
        eEmail.setText("");
        ePhone.setText("");

    }

    public void getUserList() {
        try{
            APIService service = ApiClient.getRetrofit().create(APIService.class);
            Call<List<User>> call = service.getUserData();

            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    Log.d("on Response",response.message());

                    List<User> userslist = response.body();


                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
                    recyclerView.setLayoutManager(layoutManager);
                    RecyclerViewAdapter recyclerViewAdaper = new RecyclerViewAdapter(userslist);
                    recyclerView.setAdapter(recyclerViewAdaper);
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                }
            });

        }catch (Exception e){

        }
    }

    public void setUserList() {
        String name = eName.getText().toString().trim();
        String email = eEmail.getText().toString().trim();
        String phone = ePhone.getText().toString().trim();

        APIService service = ApiClient.setRetrofit().create(APIService.class);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);



        Call<User> call = service.insertuserInfo(user.getName(),user.getEmail(),user.getPhone());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                Log.d("Main2Activity", "response.body()");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.e("Main2Activity", t.getMessage());

            }
        });



    }


}
