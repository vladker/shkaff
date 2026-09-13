package com.appdev.standard.page.printerlabel.widget;

import org.json.JSONException;
import org.json.JSONObject;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelShapeView extends BaseControlView {
    private static final String KEY_COLOR_TYPE = "colorType";
    protected final String KEY_IS_FILL;
    protected final String KEY_ITEM_SUB_TYPE;
    protected final String KEY_LINE_BOLD_SIZE;
    protected final String KEY_LINE_STYLE_INDEX;
    protected final String KEY_RECT_CORNER;
    private BaseShapeView bsv;

    public PrinterLabelShapeView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.bsv = null;
        this.KEY_ITEM_SUB_TYPE = "itemSubType";
        this.KEY_IS_FILL = "isFill";
        this.KEY_LINE_STYLE_INDEX = "lineStyleIndex";
        this.KEY_LINE_BOLD_SIZE = "lineSize";
        this.KEY_RECT_CORNER = "rectCorner";
        this.bsv = (BaseShapeView) findViewById(d.bsv_content);
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 2;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put("itemSubType", this.bsv.getItemSubType());
            this.saveObject.put("isFill", this.bsv.isFill());
            this.saveObject.put("lineStyleIndex", this.bsv.getLineStyleIndex());
            this.saveObject.put("lineSize", this.bsv.getLineBoldSize());
            this.saveObject.put("rectCorner", this.bsv.getRectCorner());
            this.saveObject.put(KEY_COLOR_TYPE, this.bsv.getColorType());
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_shape_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        super.onSizeChanged(i5, i6);
        this.bsv.updatePaint();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        super.recoverFromJson(jSONObject);
        try {
            this.bsv.setItemSubType(getObjectInt(jSONObject, "itemSubType", 5));
            this.bsv.setFill(getObjectBoolean(jSONObject, "isFill"));
            this.bsv.setLineStyleIndex(getObjectInt(jSONObject, "lineStyleIndex", 1));
            BaseShapeView baseShapeView = this.bsv;
            baseShapeView.setLineBoldSize(getObjectFloat(jSONObject, "lineSize", baseShapeView.getLineBoldSize()));
            this.bsv.setRectCorner(getObjectInt(jSONObject, "rectCorner", 0));
            this.bsv.setColorType(getObjectInt(jSONObject, KEY_COLOR_TYPE, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        setControlType(2);
        this.isRenderingCompleted = true;
        super.updateView();
    }
}
