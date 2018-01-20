package com.example.aydemir.roompersistencelibraryexample;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aydemir.roompersistencelibraryexample.database.MyAppDatabase;
import com.example.aydemir.roompersistencelibraryexample.database.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextSurname;
    MyAppDatabase database;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = getDatabase();
        textView = findViewById(R.id.textView);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);

    }

    MyAppDatabase getDatabase() {
        return Room.databaseBuilder(this, MyAppDatabase.class, "users-database")
                .allowMainThreadQueries()
                .build();
    }

    public void add(View view) {

        User user = new User();
        user.firstname = editTextName.getText().toString();
        user.surname = editTextSurname.getText().toString();
        Log.v("sa", "" + database.userDAO().insertuser(user));
    }

    public void listall(View view) {
        List<User> userList = this.database.userDAO().getAll();
        if (userList.isEmpty()) {
            Log.v("boş", "burası");
        } else {
            String s = "";
            for (User user : userList) {
                s = s + user.firstname + " " + user.surname + "\n";
            }
            textView.setText(s);
        }

    }
}
