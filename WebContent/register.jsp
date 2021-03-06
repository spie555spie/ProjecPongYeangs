<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.owner_register.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<script type="text/javascript">
	/*ตรวจสอบการว่ากรอก email ถูกต้องหรือป่าว*/
	function check_email(ch) {
		var regExp = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
		if (!regExp.test(ch)) {
			alert("รูปแบบ Email ไม่ถูกต้อง");
			register.email.value = "";
			return false;
		}
	}
	/*ตรวจสอบการว่ากรอก idcard ถูกต้องหรือป่าว*/
	function check_idcard(ch) {
		var regExp = /^[0-9]{13}$/;
		if (!regExp.test(ch)) {
			alert("กรถณากรอก เลขบัตรประชาชน 13 หลัก");
			register.idcard.value = "";
			return false;
		}
	}
	/*ตรวจสอบว่าจะไม่เป็นค่าว่าง*/
	function validate() {
		var firstname = document.forms["register"]["firstname"].value;
		var lastname = document.forms["register"]["lastname"].value;
		var idcard = document.forms["register"]["idcard"].value;
		var phone = document.forms["register"]["phone"].value;
		var email = document.forms["register"]["email"].value;
		var password = document.forms["register"]["password"].value;
		var confirmpassword = document.forms["register"]["confirmpassword"].value;

		var checkfirstname = /^[ก-์A-Za-z]{2,50}$/;
		var checklastname = /^[ก-์A-Za-z]{2,50}$/;
		var checkpassword = /^[a-zA-z0-9]{5,16}$/;
		var checkidcard = /^[0-9]{13}$/;
		var checkphone = /^[0]\d{9}$/;

		if (firstname == "") {
			alert("กรุณากรอก ชื่อจริงตามบัตรประชาชน ด้วยครับ/ค่ะ");
			register.firstname.focus();
			return false;
		}

		if (!firstname.match(checkfirstname)) {
			alert("กรุณากรอก ชื่อจริงเป็นภาษาไทยเท่านั้น ครับ/ค่ะ");
			register.firstname.focus();
			return false;
		}

		if (lastname == "") {
			alert("กรุณากรอก นามสกุล ด้วยครับ/ค่ะ");
			register.lastname.focus();
			return false;
		}
		if (!lastname.match(checklastname)) {
			alert("กรุณากรอก นามสกุลเป็นภาษาไทยเท่านั้น ครับ/ค่ะ");
			register.lastname.focus();
			return false;
		}

		if (idcard == "") {
			alert("กรุณากรอก บัตรประชาชน/Passport ด้วยครับ/ค่ะ");
			register.idcard.focus();
			return false;
		}

		if (!idcard.match(checkidcard)) {
			alert("กรุณากรอก บัตรประชาชน 13 หลัก ด้วยครับ/ค่ะ");
			register.lastname.focus();
			return false;
		}

		if (bithday == "") {
			alert("กรุณากรอก วัน/เดือน/ปี เกิด ด้วยครับ/ค่ะ");
			register.bithday.focus();
			return false;
		}
		if (phone == "") {
			alert("กรุณากรอก เบอร์โทรศัพท์ด้วยครับ/ค่ะ");
			register.phone.focus();
			return false;
		}
		if (!phone.match(checkphone)) {
			alert("ต้องขึ้นต้นด้วยเลข 0 เท่านั้น ครับ/ค่ะ");
			register.phone.focus();
			return false;
		}
		if (email == "") {
			alert("กรุณากรอก อีเมล์  ด้วยครับ/ค่ะ");
			register.email.focus();
			return false;
		}

		if (password == "") {
			alert("กรุณากรอก รหัสผ่าน ด้วยครับ/ค่ะ");
			register.password.focus();
			return false;
		}

		if (!password.match(checkpassword)) {
			alert(" รหัสผ่าน ต้องเป็นตัวอักษรหรือตัวเลข เท่านั้น");
			register.password.focus();
			return false;
		}

		if (confirmpassword == null || confirmpassword == "") {
			alert("กรุณากรอก ยืนยันรหัสผ่าน");
			register.confirmpassword.focus();
			return false;
		}

		if (confirmpassword != password) {
			alert("ยืนยันรหัสผ่าน ไม่ตรงกับ รหัสผ่าน");
			register.confirmpassword.value = "";
			register.confirmpassword.focus();
			return false;
		}

	}
</script>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<div class="row margin-vert-30">
				<!-- Register Box -->
				<div class="col-md-12">
					<form class="signup-page" action="RegisterServlet" method="post"
						name="register">
						<div class="signup-header"></div>

						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<h2>สมัครสมาชิกใหม่</h2>
								<p>
								<h3>ส่วนที่ 1</h3>
								</p>
								<table class="table table-hover">
									<tr>
										<td><label>ชื่อจริง (FirstName) <span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="text"
											name="firstname" id="firstname" placeholder="สุขภาพดี"></td>

									</tr>
									<tr>
										<td><label>นามสกุล (LastName) <span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="text"
											name="lastname" id="lastname" placeholder="มีสุข"></td>
									</tr>
									<tr>
										<td><label>รหัสบัตรประชาชน (Id Card) <span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="text" name="idcard"
											id="idcard" placeholder="1234567891230">
											<div></div></td>
									</tr>
									<tr>
										<td><label>วันเกิด (BrithDay) <span
												class="color-red">*</span></td>
										<td><input class="form-control" type="date"
											min="1950-01-01" name="bithday" id="bithday"></td>
									</tr>
									<tr>
										<td><label>เบอร์โทรศัพท์ (Phone)<span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="text" name="phone"
											id="phone" placeholder="0812345678"></span></td>
									</tr>
									<tr>
										<td><label>อีเมล์ (Email)<span class="color-red">*</span></label></td>
										<td><input class="form-control" type="text" name="email"
											id="email" onblur="check_email(this.value)"
											placeholder="pongyeang@gmail.com"> <span
											class="messageemail"></span><span class="messageemails"></span></td>
									</tr>
								</table>
								<p>
								<h3>ส่วนที่ 2</h3>
								</p>
								<table class="table table-hover">
									<tr>
										<td><label>ชื่อผู้ใข้งาน (UserName)<span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="text"
											name="username" id="username" readonly="readonly"></td>
									</tr>
									<tr>
										<td><label>รหัสผ่าน (Password) <span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="password"
											name="password" id="password"></td>
									</tr>
									<tr>
										<td><label>ยืนยันรหัส่าน (Confirm Password) <span
												class="color-red">*</span></label></td>
										<td><input class="form-control" type="password"
											name="confirmpassword" id="confirmpassword"></td>
									</tr>
								</table>
								<center>
									<button class="btn btn-primary" type="submit" id="btnSubmit"
										onclick="return validate()">สมัครสมาชิก</button>
								</center>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- End Register Box -->
	</div>
	<!-- === END CONTENT === -->
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#email').keyup(function() {
			$('#username').val($(this).val());
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() { //หน้าเว็บโหลดเสร็จทำงานฟังก์ชันนี้			
		$("#idcard").bind("input", function(e) { //ถ้ามีการเปลี่ยนแปลงค่าใน textbox ที่มี  id = idcard
			var self = $(this); //ตัวแปร อ้างอิง ถึง element ตัวนี้
			var input = self.val(); //ดึงค่าจาก textbox
			if (input.length == 13) { //เช็คจำนวน ใน textbox 
				var params = {
					idcard : input
				}; //สร้าง parameter idcard ที่อยู่ในหน้า servlet name = (key : value)
				checkFromServer(params, self); //เรียกใช้ ฟังก์ชัน
			}
		});
		function checkFromServer(params, self) { //Ajax 
			var div = self.closest("div").find("div");
			var msg = "สามารถใช้หมายเลขบัตรประชาชนนี้ได้";
			$.ajax({
				url : "JSONCheckRegisterServlet",
				data : params,
				method : "POST",
				beforeSend : function() {
					div.text("").addClass("loader");
				},
				success : function(response) {
					if (response == "true") {
						msg = "หมายบัตรประชาชนนี้ได้ถูกใช้งานแล้ว";
						alert("หมายบัตรประชาชนนี้ได้ถูกใช้งานแล้ว");
						register.idcard.value = "";
						register.idcard.focus();
					}
				},
				complete : function() {
					div.removeClass("loader").text(msg);
				},
				error : function() {
					console.log("error");
				}
			});
		}
		;
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#btnSubmit').click(function() {
							var check = check_email();
							check.success(function(data) {
								if (data != 1) {
									$('#register').submit();
									return false;
								}
							});
						});
						$('#email')
								.focusout(
										function() {
											var check = check_email();
											check
													.success(function(response) {
														if (response == "true") {
															$('.messageemail')
																	.html(
																			'อีเมล์นี้มีคนใช้แล้ว กรุณาเปลี่ยนอีเมล์ใหม่');
															alert("'อีเมล์นี้มีคนใช้แล้ว กรุณาเปลี่ยนอีเมล์ใหม่");
															register.email.value = "";
															register.email
																	.focus();
														} else {
															$('.messageemails')
																	.html(
																			'คุณสามารถใช้อีเมล์นี้ได้');
														}
													});
										});
					});
	function check_email() {
		return $.ajax({
			type : 'POST',
			data : {
				email : $('#email').val()
			},
			url : 'JSONCheckRegisterServlet'
		});
	}
</script>

<style>
.messageemail {
	font-size: 14px;
	color: red;
}
.messageemails {
	font-size: 14px;
	color: green;
}
</style>
</html>