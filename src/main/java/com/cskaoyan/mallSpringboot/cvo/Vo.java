package com.cskaoyan.mallSpringboot.cvo;

/**
 * @author AsidentVoice
 * @date 2019/7/8 14:32
 */
public class Vo {
    int errno;
    String errmsg;
    //data里面order，oder里面那4个
    OrderData data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public OrderData getData() {
        return data;
    }

    public void setData(OrderData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
