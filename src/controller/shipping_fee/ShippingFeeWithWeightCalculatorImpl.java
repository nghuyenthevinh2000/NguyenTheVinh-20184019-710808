package controller.shipping_fee;

import controller.interface_group.IShippingFeeCalculator;

import entity.order.Order;

import java.util.Random;

public class ShippingFeeWithWeightCalculatorImpl implements IShippingFeeCalculator {
	private final int LENGTH = 60;
    private final int WIDTH = 70;
    private final int HEIGHT = 80;
    private final int COEFFICIENT = 6000;

    @Override
    public int calculateShippingFee(int amount) {
        Random rand = new Random();
        return (int)( ( (rand.nextFloat()*10)/100 ) * amount + LENGTH * WIDTH * HEIGHT / COEFFICIENT);
    }
}
