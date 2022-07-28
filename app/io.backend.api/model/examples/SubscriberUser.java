package io.backend.api.model.examples;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 * Created by agonlohaj on 29 Sep, 2020
 */
@BsonDiscriminator(key = "type", value = "SUBSCRIBER")
@Data
public class SubscriberUser extends RegisteredUser {
	@Override
	public Membership getType() { return Membership.SUBSCRIBER; }
}
