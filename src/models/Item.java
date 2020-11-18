package models;

public class Item {
    private int code;
    private String name;
    private int quantity;
    private double unitValue;

    public Item(int code, String name, int quantity, double unitValue) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitValue = unitValue;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public Object[] toObjectVector(){
        return new Object[]{
                code,name,quantity,unitValue
        };
    }

    @Override
    public String toString() {
        return code + "-" + name +"-"+quantity+"-"+unitValue;
    }
}
