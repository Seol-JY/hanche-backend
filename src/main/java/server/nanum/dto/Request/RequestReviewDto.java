package server.nanum.dto.Request;

import server.nanum.domain.Order;
import server.nanum.domain.Review;

public record RequestReviewDto(
        Long orderId,
        Float rating,
        String comment) {
    public Review toEntity(Order order){
        return Review.builder()
                .rating(rating)
                .comment(comment)
                .order(order)
                .build();
    }
}
