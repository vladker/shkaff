package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3309a;
    public final /* synthetic */ long b;

    public /* synthetic */ h(long j6, int i5) {
        this.f3309a = i5;
        this.b = j6;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f3309a) {
            case 0:
                return SQLiteEventStore.lambda$getTimeWindow$22(this.b, (SQLiteDatabase) obj);
            default:
                return SQLiteEventStore.lambda$getTimeWindow$21(this.b, (Cursor) obj);
        }
    }
}
