function checkForm(frm) {
	console.log(frm);
	
	var name = frm.userName.value.trim();
	var id = frm.id.value.trim();
	var password = frm.password.value.trim();
	
	//	TODO: 추가 검증
	if (name.length < 3) {
		alert("이름은 3자리 이상의 문자입니다.");
		frm.name.focus();
	} else if (id.length < 5) {
		alert("아이디는 5자리 이상으로 입력해 주세요.");
		frm.id.focus();
	} else if (password.length < 8) {
		alert("비밀번호는 8자리 이상이어야 합니다.");
		frm.password.focus();
	} else {	//	검증 통과
		return true;	//	폼 전송
	}
	
	return false;	//	onsubmit 이벤트에서 true여야 전송
}
function checkid(idField, url) {
	console.log("id field:", idField.value);
	
	//	Ajax 호출
	if (idField.value.trim().length == 0) {
		alert("id 을 입력해 주세요");
		return;
	}
	$.ajax({
		url: url,
		type: "GET",
		dataType: "json",
		data: {
			id: idField.value.trim()
		}, 
		success: function(result) {
			console.log("Result:", result);
			//	hidden field: check 값을 변경
			if (result.data == true) {	//	중복 이메일
				idField.form.check.value = "f";
				alert("이미 가입된 이메일입니다");
			} else {
				idField.form.check.value = "t";
				alert("가입하실 수 있는 이메일입니다");
			}
		},
		error: function(xhr, status, error) {
			console.error("Status:", status);
			console.error("Response:", xhr);
			console.error("Error:", error);
			
			idField.form.check.value = "f";
		}		
	});
}