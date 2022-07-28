package io.backend.api.model.examples;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 * Created by agonlohaj on 29 Sep, 2020
 */
@BsonDiscriminator(key = "type", value = "FREE")
@Data
public class FreeUser extends RegisteredUser {
	@Override
	public Membership getType() { return Membership.FREE; }
}
