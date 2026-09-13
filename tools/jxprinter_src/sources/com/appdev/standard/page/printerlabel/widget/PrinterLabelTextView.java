package com.appdev.standard.page.printerlabel.widget;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;
import p056k0.g;
import p113u.d;
import p113u.e;
import p134x2.K;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelTextView extends IDTControlView {
    private static final int COLOR_BLACK = 0;
    private static final int COLOR_RED = 1;
    private static final String KEY_COLOR_TYPE = "colorType";
    protected final String KEY_AUTOMATICHEIGHTCALCULATION;
    protected final String KEY_BOLD;
    protected final String KEY_CONTENT;
    protected final String KEY_DARK_MODE;
    protected final String KEY_DIRECTION;
    protected final String KEY_EXCELFILEURL;
    protected final String KEY_EXCELHEADERCOLUMN;
    protected final String KEY_EXCELNAME;
    protected final String KEY_FONTTYPE;
    protected final String KEY_H_ALALIGNMENT;
    protected final String KEY_INPUTDATATYPE;
    protected final String KEY_INTERVAL;
    protected final String KEY_ISSHOWEXCELHEADER;
    protected final String KEY_ITALIC;
    protected final String KEY_LINESSPACE;
    protected final String KEY_PREFIX;
    protected final String KEY_STRIKETHROUGH;
    protected final String KEY_SUFFIX;
    protected final String KEY_TEXTSIZE;
    protected final String KEY_UNDERLINE;
    protected final String KEY_WORDSPACE;
    private boolean automaticHeightCalculation;
    private BaseTextView btv;
    private int columnIndex;
    private String commonContent;
    private int direction;
    private String excelName;
    private String excelUrl;
    private float lineSpaceMM;
    private float rootWidth;
    private String seqContent;
    private boolean showTableHeader;

    public PrinterLabelTextView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.btv = null;
        this.lineSpaceMM = -1.0f;
        this.commonContent = "";
        this.seqContent = "";
        this.automaticHeightCalculation = true;
        this.rootWidth = -1.0f;
        this.KEY_INPUTDATATYPE = "inputDataType";
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_WORDSPACE = "wordSpace";
        this.KEY_LINESSPACE = "linesSpace";
        this.KEY_AUTOMATICHEIGHTCALCULATION = "automaticHeightCalculation";
        this.KEY_FONTTYPE = "fontId";
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_H_ALALIGNMENT = "aligment";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.KEY_PREFIX = "prefix";
        this.KEY_SUFFIX = "suffix";
        this.KEY_INTERVAL = "interval";
        this.KEY_EXCELFILEURL = "excelFileUrl";
        this.KEY_EXCELNAME = "excelName";
        this.KEY_EXCELHEADERCOLUMN = "excelHeaderColumn";
        this.KEY_ISSHOWEXCELHEADER = "isShowExcelHeader";
        this.KEY_DIRECTION = "direction";
        this.KEY_DARK_MODE = "isDarkMode";
        this.btv = (BaseTextView) findViewById(d.btv_content);
        updateView();
        this.btv.setRealHeight(this.realHeight);
        this.btv.setRealWidth(this.realWidth);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return Videoio.CAP_QT;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 5;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public String getCommonContent() {
        return this.commonContent;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public String getControlViewContent() {
        return this.btv.getCurDataType() == 0 ? this.btv.getContent() : this.btv.getSeqContent();
    }

    public String getExcelName() {
        return this.excelName;
    }

    public String getExcelUrl() {
        return this.excelUrl;
    }

    public float getFontSize() {
        return this.btv.getTextSize();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put("inputDataType", this.inputDataType);
            this.saveObject.put(FirebaseAnalytics.Param.CONTENT, this.content);
            this.saveObject.put("wordSpace", this.btv.getWordSpace());
            this.saveObject.put("linesSpace", this.btv.getLinesSpace());
            this.saveObject.put("interval", this.interval);
            this.saveObject.put("prefix", this.prefix);
            this.saveObject.put("suffix", this.suffix);
            this.saveObject.put("fontId", this.btv.getFontType());
            this.saveObject.put("fontSize", this.btv.getTextSize());
            this.saveObject.put("aligment", this.btv.gethAlignment());
            this.saveObject.put("direction", this.btv.getDirection());
            this.saveObject.put("isBold", this.btv.isBold());
            this.saveObject.put("isItalic", this.btv.isItalic());
            this.saveObject.put("isUnderLine", this.btv.isUnderline());
            this.saveObject.put("isDeleteLine", this.btv.isStrikethrough());
            this.saveObject.put("excelFileUrl", this.excelUrl);
            this.saveObject.put("excelName", this.excelName);
            this.saveObject.put("excelHeaderColumn", this.columnIndex);
            this.saveObject.put("isShowExcelHeader", this.showTableHeader);
            this.saveObject.put(KEY_COLOR_TYPE, this.btv.getColorType());
            this.saveObject.put("isDarkMode", this.btv.isDarkMode());
        } catch (Exception e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int getLayoutHeight() {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
        int i5 = layoutParams.height;
        if (i5 >= 0) {
            return this.mBtnZoom.getHeight() + i5;
        }
        int i6 = layoutParams.width;
        if (i6 == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultWidth(), 1073741824);
        } else {
            iMakeMeasureSpec = i6 == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        int i7 = layoutParams.height;
        if (i7 == -1) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(defaultHeight(), 1073741824);
        } else {
            iMakeMeasureSpec2 = i7 == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        this.btv.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        return this.mBtnZoom.getHeight() + this.btv.getMeasuredHeight();
    }

    public String getSeqContent() {
        return this.seqContent;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public void intervalContentInMainThread(int i5) {
        String str;
        if (getInputDataType() != 2) {
            super.intervalContentInMainThread(i5);
            return;
        }
        if (i5 == 0 || (str = this.excelUrl) == null || str.isEmpty()) {
            return;
        }
        K cellInfo = g.readCellInfo(this.excelUrl, i5 + 1, this.columnIndex);
        if (cellInfo.a()) {
            p051j0.a.k("PrinterLabelTextView", "intervalContentInMainThread: " + cellInfo.exceptionOrNull());
            return;
        }
        p056k0.c cVar = (p056k0.c) cellInfo.getOrNull();
        if (cVar == null) {
            return;
        }
        if (this.showTableHeader) {
            setControlViewContent(cVar.getName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + cVar.getValue());
        } else {
            setControlViewContent(cVar.getValue());
        }
        int left = this.mRoot.getLeft();
        int top = this.mRoot.getTop();
        this.mRoot.measure(View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgHeight(), Integer.MIN_VALUE));
        RelativeLayout relativeLayout = this.mRoot;
        relativeLayout.layout(left, top, relativeLayout.getMeasuredWidth() + left, this.mRoot.getMeasuredHeight() + top);
    }

    public boolean isShowTableHeader() {
        return this.showTableHeader;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_text_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 30;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        int i7;
        int i8;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
        if ((this.btv.getCurDataType() == 0 || this.btv.getCurDataType() == 2) && this.automaticHeightCalculation) {
            int i9 = 0;
            if (layoutParams.width >= 0) {
                this.btv.setNeedRefresh();
                this.btv.measure(View.MeasureSpec.makeMeasureSpec((layoutParams.width - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                int paddingRight = this.mRoot.getPaddingRight() + this.mRoot.getPaddingLeft() + this.btv.getMeasuredWidth();
                this.btv.getMeasuredHeight();
                this.mRoot.getPaddingTop();
                this.mRoot.getPaddingBottom();
                if (paddingRight != i5) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                    if (getRotationAngle() == 90) {
                        int i10 = paddingRight - i5;
                        int i11 = 0 / 2;
                        i9 = ((-i10) / 2) - i11;
                        i8 = (i10 / 2) - i11;
                    } else if (getRotationAngle() == 270) {
                        int i12 = (-(paddingRight - i5)) / 2;
                        int i13 = 0 / 2;
                        int i14 = i12 + i13;
                        i8 = i12 - i13;
                        i9 = i14;
                    } else if (getRotationAngle() == 180) {
                        i9 = -(paddingRight - i5);
                        i8 = -0;
                    } else {
                        i8 = 0;
                    }
                    layoutParams2.leftMargin += i9;
                    layoutParams2.topMargin += i8;
                    setLayoutParams(layoutParams2);
                    layoutParams.width = paddingRight;
                    this.mRoot.setLayoutParams(layoutParams);
                    i5 = paddingRight;
                }
            } else if (layoutParams.height >= 0) {
                this.btv.setNeedRefresh();
                this.btv.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec((layoutParams.height - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom(), 1073741824));
                this.btv.getMeasuredWidth();
                this.mRoot.getPaddingLeft();
                this.mRoot.getPaddingRight();
                int paddingBottom = this.mRoot.getPaddingBottom() + this.mRoot.getPaddingTop() + this.btv.getMeasuredHeight();
                if (paddingBottom != i6) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getLayoutParams();
                    if (getRotationAngle() == 90) {
                        int i15 = (paddingBottom - i6) / 2;
                        int i16 = ((-0) / 2) - i15;
                        i7 = (0 / 2) - i15;
                        i9 = i16;
                    } else if (getRotationAngle() == 270) {
                        int i17 = (-0) / 2;
                        int i18 = (paddingBottom - i6) / 2;
                        i9 = i17 + i18;
                        i7 = i17 - i18;
                    } else if (getRotationAngle() == 180) {
                        i9 = -0;
                        i7 = -(paddingBottom - i6);
                    } else {
                        i7 = 0;
                    }
                    layoutParams3.leftMargin += i9;
                    layoutParams3.topMargin += i7;
                    setLayoutParams(layoutParams3);
                    layoutParams.height = paddingBottom;
                    this.mRoot.setLayoutParams(layoutParams);
                    i6 = paddingBottom;
                }
                this.btv.requestLayout();
            }
        }
        super.onSizeChanged(i5, i6);
        updateRealSize();
        this.btv.setRealWidth(this.realWidth);
        this.btv.setRealHeight(this.realHeight);
        this.btv.setNeedRefresh();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        try {
            this.btv.setDirection(getObjectInt(jSONObject, "direction", 0));
            super.recoverFromJson(jSONObject);
            this.inputDataType = getObjectInt(jSONObject, "inputDataType", 0);
            this.content = getObjectString(jSONObject, FirebaseAnalytics.Param.CONTENT, "");
            this.interval = getObjectInt(jSONObject, "interval", 1);
            this.prefix = getObjectString(jSONObject, "prefix", "");
            this.suffix = getObjectString(jSONObject, "suffix", "");
            this.excelUrl = getObjectString(jSONObject, "excelFileUrl", "");
            this.excelName = getObjectString(jSONObject, "excelName", "");
            this.columnIndex = getObjectInt(jSONObject, "excelHeaderColumn", 0);
            this.showTableHeader = getObjectBoolean(jSONObject, "isShowExcelHeader");
            this.direction = getObjectInt(jSONObject, "direction", 0);
            this.btv.setCurDataType(this.inputDataType);
            int i5 = this.inputDataType;
            if (i5 == 0) {
                String str = this.content;
                this.commonContent = str;
                this.seqContent = str;
                this.btv.setContent(str);
            } else if (i5 == 1) {
                String str2 = this.content;
                this.commonContent = str2;
                this.seqContent = str2;
                this.btv.setSeqContent(this.prefix + this.content + this.suffix);
            } else if (i5 != 2) {
                String str3 = this.content;
                this.commonContent = str3;
                this.seqContent = str3;
                this.btv.setContent(str3);
            } else {
                String str4 = this.content;
                this.commonContent = str4;
                this.seqContent = str4;
                this.btv.setContent(str4);
            }
            BaseTextView baseTextView = this.btv;
            baseTextView.setWordSpace(getObjectFloat(jSONObject, "wordSpace", baseTextView.getWordSpace()));
            BaseTextView baseTextView2 = this.btv;
            baseTextView2.setLinesSpace(getObjectFloat(jSONObject, "linesSpace", baseTextView2.getLinesSpace()));
            this.btv.setFontType(getObjectString(jSONObject, "fontId", "0"));
            BaseTextView baseTextView3 = this.btv;
            baseTextView3.setTextSize(getObjectFloat(jSONObject, "fontSize", baseTextView3.getTextSize()));
            this.btv.sethAlignment(getObjectInt(jSONObject, "aligment", 0));
            this.btv.setBold(getObjectBoolean(jSONObject, "isBold"));
            this.btv.setItalic(getObjectBoolean(jSONObject, "isItalic"));
            this.btv.setUnderline(getObjectBoolean(jSONObject, "isUnderLine"));
            this.btv.setStrikethrough(getObjectBoolean(jSONObject, "isDeleteLine"));
            this.btv.setRealWidth(this.realWidth);
            this.btv.setRealHeight(this.realHeight);
            int objectInt = getObjectInt(jSONObject, KEY_COLOR_TYPE, 0);
            this.btv.setColorType(objectInt);
            boolean objectBoolean = getObjectBoolean(jSONObject, "isDarkMode");
            this.btv.setDarkMode(objectBoolean);
            if (objectBoolean) {
                this.btv.setTextColor(-1);
            } else {
                this.btv.setTextColor(objectInt == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
            }
            if (getObjectInt(jSONObject, "direction", 0) == 3) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
                if (this.mRoot.getHeight() > 0) {
                    layoutParams.width = this.mRoot.getHeight();
                    layoutParams.height = -2;
                    this.mRoot.setLayoutParams(layoutParams);
                    updateRealSize();
                    this.btv.setRealWidth(this.realWidth);
                }
                onSizeChanged(layoutParams.width, layoutParams.height);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    public void setColumnIndex(int i5) {
        this.columnIndex = i5;
    }

    public void setCommonContent(String str) {
        this.commonContent = str;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public void setControlViewContent(String str) {
        if (this.btv.getCurDataType() == 0) {
            this.btv.setContent(str);
        } else {
            this.btv.setSeqContent(str);
        }
        updateView();
    }

    public void setExcelName(String str) {
        this.excelName = str;
    }

    public void setExcelUrl(String str) {
        this.excelUrl = str;
    }

    public void setSeqContent(String str) {
        this.seqContent = str;
    }

    public void setShowTableHeader(boolean z6) {
        this.showTableHeader = z6;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btv.getLayoutParams();
        int i5 = layoutParams.width;
        int i6 = layoutParams.height;
        int i7 = 2;
        if (this.btv.getCurDataType() != 0 && this.btv.getCurDataType() != 2) {
            if (this.rootWidth == -1.0f) {
                if (this.btv.getDirection() == 2) {
                    if (this.mRoot.getHeight() > 0) {
                        this.rootWidth = this.templatePage.getScaleConvert().b(this.mRoot.getHeight());
                    }
                } else if (this.mRoot.getWidth() > 0) {
                    this.rootWidth = this.templatePage.getScaleConvert().b(this.mRoot.getWidth());
                }
            }
            layoutParams.width = -2;
            layoutParams.height = -2;
            i7 = 4;
        } else if (!this.automaticHeightCalculation) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else if (this.btv.getDirection() == 2) {
            layoutParams.width = -2;
            layoutParams.height = -1;
            if (this.rootWidth != -1.0f) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) this.mRoot.getLayoutParams());
                layoutParams2.height = this.templatePage.getScaleConvert().a(this.rootWidth);
                layoutParams2.width = -2;
                this.mRoot.setLayoutParams(layoutParams2);
                updateRealSize();
                this.btv.setRealHeight(this.realHeight);
                this.rootWidth = -1.0f;
            } else if (i5 == -1 && i6 == -2) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) this.mRoot.getLayoutParams());
                if (this.mRoot.getWidth() > 0) {
                    layoutParams3.height = this.mRoot.getWidth();
                    layoutParams3.width = -2;
                    this.mRoot.setLayoutParams(layoutParams3);
                    updateRealSize();
                    this.btv.setRealHeight(this.realHeight);
                }
            }
            i7 = 5;
        } else {
            layoutParams.width = -1;
            layoutParams.height = -2;
            i7 = 3;
            if (this.rootWidth != -1.0f) {
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) this.mRoot.getLayoutParams());
                layoutParams4.width = this.templatePage.getScaleConvert().a(this.rootWidth);
                layoutParams4.height = -2;
                this.mRoot.setLayoutParams(layoutParams4);
                updateRealSize();
                this.btv.setRealWidth(this.realWidth);
                this.rootWidth = -1.0f;
            } else if (i5 == -2 && i6 == -1) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) this.mRoot.getLayoutParams());
                if (this.btv.getDirection() != 3 && this.mRoot.getHeight() > 0) {
                    layoutParams5.width = this.mRoot.getHeight();
                }
                layoutParams5.height = -2;
                this.mRoot.setLayoutParams(layoutParams5);
                updateRealSize();
                this.btv.setRealWidth(this.realWidth);
            }
        }
        setControlType(i7);
        this.btv.setLayoutParams(layoutParams);
        this.isRenderingCompleted = true;
        super.updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateZoomedSize() {
        super.updateZoomedSize();
        this.btv.setRealWidth(this.realWidth);
        this.btv.setRealHeight(this.realHeight);
        updateView();
        this.btv.scale(this.templatePage.getScaleConvert().a(this.realWidth), this.templatePage.getScaleConvert().a(this.realHeight));
        if (this.templatePage.isLoadCompelete()) {
            return;
        }
        this.btv.setNeedRefresh();
    }

    public PrinterLabelTextView(TemplatePageView templatePageView, String str) {
        super(templatePageView);
        this.btv = null;
        this.lineSpaceMM = -1.0f;
        this.commonContent = "";
        this.seqContent = "";
        this.automaticHeightCalculation = true;
        this.rootWidth = -1.0f;
        this.KEY_INPUTDATATYPE = "inputDataType";
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_WORDSPACE = "wordSpace";
        this.KEY_LINESSPACE = "linesSpace";
        this.KEY_AUTOMATICHEIGHTCALCULATION = "automaticHeightCalculation";
        this.KEY_FONTTYPE = "fontId";
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_H_ALALIGNMENT = "aligment";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.KEY_PREFIX = "prefix";
        this.KEY_SUFFIX = "suffix";
        this.KEY_INTERVAL = "interval";
        this.KEY_EXCELFILEURL = "excelFileUrl";
        this.KEY_EXCELNAME = "excelName";
        this.KEY_EXCELHEADERCOLUMN = "excelHeaderColumn";
        this.KEY_ISSHOWEXCELHEADER = "isShowExcelHeader";
        this.KEY_DIRECTION = "direction";
        this.KEY_DARK_MODE = "isDarkMode";
        BaseTextView baseTextView = (BaseTextView) findViewById(d.btv_content);
        this.btv = baseTextView;
        baseTextView.setContent(str);
        this.content = str;
        this.commonContent = str;
        this.seqContent = str;
        updateView();
        this.btv.setRealHeight(this.realHeight);
        this.btv.setRealWidth(this.realWidth);
    }

    public PrinterLabelTextView(TemplatePageView templatePageView, String str, String str2, String str3, int i5, boolean z6) {
        super(templatePageView);
        this.btv = null;
        this.lineSpaceMM = -1.0f;
        this.commonContent = "";
        this.seqContent = "";
        this.automaticHeightCalculation = true;
        this.rootWidth = -1.0f;
        this.KEY_INPUTDATATYPE = "inputDataType";
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_WORDSPACE = "wordSpace";
        this.KEY_LINESSPACE = "linesSpace";
        this.KEY_AUTOMATICHEIGHTCALCULATION = "automaticHeightCalculation";
        this.KEY_FONTTYPE = "fontId";
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_H_ALALIGNMENT = "aligment";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.KEY_PREFIX = "prefix";
        this.KEY_SUFFIX = "suffix";
        this.KEY_INTERVAL = "interval";
        this.KEY_EXCELFILEURL = "excelFileUrl";
        this.KEY_EXCELNAME = "excelName";
        this.KEY_EXCELHEADERCOLUMN = "excelHeaderColumn";
        this.KEY_ISSHOWEXCELHEADER = "isShowExcelHeader";
        this.KEY_DIRECTION = "direction";
        this.KEY_DARK_MODE = "isDarkMode";
        BaseTextView baseTextView = (BaseTextView) findViewById(d.btv_content);
        this.btv = baseTextView;
        baseTextView.setContent(str);
        this.content = str;
        this.commonContent = str;
        this.seqContent = str;
        this.excelUrl = str2;
        this.excelName = str3;
        this.showTableHeader = z6;
        this.columnIndex = i5;
        this.inputDataType = 2;
        updateView();
        this.btv.setRealHeight(this.realHeight);
        this.btv.setRealWidth(this.realWidth);
    }
}
