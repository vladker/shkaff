package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MultiPart extends HTTPPart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<HTTPPart> f3651a = new ArrayList<>();

    public MultiPart append(HTTPPart hTTPPart) {
        this.f3651a.add(hTTPPart);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        ArrayList<HTTPPart> arrayList = this.f3651a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            HTTPPart hTTPPart = arrayList.get(i5);
            i5++;
            multiPartInputStream.addInputStream(hTTPPart.getInputStream());
        }
        return multiPartInputStream;
    }

    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        ArrayList<HTTPPart> arrayList = this.f3651a;
        int size = arrayList.size();
        long length = 0;
        int i5 = 0;
        while (i5 < size) {
            HTTPPart hTTPPart = arrayList.get(i5);
            i5++;
            length += hTTPPart.length();
        }
        return length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<HTTPPart> arrayList = this.f3651a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            HTTPPart hTTPPart = arrayList.get(i5);
            i5++;
            sb.append(hTTPPart.toString());
        }
        return sb.toString();
    }
}
