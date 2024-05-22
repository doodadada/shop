<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<section>
	<%@ include file="sub_image_menu.jsp"%>
	<article>
		<form action="shop.do?command=writeQna" method="post">
			<h2>Q & A Write</h2>
			<div class="field">
				<label>작성자</label> <input type="text" name="userid"
					value="${loginUser.userid}" readonly>
			</div>
			<div class="field">
				<label>제목</label><input type="text" name="subject">
			</div>
			<div class="field">
				<label>질문내용</label>
				<textarea name="content" rows="12" cols="83"></textarea>
			</div>

			<div class="btn">
				<input type="submit" value="작성하기" />
			</div>
		</form>
	</article>
</section>
<%@ include file="../footer.jsp"%>