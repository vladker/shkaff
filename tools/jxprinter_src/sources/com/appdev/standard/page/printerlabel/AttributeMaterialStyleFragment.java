package com.appdev.standard.page.printerlabel;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributePictureBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeMaterialStyleFragment extends com.library.base.frame.f {
    private ElementAttributePictureBean elementAttributePictureBean;

    @BindView(5417)
    LinearLayout llMaterialStyleBinary;

    @BindView(5419)
    LinearLayout llMaterialStyleOriginal;

    @BindView(5420)
    LinearLayout llMaterialStyleShake;

    @BindView(5525)
    LineProgressWidget lpwPictureBrightnessBinary;

    @BindView(5526)
    LineProgressWidget lpwPictureBrightnessOriginal;

    @BindView(5527)
    LineProgressWidget lpwPictureBrightnessShake;

    @BindView(5529)
    LineProgressWidget lpwPictureContrastOriginal;

    @BindView(5530)
    LineProgressWidget lpwPictureContrastShake;

    @BindView(5533)
    LineProgressWidget lpwPictureSaturationOriginal;

    @BindView(5534)
    LineProgressWidget lpwPictureSaturationShake;
    private PrinterLabelPictureView printerLabelPictureView;

    @BindView(6162)
    TextView tvMaterialStyleBinary;

    @BindView(6163)
    TextView tvMaterialStyleOriginal;

    @BindView(6164)
    TextView tvMaterialStyleShake;

    public AttributeMaterialStyleFragment(BaseControlView baseControlView) {
        this.printerLabelPictureView = (PrinterLabelPictureView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupBinaryModeListeners$6(float f6) {
        this.printerLabelPictureView.updateBrightness((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupOriginalModeListeners$0(float f6) {
        this.printerLabelPictureView.updateBrightness((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupOriginalModeListeners$1(float f6) {
        this.printerLabelPictureView.updateContrast((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupOriginalModeListeners$2(float f6) {
        this.printerLabelPictureView.updateSaturation((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupShakeModeListeners$3(float f6) {
        this.printerLabelPictureView.updateBrightness((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupShakeModeListeners$4(float f6) {
        this.printerLabelPictureView.updateContrast((int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupShakeModeListeners$5(float f6) {
        this.printerLabelPictureView.updateSaturation((int) f6);
    }

    private void setupBinaryModeListeners() {
        this.lpwPictureBrightnessBinary.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.7
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.7.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setBrightness((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureBrightnessBinary.setOnRangeListener(new C0471c(this, 0));
    }

    private void setupOriginalModeListeners() {
        this.lpwPictureBrightnessOriginal.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.1.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setBrightness((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureBrightnessOriginal.setOnRangeListener(new C0471c(this, 4));
        this.lpwPictureContrastOriginal.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setContrast((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureContrastOriginal.setOnRangeListener(new C0471c(this, 5));
        this.lpwPictureSaturationOriginal.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.3
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setSaturation((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureSaturationOriginal.setOnRangeListener(new C0471c(this, 6));
    }

    private void setupShakeModeListeners() {
        this.lpwPictureBrightnessShake.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.4
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setBrightness((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureBrightnessShake.setOnRangeListener(new C0471c(this, 1));
        this.lpwPictureContrastShake.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.5
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setContrast((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureContrastShake.setOnRangeListener(new C0471c(this, 2));
        this.lpwPictureSaturationShake.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.6
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeMaterialStyleFragment.this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.6.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                        AttributeMaterialStyleFragment.this.elementAttributePictureBean.setSaturation((int) f6);
                        AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwPictureSaturationShake.setOnRangeListener(new C0471c(this, 3));
    }

    private void showBinaryMode() {
        this.llMaterialStyleOriginal.setVisibility(8);
        TextView textView = this.tvMaterialStyleOriginal;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.llMaterialStyleShake.setVisibility(8);
        this.tvMaterialStyleShake.setTextColor(getResources().getColor(i5));
        this.llMaterialStyleBinary.setVisibility(0);
        this.tvMaterialStyleBinary.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
    }

    private void showOriginalMode() {
        this.llMaterialStyleOriginal.setVisibility(0);
        this.tvMaterialStyleOriginal.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.llMaterialStyleShake.setVisibility(8);
        TextView textView = this.tvMaterialStyleShake;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.llMaterialStyleBinary.setVisibility(8);
        this.tvMaterialStyleBinary.setTextColor(getResources().getColor(i5));
    }

    private void showShakeMode() {
        this.llMaterialStyleOriginal.setVisibility(8);
        TextView textView = this.tvMaterialStyleOriginal;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.llMaterialStyleShake.setVisibility(0);
        this.tvMaterialStyleShake.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.llMaterialStyleBinary.setVisibility(8);
        this.tvMaterialStyleBinary.setTextColor(getResources().getColor(i5));
    }

    private void updateImageDisplayMode(final int i5) {
        this.printerLabelPictureView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeMaterialStyleFragment.8
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeMaterialStyleFragment.this.printerLabelPictureView.getJson();
                AttributeMaterialStyleFragment.this.elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
                AttributeMaterialStyleFragment.this.elementAttributePictureBean.setImageDisplayMode(i5);
                AttributeMaterialStyleFragment.this.printerLabelPictureView.recoverFromJson(AttributeMaterialStyleFragment.this.elementAttributePictureBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        JSONObject json = this.printerLabelPictureView.getJson();
        System.out.println(json);
        ElementAttributePictureBean elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, json.toString());
        this.elementAttributePictureBean = elementAttributePictureBean;
        this.lpwPictureBrightnessOriginal.setPosition(elementAttributePictureBean.getBrightness());
        this.lpwPictureContrastOriginal.setPosition(this.elementAttributePictureBean.getContrast());
        this.lpwPictureSaturationOriginal.setPosition(this.elementAttributePictureBean.getSaturation());
        this.lpwPictureBrightnessShake.setPosition(this.elementAttributePictureBean.getBrightness());
        this.lpwPictureContrastShake.setPosition(this.elementAttributePictureBean.getContrast());
        this.lpwPictureSaturationShake.setPosition(this.elementAttributePictureBean.getSaturation());
        this.lpwPictureBrightnessBinary.setPosition(this.elementAttributePictureBean.getBrightness());
        setupOriginalModeListeners();
        setupShakeModeListeners();
        setupBinaryModeListeners();
        int imageDisplayMode = this.elementAttributePictureBean.getImageDisplayMode();
        if (imageDisplayMode == 0) {
            showOriginalMode();
            return;
        }
        if (imageDisplayMode == 1) {
            showShakeMode();
        } else if (imageDisplayMode != 2) {
            showShakeMode();
        } else {
            showBinaryMode();
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_material_style;
    }

    @OnClick({6162})
    public void onMaterialStyleBinaryClick(View view) {
        showBinaryMode();
        updateImageDisplayMode(2);
    }

    @OnClick({6163})
    public void onMaterialStyleOriginalClick(View view) {
        showOriginalMode();
        updateImageDisplayMode(0);
    }

    @OnClick({6164})
    public void onMaterialStyleShakeClick(View view) {
        showShakeMode();
        updateImageDisplayMode(1);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
