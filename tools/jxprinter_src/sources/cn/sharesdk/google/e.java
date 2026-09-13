package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int a(int i5) {
        return i5 & 65535;
    }

    public static void b(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i5));
    }

    public static boolean c(Parcel parcel, int i5) throws Throwable {
        a(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static int d(Parcel parcel, int i5) throws Throwable {
        a(parcel, i5, 4);
        return parcel.readInt();
    }

    public static String e(Parcel parcel, int i5) {
        int iA = a(parcel, i5);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iA);
        return string;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i5) {
        return (i5 & SupportMenu.CATEGORY_MASK) != -65536 ? (i5 >> 16) & 65535 : parcel.readInt();
    }

    public static int b(Parcel parcel) throws Throwable {
        int iA = a(parcel);
        int iA2 = a(parcel, iA);
        int iDataPosition = parcel.dataPosition();
        if (a(iA) == 20293) {
            int i5 = iA2 + iDataPosition;
            if (i5 < iDataPosition || i5 > parcel.dataSize()) {
                throw new Throwable(androidx.collection.a.h(iDataPosition, i5, "Size read is invalid start=", " end="));
            }
            return i5;
        }
        throw new Throwable("Expected object header. Got 0x" + Integer.toHexString(iA));
    }

    private static void a(Parcel parcel, int i5, int i6) throws Throwable {
        int iA = a(parcel, i5);
        if (iA == i6) {
            return;
        }
        StringBuilder sbS = androidx.collection.a.s("Expected size ", i6, iA, " got ", " (0x");
        sbS.append(Integer.toHexString(iA));
        sbS.append(")");
        throw new Throwable(sbS.toString());
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i5);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iA);
        return tCreateFromParcel;
    }

    public static <T> ArrayList<T> b(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i5);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iA);
        return arrayListCreateTypedArrayList;
    }
}
