package com.zlylib.titlebarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.zlylib.titlebarlib.widget.ActionBarEx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ActionBarSearch extends ActionBarEx {
    private boolean leftIconClickToFinish;
    private int leftIconColor;
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
    private int rightIconPadding;
    private int rightIconRes;
    private ImageView rightIconView;
    private String rightText;
    private int rightTextColor;
    private int rightTextPaddingLeft;
    private int rightTextPaddingRight;
    private float rightTextSize;
    private TextView rightTextView;
    private int titleBgRes;
    private EditText titleEditText;
    private int titleHintColor;
    private String titleHintText;
    private int titleMarginVertical;
    private int titlePaddingHorizontal;
    private int titleTextColor;
    private float titleTextSize;

    public ActionBarSearch(Context context) {
        this(context, null);
    }

    public EditText getEditTextView() {
        return this.titleEditText;
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

    @Override // com.zlylib.titlebarlib.widget.ActionBarEx
    public View inflateTitleBar() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.actionbarex_common_action_bar_title_bar_search, (ViewGroup) getTitleBar(), false);
        this.leftIconView = (ImageView) relativeLayout.findViewById(R.id.actionbarex_common_iv_left);
        this.leftTextView = (TextView) relativeLayout.findViewById(R.id.actionbarex_common_tv_left);
        this.titleEditText = (EditText) relativeLayout.findViewById(R.id.actionbarex_common_et_title);
        this.rightTextView = (TextView) relativeLayout.findViewById(R.id.actionbarex_common_tv_right);
        this.rightIconView = (ImageView) relativeLayout.findViewById(R.id.actionbarex_common_iv_right);
        if (this.leftIconRes > 0) {
            this.leftIconView.setVisibility(0);
            ImageView imageView = this.leftIconView;
            int i5 = this.leftIconPadding;
            imageView.setPadding(i5, i5, i5, i5);
            this.leftIconView.setImageResource(this.leftIconRes);
            this.leftIconView.setColorFilter(this.leftIconColor);
            if (this.leftIconClickToFinish) {
                this.leftIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSearch.this.finishActivity();
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
                this.leftTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ActionBarSearch.this.finishActivity();
                    }
                });
            }
        }
        this.titleEditText.setVisibility(0);
        this.titleEditText.setHint(this.titleHintText);
        this.titleEditText.setTextColor(this.titleTextColor);
        this.titleEditText.setTextSize(0, this.titleTextSize);
        this.titleEditText.setHintTextColor(this.titleHintColor);
        int i6 = this.titleBgRes;
        if (i6 > 0) {
            this.titleEditText.setBackgroundResource(i6);
        }
        EditText editText = this.titleEditText;
        int i7 = this.titlePaddingHorizontal;
        editText.setPadding(i7, 0, i7, 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.titleEditText.getLayoutParams();
        int i8 = this.titleMarginVertical;
        layoutParams.topMargin = i8;
        layoutParams.bottomMargin = i8;
        this.titleEditText.setLayoutParams(layoutParams);
        if (this.rightIconRes > 0) {
            this.rightIconView.setVisibility(0);
            ImageView imageView2 = this.rightIconView;
            int i9 = this.rightIconPadding;
            imageView2.setPadding(i9, i9, i9, i9);
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
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ActionBarSearch);
        float dimension = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_icon_padding_def);
        float dimension2 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_size_def);
        float dimension3 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_left_def);
        float dimension4 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_right_def);
        float dimension5 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_title_text_size_def);
        int color = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_icon_color_def);
        int color2 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_text_color_def);
        int color3 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_title_text_color_def);
        int color4 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_title_text_hint_color_def);
        this.leftTextClickToFinish = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarCommon_abc_leftTextClickToFinish, false);
        this.leftIconClickToFinish = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionBarCommon_abc_leftIconClickToFinish, false);
        this.leftText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSearch_abs_leftText);
        this.leftTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_leftTextSize, dimension2);
        this.leftTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_leftTextColor, color2);
        this.leftTextPaddingLeft = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_leftTextPaddingLeft, dimension3);
        this.leftTextPaddingRight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_leftTextPaddingRight, dimension4);
        this.leftIconRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSearch_abs_leftIconRes, 0);
        this.leftIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_leftIconColor, color);
        this.leftIconPadding = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_leftIconPadding, dimension);
        this.rightText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSearch_abs_rightText);
        this.rightTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_rightTextSize, dimension2);
        this.rightTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_rightTextColor, color2);
        this.rightTextPaddingLeft = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_rightTextPaddingLeft, dimension3);
        this.rightTextPaddingRight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_rightTextPaddingRight, dimension4);
        this.rightIconRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSearch_abs_rightIconRes, 0);
        this.rightIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_rightIconColor, color);
        this.rightIconPadding = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_rightIconPadding, dimension);
        this.titleBgRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBarSearch_abs_titleBgRes, 0);
        this.titleHintText = typedArrayObtainStyledAttributes.getString(R.styleable.ActionBarSearch_abs_titleHintText);
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_titleTextSize, dimension5);
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_titleTextColor, color3);
        this.titleHintColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionBarSearch_abs_titleHintColor, color4);
        this.titlePaddingHorizontal = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_titlePaddingHorizontal, 0.0f);
        this.titleMarginVertical = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionBarSearch_abs_titleMarginVertical, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOnLeftIconClickListener(final OnActionBarChildClickListener onActionBarChildClickListener) {
        this.leftIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.3
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
        this.leftTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.4
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
        this.rightIconView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.6
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
        this.rightTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zlylib.titlebarlib.ActionBarSearch.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnActionBarChildClickListener onActionBarChildClickListener2 = onActionBarChildClickListener;
                if (onActionBarChildClickListener2 != null) {
                    onActionBarChildClickListener2.onClick(view);
                }
            }
        });
    }

    public ActionBarSearch(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarSearch(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
