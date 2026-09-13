package com.appdev.standard.page.printerlabel.widget;

import A3.AbstractC0157z;
import S4.d;
import S4.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.browser.trusted.sharing.ShareTarget;
import com.appdev.standard.model.PrintTaskElementModel;
import com.appdev.standard.model.PrintTaskModel;
import com.appdev.standard.model.TemplateEditBean;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import okhttp3.B;
import okhttp3.D;
import okhttp3.Q;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;
import p113u.i;
import p134x2.C1847b;
import p134x2.C1849c;
import p137y.f;
import p137y.g;
import p137y.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplatePageView extends RelativeLayout {
    private final String TAG;
    private int addViewLocalIndex;
    private int baseHeight;
    private int baseWidth;
    private int bgHeight;
    private int bgWidth;
    public boolean canEdit;
    private Context context;
    protected TemplateEditBean currentSaveNode;
    private int currentScrollY;
    private PrinterDottedLineView dottedLineView;
    private int editPos;
    private TemplatePageViewEvent eventListener;
    protected boolean hasEditTemplateConfig;
    private int initHeight;
    private int initWidth;
    private boolean isLoadCompelete;
    private boolean isMultipleMode;
    private boolean isWillPrintView;
    private PrinterLabelBgView labelBackground;
    private int labelHeight;
    private int labelHeightMM;
    private int labelWidth;
    private int labelWidthMM;
    private int marginH;
    private int marginV;
    private OnForwardBackwardStatusListener onForwardBackwardStatusListener;
    private int paperType;
    private String printerLabelBgBorderUrl;
    private String printerLabelBgUrl;
    private float scale;
    private C1847b scaleConvert;
    private int scaleHeight;
    private int scaleWidth;
    private int startX;
    private int startY;
    private List<TemplateEditBean> templateEdits;
    private JSONArray wantCreateElements;
    private float zoomScale;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DrawLabel2PrintBitmapEventListener {
        void onComplete(Bitmap[] bitmapArr);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DrawLabel2PrintBitmapInnerEventListener {
        void onComplete(int i5, Bitmap bitmap);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnForwardBackwardStatusListener {
        void onStatus(boolean z6, boolean z7);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TemplatePageViewEvent {
        void onLabelSizeChanged(int i5, int i6);

        void onLoadComplete();

        void onViewSizeChanged(int i5, int i6);
    }

    public TemplatePageView(Context context) {
        this(context, null);
    }

    private void addTemplateEdit(int i5, BaseControlView baseControlView, JSONObject... jSONObjectArr) {
        if (this.templateEdits != null) {
            TemplateEditBean templateEditBean = i5 == 3 ? new TemplateEditBean(i5, baseControlView, jSONObjectArr[0], jSONObjectArr[1]) : new TemplateEditBean(i5, baseControlView);
            if (this.editPos != this.templateEdits.size() - 1) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 <= this.editPos; i6++) {
                    arrayList.add(this.templateEdits.get(i6));
                }
                this.templateEdits = arrayList;
            }
            this.templateEdits.add(templateEditBean);
            this.editPos++;
        }
        notifyForwardBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseControlView getControlView(int i5) {
        View childAt = getChildAt(i5);
        if (childAt instanceof BaseControlView) {
            return (BaseControlView) childAt;
        }
        return null;
    }

    private void initView() {
        this.baseWidth = getWidth();
        this.baseHeight = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (this.canEdit) {
            this.scale = (this.baseWidth - this.marginH) / this.labelWidth;
            p051j0.a.k(this.TAG, "scale:   " + this.scale);
            float f6 = (float) this.labelWidth;
            float f7 = this.scale;
            int i5 = (int) (f6 * f7);
            this.bgWidth = i5;
            int i6 = (int) (this.labelHeight * f7);
            this.bgHeight = i6;
            int i7 = this.marginH;
            this.scaleWidth = i5 + i7;
            int i8 = this.marginV;
            this.scaleHeight = i6 + i8;
            this.startX = i7;
            this.startY = i8;
            this.initWidth = i5;
            this.initHeight = i6;
            PrinterLabelBgView printerLabelBgView = new PrinterLabelBgView(this);
            this.labelBackground = printerLabelBgView;
            printerLabelBgView.initBgView(this.bgWidth, this.bgHeight);
            this.labelBackground.setBackground(this.printerLabelBgUrl, this.printerLabelBgBorderUrl, this.paperType);
            this.labelBackground.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            addElementView(this.labelBackground, false);
            marginLayoutParams.width = this.scaleWidth;
            marginLayoutParams.height = this.scaleHeight;
            setLayoutParams(marginLayoutParams);
            addDottedLine();
        } else {
            float fMin = Math.min((this.baseWidth - this.marginH) / this.labelWidth, (this.baseHeight - this.marginV) / this.labelHeight);
            this.scale = fMin;
            int i9 = (int) (this.labelWidth * fMin);
            this.bgWidth = i9;
            int i10 = (int) (this.labelHeight * fMin);
            this.bgHeight = i10;
            int i11 = this.marginH;
            this.scaleWidth = i9 + i11;
            int i12 = this.marginV;
            this.scaleHeight = i10 + i12;
            this.startX = i11;
            this.startY = i12;
            this.initWidth = i9;
            this.initHeight = i10;
            PrinterLabelBgView printerLabelBgView2 = new PrinterLabelBgView(this);
            this.labelBackground = printerLabelBgView2;
            printerLabelBgView2.initBgView(this.bgWidth, this.bgHeight);
            this.labelBackground.setBackground(this.printerLabelBgUrl, this.printerLabelBgBorderUrl, this.paperType);
            this.labelBackground.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            addElementView(this.labelBackground, false);
            marginLayoutParams.width = this.scaleWidth;
            marginLayoutParams.height = this.scaleHeight;
            setLayoutParams(marginLayoutParams);
        }
        C1849c.setScale(this.scale);
        this.scaleConvert.f8891a = this.scale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$drawLabel2PrintBitmap$0(Bitmap[] bitmapArr, int i5, int[] iArr, int i6, float f6, DrawLabel2PrintBitmapEventListener drawLabel2PrintBitmapEventListener, int i7, Bitmap bitmap) {
        bitmapArr[i7 - i5] = bitmap;
        int i8 = iArr[0] + 1;
        iArr[0] = i8;
        if (i8 == i6) {
            C1849c.setScale(f6);
            drawLabel2PrintBitmapEventListener.onComplete(bitmapArr);
        }
    }

    private void notifyForwardBackward() {
        boolean z6;
        List<TemplateEditBean> list = this.templateEdits;
        boolean z7 = false;
        if (list == null) {
            z6 = false;
        } else {
            z6 = true;
            if (this.editPos != list.size() - 1) {
                if (this.editPos == -1) {
                    z6 = false;
                    z7 = true;
                } else {
                    z7 = true;
                }
            }
        }
        OnForwardBackwardStatusListener onForwardBackwardStatusListener = this.onForwardBackwardStatusListener;
        if (onForwardBackwardStatusListener != null) {
            onForwardBackwardStatusListener.onStatus(z7, z6);
        }
    }

    private void setWillPrintView(boolean z6) {
        this.isWillPrintView = z6;
    }

    public void addDottedLine() {
        int i5 = this.bgWidth;
        int i6 = this.bgHeight;
        this.dottedLineView = new PrinterDottedLineView(getContext());
        this.dottedLineView.setLayoutParams(new RelativeLayout.LayoutParams(i5, i6));
        this.dottedLineView.setStart(this.startX, this.startY);
        this.dottedLineView.hidden();
        addView(this.dottedLineView);
    }

    public void addElementView(BaseControlView baseControlView, boolean z6) {
        addView(baseControlView);
        if (z6) {
            baseControlView.isElementSelected = true;
            baseControlView.resetBorder();
            d.b().f(new g());
        }
        addTemplateEdit(1, baseControlView, new JSONObject[0]);
    }

    public void autoAddElementByData() {
        for (int i5 = 0; i5 <= this.wantCreateElements.length() - 1; i5++) {
            try {
                dealWithElementJsonData(this.wantCreateElements.getJSONObject(i5), false);
            } catch (JSONException e) {
                p051j0.a.d(this.TAG, e.toString());
                return;
            }
        }
        this.wantCreateElements = null;
    }

    public void bottomAlignedSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationBottom();
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.9
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return ((baseControlView.mRoot.getHeight() + baseControlView.getViewLocation().y) - baseControlView2.getViewLocation().y) - baseControlView2.mRoot.getHeight();
            }
        });
        int height = ((BaseControlView) AbstractC0157z.f(1, listHasSelectedElement)).mRoot.getHeight() + listHasSelectedElement.get(listHasSelectedElement.size() - 1).getViewLocation().y;
        for (int i5 = 0; i5 < listHasSelectedElement.size() - 1; i5++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i5);
            baseControlView.moveViewWithRecord(0, (height - baseControlView.getViewLocation().y) - baseControlView.mRoot.getHeight());
        }
    }

    public void changeLabelSize(int i5, int i6) {
        BaseControlView printerLabelLineView;
        JSONArray elementData = getElementData();
        this.labelWidthMM = i5;
        this.labelHeightMM = i6;
        this.labelWidth = C1849c.mm2px(i5);
        int iMm2px = C1849c.mm2px(i6);
        this.labelHeight = iMm2px;
        int i7 = this.baseWidth - this.marginH;
        int i8 = this.baseHeight - this.marginV;
        if (this.canEdit) {
            this.scale = i7 / this.labelWidth;
        } else {
            this.scale = Math.min(i7 / this.labelWidth, i8 / iMm2px);
        }
        System.out.println("scale:   " + this.scale);
        float f6 = (float) this.labelWidth;
        float f7 = this.scale;
        int i9 = (int) (f6 * f7);
        this.bgWidth = i9;
        int i10 = (int) (this.labelHeight * f7);
        this.bgHeight = i10;
        int i11 = this.marginH;
        this.scaleWidth = i9 + i11;
        int i12 = this.marginV;
        this.scaleHeight = i10 + i12;
        this.startX = i11;
        this.startY = i12;
        this.initWidth = i9;
        this.initHeight = i10;
        this.zoomScale = 1.0f;
        this.labelBackground.changeBgView(i11, i12, i9, i10);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.canEdit) {
            layoutParams.width = this.scaleWidth;
            layoutParams.height = this.scaleHeight;
            setLayoutParams(layoutParams);
            addDottedLine();
        } else {
            layoutParams.width = this.scaleWidth;
            layoutParams.height = this.scaleHeight;
            setLayoutParams(layoutParams);
        }
        C1849c.setScale(this.scale);
        this.scaleConvert.f8891a = this.scale;
        int childCount = getChildCount() - 1;
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 <= childCount; i13++) {
            BaseControlView controlView = getControlView(i13);
            if (controlView != null && controlView.elementType() != 0) {
                arrayList.add(controlView);
            }
        }
        int size = arrayList.size();
        int i14 = 0;
        while (i14 < size) {
            Object obj = arrayList.get(i14);
            i14++;
            removeView((BaseControlView) obj);
        }
        if (elementData != null) {
            for (int i15 = 0; i15 <= elementData.length() - 1; i15++) {
                try {
                    JSONObject jSONObject = elementData.getJSONObject(i15);
                    int i16 = jSONObject.getInt("itemType");
                    if (i16 != 0) {
                        if (i16 == 1) {
                            printerLabelLineView = new PrinterLabelLineView(this);
                        } else if (i16 != 2) {
                            switch (i16) {
                                case 5:
                                    printerLabelLineView = new PrinterLabelTextView(this);
                                    break;
                                case 6:
                                    printerLabelLineView = new PrinterLabelPictureView(this, false);
                                    break;
                                case 7:
                                    printerLabelLineView = new PrinterLabelBarCodeView(this);
                                    break;
                                case 8:
                                    printerLabelLineView = new PrinterLabelQrCodeView(this);
                                    break;
                                case 9:
                                    printerLabelLineView = new PrinterLabelTableView(this);
                                    break;
                                case 10:
                                    printerLabelLineView = new PrinterLabelTimeView(this);
                                    break;
                                default:
                                    printerLabelLineView = null;
                                    break;
                            }
                        } else {
                            printerLabelLineView = new PrinterLabelShapeView(this);
                        }
                        if (printerLabelLineView != null) {
                            printerLabelLineView.setJson(jSONObject, false);
                            addElementView(printerLabelLineView, false);
                        }
                    }
                } catch (JSONException e) {
                    p051j0.a.d(this.TAG, e.toString());
                }
            }
        }
        TemplatePageViewEvent templatePageViewEvent = this.eventListener;
        if (templatePageViewEvent != null) {
            templatePageViewEvent.onLabelSizeChanged(this.labelWidth, this.labelHeight);
        }
    }

    public void copySelectedElement(BaseControlView baseControlView) {
        if (baseControlView == null || !baseControlView.isElementSelected() || baseControlView.elementType() == 0) {
            return;
        }
        JSONObject json = baseControlView.getJson();
        baseControlView.deselect();
        dealWithElementJsonData(json, true);
        int i5 = this.addViewLocalIndex - 1;
        this.addViewLocalIndex = i5;
        if (i5 < 0) {
            this.addViewLocalIndex = 0;
        }
    }

    public void dealWithElementJsonData(JSONObject jSONObject, boolean z6) {
        BaseControlView printerLabelLineView;
        try {
            int i5 = jSONObject.getInt("itemType");
            if (i5 == 0) {
                this.labelBackground.setViewByJson(jSONObject);
                this.labelBackground.setBackground(this.printerLabelBgUrl, this.printerLabelBgBorderUrl, this.paperType);
                return;
            }
            if (i5 == 1) {
                printerLabelLineView = new PrinterLabelLineView(this);
            } else if (i5 != 2) {
                switch (i5) {
                    case 5:
                        printerLabelLineView = new PrinterLabelTextView(this);
                        break;
                    case 6:
                        printerLabelLineView = new PrinterLabelPictureView(this, false);
                        break;
                    case 7:
                        printerLabelLineView = new PrinterLabelBarCodeView(this);
                        break;
                    case 8:
                        printerLabelLineView = new PrinterLabelQrCodeView(this);
                        break;
                    case 9:
                        printerLabelLineView = new PrinterLabelTableView(this);
                        break;
                    case 10:
                        printerLabelLineView = new PrinterLabelTimeView(this);
                        break;
                    default:
                        printerLabelLineView = null;
                        break;
                }
            } else {
                printerLabelLineView = new PrinterLabelShapeView(this);
            }
            if (printerLabelLineView != null) {
                if (!isWillPrintView() || printerLabelLineView.isTakePrint()) {
                    printerLabelLineView.setJson(jSONObject, z6);
                    addElementView(printerLabelLineView, z6);
                }
            }
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
    }

    public void deleteSelectedElement() {
        int childCount = getChildCount() - 1;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.isElementSelected() && controlView.elementType() != 0) {
                arrayList.add(controlView);
            }
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            BaseControlView baseControlView = (BaseControlView) obj;
            removeView(baseControlView);
            addTemplateEdit(2, baseControlView, new JSONObject[0]);
        }
    }

    public void deselectOtherControlView(BaseControlView baseControlView) {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView != baseControlView) {
                controlView.deselect();
            }
        }
    }

    public Bitmap drawLabel2Bitmap(boolean z6, int i5, boolean z7) {
        int x6 = (int) this.labelBackground.getX();
        int y6 = (int) this.labelBackground.getY();
        int i6 = this.bgWidth;
        int i7 = this.bgHeight;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(x6 + i6, y6 + i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        int childCount = getChildCount() - 1;
        for (int i8 = 0; i8 <= childCount; i8++) {
            BaseControlView controlView = getControlView(i8);
            if (controlView != null && (!z6 || controlView.isTakePrint())) {
                controlView.deselect();
                drawChild(canvas, controlView, 0L);
            }
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmapCreateBitmap, x6, y6, i6, i7), this.labelWidth, this.labelHeight, true);
        bitmapCreateBitmap.recycle();
        if (!z7 && i5 == 0) {
            return bitmapCreateScaledBitmap;
        }
        Matrix matrix = new Matrix();
        if (i5 != 0) {
            matrix.postRotate(i5 % 360);
        }
        if (z7) {
            matrix.postScale(-1.0f, 1.0f);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateScaledBitmap, 0, 0, this.labelWidth, this.labelHeight, matrix, true);
        bitmapCreateScaledBitmap.recycle();
        return bitmapCreateBitmap2;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:49:0x020a  */
    /* JADX WARN: Code duplicated, block: B:51:0x020e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0212  */
    /* JADX WARN: Code duplicated, block: B:55:0x0216  */
    /* JADX WARN: Code duplicated, block: B:56:0x021c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0240  */
    /* JADX WARN: Code duplicated, block: B:59:0x0271  */
    /* JADX WARN: Code duplicated, block: B:60:0x029c  */
    public List<PrintTaskModel> drawLabel2BitmapList(int i5, int i6, int i7, int i8) {
        char c;
        int i9;
        int i10;
        Bitmap bitmap;
        Matrix matrix;
        int width;
        int height;
        Bitmap bitmapCreateBitmap;
        int height2;
        int height3;
        Bitmap bitmap2;
        ArrayList arrayList = new ArrayList();
        int i11 = 1;
        for (int i12 = 1; i12 <= i8; i12++) {
            PrintTaskModel printTaskModel = new PrintTaskModel();
            char c6 = 180;
            if (i5 == 0 || i5 == 180) {
                printTaskModel.setLabelHeight(i6);
                printTaskModel.setLabelWidth(i7);
            } else {
                printTaskModel.setLabelHeight(i7);
                printTaskModel.setLabelWidth(i6);
            }
            printTaskModel.setPrintCount(i8);
            ArrayList arrayList2 = new ArrayList();
            int childCount = getChildCount() - i11;
            int i13 = 0;
            while (i13 <= childCount) {
                BaseControlView controlView = getControlView(i13);
                if (controlView == null || !controlView.isTakePrint() || controlView.elementType() == 0) {
                    c = c6;
                    i9 = i13;
                    i10 = i11;
                } else {
                    if (controlView.elementType() == 6) {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap((int) (controlView.mRoot.getWidth() / C1849c.getScale()), (int) (controlView.mRoot.getHeight() / C1849c.getScale()), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap2);
                        canvas.drawColor(-1);
                        Drawable drawable = ((PrinterLabelPictureView) controlView).getIv().getDrawable();
                        if (!(drawable instanceof BitmapDrawable)) {
                            throw new UnsupportedOperationException("Unsupported drawable type");
                        }
                        Bitmap bitmap3 = ((BitmapDrawable) drawable).getBitmap();
                        canvas.drawBitmap(bitmap3, (bitmapCreateBitmap2.getWidth() - bitmap3.getWidth()) / 2, (bitmapCreateBitmap2.getHeight() - bitmap3.getHeight()) / 2, new Paint());
                        bitmap = bitmapCreateBitmap2;
                        i9 = i13;
                    } else {
                        i9 = i13;
                        if (controlView.elementType() == 7 || controlView.elementType() == 8 || controlView.elementType() == 10 || controlView.elementType() == 5) {
                            IDTControlView iDTControlView = (IDTControlView) controlView;
                            if (iDTControlView.getInputDataType() != 0) {
                                iDTControlView.intervalContent(i12 - 1);
                                printTaskModel.setSame(false);
                            }
                            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(controlView.mRoot.getLeft() + controlView.mRoot.getWidth(), controlView.mRoot.getTop() + controlView.mRoot.getHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(bitmapCreateBitmap3);
                            canvas2.drawColor(-1);
                            drawChild(canvas2, controlView.mRoot, 0L);
                            i10 = 1;
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmapCreateBitmap3, controlView.mRoot.getLeft(), controlView.mRoot.getTop(), controlView.mRoot.getWidth(), controlView.mRoot.getHeight()), (int) (controlView.mRoot.getWidth() / this.scale), (int) (controlView.mRoot.getHeight() / this.scale), true);
                            bitmapCreateBitmap3.recycle();
                            bitmap = bitmapCreateScaledBitmap;
                        } else {
                            Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(controlView.mRoot.getLeft() + controlView.mRoot.getWidth(), controlView.mRoot.getTop() + controlView.mRoot.getHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas3 = new Canvas(bitmapCreateBitmap4);
                            canvas3.drawColor(-1);
                            drawChild(canvas3, controlView.mRoot, 0L);
                            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmapCreateBitmap4, controlView.mRoot.getLeft(), controlView.mRoot.getTop(), controlView.mRoot.getWidth(), controlView.mRoot.getHeight()), (int) (controlView.mRoot.getWidth() / this.scale), (int) (controlView.mRoot.getHeight() / this.scale), true);
                            bitmapCreateBitmap4.recycle();
                            bitmap = bitmapCreateScaledBitmap2;
                        }
                        matrix = new Matrix();
                        matrix.postRotate((controlView.getRotationAngle() + i5) % 360);
                        if (controlView.getRotationAngle() != 0 || controlView.getRotationAngle() == 180) {
                            width = controlView.mRoot.getWidth();
                            height = controlView.mRoot.getHeight();
                        } else {
                            width = controlView.mRoot.getHeight();
                            height = controlView.mRoot.getWidth();
                        }
                        if (i5 != 0) {
                            c = 180;
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            height2 = controlView.getViewLocation().x;
                            height3 = controlView.getViewLocation().y;
                        } else if (i5 != 90) {
                            c = 180;
                            if (i5 != 180) {
                                if (i5 != 270) {
                                    bitmap2 = bitmap;
                                    height2 = 0;
                                    height3 = 0;
                                } else {
                                    bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                    height2 = controlView.getViewLocation().x;
                                    height3 = controlView.getViewLocation().y;
                                }
                                float f6 = this.scale;
                                arrayList2.add(new PrintTaskElementModel(bitmap2, (int) (height2 / f6), (int) (height3 / f6)));
                            } else {
                                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                height2 = (this.labelBackground.getWidth() - controlView.getViewLocation().x) - width;
                                height3 = (this.labelBackground.getHeight() - controlView.getViewLocation().y) - height;
                            }
                        } else {
                            c = 180;
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            height2 = (this.labelBackground.getHeight() - controlView.getViewLocation().y) - height;
                            height3 = controlView.getViewLocation().x;
                        }
                        bitmap2 = bitmapCreateBitmap;
                        float f7 = this.scale;
                        arrayList2.add(new PrintTaskElementModel(bitmap2, (int) (height2 / f7), (int) (height3 / f7)));
                    }
                    i10 = 1;
                    matrix = new Matrix();
                    matrix.postRotate((controlView.getRotationAngle() + i5) % 360);
                    if (controlView.getRotationAngle() != 0) {
                        width = controlView.mRoot.getWidth();
                        height = controlView.mRoot.getHeight();
                    } else {
                        width = controlView.mRoot.getWidth();
                        height = controlView.mRoot.getHeight();
                    }
                    if (i5 != 0) {
                        c = 180;
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        height2 = controlView.getViewLocation().x;
                        height3 = controlView.getViewLocation().y;
                    } else if (i5 != 90) {
                        c = 180;
                        if (i5 != 180) {
                            if (i5 != 270) {
                                bitmap2 = bitmap;
                                height2 = 0;
                                height3 = 0;
                            } else {
                                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                height2 = controlView.getViewLocation().x;
                                height3 = controlView.getViewLocation().y;
                            }
                            float f8 = this.scale;
                            arrayList2.add(new PrintTaskElementModel(bitmap2, (int) (height2 / f8), (int) (height3 / f8)));
                        } else {
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            height2 = (this.labelBackground.getWidth() - controlView.getViewLocation().x) - width;
                            height3 = (this.labelBackground.getHeight() - controlView.getViewLocation().y) - height;
                        }
                    } else {
                        c = 180;
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        height2 = (this.labelBackground.getHeight() - controlView.getViewLocation().y) - height;
                        height3 = controlView.getViewLocation().x;
                    }
                    bitmap2 = bitmapCreateBitmap;
                    float f9 = this.scale;
                    arrayList2.add(new PrintTaskElementModel(bitmap2, (int) (height2 / f9), (int) (height3 / f9)));
                }
                int i14 = i9 + 1;
                c6 = c;
                i11 = i10;
                i13 = i14;
            }
            printTaskModel.setPrintTaskElementModels(arrayList2);
            arrayList.add(printTaskModel);
        }
        return arrayList;
    }

    public D drawLabel2FormData(boolean z6) {
        byte[] byteArray;
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.labelBackground.getX()) + this.bgWidth, ((int) this.labelBackground.getY()) + this.bgHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            int childCount = getChildCount() - 1;
            for (int i5 = 0; i5 <= childCount; i5++) {
                BaseControlView controlView = getControlView(i5);
                if (controlView != null && (!z6 || controlView.isTakePrint())) {
                    controlView.deselect();
                    if (controlView.elementType() == 9) {
                        ((PrinterLabelTableView) controlView).hiddenSelected();
                    }
                    drawChild(canvas, controlView, 0L);
                }
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmapCreateBitmap, (int) this.labelBackground.getX(), (int) this.labelBackground.getY(), this.bgWidth, this.bgHeight), this.labelWidth, this.labelHeight, true);
            bitmapCreateBitmap.recycle();
            d.b().f(new g());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            byteArray = new byte[0];
        }
        return D.createFormData(Constants.FILE, "image.jpg", Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), byteArray));
    }

    public void drawLabel2PrintBitmap(int i5, boolean z6, int i6, DrawLabel2PrintBitmapEventListener drawLabel2PrintBitmapEventListener) {
        drawLabel2PrintBitmap(i5, z6, i6, 0, drawLabel2PrintBitmapEventListener);
    }

    public void drawLabel2PrintBitmapInner(int i5, boolean z6, int i6, DrawLabel2PrintBitmapInnerEventListener drawLabel2PrintBitmapInnerEventListener) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            p051j0.a.d(this.TAG, "parent is null");
            return;
        }
        TemplatePageView templatePageView = new TemplatePageView(getContext());
        templatePageView.setWillPrintView(true);
        templatePageView.canEdit = false;
        templatePageView.addOnAttachStateChangeListener(new AnonymousClass3(templatePageView, i6, viewGroup, i5, z6, drawLabel2PrintBitmapInnerEventListener));
        viewGroup.addView(templatePageView);
    }

    public Bitmap drawPrintBitmap(boolean z6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.labelWidth, this.labelHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        dispatchDraw(canvas);
        return bitmapCreateBitmap;
    }

    public List<String> getAllExcelUrls() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null) {
                if (controlView.elementType() == 5) {
                    PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) controlView;
                    if (printerLabelTextView.getInputDataType() == 2 && printerLabelTextView.getExcelUrl() != null && !printerLabelTextView.getExcelUrl().isEmpty() && !arrayList.contains(printerLabelTextView.getExcelUrl())) {
                        arrayList.add(printerLabelTextView.getExcelUrl());
                    }
                } else if (controlView.elementType() == 7) {
                    PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) controlView;
                    if (printerLabelBarCodeView.getInputDataType() == 3 && printerLabelBarCodeView.getExcelUrl() != null && !printerLabelBarCodeView.getExcelUrl().isEmpty() && !arrayList.contains(printerLabelBarCodeView.getExcelUrl())) {
                        arrayList.add(printerLabelBarCodeView.getExcelUrl());
                    }
                } else if (controlView.elementType() == 8) {
                    PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) controlView;
                    if (printerLabelQrCodeView.getInputDataType() == 3 && printerLabelQrCodeView.getExcelUrl() != null && !printerLabelQrCodeView.getExcelUrl().isEmpty() && !arrayList.contains(printerLabelQrCodeView.getExcelUrl())) {
                        arrayList.add(printerLabelQrCodeView.getExcelUrl());
                    }
                }
            }
        }
        return arrayList;
    }

    public int getBgHeight() {
        return this.bgHeight;
    }

    public int getBgWidth() {
        return this.bgWidth;
    }

    public JSONArray getElementData() {
        JSONArray jSONArray = new JSONArray();
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0) {
                controlView.setLockLocation(false);
                jSONArray.put(controlView.getJson());
            }
        }
        return jSONArray;
    }

    public List<Object> getElementDataList() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0) {
                controlView.setLockLocation(false);
                arrayList.add(p052j2.c.c(Object.class, controlView.getJson().toString()));
            }
        }
        return arrayList;
    }

    public int getLabelHeightMM() {
        return this.labelHeightMM;
    }

    public int getLabelWidthMM() {
        return this.labelWidthMM;
    }

    public List<Object> getPrinterData() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null) {
                controlView.setLockLocation(true);
                arrayList.add(p052j2.c.c(Object.class, controlView.getJson().toString()));
                controlView.setLockLocation(false);
            }
        }
        return arrayList;
    }

    public C1847b getScaleConvert() {
        return this.scaleConvert;
    }

    public int getStartX() {
        return this.startX;
    }

    public int getStartY() {
        return this.startY;
    }

    public int getTransmutationStartX() {
        int scrollY;
        if ((getParent() instanceof DrawingBoardView) && (scrollY = ((DrawingBoardView) getParent()).getScrollY()) != this.currentScrollY) {
            this.addViewLocalIndex = -1;
            this.currentScrollY = scrollY;
        }
        int i5 = this.addViewLocalIndex + 1;
        this.addViewLocalIndex = i5;
        if (i5 > 8 || i5 < 0) {
            this.addViewLocalIndex = 0;
        }
        return (this.addViewLocalIndex * 100) + this.startX;
    }

    public int getTransmutationStartY() {
        return (this.addViewLocalIndex * 100) + this.startY;
    }

    public float getZoomScale() {
        return this.zoomScale;
    }

    public void goBack() {
        int i5 = this.editPos;
        if (i5 < 0 || i5 >= this.templateEdits.size()) {
            return;
        }
        try {
            TemplateEditBean templateEditBean = this.templateEdits.get(this.editPos);
            if (templateEditBean != null) {
                int type = templateEditBean.getType();
                if (type == 1) {
                    removeView(templateEditBean.getBaseControlView());
                    d dVarB = d.b();
                    h hVar = new h();
                    hVar.f9013a = true;
                    dVarB.f(hVar);
                } else if (type == 2) {
                    BaseControlView baseControlView = templateEditBean.getBaseControlView();
                    removeView(baseControlView);
                    if (baseControlView.elementType() == 2) {
                        addView(baseControlView, 3);
                    } else {
                        addView(baseControlView);
                    }
                    deselectOtherControlView(null);
                } else if (type == 3) {
                    JSONObject json = templateEditBean.getBaseControlView().getJson();
                    templateEditBean.getBaseControlView().recoverFromJson(templateEditBean.getOldObject());
                    d.b().f(new f(0, templateEditBean.getBaseControlView(), json, templateEditBean.getOldObject()));
                }
                int i6 = this.editPos - 1;
                this.editPos = i6;
                if (i6 < -1) {
                    this.editPos = -1;
                }
            }
        } catch (Exception e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        notifyForwardBackward();
    }

    public void goForward() {
        int i5 = this.editPos + 1;
        if (i5 < 0 || i5 >= this.templateEdits.size()) {
            return;
        }
        try {
            TemplateEditBean templateEditBean = this.templateEdits.get(this.editPos + 1);
            if (templateEditBean != null) {
                int type = templateEditBean.getType();
                if (type == 1) {
                    BaseControlView baseControlView = templateEditBean.getBaseControlView();
                    removeView(baseControlView);
                    if (baseControlView.elementType() == 2) {
                        addView(baseControlView, 3);
                    } else {
                        addView(baseControlView);
                    }
                    deselectOtherControlView(null);
                } else if (type == 2) {
                    removeView(templateEditBean.getBaseControlView());
                } else if (type == 3) {
                    JSONObject json = templateEditBean.getBaseControlView().getJson();
                    templateEditBean.getBaseControlView().recoverFromJson(templateEditBean.getNewObject());
                    d.b().f(new f(0, templateEditBean.getBaseControlView(), json, templateEditBean.getNewObject()));
                }
                int i6 = this.editPos + 1;
                this.editPos = i6;
                if (i6 >= this.templateEdits.size()) {
                    this.editPos = this.templateEdits.size() - 1;
                }
            }
        } catch (Exception e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        notifyForwardBackward();
    }

    public boolean hasMultiSelected() {
        int childCount = getChildCount() - 1;
        int i5 = 0;
        for (int i6 = 0; i6 <= childCount; i6++) {
            BaseControlView controlView = getControlView(i6);
            if (controlView != null && controlView.isElementSelected() && controlView.elementType() != 0 && (i5 = i5 + 1) > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSameSizeElement(Rect rect) {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0 && controlView.getControlRect().equals(rect)) {
                return true;
            }
        }
        return false;
    }

    public List<BaseControlView> hasSelectedElement() {
        int childCount = getChildCount() - 1;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.isElementSelected() && controlView.elementType() != 0) {
                arrayList.add(controlView);
                if (controlView.elementType() == 9) {
                    ((PrinterLabelTableView) controlView).resetSelected();
                }
            } else if (controlView != null && !controlView.isElementSelected() && controlView.elementType() == 9) {
                ((PrinterLabelTableView) controlView).hiddenSelected();
            }
        }
        return arrayList;
    }

    public void hideDotLine() {
        PrinterDottedLineView printerDottedLineView = this.dottedLineView;
        if (printerDottedLineView != null) {
            printerDottedLineView.hidden();
        }
    }

    public void horizontalCenterSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationCenterHorizontally();
        }
        int i5 = Integer.MAX_VALUE;
        int viewWidth = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < listHasSelectedElement.size(); i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            Point viewLocation = baseControlView.getViewLocation();
            if (viewLocation.x < i5) {
                i5 = baseControlView.getViewLocation().x;
            }
            if (baseControlView.getViewWidth() + viewLocation.x > viewWidth) {
                viewWidth = baseControlView.getViewWidth() + baseControlView.getViewLocation().x;
            }
        }
        int i7 = (i5 + viewWidth) / 2;
        for (int i8 = 0; i8 < listHasSelectedElement.size(); i8++) {
            BaseControlView baseControlView2 = listHasSelectedElement.get(i8);
            baseControlView2.moveViewWithRecord((i7 - baseControlView2.getViewLocation().x) - (baseControlView2.getViewWidth() / 2), 0);
        }
    }

    public void horizontalIsometricSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.size() < 3) {
            return;
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.4
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return baseControlView.getViewLocation().x - baseControlView2.getViewLocation().x;
            }
        });
        int viewWidth = 0;
        for (int i5 = 1; i5 < listHasSelectedElement.size() - 1; i5++) {
            viewWidth += listHasSelectedElement.get(i5).getViewWidth();
        }
        int viewWidth2 = listHasSelectedElement.get(0).getViewWidth() + listHasSelectedElement.get(0).getViewLocation().x;
        int size = ((((BaseControlView) AbstractC0157z.f(1, listHasSelectedElement)).getViewLocation().x - viewWidth2) - viewWidth) / (listHasSelectedElement.size() - 1);
        for (int i6 = 1; i6 < listHasSelectedElement.size() - 1; i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            int i7 = viewWidth2 + size;
            baseControlView.moveViewWithRecord(i7 - baseControlView.getViewLocation().x, 0);
            viewWidth2 = i7 + baseControlView.getViewWidth();
        }
    }

    public boolean isHasEditTemplate() {
        if (this.templateEdits == null) {
            return false;
        }
        if (this.hasEditTemplateConfig && getChildCount() > 1) {
            return true;
        }
        if (this.templateEdits.size() <= 0) {
            return false;
        }
        if (this.currentSaveNode == null) {
            return true;
        }
        return this.currentSaveNode != ((TemplateEditBean) AbstractC0157z.f(1, this.templateEdits));
    }

    public boolean isLoadCompelete() {
        return this.isLoadCompelete;
    }

    public boolean isMultipleMode() {
        return this.isMultipleMode;
    }

    public boolean isRenderingCompleted() {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0 && (controlView.mRoot.getWidth() <= 0 || controlView.mRoot.getHeight() <= 0 || !controlView.isRenderingCompleted())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSelectAll() {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && !controlView.isElementSelected() && controlView.elementType() != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isWillPrintView() {
        return this.isWillPrintView;
    }

    public void leftAlignedSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationLeft();
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.6
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return baseControlView.getViewLocation().x - baseControlView2.getViewLocation().x;
            }
        });
        int i5 = listHasSelectedElement.get(0).getViewLocation().x;
        for (int i6 = 1; i6 < listHasSelectedElement.size(); i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            baseControlView.moveViewWithRecord(i5 - baseControlView.getViewLocation().x, 0);
        }
    }

    public void load() {
        initView();
        if (this.wantCreateElements != null) {
            autoAddElementByData();
        }
        this.templateEdits = new ArrayList();
        this.editPos = -1;
        TemplatePageViewEvent templatePageViewEvent = this.eventListener;
        if (templatePageViewEvent != null) {
            templatePageViewEvent.onLoadComplete();
            this.isLoadCompelete = true;
        }
    }

    public void move(int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        boolean z6 = (i7 == this.baseWidth && i8 == this.baseHeight) ? false : true;
        marginLayoutParams.leftMargin = i5;
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.width = i7;
        marginLayoutParams.height = i8;
        marginLayoutParams.rightMargin = Integer.MIN_VALUE;
        marginLayoutParams.bottomMargin = Integer.MIN_VALUE;
        if (!z6) {
            move(i5, i6);
        } else {
            updateRealSize();
            scaleTo(i7, i8);
        }
    }

    public void moveSelectedControlView(int i5, int i6) {
        int childCount = getChildCount() - 1;
        for (int i7 = 0; i7 <= childCount; i7++) {
            BaseControlView controlView = getControlView(i7);
            if (controlView != null) {
                controlView.moveView(i5, i6);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b().j(this);
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onControlViewEditEvent(f fVar) {
        if (fVar.d) {
            return;
        }
        addTemplateEdit(3, fVar.f9012a, fVar.b, fVar.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d.b().m(this);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    @Override // android.view.View
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        TemplatePageViewEvent templatePageViewEvent;
        if (this.labelBackground == null || (templatePageViewEvent = this.eventListener) == null) {
            return;
        }
        templatePageViewEvent.onViewSizeChanged(this.bgWidth, this.bgHeight);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z6) {
        super.requestDisallowInterceptTouchEvent(z6);
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z6);
        }
    }

    public boolean resetAddViewLocalIndex() {
        this.addViewLocalIndex = -1;
        return true;
    }

    public void rightAlignedSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationRight();
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.7
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return ((baseControlView.getViewWidth() + baseControlView.getViewLocation().x) - baseControlView2.getViewLocation().x) - baseControlView2.getViewWidth();
            }
        });
        int viewWidth = ((BaseControlView) AbstractC0157z.f(1, listHasSelectedElement)).getViewWidth() + listHasSelectedElement.get(listHasSelectedElement.size() - 1).getViewLocation().x;
        for (int i5 = 0; i5 < listHasSelectedElement.size() - 1; i5++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i5);
            baseControlView.moveViewWithRecord((viewWidth - baseControlView.getViewLocation().x) - baseControlView.getViewWidth(), 0);
        }
    }

    public void saveEditTemplate() {
        this.hasEditTemplateConfig = false;
        List<TemplateEditBean> list = this.templateEdits;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.currentSaveNode = (TemplateEditBean) AbstractC0157z.f(1, this.templateEdits);
    }

    public void scaleTo(int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i5;
        marginLayoutParams.height = i6;
        marginLayoutParams.rightMargin = Integer.MIN_VALUE;
        marginLayoutParams.bottomMargin = Integer.MIN_VALUE;
        setLayoutParams(marginLayoutParams);
        this.baseWidth = i5;
        this.baseHeight = i6;
        if (this.canEdit) {
            this.scale = i5 / this.labelWidth;
            p051j0.a.k(this.TAG, "scale:   " + this.scale);
            float f6 = (float) this.labelWidth;
            float f7 = this.scale;
            int i7 = (int) (f6 * f7);
            this.bgWidth = i7;
            int i8 = (int) (this.labelHeight * f7);
            this.bgHeight = i8;
            this.scaleWidth = i7;
            this.scaleHeight = i8;
            this.zoomScale = i7 / this.initWidth;
            PrinterLabelBgView printerLabelBgView = this.labelBackground;
            if (printerLabelBgView != null) {
                printerLabelBgView.changeBgView(this.startX, this.startY, i7, i8);
            }
        } else {
            float fMin = Math.min(i5 / this.labelWidth, i6 / this.labelHeight);
            this.scale = fMin;
            int i9 = (int) (this.labelWidth * fMin);
            this.bgWidth = i9;
            int i10 = (int) (this.labelHeight * fMin);
            this.bgHeight = i10;
            this.scaleWidth = i9;
            this.scaleHeight = i10;
            this.zoomScale = i9 / this.initWidth;
            PrinterLabelBgView printerLabelBgView2 = this.labelBackground;
            if (printerLabelBgView2 != null) {
                printerLabelBgView2.changeBgView(this.startX, this.startY, i9, i10);
            }
        }
        C1849c.setScale(this.scale);
        this.scaleConvert.f8891a = this.scale;
        int childCount = getChildCount() - 1;
        for (int i11 = 0; i11 <= childCount; i11++) {
            BaseControlView controlView = getControlView(i11);
            if (controlView != null && !(controlView instanceof PrinterLabelBgView)) {
                controlView.updateZoomedSize();
            }
        }
    }

    public void selectAll() {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0) {
                controlView.select(true);
            }
        }
    }

    public void sendDottedLineEvent(p137y.k kVar) {
        PrinterDottedLineView printerDottedLineView = this.dottedLineView;
        if (printerDottedLineView == null) {
            return;
        }
        if (kVar.f9016a == 1) {
            printerDottedLineView.show(kVar.b);
        } else {
            printerDottedLineView.hidden();
        }
    }

    public void setEventListener(TemplatePageViewEvent templatePageViewEvent) {
        this.eventListener = templatePageViewEvent;
    }

    public void setHasEditTemplate() {
        this.hasEditTemplateConfig = true;
    }

    public void setLabelSize(int i5, int i6) {
        this.labelWidthMM = i5;
        this.labelHeightMM = i6;
        this.labelWidth = C1849c.mm2px(i5);
        this.labelHeight = C1849c.mm2px(i6);
    }

    public void setMultipleMode(boolean z6) {
        this.isMultipleMode = z6;
        if (z6) {
            Iterator<BaseControlView> it = hasSelectedElement().iterator();
            while (it.hasNext()) {
                it.next().deselect();
            }
        }
    }

    public void setOnForwardBackwardStatusListener(OnForwardBackwardStatusListener onForwardBackwardStatusListener) {
        this.onForwardBackwardStatusListener = onForwardBackwardStatusListener;
    }

    public void setPaperType(int i5) {
        this.paperType = i5;
    }

    public void setPrinterLabelBgBorderUrl(String str) {
        this.printerLabelBgBorderUrl = str;
    }

    public void setPrinterLabelBgUrl(String str) {
        this.printerLabelBgUrl = str;
    }

    public void setWantCreateElementsByString(String str) {
        try {
            this.wantCreateElements = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    public BaseControlView testHitElement(int i5, int i6, int i7) {
        int childCount = getChildCount() - 1;
        BaseControlView baseControlView = null;
        for (int i8 = 0; i8 <= childCount; i8++) {
            BaseControlView controlView = getControlView(i8);
            if (controlView != null && controlView.isHitElement(i5, i6, i7)) {
                if (controlView.isElementSelected()) {
                    return controlView;
                }
                if (baseControlView == null) {
                    baseControlView = controlView;
                } else {
                    Rect controlHitRect = baseControlView.getControlHitRect();
                    Rect controlHitRect2 = controlView.getControlHitRect();
                    if (controlHitRect.contains(controlHitRect2)) {
                        baseControlView = controlView;
                    }
                    Rect rect = new Rect();
                    if (rect.setIntersect(controlHitRect, controlHitRect2)) {
                        float fHeight = rect.height() * rect.width();
                        if (fHeight / (controlHitRect.height() * controlHitRect.width()) < fHeight / (controlHitRect2.height() * controlHitRect2.width())) {
                            baseControlView = controlView;
                        }
                    }
                }
            }
        }
        return baseControlView;
    }

    public void topAlignedSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationTop();
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.8
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return baseControlView.getViewLocation().y - baseControlView2.getViewLocation().y;
            }
        });
        int i5 = listHasSelectedElement.get(0).getViewLocation().y;
        for (int i6 = 1; i6 < listHasSelectedElement.size(); i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            baseControlView.moveViewWithRecord(0, i5 - baseControlView.getViewLocation().y);
        }
    }

    public void unselectAll() {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && controlView.elementType() != 0) {
                controlView.deselect();
            }
        }
    }

    public void updateBgView(String str, String str2, int i5) {
        this.printerLabelBgUrl = str;
        this.printerLabelBgBorderUrl = str2;
        this.paperType = i5;
        PrinterLabelBgView printerLabelBgView = this.labelBackground;
        if (printerLabelBgView != null) {
            printerLabelBgView.setBackground(str, str2, i5);
        }
    }

    public void updateRealSize() {
        int childCount = getChildCount() - 1;
        for (int i5 = 0; i5 <= childCount; i5++) {
            BaseControlView controlView = getControlView(i5);
            if (controlView != null && !(controlView instanceof PrinterLabelBgView)) {
                controlView.updateRealSize();
            }
        }
    }

    public void verticalCenterSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.isEmpty()) {
            return;
        }
        if (listHasSelectedElement.size() < 2 && listHasSelectedElement.size() == 1) {
            listHasSelectedElement.get(0).setLocationCenterVertically();
        }
        int i5 = Integer.MAX_VALUE;
        int viewHeight = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < listHasSelectedElement.size(); i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            Point viewLocation = baseControlView.getViewLocation();
            if (viewLocation.y < i5) {
                i5 = baseControlView.getViewLocation().y;
            }
            if (baseControlView.getViewHeight() + viewLocation.y > viewHeight) {
                viewHeight = baseControlView.getViewHeight() + baseControlView.getViewLocation().y;
            }
        }
        int i7 = (i5 + viewHeight) / 2;
        for (int i8 = 0; i8 < listHasSelectedElement.size(); i8++) {
            BaseControlView baseControlView2 = listHasSelectedElement.get(i8);
            baseControlView2.moveViewWithRecord(0, (i7 - baseControlView2.getViewLocation().y) - (baseControlView2.getViewHeight() / 2));
        }
    }

    public void verticalIsometricSelected() {
        List<BaseControlView> listHasSelectedElement = hasSelectedElement();
        if (listHasSelectedElement.size() < 3) {
            return;
        }
        listHasSelectedElement.sort(new Comparator<BaseControlView>() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.5
            @Override // java.util.Comparator
            public int compare(BaseControlView baseControlView, BaseControlView baseControlView2) {
                return baseControlView.getViewLocation().y - baseControlView2.getViewLocation().y;
            }
        });
        int viewHeight = 0;
        for (int i5 = 1; i5 < listHasSelectedElement.size() - 1; i5++) {
            viewHeight += listHasSelectedElement.get(i5).getViewHeight();
        }
        int viewHeight2 = listHasSelectedElement.get(0).getViewHeight() + listHasSelectedElement.get(0).getViewLocation().y;
        int size = ((((BaseControlView) AbstractC0157z.f(1, listHasSelectedElement)).getViewLocation().y - viewHeight2) - viewHeight) / (listHasSelectedElement.size() - 1);
        for (int i6 = 1; i6 < listHasSelectedElement.size() - 1; i6++) {
            BaseControlView baseControlView = listHasSelectedElement.get(i6);
            int i7 = viewHeight2 + size;
            baseControlView.moveViewWithRecord(0, i7 - baseControlView.getViewLocation().y);
            viewHeight2 = i7 + baseControlView.getViewHeight();
        }
    }

    public TemplatePageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void drawLabel2PrintBitmap(int i5, boolean z6, final int i6, final int i7, final DrawLabel2PrintBitmapEventListener drawLabel2PrintBitmapEventListener) {
        final float scale = C1849c.getScale();
        final int[] iArr = {0};
        final Bitmap[] bitmapArr = new Bitmap[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            drawLabel2PrintBitmapInner(i5, z6, i7 + i8, new DrawLabel2PrintBitmapInnerEventListener() { // from class: com.appdev.standard.page.printerlabel.widget.c
                @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.DrawLabel2PrintBitmapInnerEventListener
                public final void onComplete(int i9, Bitmap bitmap) {
                    TemplatePageView.lambda$drawLabel2PrintBitmap$0(bitmapArr, i7, iArr, i6, scale, drawLabel2PrintBitmapEventListener, i9, bitmap);
                }
            });
        }
    }

    public TemplatePageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.TAG = getClass().getName();
        this.labelWidth = Videoio.CAP_PROP_XI_WB_KR;
        this.labelHeight = 320;
        this.baseWidth = 0;
        this.baseHeight = 0;
        this.initWidth = 0;
        this.initHeight = 0;
        this.scaleWidth = 0;
        this.scaleHeight = 0;
        this.bgWidth = 0;
        this.bgHeight = 0;
        this.marginV = 0;
        this.marginH = 0;
        this.startX = 0;
        this.startY = 0;
        this.scale = 1.0f;
        C1847b c1847b = new C1847b();
        c1847b.f8891a = 1.0f;
        this.scaleConvert = c1847b;
        this.zoomScale = 1.0f;
        this.addViewLocalIndex = -1;
        this.wantCreateElements = null;
        this.templateEdits = null;
        this.editPos = -1;
        this.labelBackground = null;
        this.dottedLineView = null;
        this.eventListener = null;
        this.printerLabelBgUrl = null;
        this.printerLabelBgBorderUrl = null;
        this.paperType = 0;
        this.isWillPrintView = false;
        this.canEdit = true;
        this.isLoadCompelete = false;
        this.currentSaveNode = null;
        this.hasEditTemplateConfig = false;
        this.currentScrollY = 0;
        this.isMultipleMode = false;
        this.onForwardBackwardStatusListener = null;
        this.context = context;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.TemplatePageView, i5, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == i.TemplatePageView_canEdit) {
                this.canEdit = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void move(int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.leftMargin = i5;
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.rightMargin = Integer.MIN_VALUE;
        marginLayoutParams.bottomMargin = Integer.MIN_VALUE;
        setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.widget.TemplatePageView$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements View.OnAttachStateChangeListener {
        final /* synthetic */ int val$direction;
        final /* synthetic */ boolean val$isMirror;
        final /* synthetic */ DrawLabel2PrintBitmapInnerEventListener val$listener;
        final /* synthetic */ TemplatePageView val$pageView;
        final /* synthetic */ ViewGroup val$parent;
        final /* synthetic */ int val$printIndex;

        public AnonymousClass3(TemplatePageView templatePageView, int i5, ViewGroup viewGroup, int i6, boolean z6, DrawLabel2PrintBitmapInnerEventListener drawLabel2PrintBitmapInnerEventListener) {
            this.val$pageView = templatePageView;
            this.val$printIndex = i5;
            this.val$parent = viewGroup;
            this.val$direction = i6;
            this.val$isMirror = z6;
            this.val$listener = drawLabel2PrintBitmapInnerEventListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.val$pageView.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.width = C1849c.mm2px(TemplatePageView.this.getLabelWidthMM());
            marginLayoutParams.height = C1849c.mm2px(TemplatePageView.this.getLabelHeightMM());
            this.val$pageView.setLayoutParams(marginLayoutParams);
            this.val$pageView.setVisibility(4);
            String strE = p052j2.c.e(TemplatePageView.this.getPrinterData());
            this.val$pageView.setLabelSize(TemplatePageView.this.getLabelWidthMM(), TemplatePageView.this.getLabelHeightMM());
            this.val$pageView.setPrinterLabelBgUrl(TemplatePageView.this.printerLabelBgUrl);
            this.val$pageView.setPrinterLabelBgBorderUrl(TemplatePageView.this.printerLabelBgBorderUrl);
            this.val$pageView.setPaperType(TemplatePageView.this.paperType);
            this.val$pageView.setWantCreateElementsByString(strE);
            this.val$pageView.requestLayout();
            this.val$pageView.invalidate();
            this.val$pageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.3.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AnonymousClass3.this.val$pageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass3.this.val$pageView.load();
                    for (int i5 = 0; i5 < AnonymousClass3.this.val$pageView.getChildCount(); i5++) {
                        BaseControlView controlView = AnonymousClass3.this.val$pageView.getControlView(i5);
                        if (controlView != null) {
                            if (controlView.elementType() == 7 || controlView.elementType() == 8 || controlView.elementType() == 10 || controlView.elementType() == 5) {
                                IDTControlView iDTControlView = (IDTControlView) controlView;
                                if (iDTControlView.getInputDataType() != 0) {
                                    iDTControlView.intervalContentInMainThread(AnonymousClass3.this.val$printIndex);
                                }
                            } else if (controlView.elementType() == 6) {
                                BaseControlView controlView2 = TemplatePageView.this.getControlView(i5);
                                if (controlView2.elementType() == 6) {
                                    ((PrinterLabelPictureView) controlView).copyFrom((PrinterLabelPictureView) controlView2);
                                }
                            } else if (controlView.elementType() == 0) {
                                BaseControlView controlView3 = TemplatePageView.this.getControlView(i5);
                                if (controlView3.elementType() == 0) {
                                    ((PrinterLabelBgView) controlView).copyFrom((PrinterLabelBgView) controlView3);
                                }
                            }
                        }
                    }
                    AnonymousClass3.this.val$pageView.requestLayout();
                    AnonymousClass3.this.val$pageView.invalidate();
                    AnonymousClass3.this.val$pageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.printerlabel.widget.TemplatePageView.3.1.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            AnonymousClass3.this.val$pageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            Bitmap bitmapDrawPrintBitmap = AnonymousClass3.this.val$pageView.drawPrintBitmap(true);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            anonymousClass3.val$parent.removeView(anonymousClass3.val$pageView);
                            AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                            if (anonymousClass4.val$direction != 0 || anonymousClass4.val$isMirror) {
                                Matrix matrix = new Matrix();
                                int i6 = AnonymousClass3.this.val$direction;
                                if (i6 != 0) {
                                    matrix.postRotate(i6 % 360);
                                }
                                if (AnonymousClass3.this.val$isMirror) {
                                    matrix.postScale(-1.0f, 1.0f);
                                }
                                bitmapDrawPrintBitmap = Bitmap.createBitmap(bitmapDrawPrintBitmap, 0, 0, bitmapDrawPrintBitmap.getWidth(), bitmapDrawPrintBitmap.getHeight(), matrix, true);
                            }
                            AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                            anonymousClass5.val$listener.onComplete(anonymousClass5.val$printIndex, bitmapDrawPrintBitmap);
                        }
                    });
                }
            });
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
