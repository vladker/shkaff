package com.appdev.standard.page.printerlabel.widget;

import android.view.View;
import android.widget.RelativeLayout;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Y;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IDTControlView extends BaseControlView {
    private long baseLongS;
    protected String content;
    private String formatContent;
    protected int inputDataType;
    protected int interval;
    protected String prefix;
    private String saveContent;
    protected String suffix;
    protected String timeFormat;
    protected int timeOffsetDay;
    protected int timeOffsetHour;
    protected int timeOffsetMinute;
    protected int timeOffsetMonth;
    protected int timeOffsetSecond;
    protected int timeOffsetYear;
    protected int timeType;

    public IDTControlView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.interval = 1;
        this.inputDataType = 0;
        this.prefix = "";
        this.suffix = "";
        this.timeType = 0;
        this.timeFormat = "yyyy/MM/dd";
        this.timeOffsetYear = 0;
        this.timeOffsetMonth = 0;
        this.timeOffsetDay = 0;
        this.timeOffsetHour = 0;
        this.timeOffsetMinute = 0;
        this.timeOffsetSecond = 0;
        this.saveContent = "";
        this.formatContent = "";
        this.baseLongS = -1L;
    }

    public abstract String getControlViewContent();

    public int getInputDataType() {
        return this.inputDataType;
    }

    public int getInterval() {
        return this.interval;
    }

    public boolean hasTransmutationContent() {
        String controlViewContent = getControlViewContent();
        for (int length = controlViewContent.length() - 1; length >= 0; length--) {
            if (Character.isDigit(controlViewContent.charAt(length))) {
                return true;
            }
        }
        return false;
    }

    public void initIntervalContent() {
        int i5;
        String controlViewContent = getControlViewContent();
        this.saveContent = controlViewContent;
        if (Y.f(controlViewContent)) {
            this.formatContent = "";
            return;
        }
        for (int length = this.saveContent.length() - 1; length >= 0; length--) {
            if (Character.isDigit(this.saveContent.charAt(length))) {
                int length2 = this.saveContent.length() - 1;
                int i6 = -1;
                while (true) {
                    if (length2 < 0) {
                        i5 = -1;
                        break;
                    }
                    if (!Character.isDigit(this.saveContent.charAt(length2))) {
                        if (i6 != -1) {
                            i5 = length2 + 1;
                            break;
                        }
                    } else if (i6 == -1) {
                        i6 = length2 + 1;
                    }
                    length2--;
                }
                if (i6 != -1 && i5 == -1) {
                    i5 = 0;
                }
                int i7 = i6 - i5;
                if (i6 == -1 && i5 == -1) {
                    this.formatContent = "";
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.saveContent.substring(0, i5));
                sb.append("%0");
                sb.append(i7);
                sb.append("d");
                this.formatContent = androidx.exifinterface.media.a.j(this.saveContent, i6, sb);
                this.baseLongS = Y.i(this.saveContent.substring(i5, i6));
                return;
            }
        }
        this.formatContent = this.saveContent;
    }

    public void intervalContent(final int i5) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.IDTControlView.2
            @Override // java.lang.Runnable
            public void run() {
                IDTControlView.this.intervalContentInMainThread(i5);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void intervalContentInMainThread(int i5) {
        if (Y.f(this.formatContent)) {
            initIntervalContent();
        }
        if (Y.f(this.formatContent)) {
            setControlViewContent(getResources().getString(g.hint_20));
        } else {
            try {
                setControlViewContent(String.format(this.formatContent, Long.valueOf(this.baseLongS + ((long) (i5 * this.interval)))));
            } catch (Exception unused) {
                setControlViewContent(this.formatContent);
            }
        }
        int left = this.mRoot.getLeft();
        int top = this.mRoot.getTop();
        this.mRoot.measure(View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgHeight(), Integer.MIN_VALUE));
        RelativeLayout relativeLayout = this.mRoot;
        relativeLayout.layout(left, top, relativeLayout.getMeasuredWidth() + left, this.mRoot.getMeasuredHeight() + top);
    }

    public void resetContent() {
        setControlViewContent(this.saveContent);
    }

    public abstract void setControlViewContent(String str);

    public void setDataInputType(int i5) {
        this.inputDataType = i5;
    }

    public void setInterval(final int i5) {
        runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.widget.IDTControlView.1
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                IDTControlView iDTControlView = IDTControlView.this;
                iDTControlView.interval = i5;
                iDTControlView.updateView();
            }
        });
    }
}
