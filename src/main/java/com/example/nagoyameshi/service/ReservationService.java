package com.example.nagoyameshi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.form.RestaurantCancelForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;

	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		Restaurant restaurant = restaurantRepository.getReferenceById(reservationRegisterForm.getRestaurantId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		DateTimeFormatter dtFt = DateTimeFormatter.ofPattern("yyyy年MM月dd日 H時mm分");
		LocalDateTime reservationDate = LocalDateTime.parse(reservationRegisterForm.getReservationDateTime(), dtFt);

		reservation.setRestaurant(restaurant);
		reservation.setUser(user);
		reservation.setReservationDateTime(reservationDate);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());

		reservationRepository.save(reservation);
	}
	
	@Transactional
	public void cancel(RestaurantCancelForm restaurantCancelForm) {
		reservationRepository.deleteById(restaurantCancelForm.getId());
	}

	// 予約人数が定員以下かどうかをチェックする
	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	// 予約日時が現在時刻以降かをチェックする
	public boolean isReservationDateWhenCurrentTimeAfter(String reservationDate, String reservationTime) {
		LocalDateTime reservation = LocalDateTime.parse(reservationDate + "T" + reservationTime);
		LocalDateTime now = LocalDateTime.now();
		return reservation.isAfter(now);
	}

}
