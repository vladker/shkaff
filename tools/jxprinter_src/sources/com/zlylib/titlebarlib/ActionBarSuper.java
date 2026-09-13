package com.zlylib.titlebarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.zlylib.titlebarlib.widget.ActionBarEx;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ActionBarSuper extends ActionBarEx {
    private int iconColor;
    private int[] iconMargin;
    private int[] iconPadding;
    private ActionView[] leftActionViews;
    private boolean[] leftIconClickToFinish;
    private int leftIconColor;
    private int[] leftIconColors;
    private int[] leftIconMargin;
    private int[][] leftIconMargins;
    private int[] leftIconPadding;
    private int[][] leftIconPaddings;
    private int[] leftIcons;
    private int[] leftPadding;
    private boolean[] leftTextClickToFinish;
    private int leftTextColor;
    private int[] leftTextColors;
    private int[] leftTextMargin;
    private int[][] leftTextMargins;
    private int[] leftTextPadding;
    private int[][] leftTextPaddings;
    private float leftTextSize;
    private float[] leftTextSizes;
    private int leftTextStyle;
    private int[] leftTextStyles;
    private String[] leftTexts;
    private ActionView[] rightActionViews;
    private boolean[] rightIconClickToFinish;
    private int rightIconColor;
    private int[] rightIconColors;
    private int[] rightIconMargin;
    private int[][] rightIconMargins;
    private int[] rightIconPadding;
    private int[][] rightIconPaddings;
    private int[] rightIcons;
    private int[] rightPadding;
    private boolean[] rightTextClickToFinish;
    private int rightTextColor;
    private int[] rightTextColors;
    private int[] rightTextMargin;
    private int[][] rightTextMargins;
    private int[] rightTextPadding;
    private int[][] rightTextPaddings;
    private float rightTextSize;
    private float[] rightTextSizes;
    private int rightTextStyle;
    private int[] rightTextStyles;
    private String[] rightTexts;
    private int[] subtitleMargin;
    private int[] subtitlePadding;
    private String subtitleText;
    private int subtitleTextColor;
    private int subtitleTextMaxWidth;
    private float subtitleTextSize;
    private int subtitleTextStyle;
    private TextView subtitleTextView;
    private int textColor;
    private int[] textMargin;
    private int[] textPadding;
    private float textSize;
    private int textStyle;
    private FrameLayout titleBarChild;
    private int titleGravity;
    private int[] titleMargin;
    private int[] titlePadding;
    private String titleText;
    private int titleTextColor;
    private int titleTextMaxWidth;
    private float titleTextSize;
    private int titleTextStyle;
    private TextView titleTextView;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextStyle {
        public static final int BOLD = 1;
        public static final int NORMAL = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleGravity {
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    public ActionBarSuper(Context context) {
        this(context, null);
    }

    private void initLeftActionViews() {
        LinearLayout linearLayout = (LinearLayout) this.titleBarChild.findViewById(R.id.actionbarex_common_ll_left);
        int[] iArr = this.leftPadding;
        linearLayout.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        ActionView[] actionViewArr = new ActionView[5];
        this.leftActionViews = actionViewArr;
        actionViewArr[0] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_left1);
        this.leftActionViews[1] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_left2);
        this.leftActionViews[2] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_left3);
        this.leftActionViews[3] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_left4);
        this.leftActionViews[4] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_left5);
        int i5 = 0;
        while (true) {
            ActionView[] actionViewArr2 = this.leftActionViews;
            if (i5 >= actionViewArr2.length) {
                return;
            }
            setTextStyle(actionViewArr2[i5].getTextView(), this.leftTextStyles[i5]);
            ActionView actionView = this.leftActionViews[i5];
            int[] iArr2 = this.leftTextPaddings[i5];
            actionView.setTextPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            ActionView actionView2 = this.leftActionViews[i5];
            int[] iArr3 = this.leftTextMargins[i5];
            actionView2.setTextMargin(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
            this.leftActionViews[i5].setTextColor(this.leftTextColors[i5]);
            this.leftActionViews[i5].setTextSizePx(this.leftTextSizes[i5]);
            ActionView actionView3 = this.leftActionViews[i5];
            int[] iArr4 = this.leftIconPaddings[i5];
            actionView3.setIconPadding(iArr4[0], iArr4[1], iArr4[2], iArr4[3]);
            ActionView actionView4 = this.leftActionViews[i5];
            int[] iArr5 = this.leftIconMargins[i5];
            actionView4.setIconMargin(iArr5[0], iArr5[1], iArr5[2], iArr5[3]);
            this.leftActionViews[i5].setIconColorInt(this.leftIconColors[i5]);
            int i6 = this.leftIcons[i5];
            if (i6 > 0) {
                this.leftActionViews[i5].setIcon(i6);
            } else if (TextUtils.isEmpty(this.leftTexts[i5])) {
                this.leftActionViews[i5].toggleToGone();
            } else {
                this.leftActionViews[i5].setText(this.leftTexts[i5]);
            }
            if (this.leftTextClickToFinish[i5]) {
                this.leftActionViews[i5].getTextView().setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSuper.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSuper.this.finishActivity();
                    }
                });
            }
            if (this.leftIconClickToFinish[i5]) {
                this.leftActionViews[i5].getIconView().setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSuper.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSuper.this.finishActivity();
                    }
                });
            }
            i5++;
        }
    }

    private void initRightActionViews() {
        LinearLayout linearLayout = (LinearLayout) this.titleBarChild.findViewById(R.id.actionbarex_common_ll_right);
        int[] iArr = this.rightPadding;
        linearLayout.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        ActionView[] actionViewArr = new ActionView[5];
        this.rightActionViews = actionViewArr;
        actionViewArr[0] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_right1);
        this.rightActionViews[1] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_right2);
        this.rightActionViews[2] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_right3);
        this.rightActionViews[3] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_right4);
        this.rightActionViews[4] = (ActionView) this.titleBarChild.findViewById(R.id.actionbarex_common_av_right5);
        int i5 = 0;
        while (true) {
            ActionView[] actionViewArr2 = this.rightActionViews;
            if (i5 >= actionViewArr2.length) {
                return;
            }
            setTextStyle(actionViewArr2[i5].getTextView(), this.rightTextStyles[i5]);
            ActionView actionView = this.rightActionViews[i5];
            int[] iArr2 = this.rightTextPaddings[i5];
            actionView.setTextPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            ActionView actionView2 = this.rightActionViews[i5];
            int[] iArr3 = this.rightTextMargins[i5];
            actionView2.setTextMargin(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
            this.rightActionViews[i5].setTextColor(this.rightTextColors[i5]);
            this.rightActionViews[i5].setTextSizePx(this.rightTextSizes[i5]);
            ActionView actionView3 = this.rightActionViews[i5];
            int[] iArr4 = this.rightIconPaddings[i5];
            actionView3.setIconPadding(iArr4[0], iArr4[1], iArr4[2], iArr4[3]);
            ActionView actionView4 = this.rightActionViews[i5];
            int[] iArr5 = this.rightIconMargins[i5];
            actionView4.setIconMargin(iArr5[0], iArr5[1], iArr5[2], iArr5[3]);
            this.rightActionViews[i5].setIconColorInt(this.rightIconColors[i5]);
            int i6 = this.rightIcons[i5];
            if (i6 > 0) {
                this.rightActionViews[i5].setIcon(i6);
            } else if (TextUtils.isEmpty(this.rightTexts[i5])) {
                this.rightActionViews[i5].toggleToGone();
            } else {
                this.rightActionViews[i5].setText(this.rightTexts[i5]);
            }
            if (this.rightTextClickToFinish[i5]) {
                this.rightActionViews[i5].getTextView().setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSuper.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSuper.this.finishActivity();
                    }
                });
            }
            if (this.rightIconClickToFinish[i5]) {
                this.rightActionViews[i5].getIconView().setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSuper.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSuper.this.finishActivity();
                    }
                });
            }
            i5++;
        }
    }

    private void setTextStyle(TextView textView, int i5) {
        if (i5 == 1) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        } else if (i5 == 0) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        } else {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public ActionView getLeftActionView(int i5) {
        if (i5 < 0) {
            return null;
        }
        ActionView[] actionViewArr = this.leftActionViews;
        if (i5 >= actionViewArr.length) {
            return null;
        }
        return actionViewArr[i5];
    }

    public ActionView[] getLeftActionViews() {
        return this.leftActionViews;
    }

    public ActionView getRightActionView(int i5) {
        if (i5 < 0) {
            return null;
        }
        ActionView[] actionViewArr = this.rightActionViews;
        if (i5 >= actionViewArr.length) {
            return null;
        }
        return actionViewArr[i5];
    }

    public ActionView[] getRightActionViews() {
        return this.rightActionViews;
    }

    public TextView getSubtitleTextView() {
        return this.subtitleTextView;
    }

    public TextView getTitleTextView() {
        return this.titleTextView;
    }

    @Override // com.zlylib.titlebarlib.widget.ActionBarEx
    public View inflateTitleBar() {
        this.titleBarChild = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.actionbarex_common_action_bar_title_bar_super, (ViewGroup) getTitleBar(), false);
        initTitleTextView();
        initLeftActionViews();
        initRightActionViews();
        return this.titleBarChild;
    }

    @Override // com.zlylib.titlebarlib.widget.ActionBarEx
    public void initAttrs(AttributeSet attributeSet) {
        char c;
        float f6;
        char c6;
        float f7;
        char c7;
        float f8;
        char c8;
        float f9;
        char c9;
        float f10;
        char c10;
        float f11;
        char c11;
        float f12;
        char c12;
        float f13;
        char c13;
        float f14;
        char c14;
        float f15;
        char c15;
        float f16;
        char c16;
        float f17;
        char c17;
        float f18;
        char c18;
        float f19;
        char c19;
        float f20;
        char c20;
        float f21;
        char c21;
        float f22;
        char c22;
        float f23;
        char c23;
        float f24;
        char c24;
        float f25;
        char c25;
        float f26;
        char c26;
        float f27;
        char c27;
        float f28;
        char c28;
        float f29;
        char c29;
        float f30;
        char c30;
        float f31;
        char c31;
        float f32;
        char c32;
        float f33;
        char c33;
        float f34;
        char c34;
        float f35;
        char c35;
        float f36;
        char c36;
        float f37;
        char c37;
        float f38;
        char c38;
        float f39;
        char c39;
        float f40;
        char c40;
        float f41;
        char c41;
        float f42;
        char c42;
        float f43;
        char c43;
        float f44;
        char c44;
        float f45;
        char c45;
        float f46;
        char c46;
        float f47;
        char c47;
        float f48;
        char c48;
        float f49;
        char c49;
        float f50;
        char c50;
        float f51;
        char c51;
        float f52;
        char c52;
        float f53;
        char c53;
        float f54;
        char c54;
        float f55;
        char c55;
        float f56;
        char c56;
        float f57;
        char c57;
        float f58;
        char c58;
        float f59;
        char c59;
        float f60;
        char c60;
        float f61;
        char c61;
        float f62;
        char c62;
        float f63;
        char c63;
        float f64;
        char c64;
        float f65;
        char c65;
        float f66;
        char c66;
        float f67;
        char c67;
        float f68;
        char c68;
        float f69;
        char c69;
        float f70;
        char c70;
        float f71;
        char c71;
        float f72;
        char c72;
        float f73;
        char c73;
        float f74;
        char c74;
        float f75;
        char c75;
        float f76;
        char c76;
        float f77;
        char c77;
        float f78;
        char c78;
        float f79;
        char c79;
        float f80;
        char c80;
        float f81;
        char c81;
        float f82;
        char c82;
        float f83;
        char c83;
        float f84;
        char c84;
        float f85;
        super.initAttrs(attributeSet);
        float dimension = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_title_text_size_def);
        float dimension2 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_subtitle_text_size_def);
        int color = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_title_text_color_def);
        int color2 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_subtitle_text_color_def);
        float dimension3 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_title_text_max_width_def);
        float dimension4 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_subtitle_text_max_width_def);
        int color3 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_text_color_def);
        float dimension5 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_size_def);
        float dimension6 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_left_def);
        float dimension7 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_right_def);
        int color4 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_icon_color_def);
        float dimension8 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_icon_padding_def);
        this.titlePadding = new int[4];
        this.titleMargin = new int[4];
        this.subtitlePadding = new int[4];
        this.subtitleMargin = new int[4];
        this.textPadding = new int[4];
        this.textMargin = new int[4];
        this.iconPadding = new int[4];
        this.iconMargin = new int[4];
        this.leftPadding = new int[4];
        this.leftTextPadding = new int[4];
        this.leftTextMargin = new int[4];
        this.leftIconPadding = new int[4];
        this.leftIconMargin = new int[4];
        this.leftTextStyles = new int[5];
        this.leftTextClickToFinish = new boolean[5];
        this.leftIconClickToFinish = new boolean[5];
        this.leftTexts = new String[5];
        this.leftTextColors = new int[5];
        this.leftTextSizes = new float[5];
        Class cls = Integer.TYPE;
        this.leftTextPaddings = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.leftTextMargins = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.leftIcons = new int[5];
        this.leftIconColors = new int[5];
        this.leftIconPaddings = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.leftIconMargins = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.rightPadding = new int[4];
        this.rightTextPadding = new int[4];
        this.rightTextMargin = new int[4];
        this.rightIconPadding = new int[4];
        this.rightIconMargin = new int[4];
        this.rightTextStyles = new int[5];
        this.rightTextClickToFinish = new boolean[5];
        this.rightIconClickToFinish = new boolean[5];
        this.rightTexts = new String[5];
        this.rightTextColors = new int[5];
        this.rightTextSizes = new float[5];
        this.rightTextPaddings = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.rightTextMargins = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.rightIcons = new int[5];
        this.rightIconColors = new int[5];
        this.rightIconPaddings = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        this.rightIconMargins = (int[][]) Array.newInstance((Class<?>) cls, 5, 4);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ActionBarSuper);
        this.titleGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_titleGravity, 0);
        this.titleTextStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_titleTextStyle, 0);
        this.titleText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_titleText);
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleTextSize, dimension);
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_titleTextColor, color);
        this.titleTextMaxWidth = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleTextMaxWidth, dimension3);
        int dimension9 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titlePadding, -1.0f);
        this.titlePadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titlePaddingLeft, dimension9 >= 0 ? dimension9 : 0.0f);
        this.titlePadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titlePaddingTop, dimension9 >= 0 ? dimension9 : 0.0f);
        this.titlePadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titlePaddingRight, dimension9 >= 0 ? dimension9 : 0.0f);
        this.titlePadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titlePaddingBottom, dimension9 >= 0 ? dimension9 : 0.0f);
        int dimension10 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleMargin, -1.0f);
        this.titleMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleMarginLeft, dimension10 >= 0 ? dimension10 : 0.0f);
        this.titleMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleMarginTop, dimension10 >= 0 ? dimension10 : 0.0f);
        this.titleMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleMarginRight, dimension10 >= 0 ? dimension10 : 0.0f);
        this.titleMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_titleMarginBottom, dimension10 >= 0 ? dimension10 : 0.0f);
        this.subtitleTextStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_subtitleTextStyle, 0);
        this.subtitleText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_subtitleText);
        this.subtitleTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleTextSize, dimension2);
        this.subtitleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_subtitleTextColor, color2);
        this.subtitleTextMaxWidth = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleTextMaxWidth, dimension4);
        int dimension11 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitlePadding, -1.0f);
        this.subtitlePadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitlePaddingLeft, dimension11 >= 0 ? dimension11 : 0.0f);
        this.subtitlePadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitlePaddingTop, dimension11 >= 0 ? dimension11 : 0.0f);
        this.subtitlePadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitlePaddingRight, dimension11 >= 0 ? dimension11 : 0.0f);
        this.subtitlePadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitlePaddingBottom, dimension11 >= 0 ? dimension11 : 0.0f);
        int dimension12 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleMargin, -1.0f);
        this.subtitleMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleMarginLeft, dimension12 >= 0 ? dimension12 : 0.0f);
        this.subtitleMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleMarginTop, dimension12 >= 0 ? dimension12 : 0.0f);
        this.subtitleMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleMarginRight, dimension12 >= 0 ? dimension12 : 0.0f);
        this.subtitleMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_subtitleMarginBottom, dimension12 >= 0 ? dimension12 : 0.0f);
        this.textStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_textStyle, 0);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_textColor, color3);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textSize, dimension5);
        int dimension13 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textPadding, -1.0f);
        int[] iArr = this.textPadding;
        int i5 = R.styleable.ActionBarSuper_absuper_textPaddingLeft;
        if (dimension13 >= 0) {
            dimension6 = dimension13;
        }
        iArr[0] = (int) typedArrayObtainStyledAttributes.getDimension(i5, dimension6);
        this.textPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textPaddingTop, dimension13 >= 0 ? dimension13 : 0.0f);
        int[] iArr2 = this.textPadding;
        int i6 = R.styleable.ActionBarSuper_absuper_textPaddingRight;
        if (dimension13 >= 0) {
            dimension7 = dimension13;
        }
        iArr2[2] = (int) typedArrayObtainStyledAttributes.getDimension(i6, dimension7);
        this.textPadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textPaddingBottom, dimension13 >= 0 ? dimension13 : 0.0f);
        int i7 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension14 = (int) typedArrayObtainStyledAttributes.getDimension(i7, -1.0f);
        this.textMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textMarginLeft, dimension14 >= 0 ? dimension14 : 0.0f);
        this.textMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textMarginTop, dimension14 >= 0 ? dimension14 : 0.0f);
        this.textMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textMarginRight, dimension14 >= 0 ? dimension14 : 0.0f);
        this.textMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_textMarginBottom, dimension14 >= 0 ? dimension14 : 0.0f);
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_iconColor, color4);
        int dimension15 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconPadding, -1.0f);
        this.iconPadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconPaddingLeft, dimension15 >= 0 ? dimension15 : dimension8);
        this.iconPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconPaddingTop, dimension15 >= 0 ? dimension15 : dimension8);
        this.iconPadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconPaddingRight, dimension15 >= 0 ? dimension15 : dimension8);
        int[] iArr3 = this.iconPadding;
        int i8 = R.styleable.ActionBarSuper_absuper_iconPaddingBottom;
        if (dimension15 >= 0) {
            dimension8 = dimension15;
        }
        iArr3[3] = (int) typedArrayObtainStyledAttributes.getDimension(i8, dimension8);
        int dimension16 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconMargin, -1.0f);
        this.iconMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconMarginLeft, dimension16 >= 0 ? dimension16 : 0.0f);
        this.iconMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconMarginTop, dimension16 >= 0 ? dimension16 : 0.0f);
        this.iconMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconMarginRight, dimension16 >= 0 ? dimension16 : 0.0f);
        this.iconMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_iconMarginBottom, dimension16 >= 0 ? dimension16 : 0.0f);
        int dimension17 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftPadding, -1.0f);
        this.leftPadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftPaddingLeft, dimension17 >= 0 ? dimension17 : 0.0f);
        this.leftPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftPaddingTop, dimension17 >= 0 ? dimension17 : 0.0f);
        this.leftPadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftPaddingRight, dimension17 >= 0 ? dimension17 : 0.0f);
        this.leftPadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftPaddingBottom, dimension17 >= 0 ? dimension17 : 0.0f);
        this.leftTextStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_leftTextStyle, this.textStyle);
        this.leftTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_leftTextColor, this.textColor);
        this.leftTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftTextSize, this.textSize);
        int dimension18 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftTextPadding, -1.0f);
        int[] iArr4 = this.leftTextPadding;
        int i9 = R.styleable.ActionBarSuper_absuper_leftTextPaddingLeft;
        if (dimension18 >= 0) {
            f6 = dimension18;
            c = 0;
        } else {
            c = 0;
            f6 = this.textPadding[0];
        }
        iArr4[c] = (int) typedArrayObtainStyledAttributes.getDimension(i9, f6);
        this.leftTextPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftTextPaddingTop, dimension18 >= 0 ? dimension18 : this.textPadding[1]);
        int[] iArr5 = this.leftTextPadding;
        int i10 = R.styleable.ActionBarSuper_absuper_leftTextPaddingRight;
        if (dimension18 >= 0) {
            f7 = dimension18;
            c6 = 2;
        } else {
            c6 = 2;
            f7 = this.textPadding[2];
        }
        iArr5[c6] = (int) typedArrayObtainStyledAttributes.getDimension(i10, f7);
        int[] iArr6 = this.leftTextPadding;
        int i11 = R.styleable.ActionBarSuper_absuper_leftTextPaddingBottom;
        if (dimension18 < 0) {
            dimension18 = this.textPadding[3];
        }
        iArr6[3] = (int) typedArrayObtainStyledAttributes.getDimension(i11, dimension18);
        int dimension19 = (int) typedArrayObtainStyledAttributes.getDimension(i7, -1.0f);
        int[] iArr7 = this.leftTextMargin;
        int i12 = R.styleable.ActionBarSuper_absuper_leftTextMarginLeft;
        if (dimension19 >= 0) {
            f8 = dimension19;
            c7 = 0;
        } else {
            c7 = 0;
            f8 = this.textMargin[0];
        }
        iArr7[c7] = (int) typedArrayObtainStyledAttributes.getDimension(i12, f8);
        this.leftTextMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftTextMarginTop, dimension19 >= 0 ? dimension19 : this.textMargin[1]);
        int[] iArr8 = this.leftTextMargin;
        int i13 = R.styleable.ActionBarSuper_absuper_leftTextMarginRight;
        if (dimension19 >= 0) {
            f9 = dimension19;
            c8 = 2;
        } else {
            c8 = 2;
            f9 = this.textMargin[2];
        }
        iArr8[c8] = (int) typedArrayObtainStyledAttributes.getDimension(i13, f9);
        int[] iArr9 = this.leftTextMargin;
        int i14 = R.styleable.ActionBarSuper_absuper_leftTextMarginBottom;
        if (dimension19 < 0) {
            dimension19 = this.textMargin[3];
        }
        iArr9[3] = (int) typedArrayObtainStyledAttributes.getDimension(i14, dimension19);
        this.leftIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_leftIconColor, this.iconColor);
        int dimension20 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftIconPadding, -1.0f);
        int[] iArr10 = this.leftIconPadding;
        int i15 = R.styleable.ActionBarSuper_absuper_leftIconPaddingLeft;
        if (dimension20 >= 0) {
            f10 = dimension20;
            c9 = 0;
        } else {
            c9 = 0;
            f10 = this.iconPadding[0];
        }
        iArr10[c9] = (int) typedArrayObtainStyledAttributes.getDimension(i15, f10);
        this.leftIconPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftIconPaddingTop, dimension20 >= 0 ? dimension20 : this.iconPadding[1]);
        int[] iArr11 = this.leftIconPadding;
        int i16 = R.styleable.ActionBarSuper_absuper_leftIconPaddingRight;
        if (dimension20 >= 0) {
            f11 = dimension20;
            c10 = 2;
        } else {
            c10 = 2;
            f11 = this.iconPadding[2];
        }
        iArr11[c10] = (int) typedArrayObtainStyledAttributes.getDimension(i16, f11);
        int[] iArr12 = this.leftIconPadding;
        int i17 = R.styleable.ActionBarSuper_absuper_leftIconPaddingBottom;
        if (dimension20 < 0) {
            dimension20 = this.iconPadding[3];
        }
        iArr12[3] = (int) typedArrayObtainStyledAttributes.getDimension(i17, dimension20);
        int dimension21 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftIconMargin, -1.0f);
        int[] iArr13 = this.leftIconMargin;
        int i18 = R.styleable.ActionBarSuper_absuper_leftIconMarginLeft;
        if (dimension21 >= 0) {
            f12 = dimension21;
            c11 = 0;
        } else {
            c11 = 0;
            f12 = this.iconMargin[0];
        }
        iArr13[c11] = (int) typedArrayObtainStyledAttributes.getDimension(i18, f12);
        this.leftIconMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_leftIconMarginTop, dimension21 >= 0 ? dimension21 : this.iconMargin[1]);
        int[] iArr14 = this.leftIconMargin;
        int i19 = R.styleable.ActionBarSuper_absuper_leftIconMarginRight;
        if (dimension21 >= 0) {
            f13 = dimension21;
            c12 = 2;
        } else {
            c12 = 2;
            f13 = this.iconMargin[2];
        }
        iArr14[c12] = (int) typedArrayObtainStyledAttributes.getDimension(i19, f13);
        int[] iArr15 = this.leftIconMargin;
        int i20 = R.styleable.ActionBarSuper_absuper_leftIconMarginBottom;
        if (dimension21 < 0) {
            dimension21 = this.iconMargin[3];
        }
        iArr15[3] = (int) typedArrayObtainStyledAttributes.getDimension(i20, dimension21);
        this.leftTextStyles[0] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_left1TextStyle, this.leftTextStyle);
        this.leftTextClickToFinish[0] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left1TextClickToFinish, false);
        this.leftIconClickToFinish[0] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left1IconClickToFinish, false);
        this.leftTexts[0] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_left1Text);
        this.leftTextColors[0] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left1TextColor, this.leftTextColor);
        this.leftTextSizes[0] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextSize, this.leftTextSize);
        int dimension22 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextPadding, -1.0f);
        this.leftTextPaddings[0][0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextPaddingLeft, dimension22 >= 0 ? dimension22 : this.leftTextPadding[0]);
        this.leftTextPaddings[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextPaddingTop, dimension22 >= 0 ? dimension22 : this.leftTextPadding[1]);
        int[] iArr16 = this.leftTextPaddings[0];
        int i21 = R.styleable.ActionBarSuper_absuper_left1TextPaddingRight;
        if (dimension22 >= 0) {
            f14 = dimension22;
            c13 = 2;
        } else {
            c13 = 2;
            f14 = this.leftTextPadding[2];
        }
        iArr16[c13] = (int) typedArrayObtainStyledAttributes.getDimension(i21, f14);
        int[] iArr17 = this.leftTextPaddings[0];
        int i22 = R.styleable.ActionBarSuper_absuper_left1TextPaddingBottom;
        if (dimension22 < 0) {
            dimension22 = this.leftTextPadding[3];
        }
        iArr17[3] = (int) typedArrayObtainStyledAttributes.getDimension(i22, dimension22);
        int i23 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension23 = (int) typedArrayObtainStyledAttributes.getDimension(i23, -1.0f);
        this.leftTextMargins[0][0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextMarginLeft, dimension23 >= 0 ? dimension23 : this.leftTextMargin[0]);
        this.leftTextMargins[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1TextMarginTop, dimension23 >= 0 ? dimension23 : this.leftTextMargin[1]);
        int[] iArr18 = this.leftTextMargins[0];
        int i24 = R.styleable.ActionBarSuper_absuper_left1TextMarginRight;
        if (dimension23 >= 0) {
            f15 = dimension23;
            c14 = 2;
        } else {
            c14 = 2;
            f15 = this.leftTextMargin[2];
        }
        iArr18[c14] = (int) typedArrayObtainStyledAttributes.getDimension(i24, f15);
        int[] iArr19 = this.leftTextMargins[0];
        int i25 = R.styleable.ActionBarSuper_absuper_left1TextMarginBottom;
        if (dimension23 < 0) {
            dimension23 = this.leftTextMargin[3];
        }
        iArr19[3] = (int) typedArrayObtainStyledAttributes.getDimension(i25, dimension23);
        this.leftIcons[0] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_left1Icon, 0);
        this.leftIconColors[0] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left1IconColor, this.leftIconColor);
        int dimension24 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconPadding, -1.0f);
        this.leftIconPaddings[0][0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconPaddingLeft, dimension24 >= 0 ? dimension24 : this.leftIconPadding[0]);
        this.leftIconPaddings[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconPaddingTop, dimension24 >= 0 ? dimension24 : this.leftIconPadding[1]);
        int[] iArr20 = this.leftIconPaddings[0];
        int i26 = R.styleable.ActionBarSuper_absuper_left1IconPaddingRight;
        if (dimension24 >= 0) {
            f16 = dimension24;
            c15 = 2;
        } else {
            c15 = 2;
            f16 = this.leftIconPadding[2];
        }
        iArr20[c15] = (int) typedArrayObtainStyledAttributes.getDimension(i26, f16);
        int[] iArr21 = this.leftIconPaddings[0];
        int i27 = R.styleable.ActionBarSuper_absuper_left1IconPaddingBottom;
        if (dimension24 < 0) {
            dimension24 = this.leftIconPadding[3];
        }
        iArr21[3] = (int) typedArrayObtainStyledAttributes.getDimension(i27, dimension24);
        int dimension25 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconMargin, -1.0f);
        this.leftIconMargins[0][0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconMarginLeft, dimension25 >= 0 ? dimension25 : this.leftIconMargin[0]);
        this.leftIconMargins[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left1IconMarginTop, dimension25 >= 0 ? dimension25 : this.leftIconMargin[1]);
        int[] iArr22 = this.leftIconMargins[0];
        int i28 = R.styleable.ActionBarSuper_absuper_left1IconMarginRight;
        if (dimension25 >= 0) {
            f17 = dimension25;
            c16 = 2;
        } else {
            c16 = 2;
            f17 = this.leftIconMargin[2];
        }
        iArr22[c16] = (int) typedArrayObtainStyledAttributes.getDimension(i28, f17);
        int[] iArr23 = this.leftIconMargins[0];
        int i29 = R.styleable.ActionBarSuper_absuper_left1IconMarginBottom;
        if (dimension25 < 0) {
            dimension25 = this.leftIconMargin[3];
        }
        iArr23[3] = (int) typedArrayObtainStyledAttributes.getDimension(i29, dimension25);
        this.leftTextStyles[1] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_left2TextStyle, this.leftTextStyle);
        this.leftTextClickToFinish[1] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left2TextClickToFinish, false);
        this.leftIconClickToFinish[1] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left2IconClickToFinish, false);
        this.leftTexts[1] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_left2Text);
        this.leftTextColors[1] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left2TextColor, this.leftTextColor);
        this.leftTextSizes[1] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2TextSize, this.leftTextSize);
        int dimension26 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2TextPadding, -1.0f);
        int[] iArr24 = this.leftTextPaddings[1];
        int i30 = R.styleable.ActionBarSuper_absuper_left2TextPaddingLeft;
        if (dimension26 >= 0) {
            f18 = dimension26;
            c17 = 0;
        } else {
            c17 = 0;
            f18 = this.leftTextPadding[0];
        }
        iArr24[c17] = (int) typedArrayObtainStyledAttributes.getDimension(i30, f18);
        this.leftTextPaddings[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2TextPaddingTop, dimension26 >= 0 ? dimension26 : this.leftTextPadding[1]);
        int[] iArr25 = this.leftTextPaddings[1];
        int i31 = R.styleable.ActionBarSuper_absuper_left2TextPaddingRight;
        if (dimension26 >= 0) {
            f19 = dimension26;
            c18 = 2;
        } else {
            c18 = 2;
            f19 = this.leftTextPadding[2];
        }
        iArr25[c18] = (int) typedArrayObtainStyledAttributes.getDimension(i31, f19);
        int[] iArr26 = this.leftTextPaddings[1];
        int i32 = R.styleable.ActionBarSuper_absuper_left2TextPaddingBottom;
        if (dimension26 < 0) {
            dimension26 = this.leftTextPadding[3];
        }
        iArr26[3] = (int) typedArrayObtainStyledAttributes.getDimension(i32, dimension26);
        int dimension27 = (int) typedArrayObtainStyledAttributes.getDimension(i23, -1.0f);
        int[] iArr27 = this.leftTextMargins[1];
        int i33 = R.styleable.ActionBarSuper_absuper_left2TextMarginLeft;
        if (dimension27 >= 0) {
            f20 = dimension27;
            c19 = 0;
        } else {
            c19 = 0;
            f20 = this.leftTextMargin[0];
        }
        iArr27[c19] = (int) typedArrayObtainStyledAttributes.getDimension(i33, f20);
        this.leftTextMargins[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2TextMarginTop, dimension27 >= 0 ? dimension27 : this.leftTextMargin[1]);
        int[] iArr28 = this.leftTextMargins[1];
        int i34 = R.styleable.ActionBarSuper_absuper_left2TextMarginRight;
        if (dimension27 >= 0) {
            f21 = dimension27;
            c20 = 2;
        } else {
            c20 = 2;
            f21 = this.leftTextMargin[2];
        }
        iArr28[c20] = (int) typedArrayObtainStyledAttributes.getDimension(i34, f21);
        int[] iArr29 = this.leftTextMargins[1];
        int i35 = R.styleable.ActionBarSuper_absuper_left2TextMarginBottom;
        if (dimension27 < 0) {
            dimension27 = this.leftTextMargin[3];
        }
        iArr29[3] = (int) typedArrayObtainStyledAttributes.getDimension(i35, dimension27);
        this.leftIcons[1] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_left2Icon, 0);
        this.leftIconColors[1] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left2IconColor, this.leftIconColor);
        int dimension28 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2IconPadding, -1.0f);
        int[] iArr30 = this.leftIconPaddings[1];
        int i36 = R.styleable.ActionBarSuper_absuper_left2IconPaddingLeft;
        if (dimension28 >= 0) {
            f22 = dimension28;
            c21 = 0;
        } else {
            c21 = 0;
            f22 = this.leftIconPadding[0];
        }
        iArr30[c21] = (int) typedArrayObtainStyledAttributes.getDimension(i36, f22);
        this.leftIconPaddings[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2IconPaddingTop, dimension28 >= 0 ? dimension28 : this.leftIconPadding[1]);
        int[] iArr31 = this.leftIconPaddings[1];
        int i37 = R.styleable.ActionBarSuper_absuper_left2IconPaddingRight;
        if (dimension28 >= 0) {
            f23 = dimension28;
            c22 = 2;
        } else {
            c22 = 2;
            f23 = this.leftIconPadding[2];
        }
        iArr31[c22] = (int) typedArrayObtainStyledAttributes.getDimension(i37, f23);
        int[] iArr32 = this.leftIconPaddings[1];
        int i38 = R.styleable.ActionBarSuper_absuper_left2IconPaddingBottom;
        if (dimension28 < 0) {
            dimension28 = this.leftIconPadding[3];
        }
        iArr32[3] = (int) typedArrayObtainStyledAttributes.getDimension(i38, dimension28);
        int dimension29 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2IconMargin, -1.0f);
        int[] iArr33 = this.leftIconMargins[1];
        int i39 = R.styleable.ActionBarSuper_absuper_left2IconMarginLeft;
        if (dimension29 >= 0) {
            f24 = dimension29;
            c23 = 0;
        } else {
            c23 = 0;
            f24 = this.leftIconMargin[0];
        }
        iArr33[c23] = (int) typedArrayObtainStyledAttributes.getDimension(i39, f24);
        this.leftIconMargins[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left2IconMarginTop, dimension29 >= 0 ? dimension29 : this.leftIconMargin[1]);
        int[] iArr34 = this.leftIconMargins[1];
        int i40 = R.styleable.ActionBarSuper_absuper_left2IconMarginRight;
        if (dimension29 >= 0) {
            f25 = dimension29;
            c24 = 2;
        } else {
            c24 = 2;
            f25 = this.leftIconMargin[2];
        }
        iArr34[c24] = (int) typedArrayObtainStyledAttributes.getDimension(i40, f25);
        int[] iArr35 = this.leftIconMargins[1];
        int i41 = R.styleable.ActionBarSuper_absuper_left2IconMarginBottom;
        if (dimension29 < 0) {
            dimension29 = this.leftIconMargin[3];
        }
        iArr35[3] = (int) typedArrayObtainStyledAttributes.getDimension(i41, dimension29);
        this.leftTextStyles[2] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_left3TextStyle, this.leftTextStyle);
        this.leftTextClickToFinish[2] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left3TextClickToFinish, false);
        this.leftIconClickToFinish[2] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left3IconClickToFinish, false);
        this.leftTexts[2] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_left3Text);
        this.leftTextColors[2] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left3TextColor, this.leftTextColor);
        this.leftTextSizes[2] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextSize, this.leftTextSize);
        int dimension30 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextPadding, -1.0f);
        int[] iArr36 = this.leftTextPaddings[2];
        int i42 = R.styleable.ActionBarSuper_absuper_left3TextPaddingLeft;
        if (dimension30 >= 0) {
            f26 = dimension30;
            c25 = 0;
        } else {
            c25 = 0;
            f26 = this.leftTextPadding[0];
        }
        iArr36[c25] = (int) typedArrayObtainStyledAttributes.getDimension(i42, f26);
        this.leftTextPaddings[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextPaddingTop, dimension30 >= 0 ? dimension30 : this.leftTextPadding[1]);
        this.leftTextPaddings[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextPaddingRight, dimension30 >= 0 ? dimension30 : this.leftTextPadding[2]);
        int[] iArr37 = this.leftTextPaddings[2];
        int i43 = R.styleable.ActionBarSuper_absuper_left3TextPaddingBottom;
        if (dimension30 < 0) {
            dimension30 = this.leftTextPadding[3];
        }
        iArr37[3] = (int) typedArrayObtainStyledAttributes.getDimension(i43, dimension30);
        int i44 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension31 = (int) typedArrayObtainStyledAttributes.getDimension(i44, -1.0f);
        int[] iArr38 = this.leftTextMargins[2];
        int i45 = R.styleable.ActionBarSuper_absuper_left3TextMarginLeft;
        if (dimension31 >= 0) {
            f27 = dimension31;
            c26 = 0;
        } else {
            c26 = 0;
            f27 = this.leftTextMargin[0];
        }
        iArr38[c26] = (int) typedArrayObtainStyledAttributes.getDimension(i45, f27);
        this.leftTextMargins[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextMarginTop, dimension31 >= 0 ? dimension31 : this.leftTextMargin[1]);
        this.leftTextMargins[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3TextMarginRight, dimension31 >= 0 ? dimension31 : this.leftTextMargin[2]);
        int[] iArr39 = this.leftTextMargins[2];
        int i46 = R.styleable.ActionBarSuper_absuper_left3TextMarginBottom;
        if (dimension31 < 0) {
            dimension31 = this.leftTextMargin[3];
        }
        iArr39[3] = (int) typedArrayObtainStyledAttributes.getDimension(i46, dimension31);
        this.leftIcons[2] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_left3Icon, 0);
        this.leftIconColors[2] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left3IconColor, this.leftIconColor);
        int dimension32 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconPadding, -1.0f);
        int[] iArr40 = this.leftIconPaddings[2];
        int i47 = R.styleable.ActionBarSuper_absuper_left3IconPaddingLeft;
        if (dimension32 >= 0) {
            f28 = dimension32;
            c27 = 0;
        } else {
            c27 = 0;
            f28 = this.leftIconPadding[0];
        }
        iArr40[c27] = (int) typedArrayObtainStyledAttributes.getDimension(i47, f28);
        this.leftIconPaddings[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconPaddingTop, dimension32 >= 0 ? dimension32 : this.leftIconPadding[1]);
        this.leftIconPaddings[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconPaddingRight, dimension32 >= 0 ? dimension32 : this.leftIconPadding[2]);
        int[] iArr41 = this.leftIconPaddings[2];
        int i48 = R.styleable.ActionBarSuper_absuper_left3IconPaddingBottom;
        if (dimension32 < 0) {
            dimension32 = this.leftIconPadding[3];
        }
        iArr41[3] = (int) typedArrayObtainStyledAttributes.getDimension(i48, dimension32);
        int dimension33 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconMargin, -1.0f);
        int[] iArr42 = this.leftIconMargins[2];
        int i49 = R.styleable.ActionBarSuper_absuper_left3IconMarginLeft;
        if (dimension33 >= 0) {
            f29 = dimension33;
            c28 = 0;
        } else {
            c28 = 0;
            f29 = this.leftIconMargin[0];
        }
        iArr42[c28] = (int) typedArrayObtainStyledAttributes.getDimension(i49, f29);
        this.leftIconMargins[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconMarginTop, dimension33 >= 0 ? dimension33 : this.leftIconMargin[1]);
        this.leftIconMargins[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left3IconMarginRight, dimension33 >= 0 ? dimension33 : this.leftIconMargin[2]);
        int[] iArr43 = this.leftIconMargins[2];
        int i50 = R.styleable.ActionBarSuper_absuper_left3IconMarginBottom;
        if (dimension33 < 0) {
            dimension33 = this.leftIconMargin[3];
        }
        iArr43[3] = (int) typedArrayObtainStyledAttributes.getDimension(i50, dimension33);
        this.leftTextStyles[3] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_left4TextStyle, this.leftTextStyle);
        this.leftTextClickToFinish[3] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left4TextClickToFinish, false);
        this.leftIconClickToFinish[3] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left4IconClickToFinish, false);
        this.leftTexts[3] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_left4Text);
        this.leftTextColors[3] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left4TextColor, this.leftTextColor);
        this.leftTextSizes[3] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4TextSize, this.leftTextSize);
        int dimension34 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4TextPadding, -1.0f);
        int[] iArr44 = this.leftTextPaddings[3];
        int i51 = R.styleable.ActionBarSuper_absuper_left4TextPaddingLeft;
        if (dimension34 >= 0) {
            f30 = dimension34;
            c29 = 0;
        } else {
            c29 = 0;
            f30 = this.leftTextPadding[0];
        }
        iArr44[c29] = (int) typedArrayObtainStyledAttributes.getDimension(i51, f30);
        this.leftTextPaddings[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4TextPaddingTop, dimension34 >= 0 ? dimension34 : this.leftTextPadding[1]);
        int[] iArr45 = this.leftTextPaddings[3];
        int i52 = R.styleable.ActionBarSuper_absuper_left4TextPaddingRight;
        if (dimension34 >= 0) {
            f31 = dimension34;
            c30 = 2;
        } else {
            c30 = 2;
            f31 = this.leftTextPadding[2];
        }
        iArr45[c30] = (int) typedArrayObtainStyledAttributes.getDimension(i52, f31);
        int[] iArr46 = this.leftTextPaddings[3];
        int i53 = R.styleable.ActionBarSuper_absuper_left4TextPaddingBottom;
        if (dimension34 < 0) {
            dimension34 = this.leftTextPadding[3];
        }
        iArr46[3] = (int) typedArrayObtainStyledAttributes.getDimension(i53, dimension34);
        int dimension35 = (int) typedArrayObtainStyledAttributes.getDimension(i44, -1.0f);
        int[] iArr47 = this.leftTextMargins[3];
        int i54 = R.styleable.ActionBarSuper_absuper_left4TextMarginLeft;
        if (dimension35 >= 0) {
            f32 = dimension35;
            c31 = 0;
        } else {
            c31 = 0;
            f32 = this.leftTextMargin[0];
        }
        iArr47[c31] = (int) typedArrayObtainStyledAttributes.getDimension(i54, f32);
        this.leftTextMargins[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4TextMarginTop, dimension35 >= 0 ? dimension35 : this.leftTextMargin[1]);
        int[] iArr48 = this.leftTextMargins[3];
        int i55 = R.styleable.ActionBarSuper_absuper_left4TextMarginRight;
        if (dimension35 >= 0) {
            f33 = dimension35;
            c32 = 2;
        } else {
            c32 = 2;
            f33 = this.leftTextMargin[2];
        }
        iArr48[c32] = (int) typedArrayObtainStyledAttributes.getDimension(i55, f33);
        int[] iArr49 = this.leftTextMargins[3];
        int i56 = R.styleable.ActionBarSuper_absuper_left4TextMarginBottom;
        if (dimension35 < 0) {
            dimension35 = this.leftTextMargin[3];
        }
        iArr49[3] = (int) typedArrayObtainStyledAttributes.getDimension(i56, dimension35);
        this.leftIcons[3] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_left4Icon, 0);
        this.leftIconColors[3] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left4IconColor, this.leftIconColor);
        int dimension36 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4IconPadding, -1.0f);
        int[] iArr50 = this.leftIconPaddings[3];
        int i57 = R.styleable.ActionBarSuper_absuper_left4IconPaddingLeft;
        if (dimension36 >= 0) {
            f34 = dimension36;
            c33 = 0;
        } else {
            c33 = 0;
            f34 = this.leftIconPadding[0];
        }
        iArr50[c33] = (int) typedArrayObtainStyledAttributes.getDimension(i57, f34);
        this.leftIconPaddings[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4IconPaddingTop, dimension36 >= 0 ? dimension36 : this.leftIconPadding[1]);
        int[] iArr51 = this.leftIconPaddings[3];
        int i58 = R.styleable.ActionBarSuper_absuper_left4IconPaddingRight;
        if (dimension36 >= 0) {
            f35 = dimension36;
            c34 = 2;
        } else {
            c34 = 2;
            f35 = this.leftIconPadding[2];
        }
        iArr51[c34] = (int) typedArrayObtainStyledAttributes.getDimension(i58, f35);
        int[] iArr52 = this.leftIconPaddings[3];
        int i59 = R.styleable.ActionBarSuper_absuper_left4IconPaddingBottom;
        if (dimension36 < 0) {
            dimension36 = this.leftIconPadding[3];
        }
        iArr52[3] = (int) typedArrayObtainStyledAttributes.getDimension(i59, dimension36);
        int dimension37 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4IconMargin, -1.0f);
        int[] iArr53 = this.leftIconMargins[3];
        int i60 = R.styleable.ActionBarSuper_absuper_left4IconMarginLeft;
        if (dimension37 >= 0) {
            f36 = dimension37;
            c35 = 0;
        } else {
            c35 = 0;
            f36 = this.leftIconMargin[0];
        }
        iArr53[c35] = (int) typedArrayObtainStyledAttributes.getDimension(i60, f36);
        this.leftIconMargins[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left4IconMarginTop, dimension37 >= 0 ? dimension37 : this.leftIconMargin[1]);
        int[] iArr54 = this.leftIconMargins[3];
        int i61 = R.styleable.ActionBarSuper_absuper_left4IconMarginRight;
        if (dimension37 >= 0) {
            f37 = dimension37;
            c36 = 2;
        } else {
            c36 = 2;
            f37 = this.leftIconMargin[2];
        }
        iArr54[c36] = (int) typedArrayObtainStyledAttributes.getDimension(i61, f37);
        int[] iArr55 = this.leftIconMargins[3];
        int i62 = R.styleable.ActionBarSuper_absuper_left4IconMarginBottom;
        if (dimension37 < 0) {
            dimension37 = this.leftIconMargin[3];
        }
        iArr55[3] = (int) typedArrayObtainStyledAttributes.getDimension(i62, dimension37);
        this.leftTextStyles[4] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_left5TextStyle, this.leftTextStyle);
        this.leftTextClickToFinish[4] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left5TextClickToFinish, false);
        this.leftIconClickToFinish[4] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_left5IconClickToFinish, false);
        this.leftTexts[4] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_left5Text);
        this.leftTextColors[4] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left5TextColor, this.leftTextColor);
        this.leftTextSizes[4] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5TextSize, this.leftTextSize);
        int dimension38 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5TextPadding, -1.0f);
        int[] iArr56 = this.leftTextPaddings[4];
        int i63 = R.styleable.ActionBarSuper_absuper_left5TextPaddingLeft;
        if (dimension38 >= 0) {
            f38 = dimension38;
            c37 = 0;
        } else {
            c37 = 0;
            f38 = this.leftTextPadding[0];
        }
        iArr56[c37] = (int) typedArrayObtainStyledAttributes.getDimension(i63, f38);
        this.leftTextPaddings[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5TextPaddingTop, dimension38 >= 0 ? dimension38 : this.leftTextPadding[1]);
        int[] iArr57 = this.leftTextPaddings[4];
        int i64 = R.styleable.ActionBarSuper_absuper_left5TextPaddingRight;
        if (dimension38 >= 0) {
            f39 = dimension38;
            c38 = 2;
        } else {
            c38 = 2;
            f39 = this.leftTextPadding[2];
        }
        iArr57[c38] = (int) typedArrayObtainStyledAttributes.getDimension(i64, f39);
        int[] iArr58 = this.leftTextPaddings[4];
        int i65 = R.styleable.ActionBarSuper_absuper_left5TextPaddingBottom;
        if (dimension38 < 0) {
            dimension38 = this.leftTextPadding[3];
        }
        iArr58[3] = (int) typedArrayObtainStyledAttributes.getDimension(i65, dimension38);
        int i66 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension39 = (int) typedArrayObtainStyledAttributes.getDimension(i66, -1.0f);
        int[] iArr59 = this.leftTextMargins[4];
        int i67 = R.styleable.ActionBarSuper_absuper_left5TextMarginLeft;
        if (dimension39 >= 0) {
            f40 = dimension39;
            c39 = 0;
        } else {
            c39 = 0;
            f40 = this.leftTextMargin[0];
        }
        iArr59[c39] = (int) typedArrayObtainStyledAttributes.getDimension(i67, f40);
        this.leftTextMargins[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5TextMarginTop, dimension39 >= 0 ? dimension39 : this.leftTextMargin[1]);
        int[] iArr60 = this.leftTextMargins[4];
        int i68 = R.styleable.ActionBarSuper_absuper_left5TextMarginRight;
        if (dimension39 >= 0) {
            f41 = dimension39;
            c40 = 2;
        } else {
            c40 = 2;
            f41 = this.leftTextMargin[2];
        }
        iArr60[c40] = (int) typedArrayObtainStyledAttributes.getDimension(i68, f41);
        int[] iArr61 = this.leftTextMargins[4];
        int i69 = R.styleable.ActionBarSuper_absuper_left5TextMarginBottom;
        if (dimension39 < 0) {
            dimension39 = this.leftTextMargin[3];
        }
        iArr61[3] = (int) typedArrayObtainStyledAttributes.getDimension(i69, dimension39);
        this.leftIcons[4] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_left5Icon, 0);
        this.leftIconColors[4] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_left5IconColor, this.leftIconColor);
        int dimension40 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5IconPadding, -1.0f);
        int[] iArr62 = this.leftIconPaddings[4];
        int i70 = R.styleable.ActionBarSuper_absuper_left5IconPaddingLeft;
        if (dimension40 >= 0) {
            f42 = dimension40;
            c41 = 0;
        } else {
            c41 = 0;
            f42 = this.leftIconPadding[0];
        }
        iArr62[c41] = (int) typedArrayObtainStyledAttributes.getDimension(i70, f42);
        this.leftIconPaddings[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5IconPaddingTop, dimension40 >= 0 ? dimension40 : this.leftIconPadding[1]);
        int[] iArr63 = this.leftIconPaddings[4];
        int i71 = R.styleable.ActionBarSuper_absuper_left5IconPaddingRight;
        if (dimension40 >= 0) {
            f43 = dimension40;
            c42 = 2;
        } else {
            c42 = 2;
            f43 = this.leftIconPadding[2];
        }
        iArr63[c42] = (int) typedArrayObtainStyledAttributes.getDimension(i71, f43);
        int[] iArr64 = this.leftIconPaddings[4];
        int i72 = R.styleable.ActionBarSuper_absuper_left5IconPaddingBottom;
        if (dimension40 < 0) {
            dimension40 = this.leftIconPadding[3];
        }
        iArr64[3] = (int) typedArrayObtainStyledAttributes.getDimension(i72, dimension40);
        int dimension41 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5IconMargin, -1.0f);
        int[] iArr65 = this.leftIconMargins[4];
        int i73 = R.styleable.ActionBarSuper_absuper_left5IconMarginLeft;
        if (dimension41 >= 0) {
            f44 = dimension41;
            c43 = 0;
        } else {
            c43 = 0;
            f44 = this.leftIconMargin[0];
        }
        iArr65[c43] = (int) typedArrayObtainStyledAttributes.getDimension(i73, f44);
        this.leftIconMargins[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_left5IconMarginTop, dimension41 >= 0 ? dimension41 : this.leftIconMargin[1]);
        int[] iArr66 = this.leftIconMargins[4];
        int i74 = R.styleable.ActionBarSuper_absuper_left5IconMarginRight;
        if (dimension41 >= 0) {
            f45 = dimension41;
            c44 = 2;
        } else {
            c44 = 2;
            f45 = this.leftIconMargin[2];
        }
        iArr66[c44] = (int) typedArrayObtainStyledAttributes.getDimension(i74, f45);
        int[] iArr67 = this.leftIconMargins[4];
        int i75 = R.styleable.ActionBarSuper_absuper_left5IconMarginBottom;
        if (dimension41 < 0) {
            dimension41 = this.leftIconMargin[3];
        }
        iArr67[3] = (int) typedArrayObtainStyledAttributes.getDimension(i75, dimension41);
        int dimension42 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightPadding, -1.0f);
        this.rightPadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightPaddingLeft, dimension42 >= 0 ? dimension42 : 0.0f);
        this.rightPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightPaddingTop, dimension42 >= 0 ? dimension42 : 0.0f);
        this.rightPadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightPaddingRight, dimension42 >= 0 ? dimension42 : 0.0f);
        this.rightPadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightPaddingBottom, dimension42 >= 0 ? dimension42 : 0.0f);
        this.rightTextStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_rightTextStyle, this.textStyle);
        this.rightTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_rightTextColor, this.textColor);
        this.rightTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightTextSize, this.textSize);
        int dimension43 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightTextPadding, -1.0f);
        int[] iArr68 = this.rightTextPadding;
        int i76 = R.styleable.ActionBarSuper_absuper_rightTextPaddingLeft;
        if (dimension43 >= 0) {
            f46 = dimension43;
            c45 = 0;
        } else {
            c45 = 0;
            f46 = this.textPadding[0];
        }
        iArr68[c45] = (int) typedArrayObtainStyledAttributes.getDimension(i76, f46);
        this.rightTextPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightTextPaddingTop, dimension43 >= 0 ? dimension43 : this.textPadding[1]);
        int[] iArr69 = this.rightTextPadding;
        int i77 = R.styleable.ActionBarSuper_absuper_rightTextPaddingRight;
        if (dimension43 >= 0) {
            f47 = dimension43;
            c46 = 2;
        } else {
            c46 = 2;
            f47 = this.textPadding[2];
        }
        iArr69[c46] = (int) typedArrayObtainStyledAttributes.getDimension(i77, f47);
        int[] iArr70 = this.rightTextPadding;
        int i78 = R.styleable.ActionBarSuper_absuper_rightTextPaddingBottom;
        if (dimension43 < 0) {
            dimension43 = this.textPadding[3];
        }
        iArr70[3] = (int) typedArrayObtainStyledAttributes.getDimension(i78, dimension43);
        int dimension44 = (int) typedArrayObtainStyledAttributes.getDimension(i66, -1.0f);
        int[] iArr71 = this.rightTextMargin;
        int i79 = R.styleable.ActionBarSuper_absuper_rightTextMarginLeft;
        if (dimension44 >= 0) {
            f48 = dimension44;
            c47 = 0;
        } else {
            c47 = 0;
            f48 = this.textMargin[0];
        }
        iArr71[c47] = (int) typedArrayObtainStyledAttributes.getDimension(i79, f48);
        this.rightTextMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightTextMarginTop, dimension44 >= 0 ? dimension44 : this.textMargin[1]);
        int[] iArr72 = this.rightTextMargin;
        int i80 = R.styleable.ActionBarSuper_absuper_rightTextMarginRight;
        if (dimension44 >= 0) {
            f49 = dimension44;
            c48 = 2;
        } else {
            c48 = 2;
            f49 = this.textMargin[2];
        }
        iArr72[c48] = (int) typedArrayObtainStyledAttributes.getDimension(i80, f49);
        int[] iArr73 = this.rightTextMargin;
        int i81 = R.styleable.ActionBarSuper_absuper_rightTextMarginBottom;
        if (dimension44 < 0) {
            dimension44 = this.textMargin[3];
        }
        iArr73[3] = (int) typedArrayObtainStyledAttributes.getDimension(i81, dimension44);
        this.rightIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_rightIconColor, this.iconColor);
        int dimension45 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightIconPadding, -1.0f);
        int[] iArr74 = this.rightIconPadding;
        int i82 = R.styleable.ActionBarSuper_absuper_rightIconPaddingLeft;
        if (dimension45 >= 0) {
            f50 = dimension45;
            c49 = 0;
        } else {
            c49 = 0;
            f50 = this.iconPadding[0];
        }
        iArr74[c49] = (int) typedArrayObtainStyledAttributes.getDimension(i82, f50);
        this.rightIconPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightIconPaddingTop, dimension45 >= 0 ? dimension45 : this.iconPadding[1]);
        int[] iArr75 = this.rightIconPadding;
        int i83 = R.styleable.ActionBarSuper_absuper_rightIconPaddingRight;
        if (dimension45 >= 0) {
            f51 = dimension45;
            c50 = 2;
        } else {
            c50 = 2;
            f51 = this.iconPadding[2];
        }
        iArr75[c50] = (int) typedArrayObtainStyledAttributes.getDimension(i83, f51);
        int[] iArr76 = this.rightIconPadding;
        int i84 = R.styleable.ActionBarSuper_absuper_rightIconPaddingBottom;
        if (dimension45 < 0) {
            dimension45 = this.iconPadding[3];
        }
        iArr76[3] = (int) typedArrayObtainStyledAttributes.getDimension(i84, dimension45);
        int dimension46 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightIconMargin, -1.0f);
        int[] iArr77 = this.rightIconMargin;
        int i85 = R.styleable.ActionBarSuper_absuper_rightIconMarginLeft;
        if (dimension46 >= 0) {
            f52 = dimension46;
            c51 = 0;
        } else {
            c51 = 0;
            f52 = this.iconMargin[0];
        }
        iArr77[c51] = (int) typedArrayObtainStyledAttributes.getDimension(i85, f52);
        this.rightIconMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_rightIconMarginTop, dimension46 >= 0 ? dimension46 : this.iconMargin[1]);
        int[] iArr78 = this.rightIconMargin;
        int i86 = R.styleable.ActionBarSuper_absuper_rightIconMarginRight;
        if (dimension46 >= 0) {
            f53 = dimension46;
            c52 = 2;
        } else {
            c52 = 2;
            f53 = this.iconMargin[2];
        }
        iArr78[c52] = (int) typedArrayObtainStyledAttributes.getDimension(i86, f53);
        int[] iArr79 = this.rightIconMargin;
        int i87 = R.styleable.ActionBarSuper_absuper_rightIconMarginBottom;
        if (dimension46 < 0) {
            dimension46 = this.iconMargin[3];
        }
        iArr79[3] = (int) typedArrayObtainStyledAttributes.getDimension(i87, dimension46);
        this.rightTextStyles[0] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_right1TextStyle, this.rightTextStyle);
        this.rightTextClickToFinish[0] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right1TextClickToFinish, false);
        this.rightIconClickToFinish[0] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right1IconClickToFinish, false);
        this.rightTexts[0] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_right1Text);
        this.rightTextColors[0] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right1TextColor, this.rightTextColor);
        this.rightTextSizes[0] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1TextSize, this.rightTextSize);
        int dimension47 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1TextPadding, -1.0f);
        int[] iArr80 = this.rightTextPaddings[0];
        int i88 = R.styleable.ActionBarSuper_absuper_right1TextPaddingRight;
        iArr80[0] = (int) typedArrayObtainStyledAttributes.getDimension(i88, dimension47 >= 0 ? dimension47 : this.rightTextPadding[0]);
        this.rightTextPaddings[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1TextPaddingTop, dimension47 >= 0 ? dimension47 : this.rightTextPadding[1]);
        int[] iArr81 = this.rightTextPaddings[0];
        if (dimension47 >= 0) {
            f54 = dimension47;
            c53 = 2;
        } else {
            c53 = 2;
            f54 = this.rightTextPadding[2];
        }
        iArr81[c53] = (int) typedArrayObtainStyledAttributes.getDimension(i88, f54);
        int[] iArr82 = this.rightTextPaddings[0];
        int i89 = R.styleable.ActionBarSuper_absuper_right1TextPaddingBottom;
        if (dimension47 < 0) {
            dimension47 = this.rightTextPadding[3];
        }
        iArr82[3] = (int) typedArrayObtainStyledAttributes.getDimension(i89, dimension47);
        int i90 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension48 = (int) typedArrayObtainStyledAttributes.getDimension(i90, -1.0f);
        int[] iArr83 = this.rightTextMargins[0];
        int i91 = R.styleable.ActionBarSuper_absuper_right1TextMarginRight;
        iArr83[0] = (int) typedArrayObtainStyledAttributes.getDimension(i91, dimension48 >= 0 ? dimension48 : this.rightTextMargin[0]);
        this.rightTextMargins[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1TextMarginTop, dimension48 >= 0 ? dimension48 : this.rightTextMargin[1]);
        int[] iArr84 = this.rightTextMargins[0];
        if (dimension48 >= 0) {
            f55 = dimension48;
            c54 = 2;
        } else {
            c54 = 2;
            f55 = this.rightTextMargin[2];
        }
        iArr84[c54] = (int) typedArrayObtainStyledAttributes.getDimension(i91, f55);
        int[] iArr85 = this.rightTextMargins[0];
        int i92 = R.styleable.ActionBarSuper_absuper_right1TextMarginBottom;
        if (dimension48 < 0) {
            dimension48 = this.rightTextMargin[3];
        }
        iArr85[3] = (int) typedArrayObtainStyledAttributes.getDimension(i92, dimension48);
        this.rightIcons[0] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_right1Icon, 0);
        this.rightIconColors[0] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right1IconColor, this.rightIconColor);
        int dimension49 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1IconPadding, -1.0f);
        int[] iArr86 = this.rightIconPaddings[0];
        int i93 = R.styleable.ActionBarSuper_absuper_right1IconPaddingRight;
        iArr86[0] = (int) typedArrayObtainStyledAttributes.getDimension(i93, dimension49 >= 0 ? dimension49 : this.rightIconPadding[0]);
        this.rightIconPaddings[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1IconPaddingTop, dimension49 >= 0 ? dimension49 : this.rightIconPadding[1]);
        int[] iArr87 = this.rightIconPaddings[0];
        if (dimension49 >= 0) {
            f56 = dimension49;
            c55 = 2;
        } else {
            c55 = 2;
            f56 = this.rightIconPadding[2];
        }
        iArr87[c55] = (int) typedArrayObtainStyledAttributes.getDimension(i93, f56);
        int[] iArr88 = this.rightIconPaddings[0];
        int i94 = R.styleable.ActionBarSuper_absuper_right1IconPaddingBottom;
        if (dimension49 < 0) {
            dimension49 = this.rightIconPadding[3];
        }
        iArr88[3] = (int) typedArrayObtainStyledAttributes.getDimension(i94, dimension49);
        int dimension50 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1IconMargin, -1.0f);
        int[] iArr89 = this.rightIconMargins[0];
        int i95 = R.styleable.ActionBarSuper_absuper_right1IconMarginRight;
        iArr89[0] = (int) typedArrayObtainStyledAttributes.getDimension(i95, dimension50 >= 0 ? dimension50 : this.rightIconMargin[0]);
        this.rightIconMargins[0][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right1IconMarginTop, dimension50 >= 0 ? dimension50 : this.rightIconMargin[1]);
        int[] iArr90 = this.rightIconMargins[0];
        if (dimension50 >= 0) {
            f57 = dimension50;
            c56 = 2;
        } else {
            c56 = 2;
            f57 = this.rightIconMargin[2];
        }
        iArr90[c56] = (int) typedArrayObtainStyledAttributes.getDimension(i95, f57);
        int[] iArr91 = this.rightIconMargins[0];
        int i96 = R.styleable.ActionBarSuper_absuper_right1IconMarginBottom;
        if (dimension50 < 0) {
            dimension50 = this.rightIconMargin[3];
        }
        iArr91[3] = (int) typedArrayObtainStyledAttributes.getDimension(i96, dimension50);
        this.rightTextStyles[1] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_right2TextStyle, this.rightTextStyle);
        this.rightTextClickToFinish[1] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right2TextClickToFinish, false);
        this.rightIconClickToFinish[1] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right2IconClickToFinish, false);
        this.rightTexts[1] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_right2Text);
        this.rightTextColors[1] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right2TextColor, this.rightTextColor);
        this.rightTextSizes[1] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2TextSize, this.rightTextSize);
        int dimension51 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2TextPadding, -1.0f);
        int[] iArr92 = this.rightTextPaddings[1];
        int i97 = R.styleable.ActionBarSuper_absuper_right2TextPaddingRight;
        if (dimension51 >= 0) {
            f58 = dimension51;
            c57 = 0;
        } else {
            c57 = 0;
            f58 = this.rightTextPadding[0];
        }
        iArr92[c57] = (int) typedArrayObtainStyledAttributes.getDimension(i97, f58);
        this.rightTextPaddings[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2TextPaddingTop, dimension51 >= 0 ? dimension51 : this.rightTextPadding[1]);
        int[] iArr93 = this.rightTextPaddings[1];
        if (dimension51 >= 0) {
            f59 = dimension51;
            c58 = 2;
        } else {
            c58 = 2;
            f59 = this.rightTextPadding[2];
        }
        iArr93[c58] = (int) typedArrayObtainStyledAttributes.getDimension(i97, f59);
        int[] iArr94 = this.rightTextPaddings[1];
        int i98 = R.styleable.ActionBarSuper_absuper_right2TextPaddingBottom;
        if (dimension51 < 0) {
            dimension51 = this.rightTextPadding[3];
        }
        iArr94[3] = (int) typedArrayObtainStyledAttributes.getDimension(i98, dimension51);
        int dimension52 = (int) typedArrayObtainStyledAttributes.getDimension(i90, -1.0f);
        int[] iArr95 = this.rightTextMargins[1];
        int i99 = R.styleable.ActionBarSuper_absuper_right2TextMarginRight;
        if (dimension52 >= 0) {
            f60 = dimension52;
            c59 = 0;
        } else {
            c59 = 0;
            f60 = this.rightTextMargin[0];
        }
        iArr95[c59] = (int) typedArrayObtainStyledAttributes.getDimension(i99, f60);
        this.rightTextMargins[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2TextMarginTop, dimension52 >= 0 ? dimension52 : this.rightTextMargin[1]);
        int[] iArr96 = this.rightTextMargins[1];
        if (dimension52 >= 0) {
            f61 = dimension52;
            c60 = 2;
        } else {
            c60 = 2;
            f61 = this.rightTextMargin[2];
        }
        iArr96[c60] = (int) typedArrayObtainStyledAttributes.getDimension(i99, f61);
        int[] iArr97 = this.rightTextMargins[1];
        int i100 = R.styleable.ActionBarSuper_absuper_right2TextMarginBottom;
        if (dimension52 < 0) {
            dimension52 = this.rightTextMargin[3];
        }
        iArr97[3] = (int) typedArrayObtainStyledAttributes.getDimension(i100, dimension52);
        this.rightIcons[1] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_right2Icon, 0);
        this.rightIconColors[1] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right2IconColor, this.rightIconColor);
        int dimension53 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2IconPadding, -1.0f);
        int[] iArr98 = this.rightIconPaddings[1];
        int i101 = R.styleable.ActionBarSuper_absuper_right2IconPaddingRight;
        if (dimension53 >= 0) {
            f62 = dimension53;
            c61 = 0;
        } else {
            c61 = 0;
            f62 = this.rightIconPadding[0];
        }
        iArr98[c61] = (int) typedArrayObtainStyledAttributes.getDimension(i101, f62);
        this.rightIconPaddings[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2IconPaddingTop, dimension53 >= 0 ? dimension53 : this.rightIconPadding[1]);
        int[] iArr99 = this.rightIconPaddings[1];
        if (dimension53 >= 0) {
            f63 = dimension53;
            c62 = 2;
        } else {
            c62 = 2;
            f63 = this.rightIconPadding[2];
        }
        iArr99[c62] = (int) typedArrayObtainStyledAttributes.getDimension(i101, f63);
        int[] iArr100 = this.rightIconPaddings[1];
        int i102 = R.styleable.ActionBarSuper_absuper_right2IconPaddingBottom;
        if (dimension53 < 0) {
            dimension53 = this.rightIconPadding[3];
        }
        iArr100[3] = (int) typedArrayObtainStyledAttributes.getDimension(i102, dimension53);
        int dimension54 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2IconMargin, -1.0f);
        int[] iArr101 = this.rightIconMargins[1];
        int i103 = R.styleable.ActionBarSuper_absuper_right2IconMarginRight;
        if (dimension54 >= 0) {
            f64 = dimension54;
            c63 = 0;
        } else {
            c63 = 0;
            f64 = this.rightIconMargin[0];
        }
        iArr101[c63] = (int) typedArrayObtainStyledAttributes.getDimension(i103, f64);
        this.rightIconMargins[1][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right2IconMarginTop, dimension54 >= 0 ? dimension54 : this.rightIconMargin[1]);
        int[] iArr102 = this.rightIconMargins[1];
        if (dimension54 >= 0) {
            f65 = dimension54;
            c64 = 2;
        } else {
            c64 = 2;
            f65 = this.rightIconMargin[2];
        }
        iArr102[c64] = (int) typedArrayObtainStyledAttributes.getDimension(i103, f65);
        int[] iArr103 = this.rightIconMargins[1];
        int i104 = R.styleable.ActionBarSuper_absuper_right2IconMarginBottom;
        if (dimension54 < 0) {
            dimension54 = this.rightIconMargin[3];
        }
        iArr103[3] = (int) typedArrayObtainStyledAttributes.getDimension(i104, dimension54);
        this.rightTextStyles[2] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_right3TextStyle, this.rightTextStyle);
        this.rightTextClickToFinish[2] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right3TextClickToFinish, false);
        this.rightIconClickToFinish[2] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right3IconClickToFinish, false);
        this.rightTexts[2] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_right3Text);
        this.rightTextColors[2] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right3TextColor, this.rightTextColor);
        this.rightTextSizes[2] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3TextSize, this.rightTextSize);
        int dimension55 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3TextPadding, -1.0f);
        int[] iArr104 = this.rightTextPaddings[2];
        int i105 = R.styleable.ActionBarSuper_absuper_right3TextPaddingRight;
        if (dimension55 >= 0) {
            f66 = dimension55;
            c65 = 0;
        } else {
            c65 = 0;
            f66 = this.rightTextPadding[0];
        }
        iArr104[c65] = (int) typedArrayObtainStyledAttributes.getDimension(i105, f66);
        this.rightTextPaddings[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3TextPaddingTop, dimension55 >= 0 ? dimension55 : this.rightTextPadding[1]);
        this.rightTextPaddings[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(i105, dimension55 >= 0 ? dimension55 : this.rightTextPadding[2]);
        int[] iArr105 = this.rightTextPaddings[2];
        int i106 = R.styleable.ActionBarSuper_absuper_right3TextPaddingBottom;
        if (dimension55 < 0) {
            dimension55 = this.rightTextPadding[3];
        }
        iArr105[3] = (int) typedArrayObtainStyledAttributes.getDimension(i106, dimension55);
        int dimension56 = (int) typedArrayObtainStyledAttributes.getDimension(i90, -1.0f);
        int[] iArr106 = this.rightTextMargins[2];
        int i107 = R.styleable.ActionBarSuper_absuper_right3TextMarginRight;
        if (dimension56 >= 0) {
            f67 = dimension56;
            c66 = 0;
        } else {
            c66 = 0;
            f67 = this.rightTextMargin[0];
        }
        iArr106[c66] = (int) typedArrayObtainStyledAttributes.getDimension(i107, f67);
        this.rightTextMargins[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3TextMarginTop, dimension56 >= 0 ? dimension56 : this.rightTextMargin[1]);
        this.rightTextMargins[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(i107, dimension56 >= 0 ? dimension56 : this.rightTextMargin[2]);
        int[] iArr107 = this.rightTextMargins[2];
        int i108 = R.styleable.ActionBarSuper_absuper_right3TextMarginBottom;
        if (dimension56 < 0) {
            dimension56 = this.rightTextMargin[3];
        }
        iArr107[3] = (int) typedArrayObtainStyledAttributes.getDimension(i108, dimension56);
        this.rightIcons[2] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_right3Icon, 0);
        this.rightIconColors[2] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right3IconColor, this.rightIconColor);
        int dimension57 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3IconPadding, -1.0f);
        int[] iArr108 = this.rightIconPaddings[2];
        int i109 = R.styleable.ActionBarSuper_absuper_right3IconPaddingRight;
        if (dimension57 >= 0) {
            f68 = dimension57;
            c67 = 0;
        } else {
            c67 = 0;
            f68 = this.rightIconPadding[0];
        }
        iArr108[c67] = (int) typedArrayObtainStyledAttributes.getDimension(i109, f68);
        this.rightIconPaddings[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3IconPaddingTop, dimension57 >= 0 ? dimension57 : this.rightIconPadding[1]);
        this.rightIconPaddings[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(i109, dimension57 >= 0 ? dimension57 : this.rightIconPadding[2]);
        int[] iArr109 = this.rightIconPaddings[2];
        int i110 = R.styleable.ActionBarSuper_absuper_right3IconPaddingBottom;
        if (dimension57 < 0) {
            dimension57 = this.rightIconPadding[3];
        }
        iArr109[3] = (int) typedArrayObtainStyledAttributes.getDimension(i110, dimension57);
        int dimension58 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3IconMargin, -1.0f);
        int[] iArr110 = this.rightIconMargins[2];
        int i111 = R.styleable.ActionBarSuper_absuper_right3IconMarginRight;
        if (dimension58 >= 0) {
            f69 = dimension58;
            c68 = 0;
        } else {
            c68 = 0;
            f69 = this.rightIconMargin[0];
        }
        iArr110[c68] = (int) typedArrayObtainStyledAttributes.getDimension(i111, f69);
        this.rightIconMargins[2][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right3IconMarginTop, dimension58 >= 0 ? dimension58 : this.rightIconMargin[1]);
        this.rightIconMargins[2][2] = (int) typedArrayObtainStyledAttributes.getDimension(i111, dimension58 >= 0 ? dimension58 : this.rightIconMargin[2]);
        int[] iArr111 = this.rightIconMargins[2];
        int i112 = R.styleable.ActionBarSuper_absuper_right3IconMarginBottom;
        if (dimension58 < 0) {
            dimension58 = this.rightIconMargin[3];
        }
        iArr111[3] = (int) typedArrayObtainStyledAttributes.getDimension(i112, dimension58);
        this.rightTextStyles[3] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_right4TextStyle, this.rightTextStyle);
        this.rightTextClickToFinish[3] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right4TextClickToFinish, false);
        this.rightIconClickToFinish[3] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right4IconClickToFinish, false);
        this.rightTexts[3] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_right4Text);
        this.rightTextColors[3] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right4TextColor, this.rightTextColor);
        this.rightTextSizes[3] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4TextSize, this.rightTextSize);
        int dimension59 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4TextPadding, -1.0f);
        int[] iArr112 = this.rightTextPaddings[3];
        int i113 = R.styleable.ActionBarSuper_absuper_right4TextPaddingRight;
        if (dimension59 >= 0) {
            f70 = dimension59;
            c69 = 0;
        } else {
            c69 = 0;
            f70 = this.rightTextPadding[0];
        }
        iArr112[c69] = (int) typedArrayObtainStyledAttributes.getDimension(i113, f70);
        this.rightTextPaddings[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4TextPaddingTop, dimension59 >= 0 ? dimension59 : this.rightTextPadding[1]);
        int[] iArr113 = this.rightTextPaddings[3];
        if (dimension59 >= 0) {
            f71 = dimension59;
            c70 = 2;
        } else {
            c70 = 2;
            f71 = this.rightTextPadding[2];
        }
        iArr113[c70] = (int) typedArrayObtainStyledAttributes.getDimension(i113, f71);
        int[] iArr114 = this.rightTextPaddings[3];
        int i114 = R.styleable.ActionBarSuper_absuper_right4TextPaddingBottom;
        if (dimension59 < 0) {
            dimension59 = this.rightTextPadding[3];
        }
        iArr114[3] = (int) typedArrayObtainStyledAttributes.getDimension(i114, dimension59);
        int i115 = R.styleable.ActionBarSuper_absuper_textMargin;
        int dimension60 = (int) typedArrayObtainStyledAttributes.getDimension(i115, -1.0f);
        int[] iArr115 = this.rightTextMargins[3];
        int i116 = R.styleable.ActionBarSuper_absuper_right4TextMarginRight;
        if (dimension60 >= 0) {
            f72 = dimension60;
            c71 = 0;
        } else {
            c71 = 0;
            f72 = this.rightTextMargin[0];
        }
        iArr115[c71] = (int) typedArrayObtainStyledAttributes.getDimension(i116, f72);
        this.rightTextMargins[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4TextMarginTop, dimension60 >= 0 ? dimension60 : this.rightTextMargin[1]);
        int[] iArr116 = this.rightTextMargins[3];
        if (dimension60 >= 0) {
            f73 = dimension60;
            c72 = 2;
        } else {
            c72 = 2;
            f73 = this.rightTextMargin[2];
        }
        iArr116[c72] = (int) typedArrayObtainStyledAttributes.getDimension(i116, f73);
        int[] iArr117 = this.rightTextMargins[3];
        int i117 = R.styleable.ActionBarSuper_absuper_right4TextMarginBottom;
        if (dimension60 < 0) {
            dimension60 = this.rightTextMargin[3];
        }
        iArr117[3] = (int) typedArrayObtainStyledAttributes.getDimension(i117, dimension60);
        this.rightIcons[3] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_right4Icon, 0);
        this.rightIconColors[3] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right4IconColor, this.rightIconColor);
        int dimension61 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4IconPadding, -1.0f);
        int[] iArr118 = this.rightIconPaddings[3];
        int i118 = R.styleable.ActionBarSuper_absuper_right4IconPaddingRight;
        if (dimension61 >= 0) {
            f74 = dimension61;
            c73 = 0;
        } else {
            c73 = 0;
            f74 = this.rightIconPadding[0];
        }
        iArr118[c73] = (int) typedArrayObtainStyledAttributes.getDimension(i118, f74);
        this.rightIconPaddings[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4IconPaddingTop, dimension61 >= 0 ? dimension61 : this.rightIconPadding[1]);
        int[] iArr119 = this.rightIconPaddings[3];
        if (dimension61 >= 0) {
            f75 = dimension61;
            c74 = 2;
        } else {
            c74 = 2;
            f75 = this.rightIconPadding[2];
        }
        iArr119[c74] = (int) typedArrayObtainStyledAttributes.getDimension(i118, f75);
        int[] iArr120 = this.rightIconPaddings[3];
        int i119 = R.styleable.ActionBarSuper_absuper_right4IconPaddingBottom;
        if (dimension61 < 0) {
            dimension61 = this.rightIconPadding[3];
        }
        iArr120[3] = (int) typedArrayObtainStyledAttributes.getDimension(i119, dimension61);
        int dimension62 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4IconMargin, -1.0f);
        int[] iArr121 = this.rightIconMargins[3];
        int i120 = R.styleable.ActionBarSuper_absuper_right4IconMarginRight;
        if (dimension62 >= 0) {
            f76 = dimension62;
            c75 = 0;
        } else {
            c75 = 0;
            f76 = this.rightIconMargin[0];
        }
        iArr121[c75] = (int) typedArrayObtainStyledAttributes.getDimension(i120, f76);
        this.rightIconMargins[3][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right4IconMarginTop, dimension62 >= 0 ? dimension62 : this.rightIconMargin[1]);
        int[] iArr122 = this.rightIconMargins[3];
        if (dimension62 >= 0) {
            f77 = dimension62;
            c76 = 2;
        } else {
            c76 = 2;
            f77 = this.rightIconMargin[2];
        }
        iArr122[c76] = (int) typedArrayObtainStyledAttributes.getDimension(i120, f77);
        int[] iArr123 = this.rightIconMargins[3];
        int i121 = R.styleable.ActionBarSuper_absuper_right4IconMarginBottom;
        if (dimension62 < 0) {
            dimension62 = this.rightIconMargin[3];
        }
        iArr123[3] = (int) typedArrayObtainStyledAttributes.getDimension(i121, dimension62);
        this.rightTextStyles[4] = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarSuper_absuper_right5TextStyle, this.rightTextStyle);
        this.rightTextClickToFinish[4] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right5TextClickToFinish, false);
        this.rightIconClickToFinish[4] = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarSuper_absuper_right5IconClickToFinish, false);
        this.rightTexts[4] = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSuper_absuper_right5Text);
        this.rightTextColors[4] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right5TextColor, this.rightTextColor);
        this.rightTextSizes[4] = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5TextSize, this.rightTextSize);
        int dimension63 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5TextPadding, -1.0f);
        int[] iArr124 = this.rightTextPaddings[4];
        int i122 = R.styleable.ActionBarSuper_absuper_right5TextPaddingRight;
        if (dimension63 >= 0) {
            f78 = dimension63;
            c77 = 0;
        } else {
            c77 = 0;
            f78 = this.rightTextPadding[0];
        }
        iArr124[c77] = (int) typedArrayObtainStyledAttributes.getDimension(i122, f78);
        this.rightTextPaddings[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5TextPaddingTop, dimension63 >= 0 ? dimension63 : this.rightTextPadding[1]);
        int[] iArr125 = this.rightTextPaddings[4];
        if (dimension63 >= 0) {
            f79 = dimension63;
            c78 = 2;
        } else {
            c78 = 2;
            f79 = this.rightTextPadding[2];
        }
        iArr125[c78] = (int) typedArrayObtainStyledAttributes.getDimension(i122, f79);
        int[] iArr126 = this.rightTextPaddings[4];
        int i123 = R.styleable.ActionBarSuper_absuper_right5TextPaddingBottom;
        if (dimension63 < 0) {
            dimension63 = this.rightTextPadding[3];
        }
        iArr126[3] = (int) typedArrayObtainStyledAttributes.getDimension(i123, dimension63);
        int dimension64 = (int) typedArrayObtainStyledAttributes.getDimension(i115, -1.0f);
        int[] iArr127 = this.rightTextMargins[4];
        int i124 = R.styleable.ActionBarSuper_absuper_right5TextMarginRight;
        if (dimension64 >= 0) {
            f80 = dimension64;
            c79 = 0;
        } else {
            c79 = 0;
            f80 = this.rightTextMargin[0];
        }
        iArr127[c79] = (int) typedArrayObtainStyledAttributes.getDimension(i124, f80);
        this.rightTextMargins[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5TextMarginTop, dimension64 >= 0 ? dimension64 : this.rightTextMargin[1]);
        int[] iArr128 = this.rightTextMargins[4];
        if (dimension64 >= 0) {
            f81 = dimension64;
            c80 = 2;
        } else {
            c80 = 2;
            f81 = this.rightTextMargin[2];
        }
        iArr128[c80] = (int) typedArrayObtainStyledAttributes.getDimension(i124, f81);
        int[] iArr129 = this.rightTextMargins[4];
        int i125 = R.styleable.ActionBarSuper_absuper_right5TextMarginBottom;
        if (dimension64 < 0) {
            dimension64 = this.rightTextMargin[3];
        }
        iArr129[3] = (int) typedArrayObtainStyledAttributes.getDimension(i125, dimension64);
        this.rightIcons[4] = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSuper_absuper_right5Icon, 0);
        this.rightIconColors[4] = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSuper_absuper_right5IconColor, this.rightIconColor);
        int dimension65 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5IconPadding, -1.0f);
        int[] iArr130 = this.rightIconPaddings[4];
        int i126 = R.styleable.ActionBarSuper_absuper_right5IconPaddingRight;
        if (dimension65 >= 0) {
            f82 = dimension65;
            c81 = 0;
        } else {
            c81 = 0;
            f82 = this.rightIconPadding[0];
        }
        iArr130[c81] = (int) typedArrayObtainStyledAttributes.getDimension(i126, f82);
        this.rightIconPaddings[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5IconPaddingTop, dimension65 >= 0 ? dimension65 : this.rightIconPadding[1]);
        int[] iArr131 = this.rightIconPaddings[4];
        if (dimension65 >= 0) {
            f83 = dimension65;
            c82 = 2;
        } else {
            c82 = 2;
            f83 = this.rightIconPadding[2];
        }
        iArr131[c82] = (int) typedArrayObtainStyledAttributes.getDimension(i126, f83);
        int[] iArr132 = this.rightIconPaddings[4];
        int i127 = R.styleable.ActionBarSuper_absuper_right5IconPaddingBottom;
        if (dimension65 < 0) {
            dimension65 = this.rightIconPadding[3];
        }
        iArr132[3] = (int) typedArrayObtainStyledAttributes.getDimension(i127, dimension65);
        int dimension66 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5IconMargin, -1.0f);
        int[] iArr133 = this.rightIconMargins[4];
        int i128 = R.styleable.ActionBarSuper_absuper_right5IconMarginRight;
        if (dimension66 >= 0) {
            f84 = dimension66;
            c83 = 0;
        } else {
            c83 = 0;
            f84 = this.rightIconMargin[0];
        }
        iArr133[c83] = (int) typedArrayObtainStyledAttributes.getDimension(i128, f84);
        this.rightIconMargins[4][1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSuper_absuper_right5IconMarginTop, dimension66 >= 0 ? dimension66 : this.rightIconMargin[1]);
        int[] iArr134 = this.rightIconMargins[4];
        if (dimension66 >= 0) {
            f85 = dimension66;
            c84 = 2;
        } else {
            c84 = 2;
            f85 = this.rightIconMargin[2];
        }
        iArr134[c84] = (int) typedArrayObtainStyledAttributes.getDimension(i128, f85);
        int[] iArr135 = this.rightIconMargins[4];
        int i129 = R.styleable.ActionBarSuper_absuper_right5IconMarginBottom;
        if (dimension66 < 0) {
            dimension66 = this.rightIconMargin[3];
        }
        iArr135[3] = (int) typedArrayObtainStyledAttributes.getDimension(i129, dimension66);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void initTitleTextView() {
        TextView textView = (TextView) this.titleBarChild.findViewById(R.id.actionbarex_common_tv_title);
        this.titleTextView = textView;
        textView.setVisibility(0);
        setTextStyle(this.titleTextView, this.titleTextStyle);
        this.titleTextView.setText(this.titleText);
        this.titleTextView.setTextColor(this.titleTextColor);
        this.titleTextView.setTextSize(0, this.titleTextSize);
        this.titleTextView.setMaxWidth(this.titleTextMaxWidth);
        TextView textView2 = this.titleTextView;
        int[] iArr = this.titlePadding;
        textView2.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleTextView.getLayoutParams();
        int[] iArr2 = this.titleMargin;
        layoutParams.leftMargin = iArr2[0];
        layoutParams.topMargin = iArr2[1];
        layoutParams.rightMargin = iArr2[2];
        layoutParams.bottomMargin = iArr2[3];
        this.subtitleTextView = (TextView) this.titleBarChild.findViewById(R.id.actionbarex_common_tv_subtitle);
        if (TextUtils.isEmpty(this.subtitleText)) {
            this.subtitleTextView.setVisibility(8);
        } else {
            this.subtitleTextView.setVisibility(0);
        }
        setTextStyle(this.subtitleTextView, this.subtitleTextStyle);
        this.subtitleTextView.setText(this.subtitleText);
        this.subtitleTextView.setTextColor(this.subtitleTextColor);
        this.subtitleTextView.setTextSize(0, this.subtitleTextSize);
        this.subtitleTextView.setMaxWidth(this.subtitleTextMaxWidth);
        TextView textView3 = this.subtitleTextView;
        int[] iArr3 = this.subtitlePadding;
        textView3.setPadding(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.subtitleTextView.getLayoutParams();
        int[] iArr4 = this.subtitleMargin;
        layoutParams2.leftMargin = iArr4[0];
        layoutParams2.topMargin = iArr4[1];
        layoutParams2.rightMargin = iArr4[2];
        layoutParams2.bottomMargin = iArr4[3];
        LinearLayout linearLayout = (LinearLayout) this.titleBarChild.findViewById(R.id.actionbarex_common_ll_title);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        int i5 = this.titleGravity;
        if (i5 == 0) {
            linearLayout.setGravity(17);
            layoutParams3.gravity = 17;
        } else if (i5 == 1) {
            linearLayout.setGravity(19);
            layoutParams3.gravity = 19;
        } else if (i5 == 2) {
            linearLayout.setGravity(21);
            layoutParams3.gravity = 21;
        } else {
            linearLayout.setGravity(17);
            layoutParams3.gravity = 17;
        }
    }

    public ActionBarSuper(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarSuper(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
