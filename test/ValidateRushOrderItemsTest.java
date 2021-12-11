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
class ValidateRushOrderItemsTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,false"
    })
	
	@Test
	void test(int mediaId, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validateItems(mediaId);
		//then
		assertEquals(expected, isValid);
	}

}
