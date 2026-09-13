package org.apache.xmlbeans.impl.common;

import javax.xml.stream.Location;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class InvalidLexicalValueException extends RuntimeException {
    private Location _location;

    public InvalidLexicalValueException() {
    }

    public Location getLocation() {
        return this._location;
    }

    public void setLocation(Location location) {
        this._location = location;
    }

    public InvalidLexicalValueException(String str) {
        super(str);
    }

    public InvalidLexicalValueException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidLexicalValueException(Throwable th) {
        super(th);
    }

    public InvalidLexicalValueException(String str, Location location) {
        super(str);
        setLocation(location);
    }

    public InvalidLexicalValueException(String str, Throwable th, Location location) {
        super(str, th);
        setLocation(location);
    }

    public InvalidLexicalValueException(Throwable th, Location location) {
        super(th);
        setLocation(location);
    }
}
