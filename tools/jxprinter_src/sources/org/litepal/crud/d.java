package org.litepal.crud;

import A3.AbstractC0157z;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.opencv.videoio.Videoio;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends c {
    public d(SQLiteDatabase sQLiteDatabase) {
        this.f7678g = sQLiteDatabase;
    }

    public ArrayList A(Class cls, String[] strArr, String[] strArr2, String str, String str2) {
        String strA;
        AbstractC1282k.b(strArr2);
        int i5 = 0;
        if (strArr2 != null && strArr2.length > 0) {
            strArr2[0] = J.c(strArr2[0]);
        }
        if (TextUtils.isEmpty(str)) {
            strA = null;
        } else {
            String lowerCase = str.trim().toLowerCase(Locale.US);
            if (lowerCase.contains(",")) {
                String[] strArrSplit = lowerCase.split(",");
                StringBuilder sb = new StringBuilder();
                int length = strArrSplit.length;
                boolean z6 = false;
                while (i5 < length) {
                    String str3 = strArrSplit[i5];
                    if (z6) {
                        sb.append(",");
                    }
                    sb.append(J.a(str3));
                    i5++;
                    z6 = true;
                }
                strA = sb.toString();
            } else {
                strA = J.a(lowerCase);
            }
        }
        return y(cls, strArr, c.x(strArr2), c.w(strArr2), strA, str2, null);
    }

    public int z(f fVar) {
        f associatedModel;
        int i5;
        int i6;
        int i7 = 0;
        if (!fVar.isSaved()) {
            return 0;
        }
        List listH = h(fVar.getClassName());
        Class<?> cls = fVar.getClass();
        long[] jArr = {fVar.getBaseObjId()};
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            String strF = J.f(cls.getName(), ((Field) it.next()).getName());
            String strG = J.g(cls.getName());
            int i8 = i7;
            while (i8 <= 0) {
                StringBuilder sb = new StringBuilder();
                int i9 = Videoio.CAP_QT;
                int i10 = Videoio.CAP_QT * i8;
                int i11 = i7;
                while (true) {
                    i5 = i8 + 1;
                    i6 = i7;
                    if (i10 >= i9 * i5 || i10 >= 1) {
                        break;
                    }
                    int i12 = i10;
                    long j6 = jArr[i12];
                    if (i11 != 0) {
                        sb.append(" or ");
                    }
                    sb.append(strG);
                    sb.append(" = ");
                    sb.append(j6);
                    i10 = i12 + 1;
                    i11 = 1;
                    i7 = i6;
                    i9 = Videoio.CAP_QT;
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    this.f7678g.delete(strF, sb.toString(), null);
                }
                i8 = i5;
                i7 = i6;
            }
        }
        int iDelete = i7;
        try {
            Collection collectionD = d(fVar.getClassName());
            c.n(fVar, collectionD);
            int iDelete2 = iDelete;
            for (String str : fVar.getAssociatedModelsMapWithFK().keySet()) {
                String strE = Z4.a.e(fVar.getTableName());
                SQLiteDatabase sQLiteDatabase = this.f7678g;
                StringBuilder sbX = AbstractC0157z.x(strE, " = ");
                sbX.append(fVar.getBaseObjId());
                iDelete2 += sQLiteDatabase.delete(str, sbX.toString(), null);
            }
            Iterator<String> it2 = fVar.getAssociatedModelsMapForJoinTable().keySet().iterator();
            while (it2.hasNext()) {
                String strI = J.i(fVar.getTableName(), it2.next());
                String strE2 = Z4.a.e(fVar.getTableName());
                SQLiteDatabase sQLiteDatabase2 = this.f7678g;
                StringBuilder sbX2 = AbstractC0157z.x(strE2, " = ");
                sbX2.append(fVar.getBaseObjId());
                iDelete = sQLiteDatabase2.delete(strI, sbX2.toString(), null) + iDelete;
            }
            int iDelete3 = this.f7678g.delete(fVar.getTableName(), "id = " + fVar.getBaseObjId(), null) + iDelete2 + iDelete;
            try {
                for (p019c5.a aVar : (HashSet) collectionD) {
                    if (aVar.f1192f == 2 && !fVar.getClassName().equals(aVar.c)) {
                        Collection<f> associatedModels = getAssociatedModels(fVar, aVar);
                        if (associatedModels != null && !associatedModels.isEmpty()) {
                            for (f fVar2 : associatedModels) {
                                if (fVar2 != null) {
                                    fVar2.clearSavedState();
                                }
                            }
                        }
                    } else if (aVar.f1192f == 1 && (associatedModel = getAssociatedModel(fVar, aVar)) != null) {
                        associatedModel.clearSavedState();
                    }
                }
                return iDelete3;
            } catch (Exception e) {
                throw new p024d5.e(e.getMessage(), e);
            }
        } catch (Exception e6) {
            throw new p024d5.e(e6.getMessage(), e6);
        }
    }
}
