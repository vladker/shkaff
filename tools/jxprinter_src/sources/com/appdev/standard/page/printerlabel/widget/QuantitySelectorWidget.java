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
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import kotlin.jvm.internal.Y;
import p113u.d;
import p113u.e;
import p113u.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class QuantitySelectorWidget extends LinearLayout {
    private int addId;
    private ImageView ivAdd;
    private ImageView ivSubtract;
    private Drawable offsetBackground;
    private int offsetBigValue;
    private int offsetSmallValue;
    private int offsetValue;
    private boolean offsetValueInputType;
    private OnValueChangeListener onValueChangeListener;
    private int subtractId;
    private TextView tvOffsetValue;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnValueChangeListener {
        void onValue(int i5);
    }

    public QuantitySelectorWidget(Context context) {
        this(context, null);
    }

    private void initListener() {
        this.ivSubtract.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuantitySelectorWidget.this.offsetSmallValue == 0 || QuantitySelectorWidget.this.offsetSmallValue <= QuantitySelectorWidget.this.offsetValue - 1) {
                    QuantitySelectorWidget.this.offsetValue--;
                    QuantitySelectorWidget.this.tvOffsetValue.setText(String.valueOf(QuantitySelectorWidget.this.offsetValue));
                    if (QuantitySelectorWidget.this.onValueChangeListener != null) {
                        QuantitySelectorWidget.this.onValueChangeListener.onValue(QuantitySelectorWidget.this.offsetValue);
                    }
                }
            }
        });
        this.ivAdd.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuantitySelectorWidget.this.offsetBigValue == 0 || QuantitySelectorWidget.this.offsetBigValue >= QuantitySelectorWidget.this.offsetValue + 1) {
                    QuantitySelectorWidget.this.offsetValue++;
                    QuantitySelectorWidget.this.tvOffsetValue.setText(String.valueOf(QuantitySelectorWidget.this.offsetValue));
                    if (QuantitySelectorWidget.this.onValueChangeListener != null) {
                        QuantitySelectorWidget.this.onValueChangeListener.onValue(QuantitySelectorWidget.this.offsetValue);
                    }
                }
            }
        });
        if (this.offsetValueInputType) {
            this.tvOffsetValue.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ContentEditDialog contentEditDialog = new ContentEditDialog(QuantitySelectorWidget.this.getContext(), 2);
                    contentEditDialog.a(String.valueOf(QuantitySelectorWidget.this.offsetValue));
                    contentEditDialog.show();
                    contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.3.1
                        @Override // com.appdev.standard.dialog.InterfaceC0453f
                        public void setNewContent(String str) {
                            if (!Y.f(str)) {
                                QuantitySelectorWidget.this.offsetValue = Integer.parseInt(str);
                            }
                            if (QuantitySelectorWidget.this.offsetValue < 1) {
                                QuantitySelectorWidget.this.offsetValue = 1;
                            }
                            QuantitySelectorWidget.this.tvOffsetValue.setText(String.valueOf(QuantitySelectorWidget.this.offsetValue));
                            if (QuantitySelectorWidget.this.onValueChangeListener != null) {
                                QuantitySelectorWidget.this.onValueChangeListener.onValue(QuantitySelectorWidget.this.offsetValue);
                            }
                        }
                    };
                }
            });
        }
    }

    public int dip2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getOffsetValue() {
        return this.offsetValue;
    }

    public void setOffsetBigValue(int i5) {
        this.offsetBigValue = i5;
    }

    public void setOffsetValue(int i5) {
        this.offsetValue = i5;
        this.tvOffsetValue.setText(String.valueOf(i5));
    }

    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        this.onValueChangeListener = onValueChangeListener;
    }

    public QuantitySelectorWidget(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuantitySelectorWidget(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.offsetValue = 0;
        this.offsetValueInputType = false;
        this.offsetSmallValue = 0;
        this.offsetBigValue = 0;
        setGravity(17);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.QuantitySelectorWidgetStyle, i5, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == i.QuantitySelectorWidgetStyle_subtractId) {
                this.subtractId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
            } else if (index == i.QuantitySelectorWidgetStyle_addId) {
                this.addId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
            } else if (index == i.QuantitySelectorWidgetStyle_offsetValue) {
                this.offsetValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == i.QuantitySelectorWidgetStyle_offsetValueInputType) {
                this.offsetValueInputType = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == i.QuantitySelectorWidgetStyle_offsetSmallValue) {
                this.offsetSmallValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == i.QuantitySelectorWidgetStyle_offsetBigValue) {
                this.offsetBigValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == i.QuantitySelectorWidgetStyle_offsetBackground) {
                this.offsetBackground = getResources().getDrawable(typedArrayObtainStyledAttributes.getResourceId(index, p113u.c.layer_underline));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = LayoutInflater.from(context).inflate(e.widget_quantity_selector, (ViewGroup) this, false);
        addView(viewInflate);
        this.ivSubtract = (ImageView) viewInflate.findViewById(d.iv_subtract);
        this.tvOffsetValue = (TextView) viewInflate.findViewById(d.tv_offset_value);
        this.ivAdd = (ImageView) viewInflate.findViewById(d.iv_add);
        int i7 = this.subtractId;
        if (i7 != 0) {
            this.ivSubtract.setImageResource(i7);
        }
        int i8 = this.addId;
        if (i8 != 0) {
            this.ivAdd.setImageResource(i8);
        }
        this.tvOffsetValue.setText(String.valueOf(this.offsetValue));
        Drawable drawable = this.offsetBackground;
        if (drawable != null) {
            this.tvOffsetValue.setBackground(drawable);
        }
        initListener();
    }
}
