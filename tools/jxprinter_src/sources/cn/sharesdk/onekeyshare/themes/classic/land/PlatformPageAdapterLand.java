package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class PlatformPageAdapterLand extends PlatformPageAdapter {
    private static final int DESIGN_CELL_WIDTH_L = 160;
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_L = 1280;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;

    public PlatformPageAdapterLand(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        float f6 = screenWidth / 1280.0f;
        int i5 = screenWidth / ((int) (160.0f * f6));
        this.lineSize = i5;
        int i6 = (int) (1.0f * f6);
        this.sepLineWidth = i6;
        if (i6 < 1) {
            i6 = 1;
        }
        this.sepLineWidth = i6;
        this.logoHeight = (int) (76.0f * f6);
        this.paddingTop = (int) (20.0f * f6);
        this.bottomHeight = (int) (f6 * 52.0f);
        int i7 = (screenWidth - (i6 * 3)) / (i5 - 1);
        this.cellHeight = i7;
        this.panelHeight = i7 + i6;
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        int i5 = this.lineSize;
        if (size < i5) {
            int i6 = size / i5;
            if (size % i5 != 0) {
                i6++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, 1, i6 * i5);
        } else {
            int i7 = size / i5;
            if (size % i5 != 0) {
                i7++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, i7, i5);
        }
        for (int i8 = 0; i8 < size; i8++) {
            int i9 = this.lineSize;
            int i10 = i8 / i9;
            this.cells[i10][i8 - (i9 * i10)] = arrayList.get(i8);
        }
    }
}
