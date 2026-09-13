package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeShapeBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelShapeView;
import com.appdev.standard.page.printerlabel.widget.TextImageViewWidget;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeShapeStyleFragment extends com.library.base.frame.f {
    private ElementAttributeShapeBean elementAttributeShapeBean;

    @BindView(5327)
    ImageView ivLineStyle1;

    @BindView(5328)
    ImageView ivLineStyle2;

    @BindView(5329)
    ImageView ivLineStyle3;

    @BindView(5330)
    ImageView ivLineStyle4;

    @BindView(5523)
    LineProgressWidget lpwLineWidth;

    @BindView(5538)
    LineProgressWidget lpwRectCorner;
    private PrinterLabelShapeView printerLabelShapeView;

    @BindView(5986)
    TextImageViewWidget tivIsFill;

    public AttributeShapeStyleFragment(BaseControlView baseControlView) {
        this.printerLabelShapeView = (PrinterLabelShapeView) baseControlView;
    }

    private void setLineStyle(final int i5) {
        this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.4
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeShapeStyleFragment.this.printerLabelShapeView.getJson();
                AttributeShapeStyleFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                AttributeShapeStyleFragment.this.elementAttributeShapeBean.setLineStyleIndex(i5);
                AttributeShapeStyleFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeStyleFragment.this.elementAttributeShapeBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, this.printerLabelShapeView.getJson().toString());
        this.elementAttributeShapeBean = elementAttributeShapeBean;
        this.lpwLineWidth.setPosition(elementAttributeShapeBean.getLineBoldSize());
        this.tivIsFill.setSwitchState(this.elementAttributeShapeBean.isFill());
        this.lpwRectCorner.setPosition(this.elementAttributeShapeBean.getRectCorner());
        int lineStyleIndex = this.elementAttributeShapeBean.getLineStyleIndex();
        if (lineStyleIndex == 1) {
            this.ivLineStyle1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            ImageView imageView = this.ivLineStyle2;
            int i5 = p113u.c.bg_f8f8f8_rad_6;
            imageView.setBackgroundResource(i5);
            this.ivLineStyle3.setBackgroundResource(i5);
            this.ivLineStyle4.setBackgroundResource(i5);
            return;
        }
        if (lineStyleIndex == 2) {
            ImageView imageView2 = this.ivLineStyle1;
            int i6 = p113u.c.bg_f8f8f8_rad_6;
            imageView2.setBackgroundResource(i6);
            this.ivLineStyle2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.ivLineStyle3.setBackgroundResource(i6);
            this.ivLineStyle4.setBackgroundResource(i6);
            return;
        }
        if (lineStyleIndex == 3) {
            ImageView imageView3 = this.ivLineStyle1;
            int i7 = p113u.c.bg_f8f8f8_rad_6;
            imageView3.setBackgroundResource(i7);
            this.ivLineStyle2.setBackgroundResource(i7);
            this.ivLineStyle3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.ivLineStyle4.setBackgroundResource(i7);
            return;
        }
        if (lineStyleIndex != 4) {
            return;
        }
        ImageView imageView4 = this.ivLineStyle1;
        int i8 = p113u.c.bg_f8f8f8_rad_6;
        imageView4.setBackgroundResource(i8);
        this.ivLineStyle2.setBackgroundResource(i8);
        this.ivLineStyle3.setBackgroundResource(i8);
        this.ivLineStyle4.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_shape_style;
    }

    @OnClick({5327})
    public void onLineStyle1Click(View view) {
        setLineStyle(1);
        this.ivLineStyle1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        ImageView imageView = this.ivLineStyle2;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivLineStyle3.setBackgroundResource(i5);
        this.ivLineStyle4.setBackgroundResource(i5);
    }

    @OnClick({5328})
    public void onLineStyle2Click(View view) {
        setLineStyle(2);
        ImageView imageView = this.ivLineStyle1;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivLineStyle2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        this.ivLineStyle3.setBackgroundResource(i5);
        this.ivLineStyle4.setBackgroundResource(i5);
    }

    @OnClick({5329})
    public void onLineStyle3Click(View view) {
        setLineStyle(3);
        ImageView imageView = this.ivLineStyle1;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivLineStyle2.setBackgroundResource(i5);
        this.ivLineStyle3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        this.ivLineStyle4.setBackgroundResource(i5);
    }

    @OnClick({5330})
    public void onLineStyle4Click(View view) {
        setLineStyle(4);
        ImageView imageView = this.ivLineStyle1;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivLineStyle2.setBackgroundResource(i5);
        this.ivLineStyle3.setBackgroundResource(i5);
        this.ivLineStyle4.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.lpwLineWidth.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeShapeStyleFragment.this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.1.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeShapeStyleFragment.this.printerLabelShapeView.getJson();
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean.setLineBoldSize(f6);
                        AttributeShapeStyleFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeStyleFragment.this.elementAttributeShapeBean.ObjectToJson());
                    }
                });
            }
        });
        this.lpwRectCorner.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeShapeStyleFragment.this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeShapeStyleFragment.this.printerLabelShapeView.getJson();
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean.setRectCorner((int) f6);
                        AttributeShapeStyleFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeStyleFragment.this.elementAttributeShapeBean.ObjectToJson());
                    }
                });
            }
        });
        this.tivIsFill.setOnSwitchClickListener(new TextImageViewWidget.OnSwitchClickListener() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.3
            @Override // com.appdev.standard.page.printerlabel.widget.TextImageViewWidget.OnSwitchClickListener
            public void callBack(final boolean z6) {
                AttributeShapeStyleFragment.this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeStyleFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeShapeStyleFragment.this.printerLabelShapeView.getJson();
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                        AttributeShapeStyleFragment.this.elementAttributeShapeBean.setFill(z6);
                        AttributeShapeStyleFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeStyleFragment.this.elementAttributeShapeBean.ObjectToJson());
                    }
                });
            }
        });
    }
}
