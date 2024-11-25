package edu.udemylearning.mediaplayerinandroid;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayTrailer extends AppCompatActivity {
    private ImageView  playfifa,playcs,playcd,playwwe,playgta,playpubg,playneed;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trailer);
//        playcd = findViewById(R.id.playcod);
//        playfifa = findViewById(R.id.playfifa);
//        playcs = findViewById(R.id.playcsgo);
//        playwwe = findViewById(R.id.playwwe);
//        playgta = findViewById(R.id.playgta);
//        videoView = findViewById(R.id.videoView);
//
//        playcd.setOnClickListener(V->playFullScreenVideo("cod"));
//        playfifa.setOnClickListener(V->playFullScreenVideo("fifa"));
//        playcs.setOnClickListener(V->playFullScreenVideo("csgo"));
//        playgta.setOnClickListener(V->playFullScreenVideo("gta"));
//        playwwe.setOnClickListener(V->playFullScreenVideo("wwe"));
//

        videoView = findViewById(R.id.videoView);

        findViewById(R.id.playcod).setOnClickListener(V->playFullScreenVideo("cod"));
        findViewById(R.id.playfifa).setOnClickListener(V->playFullScreenVideo("fifa"));
        findViewById(R.id.playcsgo).setOnClickListener(V->playFullScreenVideo("csgo"));
        findViewById(R.id.playgta).setOnClickListener(V->playFullScreenVideo("gta"));
        findViewById(R.id.playwwe).setOnClickListener(V->playFullScreenVideo("wwe"));
        findViewById(R.id.playpubg).setOnClickListener(V->playFullScreenVideo("pubg"));
        findViewById(R.id.playneed).setOnClickListener(V->playFullScreenVideo("need"));


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);


    }
    private  void playFullScreenVideo (String trailerName){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        //Get appropriate video file based on trailer name
        int videResId = getVideoResourceId(trailerName);
        Uri videoUri = Uri.parse(("android.resource://" + getPackageName() + "/" + videResId));

        videoView.setVideoURI(videoUri);
        videoView.setVisibility(View.VISIBLE);
        videoView.start();

    }
    private int getVideoResourceId(String trailerName){
        switch (trailerName){
            case "gta":
                return R.raw.gf;
            case "fifa":
                return R.raw.fifa;
            case "csgo":
                return R.raw.cs;
            case "cod":
                return R.raw.cd;
            case "wwe":
                return R.raw.wwe;
            case "need":
                return R.raw.need;
            case "pubg":
                return R.raw.pubg;
            default:
                return R.raw.gf;
        }
    }

    @Override
    public void onBackPressed() {
        //restore to portrait mode
       if (videoView.getVisibility() == View.VISIBLE){
           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
           videoView.setVisibility(View.GONE);
           View decorView = getWindow().getDecorView();
           decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
       }else {
           super.onBackPressed();
       }
    }
}