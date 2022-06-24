package genericity;

public class Order<T> {
    String OrderName;
    int orderId;

    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        OrderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public Order() {
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
