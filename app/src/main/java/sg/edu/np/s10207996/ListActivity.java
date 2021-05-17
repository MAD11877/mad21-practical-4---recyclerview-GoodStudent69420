package sg.edu.np.s10207996;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    User user;
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        ImageView profileImg = findViewById(R.id.profileImg);
//
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListActivity.this);
//        alertDialog.setTitle("Profile");
//        alertDialog.setMessage("MADness");
//        alertDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        alertDialog.setPositiveButton("View", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                Random rand = new Random();
//                String theNum = "";
//                for (int i = 0; i < 10; i++){
//                    int ranInt = rand.nextInt(10);
//                    theNum += String.valueOf(ranInt);
//                }
//
//                Intent in = new Intent(ListActivity.this, MainActivity.class);
//                in.putExtra("idNum", theNum);
//                startActivity(in);
//            }
//        });

//        profileImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.show();
//            }
//        });

        for (int i = 0 ; i < 20; i++){
            user = new User(
                    "Name " + new Random().nextInt(),
                    "Description" + new Random().nextInt(),
                    i,
                    new Random().nextBoolean()
            );
            userList.add(user);
        }

        RecyclerView recyclerViewUser = findViewById(R.id.recyclerView);
        MyAdapter mAdapter = new MyAdapter(userList);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(sLayoutManager);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.setAdapter(mAdapter);
    }
}