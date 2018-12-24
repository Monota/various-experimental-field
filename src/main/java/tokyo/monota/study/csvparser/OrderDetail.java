package tokyo.monota.study.csvparser;

import java.util.Objects;

public class OrderDetail {

    private String orderId;

    private int detailNo;

    private String itemId;

    private String itemName;

    private int unitPrice;

    private int amount;

    public OrderDetail(String orderId, int detailNo, String itemId, String itemName, int unitPrice, int amount) {
        this.orderId = orderId;
        this.detailNo = detailNo;
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getDetailNo() {
        return detailNo;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return detailNo == that.detailNo &&
                unitPrice == that.unitPrice &&
                amount == that.amount &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, detailNo, itemId, itemName, unitPrice, amount);
    }
}
