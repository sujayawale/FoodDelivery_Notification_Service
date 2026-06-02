package NotificationServiceApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DeliveryEvent {

	private Long deliveryId;
	
	private Long orderId;
	
	private String deliveryPartner;
	
	private String status;
	
}
