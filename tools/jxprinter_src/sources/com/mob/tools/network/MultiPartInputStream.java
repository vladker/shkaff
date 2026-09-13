package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MultiPartInputStream extends InputStream implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<InputStream> f3652a = new ArrayList<>();
    private int b;

    private boolean a() {
        ArrayList<InputStream> arrayList = this.f3652a;
        return arrayList == null || arrayList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) {
        this.f3652a.add(inputStream);
    }

    @Override // java.io.InputStream
    public int available() {
        if (a()) {
            return 0;
        }
        return this.f3652a.get(this.b).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ArrayList<InputStream> arrayList = this.f3652a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            InputStream inputStream = arrayList.get(i5);
            i5++;
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (a()) {
            return -1;
        }
        int i5 = this.f3652a.get(this.b).read();
        while (i5 < 0) {
            int i6 = this.b + 1;
            this.b = i6;
            if (i6 >= this.f3652a.size()) {
                break;
            }
            i5 = this.f3652a.get(this.b).read();
        }
        return i5;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        throw new IOException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (a()) {
            return -1;
        }
        int i7 = this.f3652a.get(this.b).read(bArr, i5, i6);
        while (i7 < 0) {
            int i8 = this.b + 1;
            this.b = i8;
            if (i8 >= this.f3652a.size()) {
                break;
            }
            i7 = this.f3652a.get(this.b).read(bArr, i5, i6);
        }
        return i7;
    }
}
