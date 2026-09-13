package com.bumptech.glide;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.appdev.standard.model.TextFontModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements k {
    public static String a(long j6, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            Date date = new Date();
            date.setTime(j6);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ArrayList b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_424), "", "0", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_425), "", "-10001", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_426), "", "-10002", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_427), "", "-10003", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_428), "", "-10004", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_429), "", "-10005", false));
        arrayList.add(new TextFontModel(context.getString(p113u.g.text_430), "", "-10006", false));
        return arrayList;
    }

    public static boolean c(String str) {
        return (str.equals(ShareTarget.METHOD_GET) || str.equals("HEAD")) ? false : true;
    }

    public static double d(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, int i5) {
        double d;
        for (int i6 = 0; i6 < i5; i6++) {
            dArr4[i6] = dArr2[i6] - dArr[i6];
        }
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (int i7 = 0; i7 < i5; i7++) {
            double d8 = dArr4[i7];
            d7 += d8 * d8;
        }
        if (d7 != 0.0d) {
            double dA = 0.0d;
            for (int i8 = 0; i8 < i5; i8++) {
                dA = androidx.collection.a.a(dArr3[i8], dArr[i8], dArr4[i8], dA);
            }
            d = dA / d7;
        } else {
            d = 0.0d;
        }
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        for (int i9 = 0; i9 < i5; i9++) {
            dArr4[i9] = (dArr4[i9] * d) + dArr[i9];
        }
        dArr4[i5] = d;
        for (int i10 = 0; i10 < i5; i10++) {
            double d9 = dArr3[i10] - dArr4[i10];
            d6 += d9 * d9;
        }
        return d6;
    }
}
