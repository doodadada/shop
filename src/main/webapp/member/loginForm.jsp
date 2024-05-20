<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp" %>
		<article>
			<form method="post" action="shop.do?command=login" name="loginForm">
				<h2>LogIn</h2>
				<div class="field">
					<label>User ID<input name="userid" type="text"></label>
				</div>
				<div class="field">
					<label>Password<input name="pwd" type="password"></label>
				</div>
				<div class="btn">
					<input type="submit" value="LOGIN">
					<input type="button" value="JOIN" onClick="">
					<input type="button" value="Find ID/PW" onClick="">
				</div>
			</form>
			<span style="font-size:80%; font-weight:bold; ">${message}</span>
		</article>
	</div> <!-- nav와 article 의 부모 끝 -->
</section>

<%@ include file="../footer.jsp" %>

