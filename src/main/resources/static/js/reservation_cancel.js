$('#cancelModal').on('show.bs.modal', function (event) {
		const button = $(event.relatedTarget);
		const reservationId = button.data('id');
		const restaurantName = button.data('restaurant_name');
		const modal = $(this);
		modal.find('.cancelText').text(restaurantName + 'への予約をキャンセルしますか？');
		const hiddenReservationId = document.getElementsByName('id')[0];
		hiddenReservationId.value = reservationId;
});