package com.dorapos.service.mapper;

import com.dorapos.domain.*;
import com.dorapos.service.dto.OrdersLineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrdersLine} and its DTO {@link OrdersLineDTO}.
 */
@Mapper(componentModel = "spring", uses = {OrdersMapper.class, ProductMapper.class})
public interface OrdersLineMapper extends EntityMapper<OrdersLineDTO, OrdersLine> {

    @Mapping(source = "orders.id", target = "ordersId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.productName", target = "productProductName")
    OrdersLineDTO toDto(OrdersLine ordersLine);

    @Mapping(source = "ordersId", target = "orders")
    @Mapping(target = "ordersLineVariants", ignore = true)
    @Mapping(source = "productId", target = "product")
    OrdersLine toEntity(OrdersLineDTO ordersLineDTO);

    default OrdersLine fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrdersLine ordersLine = new OrdersLine();
        ordersLine.setId(id);
        return ordersLine;
    }
}