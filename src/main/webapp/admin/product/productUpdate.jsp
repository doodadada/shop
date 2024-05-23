<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<article>
	<form name="productWriteFrm" method="post" enctype="multipart/form-data"> 
		<h2>상품 등록</h2>
		<div class="field">
			<label>상품분류</label>
			<div>
				<select name="kind" style="width:200px; height:20px; font-size:105%;">
					<option value="">선택하세요</option>
					<c:forEach items="${kindList}" var="kind" varStatus="status">
						<option value="${status.count}">${kind}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="field">
			<label>상품명</label>
			<input type="text" name="name" />
		</div>
		<div class="field">
			<label>원가</label>	
			<input type="text" name="price1" style="margin-right:20px;" onKeyup="cals();" />
			<label>판매가</label>
			<input type="text" name="price2" style="margin-right:20px;" onKeyup="cals();" />
			<label>마진</label>
			<input type="text" name="price3" readonly/>
		</div>
		<div class="field">
			<label>상세설명</label>
			<textarea name="content" rows="8" style="flex:4;"></textarea>
		</div>
		<div class="field">
			<label>상품이미지</label>
			<input type="file" name="image" />
		</div>
		<div class="btn">
				<input class="btn" type="button" value="상품등록" onClick="go_save()">
				<input class="btn" type="button" value="목록" onClick="location.href='shop.do?command=adminProductList'">
			</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>