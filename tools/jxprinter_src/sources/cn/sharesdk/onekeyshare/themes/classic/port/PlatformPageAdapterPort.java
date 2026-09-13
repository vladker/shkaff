package cn.sharesdk.onekeyshare.themes.classic.port;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class PlatformPageAdapterPort extends PlatformPageAdapter {
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_P = 720;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;
    private static final int LINE_SIZE_P = 4;
    private static final int PAGE_SIZE_P = 12;

    public PlatformPageAdapterPort(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        this.lineSize = 4;
        float f6 = screenWidth / 720.0f;
        int i5 = (int) (1.0f * f6);
        this.sepLineWidth = i5;
        if (i5 < 1) {
            i5 = 1;
        }
        this.sepLineWidth = i5;
        this.logoHeight = (int) (76.0f * f6);
        this.paddingTop = (int) (20.0f * f6);
        this.bottomHeight = (int) (f6 * 52.0f);
        this.cellHeight = (screenWidth - (i5 * 3)) / 4;
        if (arrayList.size() <= this.lineSize) {
            this.panelHeight = this.cellHeight + this.sepLineWidth;
        } else if (arrayList.size() <= 12 - this.lineSize) {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 2;
        } else {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 3;
        }
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        if (size < 12) {
            int i5 = this.lineSize;
            int i6 = size / i5;
            if (size % i5 != 0) {
                i6++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, 1, i6 * i5);
        } else {
            int i7 = size / 12;
            if (size % 12 != 0) {
                i7++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, i7, 12);
        }
        for (int i8 = 0; i8 < size; i8++) {
            int i9 = i8 / 12;
            this.cells[i9][i8 - (i9 * 12)] = arrayList.get(i8);
        }
    }
}
