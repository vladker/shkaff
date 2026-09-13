package com.zlylib.titlebarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.zlylib.titlebarlib.widget.ActionBarEx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ActionBarCommon extends ActionBarEx {
    private boolean centerTextMarquee;
    private boolean leftIconClickToFinish;
    private int leftIconColor;
    private int leftIconMarginLeft;
    private int leftIconPadding;
    private int leftIconRes;
    private ImageView leftIconView;
    private String leftText;
    private boolean leftTextClickToFinish;
    private int leftTextColor;
    private int leftTextPaddingLeft;
    private int leftTextPaddingRight;
    private float leftTextSize;
    private TextView leftTextView;
    private int rightIconColor;
    private int rightIconMarginRight;
    private int rightIconPadding;
    private int rightIconRes;
    private ImageView rightIconView;
    private String rightText;
    private int rightTextColor;
    private int rightTextPaddingLeft;
    private int rightTextPaddingRight;
    private float rightTextSize;
    private TextView rightTextView;
    private String titleText;
    private int titleTextColor;
    private int titleTextMaxWidth;
    private float titleTextSize;
    private TextView titleTextView;

    public ActionBarCommon(Context context) {
        this(context, null);
    }

    public ImageView getLeftIconView() {
        return this.leftIconView;
    }

    public TextView getLeftTextView() {
        return this.leftTextView;
    }

    public ImageView getRightIconView() {
        return this.rightIconView;
    }

    public TextView getRightTextView() {
        return this.rightTextView;
    }

    public TextView getTitleTextView() {
        return this.titleTextView;
    }

    @Override // com.zlylib.titlebarlib.widget.ActionBarEx
    public View inflateTitleBar() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.actionbarex_common_action_bar_title_bar_common, (ViewGroup) getTitleBar(), false);
        this.leftIconView = (ImageView) relativeLayout.findViewById(R.id.actionbarex_common_iv_left);
        this.leftTextView = (TextView) relativeLayout.findViewById(R.id.actionbarex_common_tv_left);
        this.titleTextView = (TextView) relativeLayout.findViewById(R.id.actionbarex_common_tv_title);
        this.rightTextView = (TextView) relativeLayout.findViewById(R.id.actionbarex_common_tv_right);
        this.rightIconView = (ImageView) relativeLayout.findViewById(R.id.actionbarex_common_iv_right);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leftIconView.getLayoutParams();
        layoutParams.leftMargin = this.leftIconMarginLeft;
        this.leftIconView.setLayoutParams(layoutParams);
        if (this.leftIconRes > 0) {
            this.leftIconView.setVisibility(0);
            ImageView imageView = this.leftIconView;
            int i5 = this.leftIconPadding;
            imageView.setPadding(i5, i5, i5, i5);
            this.leftIconView.setImageResource(this.leftIconRes);
            this.leftIconView.setColorFilter(this.leftIconColor);
            if (this.leftIconClickToFinish) {
                this.leftIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarCommon.this.finishActivity();
                    }
                });
            }
        } else {
            this.leftIconView.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.leftText)) {
            this.leftTextView.setVisibility(8);
        } else {
            this.leftTextView.setVisibility(0);
            this.leftTextView.setText(this.leftText);
            this.leftTextView.setTextColor(this.leftTextColor);
            this.leftTextView.setTextSize(0, this.leftTextSize);
            this.leftTextView.setPadding(this.leftTextPaddingLeft, 0, this.leftTextPaddingRight, 0);
            if (this.leftTextClickToFinish) {
                this.leftTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarCommon.this.finishActivity();
                    }
                });
            }
        }
        this.titleTextView.setVisibility(0);
        this.titleTextView.setText(this.titleText);
        this.titleTextView.setTextColor(this.titleTextColor);
        this.titleTextView.setTextSize(0, this.titleTextSize);
        this.titleTextView.setMaxWidth(this.titleTextMaxWidth);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.rightIconView.getLayoutParams();
        layoutParams2.rightMargin = this.rightIconMarginRight;
        this.rightIconView.setLayoutParams(layoutParams2);
        if (this.rightIconRes > 0) {
            this.rightIconView.setVisibility(0);
            ImageView imageView2 = this.rightIconView;
            int i6 = this.rightIconPadding;
            imageView2.setPadding(i6, i6, i6, i6);
            this.rightIconView.setImageResource(this.rightIconRes);
            this.rightIconView.setColorFilter(this.rightIconColor);
        } else {
            this.rightIconView.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.rightText)) {
            this.rightTextView.setVisibility(8);
            return relativeLayout;
        }
        this.rightTextView.setVisibility(0);
        this.rightTextView.setText(this.rightText);
        this.rightTextView.setTextColor(this.rightTextColor);
        this.rightTextView.setTextSize(0, this.rightTextSize);
        this.rightTextView.setPadding(this.rightTextPaddingLeft, 0, this.rightTextPaddingRight, 0);
        return relativeLayout;
    }

    @Override // com.zlylib.titlebarlib.widget.ActionBarEx
    public void initAttrs(AttributeSet attributeSet) {
        super.initAttrs(attributeSet);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ActionBarCommon);
        float dimension = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_title_text_max_width_def);
        float dimension2 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_icon_padding_def);
        float dimension3 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_size_def);
        float dimension4 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_left_def);
        float dimension5 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_right_def);
        float dimension6 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_title_text_size_def);
        int color = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_icon_color_def);
        int color2 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_text_color_def);
        int color3 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_title_text_color_def);
        this.leftTextClickToFinish = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarCommon_abc_leftTextClickToFinish, false);
        this.leftIconClickToFinish = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarCommon_abc_leftIconClickToFinish, false);
        this.leftText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarCommon_abc_leftText);
        this.leftTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_leftTextSize, dimension3);
        this.leftTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarCommon_abc_leftTextColor, color2);
        this.leftTextPaddingLeft = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_leftTextPaddingLeft, dimension4);
        this.leftTextPaddingRight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_leftTextPaddingRight, dimension5);
        this.leftIconRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarCommon_abc_leftIconRes, 0);
        this.leftIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarCommon_abc_leftIconColor, color);
        this.leftIconPadding = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_leftIconPadding, dimension2);
        this.leftIconMarginLeft = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_leftIconMarginLeft, 0.0f);
        this.rightText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarCommon_abc_rightText);
        this.rightTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_rightTextSize, dimension3);
        this.rightTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarCommon_abc_rightTextColor, color2);
        this.rightTextPaddingLeft = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_rightTextPaddingLeft, dimension4);
        this.rightTextPaddingRight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_rightTextPaddingRight, dimension5);
        this.rightIconRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarCommon_abc_rightIconRes, 0);
        this.rightIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarCommon_abc_rightIconColor, color);
        this.rightIconPadding = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_rightIconPadding, dimension2);
        this.rightIconMarginRight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_rightIconMarginRight, 0.0f);
        this.titleText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarCommon_abc_titleText);
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_titleTextSize, dimension6);
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarCommon_abc_titleTextColor, color3);
        this.titleTextMaxWidth = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarCommon_abc_titleTextMaxWidth, dimension);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOnLeftIconClickListener(final OnActionBarChildClickListener onActionBarChildClickListener) {
        this.leftIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnActionBarChildClickListener onActionBarChildClickListener2 = onActionBarChildClickListener;
                if (onActionBarChildClickListener2 != null) {
                    onActionBarChildClickListener2.onClick(view);
                }
            }
        });
    }

    public void setOnLeftTextClickListener(final OnActionBarChildClickListener onActionBarChildClickListener) {
        this.leftTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnActionBarChildClickListener onActionBarChildClickListener2 = onActionBarChildClickListener;
                if (onActionBarChildClickListener2 != null) {
                    onActionBarChildClickListener2.onClick(view);
                }
            }
        });
    }

    public void setOnRightIconClickListener(final OnActionBarChildClickListener onActionBarChildClickListener) {
        this.rightIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnActionBarChildClickListener onActionBarChildClickListener2 = onActionBarChildClickListener;
                if (onActionBarChildClickListener2 != null) {
                    onActionBarChildClickListener2.onClick(view);
                }
            }
        });
    }

    public void setOnRightTextClickListener(final OnActionBarChildClickListener onActionBarChildClickListener) {
        this.rightTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarCommon.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnActionBarChildClickListener onActionBarChildClickListener2 = onActionBarChildClickListener;
                if (onActionBarChildClickListener2 != null) {
                    onActionBarChildClickListener2.onClick(view);
                }
            }
        });
    }

    public ActionBarCommon(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarCommon(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.centerTextMarquee = true;
    }
}
