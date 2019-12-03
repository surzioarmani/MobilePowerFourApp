package fr.nantes.opensource.power4.activities;

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

public class GameActivity2 extends AppCompatActivity
        implements SettingsDialog.SettingsDialogListener,
        GridAdapter.GridAdapterListener {


    @BindView(R.id.toolbar_progress_bar)
    ProgressBar toolbarProgressBar;
    @BindView(R.id.toolbar_top)
    Toolbar toolbarTop;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.fab_play)
    FloatingActionButton fabPlay;
    @BindView(R.id.view)
    CoordinatorLayout view;
    @BindView(R.id.btn_info)
    ImageButton btnInfo;
    @BindView(R.id.btn_params)
    ImageButton btnParams;
    @BindView(R.id.toolbar_bottom)
    Toolbar toolbarBottom;
    @BindView(R.id.btn_replay)
    FloatingActionButton btnReplay;

    private GridAdapter adapter;
    private SettingsDialog settingsDialog;
    private AnalyticsDialog analyticsDialog;
    private String FIRST_PLAYER;
    private String SECOND_PLAYER;
    int who =0;

    private String COLOR_PIECE_USER;
    private String COLOR_PIECE_USER1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarTop);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            btnReplay.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorPieceYellow)));
        } else {
            btnReplay.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPieceYellow)));
        }

        // INIT DIALOGS
        settingsDialog = new SettingsDialog();
        analyticsDialog = new AnalyticsDialog(getApplicationContext());

        // START INIT ELEMENTS

        COLOR_PIECE_USER = Constantes.YELLOW_PIECE;
        COLOR_PIECE_USER1 = Constantes.RED_PIECE;
        FIRST_PLAYER = Constantes.PLAYER;
        SECOND_PLAYER = Constantes.PLAYER2;

        // INIT GAME
        initOrResetGame();
    }

    private void replay() {
        if (adapter.gameEnd() || !adapter.gameHasBegin()) {
            initOrResetGame();
        } else {
            Snackbar snackbar = Snackbar.make(view, R.string.do_you_want_replay, Snackbar.LENGTH_LONG)
                    .setAction(R.string.snackbar_yes, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            initOrResetGame();
                        }
                    });

            snackbar.setActionTextColor(getResources().getColor(R.color.snackAction));
            snackbar.setDuration(Snackbar.LENGTH_SHORT);

            // Changing action button text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            snackbar.show();
        }
    }

    @OnItemClick(R.id.gridView)
    public void OnItemClick(int position) {
        if (Constantes.PLAYER.equals(FIRST_PLAYER) && !adapter.gameHasBegin()) {
            adapter.placeGamerPiece2(position, who);
        }
        else {
           adapter.placeGamerPiece2(position, who);
        }
        if(who == 0)
            who = 1;
        else
            who = 0;
    }

    @OnClick({R.id.btn_replay, R.id.btn_params, R.id.btn_info, R.id.fab_play})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_replay:
                replay();
                break;

            case R.id.btn_params:
                settingsDialog.show(getSupportFragmentManager(), "settingsDialog");
                break;

            case R.id.btn_info:
                analyticsDialog.show(getSupportFragmentManager(), "analyticsDialog");
                break;
            case R.id.fab_play:


        }
    }

    private void initOrResetGame() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        adapter = new GridAdapter(this, FIRST_PLAYER, metrics.widthPixels);
        adapter.setColor_piece_user(COLOR_PIECE_USER);


        if (FIRST_PLAYER.equals(Constantes.PLAYER)) {
            fabPlay.setVisibility(View.VISIBLE);
        } else {
            fabPlay.setVisibility(View.GONE);
        }

        gridView.setAdapter(adapter);
    }




    private void switchPlayer() {
        if (adapter.gameHasBegin()) {
            Snackbar.make(settingsDialog.getViewForSnackBar(), R.string.first_user_change_at_next_game, Snackbar.LENGTH_SHORT).show();
        } else {
            initOrResetGame();
        }
    }

    private void switchColor() {
        if (adapter.gameHasBegin()) {
            Snackbar.make(settingsDialog.getViewForSnackBar(), R.string.color_piece_user_change_at_next_game, Snackbar.LENGTH_SHORT).show();
        } else {
            adapter.setColor_piece_user(COLOR_PIECE_USER);
        }
    }

    @Override
    public void afterInflateView() {
        settingsDialog.setPlayer(FIRST_PLAYER);
        settingsDialog.setPlayer(SECOND_PLAYER);
        settingsDialog.setColor(COLOR_PIECE_USER);
        settingsDialog.setColor(COLOR_PIECE_USER1);

    }

    @Override
    public void onDialogViewClick(View v) {
        switch (v.getId()) {
            case R.id.radioButtonPlayerUser:
                FIRST_PLAYER = Constantes.PLAYER;
                switchPlayer();
                break;

            case R.id.radioButtonPlayerComputer:
                SECOND_PLAYER = Constantes.PLAYER2;
                switchPlayer();
                break;

            case R.id.redPiece:
                COLOR_PIECE_USER = Constantes.RED_PIECE;
                switchColor();
                break;

            case R.id.yellowPiece:
                COLOR_PIECE_USER1 = Constantes.YELLOW_PIECE;
                switchColor();
                break;
        }
    }

    @Override
    public void onSlide(int index) {

    }

    @Override
    public void onBeginComputerLoad() {

    }

    @Override
    public void onFinishComputerLoad() {

    }

    @Override
    public void showSnackMessage(String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
