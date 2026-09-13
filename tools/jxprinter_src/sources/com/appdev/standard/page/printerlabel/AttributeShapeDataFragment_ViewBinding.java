package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeShapeDataFragment_ViewBinding implements Unbinder {
    private AttributeShapeDataFragment target;
    private View view157d;
    private View view157e;
    private View view157f;

    @UiThread
    public AttributeShapeDataFragment_ViewBinding(final AttributeShapeDataFragment attributeShapeDataFragment, View view) {
        this.target = attributeShapeDataFragment;
        attributeShapeDataFragment.ivShapeTypeRectangle = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_shape_type_rectangle, "field 'ivShapeTypeRectangle'", ImageView.class);
        attributeShapeDataFragment.ivShapeTypeRoundness = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_shape_type_roundness, "field 'ivShapeTypeRoundness'", ImageView.class);
        attributeShapeDataFragment.ivShapeTypeTriangle = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_shape_type_triangle, "field 'ivShapeTypeTriangle'", ImageView.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.ll_shape_type_rectangle, "method 'onShapeTypeRectangleClick'");
        this.view157d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeShapeDataFragment.onShapeTypeRectangleClick();
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_shape_type_roundness, "method 'onShapeTypeRoundnessClick'");
        this.view157e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeShapeDataFragment.onShapeTypeRoundnessClick();
            }
        });
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_shape_type_triangle, "method 'onShapeTypeTriangleClick'");
        this.view157f = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeShapeDataFragment.onShapeTypeTriangleClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeShapeDataFragment attributeShapeDataFragment = this.target;
        if (attributeShapeDataFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeShapeDataFragment.ivShapeTypeRectangle = null;
        attributeShapeDataFragment.ivShapeTypeRoundness = null;
        attributeShapeDataFragment.ivShapeTypeTriangle = null;
        this.view157d.setOnClickListener(null);
        this.view157d = null;
        this.view157e.setOnClickListener(null);
        this.view157e = null;
        this.view157f.setOnClickListener(null);
        this.view157f = null;
    }
}
