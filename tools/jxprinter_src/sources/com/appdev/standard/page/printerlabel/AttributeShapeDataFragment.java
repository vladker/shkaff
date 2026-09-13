package com.appdev.standard.page.printerlabel;

import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeShapeBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelShapeView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeShapeDataFragment extends com.library.base.frame.f {
    private ElementAttributeShapeBean elementAttributeShapeBean;

    @BindView(5298)
    ImageView ivShapeTypeRectangle;

    @BindView(5299)
    ImageView ivShapeTypeRoundness;

    @BindView(5300)
    ImageView ivShapeTypeTriangle;
    private PrinterLabelShapeView printerLabelShapeView;

    public AttributeShapeDataFragment(BaseControlView baseControlView) {
        this.printerLabelShapeView = (PrinterLabelShapeView) baseControlView;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        JSONObject json = this.printerLabelShapeView.getJson();
        System.out.println(json);
        ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
        this.elementAttributeShapeBean = elementAttributeShapeBean;
        int itemSubType = elementAttributeShapeBean.getItemSubType();
        if (itemSubType == 5) {
            this.ivShapeTypeRectangle.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            ImageView imageView = this.ivShapeTypeRoundness;
            int i5 = p113u.c.bg_f8f8f8_rad_6;
            imageView.setBackgroundResource(i5);
            this.ivShapeTypeTriangle.setBackgroundResource(i5);
            return;
        }
        if (itemSubType == 6) {
            ImageView imageView2 = this.ivShapeTypeRectangle;
            int i6 = p113u.c.bg_f8f8f8_rad_6;
            imageView2.setBackgroundResource(i6);
            this.ivShapeTypeRoundness.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.ivShapeTypeTriangle.setBackgroundResource(i6);
            return;
        }
        if (itemSubType != 7) {
            return;
        }
        ImageView imageView3 = this.ivShapeTypeRectangle;
        int i7 = p113u.c.bg_f8f8f8_rad_6;
        imageView3.setBackgroundResource(i7);
        this.ivShapeTypeRoundness.setBackgroundResource(i7);
        this.ivShapeTypeTriangle.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_shape_data;
    }

    @OnClick({5501})
    public void onShapeTypeRectangleClick() {
        JSONObject json = this.printerLabelShapeView.getJson();
        System.out.println(json);
        this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
        this.ivShapeTypeRectangle.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        ImageView imageView = this.ivShapeTypeRoundness;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivShapeTypeTriangle.setBackgroundResource(i5);
        this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json2 = AttributeShapeDataFragment.this.printerLabelShapeView.getJson();
                AttributeShapeDataFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json2.toString());
                AttributeShapeDataFragment.this.elementAttributeShapeBean.setItemSubType(5);
                AttributeShapeDataFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeDataFragment.this.elementAttributeShapeBean.ObjectToJson());
            }
        });
    }

    @OnClick({5502})
    public void onShapeTypeRoundnessClick() {
        JSONObject json = this.printerLabelShapeView.getJson();
        System.out.println(json);
        this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
        ImageView imageView = this.ivShapeTypeRectangle;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivShapeTypeRoundness.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        this.ivShapeTypeTriangle.setBackgroundResource(i5);
        this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json2 = AttributeShapeDataFragment.this.printerLabelShapeView.getJson();
                AttributeShapeDataFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json2.toString());
                AttributeShapeDataFragment.this.elementAttributeShapeBean.setItemSubType(6);
                AttributeShapeDataFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeDataFragment.this.elementAttributeShapeBean.ObjectToJson());
            }
        });
    }

    @OnClick({5503})
    public void onShapeTypeTriangleClick() {
        JSONObject json = this.printerLabelShapeView.getJson();
        System.out.println(json);
        this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
        ImageView imageView = this.ivShapeTypeRectangle;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        this.ivShapeTypeRoundness.setBackgroundResource(i5);
        this.ivShapeTypeTriangle.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        this.printerLabelShapeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeShapeDataFragment.3
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json2 = AttributeShapeDataFragment.this.printerLabelShapeView.getJson();
                AttributeShapeDataFragment.this.elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json2.toString());
                AttributeShapeDataFragment.this.elementAttributeShapeBean.setItemSubType(7);
                AttributeShapeDataFragment.this.printerLabelShapeView.recoverFromJson(AttributeShapeDataFragment.this.elementAttributeShapeBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
