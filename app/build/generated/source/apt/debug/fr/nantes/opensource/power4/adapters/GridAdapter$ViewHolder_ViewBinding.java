// Generated code from Butter Knife. Do not modify!
package fr.nantes.opensource.power4.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import fr.nantes.opensource.power4.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GridAdapter$ViewHolder_ViewBinding implements Unbinder {
  private GridAdapter.ViewHolder target;

  @UiThread
  public GridAdapter$ViewHolder_ViewBinding(GridAdapter.ViewHolder target, View source) {
    this.target = target;

    target.image = Utils.findRequiredViewAsType(source, R.id.imageViewPion, "field 'image'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GridAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.image = null;
  }
}
