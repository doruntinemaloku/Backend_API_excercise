package io.backend.api.model.examples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonIgnore;

/**
 * Created by agonlohaj on 29 Sep, 2020
 */
@BsonDiscriminator(key = "type", value = "PREMIUM")
@Data
public class PremiumUser extends RegisteredUser {
	private String card;

	public void setCard (String card) {
		this.card = card.toLowerCase();
	}
	@BsonIgnore
	@JsonIgnore
	public String getSupervisor () {
		return "blla blla";
	}

	@Override
	public Membership getType() { return Membership.PREMIUM; }
}
