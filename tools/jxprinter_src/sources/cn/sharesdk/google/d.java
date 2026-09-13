package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    private static void b(Parcel parcel, int i5, int i6) {
        if (i6 < 65535) {
            parcel.writeInt(i5 | (i6 << 16));
        } else {
            parcel.writeInt(i5 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i6);
        }
    }

    private static void c(Parcel parcel, int i5) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(iDataPosition - i5);
        parcel.setDataPosition(iDataPosition);
    }

    public static void a(Parcel parcel, int i5) {
        c(parcel, i5);
    }

    public static void a(Parcel parcel, int i5, boolean z6) {
        b(parcel, i5, 4);
        parcel.writeInt(z6 ? 1 : 0);
    }

    private static int b(Parcel parcel, int i5) {
        parcel.writeInt(i5 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i5, int i6) {
        b(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void a(Parcel parcel, int i5, String str, boolean z6) {
        if (str == null) {
            if (z6) {
                b(parcel, i5, 0);
            }
        } else {
            int iB = b(parcel, i5);
            parcel.writeString(str);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i5, Parcelable parcelable, int i6, boolean z6) {
        if (parcelable == null) {
            if (z6) {
                b(parcel, i5, 0);
            }
        } else {
            int iB = b(parcel, i5);
            parcelable.writeToParcel(parcel, i6);
            c(parcel, iB);
        }
    }
}
