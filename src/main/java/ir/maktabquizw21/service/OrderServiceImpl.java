package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Order;
import ir.maktabquizw21.repository.OrderRepository;
import ir.maktabquizw21.service.base.BaseServiceImpl;

public class OrderServiceImpl
        extends BaseServiceImpl<Order, Long, OrderRepository>
        implements OrderService{

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
