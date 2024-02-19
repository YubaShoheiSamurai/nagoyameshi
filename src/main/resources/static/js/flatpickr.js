let maxDate = new Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);

flatpickr('#reservationDate', {
	mode: "single",
	locale: 'ja',
	minDate: 'today',
	maxDate: maxDate,
	disable: [
		function(date) {
			const day = date.getDay()
			let days = []
			document.getElementsByName('holiday').forEach(h => {
				console.log(h.value)
				days.push(Number(h.value));
			});
			// 0:日, 1:月, 2:火, 3:水, 4:木, 5:金, 6:土
			return days.includes(day);
		}
	],
});

let reservationTime = document.querySelector('#reservationTime');
let hiddenOpeningTime = document.getElementsByName('hiddenOpeningTime')[0].value;
let hiddenClosedTime = document.getElementsByName('hiddenClosedTime')[0].value;
if (reservationTime != null) {
	reservationTime.min = hiddenOpeningTime;
}
if (reservationTime != null) {
	reservationTime.max = hiddenClosedTime;
}