package com.appdev.standard.page.printerlabel;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeBarCodeBean;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.util.LanguageUtils;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeBarcodeStyleFragment extends com.library.base.frame.f implements J.a {
    private ElementAttributeBarCodeBean elementAttributeBarCodeBean;

    @BindView(5189)
    ImageView ivAttributeTextStyleBold;

    @BindView(5190)
    ImageView ivAttributeTextStyleCenter;

    @BindView(5191)
    ImageView ivAttributeTextStyleItalic;

    @BindView(5192)
    ImageView ivAttributeTextStyleLeft;

    @BindView(5193)
    ImageView ivAttributeTextStyleRight;

    @BindView(5194)
    ImageView ivAttributeTextStyleStretch;

    @BindView(5195)
    ImageView ivAttributeTextStyleStrikethrough;

    @BindView(5196)
    ImageView ivAttributeTextStyleUnderline;

    @BindView(5201)
    ImageView ivBarcodeStyleLocationBottom;

    @BindView(5202)
    ImageView ivBarcodeStyleLocationGone;

    @BindView(5203)
    ImageView ivBarcodeStyleLocationTop;

    @BindView(5200)
    ImageView ivMore;

    @BindView(5349)
    LinearLayout llBarcodeStyleFont;

    @BindView(5350)
    LinearLayout llBarcodeStyleFontLocation;

    @BindView(5355)
    LinearLayout llBarcodeStyleTextStyle;

    @BindView(5356)
    LinearLayout llBarcodeStyleType;

    @BindView(5351)
    LinearLayout llFormat;

    @BindView(5548)
    LineProgressWidget lpwTextSize;
    private PrinterLabelBarCodeView printerLabelBarCodeView;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5816)
    RecyclerView rvAttributeTextFont;
    private List<TextFontModel> textFontModels;
    private J.b textFontWorker;

    @BindView(6037)
    TextView tvBarcodeStyleFont;

    @BindView(6038)
    TextView tvBarcodeStyleFontLocation;

    @BindView(6040)
    TextView tvBarcodeStyleTextStyle;

    @BindView(6041)
    TextView tvBarcodeStyleType;

    @BindView(6039)
    TextView tvFormat;

    public AttributeBarcodeStyleFragment(BaseControlView baseControlView) {
        this.printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView;
    }

    private void setShowTextLocation(final int i5) {
        if (i5 == 2 || i5 == 1 || i5 == 0) {
            this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.10
                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                public void run() {
                    JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                    AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                    AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setShowText(i5);
                    AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                }
            });
        }
    }

    private void setTextAlignment(final int i5) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.9
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setAligment(i5);
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                int aligment = AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.getAligment();
                if (aligment == 0) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleCenter.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleRight.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStretch.setBackground(null);
                    return;
                }
                if (aligment == 1) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleLeft.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleRight.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStretch.setBackground(null);
                    return;
                }
                if (aligment == 2) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleLeft.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleCenter.setBackground(null);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleRight.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStretch.setBackground(null);
                    return;
                }
                if (aligment != 4) {
                    return;
                }
                AttributeBarcodeStyleFragment.this.ivAttributeTextStyleLeft.setBackground(null);
                AttributeBarcodeStyleFragment.this.ivAttributeTextStyleCenter.setBackground(null);
                AttributeBarcodeStyleFragment.this.ivAttributeTextStyleRight.setBackground(null);
                AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStretch.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            }
        });
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
        p050j.w.c();
        this.quickAdapter.clear();
        this.quickAdapter.addAll(com.bumptech.glide.h.b(getFrameActivity()));
        this.quickAdapter.addAll(list);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        J.b bVar = new J.b(getContext());
        this.textFontWorker = bVar;
        addPresenter(bVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_attribute_text_font) { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, TextFontModel textFontModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_attribute_text_font_content);
                textView.setText(textFontModel.getName());
                if (textFontModel.isSelect()) {
                    textView.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    textView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
            }
        };
        this.rvAttributeTextFont.setLayoutManager(new GridLayoutManager(getContext(), LanguageUtils.isCJKLanguage(getContext()) ? 3 : 2));
        this.rvAttributeTextFont.setAdapter(this.quickAdapter);
        JSONObject json = this.printerLabelBarCodeView.getJson();
        System.out.println(json);
        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
        this.elementAttributeBarCodeBean = elementAttributeBarCodeBean;
        this.lpwTextSize.setPosition(elementAttributeBarCodeBean.getTextSize());
        this.tvFormat.setText(this.elementAttributeBarCodeBean.getBarcodeType());
        int showText = this.elementAttributeBarCodeBean.getShowText();
        if (showText == 0) {
            this.ivBarcodeStyleLocationTop.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            ImageView imageView = this.ivBarcodeStyleLocationBottom;
            int i5 = p113u.c.bg_f8f8f8_rad_6;
            imageView.setBackgroundResource(i5);
            this.ivBarcodeStyleLocationGone.setBackgroundResource(i5);
        } else if (showText == 1) {
            ImageView imageView2 = this.ivBarcodeStyleLocationTop;
            int i6 = p113u.c.bg_f8f8f8_rad_6;
            imageView2.setBackgroundResource(i6);
            this.ivBarcodeStyleLocationBottom.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.ivBarcodeStyleLocationGone.setBackgroundResource(i6);
        } else if (showText == 2) {
            ImageView imageView3 = this.ivBarcodeStyleLocationTop;
            int i7 = p113u.c.bg_f8f8f8_rad_6;
            imageView3.setBackgroundResource(i7);
            this.ivBarcodeStyleLocationBottom.setBackgroundResource(i7);
            this.ivBarcodeStyleLocationGone.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        if (this.elementAttributeBarCodeBean.isBold()) {
            this.ivAttributeTextStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleBold.setBackground(null);
        }
        if (this.elementAttributeBarCodeBean.isItalic()) {
            this.ivAttributeTextStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleItalic.setBackground(null);
        }
        if (this.elementAttributeBarCodeBean.isUnderLine()) {
            this.ivAttributeTextStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleUnderline.setBackground(null);
        }
        if (this.elementAttributeBarCodeBean.isDeleteLine()) {
            this.ivAttributeTextStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivAttributeTextStyleStrikethrough.setBackground(null);
        }
        int aligment = this.elementAttributeBarCodeBean.getAligment();
        if (aligment == 0) {
            this.ivAttributeTextStyleLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
            this.ivAttributeTextStyleStretch.setBackground(null);
        } else if (aligment == 1) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleRight.setBackground(null);
            this.ivAttributeTextStyleStretch.setBackground(null);
        } else if (aligment == 2) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
            this.ivAttributeTextStyleStretch.setBackground(null);
        } else if (aligment == 4) {
            this.ivAttributeTextStyleLeft.setBackground(null);
            this.ivAttributeTextStyleCenter.setBackground(null);
            this.ivAttributeTextStyleRight.setBackground(null);
            this.ivAttributeTextStyleStretch.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        }
        List<TextFontModel> list = (List) Hawk.get("FONT_LIB_DATA", null);
        this.textFontModels = list;
        if (list == null) {
            p050j.w.e();
            this.textFontWorker.a();
            return;
        }
        this.quickAdapter.clear();
        this.quickAdapter.addAll(com.bumptech.glide.h.b(getFrameActivity()));
        this.quickAdapter.addAll(this.textFontModels);
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            TextFontModel textFontModel = (TextFontModel) it.next();
            if (textFontModel.getFontlibId().equals(String.valueOf(this.elementAttributeBarCodeBean.getFontType()))) {
                textFontModel.setSelect(true);
                this.quickAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_barcode_style;
    }

    @OnClick({6037})
    public void onBarcodeStyleFontClick(View view) {
        this.llBarcodeStyleType.setVisibility(8);
        this.llBarcodeStyleFont.setVisibility(0);
        this.llBarcodeStyleFontLocation.setVisibility(8);
        this.llBarcodeStyleTextStyle.setVisibility(8);
        TextView textView = this.tvBarcodeStyleType;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvBarcodeStyleFont.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvBarcodeStyleFontLocation.setTextColor(getResources().getColor(i5));
        this.tvBarcodeStyleTextStyle.setTextColor(getResources().getColor(i5));
    }

    @OnClick({6038})
    public void onBarcodeStyleFontLocationClick(View view) {
        this.llBarcodeStyleType.setVisibility(8);
        this.llBarcodeStyleFont.setVisibility(8);
        this.llBarcodeStyleFontLocation.setVisibility(0);
        this.llBarcodeStyleTextStyle.setVisibility(8);
        TextView textView = this.tvBarcodeStyleType;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvBarcodeStyleFont.setTextColor(getResources().getColor(i5));
        this.tvBarcodeStyleFontLocation.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvBarcodeStyleTextStyle.setTextColor(getResources().getColor(i5));
    }

    @OnClick({6040})
    public void onBarcodeStyleTextStyleClick(View view) {
        this.llBarcodeStyleType.setVisibility(8);
        this.llBarcodeStyleFont.setVisibility(8);
        this.llBarcodeStyleFontLocation.setVisibility(8);
        this.llBarcodeStyleTextStyle.setVisibility(0);
        TextView textView = this.tvBarcodeStyleType;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvBarcodeStyleFont.setTextColor(getResources().getColor(i5));
        this.tvBarcodeStyleFontLocation.setTextColor(getResources().getColor(i5));
        this.tvBarcodeStyleTextStyle.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
    }

    @OnClick({6041})
    public void onBarcodeStyleTypeClick(View view) {
        this.llBarcodeStyleType.setVisibility(0);
        this.llBarcodeStyleFont.setVisibility(8);
        this.llBarcodeStyleFontLocation.setVisibility(8);
        this.llBarcodeStyleTextStyle.setVisibility(8);
        this.tvBarcodeStyleType.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        TextView textView = this.tvBarcodeStyleFont;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvBarcodeStyleFontLocation.setTextColor(getResources().getColor(i5));
        this.tvBarcodeStyleTextStyle.setTextColor(getResources().getColor(i5));
    }

    @OnClick({5189})
    public void onBoldClick(View view) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.5
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson().toString());
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setBold(!AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isBold());
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                if (AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isBold()) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleBold.setBackground(null);
                }
            }
        });
    }

    @OnClick({5190})
    public void onCenterClick(View view) {
        setTextAlignment(1);
    }

    @OnClick({5351})
    public void onFormatClick(View view) {
        p097r0.a aVar = new p097r0.a(getContext(), new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.4
            @Override // p109t0.a
            public void onOptionsSelect(final int i5, int i6, int i7, View view2) {
                AttributeBarcodeStyleFragment.this.tvFormat.setText((CharSequence) p051j0.a.f().get(i5));
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setBarcodeType((String) p051j0.a.f().get(i5));
                        AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        });
        aVar.f7931a.f8190k = getString(p113u.g.text_285);
        aVar.f7931a.f8188i = getString(p113u.g.confirm);
        String string = getResources().getString(p113u.g.cancel);
        p103s0.a aVar2 = aVar.f7931a;
        aVar2.f8189j = string;
        aVar2.f8192m = 14;
        aVar2.f8191l = 14;
        p114u0.d dVarA = aVar.a();
        dVarA.e(p051j0.a.f(), null);
        dVarA.h();
    }

    @OnClick({5191})
    public void onItalicClick(View view) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.6
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson().toString());
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setItalic(!AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isItalic());
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                if (AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isItalic()) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleItalic.setBackground(null);
                }
            }
        });
    }

    @OnClick({5192})
    public void onLeftClick(View view) {
        setTextAlignment(0);
    }

    @OnClick({5352})
    public void onLocationBottomClick(View view) {
        setShowTextLocation(1);
        ImageView imageView = this.ivBarcodeStyleLocationTop;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivBarcodeStyleLocationBottom.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        this.ivBarcodeStyleLocationGone.setBackgroundResource(i5);
    }

    @OnClick({5353})
    public void onLocationGoneClick(View view) {
        setShowTextLocation(2);
        ImageView imageView = this.ivBarcodeStyleLocationTop;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivBarcodeStyleLocationBottom.setBackgroundResource(i5);
        this.ivBarcodeStyleLocationGone.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
    }

    @OnClick({5354})
    public void onLocationTopClick(View view) {
        setShowTextLocation(0);
        this.ivBarcodeStyleLocationTop.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        ImageView imageView = this.ivBarcodeStyleLocationBottom;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivBarcodeStyleLocationGone.setBackgroundResource(i5);
    }

    @OnClick({5193})
    public void onRightClick(View view) {
        setTextAlignment(2);
    }

    @OnClick({5194})
    public void onStretchClick(View view) {
        setTextAlignment(4);
    }

    @OnClick({5195})
    public void onStrikethroughClick(View view) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.8
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson().toString());
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setDeleteLine(!AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isDeleteLine());
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                if (AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isDeleteLine()) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleStrikethrough.setBackground(null);
                }
            }
        });
    }

    @OnClick({5196})
    public void onUnderlineClick(View view) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.7
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson().toString());
                AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setUnderLine(!AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isUnderLine());
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                if (AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.isUnderLine()) {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeBarcodeStyleFragment.this.ivAttributeTextStyleUnderline.setBackground(null);
                }
            }
        });
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.lpwTextSize.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setTextSize(f6);
                        AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, final int i5) {
                final TextFontModel textFontModel = (TextFontModel) AttributeBarcodeStyleFragment.this.quickAdapter.getItem(i5);
                if (textFontModel.getFontlibId().equals("0") || textFontModel.getFontlibId().equals("-10001") || textFontModel.getFontlibId().equals("-10002") || textFontModel.getFontlibId().equals("-10003") || textFontModel.getFontlibId().equals("-10004") || textFontModel.getFontlibId().equals("-10005") || textFontModel.getFontlibId().equals("-10006")) {
                    AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.3.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                            AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                            AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setFontType(textFontModel.getFontlibId());
                            AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                        }
                    });
                    Iterator<Object> it = AttributeBarcodeStyleFragment.this.quickAdapter.getData().iterator();
                    while (it.hasNext()) {
                        ((TextFontModel) it.next()).setSelect(false);
                    }
                    ((TextFontModel) AttributeBarcodeStyleFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                    AttributeBarcodeStyleFragment.this.quickAdapter.notifyDataSetChanged();
                    return;
                }
                String str = AttributeBarcodeStyleFragment.this.getFrameActivity().getCacheDir().getAbsolutePath() + "/fontData/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (new File(androidx.collection.a.o(str, textFontModel.getFontlibId(), ".ttf")).exists()) {
                    AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment.3.2
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.getJson();
                            AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                            AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.setFontType(textFontModel.getFontlibId());
                            AttributeBarcodeStyleFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeStyleFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                            Iterator<Object> it2 = AttributeBarcodeStyleFragment.this.quickAdapter.getData().iterator();
                            while (it2.hasNext()) {
                                ((TextFontModel) it2.next()).setSelect(false);
                            }
                            ((TextFontModel) AttributeBarcodeStyleFragment.this.quickAdapter.getItem(i5)).setSelect(true);
                            AttributeBarcodeStyleFragment.this.quickAdapter.notifyDataSetChanged();
                        }
                    });
                    return;
                }
                com.appdev.standard.util.fileDownload.g.b().a(new File(androidx.collection.a.o(str, textFontModel.getFontlibId(), ".ttf")), textFontModel.getFileUrl());
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }
}
