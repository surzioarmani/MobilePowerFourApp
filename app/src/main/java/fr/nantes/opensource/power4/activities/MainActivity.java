package fr.nantes.opensource.power4.activities;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import fr.nantes.opensource.power4.R;
import fr.nantes.opensource.power4.adapters.GridAdapter;
import fr.nantes.opensource.power4.dialogs.AnalyticsDialog;
import fr.nantes.opensource.power4.dialogs.SettingsDialog;
import fr.nantes.opensource.power4.utils.Constantes;



public class MainActivity extends AppCompatActivity {
    Button oneplayer;
    Button twoplayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneplayer = (Button)findViewById(R.id.oneplayer);


        findViewById(R.id.oneplayer).setOnClickListener(mClickListener);
    }



    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.oneplayer:
                    // 액티비티 실행
                    Intent intentSubActivity = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intentSubActivity);
                    break;
            }
        }
    };
}