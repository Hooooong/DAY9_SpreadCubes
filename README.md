# SpreadCubes 예제

### 설명
____________________________________________________

![SpreadCubes](https://github.com/Hooooong/DAY9_SpreadCubes/blob/master/image/SpreadCubes.gif)

- Property Animator 를 사용한 애니메이션 예제


### 소스코드
____________________________________________________

  - actity_main.xml

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context="hooooong.com.spreadcubes.MainActivity">

      <Button
          android:id="@+id/btnCube1"
          android:layout_width="150dp"
          android:layout_height="150dp"
          android:text="Button"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layout_constraintVertical_bias="0.501"
          tools:layout_editor_absoluteY="124dp"
          android:textColor="#FFFFFF"
          android:background="@android:color/black"/>

      <Button
          android:id="@+id/btnCube2"
          android:layout_width="150dp"
          android:layout_height="150dp"
          android:text="Button"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layout_constraintVertical_bias="0.501"
          tools:layout_editor_absoluteY="124dp"
          android:background="@android:color/holo_blue_bright"/>

      <Button
          android:id="@+id/btnCube3"
          android:layout_width="150dp"
          android:layout_height="150dp"
          android:text="Button"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layout_constraintVertical_bias="0.501"
          tools:layout_editor_absoluteY="124dp"
          android:background="@android:color/holo_green_light"/>

      <Button
          android:id="@+id/btnCube4"
          android:layout_width="150dp"
          android:layout_height="150dp"
          android:text="Button"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layout_constraintVertical_bias="0.501"
          tools:layout_editor_absoluteY="124dp"
          android:background="@android:color/holo_orange_light"/>

      <Button
          android:id="@+id/btnSpread"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="SPREAD"
          app:layout_constraintTop_toTopOf="parent"
          android:layout_marginTop="8dp"
          android:layout_marginBottom="8dp"
          app:layout_constraintVertical_bias="0.017"
          app:layout_constraintBottom_toBottomOf="parent"
          android:layout_marginRight="8dp"
          app:layout_constraintRight_toRightOf="parent"
          android:layout_marginLeft="8dp"
          app:layout_constraintLeft_toLeftOf="parent" />
  </android.support.constraint.ConstraintLayout>
  ```

  - MainActivity.java

  ```java
  public class MainActivity extends AppCompatActivity implements View.OnClickListener {

      // Spread, Conversion 구분값
      boolean checkFlag = true;

      Button btnCube1;
      Button btnCube2;
      Button btnCube3;
      Button btnCube4;
      Button btnSpread;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          initView();
          initListener();
      }

      /**
       * View 초기화
       */
      public void initView() {
          btnCube1 = (Button) findViewById(R.id.btnCube1);
          btnCube2 = (Button) findViewById(R.id.btnCube2);
          btnCube3 = (Button) findViewById(R.id.btnCube3);
          btnCube4 = (Button) findViewById(R.id.btnCube4);
          btnSpread = (Button) findViewById(R.id.btnSpread);
      }

      /**
       * Listener 초기화
       */
      public void initListener() {
          btnSpread.setOnClickListener(this);
      }

      /**
       * onClick 이벤트처리
       * @param view
       */
      @Override
      public void onClick(View view) {
          switch (view.getId()) {
              case R.id.btnSpread:
                  // 구분자를 통해
                  // Spread 인지 아닌지 검사
                  if (checkFlag) {
                      // Spread 일 떄
                      spreadCube(btnCube1);
                      spreadCube(btnCube2);
                      spreadCube(btnCube3);
                      spreadCube(btnCube4);
                  } else {
                      // Conversion 일 때
                      conversionCube(btnCube1);
                      conversionCube(btnCube2);
                      conversionCube(btnCube3);
                      conversionCube(btnCube4);
                  }
                  break;
          }
      }

      /**
       * btnSpread 을 눌렀을 때(Spread) 발생하는 이벤트 처리
       * @param view
       */
      private void spreadCube(View view) {
         switch (view.getId()){
             case R.id.btnCube1:
                 changeCube(view,-view.getWidth()/2,-view.getHeight()/2);
                 break;
             case R.id.btnCube2:
                 changeCube(view,view.getWidth()/2,-view.getHeight()/2);
                 break;
             case R.id.btnCube3:
                 changeCube(view,-view.getWidth()/2,view.getHeight()/2);
                 break;
             case R.id.btnCube4:
                 changeCube(view,view.getWidth()/2,view.getHeight()/2);
                 break;
         }
          // flag 변경
          checkFlag = false;
          // button Text 변경
          btnSpread.setText("CONVERSION");
      }

      /**
       * btnSpread 을 눌렀을 때(Conversion) 발생하는 이벤트 처리
       * @param view
       */
      private void conversionCube(View view) {
          //모든 Cube 가 0으로 이동해야 한다.
          changeCube(view,0,0);
          // flag 변경
          checkFlag = true;
          // Button text 번경
          btnSpread.setText("SPREAD");
      }

      /**
       * 애니메이션 처리
       *
       * @param view
       * @param width
       * @param height
       */
      public void changeCube(View view, float width, float height){
          /**
           * Property 애니메이션 처리
           *
           * translationX, translationY : view 좌표 이동
           */
          ObjectAnimator aniY = ObjectAnimator.ofFloat(
                  view, "translationY",   width
          );
          ObjectAnimator aniX = ObjectAnimator.ofFloat(
                  view, "translationX",   height
          );

          AnimatorSet animatorSet = new AnimatorSet();
          animatorSet.playTogether(aniX, aniY);
          animatorSet.setInterpolator(new DecelerateInterpolator());
          animatorSet.setDuration(1500);
          animatorSet.start();

          /**
           * Property 애니메이션 처리
           *
           * rotation : view 회전
           */
          ObjectAnimator aniRotate = ObjectAnimator.ofFloat(
                  view, "rotation", 0f, 720f
          );
          aniRotate.setDuration(2000);
          animatorSet.setInterpolator(new AccelerateInterpolator());
          aniRotate.start();
      }
  }
  ```
