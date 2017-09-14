package hooooong.com.spreadcubes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean checkFlag = true;
    Button btnCube1;
    Button btnCube2;
    Button btnCube3;
    Button btnCube4;
    Button btnSpread;

    float width1 = 0;
    float height1 = 0;
    float width2 = 0;
    float height2 = 0;
    float width3 = 0;
    float height3 = 0;
    float width4 = 0;
    float height4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    public void initView() {
        btnCube1 = (Button) findViewById(R.id.btnCube1);
        btnCube2 = (Button) findViewById(R.id.btnCube2);
        btnCube3 = (Button) findViewById(R.id.btnCube3);
        btnCube4 = (Button) findViewById(R.id.btnCube4);
        btnSpread = (Button) findViewById(R.id.btnSpread);
    }

    public void initListener() {
        btnSpread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSpread:
                if (checkFlag) {
                    spreadCube(btnCube1);
                    spreadCube(btnCube2);
                    spreadCube(btnCube3);
                    spreadCube(btnCube4);
                    checkFlag = false;
                    btnSpread.setText("CONVERSION");
                } else {
                    conversionCube(btnCube1);
                    conversionCube(btnCube2);
                    conversionCube(btnCube3);
                    conversionCube(btnCube4);
                    checkFlag = true;
                    btnSpread.setText("SPREAD");
                }
                break;
        }
    }

    private void spreadCube(View view) {
       switch (view.getId()){
           case R.id.btnCube1:
               width1 -= view.getWidth()/2;
               height1 -= view.getHeight()/2;
               changeCube(view,width1,height1);
               break;
           case R.id.btnCube2:
               width2 += view.getWidth()/2;
               height2 -= view.getHeight()/2;
               changeCube(view,width2,height2);
               break;
           case R.id.btnCube3:
               width3 -= view.getWidth()/2;
               height3 += view.getHeight()/2;
               changeCube(view,width3,height3);
               break;
           case R.id.btnCube4:
               width4 += view.getWidth()/2;
               height4 += view.getHeight()/2;
               changeCube(view,width4,height4);
               break;
       }
    }

    private void conversionCube(View view) {
        switch (view.getId()){
            case R.id.btnCube1:
                width1 += view.getWidth()/2;
                height1 += view.getHeight()/2;
                changeCube(view,width1,height1);
                break;
            case R.id.btnCube2:
                width2 -= view.getWidth()/2;
                height2 += view.getHeight()/2;
                changeCube(view,width2,height2);
                break;
            case R.id.btnCube3:
                width3 += view.getWidth()/2;
                height3 -= view.getHeight()/2;
                changeCube(view,width3,height3);
                break;
            case R.id.btnCube4:
                width4 -= view.getWidth()/2;
                height4 -= view.getHeight()/2;
                changeCube(view,width4,height4);
                break;
        }
    }

    public void changeCube(View view, float width, float height){
        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                view, "translationY",  width
        );
        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                view, "translationX",  height
        );

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(aniX, aniY);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1500);
        animatorSet.start();

        ObjectAnimator aniRotate = ObjectAnimator.ofFloat(
                view, "rotation", 0f, 720f
        );
        aniRotate.setDuration(2000);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        aniRotate.start();
    }
}
