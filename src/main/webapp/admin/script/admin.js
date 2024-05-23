function loginCheck(){
	if(document.loginForm.adminid.value==""){
		alert("아이디를 입력하세요");
		document.loginForm.adminid.focus();
		return false;
	}else if(document.loginForm.pwd.value==""){
		alert("패스워드를 입력하세요");
		document.loginForm.pwd.focus();
		return false;
	}else{
		return true;
	}
}

function go_search(command){
	var url="shop.do?command="	+command+"&page=1"
	document.frm.action = url;
	document.frm.submit();
}


function go_detail(pseq){
	location.href="shop.do?command=adminProductDetail&pseq="+pseq;
}

function go_wrt(){
	location.href="shop.do?command=adminProductWriteForm";
}

function cals(){
	var value1=document.productWriteFrm.price1.value;
	var value2=document.productWriteFrm.price2.value;
	if(value1==""||value2==""){
		return;
	}else{
		document.productWriteFrm.price3.value = value2 - value1;
	}
}

function go_save(){
	var theForm = document.productWriteFrm;
	if(theForm.kind.value==""){
		alert("상품분류를 선택하세요");
		theForm.kind.focus();
	}else if(theForm.name.value==""){
		alert("상품명을 선택하세요");
		theForm.name.focus();
	}else if(theForm.price1.value==""){
		alert("원가를 선택하세요");
		theForm.price1.focus();
	}else if(theForm.price2.value==""){
		alert("판매가 선택하세요");
		theForm.price2.focus();
	}else if(theForm.content.value==""){
		alert("상품상세를 선택하세요");
		theForm.content.focus();
	}else if(theForm.image.value==""){
		alert("상품이미지를 선택하세요");
		theForm.image.focus();
	}else{
		theForm.action = "shop.do?command=adminProductWrite";
		theForm.submit();
	}
}

function go_mod(pseq){
	var url = location.href="shop.do?command=adminProductUpdateForm="+pseq;
	location.href=url;
}

function deleteProduct(pseq){
	
}


