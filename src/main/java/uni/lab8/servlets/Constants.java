package uni.lab8.servlets;

public enum Constants {
    ATTRIBUTE_CART("cart"),
    ADD_CART_PARAM_ID("id"),
    ADD_CART_OPERAND("operand"),
    ATTRIBUTE_CART_SIZE("k"),
    ATTRIBUTE_CART_ITEMS("cartItems"),
    ATTRIBUTE_CART_COST("cartCost"),
    ATTRIBUTE_ITEMS("products"),
    ATTRIBUTE_LOGIN("email"),
    ATTRIBUTE_ITEM_SERVICE("ItemService"),
    ATTRIBUTE_ORDER_SERVICE("OrderService"),
    ATTRIBUTE_USER_SERVICE("UserService") ;

    private final String value;
    Constants(final String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }

}

