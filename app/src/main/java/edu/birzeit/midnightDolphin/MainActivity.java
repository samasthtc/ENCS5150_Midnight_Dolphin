package edu.birzeit.midnightDolphin;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView scrollText;
    ImageView logo;
    ImageView plane;
    ImageView dolphin;
    ImageView waves;

    Animation textAnimation;
    Animation logoAnimation;
    Animation planeAnimation;
    Animation dolphinAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.textName);
        logo = findViewById(R.id.logo);
        plane = findViewById(R.id.plane);
        dolphin = findViewById(R.id.dolphin);
        waves = findViewById(R.id.waves);
        scrollText = findViewById(R.id.textView);

        textAnimation = AnimationUtils.loadAnimation(this, R.anim.opacity);
        logoAnimation = AnimationUtils.loadAnimation(this, R.anim.fake_rotate);
        planeAnimation = AnimationUtils.loadAnimation(this, R.anim.plane_move);
        dolphinAnimation = AnimationUtils.loadAnimation(this, R.anim.dolphin_rotate);
        scrollText.setSelected(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        name.startAnimation(textAnimation);
        logo.startAnimation(logoAnimation);
        plane.startAnimation(planeAnimation);
        dolphin.startAnimation(dolphinAnimation);
    }
}
