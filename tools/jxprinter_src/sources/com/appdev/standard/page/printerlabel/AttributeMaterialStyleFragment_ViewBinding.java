package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeMaterialStyleFragment_ViewBinding implements Unbinder {
    private AttributeMaterialStyleFragment target;
    private View view1812;
    private View view1813;
    private View view1814;

    @UiThread
    public AttributeMaterialStyleFragment_ViewBinding(final AttributeMaterialStyleFragment attributeMaterialStyleFragment, View view) {
        this.target = attributeMaterialStyleFragment;
        int i5 = p113u.d.tv_material_style_original;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvMaterialStyleOriginal' and method 'onMaterialStyleOriginalClick'");
        attributeMaterialStyleFragment.tvMaterialStyleOriginal = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvMaterialStyleOriginal'", TextView.class);
        this.view1813 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeMaterialStyleFragment.onMaterialStyleOriginalClick(view2);
            }
        });
        int i6 = p113u.d.tv_material_style_shake;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvMaterialStyleShake' and method 'onMaterialStyleShakeClick'");
        attributeMaterialStyleFragment.tvMaterialStyleShake = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvMaterialStyleShake'", TextView.class);
        this.view1814 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeMaterialStyleFragment.onMaterialStyleShakeClick(view2);
            }
        });
        int i7 = p113u.d.tv_material_style_binary;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvMaterialStyleBinary' and method 'onMaterialStyleBinaryClick'");
        attributeMaterialStyleFragment.tvMaterialStyleBinary = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvMaterialStyleBinary'", TextView.class);
        this.view1812 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeMaterialStyleFragment.onMaterialStyleBinaryClick(view2);
            }
        });
        attributeMaterialStyleFragment.llMaterialStyleOriginal = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_material_style_original, "field 'llMaterialStyleOriginal'", LinearLayout.class);
        attributeMaterialStyleFragment.llMaterialStyleShake = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_material_style_shake, "field 'llMaterialStyleShake'", LinearLayout.class);
        attributeMaterialStyleFragment.llMaterialStyleBinary = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_material_style_binary, "field 'llMaterialStyleBinary'", LinearLayout.class);
        attributeMaterialStyleFragment.lpwPictureBrightnessOriginal = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_brightness_original, "field 'lpwPictureBrightnessOriginal'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureContrastOriginal = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_contrast_original, "field 'lpwPictureContrastOriginal'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureSaturationOriginal = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_saturation_original, "field 'lpwPictureSaturationOriginal'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureBrightnessShake = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_brightness_shake, "field 'lpwPictureBrightnessShake'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureContrastShake = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_contrast_shake, "field 'lpwPictureContrastShake'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureSaturationShake = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_saturation_shake, "field 'lpwPictureSaturationShake'", LineProgressWidget.class);
        attributeMaterialStyleFragment.lpwPictureBrightnessBinary = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_picture_brightness_binary, "field 'lpwPictureBrightnessBinary'", LineProgressWidget.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeMaterialStyleFragment attributeMaterialStyleFragment = this.target;
        if (attributeMaterialStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeMaterialStyleFragment.tvMaterialStyleOriginal = null;
        attributeMaterialStyleFragment.tvMaterialStyleShake = null;
        attributeMaterialStyleFragment.tvMaterialStyleBinary = null;
        attributeMaterialStyleFragment.llMaterialStyleOriginal = null;
        attributeMaterialStyleFragment.llMaterialStyleShake = null;
        attributeMaterialStyleFragment.llMaterialStyleBinary = null;
        attributeMaterialStyleFragment.lpwPictureBrightnessOriginal = null;
        attributeMaterialStyleFragment.lpwPictureContrastOriginal = null;
        attributeMaterialStyleFragment.lpwPictureSaturationOriginal = null;
        attributeMaterialStyleFragment.lpwPictureBrightnessShake = null;
        attributeMaterialStyleFragment.lpwPictureContrastShake = null;
        attributeMaterialStyleFragment.lpwPictureSaturationShake = null;
        attributeMaterialStyleFragment.lpwPictureBrightnessBinary = null;
        this.view1813.setOnClickListener(null);
        this.view1813 = null;
        this.view1814.setOnClickListener(null);
        this.view1814 = null;
        this.view1812.setOnClickListener(null);
        this.view1812 = null;
    }
}
