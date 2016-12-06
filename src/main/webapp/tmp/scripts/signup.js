$(document).ready(function() {
	$("#returnToSignin").click(function() {
		window.location = "../index.html"
	});

	$("#signup").click(function(event) {
		var name = $("#inputNameSignup")[0].value;
		var sex = $("#inputSexSignup")[0].value;
		var phone = $("#inputPhoneSignup")[0].value;
		var address = $("#inputAddressSignup")[0].value;
		var username = $("#inputUsernameSignup")[0].value;
		var password = $("#inputPasswordSignup")[0].value;

		var na = validator.isNameValid(name);
		var se = validator.isSexValid(sex);
		var ph = validator.isPhoneValid(phone);
		var ad = validator.isAddressValid(address);
		var us = validator.isUsernameValid(username);
		var ps = validator.isPasswordValid(password);
		if (!na) {
			$("#signupErrorMessage").text(validator.form.name.errorMessage);	
		} else if (!se) {
			$("#signupErrorMessage").text(validator.form.sex.errorMessage);
		} else if (!ph) {
			$("#signupErrorMessage").text(validator.form.phone.errorMessage);
		} else if (!ad) {
			$("#signupErrorMessage").text(validator.form.address.errorMessage);
		} else if (!us) {
			$("#signupErrorMessage").text(validator.form.username.errorMessage);
		} else if (!ps) {
			$("#signupErrorMessage").text(validator.form.password.errorMessage);
		} else {
			$.post("/signup", {inputNameSignup: name, inputSexSignup: sex, inputPhoneSignup: phone, inputAddressSignup: address, inputUsernameSignup: username, inputPasswordSignup: password})
				.done(function(data) {
					$("#signupErrorMessage").text("");
					alert("登录成功");
					window.location = "/home";
				})
				.fail(function(data) {
					$("#signupErrorMessage").text("用户名已被使用");
				});
		}  
	});
});