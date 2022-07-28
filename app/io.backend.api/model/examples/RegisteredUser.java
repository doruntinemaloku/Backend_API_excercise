package io.backend.api.model.examples;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.training.api.mongo.serializers.ObjectIdDeSerializer;
import io.training.api.mongo.serializers.ObjectIdStringSerializer;
import lombok.Data;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

/**
 * Created by agonlohaj on 29 Sep, 2020
 */
@Data
@ToString
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type", visible = true)
@JsonSubTypes({
		@JsonSubTypes.Type(value= FreeUser.class, name = "FREE"),
		@JsonSubTypes.Type(value= PremiumUser.class, name = "PREMIUM"),
		@JsonSubTypes.Type(value= SubscriberUser.class, name = "SUBSCRIBER")
})
@BsonDiscriminator(key = "type", value = "NONE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisteredUser {
	@BsonId
	@JsonSerialize(using = ObjectIdStringSerializer.class)
	@JsonDeserialize(using = ObjectIdDeSerializer.class)
	public ObjectId id;
	String name;
	@BsonIgnore
	Membership type = Membership.NONE;
}
