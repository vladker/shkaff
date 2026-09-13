package com.appdev.standard.page.printerlabel.widget;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p113u.d;
import p113u.e;
import p137y.f;
import p137y.k;
import p137y.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelTableView extends BaseControlView {
    private static final String KEY_COLOR_TYPE = "colorType";
    private static final String KEY_OPEN_FRAME = "openFrame";
    protected final String KEY_CELLS;
    protected final String KEY_COLUMNS_NUM;
    protected final String KEY_LINE_SIZE;
    protected final String KEY_ROWS_NUM;
    protected final String MERGE_DATA;
    private BaseTableView btv;
    private Point startPos;
    private Integer tempFontSize;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TableSelectEvent {
        public BaseTextView baseTextView;
        public String row_col;

        public TableSelectEvent(BaseTextView baseTextView, String str) {
            this.baseTextView = baseTextView;
            this.row_col = str;
        }
    }

    public PrinterLabelTableView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.btv = null;
        this.tempFontSize = null;
        this.KEY_LINE_SIZE = "lineSize";
        this.KEY_ROWS_NUM = "rowsNum";
        this.KEY_COLUMNS_NUM = "columnsNum";
        this.KEY_CELLS = "tableData";
        this.MERGE_DATA = "mergeData";
        this.btv = (BaseTableView) findViewById(d.table_view);
        updateView();
        this.btv.setOnEditChangedListener(new BaseTableView.OnEditChangedListener() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView.1
            @Override // com.appdev.standard.page.printerlabel.widget.BaseTableView.OnEditChangedListener
            public void onChanged(BaseTextView baseTextView, String str) {
                S4.d.b().f(new l(PrinterLabelTableView.this));
            }
        });
        this.btv.setOnSelectChangedListener(new BaseTableView.onSelectChangedListener() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView.2
            @Override // com.appdev.standard.page.printerlabel.widget.BaseTableView.onSelectChangedListener
            public void onChanged(BaseTextView baseTextView, String str) {
                S4.d.b().f(new TableSelectEvent(baseTextView, str));
            }
        });
    }

    public void addColumnOnSelectedLeft() {
        JSONObject json = getJson();
        if (this.btv.addColumnOnSelectedLeft()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public void addColumnOnSelectedRight() {
        JSONObject json = getJson();
        if (this.btv.addColumnOnSelectedRight()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public boolean addColumnOnTableRight(int i5) {
        return this.btv.addColumnOnTableRight(i5);
    }

    public void addRowOnSelectedBottom() {
        JSONObject json = getJson();
        if (this.btv.addRowOnSelectedBottom()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public void addRowOnSelectedTop() {
        JSONObject json = getJson();
        if (this.btv.addRowOnSelectedTop()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public boolean addRowOnTableBottom(int i5) {
        return this.btv.addRowOnTableBottom(i5);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.templatePage.canEdit) {
            return super.dispatchTouchEvent(motionEvent);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRoot.getLayoutParams();
        motionEvent.offsetLocation(-marginLayoutParams.leftMargin, -marginLayoutParams.topMargin);
        this.btv.dispatchTouchEvent(motionEvent);
        motionEvent.offsetLocation(marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
        if (motionEvent.getAction() == 0) {
            this.startPos = getViewLocation();
        } else if (motionEvent.getAction() == 1) {
            Point viewLocation = getViewLocation();
            Point point = this.startPos;
            if (point != null && viewLocation != null && point.equals(viewLocation)) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mRoot.getLayoutParams();
                BaseTextView baseTextViewTestHitCell = this.btv.testHitCell(((int) motionEvent.getX()) - marginLayoutParams2.leftMargin, ((int) motionEvent.getY()) - marginLayoutParams2.topMargin);
                if (baseTextViewTestHitCell != null) {
                    this.btv.select(baseTextViewTestHitCell);
                    if (isElementSelected() && !this.hasMove) {
                        BaseControlView.touchView = null;
                        this.templatePage.sendDottedLineEvent(new k(2, this));
                        return true;
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 9;
    }

    public int getAlignment() {
        return this.btv.getAligment();
    }

    public ElementAttributeTableChildBean getChildBean(int i5, int i6) {
        return this.btv.getChildBean(i5, i6);
    }

    public int getColumnsNum() {
        return this.btv.getColumnsNum();
    }

    public String getContent() {
        return this.btv.getContent();
    }

    public BaseTextView getEditView() {
        return this.btv.getEditView();
    }

    public String getFontId() {
        return this.btv.getFont();
    }

    public float getFontSize() {
        return this.btv.getFontSize();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put("lineSize", this.btv.getLineSize());
            this.saveObject.put("rowsNum", this.btv.getRowsNum());
            this.saveObject.put("columnsNum", this.btv.getColumnsNum());
            this.saveObject.put("tableData", this.btv.getCells());
            this.saveObject.put("mergeData", this.btv.getMergeData());
            this.saveObject.put(KEY_COLOR_TYPE, this.btv.getColorType());
            this.saveObject.put(KEY_OPEN_FRAME, this.btv.getOpenFrame());
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    public float getLinesSpace() {
        return this.btv.getLinesSpace();
    }

    public int getRowsNum() {
        return this.btv.getRowsNum();
    }

    public ElementAttributeTableChildBean getSelectedChildBean() {
        return this.btv.getSelectedChildBean();
    }

    public Integer getTempFontSize() {
        return this.tempFontSize;
    }

    public float getWordSpace() {
        return this.btv.getWordSpace();
    }

    public void hiddenSelected() {
        this.btv.hiddenSelected();
    }

    public boolean isBold() {
        return this.btv.isBold();
    }

    public boolean isDeleteLine() {
        return this.btv.isDeleteLine();
    }

    public boolean isItalic() {
        return this.btv.isItalic();
    }

    public boolean isOpenFrame() {
        return this.btv.isOpenFrame();
    }

    public boolean isSingleSelectMode() {
        return this.btv.isSingleSelectMode();
    }

    public boolean isUnderLine() {
        return this.btv.isUnderLine();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_table_view;
    }

    public void merge() {
        JSONObject json = getJson();
        if (this.btv.merge()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 10;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 10;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        super.onSizeChanged(i5, i6);
        this.btv.refreshTable(i5, i6);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        super.recoverFromJson(jSONObject);
        try {
            this.btv.setLineSize(getObjectFloat(jSONObject, "lineSize", 0.5f));
            this.btv.setRowsNum(getObjectInt(jSONObject, "rowsNum", 3));
            this.btv.setColumnsNum(getObjectInt(jSONObject, "columnsNum", 2));
            this.btv.setColorType(getObjectInt(jSONObject, KEY_COLOR_TYPE, 0));
            this.btv.setOpenFrame(getObjectInt(jSONObject, KEY_OPEN_FRAME, 1));
            try {
                jSONArray = jSONObject.getJSONArray("mergeData");
            } catch (Exception unused) {
                jSONArray = null;
            }
            this.btv.setCells(jSONObject.getJSONArray("tableData"), jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    public void removeColumnOnSelectedLeft() {
        JSONObject json = getJson();
        if (this.btv.removeColumnOnSelectedLeft()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public void removeColumnOnSelectedRight() {
        JSONObject json = getJson();
        if (this.btv.removeColumnOnSelectedRight()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public boolean removeColumnOnTableRight(int i5) {
        return this.btv.removeColumnOnTableRight(i5);
    }

    public void removeRowOnSelectedBottom() {
        JSONObject json = getJson();
        if (this.btv.removeRowOnSelectedBottom()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public void removeRowOnSelectedTop() {
        JSONObject json = getJson();
        if (this.btv.removeRowOnSelectedTop()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    public boolean removeRowOnTableBottom(int i5) {
        return this.btv.removeRowOnTableBottom(i5);
    }

    public void resetSelected() {
        this.btv.resetSelected();
    }

    public boolean setAlignment(int i5) {
        return this.btv.setFontAligment(i5);
    }

    public boolean setBold(boolean z6) {
        return this.btv.setBold(z6);
    }

    public void setColWidth(float f6) {
        this.btv.setColWidth(f6);
    }

    public void setContent(String str) {
        this.btv.setContent(str);
    }

    public boolean setDeleteLine(boolean z6) {
        return this.btv.setDeleteLine(z6);
    }

    public boolean setFontId(String str) {
        return this.btv.setFont(str);
    }

    public void setFontSize(int i5) {
        this.btv.setFontSize(i5);
    }

    public boolean setItalic(boolean z6) {
        return this.btv.setItalic(z6);
    }

    public void setLineSize(float f6) {
        this.btv.setLineSize(f6);
    }

    public boolean setLinesSpace(float f6) {
        return this.btv.setLinesSpace(f6);
    }

    public void setOpenFrame(boolean z6) {
        this.btv.setOpenFrame(z6);
    }

    public void setRowHeight(float f6) {
        this.btv.setRowHeight(f6);
    }

    public void setSingleSelectMode(boolean z6) {
        this.btv.setSingleSelectMode(z6);
    }

    public void setTempFontSize(Integer num) {
        this.tempFontSize = num;
    }

    public boolean setUnderLine(boolean z6) {
        return this.btv.setUnderLine(z6);
    }

    public boolean setWordSpace(float f6) {
        return this.btv.setWordSpace(f6);
    }

    public void split() {
        JSONObject json = getJson();
        if (this.btv.split()) {
            S4.d.b().f(new f(json, getJson(), this));
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        setControlType(2);
        this.isRenderingCompleted = true;
        super.updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateZoomedSize() {
        super.updateZoomedSize();
        this.btv.scale();
    }
}
