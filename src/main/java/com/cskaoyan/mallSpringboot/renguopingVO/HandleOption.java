package com.cskaoyan.mallSpringboot.renguopingVO;

public class HandleOption {
    Boolean cancel;
    Boolean comment;
    Boolean confirm;
    Boolean delete;
    Boolean pay;
    Boolean rebuy;
    Boolean refund;

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Boolean getComment() {
        return comment;
    }

    public void setComment(Boolean comment) {
        this.comment = comment;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    public Boolean getRebuy() {
        return rebuy;
    }

    public void setRebuy(Boolean rebuy) {
        this.rebuy = rebuy;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }
}
