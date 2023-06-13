    package com.example.yuan.mytest;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.viewpager.widget.ViewPager;

    import android.os.Bundle;

    public class launchSimpleActivity extends AppCompatActivity {
        public static int[] imageArray = {R.drawable.fdj,R.drawable.orange,R.drawable.img_2,R.drawable.orange};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_launch_simple);

            ViewPager vp_launch = findViewById(R.id.vp_launch);

            LaunchSimpleAdapter adapter = new LaunchSimpleAdapter(this,imageArray);
            vp_launch.setAdapter(adapter);
        }
    }