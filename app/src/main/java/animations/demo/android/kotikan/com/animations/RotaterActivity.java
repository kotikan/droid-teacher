package animations.demo.android.kotikan.com.animations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.SeekBar;


public class RotaterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotater);

        View picToRotate = findViewById(R.id.picture);
        SeekBar speedBar = (SeekBar) findViewById(R.id.view_seekbar);

        startAnimation(speedBar.getProgress(), picToRotate);
        updateAnimationWhenSeekBarTouched(speedBar, picToRotate);
    }

    private void updateAnimationWhenSeekBarTouched(final SeekBar speedBar, final View picToRotate) {
        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                startAnimation(speedBar.getProgress(), picToRotate);
            }
        });
    }

    private void startAnimation(int progress, View picToRotate) {
        int sliderDuration = (int) (1500f * percentageThroughSlider(progress));
        int totalDuration = 2000 - sliderDuration;

        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(totalDuration);
        rotate.setRepeatCount(-1);
        picToRotate.startAnimation(rotate);
    }

    private float percentageThroughSlider(int sliderProgress) {
        if (sliderProgress == 0) {
            return 0;
        } else {
            return (float) sliderProgress / 100f;
        }
    }
}
