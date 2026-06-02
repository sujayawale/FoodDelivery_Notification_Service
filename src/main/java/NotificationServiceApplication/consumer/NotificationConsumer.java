package NotificationServiceApplication.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import NotificationServiceApplication.dto.DeliveryEvent;
import NotificationServiceApplication.dto.OrderEvent;
import NotificationServiceApplication.dto.PaymentEvent;
import NotificationServiceApplication.service.NotificationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {

	private final NotificationService notificationService;
	
	@KafkaListener(topics ="order-created-topic", groupId = "notification-group")
	public void orderCreated(OrderEvent event) {
		notificationService.orderCreated(event);
	}
	
	@KafkaListener(topics ="payment-completed-topic", groupId = "notification-group")
	public void paymentCompleted(PaymentEvent event) {
		notificationService.paymentCompleted(event);
	}
	
	@KafkaListener(topics ="delivery-created-topic", groupId = "notification-group")
	public void deliveryAssigned(DeliveryEvent event) {
		notificationService.deliveryAssigned(event);
	}
	
}
