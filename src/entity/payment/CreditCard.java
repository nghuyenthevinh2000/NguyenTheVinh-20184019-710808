package entity.payment;

import java.sql.Timestamp;

public class CreditCard extends Card{
	private int cvvCode;
	private String dateExpired;

	public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
		super(owner, cardCode);
		this.cvvCode = cvvCode;
		this.dateExpired = dateExpired;
	}
}
