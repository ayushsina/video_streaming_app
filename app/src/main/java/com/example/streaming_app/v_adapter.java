package com.example.streaming_app;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class v_adapter extends FirebaseRecyclerAdapter<video_model,v_adapter.viewholder> {



    public v_adapter(@NonNull FirebaseRecyclerOptions<video_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull video_model model) {

        holder.setdata(model);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View mview= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
       return new viewholder(mview);
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        VideoView videoView;
        TextView detail;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);

            videoView=(VideoView)itemView.findViewById(R.id.videov);
            detail=(TextView)itemView.findViewById(R.id.detail);
        }

       void setdata(video_model obj)
        {
            videoView.setVideoPath(obj.getVurl());
            detail.setText(obj.getDetail());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });

        }

    }
}
