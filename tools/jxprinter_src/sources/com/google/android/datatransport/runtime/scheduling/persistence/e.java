package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3306a;
    public final /* synthetic */ SQLiteEventStore b;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore, int i5) {
        this.f3306a = i5;
        this.b = sQLiteEventStore;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f3306a) {
            case 0:
                return this.b.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
            case 1:
                return this.b.lambda$cleanUp$11((Cursor) obj);
            default:
                return this.b.lambda$recordFailure$3((Cursor) obj);
        }
    }
}
