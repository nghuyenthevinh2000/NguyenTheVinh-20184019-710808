package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Class nay control hoat dong PlaceRushOrder
 * @author NguyenTheVinh-20184019
 */
public class PlaceRushOrderController extends PlaceOrderController{

	public PlaceRushOrderController() {
		super();
	}
	
    /**
     * cac tinh ho tro PlaceRushOrder
     */
    public static List<String> PROVINCE_LIST = List.of("Ha Noi",
    		"Ha Tay", "Ha Giang", "Ha Nam");

    /**
     * Media id ho tro rush order
     */
    public static List<Integer> MEDIA_ID_LIST = List.of(1, 2, 3);
    
    /**
     * Dam bao string khong co dau
     * @param info string to check
     * @return true/false
     */
    private boolean validateString(String info) {
    	return info != null && info.matches("^[ a-zA-Z0-9]*$"); 
    }
    
    /**
     * Kiem tra vi tri co support rush order hay khong
     * @param location User's province
     */
    public boolean validateLocation(String location) {
        return location != null && PlaceRushOrderController.PROVINCE_LIST.contains(location);
    }
    
    /**
     * Kiem tra user's media ho tro rush order hay khong
     * @param mediaID Cart's media id
     */
    public boolean validateItems(int mediaID) {
        return PlaceRushOrderController.MEDIA_ID_LIST.contains(mediaID);
    }
    
    /**
     * Kiem tra thoi gian nhan hang cua user
     * @param time User's receive time
     */
    public boolean validateReceiveTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
            // Get current date time
            LocalDateTime currentDateTime = LocalDateTime.now();
            return !localDateTime.isBefore(currentDateTime);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Kiem tra user's rush thong tin don hang
     * @param info User's rush order info
     */
    public boolean validateRushOrderInfo(String info) {
        return validateString(info);
    }
    
    /**
     * Kiem tra chi dan cho don rush
     * @param instruction User's rush order instruction
     */
    public boolean validateRushOrderInstruction(String instruction) {
        return validateString(instruction);
    }
}