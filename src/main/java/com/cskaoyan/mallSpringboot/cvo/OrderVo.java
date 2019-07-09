package com.cskaoyan.mallSpringboot.cvo;

/**
 * @author AsidentVoice
 * @date 2019/7/8 14:28
 */
public class OrderVo {
    int unrecv;
    int uncomment;
    int unpaid;
    int unship;

    @Override
    public String toString() {
        return "OrderVo{" +
                "unrecv=" + unrecv +
                ", uncomment=" + uncomment +
                ", unpaid=" + unpaid +
                ", unship=" + unship +
                '}';
    }

    public int getUnrecv() {
        return unrecv;
    }

    public void setUnrecv(int unrecv) {
        this.unrecv = unrecv;
    }

    public int getUncomment() {
        return uncomment;
    }

    public void setUncomment(int uncomment) {
        this.uncomment = uncomment;
    }

    public int getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(int unpaid) {
        this.unpaid = unpaid;
    }

    public int getUnship() {
        return unship;
    }

    public void setUnship(int unship) {
        this.unship = unship;
    }
}
