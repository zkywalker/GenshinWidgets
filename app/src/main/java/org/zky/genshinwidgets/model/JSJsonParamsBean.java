package org.zky.genshinwidgets.model;

public class JSJsonParamsBean<T> {

    public String callback = "";

    public T data;

    public String method = "";

    public T payload;

    public String type = "";

    public final String getCallback() {
        return this.callback;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMethod() {
        return this.method;
    }

    public final T getPayload() {
        return this.payload;
    }

    public final String getType() {
        return this.type;
    }

//  public final T optPayload( a<? extends T> parama) {
//    T t1 = this.payload;
//    T t2 = t1;
//    if (t1 == null) {
//      t1 = this.data;
//      t2 = t1;
//      if (t1 == null)
//        t2 = (T)parama.invoke();
//    }
//    return t2;
//  }

    public final void setCallback(String paramString) {
        this.callback = paramString;
    }

    public final void setData(T paramT) {
        this.data = paramT;
    }

    public final void setMethod(String paramString) {
        this.method = paramString;
    }

    public final void setPayload(T paramT) {
        this.payload = paramT;
    }

    public final void setType(String paramString) {
        this.type = paramString;
    }

}
