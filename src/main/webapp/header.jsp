<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/header_footer.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/section.css">
</head>
<body>

<div id="wrap">

	<header>
		<nav id="top_menu">
			<div id="logo">
				<a href="/">
					<img src="images/logo.png" width="180" height="100">
				</a>
			</div>
			<div class="gnb">
				<c:choose>
					<c:when test="${empty loginUser}">
						<a href="shop.do?command=loginForm">LOGIN</a>
						<a href="">JOIN</a>
					</c:when>
					<c:otherwise>
						<a href="#">${loginUser.name}(${loginUser.userid})</a>
						<a href="">LOGOUT</a>
					</c:otherwise>
				</c:choose>
				<a href="">CART</a>
				<a href="">MY PAGE</a>
				<a href="">고객센터</a>
			
			</div>
			<div class="hmenu"><div></div><div></div><div></div>		</div>
		</nav>
		<nav id="category_menu">
				<a href="">Heels</a>
				<a href="">Boots</a>
				<a href="">Sandal</a>
				<a href="">Sneakers</a>
				<a href="">Sleeper</a>
		</nav>
	</header>