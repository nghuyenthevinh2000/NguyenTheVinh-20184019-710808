package controller.interface_group;

import entity.order.Order;

public interface IShippingFeeCalculator {

    int calculateShippingFee(int amount);

}