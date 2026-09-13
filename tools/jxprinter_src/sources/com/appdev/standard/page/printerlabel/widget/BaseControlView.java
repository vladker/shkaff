package com.appdev.standard.page.printerlabel.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.LayoutRes;
import androidx.core.widget.NestedScrollView;
import com.appdev.standard.page.printerlabel.util.TextSizeUtil;
import org.json.JSONException;
import org.json.JSONObject;
import p113u.d;
import p113u.e;
import p113u.g;
import p134x2.C1849c;
import p137y.f;
import p137y.h;
import p137y.k;
import p137y.l;
import p137y.m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseControlView extends FrameLayout {
    protected static View touchView;
    protected final String KEY_HEIGHT;
    protected final String KEY_LOCKLOCATION;
    protected final String KEY_ROTATIONANGLE;
    protected final String KEY_WIDTH;
    protected final String KEY_X;
    protected final String KEY_Y;
    protected final String TAG;
    protected int controlType;
    protected boolean hasMove;
    protected boolean isElementSelected;
    protected boolean isFixed;
    protected boolean isRenderingCompleted;
    protected boolean lockLocation;
    protected ImageView mBtnDelete;
    protected ImageView mBtnZoom;
    protected Context mContext;
    protected RelativeLayout mRoot;
    private ViewMoveEvent moveEvent;
    private JSONObject newObject;
    private JSONObject oldObject;
    protected float realHeight;
    protected float realWidth;
    protected float realX;
    protected float realY;
    private int rotationAngle;
    protected boolean saveCopy;
    protected JSONObject saveObject;
    protected boolean takePrint;
    protected TemplatePageView templatePage;
    protected TextSizeUtil textSizeUtil;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TemplateEditTask {
        void run();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TemplateEditTaskWithResult {
        boolean run();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ViewMoveEvent {
        void onMove(BaseControlView baseControlView);

        void onStartMove(BaseControlView baseControlView);

        void onStopMove(BaseControlView baseControlView);
    }

    public BaseControlView(TemplatePageView templatePageView) {
        RelativeLayout.LayoutParams layoutParams;
        super(templatePageView.getContext());
        String name = getClass().getName();
        this.TAG = name;
        this.mRoot = null;
        this.mBtnDelete = null;
        this.mBtnZoom = null;
        int i5 = 0;
        this.rotationAngle = 0;
        this.lockLocation = false;
        this.takePrint = true;
        this.isRenderingCompleted = false;
        this.controlType = 3;
        this.isElementSelected = false;
        this.isFixed = false;
        this.realWidth = -1.0f;
        this.realHeight = -1.0f;
        this.realX = -1.0f;
        this.realY = -1.0f;
        this.hasMove = false;
        this.textSizeUtil = null;
        this.templatePage = null;
        this.KEY_X = "l";
        this.KEY_Y = "t";
        this.KEY_WIDTH = "w";
        this.KEY_HEIGHT = "h";
        this.KEY_ROTATIONANGLE = "rotate";
        this.KEY_LOCKLOCATION = "lockLocation";
        this.saveCopy = false;
        this.oldObject = null;
        this.newObject = null;
        Context context = templatePageView.getContext();
        this.mContext = context;
        this.templatePage = templatePageView;
        View.inflate(context, e.view_base_control, this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (elementType() == 0) {
            layoutParams2.leftMargin = templatePageView.getStartX();
            layoutParams2.topMargin = templatePageView.getStartY();
        } else {
            if (templatePageView.getParent() instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) templatePageView.getParent();
                int scrollY = nestedScrollView.getScrollY();
                p051j0.a.k(name, "getScrollY():" + nestedScrollView.getScrollY());
                i5 = scrollY;
            }
            layoutParams2.leftMargin = templatePageView.getTransmutationStartX();
            layoutParams2.topMargin = templatePageView.getTransmutationStartY() + i5;
            layoutParams2.rightMargin = Integer.MIN_VALUE;
            layoutParams2.bottomMargin = Integer.MIN_VALUE;
        }
        setLayoutParams(layoutParams2);
        this.mBtnDelete = (ImageView) findViewById(d.btn_root_delete);
        this.mBtnZoom = (ImageView) findViewById(d.btn_root_zoom);
        this.mRoot = (RelativeLayout) findViewById(d.root);
        if (elementType() == 0) {
            layoutParams = new RelativeLayout.LayoutParams((int) (templatePageView.getZoomScale() * defaultWidth()), (int) (templatePageView.getZoomScale() * defaultHeight()));
            this.mBtnDelete.setVisibility(8);
            this.mBtnZoom.setVisibility(8);
        } else if (elementType() == 5) {
            layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
            layoutParams.width = (int) (templatePageView.getZoomScale() * defaultWidth());
            layoutParams.height = -2;
        } else if (elementType() == 9) {
            layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = (int) (templatePageView.getZoomScale() * defaultHeight());
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
            layoutParams.width = (int) (templatePageView.getZoomScale() * defaultWidth());
            layoutParams.height = (int) (templatePageView.getZoomScale() * defaultHeight());
        }
        this.mRoot.setLayoutParams(layoutParams);
        View.inflate(this.mContext, layoutId(), this.mRoot);
        this.mBtnDelete.bringToFront();
        updateRealSize();
        initListener();
    }

    private void initListener() {
        this.mRoot.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.printerlabel.widget.BaseControlView.1
            private float downX = 0.0f;
            private float downY = 0.0f;
            private float moveX = 0.0f;
            private float moveY = 0.0f;
            private int clickCount = 0;
            private final int CLICK_TIME = 200;
            private Handler handler = new Handler();
            private Runnable clickRunnable = new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseControlView.1.1
                /* JADX WARN: Code duplicated, block: B:29:0x0078  */
                /* JADX WARN: Code duplicated, block: B:69:0x0146  */
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass1.this.clickCount == 1) {
                        BaseControlView baseControlView = BaseControlView.this;
                        if (baseControlView.isElementSelected) {
                            baseControlView.deselect();
                        } else {
                            boolean z6 = (baseControlView.lockLocation || baseControlView.isFixed || baseControlView.templatePage.isMultipleMode()) ? false : true;
                            if (BaseControlView.this.elementType() != 0) {
                                BaseControlView.this.mBtnDelete.setVisibility(z6 ? 0 : 4);
                                BaseControlView.this.mBtnZoom.setVisibility(z6 ? 0 : 4);
                                if (BaseControlView.this.templatePage.isMultipleMode()) {
                                    BaseControlView baseControlView2 = BaseControlView.this;
                                    if (baseControlView2.lockLocation) {
                                        baseControlView2.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                                        BaseControlView.this.isElementSelected = false;
                                        p042h2.d.show(g.toast_71);
                                    } else {
                                        BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                                        BaseControlView.this.isElementSelected = true;
                                    }
                                } else {
                                    BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                                    BaseControlView.this.isElementSelected = true;
                                }
                            } else {
                                BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                                BaseControlView.this.mBtnDelete.setVisibility(z6 ? 0 : 8);
                                BaseControlView.this.mBtnZoom.setVisibility(z6 ? 0 : 8);
                            }
                            if (BaseControlView.this.elementType() != 0) {
                                BaseControlView.this.bringToFront();
                            }
                            if (!BaseControlView.this.templatePage.isMultipleMode()) {
                                BaseControlView baseControlView3 = BaseControlView.this;
                                baseControlView3.templatePage.deselectOtherControlView(baseControlView3);
                            }
                            S4.d.b().f(new p137y.g());
                        }
                    } else if (AnonymousClass1.this.clickCount == 2) {
                        BaseControlView baseControlView4 = BaseControlView.this;
                        if (!baseControlView4.isElementSelected) {
                            boolean z7 = (baseControlView4.lockLocation || baseControlView4.isFixed) ? false : true;
                            if (baseControlView4.elementType() != 0) {
                                BaseControlView.this.mBtnDelete.setVisibility(z7 ? 0 : 4);
                                BaseControlView.this.mBtnZoom.setVisibility(z7 ? 0 : 4);
                                if (BaseControlView.this.templatePage.isMultipleMode()) {
                                    BaseControlView baseControlView5 = BaseControlView.this;
                                    if (baseControlView5.lockLocation) {
                                        baseControlView5.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                                        BaseControlView.this.isElementSelected = false;
                                        p042h2.d.show(g.toast_71);
                                    } else {
                                        BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                                        BaseControlView.this.isElementSelected = true;
                                    }
                                } else {
                                    BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                                    BaseControlView.this.isElementSelected = true;
                                }
                            } else {
                                BaseControlView.this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                                BaseControlView.this.mBtnDelete.setVisibility(z7 ? 0 : 8);
                                BaseControlView.this.mBtnZoom.setVisibility(z7 ? 0 : 8);
                            }
                            if (BaseControlView.this.elementType() != 0) {
                                BaseControlView.this.bringToFront();
                            }
                        }
                        if (!BaseControlView.this.templatePage.isMultipleMode()) {
                            BaseControlView baseControlView6 = BaseControlView.this;
                            baseControlView6.templatePage.deselectOtherControlView(baseControlView6);
                        }
                        if (BaseControlView.this.elementType() == 5) {
                            S4.d.b().f(new p137y.g());
                            if (!BaseControlView.this.templatePage.isMultipleMode()) {
                                S4.d.b().f(new l(BaseControlView.this));
                            }
                        } else if (BaseControlView.this.elementType() == 6) {
                            S4.d.b().f(new p137y.g());
                            BaseControlView.this.postDelayed(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseControlView.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    S4.d.b().f(new m());
                                }
                            }, 500L);
                        } else {
                            S4.d.b().f(new p137y.g());
                        }
                    }
                    AnonymousClass1.this.clickCount = 0;
                    BaseControlView.touchView = null;
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!BaseControlView.this.templatePage.canEdit) {
                    return true;
                }
                View view2 = BaseControlView.touchView;
                if (view2 != null && view2 != view) {
                    return true;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    BaseControlView baseControlView = BaseControlView.this;
                    baseControlView.oldObject = baseControlView.getJson();
                    this.downX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.downY = rawY;
                    this.moveX = this.downX;
                    this.moveY = rawY;
                    BaseControlView.this.hasMove = false;
                } else if (action == 1) {
                    BaseControlView baseControlView2 = BaseControlView.this;
                    baseControlView2.newObject = baseControlView2.getJson();
                    BaseControlView baseControlView3 = BaseControlView.this;
                    if (baseControlView3.hasMove) {
                        S4.d.b().f(new f(BaseControlView.this.oldObject, BaseControlView.this.newObject, BaseControlView.this));
                        BaseControlView.touchView = null;
                        BaseControlView baseControlView4 = BaseControlView.this;
                        baseControlView4.templatePage.sendDottedLineEvent(new k(2, baseControlView4));
                    } else {
                        this.clickCount++;
                        p051j0.a.d(baseControlView3.TAG, "clickCount=" + this.clickCount);
                        if (this.clickCount >= 2) {
                            this.handler.removeCallbacks(this.clickRunnable);
                            this.handler.post(this.clickRunnable);
                        } else {
                            this.handler.removeCallbacks(this.clickRunnable);
                            this.handler.postDelayed(this.clickRunnable, 200L);
                            BaseControlView.touchView = view;
                        }
                    }
                    this.downX = 0.0f;
                    this.downY = 0.0f;
                    this.moveX = 0.0f;
                    this.moveY = 0.0f;
                } else if (action == 2) {
                    BaseControlView baseControlView5 = BaseControlView.this;
                    if (!baseControlView5.lockLocation && !baseControlView5.isFixed && baseControlView5.isElementSelected) {
                        int rawX = (int) (motionEvent.getRawX() - this.moveX);
                        int rawY2 = (int) (motionEvent.getRawY() - this.moveY);
                        if (Math.abs(rawX) > 6 || Math.abs(rawY2) > 6) {
                            if (BaseControlView.this.templatePage.hasMultiSelected()) {
                                BaseControlView.this.templatePage.moveSelectedControlView(rawX, rawY2);
                            } else {
                                BaseControlView.this.moveView(rawX, rawY2);
                            }
                            this.moveX = motionEvent.getRawX();
                            this.moveY = motionEvent.getRawY();
                            BaseControlView.this.hasMove = true;
                            this.handler.removeCallbacks(this.clickRunnable);
                            BaseControlView baseControlView6 = BaseControlView.this;
                            baseControlView6.templatePage.sendDottedLineEvent(new k(1, baseControlView6));
                        }
                    }
                }
                return true;
            }
        });
        this.mBtnZoom.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.printerlabel.widget.BaseControlView.2
            private float baseX = 0.0f;
            private float baseY = 0.0f;
            private int initLeftMargin = 0;
            private int initTopMargin = 0;
            private int initWidth = 0;
            private int initHeight = 0;

            /* JADX WARN: Code duplicated, block: B:27:0x008b A[PHI: r5
  0x008b: PHI (r5v34 int) = (r5v7 int), (r5v37 int) binds: [B:23:0x0061, B:25:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:39:0x0109 A[PHI: r5
  0x0109: PHI (r5v25 int) = (r5v7 int), (r5v28 int) binds: [B:35:0x00df, B:37:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:50:0x0178 A[PHI: r5
  0x0178: PHI (r5v17 int) = (r5v7 int), (r5v20 int) binds: [B:46:0x014e, B:48:0x0164] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:67:0x0247  */
            /* JADX WARN: Code duplicated, block: B:70:0x024c  */
            /* JADX WARN: Code duplicated, block: B:81:0x029f  */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float f6;
                float f7;
                float fB;
                int rawX = 0;
                if (BaseControlView.this.lockLocation) {
                    return false;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) BaseControlView.this.mRoot.getLayoutParams());
                if (layoutParams.height < 0 && layoutParams.width < 0) {
                    return true;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) BaseControlView.this.getLayoutParams());
                int action = motionEvent.getAction();
                if (action != 0) {
                    float f8 = 0.0f;
                    if (action == 1) {
                        BaseControlView baseControlView = BaseControlView.this;
                        baseControlView.newObject = baseControlView.getJson();
                        S4.d.b().f(new f(BaseControlView.this.oldObject, BaseControlView.this.newObject, BaseControlView.this));
                        this.baseX = 0.0f;
                        this.baseY = 0.0f;
                        BaseControlView baseControlView2 = BaseControlView.this;
                        baseControlView2.templatePage.sendDottedLineEvent(new k(2, baseControlView2));
                    } else if (action == 2) {
                        int zoomScale = layoutParams.width;
                        int rawY = layoutParams.height;
                        int i5 = BaseControlView.this.rotationAngle;
                        if (i5 != 0) {
                            if (i5 != 90) {
                                if (i5 == 180) {
                                    int rawX2 = (int) (this.baseX - motionEvent.getRawX());
                                    if (zoomScale >= 0) {
                                        zoomScale = layoutParams.width + rawX2;
                                        if (zoomScale < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth()))) {
                                            zoomScale = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth());
                                        } else {
                                            rawX = rawX2;
                                        }
                                    } else {
                                        rawX = rawX2;
                                    }
                                    if (rawY >= 0) {
                                        rawY += (int) (this.baseY - motionEvent.getRawY());
                                        if (rawY < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight()))) {
                                            rawY = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight());
                                        }
                                    }
                                    f7 = -(rawY - this.initHeight);
                                    fB = -(zoomScale - this.initWidth);
                                } else if (i5 == 270) {
                                    int rawY2 = (int) (this.baseX - motionEvent.getRawY());
                                    if (zoomScale >= 0) {
                                        zoomScale = layoutParams.width + rawY2;
                                        if (zoomScale < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth()))) {
                                            zoomScale = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth());
                                        } else {
                                            rawX = rawY2;
                                        }
                                    } else {
                                        rawX = rawY2;
                                    }
                                    if (rawY >= 0) {
                                        rawY += (int) (motionEvent.getRawX() - this.baseY);
                                        if (rawY < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight()))) {
                                            rawY = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight());
                                        }
                                    }
                                    int i6 = this.initWidth;
                                    int i7 = this.initHeight;
                                    fB = AbstractC0157z.b(rawY, i7, 2, -((zoomScale - i6) / 2));
                                    f7 = (-((zoomScale - i6) / 2)) + (-((rawY - i7) / 2));
                                }
                                float f9 = fB;
                                f6 = f7;
                                f8 = f9;
                            } else {
                                int rawY3 = (int) (motionEvent.getRawY() - this.baseX);
                                if (zoomScale >= 0) {
                                    zoomScale = layoutParams.width + rawY3;
                                    if (zoomScale < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth()))) {
                                        zoomScale = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth());
                                    } else {
                                        rawX = rawY3;
                                    }
                                } else {
                                    rawX = rawY3;
                                }
                                if (rawY >= 0) {
                                    rawY += (int) (this.baseY - motionEvent.getRawX());
                                    if (rawY < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight()))) {
                                        rawY = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight());
                                    }
                                }
                                int i8 = this.initWidth;
                                int i9 = this.initHeight;
                                f6 = ((zoomScale - i8) / 2) + (-((rawY - i9) / 2));
                                f8 = ((-(zoomScale - i8)) / 2) + (-((rawY - i9) / 2));
                            }
                            if (rawX % 2 == 0) {
                                if (zoomScale <= 6 || rawY > 6) {
                                    layoutParams.width = zoomScale;
                                    layoutParams.height = rawY;
                                    layoutParams2.leftMargin = this.initLeftMargin + ((int) f8);
                                    layoutParams2.topMargin = this.initTopMargin + ((int) f6);
                                }
                                BaseControlView.this.setLayoutParams(layoutParams2);
                                BaseControlView.this.mRoot.setLayoutParams(layoutParams);
                                BaseControlView.this.onSizeChanged(layoutParams.width, layoutParams.height);
                                if (BaseControlView.this.rotationAngle != 0 || BaseControlView.this.rotationAngle == 180) {
                                    this.baseX = motionEvent.getRawX();
                                    this.baseY = motionEvent.getRawY();
                                } else if (BaseControlView.this.rotationAngle == 90 || BaseControlView.this.rotationAngle == 270) {
                                    this.baseX = motionEvent.getRawY();
                                    this.baseY = motionEvent.getRawX();
                                }
                            }
                            BaseControlView baseControlView3 = BaseControlView.this;
                            baseControlView3.templatePage.sendDottedLineEvent(new k(1, baseControlView3));
                        } else {
                            rawX = (int) (motionEvent.getRawX() - this.baseX);
                            if (zoomScale >= 0) {
                                zoomScale = layoutParams.width + rawX;
                                if (zoomScale < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth()))) {
                                    int zoomScale2 = zoomScale - ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth()));
                                    zoomScale = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minWidth());
                                    rawX = zoomScale2;
                                }
                            }
                            if (rawY >= 0) {
                                rawY += (int) (motionEvent.getRawY() - this.baseY);
                                if (rawY < ((int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight()))) {
                                    BaseControlView.this.minHeight();
                                    BaseControlView.this.templatePage.getZoomScale();
                                    rawY = (int) (BaseControlView.this.templatePage.getZoomScale() * BaseControlView.this.minHeight());
                                }
                            }
                        }
                        f6 = 0.0f;
                        if (rawX % 2 == 0) {
                            if (zoomScale <= 6) {
                                layoutParams.width = zoomScale;
                                layoutParams.height = rawY;
                                layoutParams2.leftMargin = this.initLeftMargin + ((int) f8);
                                layoutParams2.topMargin = this.initTopMargin + ((int) f6);
                            } else {
                                layoutParams.width = zoomScale;
                                layoutParams.height = rawY;
                                layoutParams2.leftMargin = this.initLeftMargin + ((int) f8);
                                layoutParams2.topMargin = this.initTopMargin + ((int) f6);
                            }
                            BaseControlView.this.setLayoutParams(layoutParams2);
                            BaseControlView.this.mRoot.setLayoutParams(layoutParams);
                            BaseControlView.this.onSizeChanged(layoutParams.width, layoutParams.height);
                            if (BaseControlView.this.rotationAngle != 0) {
                                this.baseX = motionEvent.getRawX();
                                this.baseY = motionEvent.getRawY();
                            } else {
                                this.baseX = motionEvent.getRawX();
                                this.baseY = motionEvent.getRawY();
                            }
                        }
                        BaseControlView baseControlView4 = BaseControlView.this;
                        baseControlView4.templatePage.sendDottedLineEvent(new k(1, baseControlView4));
                    }
                } else {
                    BaseControlView baseControlView5 = BaseControlView.this;
                    baseControlView5.oldObject = baseControlView5.getJson();
                    this.initLeftMargin = layoutParams2.leftMargin;
                    this.initTopMargin = layoutParams2.topMargin;
                    this.initWidth = layoutParams.width;
                    this.initHeight = layoutParams.height;
                    if (BaseControlView.this.rotationAngle == 0 || BaseControlView.this.rotationAngle == 180) {
                        this.baseX = motionEvent.getRawX();
                        this.baseY = motionEvent.getRawY();
                    } else if (BaseControlView.this.rotationAngle == 90 || BaseControlView.this.rotationAngle == 270) {
                        this.baseX = motionEvent.getRawY();
                        this.baseY = motionEvent.getRawX();
                    }
                }
                return true;
            }
        });
        this.mBtnDelete.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.BaseControlView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                S4.d dVarB = S4.d.b();
                h hVar = new h();
                hVar.f9013a = false;
                dVarB.f(hVar);
            }
        });
    }

    public boolean canAdjustFontSize() {
        return elementType() == 5 || elementType() == 7;
    }

    public abstract int defaultHeight();

    public abstract int defaultWidth();

    public void deselect() {
        if (elementType() != 0) {
            this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
            this.mBtnDelete.setVisibility(4);
            this.mBtnZoom.setVisibility(4);
        } else {
            this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
            this.mBtnDelete.setVisibility(8);
            this.mBtnZoom.setVisibility(8);
        }
        this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
        this.isElementSelected = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void directionTranslation(String str) {
        int scale = (int) (C1849c.getScale() * C1849c.getRatio());
        if ("向上".equals(str) || "向下".equals(str) || "向左".equals(str) || "向右".equals(str)) {
            this.oldObject = getJson();
            TemplatePageView templatePageView = (TemplatePageView) getParent();
            if (templatePageView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                str.getClass();
                switch (str) {
                    case "向上":
                        int startY = templatePageView.getStartY() - (this.mBtnZoom.getWidth() / 2);
                        int i5 = layoutParams.topMargin;
                        if (i5 - startY < scale) {
                            scale = i5 - startY;
                        }
                        if (scale != 0) {
                            int i6 = i5 - scale;
                            layoutParams.topMargin = i6;
                            if (i6 < startY) {
                                layoutParams.topMargin = i6 + scale;
                                break;
                            }
                            setLayoutParams(layoutParams);
                            break;
                        }
                        break;
                    case "向下":
                        int startY2 = (templatePageView.getStartY() + templatePageView.getBgHeight()) - (this.mBtnZoom.getWidth() / 2);
                        int i7 = layoutParams.topMargin;
                        if (startY2 - i7 < scale) {
                            scale = startY2 - i7;
                        }
                        if (scale != 0) {
                            int i8 = i7 + scale;
                            layoutParams.topMargin = i8;
                            if (i8 > startY2) {
                                layoutParams.topMargin = i8 - scale;
                                break;
                            }
                            setLayoutParams(layoutParams);
                            break;
                        }
                        break;
                    case "向右":
                        int startX = (templatePageView.getStartX() + templatePageView.getBgWidth()) - (this.mBtnZoom.getWidth() / 2);
                        int i9 = layoutParams.leftMargin;
                        if (startX - i9 < scale) {
                            scale = startX - i9;
                        }
                        if (scale != 0) {
                            int i10 = i9 + scale;
                            layoutParams.leftMargin = i10;
                            if (i10 > startX) {
                                layoutParams.leftMargin = i10 - scale;
                                break;
                            }
                            setLayoutParams(layoutParams);
                            break;
                        }
                        break;
                    case "向左":
                        int startX2 = templatePageView.getStartX() - (this.mBtnZoom.getWidth() / 2);
                        int i11 = layoutParams.leftMargin;
                        if (i11 - startX2 < scale) {
                            scale = i11 - startX2;
                        }
                        if (scale != 0) {
                            int i12 = i11 - scale;
                            layoutParams.leftMargin = i12;
                            if (i12 < startX2) {
                                layoutParams.leftMargin = i12 + scale;
                                break;
                            }
                            setLayoutParams(layoutParams);
                            break;
                        }
                        break;
                    default:
                        setLayoutParams(layoutParams);
                        break;
                }
            }
            this.newObject = getJson();
            S4.d.b().f(new f(this.oldObject, this.newObject, this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i5 = this.rotationAngle;
        if (i5 != 90 && i5 != 270 && i5 != 180) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        Matrix matrix = new Matrix();
        getMatrix().invert(matrix);
        matrix.mapPoints(fArr);
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }

    public abstract int elementType();

    public Rect getControlHitRect() {
        Rect rect = new Rect();
        getHitRect(rect);
        if (!this.isElementSelected) {
            rect.inset(this.mBtnZoom.getWidth() / 2, this.mBtnZoom.getHeight() / 2);
        }
        return rect;
    }

    public Rect getControlRect() {
        Rect rect = new Rect();
        getHitRect(rect);
        return rect;
    }

    public JSONObject getJson() {
        this.saveObject = new JSONObject();
        try {
            this.saveObject.put("l", C1849c.px2mmWithScale(getViewLocation().x));
            this.saveObject.put("t", C1849c.px2mmWithScale(getViewLocation().y));
            int i5 = this.rotationAngle;
            if (i5 == 0 || i5 == 180) {
                this.saveObject.put("w", C1849c.px2mmWithScale((this.mRoot.getWidth() - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight()));
                this.saveObject.put("h", C1849c.px2mmWithScale((this.mRoot.getHeight() - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom()));
            } else {
                this.saveObject.put("w", C1849c.px2mmWithScale((this.mRoot.getHeight() - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom()));
                this.saveObject.put("h", C1849c.px2mmWithScale((this.mRoot.getWidth() - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight()));
            }
            this.saveObject.put("rotate", this.rotationAngle);
            this.saveObject.put("lockLocation", this.lockLocation);
            this.saveObject.put("itemType", elementType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.saveObject;
    }

    public int getLayoutHeight() {
        int height;
        int zoomScale = ((RelativeLayout.LayoutParams) this.mRoot.getLayoutParams()).height;
        if (zoomScale < 0) {
            zoomScale = (int) (this.templatePage.getZoomScale() * defaultHeight());
            height = this.mBtnZoom.getHeight();
        } else {
            height = this.mBtnZoom.getHeight();
        }
        return height + zoomScale;
    }

    public boolean getObjectBoolean(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public float getObjectFloat(JSONObject jSONObject, String str, float f6) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return f6;
        }
    }

    public int getObjectInt(JSONObject jSONObject, String str, int i5) {
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return i5;
        }
    }

    public long getObjectLong(JSONObject jSONObject, String str, long j6) {
        try {
            return jSONObject.getLong(str);
        } catch (JSONException unused) {
            return j6;
        }
    }

    public String getObjectString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    public int getRootHeight() {
        return this.mRoot.getHeight();
    }

    public int getRootWidth() {
        return this.mRoot.getWidth();
    }

    public int getRotationAngle() {
        return this.rotationAngle;
    }

    public int getViewHeight() {
        int i5 = this.rotationAngle;
        if (i5 != 0) {
            if (i5 != 90) {
                if (i5 != 180) {
                    if (i5 != 270) {
                        return 0;
                    }
                }
            }
            return this.mRoot.getWidth();
        }
        return this.mRoot.getHeight();
    }

    public Point getViewLocation() {
        int width = (getWidth() - getHeight()) / 2;
        int paddingLeft = this.mRoot.getPaddingLeft() + (this.mBtnZoom.getWidth() / 2);
        Point point = new Point();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int i5 = this.rotationAngle;
        if (i5 != 0) {
            if (i5 != 90) {
                if (i5 != 180) {
                    if (i5 != 270) {
                        return point;
                    }
                }
            }
            point.x = ((layoutParams.leftMargin + width) + paddingLeft) - this.templatePage.getStartX();
            point.y = ((layoutParams.topMargin - width) + paddingLeft) - this.templatePage.getStartY();
            return point;
        }
        point.x = (layoutParams.leftMargin + paddingLeft) - this.templatePage.getStartX();
        point.y = (layoutParams.topMargin + paddingLeft) - this.templatePage.getStartY();
        return point;
    }

    public int getViewWidth() {
        int i5 = this.rotationAngle;
        if (i5 != 0) {
            if (i5 != 90) {
                if (i5 != 180) {
                    if (i5 != 270) {
                        return 0;
                    }
                }
            }
            return this.mRoot.getHeight();
        }
        return this.mRoot.getWidth();
    }

    public void hiddenBorder() {
        this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
        if (elementType() != 0) {
            this.mBtnDelete.setVisibility(4);
            this.mBtnZoom.setVisibility(4);
        } else {
            this.mBtnDelete.setVisibility(8);
            this.mBtnZoom.setVisibility(8);
        }
    }

    public boolean isElementSelected() {
        return this.isElementSelected;
    }

    public boolean isHitElement(int i5, int i6, int i7) {
        return getControlHitRect().contains(i6, i7);
    }

    public boolean isInDelete(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.mBtnDelete.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        return rawX >= ((float) i5) && rawX <= ((float) (i5 + this.mBtnDelete.getWidth())) && rawY >= ((float) i6) && rawY <= ((float) (i6 + this.mBtnDelete.getHeight()));
    }

    public int isInRange(MotionEvent motionEvent) {
        int width;
        int height;
        int[] iArr = new int[2];
        this.mRoot.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.isElementSelected) {
            width = getWidth();
            height = getHeight();
        } else {
            width = this.mRoot.getWidth();
            height = this.mRoot.getHeight();
        }
        int i7 = this.rotationAngle;
        if (i7 != 0) {
            if (i7 != 90) {
                if (i7 != 180) {
                    if (i7 == 270 && (rawX < i5 || rawX > i5 + height || rawY < i6 - width || rawY > i6)) {
                        return Integer.MAX_VALUE;
                    }
                } else if (rawX < i5 - width || rawX > i5 || rawY < i6 - height || rawY > i6) {
                    return Integer.MAX_VALUE;
                }
            } else if (rawX < i5 - height || rawX > i5 || rawY < i6 || rawY > i6 + width) {
                return Integer.MAX_VALUE;
            }
        } else if (rawX < i5 || rawX > i5 + width || rawY < i6 || rawY > i6 + height) {
            return Integer.MAX_VALUE;
        }
        return this.mRoot.getHeight() * this.mRoot.getWidth();
    }

    public boolean isInZoom(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.mBtnZoom.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        return rawX >= ((float) i5) && rawX <= ((float) (i5 + this.mBtnZoom.getWidth())) && rawY >= ((float) i6) && rawY <= ((float) (i6 + this.mBtnZoom.getHeight()));
    }

    public boolean isLockLocation() {
        return this.lockLocation;
    }

    public boolean isRenderingCompleted() {
        return this.isRenderingCompleted;
    }

    public boolean isTakePrint() {
        return this.takePrint;
    }

    @LayoutRes
    public abstract int layoutId();

    public abstract int minHeight();

    public abstract int minWidth();

    /* JADX WARN: Code duplicated, block: B:17:0x0024  */
    /* JADX WARN: Code duplicated, block: B:19:0x002e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    public void moveView(int i5, int i6) {
        if (!this.isElementSelected || elementType() == 0 || this.templatePage == null) {
            return;
        }
        this.mBtnZoom.getHeight();
        int i7 = this.rotationAngle;
        if (i7 == 0) {
            this.templatePage.getStartX();
            this.templatePage.getStartY();
        } else if (i7 == 90) {
            if (getWidth() > getHeight()) {
                this.templatePage.getStartX();
                getWidth();
                getHeight();
                this.templatePage.getStartY();
                getWidth();
                getHeight();
            } else {
                this.templatePage.getStartX();
                getHeight();
                getWidth();
                this.templatePage.getStartY();
                getHeight();
                getWidth();
            }
        } else if (i7 == 180) {
            this.templatePage.getStartX();
            this.templatePage.getStartY();
        } else if (i7 == 270) {
            if (getWidth() > getHeight()) {
                this.templatePage.getStartX();
                getWidth();
                getHeight();
                this.templatePage.getStartY();
                getWidth();
                getHeight();
            } else {
                this.templatePage.getStartX();
                getHeight();
                getWidth();
                this.templatePage.getStartY();
                getHeight();
                getWidth();
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int i8 = layoutParams.leftMargin + i5;
        int i9 = layoutParams.topMargin + i6;
        layoutParams.leftMargin = i8;
        layoutParams.topMargin = i9;
        layoutParams.bottomMargin = Integer.MIN_VALUE;
        layoutParams.rightMargin = Integer.MIN_VALUE;
        setLayoutParams(layoutParams);
    }

    public void moveViewWithRecord(int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.oldObject = getJson();
        moveView(i5, i6);
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!(this instanceof PrinterLabelBgView)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void recoverFromJson(JSONObject jSONObject) {
        try {
            this.rotationAngle = jSONObject.getInt("rotate");
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
            int i5 = this.rotationAngle;
            if (i5 == 0 || i5 == 180) {
                layoutParams.width = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("w")) + this.mRoot.getPaddingLeft() + this.mRoot.getPaddingRight();
                layoutParams.height = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("h")) + this.mRoot.getPaddingTop() + this.mRoot.getPaddingBottom();
                this.realWidth = (float) jSONObject.getDouble("w");
                this.realHeight = (float) jSONObject.getDouble("h");
            } else {
                layoutParams.width = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("h")) + this.mRoot.getPaddingLeft() + this.mRoot.getPaddingRight();
                layoutParams.height = C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("w")) + this.mRoot.getPaddingTop() + this.mRoot.getPaddingBottom();
                this.realWidth = (float) jSONObject.getDouble("h");
                this.realHeight = (float) jSONObject.getDouble("w");
            }
            if (this.saveCopy) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                Point viewLocation = getViewLocation(C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("l")), C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("t")));
                layoutParams2.leftMargin = viewLocation.x;
                layoutParams2.topMargin = viewLocation.y;
                for (int i6 = 1; i6 < 100; i6++) {
                    int i7 = viewLocation.x;
                    int i8 = i6 * 100;
                    if (!this.templatePage.hasSameSizeElement(new Rect(i7 + i8, viewLocation.y + i8, i7 + i8 + layoutParams.width + this.mBtnZoom.getLayoutParams().width, viewLocation.y + i8 + layoutParams.height + this.mBtnZoom.getLayoutParams().height))) {
                        layoutParams2.leftMargin = viewLocation.x + i8;
                        layoutParams2.topMargin = viewLocation.y + i8;
                        break;
                    }
                }
                setLayoutParams(layoutParams2);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getLayoutParams();
                Point viewLocation2 = getViewLocation(C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("l")), C1849c.mm2pxWithScaleForInt((float) jSONObject.getDouble("t")));
                layoutParams3.leftMargin = viewLocation2.x;
                layoutParams3.topMargin = viewLocation2.y;
                setLayoutParams(layoutParams3);
            }
            this.mRoot.setLayoutParams(layoutParams);
            setLockLocation(jSONObject.getBoolean("lockLocation"));
            updateView();
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
    }

    public void resetBorder() {
        if (this.isElementSelected) {
            boolean z6 = (this.lockLocation || this.isFixed) ? false : true;
            if (elementType() != 0) {
                this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                this.mBtnDelete.setVisibility(z6 ? 0 : 4);
                this.mBtnZoom.setVisibility(z6 ? 0 : 4);
            } else {
                this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                this.mBtnDelete.setVisibility(z6 ? 0 : 8);
                this.mBtnZoom.setVisibility(z6 ? 0 : 8);
            }
        }
    }

    public void runWithTemplateEdit(TemplateEditTask templateEditTask) {
        this.oldObject = getJson();
        templateEditTask.run();
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void select(boolean z6) {
        boolean z7 = (this.lockLocation || this.isFixed || z6) ? false : true;
        if (elementType() != 0) {
            this.mBtnDelete.setVisibility(z7 ? 0 : 4);
            this.mBtnZoom.setVisibility(z7 ? 0 : 4);
            if (this.templatePage.isMultipleMode() && this.lockLocation) {
                this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame_null);
                this.isElementSelected = false;
            } else {
                this.mRoot.setBackgroundResource(p113u.c.bg_view_base_control_frame);
                this.isElementSelected = true;
            }
        }
    }

    public void setControlType(int i5) {
        this.controlType = i5;
        if (i5 != 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
            if (layoutParams.width <= 0) {
                layoutParams.width = this.mRoot.getWidth();
            }
            boolean z6 = (this.lockLocation || this.isFixed) ? false : true;
            if (i5 == 1) {
                if (layoutParams.height <= 0) {
                    layoutParams.height = this.mRoot.getHeight();
                }
                if (this.isElementSelected) {
                    this.mBtnDelete.setVisibility(4);
                    this.mBtnZoom.setVisibility(4);
                }
            } else {
                if (this.isElementSelected) {
                    this.mBtnDelete.setVisibility(z6 ? 0 : 4);
                    this.mBtnZoom.setVisibility(z6 ? 0 : 4);
                }
                if (i5 == 2) {
                    if (layoutParams.height <= 0) {
                        layoutParams.height = this.mRoot.getHeight() != 0 ? this.mRoot.getHeight() : -2;
                    }
                } else if (i5 == 3) {
                    layoutParams.height = -2;
                } else if (i5 == 4) {
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                } else if (i5 == 5) {
                    layoutParams.width = -2;
                }
            }
            this.mRoot.setLayoutParams(layoutParams);
        }
    }

    public void setJson(JSONObject jSONObject, boolean z6) {
        this.saveCopy = z6;
        recoverFromJson(jSONObject);
        this.saveCopy = false;
    }

    public void setLocationBottom() {
        this.oldObject = getJson();
        if (this.templatePage != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = ((this.templatePage.getBgHeight() - getRootHeight()) - (this.mBtnDelete.getWidth() / 2)) - this.templatePage.getStartX();
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLocationCenterHorizontally() {
        this.oldObject = getJson();
        TemplatePageView templatePageView = (TemplatePageView) getParent();
        if (templatePageView != null) {
            int bgWidth = (templatePageView.getBgWidth() - getRootWidth()) / 2;
            int i5 = -(this.mBtnZoom.getHeight() / 2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = templatePageView.getStartX() + bgWidth + i5;
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLocationCenterVertically() {
        this.oldObject = getJson();
        TemplatePageView templatePageView = (TemplatePageView) getParent();
        if (templatePageView != null) {
            int bgHeight = (templatePageView.getBgHeight() - getRootHeight()) / 2;
            int i5 = -(this.mBtnZoom.getHeight() / 2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = templatePageView.getStartY() + bgHeight + i5;
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLocationLeft() {
        this.oldObject = getJson();
        if (this.templatePage != null) {
            int i5 = -(this.mBtnZoom.getHeight() / 2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = this.templatePage.getStartX() + i5;
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLocationRight() {
        this.oldObject = getJson();
        if (this.templatePage != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = ((this.templatePage.getBgWidth() - getRootWidth()) - (this.mBtnDelete.getWidth() / 2)) - this.templatePage.getStartY();
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLocationTop() {
        this.oldObject = getJson();
        if (this.templatePage != null) {
            int i5 = -(this.mBtnZoom.getHeight() / 2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = this.templatePage.getStartY() + i5;
            setLayoutParams(layoutParams);
        }
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setLockLocation(boolean z6) {
        this.lockLocation = z6;
        updateView();
    }

    public void setRotationAngle(int i5) {
        this.oldObject = getJson();
        this.rotationAngle = i5;
        updateView();
        this.newObject = getJson();
        S4.d.b().f(new f(this.oldObject, this.newObject, this));
    }

    public void setTakePrint(boolean z6) {
        this.takePrint = z6;
    }

    public void updateRealSize() {
        float fB;
        float fB2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int paddingLeft = this.mRoot.getPaddingLeft() + (this.mBtnZoom.getLayoutParams().width / 2);
        float fB3 = this.templatePage.getScaleConvert().b(layoutParams.leftMargin + paddingLeft);
        float fB4 = this.templatePage.getScaleConvert().b(layoutParams.topMargin + paddingLeft);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
        int paddingLeft2 = (layoutParams2.width - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight();
        int paddingTop = (layoutParams2.height - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom();
        if (paddingLeft2 > 0) {
            fB = this.templatePage.getScaleConvert().b((layoutParams2.width - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight());
        } else {
            paddingLeft2 = (this.mRoot.getWidth() - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight();
            fB = this.templatePage.getScaleConvert().b(paddingLeft2);
        }
        if (paddingTop > 0) {
            fB2 = this.templatePage.getScaleConvert().b((layoutParams2.height - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom());
        } else {
            paddingTop = (this.mRoot.getHeight() - this.mRoot.getPaddingTop()) - this.mRoot.getPaddingBottom();
            fB2 = this.templatePage.getScaleConvert().b(paddingTop);
        }
        if (Math.abs(this.realX + 1.0f) < 0.001d || Math.abs((layoutParams.leftMargin + paddingLeft) - this.templatePage.getScaleConvert().a(this.realX)) > 1) {
            this.realX = fB3;
        }
        if (Math.abs(this.realY + 1.0f) < 0.001d || Math.abs((layoutParams.topMargin + paddingLeft) - this.templatePage.getScaleConvert().a(this.realY)) > 1) {
            this.realY = fB4;
        }
        if (Math.abs(this.realWidth + 1.0f) < 0.001d || Math.abs(paddingLeft2 - this.templatePage.getScaleConvert().a(this.realWidth)) > 1) {
            this.realWidth = fB;
        }
        if (Math.abs(this.realHeight + 1.0f) < 0.001d || Math.abs(paddingTop - this.templatePage.getScaleConvert().a(this.realHeight)) > 1) {
            this.realHeight = fB2;
        }
    }

    public void updateView() {
        setRotation(this.rotationAngle);
    }

    public void updateZoomedRootView(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.width > 0) {
            marginLayoutParams.width = view.getPaddingRight() + view.getPaddingLeft() + this.templatePage.getScaleConvert().a(this.realWidth);
        }
        if (marginLayoutParams.height > 0) {
            marginLayoutParams.height = view.getPaddingBottom() + view.getPaddingTop() + this.templatePage.getScaleConvert().a(this.realHeight);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public void updateZoomedSize() {
        updateZoomedView(this);
        updateZoomedRootView(this.mRoot);
    }

    public void updateZoomedView(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.width > 0) {
            marginLayoutParams.width = this.mRoot.getPaddingRight() + this.mRoot.getPaddingLeft() + this.templatePage.getScaleConvert().a(this.realWidth);
        }
        if (marginLayoutParams.height > 0) {
            marginLayoutParams.height = this.mRoot.getPaddingBottom() + this.mRoot.getPaddingTop() + this.templatePage.getScaleConvert().a(this.realHeight);
        }
        int paddingLeft = this.mRoot.getPaddingLeft() + (this.mBtnZoom.getLayoutParams().width / 2);
        marginLayoutParams.topMargin = this.templatePage.getScaleConvert().a(this.realY) - paddingLeft;
        marginLayoutParams.leftMargin = this.templatePage.getScaleConvert().a(this.realX) - paddingLeft;
        view.setLayoutParams(marginLayoutParams);
    }

    public void runWithTemplateEdit(TemplateEditTaskWithResult templateEditTaskWithResult) {
        this.oldObject = getJson();
        if (templateEditTaskWithResult.run()) {
            this.newObject = getJson();
            S4.d.b().f(new f(this.oldObject, this.newObject, this));
        }
    }

    public Point getViewLocation(int i5, int i6) {
        int i7 = (this.mRoot.getLayoutParams().width - this.mRoot.getLayoutParams().height) / 2;
        int paddingLeft = this.mRoot.getPaddingLeft() + (this.mBtnZoom.getLayoutParams().width / 2);
        Point point = new Point();
        int i8 = this.rotationAngle;
        if (i8 != 0) {
            if (i8 != 90) {
                if (i8 != 180) {
                    if (i8 != 270) {
                        return point;
                    }
                }
            }
            point.x = this.templatePage.getStartX() + ((i5 - i7) - paddingLeft);
            point.y = this.templatePage.getStartY() + ((i6 + i7) - paddingLeft);
            return point;
        }
        point.x = this.templatePage.getStartX() + (i5 - paddingLeft);
        point.y = this.templatePage.getStartY() + (i6 - paddingLeft);
        return point;
    }

    public BaseControlView getElementView() {
        return this;
    }

    public void onSizeChanged(int i5, int i6) {
    }
}
