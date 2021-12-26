package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

import controller.interface_group.IShippingFeeCalculator;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */
public class PlaceOrderController extends BaseController{
	
	/**
     * For reduce hard code
     */
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phone";
    public static final String NAME = "name";

    private IShippingFeeCalculator calculateShippingFee;

    public PlaceOrderController() {
    }

    public PlaceOrderController(IShippingFeeCalculator calculateShippingFee) {
        this.calculateShippingFee = calculateShippingFee;
    }

    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the avalibility of product when user click PlaceOrder button
     * @throws SQLException
     */
    public void placeOrder() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    public Order createOrder() throws SQLException{
        return new Order();
    }

    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException{
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
    }
    
    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
    public boolean validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
    	String address = info.get(ADDRESS);
        String name = info.get(NAME);
        String phoneNumber = info.get(PHONE_NUMBER);
        return validateAddress(address) && validateName(name) && validatePhoneNumber(phoneNumber);
    }
    
    public boolean validatePhoneNumber(String phoneNumber) {
    	if(phoneNumber.length() != 10) return false;
    	
    	if(!phoneNumber.startsWith("0")) return false;
    	
    	try {
    		Integer.parseInt(phoneNumber);
    	}catch(NumberFormatException e) {
    		return false;
    	}
    	
    	return true;
    }
    
    public boolean validateName(String name) {
    	return name != null && name.matches("^[ a-zA-Z]*$");   	
    }
    
    public boolean validateAddress(String address) {
    	return address != null && address.matches("^[ a-zA-Z0-9]*$");  
    }
    

    /**
     * This method calculates the shipping fees of order
     * @param order
     * @return shippingFee
     */
    public int calculateShippingFee(Order order){
    	 return calculateShippingFee.calculateShippingFee(order.getAmount());
    }
}
