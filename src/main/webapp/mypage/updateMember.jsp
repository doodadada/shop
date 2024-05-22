<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<section>
	<%@ include file="sub_image_menu.jsp"%>
	<article>
	<form action="shop.do?command=updateMember" method="post" name="joinForm">
					<h2>Update Member</h2>
					
					<h3>Basic Info</h3>
					<div class="field">
						<label>User ID</label>
							<input type="text" name="userid" value="${loginUser.userid}" readOnly>
					</div>
					<div class="field"><label>Password</label><input type="password"  name="pwd"></div>
					<div class="field">
						<label>Retype Password</label><input type="password"  name="pwdCheck"></div>
					<div class="field"><label>Name</label><input type="text"  name="name"  value="${loginUser.name}"></div>
					<div class="field"><label>Phone</label><input type="text"  name="phone"   value="${loginUser.phone}"/></div>
					<div class="field"><label>E-Mail</label><input type="text"  name="email"  value="${loginUser.email}" /></div>
					
					<h3>Optional Info</h3>
					<div class="field">
						<label>Zip Code</label>
						<div>
							 <input type="text" name="zip_num" readonly  value="${loginUser.zip_num}">
							 <input type="button" value="우편번호 찾기" onclick="post_zip()">
						</div>
					</div>
					<div class="field">
						<label>Address</label><input type="text"  name="address1"   value="${loginUser.address1}" readonly />
					</div>
					<div class="field">
						<label>detail Address</label><input type="text" name="address2"  value="${loginUser.address2}"/>
					</div>
					
					<div class="btn">
			   			<input type="button" value="회원정보 수정" onClick="go_updateMember()">
			   		</div>
					
				</form>
	</article>
</section>
<%@ include file="../footer.jsp"%>