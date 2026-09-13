package com.zlylib.titlebarlib.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.zlylib.titlebarlib.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ActionBarEx extends FrameLayout {
    private LinearLayout mActionBar;
    private Activity mActivity;
    private View mBackgroundLayer;
    private int mBackgroundLayerImageRes;
    private int mBackgroundLayerLayoutRes;
    private View mBottomLine;

    @ColorInt
    private int mBottomLineColor;
    private int mBottomLineHeight;
    private boolean mBottomLineOutside;
    private int mBottomLineResId;
    private int mClickToFinishViewId;
    private View mForegroundLayer;
    private int mForegroundLayerLayoutRes;
    private int mImmersion;
    private StatusBarView mStatusBar;

    @ColorInt
    private int mStatusBarColor;
    private int mStatusBarMode;
    private int mStatusBarVisible;
    private FrameLayout mTitleBar;
    private int mTitleBarHeight;
    private int mTitleBarLayoutRes;
    private SparseArray<View> views;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Immersion {
        public static final int IMMERSED = 2;
        public static final int ORDINARY = 1;
        public static final int UNCHANGED = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusBarMode {
        public static final int AUTO = 3;
        public static final int DARK = 2;
        public static final int LIGHT = 1;
        public static final int REAL_TIME = 4;
        public static final int UNCHANGED = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusBarVisible {
        public static final int AUTO = 0;
        public static final int GONE = 2;
        public static final int VISIBLE = 1;
    }

    public ActionBarEx(Context context) {
        this(context, null);
    }

    @Nullable
    private Activity getActivity() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity;
        }
        Context context = getContext();
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                this.mActivity = (Activity) baseContext;
            }
        }
        return this.mActivity;
    }

    private void hintSystemActionBar() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (activity.getActionBar() != null) {
            activity.getActionBar().hide();
        }
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            if (appCompatActivity.getSupportActionBar() != null) {
                appCompatActivity.getSupportActionBar().hide();
            }
        }
    }

    private FrameLayout.LayoutParams makeLayerLayoutParamsMatch() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private FrameLayout.LayoutParams makeLayerLayoutParamsWrap() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    private void performClickToFinish() {
        View view = getView(this.mClickToFinishViewId);
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.widget.ActionBarEx.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ActionBarEx.this.finishActivity();
            }
        });
    }

    private void refreshStatusBarModeAuto() {
        post(new Runnable() { // from class: com.zlylib.titlebarlib.widget.ActionBarEx.1
            @Override // java.lang.Runnable
            public void run() {
                c.setIconModeAuto(ActionBarEx.this.getContext());
            }
        });
    }

    public double calculateStatusBarBgLuminance() {
        return c.calcBgLuminance(getContext());
    }

    public void finishActivity() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public LinearLayout getActionBar() {
        return this.mActionBar;
    }

    public View getBackgroundLayer() {
        return this.mBackgroundLayer;
    }

    public View getBottomLine() {
        return this.mBottomLine;
    }

    public View getForegroundLayer() {
        return this.mForegroundLayer;
    }

    public StatusBarView getStatusBar() {
        return this.mStatusBar;
    }

    public FrameLayout getTitleBar() {
        return this.mTitleBar;
    }

    public int getTitleBarRes() {
        return this.mTitleBarLayoutRes;
    }

    public <V extends View> V getView(@IdRes int i5) {
        if (this.views == null) {
            this.views = new SparseArray<>();
        }
        V v6 = (V) this.views.get(i5);
        if (v6 != null) {
            return v6;
        }
        V v7 = (V) findViewById(i5);
        this.views.put(i5, v7);
        return v7;
    }

    public View inflateTitleBar() {
        if (getTitleBarRes() > 0) {
            return LayoutInflater.from(getContext()).inflate(getTitleBarRes(), (ViewGroup) this.mTitleBar, false);
        }
        return null;
    }

    @CallSuper
    public void initAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ActionBarEx);
        this.mImmersion = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarEx_ab_immersion, this.mImmersion);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_backgroundLayerLayout, this.mBackgroundLayerLayoutRes);
        this.mBackgroundLayerLayoutRes = resourceId;
        this.mBackgroundLayerImageRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_backgroundLayerImageRes, resourceId);
        this.mStatusBarVisible = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarEx_ab_statusBarVisible, this.mStatusBarVisible);
        this.mStatusBarMode = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarEx_ab_statusBarMode, this.mStatusBarMode);
        this.mStatusBarColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarEx_ab_statusBarColor, this.mStatusBarColor);
        this.mTitleBarHeight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarEx_ab_titleBarHeight, this.mTitleBarHeight);
        this.mTitleBarLayoutRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_titleBarLayout, this.mTitleBarLayoutRes);
        this.mBottomLineHeight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarEx_ab_bottomLineHeight, this.mBottomLineHeight);
        this.mBottomLineColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarEx_ab_bottomLineColor, this.mBottomLineColor);
        this.mBottomLineResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_bottomLineResId, this.mBottomLineResId);
        this.mBottomLineOutside = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarEx_ab_bottomLineOutside, this.mBottomLineOutside);
        this.mForegroundLayerLayoutRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_foregroundLayerLayout, this.mForegroundLayerLayoutRes);
        this.mClickToFinishViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarEx_ab_clickToFinish, this.mClickToFinishViewId);
        typedArrayObtainStyledAttributes.recycle();
    }

    @CallSuper
    public void initView() {
        if (this.mBackgroundLayerLayoutRes > 0) {
            View viewInflate = View.inflate(getContext(), this.mBackgroundLayerLayoutRes, null);
            this.mBackgroundLayer = viewInflate;
            addViewInLayout(viewInflate, getChildCount(), makeLayerLayoutParamsMatch(), true);
        } else if (this.mBackgroundLayerImageRes > 0) {
            ImageView imageView = new ImageView(getContext());
            this.mBackgroundLayer = imageView;
            addViewInLayout(imageView, getChildCount(), makeLayerLayoutParamsMatch(), true);
            imageView.setImageResource(this.mBackgroundLayerImageRes);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R.layout.actionbarex_action_bar, null);
        this.mActionBar = linearLayout;
        addViewInLayout(linearLayout, getChildCount(), makeLayerLayoutParamsWrap(), true);
        this.mStatusBar = (StatusBarView) this.mActionBar.findViewById(R.id.actionbarex_status_bar);
        FrameLayout frameLayout = (FrameLayout) this.mActionBar.findViewById(R.id.actionbarex_title_bar);
        this.mTitleBar = frameLayout;
        frameLayout.setClickable(true);
        this.mTitleBar.setFocusable(true);
        this.mTitleBar.setFocusableInTouchMode(true);
        if (this.mTitleBarHeight >= 0) {
            this.mTitleBar.getLayoutParams().height = this.mTitleBarHeight;
        }
        setTitleBarChild(inflateTitleBar());
        View viewFindViewById = this.mActionBar.findViewById(R.id.actionbarex_bottom_line);
        this.mBottomLine = viewFindViewById;
        viewFindViewById.getLayoutParams().height = this.mBottomLineHeight;
        int i5 = this.mBottomLineResId;
        if (i5 > 0) {
            this.mBottomLine.setBackgroundResource(i5);
        } else {
            this.mBottomLine.setBackgroundColor(this.mBottomLineColor);
        }
        if (this.mBottomLineOutside) {
            this.mActionBar.setClipChildren(false);
            setClipChildren(false);
        }
        if (this.mForegroundLayerLayoutRes > 0) {
            View viewInflate2 = View.inflate(getContext(), this.mForegroundLayerLayoutRes, null);
            this.mForegroundLayer = viewInflate2;
            addViewInLayout(viewInflate2, getChildCount(), makeLayerLayoutParamsMatch(), true);
        }
        performClickToFinish();
    }

    public boolean isStatusBarBgLight() {
        return c.isBgLight(getContext());
    }

    public boolean isStatusBarIconDark() {
        return c.isIconDark(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mBottomLineOutside) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).setClipChildren(false);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != this.mForegroundLayer && childAt != this.mActionBar && childAt != this.mBackgroundLayer) {
                removeView(childAt);
                this.mTitleBar.addView(childAt, 0);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        int measuredHeight;
        this.mActionBar.measure(i5, i6);
        int measuredWidth = this.mActionBar.getMeasuredWidth();
        if (this.mBottomLineOutside) {
            measuredHeight = this.mTitleBar.getMeasuredHeight() + this.mStatusBar.getMeasuredHeight();
        } else {
            measuredHeight = this.mActionBar.getMeasuredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void refresh() {
        refreshImmersion();
        refreshStatusBarVisible();
        refreshStatusBarMode();
        refreshStatusBarColor();
    }

    public void refreshImmersion() {
        int i5 = this.mImmersion;
        if (i5 == 1) {
            c.unTransparent(getContext());
        } else {
            if (i5 != 2) {
                return;
            }
            c.transparent(getContext());
        }
    }

    public void refreshStatusBarColor() {
        this.mStatusBar.setBackgroundColor(this.mStatusBarColor);
        if (c.isTransparent(getContext()) && this.mStatusBar.isVisibility()) {
            c.setColor(getContext(), 0);
        } else {
            c.setColor(getContext(), this.mStatusBarColor);
        }
    }

    public void refreshStatusBarMode() {
        c.unregisterToAutoChangeIconMode(getContext());
        int i5 = this.mStatusBarMode;
        if (i5 == 1) {
            c.setIconMode(getContext(), false);
            return;
        }
        if (i5 == 2) {
            c.setIconMode(getContext(), true);
        } else if (i5 == 3) {
            refreshStatusBarModeAuto();
        } else {
            if (i5 != 4) {
                return;
            }
            c.registerToAutoChangeIconMode(getContext());
        }
    }

    public void refreshStatusBarVisible() {
        int i5 = this.mStatusBarVisible;
        if (i5 == 0) {
            this.mStatusBar.setVisibility(c.isTransparent(getContext()));
        } else if (i5 == 1) {
            this.mStatusBar.setVisibility(true);
        } else {
            if (i5 != 2) {
                return;
            }
            this.mStatusBar.setVisibility(false);
        }
    }

    public void setImmersion(int i5) {
        this.mImmersion = i5;
    }

    public void setStatusBarColor(@ColorInt int i5) {
        this.mStatusBarColor = i5;
    }

    public void setStatusBarMode(int i5) {
        this.mStatusBarMode = i5;
    }

    public void setStatusBarVisible(int i5) {
        this.mStatusBarVisible = i5;
    }

    public void setTitleBarChild(View view) {
        this.mTitleBar.removeAllViewsInLayout();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            if (this.mTitleBarHeight >= 0) {
                layoutParams.height = -1;
            }
            this.mTitleBar.addView(view, layoutParams);
        }
    }

    public ActionBarEx(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarEx(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mImmersion = 0;
        this.mStatusBarVisible = 0;
        this.mStatusBarMode = 0;
        this.mStatusBarColor = 0;
        this.mTitleBarHeight = -1;
        this.mTitleBarLayoutRes = 0;
        this.mBottomLineColor = 0;
        this.mBottomLineResId = 0;
        this.mBottomLineHeight = 0;
        this.mBottomLineOutside = false;
        this.mForegroundLayerLayoutRes = 0;
        this.mBackgroundLayerLayoutRes = 0;
        this.mBackgroundLayerImageRes = 0;
        this.mClickToFinishViewId = 0;
        this.mActivity = null;
        this.views = null;
        hintSystemActionBar();
        initAttrs(attributeSet);
        initView();
        refresh();
    }
}
