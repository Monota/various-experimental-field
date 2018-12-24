package tokyo.monota.study.csvparser;

import com.opencsv.bean.CsvBindByPosition;

import java.util.*;

public class Order {

    @CsvBindByPosition(position = 0)
    private String orderId;

    @CsvBindByPosition(position = 1)
    private String customerId;

    @CsvBindByPosition(position = 2)
    private int totalPrice;

    private List<OrderDetail> orderDetails;

    public Order(String orderId, String customerId, int totalPrice, OrderDetail... details) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.orderDetails = Collections.unmodifiableList(Arrays.asList(details));
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return totalPrice == order.totalPrice &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(customerId, order.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, totalPrice);
    }
}
