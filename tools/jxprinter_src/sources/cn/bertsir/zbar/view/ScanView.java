package cn.bertsir.zbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ScanView extends FrameLayout {
    private int CURRENT_TYEP;
    private CornerView cnv_left_bottom;
    private CornerView cnv_left_top;
    private CornerView cnv_right_bottom;
    private CornerView cnv_right_top;
    private ArrayList<CornerView> cornerViews;
    private FrameLayout fl_scan;
    private ScanLineView iv_scan_line;
    private int line_speed;

    public ScanView(Context context) {
        super(context);
        this.CURRENT_TYEP = 1;
        this.line_speed = 3000;
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = View.inflate(context, R.layout.view_scan, this);
        this.cnv_left_top = (CornerView) viewInflate.findViewById(R.id.cnv_left_top);
        this.cnv_left_bottom = (CornerView) viewInflate.findViewById(R.id.cnv_left_bottom);
        this.cnv_right_top = (CornerView) viewInflate.findViewById(R.id.cnv_right_top);
        this.cnv_right_bottom = (CornerView) viewInflate.findViewById(R.id.cnv_right_bottom);
        ArrayList<CornerView> arrayList = new ArrayList<>();
        this.cornerViews = arrayList;
        arrayList.add(this.cnv_left_top);
        this.cornerViews.add(this.cnv_left_bottom);
        this.cornerViews.add(this.cnv_right_top);
        this.cornerViews.add(this.cnv_right_bottom);
        this.iv_scan_line = (ScanLineView) viewInflate.findViewById(R.id.iv_scan_line);
        this.fl_scan = (FrameLayout) viewInflate.findViewById(R.id.fl_scan);
        getViewWidthHeight();
    }

    public int dip2px(int i5) {
        return (int) (((double) (i5 * getContext().getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public void getViewWidthHeight() {
        this.fl_scan.post(new Runnable() { // from class: cn.bertsir.zbar.view.ScanView.1
            @Override // java.lang.Runnable
            public void run() {
                Symbol.cropWidth = ScanView.this.fl_scan.getWidth();
                Symbol.cropHeight = ScanView.this.fl_scan.getHeight();
            }
        });
    }

    public void setCornerColor(int i5) {
        for (int i6 = 0; i6 < this.cornerViews.size(); i6++) {
            this.cornerViews.get(i6).setColor(i5);
        }
    }

    public void setCornerWidth(int i5) {
        for (int i6 = 0; i6 < this.cornerViews.size(); i6++) {
            this.cornerViews.get(i6).setLineWidth(i5);
        }
    }

    public void setLineColor(int i5) {
        this.iv_scan_line.setScancolor(i5);
    }

    public void setLineSpeed(int i5) {
        this.iv_scan_line.setScanAnimatorDuration(i5);
    }

    public void setScanLineStyle(int i5) {
        this.iv_scan_line.setScanStyle(i5);
    }

    public void setType(int i5) {
        this.CURRENT_TYEP = i5;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fl_scan.getLayoutParams();
        int i6 = this.CURRENT_TYEP;
        if (i6 == 1) {
            layoutParams.width = dip2px(200);
            layoutParams.height = dip2px(200);
        } else if (i6 == 2) {
            layoutParams.width = dip2px(300);
            layoutParams.height = dip2px(100);
        }
        this.fl_scan.setLayoutParams(layoutParams);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CURRENT_TYEP = 1;
        this.line_speed = 3000;
        initView(context);
    }

    public ScanView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.CURRENT_TYEP = 1;
        this.line_speed = 3000;
        initView(context);
    }
}
