package controller.interface_group;

public interface IRushOrderInputValidator {
    boolean isValidReceiveTime(String time, String pattern);
    boolean isValidRushOrderInfo(String info);
    boolean isValidRushOrderInstruction(String instruction);
}
