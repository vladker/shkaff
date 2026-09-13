package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import p113u.f;
import p113u.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TextImageViewWidget extends LinearLayout {
    private String describeContent;
    private boolean isOpen;
    private ImageView mImageView;
    private TextView mTextView;
    private OnSwitchClickListener onSwitchClickListener;
    private int tivLabelTextColor;
    private int tivLabelTextSize;
    private int tivSwitchHeight;
    private int tivSwitchWidth;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnSwitchClickListener {
        void callBack(boolean z6);
    }

    public TextImageViewWidget(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        TextView textView = new TextView(context);
        this.mTextView = textView;
        boolean z6 = this.isOpen;
        textView.setText(this.describeContent);
        this.mTextView.setTextSize(1, this.tivLabelTextSize);
        this.mTextView.setTextColor(this.tivLabelTextColor);
        addView(this.mTextView, new LinearLayoutCompat.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mImageView.setBackgroundResource(this.isOpen ? f.ic_common_switch_on_1 : f.ic_common_switch_off_1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p035f5.b.d(70.0f), p035f5.b.d(32.0f));
        layoutParams.setMarginStart((int) ((30.0f / p035f5.b.b.getResources().getDisplayMetrics().density) + 0.5f));
        int i5 = this.tivSwitchWidth;
        if (i5 != 0) {
            layoutParams.width = i5;
        }
        int i6 = this.tivSwitchHeight;
        if (i6 != 0) {
            layoutParams.height = i6;
        }
        addView(this.mImageView, layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.TextImageViewWidget.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextImageViewWidget textImageViewWidget = TextImageViewWidget.this;
                textImageViewWidget.isOpen = !textImageViewWidget.isOpen;
                TextView textView2 = TextImageViewWidget.this.mTextView;
                boolean unused = TextImageViewWidget.this.isOpen;
                textView2.setText(TextImageViewWidget.this.describeContent);
                TextImageViewWidget.this.mImageView.setBackgroundResource(TextImageViewWidget.this.isOpen ? f.ic_common_switch_on_1 : f.ic_common_switch_off_1);
                if (TextImageViewWidget.this.onSwitchClickListener != null) {
                    TextImageViewWidget.this.onSwitchClickListener.callBack(TextImageViewWidget.this.isOpen);
                }
            }
        });
    }

    public int dip2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setOnSwitchClickListener(OnSwitchClickListener onSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener;
    }

    public void setSwitchState(boolean z6) {
        this.isOpen = z6;
        this.mTextView.setText(this.describeContent);
        this.mImageView.setBackgroundResource(this.isOpen ? f.ic_common_switch_on_1 : f.ic_common_switch_off_1);
    }

    public TextImageViewWidget(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextImageViewWidget(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.isOpen = false;
        this.describeContent = "";
        this.tivLabelTextSize = 28;
        this.tivLabelTextColor = ViewCompat.MEASURED_STATE_MASK;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.TextImageViewWidget, i5, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == i.TextImageViewWidget_tiv_describe_content) {
                this.describeContent = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == i.TextImageViewWidget_tiv_switch_width) {
                this.tivSwitchWidth = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 20.0f));
            } else if (index == i.TextImageViewWidget_tiv_switch_height) {
                this.tivSwitchHeight = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 20.0f));
            } else if (index == i.TextImageViewWidget_tiv_label_text_size) {
                this.tivLabelTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            } else if (index == i.TextImageViewWidget_tiv_label_text_color) {
                this.tivLabelTextColor = typedArrayObtainStyledAttributes.getColor(index, -16776961);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(0);
        setGravity(16);
        initView(context);
    }
}
