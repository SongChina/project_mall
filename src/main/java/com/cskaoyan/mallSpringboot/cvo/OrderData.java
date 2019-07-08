package com.cskaoyan.mallSpringboot.cvo;

/**
 * @author AsidentVoice
 * @date 2019/7/8 14:33
 */
public class OrderData {
    //order要和抓包的名字对应起来
    private OrderVo order;

    public OrderVo getOrder() {
        return order;
    }

    public void setOrder(OrderVo order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "order=" + order +
                '}';
    }
}
