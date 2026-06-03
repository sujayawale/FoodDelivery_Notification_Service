package NotificationServiceApplication.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import NotificationServiceApplication.dto.DeliveryEvent;
import NotificationServiceApplication.dto.OrderEvent;
import NotificationServiceApplication.dto.PaymentEvent;
import NotificationServiceApplication.service.NotificationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {

	private final NotificationService notificationService;
	
	private final ObjectMapper mapper =new ObjectMapper();
	
	@KafkaListener(topics ="order-created-topic", groupId = "notification-group")
	public void orderCreated(String message) throws Exception{
		OrderEvent event =
                mapper.readValue(
                        message,
                        OrderEvent.class
                );

        notificationService.orderCreated(event);
	}
	
	@KafkaListener(topics ="payment-completed-topic", groupId = "notification-group")
	public void paymentCompleted(String message) throws Exception{
		PaymentEvent event =
	            mapper.readValue(
	                    message,
	                    PaymentEvent.class
	            );

	    notificationService.paymentCompleted(event);
	}
	
	@KafkaListener(topics ="delivery-created-topic", groupId = "notification-group")
	public void deliveryAssigned(String message) throws Exception{
		 DeliveryEvent event =
		            mapper.readValue(
		                    message,
		                    DeliveryEvent.class
		            );

		    notificationService.deliveryAssigned(event);
	}
	
}
