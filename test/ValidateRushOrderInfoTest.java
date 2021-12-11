import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceRushOrderController;

/**
 * 
 * @author NguyenTheVinh-20184019
 *
 */
class ValidateRushOrderInfoTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
    @CsvSource(value = {
    	"Giao vao chieu,true",
        "Them 5 to pho,true",
        "Don hang nay loi#,false",
        "null,false"
    }, nullValues={"null"})
	
	@Test
	void test(String info, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validateRushOrderInfo(info);
		//then
		assertEquals(expected, isValid);
	}

}
