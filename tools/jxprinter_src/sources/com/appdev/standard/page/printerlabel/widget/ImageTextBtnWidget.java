package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import p113u.d;
import p113u.e;
import p113u.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ImageTextBtnWidget extends LinearLayout {
    private boolean canClick;
    private String itbContent;
    private int itbContentTextColor;
    private int itbContentTextSize;
    private int itbHeight;
    private Drawable itbIcon;
    private int itbWidth;
    private ImageView ivIcon;
    private LinearLayout llImageTextBtn;
    public OnImageTextBtnWidgetOnClick onImageTextBtnWidgetOnClick;
    private TextView tvContent;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnImageTextBtnWidgetOnClick {
        void onClick();
    }

    public ImageTextBtnWidget(Context context) {
        this(context, null);
    }

    public int dip2px(Context context, float f6) {
        return (int) (f6 * context.getResources().getDisplayMetrics().density);
    }

    public boolean isCanClick() {
        return this.canClick;
    }

    public void setCanClick(boolean z6) {
        this.canClick = z6;
        this.ivIcon.setEnabled(z6);
    }

    public void setContent(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        this.tvContent.setText(str);
    }

    public void setIconState(boolean z6) {
        this.ivIcon.setEnabled(z6);
    }

    public void setItbContent(String str) {
        this.itbContent = str;
        this.tvContent.setText(str);
    }

    public void setItbIcon(int i5) {
        Drawable drawable = getResources().getDrawable(i5);
        this.itbIcon = drawable;
        this.ivIcon.setImageDrawable(drawable);
    }

    public void setOnDataClickListener(OnImageTextBtnWidgetOnClick onImageTextBtnWidgetOnClick) {
        this.onImageTextBtnWidgetOnClick = onImageTextBtnWidgetOnClick;
    }

    public ImageTextBtnWidget(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageTextBtnWidget(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.canClick = true;
        View viewInflate = LayoutInflater.from(context).inflate(e.widget_image_text_btn, (ViewGroup) this, false);
        addView(viewInflate);
        this.llImageTextBtn = (LinearLayout) viewInflate.findViewById(d.ll_image_text_btn);
        this.ivIcon = (ImageView) viewInflate.findViewById(d.iv_image_text_btn_icon);
        this.tvContent = (TextView) viewInflate.findViewById(d.tv_image_text_btn_content);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ImageTextBtnWidgetStyle);
        this.itbIcon = getResources().getDrawable(typedArrayObtainStyledAttributes.getResourceId(i.ImageTextBtnWidgetStyle_itb_icon, p113u.c.default_itb_icon));
        this.itbHeight = (int) typedArrayObtainStyledAttributes.getDimension(i.ImageTextBtnWidgetStyle_itb_height, dip2px(context, 20.0f));
        this.itbWidth = (int) typedArrayObtainStyledAttributes.getDimension(i.ImageTextBtnWidgetStyle_itb_width, dip2px(context, 20.0f));
        this.itbContent = typedArrayObtainStyledAttributes.getString(i.ImageTextBtnWidgetStyle_itb_content);
        this.itbContentTextColor = typedArrayObtainStyledAttributes.getColor(i.ImageTextBtnWidgetStyle_itb_content_text_color, ViewCompat.MEASURED_STATE_MASK);
        this.itbContentTextSize = (int) typedArrayObtainStyledAttributes.getDimension(i.ImageTextBtnWidgetStyle_itb_content_text_size, dip2px(context, 5.0f));
        typedArrayObtainStyledAttributes.recycle();
        this.llImageTextBtn.setLayoutParams(new LinearLayout.LayoutParams(-2, this.itbHeight));
        this.ivIcon.setImageDrawable(this.itbIcon);
        this.tvContent.setText(this.itbContent);
        this.tvContent.setTextSize(0, this.itbContentTextSize);
        this.tvContent.setTextColor(this.itbContentTextColor);
    }
}
