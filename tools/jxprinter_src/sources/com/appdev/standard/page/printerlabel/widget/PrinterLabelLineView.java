package com.appdev.standard.page.printerlabel.widget;

import android.widget.RelativeLayout;
import org.json.JSONException;
import org.json.JSONObject;
import p113u.d;
import p113u.e;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelLineView extends BaseControlView {
    private static final String KEY_COLOR_TYPE = "colorType";
    protected final String KEY_LINE_SIZE;
    protected final String KEY_LINE_STYLE_INDEX;
    private BaseLineView blv;

    public PrinterLabelLineView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.blv = null;
        this.KEY_LINE_STYLE_INDEX = "lineStyleIndex";
        this.KEY_LINE_SIZE = "lineSize";
        this.blv = (BaseLineView) findViewById(d.blv_content);
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 360;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 1;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put("lineStyleIndex", this.blv.getLineStyleIndex());
            this.saveObject.put("lineSize", this.blv.getLineSize());
            this.saveObject.put(KEY_COLOR_TYPE, this.blv.getColorType());
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_line_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 50;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        super.onSizeChanged(i5, i6);
        this.blv.updatePaint();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        super.recoverFromJson(jSONObject);
        try {
            this.blv.setLineStyleIndex(getObjectInt(jSONObject, "lineStyleIndex", 1));
            BaseLineView baseLineView = this.blv;
            baseLineView.setLineSize(getObjectFloat(jSONObject, "lineSize", baseLineView.getLineSize()));
            this.blv.setColorType(getObjectInt(jSONObject, KEY_COLOR_TYPE, 0));
            int lineViewHeight = this.blv.getLineViewHeight();
            int i5 = jSONObject.getInt("rotate");
            if (i5 == 0 || i5 == 180) {
                int iMm2pxWithScaleForInt = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("h"));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                if (iMm2pxWithScaleForInt > lineViewHeight) {
                    layoutParams.topMargin += (iMm2pxWithScaleForInt - lineViewHeight) / 2;
                } else {
                    layoutParams.topMargin -= (iMm2pxWithScaleForInt - lineViewHeight) / 2;
                }
                setLayoutParams(layoutParams);
            } else {
                int iMm2pxWithScaleForInt2 = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("w"));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                if (iMm2pxWithScaleForInt2 > lineViewHeight) {
                    layoutParams2.leftMargin += (iMm2pxWithScaleForInt2 - lineViewHeight) / 2;
                } else {
                    layoutParams2.leftMargin -= (iMm2pxWithScaleForInt2 - lineViewHeight) / 2;
                }
                setLayoutParams(layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        setControlType(3);
        this.isRenderingCompleted = true;
        super.updateView();
    }
}
