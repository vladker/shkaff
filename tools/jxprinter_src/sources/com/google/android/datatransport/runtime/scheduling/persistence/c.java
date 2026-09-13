package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3304a;
    public final /* synthetic */ SQLiteEventStore b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(SQLiteEventStore sQLiteEventStore, Object obj, int i5) {
        this.f3304a = i5;
        this.b = sQLiteEventStore;
        this.c = obj;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f3304a) {
            case 0:
                return this.b.lambda$hasPendingEventsFor$6((TransportContext) this.c, (SQLiteDatabase) obj);
            case 1:
                return this.b.lambda$loadBatch$8((TransportContext) this.c, (SQLiteDatabase) obj);
            default:
                return this.b.lambda$recordFailure$4((String) this.c, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", (SQLiteDatabase) obj);
        }
    }
}
