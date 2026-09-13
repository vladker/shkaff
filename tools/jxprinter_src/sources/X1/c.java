package X1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public a b;
    public HashMap c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f836a = new HashSet();
    public String d = "";
    public String e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f837f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f838g = "";

    public static c open(File file) {
        return open(new FileInputStream(file));
    }

    private void readDirTabs() throws EOFException {
        this.b.readTTFLong();
        int tTFUShort = this.b.readTTFUShort();
        this.b.skip(6L);
        this.c = new HashMap();
        b[] bVarArr = new b[tTFUShort];
        for (int i5 = 0; i5 < tTFUShort; i5++) {
            b bVar = new b();
            bVarArr[i5] = bVar;
            String str = bVar.read(this.b);
            HashMap map = this.c;
            if (str == null) {
                throw new IllegalArgumentException("A TrueType font table name must not be null");
            }
            map.put(new d(str), bVarArr[i5]);
        }
        HashMap map2 = this.c;
        int i6 = this.b.b;
        map2.put(d.b, new b(0));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    private void readName() throws EOFException {
        seekTab(this.b, d.c, 2L);
        a aVar = this.b;
        int i5 = aVar.b;
        int tTFUShort = aVar.readTTFUShort();
        int tTFUShort2 = (this.b.readTTFUShort() + i5) - 2;
        int i6 = i5 + 4;
        while (true) {
            int i7 = tTFUShort - 1;
            if (tTFUShort <= 0) {
                return;
            }
            this.b.seekSet(i6);
            int tTFUShort3 = this.b.readTTFUShort();
            int tTFUShort4 = this.b.readTTFUShort();
            int tTFUShort5 = this.b.readTTFUShort();
            int tTFUShort6 = this.b.readTTFUShort();
            int tTFUShort7 = this.b.readTTFUShort();
            if ((tTFUShort3 == 1 || tTFUShort3 == 3) && (tTFUShort4 == 0 || tTFUShort4 == 1)) {
                a aVar2 = this.b;
                aVar2.seekSet(aVar2.readTTFUShort() + tTFUShort2);
                String tTFString = tTFUShort3 == 3 ? this.b.readTTFString(tTFUShort7, tTFUShort4) : this.b.readTTFString(tTFUShort7);
                if (tTFUShort6 != 0) {
                    if (tTFUShort6 == 1) {
                        this.f836a.add(tTFString);
                    } else if (tTFUShort6 != 2) {
                        if (tTFUShort6 != 4) {
                            if (tTFUShort6 != 6) {
                                if (tTFUShort6 == 16) {
                                    this.f836a.add(tTFString);
                                }
                            } else if (this.d.length() == 0) {
                                this.d = tTFString;
                            }
                        } else if (this.e.length() == 0 || (tTFUShort3 == 3 && tTFUShort5 == 1033)) {
                            this.e = tTFString;
                        }
                    } else if (this.f838g.length() == 0) {
                        this.f838g = tTFString;
                    }
                } else if (this.f837f.length() == 0) {
                    this.f837f = tTFString;
                }
            }
            i6 += 12;
            tTFUShort = i7;
        }
    }

    private boolean seekTab(a aVar, d dVar, long j6) throws EOFException {
        b bVar = (b) this.c.get(dVar);
        if (bVar == null) {
            return false;
        }
        aVar.seekSet(bVar.b + j6);
        return true;
    }

    public void readFont(a aVar) throws EOFException {
        this.b = aVar;
        readDirTabs();
        HashMap map = this.c;
        d dVar = d.d;
        if (((b) map.get(dVar)) != null) {
            seekTab(this.b, dVar, 0L);
            this.b.readTTFUShort();
            this.b.skip(2L);
            this.b.readTTFUShort();
        }
        readName();
    }

    public static c open(InputStream inputStream) throws EOFException {
        c cVar = new c();
        cVar.readFont(new a(inputStream));
        return cVar;
    }
}
