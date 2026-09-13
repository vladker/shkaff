package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SquareLabelFragment_ViewBinding implements Unbinder {
    private SquareLabelFragment target;
    private View view17d7;
    private View view17d8;

    @UiThread
    public SquareLabelFragment_ViewBinding(final SquareLabelFragment squareLabelFragment, View view) {
        this.target = squareLabelFragment;
        squareLabelFragment.etFragmentSquareLabelSearch = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_fragment_square_label_search, "field 'etFragmentSquareLabelSearch'", EditText.class);
        squareLabelFragment.rvFragmentSquareLabelType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_square_label_type, "field 'rvFragmentSquareLabelType'", RecyclerView.class);
        squareLabelFragment.etFragmentSquareLabelMinWidth = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_fragment_square_label_minWidth, "field 'etFragmentSquareLabelMinWidth'", EditText.class);
        squareLabelFragment.etFragmentSquareLabelMaxWidth = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_fragment_square_label_maxWidth, "field 'etFragmentSquareLabelMaxWidth'", EditText.class);
        squareLabelFragment.rvFragmentSquareLabel = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_square_label, "field 'rvFragmentSquareLabel'", RecyclerView.class);
        squareLabelFragment.audvFragmentSquareLabel = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_fragment_square_label, "field 'audvFragmentSquareLabel'", AutoNullDisplayView.class);
        squareLabelFragment.srlFragmentSquareLabel = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_fragment_square_label, "field 'srlFragmentSquareLabel'", SmartRefreshLayout.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.tv_fragment_square_label_search, "method 'onSquareLabelSearchClick'");
        this.view17d8 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SquareLabelFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                squareLabelFragment.onSquareLabelSearchClick();
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_fragment_square_label_screen, "method 'onSquareLabelScreenhClick'");
        this.view17d7 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SquareLabelFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                squareLabelFragment.onSquareLabelScreenhClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SquareLabelFragment squareLabelFragment = this.target;
        if (squareLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        squareLabelFragment.etFragmentSquareLabelSearch = null;
        squareLabelFragment.rvFragmentSquareLabelType = null;
        squareLabelFragment.etFragmentSquareLabelMinWidth = null;
        squareLabelFragment.etFragmentSquareLabelMaxWidth = null;
        squareLabelFragment.rvFragmentSquareLabel = null;
        squareLabelFragment.audvFragmentSquareLabel = null;
        squareLabelFragment.srlFragmentSquareLabel = null;
        this.view17d8.setOnClickListener(null);
        this.view17d8 = null;
        this.view17d7.setOnClickListener(null);
        this.view17d7 = null;
    }
}
