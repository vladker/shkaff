package com.google.mlkit.vision.text.pipeline;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaaj;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpb;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbf {
    public static Rect zba(List list, @Nullable Matrix matrix) {
        Iterator it = list.iterator();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        RectF rectF = new RectF(iMin, iMin2, iMax, iMax2);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    public static zbpb zbb(zbaaj zbaajVar) {
        if (zbaajVar.zbi()) {
            return zbaajVar.zbc().zbd();
        }
        return zbaajVar.zbH() ? zbaajVar.zbf().zbc() : zbaajVar.zbe();
    }

    public static List zbc(zbpb zbpbVar) {
        double dSin = Math.sin(Math.toRadians(zbpbVar.zba()));
        double dCos = Math.cos(Math.toRadians(zbpbVar.zba()));
        Point point = new Point((int) (((double) zbpbVar.zbd()) + (((double) zbpbVar.zbf()) * dCos)), (int) ((((double) zbpbVar.zbf()) * dSin) + ((double) zbpbVar.zbe())));
        double d = point.x;
        double dZbc = ((double) zbpbVar.zbc()) * dSin;
        double dZbc2 = (((double) zbpbVar.zbc()) * dCos) + ((double) pointArr[1].y);
        Point point2 = pointArr[0];
        int i5 = point2.x;
        Point point3 = pointArr[2];
        int i6 = point3.x;
        Point point4 = pointArr[1];
        Point[] pointArr = {new Point(zbpbVar.zbd(), zbpbVar.zbe()), point, new Point((int) (d - dZbc), (int) dZbc2), new Point((i6 - point4.x) + i5, (point3.y - point4.y) + point2.y)};
        return Arrays.asList(pointArr);
    }
}
