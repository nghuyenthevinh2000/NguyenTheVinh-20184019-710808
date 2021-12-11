import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ValidateAddressTest.class, ValidateNameTest.class, ValidatePhoneNumberTest.class, ValidateRushOrderInfoTest.class, ValidateRushOrderInstructionTest.class, ValidateRushOrderItemsTest.class, ValidateRushOrderLocationTest.class})
public class AllTests {
	
}
