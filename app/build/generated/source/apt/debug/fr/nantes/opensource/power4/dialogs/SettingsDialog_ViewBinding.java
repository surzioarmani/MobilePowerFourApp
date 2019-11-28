// Generated code from Butter Knife. Do not modify!
package fr.nantes.opensource.power4.dialogs;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.channguyen.rsv.RangeSliderView;
import fr.nantes.opensource.power4.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingsDialog_ViewBinding implements Unbinder {
  private SettingsDialog target;

  private View view2131296376;

  private View view2131296375;

  private View view2131296377;

  private View view2131296453;

  @UiThread
  public SettingsDialog_ViewBinding(final SettingsDialog target, View source) {
    this.target = target;

    View view;
    target.difficulty = Utils.findRequiredViewAsType(source, R.id.difficulty, "field 'difficulty'", TextView.class);
    target.rsv = Utils.findRequiredViewAsType(source, R.id.rsv, "field 'rsv'", RangeSliderView.class);
    view = Utils.findRequiredView(source, R.id.radioButtonPlayerUser, "field 'radioButtonPlayerUser' and method 'onClick'");
    target.radioButtonPlayerUser = Utils.castView(view, R.id.radioButtonPlayerUser, "field 'radioButtonPlayerUser'", RadioButton.class);
    view2131296376 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.radioButtonPlayerComputer, "field 'radioButtonPlayerComputer' and method 'onClick'");
    target.radioButtonPlayerComputer = Utils.castView(view, R.id.radioButtonPlayerComputer, "field 'radioButtonPlayerComputer'", RadioButton.class);
    view2131296375 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.redPiece, "field 'redPiece' and method 'onClick'");
    target.redPiece = Utils.castView(view, R.id.redPiece, "field 'redPiece'", RadioButton.class);
    view2131296377 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.yellowPiece, "field 'yellowPiece' and method 'onClick'");
    target.yellowPiece = Utils.castView(view, R.id.yellowPiece, "field 'yellowPiece'", RadioButton.class);
    view2131296453 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.viewForSnackBar = Utils.findRequiredViewAsType(source, R.id.viewForSnackBar, "field 'viewForSnackBar'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingsDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.difficulty = null;
    target.rsv = null;
    target.radioButtonPlayerUser = null;
    target.radioButtonPlayerComputer = null;
    target.redPiece = null;
    target.yellowPiece = null;
    target.viewForSnackBar = null;

    view2131296376.setOnClickListener(null);
    view2131296376 = null;
    view2131296375.setOnClickListener(null);
    view2131296375 = null;
    view2131296377.setOnClickListener(null);
    view2131296377 = null;
    view2131296453.setOnClickListener(null);
    view2131296453 = null;
  }
}
