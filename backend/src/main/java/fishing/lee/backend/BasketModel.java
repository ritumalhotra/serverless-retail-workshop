package fishing.lee.backend;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.socialsignin.spring.data.dynamodb.marshaller.Instant2EpocheDynamoDBMarshaller;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@DynamoDBTable(tableName = "Basket")
public class BasketModel {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey()
    private UUID id;

    @DynamoDBTypeConverted(converter = Instant2EpocheDynamoDBMarshaller.class)
    private Instant creationPoint;

    @DynamoDBAttribute
    private Set<String> items;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty("creation_point")
    public Instant getCreationPoint() {
        return creationPoint;
    }

    @JsonProperty("creation_point")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    public void setCreationPoint(Instant creationPoint) {
        this.creationPoint = creationPoint != null ? creationPoint : Instant.now();
    }

    @JsonProperty("items")
    public Set<String> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Set<String> items) {
        this.items = items;
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void deleteItem(String item) {
        this.items.remove(item);
    }
}
