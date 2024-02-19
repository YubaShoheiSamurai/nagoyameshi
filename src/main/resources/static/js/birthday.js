let userBirthdayYear = document.querySelector('#birthdayYear');
let userBirthdayMonth = document.querySelector('#birthdayMonth');
let userBirthdayDay = document.querySelector('#birthdayDay');
let hiddenBirthdayYear = document.getElementsByName('hiddenBirthdayYear')[0].value;
let hiddenBirthdayMonth = document.getElementsByName('hiddenBirthdayMonth')[0].value;
let hiddenBirthdayDay = document.getElementsByName('hiddenBirthdayDay')[0].value;

/**
 * selectのoptionタグを生成するための関数
 * @param {Element} elem 変更したいselectの要素
 * @param {Number} val 表示される文字と値の数値
 */
function createOptionForElements(elem, val, unit, hidden) {
	let option = document.createElement('option');
	if (val.toString().length == 1) {
		option.text = '0' + val + unit;
	} else {
		option.text = val + unit;
	}
	
	if (val.toString() == hidden) {
		option.setAttribute("selected", "selected");
	}

	option.value = val;
	elem.appendChild(option);
}
//年の生成
const now = new Date();
const year = now.getFullYear();
for (let i = 1920; i <= year; i++) {
	createOptionForElements(userBirthdayYear, i, "年", hiddenBirthdayYear);
}
//月の生成
for (let i = 1; i <= 12; i++) {
	createOptionForElements(userBirthdayMonth, i, "月", hiddenBirthdayMonth);
}
//日の生成
for (let i = 1; i <= 31; i++) {
	createOptionForElements(userBirthdayDay, i, "日", hiddenBirthdayDay);
}

/**
 * 日付を変更する関数
 */
function changeTheDay() {
	//日付の要素を削除
	userBirthdayDay.innerHTML = '<option hidden value="">日</option>';

	const month = userBirthdayMonth.value != "" ? userBirthdayMonth.value : 1;

	//選択された年月の最終日を計算
	let lastDayOfTheMonth = new Date(userBirthdayYear.value, month, 0).getDate();

	//選択された年月の日付を生成
	for (let i = 1; i <= lastDayOfTheMonth; i++) {
		createOptionForElements(userBirthdayDay, i, "日", hiddenBirthdayDay);
	}
}

userBirthdayYear.addEventListener('change', function() {
	changeTheDay();
});

userBirthdayMonth.addEventListener('change', function() {
	changeTheDay();
});