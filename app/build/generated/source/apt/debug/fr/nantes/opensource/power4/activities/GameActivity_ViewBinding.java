// Generated code from Butter Knife. Do not modify!
package fr.nantes.opensource.power4.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import fr.nantes.opensource.power4.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GameActivity_ViewBinding implements Unbinder {
  private GameActivity target;

  private View view2131296336;

  private View view2131296329;

  private View view2131296292;

  private View view2131296293;

  private View view2131296294;

  @UiThread
  public GameActivity_ViewBinding(GameActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GameActivity_ViewBinding(final GameActivity target, View source) {
    this.target = target;

    View view;
    target.toolbarProgressBar = Utils.findRequiredViewAsType(source, R.id.toolbar_progress_bar, "field 'toolbarProgressBar'", ProgressBar.class);
    target.toolbarTop = Utils.findRequiredViewAsType(source, R.id.toolbar_top, "field 'toolbarTop'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.gridView, "field 'gridView' and method 'OnItemClick'");
    target.gridView = Utils.castView(view, R.id.gridView, "field 'gridView'", GridView.class);
    view2131296336 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.OnItemClick(p2);
      }
    });
    view = Utils.findRequiredView(source, R.id.fab_play, "field 'fabPlay' and method 'onClick'");
    target.fabPlay = Utils.castView(view, R.id.fab_play, "field 'fabPlay'", FloatingActionButton.class);
    view2131296329 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.view = Utils.findRequiredViewAsType(source, R.id.view, "field 'view'", CoordinatorLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_info, "field 'btnInfo' and method 'onClick'");
    target.btnInfo = Utils.castView(view, R.id.btn_info, "field 'btnInfo'", ImageButton.class);
    view2131296292 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_params, "field 'btnParams' and method 'onClick'");
    target.btnParams = Utils.castView(view, R.id.btn_params, "field 'btnParams'", ImageButton.class);
    view2131296293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbarBottom = Utils.findRequiredViewAsType(source, R.id.toolbar_bottom, "field 'toolbarBottom'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_replay, "field 'btnReplay' and method 'onClick'");
    target.btnReplay = Utils.castView(view, R.id.btn_replay, "field 'btnReplay'", FloatingActionButton.class);
    view2131296294 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    GameActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarProgressBar = null;
    target.toolbarTop = null;
    target.gridView = null;
    target.fabPlay = null;
    target.view = null;
    target.btnInfo = null;
    target.btnParams = null;
    target.toolbarBottom = null;
    target.btnReplay = null;

    ((AdapterView<?>) view2131296336).setOnItemClickListener(null);
    view2131296336 = null;
    view2131296329.setOnClickListener(null);
    view2131296329 = null;
    view2131296292.setOnClickListener(null);
    view2131296292 = null;
    view2131296293.setOnClickListener(null);
    view2131296293 = null;
    view2131296294.setOnClickListener(null);
    view2131296294 = null;
  }
}
