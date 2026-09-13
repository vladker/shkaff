package com.appdev.standard.page.printerlabel.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p113u.d;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BaseTableView extends RelativeLayout {
    protected final String KEY_BOLD;
    protected final String KEY_COLUMNS_WIDTH;
    protected final String KEY_CONTENT;
    protected final String KEY_FONTTYPE;
    protected final String KEY_H_ALALIGNMENT;
    protected final String KEY_ITALIC;
    protected final String KEY_LINESSPACE;
    protected final String KEY_ROWS_HEIGHT;
    protected final String KEY_STRIKETHROUGH;
    protected final String KEY_TEXTSIZE;
    protected final String KEY_UNDERLINE;
    protected final String KEY_WORDSPACE;
    private final String TAG;
    private int colorType;
    private int columnsNum;
    private BaseTextView editView;
    private GestureDetector gestureDetector;
    private boolean isShow;
    private float lineSize;
    private OnEditChangedListener onEditChangedListener;
    private onSelectChangedListener onSelectChangedListener;
    private int openFrame;
    private int rowsNum;
    private int selectMode;
    private List<List<ElementAttributeTableChildBean>> tableData;
    private int tempHeight;
    private int tempWidth;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnEditChangedListener {
        void onChanged(BaseTextView baseTextView, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface onSelectChangedListener {
        void onChanged(BaseTextView baseTextView, String str);
    }

    public BaseTableView(Context context, JSONArray jSONArray, JSONArray jSONArray2) {
        super(context);
        this.colorType = 0;
        this.TAG = "BaseTableView";
        this.lineSize = 0.5f;
        this.isShow = false;
        this.openFrame = 1;
        this.tempWidth = 0;
        this.tempHeight = 0;
        this.tableData = new ArrayList();
        this.selectMode = 1;
        this.editView = null;
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_FONTTYPE = "fontId";
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_H_ALALIGNMENT = "aligment";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.KEY_ROWS_HEIGHT = "rowsHeight";
        this.KEY_COLUMNS_WIDTH = "columnsWidth";
        this.KEY_WORDSPACE = "wordSpace";
        this.KEY_LINESSPACE = "linesSpace";
        this.onEditChangedListener = null;
        this.onSelectChangedListener = null;
        if (jSONArray != null && jSONArray.length() != 0) {
            setCells(jSONArray, jSONArray2);
        }
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTableView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (BaseTableView.this.onEditChangedListener == null) {
                    return true;
                }
                BaseTableView.this.onEditChangedListener.onChanged(null, null);
                return true;
            }
        });
        post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTableView.2
            @Override // java.lang.Runnable
            public void run() {
                BaseTableView.this.initView();
            }
        });
    }

    private int getFrameLineSize() {
        int iMm2pxWithScale = C1849c.mm2pxWithScale(this.lineSize);
        if (iMm2pxWithScale <= 0) {
            iMm2pxWithScale = 1;
        }
        if (this.openFrame == 0) {
            return 0;
        }
        return iMm2pxWithScale;
    }

    private List<String> getSelectElements() {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 <= getChildCount() - 1; i5++) {
            BaseTextView baseTextView = (BaseTextView) getChildAt(i5);
            if (baseTextView != null && ((Boolean) baseTextView.getTag(d.table_select)).booleanValue()) {
                arrayList.add((String) baseTextView.getTag());
            }
        }
        return arrayList;
    }

    private float getTableLineSize() {
        if (this.openFrame == 0) {
            return 0.0f;
        }
        return this.lineSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        if (this.rowsNum <= 0 || this.columnsNum <= 0) {
            this.rowsNum = 3;
            this.columnsNum = 2;
            this.tempWidth = (C1849c.mm2pxWithScale(0.5f) * 3) + (C1849c.mm2pxWithScale(9.0f) * 2);
            this.tempHeight = (C1849c.mm2pxWithScale(0.5f) * 4) + (C1849c.mm2pxWithScale(5.0f) * 3);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.width = this.tempWidth;
                layoutParams.height = this.tempHeight;
                viewGroup.setLayoutParams(layoutParams);
            }
            int frameLineSize = getFrameLineSize();
            int i5 = this.tempWidth;
            int i6 = this.columnsNum;
            int i7 = (i5 - ((i6 + 1) * frameLineSize)) / i6;
            int i8 = this.tempHeight;
            int i9 = this.rowsNum;
            int i10 = (i8 - ((i9 + 1) * frameLineSize)) / i9;
            for (int i11 = 0; i11 < this.rowsNum; i11++) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 0; i12 < this.columnsNum; i12++) {
                    arrayList.add(new ElementAttributeTableChildBean(5.0f, 9.0f));
                }
                this.tableData.add(arrayList);
            }
            paintingTable(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addColumnOnSelectedLeft$4(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addColumnOnSelectedRight$6(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addRowOnSelectedBottom$2(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addRowOnSelectedTop$0(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeColumnOnSelectedLeft$5(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeColumnOnSelectedRight$7(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeRowOnSelectedBottom$3(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeRowOnSelectedTop$1(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    private void paintingTable(boolean z6, boolean z7) {
        ViewGroup viewGroup;
        if (this.tableData.size() <= 0) {
            return;
        }
        int frameLineSize = getFrameLineSize();
        float tableLineSize = getTableLineSize();
        setPadding(frameLineSize, frameLineSize, frameLineSize, frameLineSize);
        removeAllViews();
        int i5 = 0;
        int i6 = 0;
        float rowsHeight = 0.0f;
        float columnsWidth = 0.0f;
        while (true) {
            if (i6 > this.tableData.size() - 1) {
                break;
            }
            rowsHeight = i6 == 0 ? 0.0f : this.tableData.get(i6 - 1).get(i5).getRowsHeight() + tableLineSize + rowsHeight;
            int i7 = i5;
            for (int i8 = 1; i7 <= this.tableData.get(i6).size() - i8; i8 = 1) {
                columnsWidth = i7 == 0 ? 0.0f : this.tableData.get(i6).get(i7 - 1).getColumnsWidth() + tableLineSize + columnsWidth;
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(i7);
                if (!elementAttributeTableChildBean.isMergeCell()) {
                    float rowsHeight2 = elementAttributeTableChildBean.getRowsHeight();
                    float columnsWidth2 = elementAttributeTableChildBean.getColumnsWidth();
                    BaseTextView baseTextView = (BaseTextView) findViewWithTag(String.format("%d:1,%d:1", Integer.valueOf(i6), Integer.valueOf(i7)));
                    if (baseTextView == null) {
                        BaseTextView baseTextView2 = new BaseTextView(getContext());
                        baseTextView2.setDefaultContent("");
                        baseTextView2.setRealWidth(columnsWidth2);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C1849c.mm2pxWithScale(columnsWidth2), C1849c.mm2pxWithScale(rowsHeight2));
                        layoutParams.topMargin = C1849c.mm2pxWithScale(rowsHeight);
                        layoutParams.leftMargin = C1849c.mm2pxWithScale(columnsWidth);
                        Resources resources = getResources();
                        int i9 = p113u.a.color_00FFFFFF;
                        baseTextView2.setBackgroundColor(resources.getColor(i9));
                        baseTextView2.setTag(String.format("%d:1,%d:1", Integer.valueOf(i6), Integer.valueOf(i7)));
                        baseTextView2.setTextInfo(elementAttributeTableChildBean.getContent(), elementAttributeTableChildBean.getFontSize(), elementAttributeTableChildBean.getWordSpace(), elementAttributeTableChildBean.getLinesSpace(), elementAttributeTableChildBean.isIsBold(), elementAttributeTableChildBean.isIsItalic(), elementAttributeTableChildBean.isIsUnderLine(), elementAttributeTableChildBean.isIsDeleteLine(), elementAttributeTableChildBean.getAligment(), elementAttributeTableChildBean.getFontId(), elementAttributeTableChildBean.getDirection());
                        baseTextView2.setTag(d.table_select, Boolean.valueOf(elementAttributeTableChildBean.isSelect()));
                        Resources resources2 = getResources();
                        if (elementAttributeTableChildBean.isSelect()) {
                            i9 = p113u.a.color_FFAE00;
                        }
                        baseTextView2.setBackgroundColor(resources2.getColor(i9));
                        baseTextView2.setLayoutParams(layoutParams);
                        addView(baseTextView2);
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) baseTextView.getLayoutParams();
                        baseTextView.setTextInfo(elementAttributeTableChildBean.getContent(), elementAttributeTableChildBean.getFontSize(), elementAttributeTableChildBean.getWordSpace(), elementAttributeTableChildBean.getLinesSpace(), elementAttributeTableChildBean.isIsBold(), elementAttributeTableChildBean.isIsItalic(), elementAttributeTableChildBean.isIsUnderLine(), elementAttributeTableChildBean.isIsDeleteLine(), elementAttributeTableChildBean.getAligment(), elementAttributeTableChildBean.getFontId(), elementAttributeTableChildBean.getDirection());
                        baseTextView.setTag(d.table_select, Boolean.valueOf(elementAttributeTableChildBean.isSelect()));
                        baseTextView.setBackgroundColor(getResources().getColor(elementAttributeTableChildBean.isSelect() ? p113u.a.color_FFAE00 : p113u.a.color_00FFFFFF));
                        layoutParams2.width = C1849c.mm2pxWithScale(columnsWidth2);
                        layoutParams2.height = C1849c.mm2pxWithScale(rowsHeight2);
                        layoutParams2.topMargin = C1849c.mm2pxWithScale(rowsHeight);
                        layoutParams2.leftMargin = C1849c.mm2pxWithScale(columnsWidth);
                        baseTextView.setLayoutParams(layoutParams2);
                    }
                } else if (elementAttributeTableChildBean.isShowCell()) {
                    int baseOffsetY = elementAttributeTableChildBean.getBaseOffsetY() + i6;
                    int baseOffsetX = elementAttributeTableChildBean.getBaseOffsetX() + i7;
                    float columnsWidth3 = 0.0f;
                    for (int i10 = baseOffsetX; i10 < elementAttributeTableChildBean.getMergeWidth() + baseOffsetX; i10++) {
                        columnsWidth3 += this.tableData.get(baseOffsetY).get(i10).getColumnsWidth() + tableLineSize;
                    }
                    float rowsHeight3 = 0.0f;
                    for (int i11 = baseOffsetY; i11 < elementAttributeTableChildBean.getMergeHeight() + baseOffsetY; i11++) {
                        rowsHeight3 += this.tableData.get(i11).get(baseOffsetX).getRowsHeight() + tableLineSize;
                    }
                    float columnsWidth4 = rowsHeight;
                    for (int i12 = baseOffsetY; i12 < i6; i12++) {
                        columnsWidth4 -= this.tableData.get(i12).get(baseOffsetX).getColumnsWidth() + tableLineSize;
                    }
                    float rowsHeight4 = columnsWidth;
                    for (int i13 = baseOffsetX; i13 < i7; i13++) {
                        rowsHeight4 -= this.tableData.get(baseOffsetY).get(i13).getRowsHeight() + tableLineSize;
                    }
                    String str = String.format("%d:%d,%d:%d", Integer.valueOf(baseOffsetY), Integer.valueOf(elementAttributeTableChildBean.getMergeHeight()), Integer.valueOf(baseOffsetX), Integer.valueOf(elementAttributeTableChildBean.getMergeWidth()));
                    BaseTextView baseTextView3 = new BaseTextView(getContext(), true);
                    baseTextView3.setDefaultContent("");
                    baseTextView3.setRealWidth(columnsWidth3);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(C1849c.mm2pxWithScale(columnsWidth3), C1849c.mm2pxWithScale(rowsHeight3));
                    layoutParams3.topMargin = C1849c.mm2pxWithScale(columnsWidth4);
                    layoutParams3.leftMargin = C1849c.mm2pxWithScale(rowsHeight4);
                    Resources resources3 = getResources();
                    int i14 = p113u.a.color_00FFFFFF;
                    baseTextView3.setBackgroundColor(resources3.getColor(i14));
                    baseTextView3.setTag(str);
                    baseTextView3.setTextInfo(elementAttributeTableChildBean.getContent(), elementAttributeTableChildBean.getFontSize(), elementAttributeTableChildBean.getWordSpace(), elementAttributeTableChildBean.getLinesSpace(), elementAttributeTableChildBean.isIsBold(), elementAttributeTableChildBean.isIsItalic(), elementAttributeTableChildBean.isIsUnderLine(), elementAttributeTableChildBean.isIsDeleteLine(), elementAttributeTableChildBean.getAligment(), elementAttributeTableChildBean.getFontId(), elementAttributeTableChildBean.getDirection());
                    baseTextView3.setTag(d.table_select, Boolean.valueOf(elementAttributeTableChildBean.isSelect()));
                    Resources resources4 = getResources();
                    if (elementAttributeTableChildBean.isSelect()) {
                        i14 = p113u.a.color_FFAE00;
                    }
                    baseTextView3.setBackgroundColor(resources4.getColor(i14));
                    baseTextView3.setLayoutParams(layoutParams3);
                    addView(baseTextView3);
                }
                i7++;
            }
            i6++;
            i5 = 0;
        }
        if (!z6 || (viewGroup = (ViewGroup) getParent()) == null) {
            return;
        }
        ElementAttributeTableChildBean elementAttributeTableChildBean2 = (ElementAttributeTableChildBean) ((List) AbstractC0157z.f(1, this.tableData)).get(((List) AbstractC0157z.f(1, this.tableData)).size() - 1);
        float f6 = tableLineSize * 2.0f;
        float rowsHeight5 = elementAttributeTableChildBean2.getRowsHeight() + rowsHeight + f6;
        float columnsWidth5 = elementAttributeTableChildBean2.getColumnsWidth() + columnsWidth + f6;
        ViewGroup.LayoutParams layoutParams4 = viewGroup.getLayoutParams();
        layoutParams4.width = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() + C1849c.mm2pxWithScale(columnsWidth5);
        layoutParams4.height = viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() + C1849c.mm2pxWithScale(rowsHeight5);
        viewGroup.setLayoutParams(layoutParams4);
        this.tempWidth = layoutParams4.width;
        this.tempHeight = layoutParams4.height;
        p051j0.a.d("BaseTableView", "totalWidth=" + columnsWidth5 + ",totalHeight=" + rowsHeight5);
    }

    private void removeColumn(int i5) {
        for (int i6 = 0; i6 < this.tableData.size(); i6++) {
            ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(i5);
            int baseOffsetX = elementAttributeTableChildBean.getBaseOffsetX() + i5;
            int mergeWidth = elementAttributeTableChildBean.getMergeWidth() + elementAttributeTableChildBean.getBaseOffsetX() + i5;
            if (elementAttributeTableChildBean.isMergeCell()) {
                int mergeWidth2 = elementAttributeTableChildBean.getMergeWidth();
                for (int i7 = baseOffsetX; i7 < mergeWidth; i7++) {
                    ElementAttributeTableChildBean elementAttributeTableChildBean2 = this.tableData.get(i6).get(i7);
                    if (i7 < i5) {
                        elementAttributeTableChildBean2.setBaseOffsetX(baseOffsetX - i7);
                    } else {
                        elementAttributeTableChildBean2.setBaseOffsetX((baseOffsetX - i7) + 1);
                    }
                    elementAttributeTableChildBean2.setMergeWidth((mergeWidth - baseOffsetX) - 1);
                }
                if (baseOffsetX == i5 && i6 == elementAttributeTableChildBean.getBaseOffsetY() + i6 && mergeWidth2 > 1) {
                    this.tableData.get(i6).get(i5 + 1).setShowCell(true);
                }
            }
            this.tableData.get(i6).remove(i5);
        }
        this.columnsNum--;
    }

    private void removeRow(int i5) {
        for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
            ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
            int baseOffsetY = elementAttributeTableChildBean.getBaseOffsetY() + i5;
            int mergeHeight = elementAttributeTableChildBean.getMergeHeight() + elementAttributeTableChildBean.getBaseOffsetY() + i5;
            if (elementAttributeTableChildBean.isMergeCell()) {
                int mergeHeight2 = elementAttributeTableChildBean.getMergeHeight();
                for (int i7 = baseOffsetY; i7 < mergeHeight; i7++) {
                    ElementAttributeTableChildBean elementAttributeTableChildBean2 = this.tableData.get(i7).get(i6);
                    if (i7 < i5) {
                        elementAttributeTableChildBean2.setBaseOffsetY(baseOffsetY - i7);
                    } else {
                        elementAttributeTableChildBean2.setBaseOffsetY((baseOffsetY - i7) + 1);
                    }
                    elementAttributeTableChildBean2.setMergeHeight((mergeHeight - baseOffsetY) - 1);
                }
                if (baseOffsetY == i5 && i6 == elementAttributeTableChildBean.getBaseOffsetX() + i6 && mergeHeight2 > 1) {
                    this.tableData.get(i5 + 1).get(i6).setShowCell(true);
                }
            }
        }
        this.tableData.remove(i5);
        this.rowsNum--;
    }

    private void updateColors() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof BaseTextView) {
                ((BaseTextView) childAt).setColorType(this.colorType);
            }
        }
        invalidate();
    }

    public boolean addColumnOnSelectedLeft() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer.valueOf(strArrSplit2[0]);
            Integer numValueOf = Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(numValueOf)) {
                arrayList.add(numValueOf);
            }
        }
        arrayList.sort(new I4.a(6));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            for (int i6 = 0; i6 < this.tableData.size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(num.intValue());
                ElementAttributeTableChildBean elementAttributeTableChildBean2 = new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth());
                this.tableData.get(i6).add(num.intValue(), elementAttributeTableChildBean2);
                if (elementAttributeTableChildBean.isMergeCell() && elementAttributeTableChildBean.getBaseOffsetX() != 0) {
                    int baseOffsetX = elementAttributeTableChildBean.getBaseOffsetX() + num.intValue();
                    int mergeWidth = elementAttributeTableChildBean.getMergeWidth() + elementAttributeTableChildBean.getBaseOffsetX() + num.intValue();
                    elementAttributeTableChildBean2.setBaseOffsetX(elementAttributeTableChildBean.getBaseOffsetX());
                    elementAttributeTableChildBean2.setBaseOffsetY(elementAttributeTableChildBean.getBaseOffsetY());
                    elementAttributeTableChildBean2.setMergeWidth(elementAttributeTableChildBean.getMergeWidth());
                    elementAttributeTableChildBean2.setMergeHeight(elementAttributeTableChildBean.getMergeHeight());
                    elementAttributeTableChildBean2.setShowCell(false);
                    for (int i7 = baseOffsetX; i7 <= mergeWidth; i7++) {
                        ElementAttributeTableChildBean elementAttributeTableChildBean3 = this.tableData.get(i6).get(i7);
                        elementAttributeTableChildBean3.setBaseOffsetX(baseOffsetX - i7);
                        elementAttributeTableChildBean3.setMergeWidth((mergeWidth - baseOffsetX) + 1);
                    }
                }
            }
        }
        this.columnsNum = arrayList.size() + this.columnsNum;
        paintingTable(true, false);
        return true;
    }

    public boolean addColumnOnSelectedRight() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer.valueOf(strArrSplit2[0]);
            Integer numValueOf = Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer numValueOf2 = Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1))) {
                arrayList.add(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1));
            }
        }
        arrayList.sort(new I4.a(7));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            for (int i6 = 0; i6 < this.tableData.size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(num.intValue());
                ElementAttributeTableChildBean elementAttributeTableChildBean2 = new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth());
                this.tableData.get(i6).add(num.intValue() + 1, elementAttributeTableChildBean2);
                int baseOffsetX = elementAttributeTableChildBean.getBaseOffsetX() + num.intValue();
                int mergeWidth = elementAttributeTableChildBean.getMergeWidth() + elementAttributeTableChildBean.getBaseOffsetX() + num.intValue();
                if (elementAttributeTableChildBean.isMergeCell() && mergeWidth - 1 > num.intValue()) {
                    elementAttributeTableChildBean2.setBaseOffsetX(elementAttributeTableChildBean.getBaseOffsetX());
                    elementAttributeTableChildBean2.setBaseOffsetY(elementAttributeTableChildBean.getBaseOffsetY());
                    elementAttributeTableChildBean2.setMergeWidth(elementAttributeTableChildBean.getMergeWidth());
                    elementAttributeTableChildBean2.setMergeHeight(elementAttributeTableChildBean.getMergeHeight());
                    elementAttributeTableChildBean2.setShowCell(false);
                    for (int i7 = baseOffsetX; i7 <= mergeWidth; i7++) {
                        ElementAttributeTableChildBean elementAttributeTableChildBean3 = this.tableData.get(i6).get(i7);
                        elementAttributeTableChildBean3.setBaseOffsetX(baseOffsetX - i7);
                        elementAttributeTableChildBean3.setMergeWidth((mergeWidth - baseOffsetX) + 1);
                    }
                }
            }
        }
        this.columnsNum = arrayList.size() + this.columnsNum;
        paintingTable(true, false);
        return true;
    }

    public boolean addColumnOnTableRight(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            for (int i7 = 0; i7 < this.tableData.size(); i7++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i7).get(0);
                this.tableData.get(i7).add(new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth()));
            }
            this.columnsNum++;
        }
        paintingTable(true, false);
        return true;
    }

    public boolean addRowOnSelectedBottom() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
            Integer.valueOf(strArrSplit3[0]);
            Integer numValueOf2 = Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1))) {
                arrayList.add(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1));
            }
        }
        arrayList.sort(new I4.a(10));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            ArrayList arrayList2 = new ArrayList();
            for (int i6 = 0; i6 < this.tableData.get(num.intValue()).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(num.intValue()).get(i6);
                ElementAttributeTableChildBean elementAttributeTableChildBean2 = new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth());
                arrayList2.add(elementAttributeTableChildBean2);
                int baseOffsetY = elementAttributeTableChildBean.getBaseOffsetY() + num.intValue();
                int mergeHeight = elementAttributeTableChildBean.getMergeHeight() + elementAttributeTableChildBean.getBaseOffsetY() + num.intValue();
                if (elementAttributeTableChildBean.isMergeCell() && mergeHeight - 1 > num.intValue()) {
                    elementAttributeTableChildBean2.setBaseOffsetX(elementAttributeTableChildBean.getBaseOffsetX());
                    elementAttributeTableChildBean2.setBaseOffsetY((baseOffsetY - num.intValue()) - 1);
                    elementAttributeTableChildBean2.setMergeWidth(elementAttributeTableChildBean.getMergeWidth());
                    elementAttributeTableChildBean2.setMergeHeight(elementAttributeTableChildBean.getMergeHeight() + 1);
                    elementAttributeTableChildBean2.setShowCell(false);
                    for (int i7 = baseOffsetY; i7 < mergeHeight; i7++) {
                        ElementAttributeTableChildBean elementAttributeTableChildBean3 = this.tableData.get(i7).get(i6);
                        if (i7 <= num.intValue()) {
                            elementAttributeTableChildBean3.setBaseOffsetY(baseOffsetY - i7);
                        } else {
                            elementAttributeTableChildBean3.setBaseOffsetY((baseOffsetY - i7) - 1);
                        }
                        elementAttributeTableChildBean3.setMergeHeight((mergeHeight - baseOffsetY) + 1);
                    }
                }
            }
            this.tableData.add(num.intValue() + 1, arrayList2);
        }
        this.rowsNum = arrayList.size() + this.rowsNum;
        paintingTable(true, false);
        return true;
    }

    public boolean addRowOnSelectedTop() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
            Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(numValueOf)) {
                arrayList.add(numValueOf);
            }
        }
        arrayList.sort(new I4.a(11));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            ArrayList arrayList2 = new ArrayList();
            for (int i6 = 0; i6 < this.tableData.get(num.intValue()).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(num.intValue()).get(i6);
                ElementAttributeTableChildBean elementAttributeTableChildBean2 = new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth());
                arrayList2.add(elementAttributeTableChildBean2);
                int baseOffsetY = elementAttributeTableChildBean.getBaseOffsetY() + num.intValue();
                int mergeHeight = elementAttributeTableChildBean.getMergeHeight() + elementAttributeTableChildBean.getBaseOffsetY() + num.intValue();
                if (elementAttributeTableChildBean.isMergeCell() && baseOffsetY < num.intValue()) {
                    elementAttributeTableChildBean2.setBaseOffsetX(elementAttributeTableChildBean.getBaseOffsetX());
                    elementAttributeTableChildBean2.setBaseOffsetY(baseOffsetY - num.intValue());
                    elementAttributeTableChildBean2.setMergeWidth(elementAttributeTableChildBean.getMergeWidth());
                    elementAttributeTableChildBean2.setMergeHeight(elementAttributeTableChildBean.getMergeHeight() + 1);
                    elementAttributeTableChildBean2.setShowCell(false);
                    for (int i7 = baseOffsetY; i7 < mergeHeight; i7++) {
                        ElementAttributeTableChildBean elementAttributeTableChildBean3 = this.tableData.get(i7).get(i6);
                        if (i7 < num.intValue()) {
                            elementAttributeTableChildBean3.setBaseOffsetY(baseOffsetY - i7);
                        } else {
                            elementAttributeTableChildBean3.setBaseOffsetY((baseOffsetY - i7) - 1);
                        }
                        elementAttributeTableChildBean3.setMergeHeight((mergeHeight - baseOffsetY) + 1);
                    }
                }
            }
            this.tableData.add(num.intValue(), arrayList2);
        }
        this.rowsNum = arrayList.size() + this.rowsNum;
        paintingTable(true, false);
        return true;
    }

    public boolean addRowOnTableBottom(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < this.tableData.get(0).size(); i7++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(0).get(i7);
                arrayList.add(new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth()));
            }
            this.tableData.add(arrayList);
            this.rowsNum++;
        }
        paintingTable(true, false);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i5;
        int i6;
        int i7;
        super.dispatchDraw(canvas);
        int frameLineSize = getFrameLineSize();
        if (frameLineSize == 0) {
            return;
        }
        int i8 = 1;
        int i9 = this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK;
        float tableLineSize = getTableLineSize();
        Paint paint = new Paint();
        paint.setColor(i9);
        float f6 = frameLineSize;
        paint.setStrokeWidth(f6);
        paint.setStyle(Paint.Style.STROKE);
        int width = getWidth();
        int height = getHeight();
        StringBuilder sbS = androidx.collection.a.s("width=", width, height, ",height=", ",frameLineSize=");
        sbS.append(frameLineSize);
        p051j0.a.d("BaseTableView", sbS.toString());
        float f7 = f6 / 2.0f;
        canvas.drawRect(f7, f7, width - f7, height - f7, paint);
        float f8 = tableLineSize / 2.0f;
        int i10 = 0;
        float f9 = f8;
        int i11 = 0;
        while (i11 <= this.tableData.size() - i8) {
            float rowsHeight = this.tableData.get(i11).get(i10).getRowsHeight() + tableLineSize + f9;
            float f10 = f8;
            int i12 = i10;
            while (i12 <= this.tableData.get(i11).size() - i8) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i11).get(i12);
                float columnsWidth = elementAttributeTableChildBean.getColumnsWidth() + tableLineSize + f10;
                int iMm2pxWithScale = C1849c.mm2pxWithScale(f10);
                int iMm2pxWithScale2 = C1849c.mm2pxWithScale(f9);
                int iMm2pxWithScale3 = C1849c.mm2pxWithScale(columnsWidth);
                int iMm2pxWithScale4 = C1849c.mm2pxWithScale(rowsHeight);
                if (elementAttributeTableChildBean.isMergeCell()) {
                    if (i12 < (elementAttributeTableChildBean.getMergeWidth() + (elementAttributeTableChildBean.getBaseOffsetX() + i12)) - 1 || i12 == this.tableData.get(i11).size() - i8) {
                        i6 = iMm2pxWithScale3;
                        i7 = iMm2pxWithScale4;
                    } else {
                        float f11 = iMm2pxWithScale3;
                        i7 = iMm2pxWithScale4;
                        i6 = iMm2pxWithScale3;
                        canvas.drawLine(f11, iMm2pxWithScale2, f11, iMm2pxWithScale4, paint);
                    }
                    if (i11 >= (elementAttributeTableChildBean.getMergeHeight() + (elementAttributeTableChildBean.getBaseOffsetY() + i11)) - 1 && i11 != this.tableData.size() - 1) {
                        float f12 = i7;
                        canvas.drawLine(iMm2pxWithScale, f12, i6, f12, paint);
                    }
                } else {
                    f8 = f8;
                    i8 = i8;
                    if (i11 != this.tableData.size() - 1) {
                        float f13 = iMm2pxWithScale4;
                        i5 = iMm2pxWithScale2;
                        canvas.drawLine(iMm2pxWithScale, f13, iMm2pxWithScale3, f13, paint);
                    } else {
                        i5 = iMm2pxWithScale2;
                    }
                    if (i12 != this.tableData.get(i11).size() - 1) {
                        float f14 = iMm2pxWithScale3;
                        canvas.drawLine(f14, i5, f14, iMm2pxWithScale4, paint);
                    }
                }
                i12++;
                f10 = columnsWidth;
                i8 = i8;
                f8 = f8;
            }
            i11++;
            f9 = rowsHeight;
            i10 = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public int getAligment() {
        int aligment = -1;
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (aligment == -1) {
                        aligment = elementAttributeTableChildBean.getAligment();
                    } else if (aligment != elementAttributeTableChildBean.getAligment()) {
                        return -1;
                    }
                    z6 = true;
                }
            }
        }
        if (z6) {
            return aligment;
        }
        return -1;
    }

    public JSONArray getCells() {
        JSONArray jSONArray = new JSONArray();
        for (List<ElementAttributeTableChildBean> list : this.tableData) {
            JSONArray jSONArray2 = new JSONArray();
            for (ElementAttributeTableChildBean elementAttributeTableChildBean : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.CONTENT, elementAttributeTableChildBean.getContent());
                    jSONObject.put("fontId", elementAttributeTableChildBean.getFontId());
                    jSONObject.put("fontSize", elementAttributeTableChildBean.getFontSize());
                    jSONObject.put("aligment", elementAttributeTableChildBean.getAligment());
                    jSONObject.put("isBold", elementAttributeTableChildBean.isIsBold());
                    jSONObject.put("isItalic", elementAttributeTableChildBean.isIsItalic());
                    jSONObject.put("isUnderLine", elementAttributeTableChildBean.isIsUnderLine());
                    jSONObject.put("isDeleteLine", elementAttributeTableChildBean.isIsDeleteLine());
                    jSONObject.put("rowsHeight", elementAttributeTableChildBean.getRowsHeight());
                    jSONObject.put("columnsWidth", elementAttributeTableChildBean.getColumnsWidth());
                    jSONObject.put("wordSpace", elementAttributeTableChildBean.getWordSpace());
                    jSONObject.put("linesSpace", elementAttributeTableChildBean.getLinesSpace());
                    jSONArray2.put(jSONObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            jSONArray.put(jSONArray2);
        }
        return jSONArray;
    }

    public ElementAttributeTableChildBean getChildBean(int i5, int i6) {
        return this.tableData.get(i5).get(i6);
    }

    public int getColorType() {
        return this.colorType;
    }

    public int getColumnsNum() {
        return this.columnsNum;
    }

    public String getContent() {
        String content = null;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (content == null) {
                        content = elementAttributeTableChildBean.getContent();
                    } else if (!content.equals(elementAttributeTableChildBean.getContent())) {
                        return null;
                    }
                }
            }
        }
        return content;
    }

    public BaseTextView getEditView() {
        return this.editView;
    }

    public String getFont() {
        String fontId = null;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (fontId == null) {
                        fontId = elementAttributeTableChildBean.getFontId();
                    } else if (!fontId.equals(elementAttributeTableChildBean.getFontId())) {
                        return null;
                    }
                }
            }
        }
        return fontId;
    }

    public float getFontSize() {
        float fontSize = 35.0f;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (fontSize == 35.0f) {
                        fontSize = elementAttributeTableChildBean.getFontSize();
                    } else if (fontSize != elementAttributeTableChildBean.getFontSize()) {
                        return 35.0f;
                    }
                }
            }
        }
        return fontSize;
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public float getLinesSpace() {
        float linesSpace = 0.0f;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (linesSpace == 0.0f) {
                        linesSpace = elementAttributeTableChildBean.getLinesSpace();
                    } else if (linesSpace != elementAttributeTableChildBean.getLinesSpace()) {
                        return 0.0f;
                    }
                }
            }
        }
        return linesSpace;
    }

    public JSONArray getMergeData() {
        JSONArray jSONArray = new JSONArray();
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isMergeCell() && elementAttributeTableChildBean.isShowCell()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("leftTopRow", elementAttributeTableChildBean.getBaseOffsetY() + i5);
                        jSONObject.put("leftTopCol", elementAttributeTableChildBean.getBaseOffsetX() + i6);
                        jSONObject.put("rightBottomRow", ((elementAttributeTableChildBean.getBaseOffsetY() + i5) + elementAttributeTableChildBean.getMergeHeight()) - 1);
                        jSONObject.put("rightBottomCol", ((elementAttributeTableChildBean.getBaseOffsetX() + i6) + elementAttributeTableChildBean.getMergeWidth()) - 1);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public int getOpenFrame() {
        return this.openFrame;
    }

    public int getRowsNum() {
        return this.rowsNum;
    }

    public ElementAttributeTableChildBean getSelectedChildBean() {
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    return elementAttributeTableChildBean;
                }
            }
        }
        return null;
    }

    public float getWordSpace() {
        float wordSpace = 0.0f;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (wordSpace == 0.0f) {
                        wordSpace = elementAttributeTableChildBean.getWordSpace();
                    } else if (wordSpace != elementAttributeTableChildBean.getWordSpace()) {
                        return 0.0f;
                    }
                }
            }
        }
        return wordSpace;
    }

    public void hiddenSelected() {
        this.editView = null;
        for (int i5 = 0; i5 <= getChildCount() - 1; i5++) {
            BaseTextView baseTextView = (BaseTextView) getChildAt(i5);
            if (baseTextView != null) {
                baseTextView.setTag(d.table_select, Boolean.FALSE);
                baseTextView.setBackgroundColor(getResources().getColor(p113u.a.color_00FFFFFF));
            }
        }
        for (int i6 = 0; i6 < this.tableData.size(); i6++) {
            for (int i7 = 0; i7 < this.tableData.get(i6).size(); i7++) {
                this.tableData.get(i6).get(i7).setSelect(false);
            }
        }
    }

    public boolean isBold() {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (!elementAttributeTableChildBean.isIsBold()) {
                        return false;
                    }
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public boolean isDeleteLine() {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (!elementAttributeTableChildBean.isIsDeleteLine()) {
                        return false;
                    }
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public boolean isItalic() {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (!elementAttributeTableChildBean.isIsItalic()) {
                        return false;
                    }
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public boolean isOpenFrame() {
        return this.openFrame == 1;
    }

    public boolean isSingleSelectMode() {
        return this.selectMode == 1;
    }

    public boolean isUnderLine() {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    if (!elementAttributeTableChildBean.isIsUnderLine()) {
                        return false;
                    }
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public boolean merge() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() <= 1) {
            return false;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, this.rowsNum, this.columnsNum);
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
            Integer numValueOf2 = Integer.valueOf(strArrSplit3[0]);
            for (int iIntValue = numValueOf.intValue(); iIntValue < Integer.valueOf(strArrSplit2[1]).intValue() + numValueOf.intValue(); iIntValue++) {
                for (int iIntValue2 = numValueOf2.intValue(); iIntValue2 < Integer.valueOf(strArrSplit3[1]).intValue() + numValueOf2.intValue(); iIntValue2++) {
                    iArr[iIntValue][iIntValue2] = 1;
                }
            }
        }
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = 0;
            while (true) {
                int[] iArr2 = iArr[i9];
                if (i10 < iArr2.length) {
                    if (iArr2[i10] != 1) {
                        if (i5 <= i9 && i9 <= i7 && i6 != -1 && i6 <= i10 && i10 <= i8) {
                            return false;
                        }
                    } else if (i5 == -1) {
                        i5 = i9;
                        i7 = i5;
                        i6 = i10;
                        i8 = i6;
                    } else {
                        if (i9 > i7) {
                            i7 = i9;
                        }
                        if (i9 < i5) {
                            return false;
                        }
                        if (i10 > i8) {
                            i8 = i10;
                        }
                        if (i10 < i6) {
                            return false;
                        }
                    }
                    i10++;
                }
            }
        }
        for (int i11 = i5; i11 <= i7; i11++) {
            for (int i12 = i6; i12 <= i8; i12++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i11).get(i12);
                if (i11 == i5 && i12 == i6) {
                    elementAttributeTableChildBean.setBaseOffsetX(0);
                    elementAttributeTableChildBean.setBaseOffsetY(0);
                    elementAttributeTableChildBean.setMergeHeight((i7 - i5) + 1);
                    elementAttributeTableChildBean.setMergeWidth((i8 - i6) + 1);
                    elementAttributeTableChildBean.setShowCell(true);
                } else {
                    elementAttributeTableChildBean.setBaseOffsetX(i6 - i12);
                    elementAttributeTableChildBean.setBaseOffsetY(i5 - i11);
                    elementAttributeTableChildBean.setMergeHeight((i7 - i5) + 1);
                    elementAttributeTableChildBean.setMergeWidth((i8 - i6) + 1);
                    elementAttributeTableChildBean.setShowCell(false);
                }
            }
        }
        paintingTable(true, false);
        return true;
    }

    public void refreshTable(int i5, int i6) {
        Iterator<ElementAttributeTableChildBean> it = this.tableData.get(0).iterator();
        int iMm2pxWithScale = 0;
        while (it.hasNext()) {
            iMm2pxWithScale += C1849c.mm2pxWithScale(it.next().getColumnsWidth());
        }
        Iterator<List<ElementAttributeTableChildBean>> it2 = this.tableData.iterator();
        int iMm2pxWithScale2 = 0;
        while (it2.hasNext()) {
            iMm2pxWithScale2 += C1849c.mm2pxWithScale(it2.next().get(0).getRowsHeight());
        }
        int frameLineSize = getFrameLineSize();
        int i7 = this.columnsNum;
        float f6 = ((i5 - ((i7 + 1) * frameLineSize)) - iMm2pxWithScale) / i7;
        int i8 = this.rowsNum;
        float f7 = ((i6 - ((i8 + 1) * frameLineSize)) - iMm2pxWithScale2) / i8;
        Iterator<List<ElementAttributeTableChildBean>> it3 = this.tableData.iterator();
        while (it3.hasNext()) {
            for (ElementAttributeTableChildBean elementAttributeTableChildBean : it3.next()) {
                elementAttributeTableChildBean.setColumnsWidth(C1849c.px2mmWithScale(f6) + elementAttributeTableChildBean.getColumnsWidth());
                elementAttributeTableChildBean.setRowsHeight(C1849c.px2mmWithScale(f7) + elementAttributeTableChildBean.getRowsHeight());
            }
        }
        this.tempWidth = i5;
        this.tempHeight = i6;
        paintingTable(false, false);
    }

    public boolean removeColumnOnSelectedLeft() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer.valueOf(strArrSplit2[0]);
            Integer numValueOf = Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(numValueOf)) {
                arrayList.add(numValueOf);
            }
        }
        arrayList.sort(new I4.a(4));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            if (num.intValue() != 0) {
                removeColumn(num.intValue() - 1);
            }
        }
        paintingTable(true, false);
        return true;
    }

    public boolean removeColumnOnSelectedRight() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer.valueOf(strArrSplit2[0]);
            Integer numValueOf = Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer numValueOf2 = Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1))) {
                arrayList.add(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1));
            }
        }
        arrayList.sort(new I4.a(9));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            if (num.intValue() != this.tableData.get(0).size() - 1) {
                removeColumn(num.intValue() + 1);
            }
        }
        paintingTable(true, false);
        return true;
    }

    public boolean removeColumnOnTableRight(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.tableData.get(0).size() == 1) {
                return false;
            }
            removeColumn(this.tableData.get(0).size() - 1);
        }
        paintingTable(true, false);
        return true;
    }

    public boolean removeRowOnSelectedBottom() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
            Integer.valueOf(strArrSplit3[0]);
            Integer numValueOf2 = Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1))) {
                arrayList.add(Integer.valueOf((numValueOf2.intValue() + numValueOf.intValue()) - 1));
            }
        }
        arrayList.sort(new I4.a(8));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            if (num.intValue() != this.tableData.size() - 1) {
                removeRow(num.intValue() + 1);
            }
        }
        paintingTable(true, false);
        return true;
    }

    public boolean removeRowOnSelectedTop() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = selectElements.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(",");
            String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
            Integer.valueOf(strArrSplit3[0]);
            Integer.valueOf(strArrSplit2[1]);
            Integer.valueOf(strArrSplit3[1]);
            if (!arrayList.contains(numValueOf)) {
                arrayList.add(numValueOf);
            }
        }
        arrayList.sort(new I4.a(5));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Integer num = (Integer) obj;
            if (num.intValue() != 0) {
                removeRow(num.intValue() - 1);
            }
        }
        paintingTable(true, false);
        return true;
    }

    public boolean removeRowOnTableBottom(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.tableData.size() == 1) {
                return false;
            }
            removeRow(this.tableData.size() - 1);
        }
        paintingTable(true, false);
        return true;
    }

    public void removeSelectChangedListener(onSelectChangedListener onselectchangedlistener) {
        onSelectChangedListener onselectchangedlistener2 = this.onSelectChangedListener;
        if (onselectchangedlistener2 == null || onselectchangedlistener2 != onselectchangedlistener) {
            return;
        }
        this.onSelectChangedListener = null;
    }

    public void resetSelected() {
        for (int i5 = 0; i5 <= getChildCount() - 1; i5++) {
            BaseTextView baseTextView = (BaseTextView) getChildAt(i5);
            if (baseTextView != null) {
                baseTextView.setBackgroundColor(getResources().getColor(((Boolean) baseTextView.getTag(d.table_select)).booleanValue() ? p113u.a.color_FFAE00 : p113u.a.color_00FFFFFF));
            }
        }
    }

    public void scale() {
        if (this.tableData.size() <= 0) {
            return;
        }
        int frameLineSize = getFrameLineSize();
        float tableLineSize = getTableLineSize();
        setPadding(frameLineSize, frameLineSize, frameLineSize, frameLineSize);
        int i5 = 0;
        int i6 = 0;
        float rowsHeight = 0.0f;
        float columnsWidth = 0.0f;
        while (i6 <= this.tableData.size() - 1) {
            rowsHeight = i6 == 0 ? 0.0f : this.tableData.get(i6 - 1).get(i5).getRowsHeight() + tableLineSize + rowsHeight;
            int i7 = i5;
            while (i7 <= this.tableData.get(i6).size() - 1) {
                columnsWidth = i7 == 0 ? 0.0f : this.tableData.get(i6).get(i7 - 1).getColumnsWidth() + tableLineSize + columnsWidth;
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(i7);
                if (!elementAttributeTableChildBean.isMergeCell()) {
                    float rowsHeight2 = elementAttributeTableChildBean.getRowsHeight();
                    float columnsWidth2 = elementAttributeTableChildBean.getColumnsWidth();
                    BaseTextView baseTextView = (BaseTextView) findViewWithTag(String.format("%d:1,%d:1", Integer.valueOf(i6), Integer.valueOf(i7)));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) baseTextView.getLayoutParams();
                    layoutParams.width = C1849c.mm2pxWithScale(columnsWidth2);
                    layoutParams.height = C1849c.mm2pxWithScale(rowsHeight2);
                    layoutParams.topMargin = C1849c.mm2pxWithScale(rowsHeight);
                    layoutParams.leftMargin = C1849c.mm2pxWithScale(columnsWidth);
                    baseTextView.setLayoutParams(layoutParams);
                    baseTextView.scale(C1849c.mm2pxWithScale(columnsWidth2), C1849c.mm2pxWithScale(rowsHeight2));
                } else if (elementAttributeTableChildBean.isShowCell()) {
                    int baseOffsetY = elementAttributeTableChildBean.getBaseOffsetY() + i6;
                    int baseOffsetX = elementAttributeTableChildBean.getBaseOffsetX() + i7;
                    float columnsWidth3 = 0.0f;
                    for (int i8 = baseOffsetX; i8 < elementAttributeTableChildBean.getMergeWidth() + baseOffsetX; i8++) {
                        columnsWidth3 += this.tableData.get(baseOffsetY).get(i8).getColumnsWidth() + tableLineSize;
                    }
                    float rowsHeight3 = 0.0f;
                    for (int i9 = baseOffsetY; i9 < elementAttributeTableChildBean.getMergeHeight() + baseOffsetY; i9++) {
                        rowsHeight3 += this.tableData.get(i9).get(baseOffsetX).getRowsHeight() + tableLineSize;
                    }
                    float columnsWidth4 = rowsHeight;
                    for (int i10 = baseOffsetY; i10 < i6; i10++) {
                        columnsWidth4 -= this.tableData.get(i10).get(baseOffsetX).getColumnsWidth() + tableLineSize;
                    }
                    float rowsHeight4 = columnsWidth;
                    for (int i11 = baseOffsetX; i11 < i7; i11++) {
                        rowsHeight4 -= this.tableData.get(baseOffsetY).get(i11).getRowsHeight() + tableLineSize;
                    }
                    BaseTextView baseTextView2 = (BaseTextView) findViewWithTag(String.format("%d:%d,%d:%d", Integer.valueOf(baseOffsetY), Integer.valueOf(elementAttributeTableChildBean.getMergeHeight()), Integer.valueOf(baseOffsetX), Integer.valueOf(elementAttributeTableChildBean.getMergeWidth())));
                    if (baseTextView2 != null) {
                        baseTextView2.setRealWidth(columnsWidth3);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) baseTextView2.getLayoutParams();
                        layoutParams2.width = C1849c.mm2pxWithScale(columnsWidth3);
                        layoutParams2.height = C1849c.mm2pxWithScale(rowsHeight3);
                        layoutParams2.topMargin = C1849c.mm2pxWithScale(columnsWidth4);
                        layoutParams2.leftMargin = C1849c.mm2pxWithScale(rowsHeight4);
                        baseTextView2.setLayoutParams(layoutParams2);
                        baseTextView2.scale(C1849c.mm2pxWithScale(columnsWidth3), C1849c.mm2pxWithScale(rowsHeight3));
                    }
                }
                i7++;
            }
            i6++;
            i5 = 0;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            ElementAttributeTableChildBean elementAttributeTableChildBean2 = (ElementAttributeTableChildBean) ((List) AbstractC0157z.f(1, this.tableData)).get(((List) AbstractC0157z.f(1, this.tableData)).size() - 1);
            float f6 = tableLineSize * 2.0f;
            float rowsHeight5 = elementAttributeTableChildBean2.getRowsHeight() + rowsHeight + f6;
            float columnsWidth5 = elementAttributeTableChildBean2.getColumnsWidth() + columnsWidth + f6;
            ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
            layoutParams3.width = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() + C1849c.mm2pxWithScale(columnsWidth5);
            layoutParams3.height = viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() + C1849c.mm2pxWithScale(rowsHeight5);
            viewGroup.setLayoutParams(layoutParams3);
            this.tempWidth = layoutParams3.width;
            this.tempHeight = layoutParams3.height;
            p051j0.a.d("BaseTableView", "totalWidth=" + columnsWidth5 + ",totalHeight=" + rowsHeight5);
        }
    }

    public void select(BaseTextView baseTextView) {
        int i5 = d.table_select;
        if (((Boolean) baseTextView.getTag(i5)).booleanValue()) {
            return;
        }
        if (this.selectMode == 1) {
            hiddenSelected();
        }
        String str = (String) baseTextView.getTag();
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
        Integer numValueOf2 = Integer.valueOf(strArrSplit3[0]);
        Integer numValueOf3 = Integer.valueOf(strArrSplit2[1]);
        Integer numValueOf4 = Integer.valueOf(strArrSplit3[1]);
        baseTextView.setBackgroundColor(getResources().getColor(p113u.a.color_FFAE00));
        baseTextView.setTag(i5, Boolean.TRUE);
        for (int iIntValue = numValueOf.intValue(); iIntValue < numValueOf3.intValue() + numValueOf.intValue(); iIntValue++) {
            for (int iIntValue2 = numValueOf2.intValue(); iIntValue2 < numValueOf4.intValue() + numValueOf2.intValue(); iIntValue2++) {
                this.tableData.get(iIntValue).get(iIntValue2).setSelect(true);
            }
        }
        if (this.selectMode == 1) {
            this.editView = baseTextView;
        }
        onSelectChangedListener onselectchangedlistener = this.onSelectChangedListener;
        if (onselectchangedlistener != null) {
            onselectchangedlistener.onChanged(baseTextView, str);
        }
    }

    public boolean setBold(boolean z6) {
        boolean z7 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setIsBold(z6);
                    z7 = true;
                }
            }
        }
        paintingTable(true, false);
        return z7;
    }

    public void setCells(JSONArray jSONArray, JSONArray jSONArray2) {
        this.tableData.clear();
        List listA = p052j2.c.a(List.class, jSONArray.toString());
        this.rowsNum = listA.size();
        this.columnsNum = ((List) listA.get(0)).size();
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            this.tableData.add(p052j2.c.b((List) it.next(), ElementAttributeTableChildBean.class));
        }
        if (jSONArray2 != null) {
            for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                try {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i5);
                    int i6 = jSONObject.getInt("leftTopRow");
                    int i7 = jSONObject.getInt("leftTopCol");
                    int i8 = jSONObject.getInt("rightBottomRow");
                    int i9 = jSONObject.getInt("rightBottomCol");
                    for (int i10 = i6; i10 <= i8; i10++) {
                        for (int i11 = i7; i11 <= i9; i11++) {
                            if (i10 == i6 && i11 == i7) {
                                this.tableData.get(i10).get(i11).setShowCell(true);
                                this.tableData.get(i10).get(i11).setBaseOffsetX(0);
                                this.tableData.get(i10).get(i11).setBaseOffsetY(0);
                                this.tableData.get(i10).get(i11).setMergeWidth((i9 - i7) + 1);
                                this.tableData.get(i10).get(i11).setMergeHeight((i8 - i6) + 1);
                            } else {
                                this.tableData.get(i10).get(i11).setShowCell(false);
                                this.tableData.get(i10).get(i11).setBaseOffsetX(i7 - i11);
                                this.tableData.get(i10).get(i11).setBaseOffsetY(i6 - i10);
                                this.tableData.get(i10).get(i11).setMergeWidth((i9 - i7) + 1);
                                this.tableData.get(i10).get(i11).setMergeHeight((i8 - i6) + 1);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        paintingTable(true, false);
    }

    public void setColWidth(float f6) {
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect() && elementAttributeTableChildBean.getColumnsWidth() != f6) {
                    for (int i7 = 0; i7 < this.tableData.size(); i7++) {
                        this.tableData.get(i7).get(i6).setColumnsWidth(f6);
                    }
                    break;
                }
            }
        }
        paintingTable(true, false);
    }

    public void setColorType(int i5) {
        if (this.colorType != i5) {
            this.colorType = i5;
            updateColors();
            invalidate();
        }
    }

    public void setColumnsNum(int i5) {
        this.columnsNum = i5;
    }

    public void setContent(String str) {
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setContent(str);
                }
            }
        }
        paintingTable(true, false);
    }

    public boolean setDeleteLine(boolean z6) {
        boolean z7 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setIsDeleteLine(z6);
                    z7 = true;
                }
            }
        }
        paintingTable(true, false);
        return z7;
    }

    public void setEditView(int i5, int i6) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (getChildAt(i7) instanceof BaseTextView) {
                BaseTextView baseTextView = (BaseTextView) getChildAt(i7);
                if (baseTextView.getTag().equals(String.format("%d:1,%d:1", Integer.valueOf(i5), Integer.valueOf(i6)))) {
                    baseTextView.setTag(d.table_select, Boolean.TRUE);
                    this.editView = baseTextView;
                    break;
                }
            }
        }
        resetSelected();
    }

    public boolean setFont(String str) {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setFontId(str);
                    z6 = true;
                }
            }
        }
        paintingTable(true, false);
        return z6;
    }

    public boolean setFontAligment(int i5) {
        boolean z6 = false;
        for (int i6 = 0; i6 < this.tableData.size(); i6++) {
            for (int i7 = 0; i7 < this.tableData.get(i6).size(); i7++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(i7);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setAligment(i5);
                    z6 = true;
                }
            }
        }
        paintingTable(true, false);
        return z6;
    }

    public boolean setFontSize(int i5) {
        boolean z6 = false;
        for (int i6 = 0; i6 < this.tableData.size(); i6++) {
            for (int i7 = 0; i7 < this.tableData.get(i6).size(); i7++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i6).get(i7);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setFontSize(i5);
                    z6 = true;
                }
            }
        }
        paintingTable(true, false);
        return z6;
    }

    public boolean setItalic(boolean z6) {
        boolean z7 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setIsItalic(z6);
                    z7 = true;
                }
            }
        }
        paintingTable(true, false);
        return z7;
    }

    public void setLineSize(float f6) {
        this.lineSize = f6;
        paintingTable(true, false);
    }

    public boolean setLinesSpace(float f6) {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setLinesSpace(f6);
                    z6 = true;
                }
            }
        }
        paintingTable(true, false);
        return z6;
    }

    public void setOnEditChangedListener(OnEditChangedListener onEditChangedListener) {
        this.onEditChangedListener = onEditChangedListener;
    }

    public void setOnSelectChangedListener(onSelectChangedListener onselectchangedlistener) {
        this.onSelectChangedListener = onselectchangedlistener;
    }

    public void setOpenFrame(boolean z6) {
        this.openFrame = z6 ? 1 : 0;
        paintingTable(true, false);
    }

    public void setRowHeight(float f6) {
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                if (this.tableData.get(i5).get(i6).isSelect()) {
                    for (int i7 = 0; i7 < this.tableData.get(i5).size(); i7++) {
                        this.tableData.get(i5).get(i7).setRowsHeight(f6);
                    }
                    break;
                }
            }
        }
        paintingTable(true, false);
    }

    public void setRowsNum(int i5) {
        this.rowsNum = i5;
    }

    public void setShow(boolean z6) {
        this.isShow = z6;
    }

    public void setSingleSelectMode(boolean z6) {
        this.selectMode = z6 ? 1 : 2;
    }

    public boolean setUnderLine(boolean z6) {
        boolean z7 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setIsUnderLine(z6);
                    z7 = true;
                }
            }
        }
        paintingTable(true, false);
        return z7;
    }

    public boolean setWordSpace(float f6) {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.tableData.size(); i5++) {
            for (int i6 = 0; i6 < this.tableData.get(i5).size(); i6++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(i5).get(i6);
                if (elementAttributeTableChildBean.isSelect()) {
                    elementAttributeTableChildBean.setWordSpace(f6);
                    z6 = true;
                }
            }
        }
        paintingTable(true, false);
        return z6;
    }

    public boolean split() {
        List<String> selectElements = getSelectElements();
        if (selectElements.size() != 1) {
            return false;
        }
        String[] strArrSplit = selectElements.get(0).split(",");
        String[] strArrSplit2 = strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String[] strArrSplit3 = strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        Integer numValueOf = Integer.valueOf(strArrSplit2[0]);
        Integer numValueOf2 = Integer.valueOf(strArrSplit3[0]);
        Integer numValueOf3 = Integer.valueOf(strArrSplit2[1]);
        Integer numValueOf4 = Integer.valueOf(strArrSplit3[1]);
        for (int iIntValue = numValueOf.intValue(); iIntValue < numValueOf3.intValue() + numValueOf.intValue(); iIntValue++) {
            for (int iIntValue2 = numValueOf2.intValue(); iIntValue2 < numValueOf4.intValue() + numValueOf2.intValue(); iIntValue2++) {
                ElementAttributeTableChildBean elementAttributeTableChildBean = this.tableData.get(iIntValue).get(iIntValue2);
                elementAttributeTableChildBean.setBaseOffsetX(0);
                elementAttributeTableChildBean.setBaseOffsetY(0);
                elementAttributeTableChildBean.setMergeWidth(1);
                elementAttributeTableChildBean.setMergeHeight(1);
                elementAttributeTableChildBean.setShowCell(true);
            }
        }
        paintingTable(true, false);
        return true;
    }

    public BaseTextView testHitCell(int i5, int i6) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 <= getChildCount() - 1; i7++) {
            BaseTextView baseTextView = (BaseTextView) getChildAt(i7);
            if (baseTextView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) baseTextView.getLayoutParams();
                int i8 = marginLayoutParams.leftMargin + paddingLeft;
                int i9 = marginLayoutParams.topMargin + paddingTop;
                int width = baseTextView.getWidth() + i8;
                int height = baseTextView.getHeight() + i9;
                if (i5 >= i8 && i5 <= width && i6 >= i9 && i6 <= height) {
                    return baseTextView;
                }
            }
        }
        return null;
    }

    public void setOpenFrame(int i5) {
        this.openFrame = i5;
        paintingTable(true, false);
    }

    public BaseTableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTableView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.colorType = 0;
        this.TAG = "BaseTableView";
        this.lineSize = 0.5f;
        this.isShow = false;
        this.openFrame = 1;
        this.tempWidth = 0;
        this.tempHeight = 0;
        this.tableData = new ArrayList();
        this.selectMode = 1;
        this.editView = null;
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_FONTTYPE = "fontId";
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_H_ALALIGNMENT = "aligment";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.KEY_ROWS_HEIGHT = "rowsHeight";
        this.KEY_COLUMNS_WIDTH = "columnsWidth";
        this.KEY_WORDSPACE = "wordSpace";
        this.KEY_LINESSPACE = "linesSpace";
        this.onEditChangedListener = null;
        this.onSelectChangedListener = null;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTableView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (BaseTableView.this.onEditChangedListener == null) {
                    return true;
                }
                BaseTableView.this.onEditChangedListener.onChanged(null, null);
                return true;
            }
        });
        post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTableView.4
            @Override // java.lang.Runnable
            public void run() {
                BaseTableView.this.initView();
            }
        });
    }
}
