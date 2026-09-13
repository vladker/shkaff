package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import cn.sharesdk.framework.utils.SSDKLog;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class UserData {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Cover implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2245a = new a();
        private final Set<Integer> b;
        private final int c;
        private CoverInfo d;
        private CoverPhoto e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2246f;

        public Cover() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public CoverInfo c() {
            return this.d;
        }

        public CoverPhoto d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.f2246f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class CoverInfo implements Parcelable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f2247a = new a();
            private final Set<Integer> b;
            private final int c;
            private int d;
            private int e;

            public CoverInfo() {
                this.c = 1;
                this.b = new HashSet();
            }

            public Set<Integer> a() {
                return this.b;
            }

            public int b() {
                return this.c;
            }

            public int c() {
                return this.d;
            }

            public int d() {
                return this.e;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i5) {
                a.a(this, parcel, i5);
            }

            public CoverInfo(Set<Integer> set, int i5, int i6, int i7) {
                this.b = set;
                this.c = i5;
                this.d = i6;
                this.e = i7;
            }

            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public static class a implements Parcelable.Creator<CoverInfo> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverInfo createFromParcel(Parcel parcel) {
                    int iD;
                    int iD2;
                    HashSet hashSet = new HashSet();
                    int iD3 = 0;
                    try {
                        int iB = e.b(parcel);
                        iD = 0;
                        iD2 = 0;
                        while (parcel.dataPosition() < iB) {
                            try {
                                int iA = e.a(parcel);
                                int iA2 = e.a(iA);
                                if (iA2 == 1) {
                                    iD3 = e.d(parcel, iA);
                                    hashSet.add(1);
                                } else if (iA2 == 2) {
                                    iD = e.d(parcel, iA);
                                    hashSet.add(2);
                                } else if (iA2 != 3) {
                                    e.b(parcel, iA);
                                } else {
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(3);
                                }
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        }
                        if (parcel.dataPosition() != iB) {
                            try {
                                throw new Throwable("Overread allowed size end=" + iB);
                            } catch (Throwable th2) {
                                SSDKLog.b().a(th2);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iD = 0;
                        iD2 = 0;
                    }
                    return new CoverInfo(hashSet, iD3, iD, iD2);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverInfo[] newArray(int i5) {
                    return new CoverInfo[i5];
                }

                public static void a(CoverInfo coverInfo, Parcel parcel, int i5) {
                    int iA = d.a(parcel);
                    Set<Integer> setA = coverInfo.a();
                    if (setA.contains(1)) {
                        d.a(parcel, 1, coverInfo.b());
                    }
                    if (setA.contains(2)) {
                        d.a(parcel, 2, coverInfo.c());
                    }
                    if (setA.contains(3)) {
                        d.a(parcel, 3, coverInfo.d());
                    }
                    d.a(parcel, iA);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class CoverPhoto implements Parcelable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f2248a = new a();
            private final Set<Integer> b;
            private final int c;
            private int d;
            private String e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f2249f;

            public CoverPhoto() {
                this.c = 1;
                this.b = new HashSet();
            }

            public Set<Integer> a() {
                return this.b;
            }

            public int b() {
                return this.c;
            }

            public int c() {
                return this.d;
            }

            public String d() {
                return this.e;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int e() {
                return this.f2249f;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i5) {
                a.a(this, parcel, i5);
            }

            public CoverPhoto(Set<Integer> set, int i5, int i6, String str, int i7) {
                this.b = set;
                this.c = i5;
                this.d = i6;
                this.e = str;
                this.f2249f = i7;
            }

            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public static class a implements Parcelable.Creator<CoverPhoto> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverPhoto createFromParcel(Parcel parcel) {
                    Throwable th;
                    int iD;
                    String strE;
                    int iD2;
                    HashSet hashSet = new HashSet();
                    int iD3 = 0;
                    try {
                        int iB = e.b(parcel);
                        iD = 0;
                        strE = null;
                        iD2 = 0;
                        while (parcel.dataPosition() < iB) {
                            try {
                                int iA = e.a(parcel);
                                int iA2 = e.a(iA);
                                if (iA2 == 1) {
                                    iD3 = e.d(parcel, iA);
                                    hashSet.add(1);
                                } else if (iA2 == 2) {
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(2);
                                } else if (iA2 == 3) {
                                    strE = e.e(parcel, iA);
                                    hashSet.add(3);
                                } else if (iA2 != 4) {
                                    e.b(parcel, iA);
                                } else {
                                    iD = e.d(parcel, iA);
                                    hashSet.add(4);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                        if (parcel.dataPosition() != iB) {
                            try {
                                throw new Throwable("Overread allowed size end=" + iB);
                            } catch (Throwable th3) {
                                SSDKLog.b().a(th3);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        iD = 0;
                        strE = null;
                        iD2 = 0;
                    }
                    return new CoverPhoto(hashSet, iD3, iD2, strE, iD);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverPhoto[] newArray(int i5) {
                    return new CoverPhoto[i5];
                }

                public static void a(CoverPhoto coverPhoto, Parcel parcel, int i5) {
                    int iA = d.a(parcel);
                    Set<Integer> setA = coverPhoto.a();
                    if (setA.contains(1)) {
                        d.a(parcel, 1, coverPhoto.b());
                    }
                    if (setA.contains(2)) {
                        d.a(parcel, 2, coverPhoto.c());
                    }
                    if (setA.contains(3)) {
                        d.a(parcel, 3, coverPhoto.d(), true);
                    }
                    if (setA.contains(4)) {
                        d.a(parcel, 4, coverPhoto.e());
                    }
                    d.a(parcel, iA);
                }
            }
        }

        public Cover(Set<Integer> set, int i5, CoverInfo coverInfo, CoverPhoto coverPhoto, int i6) {
            this.b = set;
            this.c = i5;
            this.d = coverInfo;
            this.e = coverPhoto;
            this.f2246f = i6;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Cover> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Cover createFromParcel(Parcel parcel) {
                Throwable th;
                CoverInfo coverInfo;
                CoverPhoto coverPhoto;
                int iD;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    coverInfo = null;
                    coverPhoto = null;
                    iD = 0;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 != 1) {
                                if (iA2 == 2) {
                                    CoverInfo coverInfo2 = (CoverInfo) e.a(parcel, iA, CoverInfo.f2247a);
                                    try {
                                        hashSet.add(2);
                                        coverInfo = coverInfo2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        coverInfo = coverInfo2;
                                        th.printStackTrace();
                                        return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                                    }
                                } else if (iA2 == 3) {
                                    CoverPhoto coverPhoto2 = (CoverPhoto) e.a(parcel, iA, CoverPhoto.f2248a);
                                    try {
                                        hashSet.add(3);
                                        coverPhoto = coverPhoto2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        coverPhoto = coverPhoto2;
                                        th.printStackTrace();
                                        return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                                    }
                                } else if (iA2 != 4) {
                                    e.b(parcel, iA);
                                } else {
                                    iD = e.d(parcel, iA);
                                    hashSet.add(4);
                                }
                                return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                            }
                            iD2 = e.d(parcel, iA);
                            hashSet.add(1);
                        } catch (Throwable th4) {
                            th = th4;
                            th.printStackTrace();
                            return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th5) {
                            SSDKLog.b().a(th5);
                            return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    coverInfo = null;
                    coverPhoto = null;
                    iD = 0;
                }
                return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Cover[] newArray(int i5) {
                return new Cover[i5];
            }

            public static void a(Cover cover, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = cover.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, cover.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, cover.c(), i5, true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, cover.d(), i5, true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, cover.e());
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AgeRange implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2244a = new a();
        private final Set<Integer> b;
        private final int c;
        private int d;
        private int e;

        public AgeRange() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public AgeRange(Set<Integer> set, int i5, int i6, int i7) {
            this.b = set;
            this.c = i5;
            this.d = i6;
            this.e = i7;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<AgeRange> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AgeRange createFromParcel(Parcel parcel) {
                int iD;
                int iD2;
                HashSet hashSet = new HashSet();
                int iD3 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    iD2 = 0;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD3 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                iD = e.d(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 != 3) {
                                e.b(parcel, iA);
                            } else {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(3);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    iD2 = 0;
                }
                return new AgeRange(hashSet, iD3, iD, iD2);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AgeRange[] newArray(int i5) {
                return new AgeRange[i5];
            }

            public static void a(AgeRange ageRange, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = ageRange.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, ageRange.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, ageRange.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, ageRange.d());
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Emails implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2250a = new a();
        private final Set<Integer> b;
        private final int c;
        private boolean d;
        private int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2251f;

        public Emails() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public boolean c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f2251f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public Emails(Set<Integer> set, int i5, boolean z6, int i6, String str) {
            this.b = set;
            this.c = i5;
            this.d = z6;
            this.e = i6;
            this.f2251f = str;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Emails> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Emails createFromParcel(Parcel parcel) {
                Throwable th;
                int iD;
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 == 3) {
                                iD = e.d(parcel, iA);
                                hashSet.add(3);
                            } else if (iA2 != 4) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(4);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th3) {
                            SSDKLog.b().a(th3);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    iD = 0;
                    strE = null;
                    zC = false;
                }
                return new Emails(hashSet, iD2, zC, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Emails[] newArray(int i5) {
                return new Emails[i5];
            }

            public static void a(Emails emails, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = emails.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, emails.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, emails.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, emails.d());
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, emails.e(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Image implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2252a = new a();
        private final Set<Integer> b;
        private final int c;
        private String d;

        public Image() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public Image(Set<Integer> set, int i5, String str) {
            this.b = set;
            this.c = i5;
            this.d = str;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Image> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Image createFromParcel(Parcel parcel) {
                HashSet hashSet = new HashSet();
                int iD = 0;
                String strE = null;
                try {
                    int iB = e.b(parcel);
                    while (parcel.dataPosition() < iB) {
                        int iA = e.a(parcel);
                        int iA2 = e.a(iA);
                        if (iA2 == 1) {
                            iD = e.d(parcel, iA);
                            hashSet.add(1);
                        } else if (iA2 != 2) {
                            e.b(parcel, iA);
                        } else {
                            strE = e.e(parcel, iA);
                            hashSet.add(2);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return new Image(hashSet, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Image[] newArray(int i5) {
                return new Image[i5];
            }

            public static void a(Image image, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = image.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, image.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, image.c(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Name implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2253a = new a();
        private final Set<Integer> b;
        private final int c;
        private String d;
        private String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2255g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f2256h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f2257i;

        public Name() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f2254f;
        }

        public String f() {
            return this.f2255g;
        }

        public String g() {
            return this.f2256h;
        }

        public String h() {
            return this.f2257i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public Name(Set<Integer> set, int i5, String str, String str2, String str3, String str4, String str5, String str6) {
            this.b = set;
            this.c = i5;
            this.d = str;
            this.e = str2;
            this.f2254f = str3;
            this.f2255g = str4;
            this.f2256h = str5;
            this.f2257i = str6;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Name> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Name createFromParcel(Parcel parcel) {
                Throwable th;
                String strE;
                String strE2;
                String strE3;
                String strE4;
                String strE5;
                HashSet hashSet = new HashSet();
                int iD = 0;
                String strE6 = null;
                try {
                    int iB = e.b(parcel);
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            switch (e.a(iA)) {
                                case 1:
                                    iD = e.d(parcel, iA);
                                    hashSet.add(1);
                                    break;
                                case 2:
                                    strE6 = e.e(parcel, iA);
                                    hashSet.add(2);
                                    break;
                                case 3:
                                    strE = e.e(parcel, iA);
                                    hashSet.add(3);
                                    break;
                                case 4:
                                    strE2 = e.e(parcel, iA);
                                    hashSet.add(4);
                                    break;
                                case 5:
                                    strE3 = e.e(parcel, iA);
                                    hashSet.add(5);
                                    break;
                                case 6:
                                    strE4 = e.e(parcel, iA);
                                    hashSet.add(6);
                                    break;
                                case 7:
                                    strE5 = e.e(parcel, iA);
                                    hashSet.add(7);
                                    break;
                                default:
                                    e.b(parcel, iA);
                                    break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            return new Name(hashSet, iD, strE6, strE, strE2, strE3, strE4, strE5);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th3) {
                            SSDKLog.b().a(th3);
                            return new Name(hashSet, iD, strE6, strE, strE2, strE3, strE4, strE5);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                }
                return new Name(hashSet, iD, strE6, strE, strE2, strE3, strE4, strE5);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Name[] newArray(int i5) {
                return new Name[i5];
            }

            public static void a(Name name, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = name.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, name.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, name.c(), true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, name.d(), true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, name.e(), true);
                }
                if (setA.contains(5)) {
                    d.a(parcel, 5, name.f(), true);
                }
                if (setA.contains(6)) {
                    d.a(parcel, 6, name.g(), true);
                }
                if (setA.contains(7)) {
                    d.a(parcel, 7, name.h(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Organizations implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2258a = new a();
        private final Set<Integer> b;
        private final int c;
        private String d;
        private String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2259f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2260g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f2261h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f2262i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f2263j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f2264k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2265l;

        public Organizations() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f2259f;
        }

        public String f() {
            return this.f2260g;
        }

        public String g() {
            return this.f2261h;
        }

        public boolean h() {
            return this.f2262i;
        }

        public String i() {
            return this.f2263j;
        }

        public String j() {
            return this.f2264k;
        }

        public int k() {
            return this.f2265l;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public Organizations(Set<Integer> set, int i5, String str, String str2, String str3, String str4, String str5, boolean z6, String str6, String str7, int i6) {
            this.b = set;
            this.c = i5;
            this.d = str;
            this.e = str2;
            this.f2259f = str3;
            this.f2260g = str4;
            this.f2261h = str5;
            this.f2262i = z6;
            this.f2263j = str6;
            this.f2264k = str7;
            this.f2265l = i6;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Organizations> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Organizations createFromParcel(Parcel parcel) {
                int iD;
                String strE;
                String strE2;
                String strE3;
                String strE4;
                String strE5;
                String strE6;
                String strE7;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    strE6 = null;
                    strE7 = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            switch (e.a(iA)) {
                                case 1:
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(1);
                                    break;
                                case 2:
                                    strE = e.e(parcel, iA);
                                    hashSet.add(2);
                                    break;
                                case 3:
                                    strE2 = e.e(parcel, iA);
                                    hashSet.add(3);
                                    break;
                                case 4:
                                    strE3 = e.e(parcel, iA);
                                    hashSet.add(4);
                                    break;
                                case 5:
                                    strE4 = e.e(parcel, iA);
                                    hashSet.add(5);
                                    break;
                                case 6:
                                    strE5 = e.e(parcel, iA);
                                    hashSet.add(6);
                                    break;
                                case 7:
                                    zC = e.c(parcel, iA);
                                    hashSet.add(7);
                                    break;
                                case 8:
                                    strE6 = e.e(parcel, iA);
                                    hashSet.add(8);
                                    break;
                                case 9:
                                    strE7 = e.e(parcel, iA);
                                    hashSet.add(9);
                                    break;
                                case 10:
                                    iD = e.d(parcel, iA);
                                    hashSet.add(10);
                                    break;
                                default:
                                    e.b(parcel, iA);
                                    break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new Organizations(hashSet, iD2, strE, strE2, strE3, strE4, strE5, zC, strE6, strE7, iD);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                            return new Organizations(hashSet, iD2, strE, strE2, strE3, strE4, strE5, zC, strE6, strE7, iD);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    strE6 = null;
                    strE7 = null;
                    zC = false;
                }
                return new Organizations(hashSet, iD2, strE, strE2, strE3, strE4, strE5, zC, strE6, strE7, iD);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Organizations[] newArray(int i5) {
                return new Organizations[i5];
            }

            public static void a(Organizations organizations, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = organizations.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, organizations.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, organizations.c(), true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, organizations.d(), true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, organizations.e(), true);
                }
                if (setA.contains(5)) {
                    d.a(parcel, 5, organizations.f(), true);
                }
                if (setA.contains(6)) {
                    d.a(parcel, 6, organizations.g(), true);
                }
                if (setA.contains(7)) {
                    d.a(parcel, 7, organizations.h());
                }
                if (setA.contains(8)) {
                    d.a(parcel, 8, organizations.i(), true);
                }
                if (setA.contains(9)) {
                    d.a(parcel, 9, organizations.j(), true);
                }
                if (setA.contains(10)) {
                    d.a(parcel, 10, organizations.k());
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlacesLived implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2266a = new a();
        private final Set<Integer> b;
        private final int c;
        private boolean d;
        private String e;

        public PlacesLived() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public boolean c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public PlacesLived(Set<Integer> set, int i5, boolean z6, String str) {
            this.b = set;
            this.c = i5;
            this.d = z6;
            this.e = str;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<PlacesLived> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PlacesLived createFromParcel(Parcel parcel) {
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD = 0;
                try {
                    int iB = e.b(parcel);
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 != 3) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(3);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    strE = null;
                    zC = false;
                }
                return new PlacesLived(hashSet, iD, zC, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PlacesLived[] newArray(int i5) {
                return new PlacesLived[i5];
            }

            public static void a(PlacesLived placesLived, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = placesLived.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, placesLived.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, placesLived.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, placesLived.d(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Urls implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2267a = new a();
        private final Set<Integer> b;
        private final int c;
        private boolean d;
        private int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2268f;

        public Urls() {
            this.c = 1;
            this.b = new HashSet();
        }

        public Set<Integer> a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public boolean c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f2268f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            a.a(this, parcel, i5);
        }

        public Urls(Set<Integer> set, int i5, boolean z6, int i6, String str) {
            this.b = set;
            this.c = i5;
            this.d = z6;
            this.e = i6;
            this.f2268f = str;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class a implements Parcelable.Creator<Urls> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Urls createFromParcel(Parcel parcel) {
                Throwable th;
                int iD;
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 == 3) {
                                iD = e.d(parcel, iA);
                                hashSet.add(3);
                            } else if (iA2 != 4) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(4);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th3) {
                            SSDKLog.b().a(th3);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    iD = 0;
                    strE = null;
                    zC = false;
                }
                return new Urls(hashSet, iD2, zC, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Urls[] newArray(int i5) {
                return new Urls[i5];
            }

            public static void a(Urls urls, Parcel parcel, int i5) {
                int iA = d.a(parcel);
                Set<Integer> setA = urls.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, urls.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, urls.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, urls.d());
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, urls.e(), true);
                }
                d.a(parcel, iA);
            }
        }
    }
}
