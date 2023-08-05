package server.nanum.dto.response;

import server.nanum.domain.Order;

import java.util.List;

public record MyProgressOrdersDTO(
        Integer count,
        List<MyOrderDTO> progressOrders) {

    public static MyProgressOrdersDTO toEntity(List<Order> orderList){
        List<MyOrderDTO> DtoList = orderList.stream().map((order)-> {
            return new MyOrderDTO(
                    order.getId(),
                    order.getUser().getName(),
                    order.getTotalAmount(),
                    order.getDeliveryStatus(),
                    order.getProduct().getName(),
                    order.getProduct().getUnit(),
                    order.getProductCount());
        }).toList();
        return new MyProgressOrdersDTO(DtoList.size(),DtoList);
    }

}
