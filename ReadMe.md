             Kafka

             order-created
                   ▲
                   │
             Order Service
                   │
        ┌──────────┴──────────┐
        ▼                     ▼
Inventory Service     Notification Service
│
▼
inventory-reserved
│
┌────┴──────────┐
▼               ▼
Shipping Service Notification Service
│
▼
shipment-created
│
▼
Notification Service