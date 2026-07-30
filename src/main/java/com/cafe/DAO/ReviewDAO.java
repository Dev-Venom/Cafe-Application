package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Review;

public interface ReviewDAO {

	boolean addReview(Review review);

	Review getReview(int reviewId);

	List<Review> getReviewsByProductId(int productId);

	List<Review> getReviewsByUserId(int userId);

	List<Review> getAllReviews();

	boolean updateReview(Review review);

	boolean deleteReview(int reviewId);
}