package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.ReviewDAO;
import com.cafe.Model.Review;
import com.cafe.utility.DBConnection;

public class ReviewDAOImpl implements ReviewDAO {

	private static final String INSERT_QUERY = "INSERT INTO review(userId, productId, rating, comment) VALUES(?,?,?,?)";

	private static final String GET_QUERY = "SELECT * FROM review WHERE reviewId=?";

	private static final String GET_BY_PRODUCT_QUERY = "SELECT * FROM review WHERE productId=?";

	private static final String GET_BY_USER_QUERY = "SELECT * FROM review WHERE userId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM review";

	private static final String UPDATE_QUERY = "UPDATE review SET userId=?, productId=?, rating=?, comment=? WHERE reviewId=?";

	private static final String DELETE_QUERY = "DELETE FROM review WHERE reviewId=?";

	@Override
	public boolean addReview(Review review) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setInt(1, review.getUserId());
			pstmt.setInt(2, review.getProductId());
			pstmt.setInt(3, review.getRating());
			pstmt.setString(4, review.getComment());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Review getReview(int reviewId) {

		Review review = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, reviewId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				review = new Review();

				review.setReviewId(rs.getInt("reviewId"));
				review.setUserId(rs.getInt("userId"));
				review.setProductId(rs.getInt("productId"));
				review.setRating(rs.getInt("rating"));
				review.setComment(rs.getString("comment"));

				Timestamp ts = rs.getTimestamp("reviewDate");
				if (ts != null) {
					review.setReviewDate(ts.toLocalDateTime());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return review;
	}

	@Override
	public List<Review> getReviewsByProductId(int productId) {

		List<Review> reviews = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_PRODUCT_QUERY)) {

			pstmt.setInt(1, productId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Review review = new Review();

				review.setReviewId(rs.getInt("reviewId"));
				review.setUserId(rs.getInt("userId"));
				review.setProductId(rs.getInt("productId"));
				review.setRating(rs.getInt("rating"));
				review.setComment(rs.getString("comment"));

				Timestamp ts = rs.getTimestamp("reviewDate");
				if (ts != null) {
					review.setReviewDate(ts.toLocalDateTime());
				}

				reviews.add(review);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reviews;
	}

	@Override
	public List<Review> getReviewsByUserId(int userId) {

		List<Review> reviews = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_USER_QUERY)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Review review = new Review();

				review.setReviewId(rs.getInt("reviewId"));
				review.setUserId(rs.getInt("userId"));
				review.setProductId(rs.getInt("productId"));
				review.setRating(rs.getInt("rating"));
				review.setComment(rs.getString("comment"));

				Timestamp ts = rs.getTimestamp("reviewDate");
				if (ts != null) {
					review.setReviewDate(ts.toLocalDateTime());
				}

				reviews.add(review);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reviews;
	}

	@Override
	public List<Review> getAllReviews() {

		List<Review> reviews = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

			while (rs.next()) {

				Review review = new Review();

				review.setReviewId(rs.getInt("reviewId"));
				review.setUserId(rs.getInt("userId"));
				review.setProductId(rs.getInt("productId"));
				review.setRating(rs.getInt("rating"));
				review.setComment(rs.getString("comment"));

				Timestamp ts = rs.getTimestamp("reviewDate");
				if (ts != null) {
					review.setReviewDate(ts.toLocalDateTime());
				}

				reviews.add(review);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reviews;
	}

	@Override
	public boolean updateReview(Review review) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setInt(1, review.getUserId());
			pstmt.setInt(2, review.getProductId());
			pstmt.setInt(3, review.getRating());
			pstmt.setString(4, review.getComment());
			pstmt.setInt(5, review.getReviewId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteReview(int reviewId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, reviewId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}