package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.model.ElementAttributeTimeBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTimeView;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeStyleFragment extends com.library.base.frame.f {
    private ElementAttributeTimeBean elementAttributeTimeBean;

    @BindView(5549)
    ImageView ivTimeStyleBold;

    @BindView(5550)
    ImageView ivTimeStyleItalic;

    @BindView(5551)
    ImageView ivTimeStyleStrikethrough;

    @BindView(5552)
    ImageView ivTimeStyleUnderline;

    @BindView(5548)
    LineProgressWidget lpwTextSize;
    private PrinterLabelTimeView printerLabelTimeView;

    public AttributeTimeStyleFragment(BaseControlView baseControlView) {
        this.printerLabelTimeView = (PrinterLabelTimeView) baseControlView;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, this.printerLabelTimeView.getJson().toString());
        this.elementAttributeTimeBean = elementAttributeTimeBean;
        this.lpwTextSize.setPosition(elementAttributeTimeBean.getTextSize() / 10.0f);
        if (this.elementAttributeTimeBean.isBold()) {
            this.ivTimeStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivTimeStyleBold.setBackground(null);
        }
        if (this.elementAttributeTimeBean.isItalic()) {
            this.ivTimeStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivTimeStyleItalic.setBackground(null);
        }
        if (this.elementAttributeTimeBean.isUnderline()) {
            this.ivTimeStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivTimeStyleUnderline.setBackground(null);
        }
        if (this.elementAttributeTimeBean.isStrikethrough()) {
            this.ivTimeStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
        } else {
            this.ivTimeStyleStrikethrough.setBackground(null);
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_time_style;
    }

    @OnClick({5549})
    public void onBoldClick(View view) {
        this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeTimeStyleFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, AttributeTimeStyleFragment.this.printerLabelTimeView.getJson().toString());
                AttributeTimeStyleFragment.this.elementAttributeTimeBean.setBold(!AttributeTimeStyleFragment.this.elementAttributeTimeBean.isBold());
                AttributeTimeStyleFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeStyleFragment.this.elementAttributeTimeBean.ObjectToJson());
                if (AttributeTimeStyleFragment.this.elementAttributeTimeBean.isBold()) {
                    AttributeTimeStyleFragment.this.ivTimeStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeTimeStyleFragment.this.ivTimeStyleBold.setBackground(null);
                }
            }
        });
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onControlViewEditEvent(p137y.f fVar) {
        JSONObject json = this.printerLabelTimeView.getJson();
        this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
        p051j0.a.c("JSON_DEBUG", "事件同步数据: " + json.toString());
    }

    @OnClick({5550})
    public void onItalicClick(View view) {
        this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.3
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeTimeStyleFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, AttributeTimeStyleFragment.this.printerLabelTimeView.getJson().toString());
                AttributeTimeStyleFragment.this.elementAttributeTimeBean.setItalic(!AttributeTimeStyleFragment.this.elementAttributeTimeBean.isItalic());
                AttributeTimeStyleFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeStyleFragment.this.elementAttributeTimeBean.ObjectToJson());
                if (AttributeTimeStyleFragment.this.elementAttributeTimeBean.isItalic()) {
                    AttributeTimeStyleFragment.this.ivTimeStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeTimeStyleFragment.this.ivTimeStyleItalic.setBackground(null);
                }
            }
        });
    }

    @OnClick({5551})
    public void onStrikethroughClick(View view) {
        this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.5
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeTimeStyleFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, AttributeTimeStyleFragment.this.printerLabelTimeView.getJson().toString());
                AttributeTimeStyleFragment.this.elementAttributeTimeBean.setStrikethrough(!AttributeTimeStyleFragment.this.elementAttributeTimeBean.isStrikethrough());
                AttributeTimeStyleFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeStyleFragment.this.elementAttributeTimeBean.ObjectToJson());
                if (AttributeTimeStyleFragment.this.elementAttributeTimeBean.isStrikethrough()) {
                    AttributeTimeStyleFragment.this.ivTimeStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeTimeStyleFragment.this.ivTimeStyleStrikethrough.setBackground(null);
                }
            }
        });
    }

    @OnClick({5552})
    public void onUnderlineClick(View view) {
        this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.4
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                AttributeTimeStyleFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, AttributeTimeStyleFragment.this.printerLabelTimeView.getJson().toString());
                AttributeTimeStyleFragment.this.elementAttributeTimeBean.setUnderline(!AttributeTimeStyleFragment.this.elementAttributeTimeBean.isUnderline());
                AttributeTimeStyleFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeStyleFragment.this.elementAttributeTimeBean.ObjectToJson());
                if (AttributeTimeStyleFragment.this.elementAttributeTimeBean.isUnderline()) {
                    AttributeTimeStyleFragment.this.ivTimeStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_4_stroke_ffae00);
                } else {
                    AttributeTimeStyleFragment.this.ivTimeStyleUnderline.setBackground(null);
                }
            }
        });
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.lpwTextSize.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.1
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(final float f6) {
                AttributeTimeStyleFragment.this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment.1.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTimeStyleFragment.this.printerLabelTimeView.getJson();
                        AttributeTimeStyleFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                        AttributeTimeStyleFragment.this.elementAttributeTimeBean.setTextSize(f6 * 10.0f);
                        AttributeTimeStyleFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeStyleFragment.this.elementAttributeTimeBean.ObjectToJson());
                    }
                });
            }
        });
    }
}
