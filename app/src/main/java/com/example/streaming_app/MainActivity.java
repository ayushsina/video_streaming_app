package com.example.streaming_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    v_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        viewPager2=(ViewPager2)findViewById(R.id.viewpager);


        FirebaseRecyclerOptions<video_model> options =
                new FirebaseRecyclerOptions.Builder<video_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("video"), video_model.class)
                        .build();

        adapter=new v_adapter(options);
        viewPager2.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}