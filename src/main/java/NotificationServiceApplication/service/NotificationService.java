package NotificationServiceApplication.service;

import org.springframework.stereotype.Service;

import NotificationServiceApplication.dto.DeliveryEvent;
import NotificationServiceApplication.dto.OrderEvent;
import NotificationServiceApplication.dto.PaymentEvent;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationService {
	public void orderCreated(OrderEvent event) {
		log.info("EMAIL SENT -> Order {} Created", event.getOrderId());
	}
	public void paymentCompleted(PaymentEvent event) {
		log.info("SMS SENT -> Paymeny Success For Order {}", event.getOrderId());
	}
	public void deliveryAssigned(DeliveryEvent event) {
		log.info("PUSH NOTIFICATION -> Delivery Partner {} Assigned For Order {}", event.getDeliveryPartner(), event.getOrderId());
	}
}
