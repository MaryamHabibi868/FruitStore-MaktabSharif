package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Fruit;
import ir.maktabquizw21.domains.OrderItem;
import ir.maktabquizw21.repository.FruitRepository;
import ir.maktabquizw21.repository.OrderItemRepository;
import ir.maktabquizw21.service.base.BaseServiceImpl;

public class OrderItemServiceImpl
        extends BaseServiceImpl<OrderItem, Long, OrderItemRepository>
        implements OrderItemService{

    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
    }
}
