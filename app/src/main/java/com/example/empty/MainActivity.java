package com.example.empty;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewGroup container = findViewById(R.id.container);
    LayoutInflater.from(this).inflate(R.layout.tile, container, true);

    MotionLayout motionLayout = findViewById(R.id.media_tile);

    findViewById(R.id.suggestions_section).setOnClickListener(v -> motionLayout.transitionToStart());

    findViewById(R.id.media_suggestion_1).setOnClickListener(v -> motionLayout.transitionToEnd());
    findViewById(R.id.media_suggestion_2).setOnClickListener(v -> motionLayout.transitionToEnd());
    findViewById(R.id.media_suggestion_3).setOnClickListener(v -> motionLayout.transitionToEnd());
    findViewById(R.id.media_suggestion_4).setOnClickListener(v -> motionLayout.transitionToEnd());
    findViewById(R.id.media_suggestion_5).setOnClickListener(v -> motionLayout.transitionToEnd());
    findViewById(R.id.media_suggestion_6).setOnClickListener(v -> motionLayout.transitionToEnd());

    motionLayout.setTransitionListener(new TransitionListener() {
      @Override
      public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

      }

      @Override
      public void onTransitionChange(MotionLayout motionLayout, int startId, int endId,
          float progress) {

      }

      @Override
      public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
        findViewById(R.id.suggestions_section).setClickable(currentId != R.id.start);
        findViewById(R.id.media_suggestion_1).setClickable(currentId == R.id.start);
        findViewById(R.id.media_suggestion_2).setClickable(currentId == R.id.start);
        findViewById(R.id.media_suggestion_3).setClickable(currentId == R.id.start);
        findViewById(R.id.media_suggestion_4).setClickable(currentId == R.id.start);
        findViewById(R.id.media_suggestion_5).setClickable(currentId == R.id.start);
        findViewById(R.id.media_suggestion_6).setClickable(currentId == R.id.start);
      }

      @Override
      public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive,
          float progress) {

      }
    });
  }
}