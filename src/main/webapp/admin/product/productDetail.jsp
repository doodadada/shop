<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/admin/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<article>
	<form>
		<h2>상품 상세 보기</h2>
		<div class="field"
			style="border-top: 2px solid blueviolet">
			<label>상품분류</label>
			<div>${kind}</div>
		</div>
		<div class="field"
			style=" border-top: 1px dotted blueviolet">
			<label>상품명</label>
			<div>${productVO.name}</div>
		</div>
		<div class="field"
			style="border-top: 1px dotted blueviolet">
			<label>원가</label>
			<div><fmt:formatNumber value="${productVO.price1}"/></div>
		</div>
		<div class="field"
			style=" border-top: 1px dotted blueviolet">
			<label>판매가</label>
			<div><fmt:formatNumber value="${productVO.price2}"/></div>
		</div>
		<div class="field"
			style=" border-top: 1px dotted blueviolet">
			<label>마진</label>
			<div><fmt:formatNumber value="${productVO.price3}"/></div>
		</div>
		<div class="field"
			style="border-top: 1px dotted blueviolet">
			<label>상세설명</label>
			<div>${productVO.content}</div>
		</div>
		<div class="field"
			style=" border-top:1px dotted blueviolet; border-bottom: 2px solid blueviolet">
			<label>상품이미지</label>
			<div>
				<img src="product_images/${productVO.savefilename}" width="300">
			</div>
		</div>
		<div class="btn">
				<input class="btn" type="button" value="수정" onClick="go_mod('${productVO.pseq}')">
				<input class="btn" type="button" value="삭제" onClick="deleteProduct('${productVO.pseq}')">
				<input class="btn" type="button" value="목록" onClick="location.href='shop.do?command=adminProductList'">
		</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>