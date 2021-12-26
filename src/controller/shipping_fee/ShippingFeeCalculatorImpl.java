package controller.shipping_fee;

import entity.order.Order;
import controller.interface_group.IShippingFeeCalculator;

import java.util.Random;

public class ShippingFeeCalculatorImpl implements IShippingFeeCalculator {

    @Override
    public int calculateShippingFee(int amount) {
        Random rand = new Random();
        return (int)( ( (rand.nextFloat()*10)/100 ) * amount );
    }

}