package controller.rush_order_validator;

import controller.interface_group.IRushOrderInputValidator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleRushOrderValidator implements IRushOrderInputValidator {
	
	@Override
    public boolean isValidReceiveTime(String time, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime.parse(time, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isValidRushOrderInfo(String info) {
        return validateString(info);
    }

    @Override
    public boolean isValidRushOrderInstruction(String instruction) {
        return validateString(instruction);
    }

    /**
     * Dam bao string khong co dau
     * @param info string to check
     * @return true/false
     */
    private boolean validateString(String info) {
    	return info != null && info.matches("^[ a-zA-Z0-9]*$"); 
    }
}
