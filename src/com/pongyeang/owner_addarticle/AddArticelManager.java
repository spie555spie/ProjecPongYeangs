package com.pongyeang.owner_addarticle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class AddArticelManager {
	private Article article = new Article();

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getMaxArticleID() {
		int reataurantsdetailID = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(articleID) from article;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 10) {
				}
				reataurantsdetailID = rs.getInt(1) + 1;
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}

		return reataurantsdetailID;
	}

	public void addImages(Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_addarticle_Images(?,?,?);";
		try {
			/*
			 * �Դ�ѧ��ѹ Auto Commit � Database ������������
			 * �������¹�ŧ�������ѵ��ѵ�
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);

			for (Images image : article.getVectorimages()) {
				cstmt.setString(1, image.getImageName());
				cstmt.setString(2, image.getImageDetail());
				cstmt.setInt(3, article.getArticleID());
			}

			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void addHotelDetailArticle(Owner owner, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_addarticle_HotelDetail(?,?,?,?,?,?,?,?)";
		try {
			/*
			 * �Դ�ѧ��ѹ Auto Commit � Database ������������
			 * �������¹�ŧ�������ѵ��ѵ�
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, article.getArticleID());
			cstmt.setString(2, article.getArticleName());
			cstmt.setString(3, article.getArticleDetail());
			cstmt.setString(4, article.getArticleTitel());
			cstmt.setString(5, article.getCountactus());
			cstmt.setString(6, article.getAmenities());
			cstmt.setInt(7, 0);
			cstmt.setInt(8, owner.getHoteldetail().getHoteldetailID());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void addTravelDetailArticle(Owner owner, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_addarticle_TravelDetail(?,?,?,?,?,?,?,?)";
		try {
			/*
			 * �Դ�ѧ��ѹ Auto Commit � Database ������������
			 * �������¹�ŧ�������ѵ��ѵ�
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, article.getArticleID());
			cstmt.setString(2, article.getArticleName());
			cstmt.setString(3, article.getArticleDetail());
			cstmt.setString(4, article.getArticleTitel());
			cstmt.setString(5, article.getCountactus());
			cstmt.setString(6, article.getAmenities());
			cstmt.setInt(7, 0);
			cstmt.setInt(8, owner.getTravledetail().getTraveldetailID());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void addRestaurantsDetailArticle(Owner owner, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_addarticle_RestaurantsDetail(?,?,?,?,?,?,?,?)";
		try {
			/*
			 * �Դ�ѧ��ѹ Auto Commit � Database ������������
			 * �������¹�ŧ�������ѵ��ѵ�
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, article.getArticleID());
			cstmt.setString(2, article.getArticleName());
			cstmt.setString(3, article.getArticleDetail());
			cstmt.setString(4, article.getArticleTitel());
			cstmt.setString(5, article.getCountactus());
			cstmt.setString(6, article.getAmenities());
			cstmt.setInt(7, 0);
			cstmt.setInt(8, owner.getRestaurantsdetail().getRestaurantsdetailID());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void removeImageArticle(String imageID) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "delete  from image where imageID  = ? ;";
		try {
			/*
			 * �Դ�ѧ��ѹ Auto Commit � Database ������������
			 * �������¹�ŧ�������ѵ��ѵ�
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, imageID);
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Owner getViewPRBusinessAndTravelDetail(Login login) {
		Owner owner = new Owner();
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_restaurants = null;
		try {
			Vector<SubCategoryTravel> listsubCategoryTravel = new Vector<>();
			SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
			Vector<TravelDetail> listtravelDetail = new Vector<>();
			String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData,"
					+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit ,traveldetail.ownerID,"
					+ "traveldetail.subcategorytravelID,subcategorytravel.subcategorytravelName,"
					+ "subcategorytravel.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line,"
					+ "traveldetail.twitter,traveldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName " + "from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = traveldetail.addressID "
					+ "inner join image on image.addressID = address.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "where owner.OwnerID = ? ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next() && login.getOwner().getOwnerID() == rs.getInt(6)) {
				owner.getTravledetail().setTraveldetailID(rs.getInt(1));
				owner.getTravledetail().setTraveldetailName(rs.getString(2));
				owner.getTravledetail().setTraveldetailData(rs.getString(3));
				owner.getTravledetail().setTraveldetailTitel(rs.getString(4));
				owner.getTravledetail().setStatisticsvisit(rs.getInt(5));
				owner.setOwnerID(rs.getInt(6));

				category.getVectorsubcategorytravel().add(new SubCategoryTravel(rs.getString(7), rs.getString(8), ""));
				// subCategoryTravel.setSubcategorytravelID(rs.getString(7));
				// subCategoryTravel.setSubcategorytravelName(rs.getString(8));

				category.setCategoryID(rs.getString(9));
				category.setCategoryName(rs.getString(10));

				// Address address = new Address();
				owner.getTravledetail().getAddress().setAddressID(rs.getInt(11));
				owner.getTravledetail().getAddress().setAddressno(rs.getString(12));
				owner.getTravledetail().getAddress().setVillageno(rs.getString(13));
				owner.getTravledetail().getAddress().setAlley(rs.getString(14));
				owner.getTravledetail().getAddress().setStreet(rs.getString(15));
				owner.getTravledetail().getAddress().setSubdistrict(rs.getString(16));
				owner.getTravledetail().getAddress().setDistrict(rs.getString(17));
				owner.getTravledetail().getAddress().setProvince(rs.getString(18));
				owner.getTravledetail().getAddress().setZipcode(rs.getString(19));
				owner.getTravledetail().getAddress().setMapimage(rs.getString(20));
				owner.getTravledetail().getAddress().setDatecreate(rs.getString(21));
				owner.getTravledetail().getAddress().setLatitude(rs.getString(22));
				owner.getTravledetail().getAddress().setLongtitude(rs.getString(23));
				owner.getTravledetail().setTelephone(rs.getString(24));
				owner.getTravledetail().setFacebook(rs.getString(25));
				owner.getTravledetail().setLine(rs.getString(26));
				owner.getTravledetail().setTwitter(rs.getString(27));
				owner.getTravledetail().setWebsite(rs.getString(28));
				owner.getTravledetail().getAddress().setStatusapproved(rs.getString(29));

				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(30), rs.getString(31), rs.getString(32)));
				// Images images = new Images();
				// images.setImageID(rs.getInt(30));
				// images.setImageName(rs.getString(31));
				// images.setImageDetail(rs.getString(32));

				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(33));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(34));

				// listimages.add(images);
				// address.setVectorimages(listimages);
				listsubCategoryTravel.add(category.getVectorsubcategorytravel().get(0));
				listtravelDetail.add(owner.getTravledetail());
				// travelDetail.setAddress(address);
			}
			subCategoryTravel.setVectortraveldetail(listtravelDetail);
			category.setVectorsubcategorytravel(listsubCategoryTravel);
			// owner.setTravledetail(travelDetail);
			rs.close();

			Vector<SubCategoryHotel> listsubCategoryHotel = new Vector<>();
			SubCategoryHotel subCategoryHotel = new SubCategoryHotel();
			Vector<HotelDetail> listhotelDetail = new Vector<>();
			String sql_hotel = " select hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,"
					+ "hoteldetail.hoteldetailData,hoteldetail.hoteldetailTitle,hoteldetail.opentime,"
					+ "hoteldetail.checkincheckout,hoteldetail.roomofnumber,hoteldetail.hotelprice,"
					+ "hoteldetail.amenities,hoteldetail.statisticsvisit,hoteldetail.ownerID,"
					+ "hoteldetail.subcategoryhotelID,subcategoryhotel.subcategoryhotelName, category.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,hoteldetail.telephone,hoteldetail.facebook,hoteldetail.line,"
					+ "hoteldetail.twitter,hoteldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
					+ "inner join subcategoryhotel on hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID "
					+ " inner join category on subcategoryhotel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = hoteldetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_hotel = conn.prepareStatement(sql_hotel);
			stmt_hotel.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs2 = stmt_hotel.executeQuery();
			while (rs2.next() && login.getOwner().getOwnerID() == rs2.getInt(11)) {
				owner.getHoteldetail().setHoteldetailID(rs2.getInt(1));
				owner.getHoteldetail().setHoteldetailName(rs2.getString(2));
				owner.getHoteldetail().setHoteldetailData(rs2.getString(3));
				owner.getHoteldetail().setHoteldetailTitel(rs2.getString(4));
				owner.getHoteldetail().setOpentime(rs2.getString(5));
				owner.getHoteldetail().setCheckincheckout(rs2.getString(6));
				owner.getHoteldetail().setRoomofnumber(rs2.getString(7));
				owner.getHoteldetail().setHotelprice(rs2.getString(8));
				owner.getHoteldetail().setAmenities(rs2.getString(9));
				owner.getHoteldetail().setStatisticsvisit(rs2.getInt(10));
				owner.setOwnerID(rs2.getInt(11));

				category.getVectorsubcategoryhotel()
						.add(new SubCategoryHotel(rs2.getString(12), rs2.getString(13), ""));
				// subCategoryHotel.setSubcategoryhotelID(rs2.getString(12));
				// subCategoryHotel.setSubcategoryhotelName(rs2.getString(13));

				category.setCategoryID(rs2.getString(14));
				category.setCategoryName(rs2.getString(15));

				// Address address = new Address();
				owner.getHoteldetail().getAddress().setAddressID(rs2.getInt(16));
				owner.getHoteldetail().getAddress().setAddressno(rs2.getString(17));
				owner.getHoteldetail().getAddress().setVillageno(rs2.getString(18));
				owner.getHoteldetail().getAddress().setAlley(rs2.getString(19));
				owner.getHoteldetail().getAddress().setStreet(rs2.getString(20));
				owner.getHoteldetail().getAddress().setSubdistrict(rs2.getString(21));
				owner.getHoteldetail().getAddress().setDistrict(rs2.getString(22));
				owner.getHoteldetail().getAddress().setProvince(rs2.getString(23));
				owner.getHoteldetail().getAddress().setZipcode(rs2.getString(24));
				owner.getHoteldetail().getAddress().setMapimage(rs2.getString(25));
				owner.getHoteldetail().getAddress().setDatecreate(rs2.getString(26));
				owner.getHoteldetail().getAddress().setLatitude(rs2.getString(27));
				owner.getHoteldetail().getAddress().setLongtitude(rs2.getString(28));
				owner.getHoteldetail().setTelephone(rs2.getString(29));
				owner.getHoteldetail().setFacebook(rs2.getString(30));
				owner.getHoteldetail().setLine(rs2.getString(31));
				owner.getHoteldetail().setTwitter(rs2.getString(32));
				owner.getHoteldetail().setWebsite(rs2.getString(33));
				owner.getHoteldetail().getAddress().setStatusapproved(rs2.getString(34));

				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(35), rs2.getString(36), rs2.getString(37)));
				// Images images = new Images();
				// images.setImageID(rs2.getInt(35));
				// images.setImageName(rs2.getString(36));
				// images.setImageDetail(rs2.getString(37));

				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(38));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(39));

				// listimages.add(images);
				// hotelDetail.setAddress(address);
				listhotelDetail.add(owner.getHoteldetail());
				listsubCategoryHotel.add(category.getVectorsubcategoryhotel().get(0));
				// address.setVectorimages(listimages);
			}
			subCategoryHotel.setVectorhoteldetail(listhotelDetail);
			category.setVectorsubcategoryhotel(listsubCategoryHotel);
			// owner.setHoteldetail(hotelDetail);
			rs2.close();

			Vector<SubCategoryRestaurants> listsubCategoryRestaurants = new Vector<>();
			Vector<RestaurantsDetail> listrestaurantsDetails = new Vector<>();
			SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
			String sql_restaurants = "select restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
					+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
					+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
					+ "restaurantsdetail.statisticsvisit,restaurantsdetail.ownerID,"
					+ "subcategoryrestaurants.subcategoryrestaurantsID,subcategoryrestaurants.subcategoryrestaurantsName,"
					+ "subcategoryrestaurants.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,restaurantsdetail.telephone,restaurantsdetail.facebook,restaurantsdetail.line,"
					+ "restaurantsdetail.twitter,restaurantsdetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_restaurants = conn.prepareStatement(sql_restaurants);
			stmt_restaurants.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_restaurants.executeQuery();
			while (rs3.next() && login.getOwner().getOwnerID() == rs3.getInt(9)) {
				owner.getRestaurantsdetail().setRestaurantsdetailID(rs3.getInt(1));
				owner.getRestaurantsdetail().setRestaurantsdetailName(rs3.getString(2));
				owner.getRestaurantsdetail().setRestaurantsdetailData(rs3.getString(3));
				owner.getRestaurantsdetail().setRestaurantsdetailTitel(rs3.getString(4));
				owner.getRestaurantsdetail().setOpentime(rs3.getString(5));
				owner.getRestaurantsdetail().setPricerange(rs3.getString(6));
				owner.getRestaurantsdetail().setAmenities(rs3.getString(7));
				owner.getRestaurantsdetail().setStatisticsvisit(rs3.getInt(8));
				owner.setOwnerID(rs3.getInt(9));

				category.getVectorsubcategoryrestaurants()
						.add(new SubCategoryRestaurants(rs3.getString(10), rs3.getString(11), ""));
				// subCategoryRestaurants.setSubcategoryrestaurantID(rs3.getString(10));
				// subCategoryRestaurants.setSubcategoryrestaurantName(rs3.getString(11));

				category.setCategoryID(rs3.getString(12));
				category.setCategoryName(rs3.getString(13));

				// Address address = new Address();
				owner.getRestaurantsdetail().getAddress().setAddressID(rs3.getInt(14));
				owner.getRestaurantsdetail().getAddress().setAddressno(rs3.getString(15));
				owner.getRestaurantsdetail().getAddress().setVillageno(rs3.getString(16));
				owner.getRestaurantsdetail().getAddress().setAlley(rs3.getString(17));
				owner.getRestaurantsdetail().getAddress().setStreet(rs3.getString(18));
				owner.getRestaurantsdetail().getAddress().setSubdistrict(rs3.getString(19));
				owner.getRestaurantsdetail().getAddress().setDistrict(rs3.getString(20));
				owner.getRestaurantsdetail().getAddress().setProvince(rs3.getString(21));
				owner.getRestaurantsdetail().getAddress().setZipcode(rs3.getString(22));
				owner.getRestaurantsdetail().getAddress().setMapimage(rs3.getString(23));
				owner.getRestaurantsdetail().getAddress().setDatecreate(rs3.getString(24));
				owner.getRestaurantsdetail().getAddress().setLatitude(rs3.getString(25));
				owner.getRestaurantsdetail().getAddress().setLongtitude(rs3.getString(26));
				owner.getRestaurantsdetail().setTelephone(rs3.getString(27));
				owner.getRestaurantsdetail().setFacebook(rs3.getString(28));
				owner.getRestaurantsdetail().setLine(rs3.getString(29));
				owner.getRestaurantsdetail().setTwitter(rs3.getString(30));
				owner.getRestaurantsdetail().setWebsite(rs3.getString(31));
				owner.getRestaurantsdetail().getAddress().setStatusapproved(rs3.getString(32));

				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs3.getInt(33), rs3.getString(34), rs3.getString(35)));
				// Images images = new Images();
				// images.setImageID(rs3.getInt(33));
				// images.setImageName(rs3.getString(34));
				// images.setImageDetail(rs3.getString(35));

				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(36));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(37));

				// listimages.add(images);
				// restaurantsDetails.setAddress(address);
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
				listsubCategoryRestaurants.add(category.getVectorsubcategoryrestaurants().get(0));
				// address.setVectorimages(listimages);
			}
			subCategoryRestaurants.setVectorrestaurantsdetail(listrestaurantsDetails);
			category.setVectorsubcategoryrestaurants(listsubCategoryRestaurants);
			// owner.setRestaurantsdetail(restaurantsDetails);
			rs3.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				stmt_hotel.close();
				stmt_restaurants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

	}
}
