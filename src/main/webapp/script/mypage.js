function go_cart(){
	if(document.formm.quantity.value == ""){
		alert("수량을 입력하세요");
		document.formm.quantity.focus();
	}else{
		document.formm.action ='shop.do?command=cartInsert';
		document.formm.submit();
	}
	
}


function go_cart_delete(){
	// 자바스크립트에서 html form 태그 내의 입력란들에 접근할 때는 name이 같은 것들은 배열로 인식이 됩니다.
	// document.cartForm.cseq 들이 갯수만큼 배열로 인식됩니다. document.cartForm.cseq[0] ~
	// 만약 해당이름의 태그가 한개라면 배열이 아니라 그냥 변수처럼 인식합니다
	// 배열이라면 .length 라는 속성을 쓸 수가 있고, 배열이 아니라면 length 속성은 undefined 가 됩니다.

	var count=0;
	// 혹시라도 체크박스에 체크를 하나도 안넣고 삭제버튼을 눌렀는지 검사
	if(document.cartForm.cseq.length == undefined){
		// 체크 박스가 한개라면, 체크박스가 단일변수로 인식된다면
		if(document.cartForm.cseq.checked==true){
			count++;
		}
	}else{
		// 체크 박스가 두개 이상이라면, 체크박스들이 배열이라면
		for(var i = 0; i<document.cartForm.cseq.length;i++){
			if(document.cartForm.cseq[i].checked ==true){
				count++;
			}
		}
	}
	
	if(count ==0){
		alert("삭제할 항목을 선택하세요");
	}else{
		var ans = confirm("선택한 항목을 삭제할까요?");
		if(ans){
			document.cartForm.action="shop.do?command=cartDelete";
			document.cartForm.submit();
		}
	}
}


function go_order_insert(){
	var count=0;
	if(document.cartForm.cseq.length == undefined){
		if(document.cartForm.cseq.checked==true){
			count++;
		}
	}else{
		for(var i = 0; i<document.cartForm.cseq.length;i++){
			if(document.cartForm.cseq[i].checked ==true){
				count++;
			}
		}
	}	
	if(count ==0){
		alert("주문할 항목을 선택하세요");
	}else{
		var ans = confirm("선택한 항목을 주문할까요?");
		if(ans){
			document.cartForm.action="shop.do?command=orderInsert";
			document.cartForm.submit();
		}
	}
}

function go_order(){
	var ans = confirm("현재 상품을 주문할까요?");
		if(ans){
			document.formm.action="shop.do?command=orderInsertOne";
			document.formm.submit();
		}
}

function go_updateMember(){
	if( document.joinForm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");	    
	    document.joinForm.pwd.focus();
	} else if( document.joinForm.pwd.value != document.joinForm.pwdCheck.value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
	    document.joinForm.pwd.focus();
	} else if( document.joinForm.name.value == "") {
	    alert("이름을 입력해 주세요.");	    
	    document.joinForm.name.focus();
	} else if( document.joinForm.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");	   
	    document.joinForm.phone.focus();
	}else if( document.joinForm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.joinForm.email.focus();
	} else{
	    document.joinForm.submit();
	}
}

function widthdrawal(){
	var ans = confirm("정말로 탈퇴하시겠습니까?")
	if(ans){
		location.href="shop.do?command=deleteMember"
	}
}