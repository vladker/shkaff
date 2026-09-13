package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeLineBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelLineView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeLineStyleFragment extends com.library.base.frame.f {
    private ElementAttributeLineBean elementAttributeLineBean;

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
    private PrinterLabelLineView printerLabelLineView;

    public AttributeLineStyleFragment(BaseControlView baseControlView) {
        this.printerLabelLineView = (PrinterLabelLineView) baseControlView;
    }

    private void setLineStyle(final int i5) {
        this.printerLabelLineView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeLineStyleFragment.this.printerLabelLineView.getJson();
                AttributeLineStyleFragment.this.elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                AttributeLineStyleFragment.this.elementAttributeLineBean.setLineStyleIndex(i5);
                AttributeLineStyleFragment.this.printerLabelLineView.recoverFromJson(AttributeLineStyleFragment.this.elementAttributeLineBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        ElementAttributeLineBean elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, this.printerLabelLineView.getJson().toString());
        this.elementAttributeLineBean = elementAttributeLineBean;
        this.lpwLineWidth.setPosition(elementAttributeLineBean.getLineSize());
        int lineStyleIndex = this.elementAttributeLineBean.getLineStyleIndex();
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
        return p113u.e.fragment_attribute_line_style;
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
        this.lpwLineWidth.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeLineStyleFragment.this.printerLabelLineView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment.1.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeLineStyleFragment.this.printerLabelLineView.getJson();
                        AttributeLineStyleFragment.this.elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                        AttributeLineStyleFragment.this.elementAttributeLineBean.setLineSize(f6);
                        AttributeLineStyleFragment.this.printerLabelLineView.recoverFromJson(AttributeLineStyleFragment.this.elementAttributeLineBean.ObjectToJson());
                    }
                });
            }
        });
    }
}
