package com.alibaba.fastjson.support.jaxrs;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import p079o.Z;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a implements MessageBodyReader, MessageBodyWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p085p.a f2419a;

    @Deprecated
    protected Charset charset;

    @Deprecated
    protected String dateFormat;

    @Deprecated
    protected c0[] features;

    @Deprecated
    protected Z[] filters;

    public a() {
        this.charset = Charset.forName("UTF-8");
        this.features = new c0[0];
        this.filters = new Z[0];
        this.f2419a = new p085p.a();
    }

    @Deprecated
    public Charset getCharset() {
        return this.f2419a.f7732a;
    }

    @Deprecated
    public String getDateFormat() {
        return this.f2419a.f7733f;
    }

    @Deprecated
    public c0[] getFeatures() {
        return this.f2419a.c;
    }

    @Deprecated
    public Z[] getFilters() {
        return this.f2419a.d;
    }

    public Object readFrom(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) {
        p085p.a aVar = this.f2419a;
        return p050j.a.parseObject(inputStream, aVar.f7732a, type, aVar.e);
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.f2419a.f7732a = charset;
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.f2419a.f7733f = str;
    }

    @Deprecated
    public void setFeatures(c0... c0VarArr) {
        this.f2419a.c = c0VarArr;
    }

    @Deprecated
    public void setFilters(Z... zArr) {
        this.f2419a.d = zArr;
    }

    public void writeTo(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException {
        p085p.a aVar = this.f2419a;
        multivaluedMap.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(p050j.a.writeJSONString(outputStream, aVar.f7732a, obj, aVar.b, aVar.d, aVar.f7733f, p050j.a.f5374g, aVar.c)));
        outputStream.flush();
    }

    @Deprecated
    public a(String str) {
        this.charset = Charset.forName("UTF-8");
        this.features = new c0[0];
        this.filters = new Z[0];
        p085p.a aVar = new p085p.a();
        this.f2419a = aVar;
        aVar.f7732a = Charset.forName(str);
    }
}
