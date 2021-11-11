//Javascript
function checkId(){
   
   var id=document.getElementById("id").value; //자바 스크립트
   //var id = $('#id').val(); 					 제이쿼리
   
   if(id == ""){
      //alert("아이디를 입력하세요.");
	  
      document.getElementById("idDiv").innerText="아이디를 입력하세요.";
   }else{
		
		window.open("http://localhost:8080/mvcmember/member/checkId.do?id="+id, "checkId",'width=600, top=200,height=400');
      /*window.open("/mvcmember/CheckIdService?id="+id,
      "checkId",//타켓 - 아무 단어나 쓰면 창이 중복 뜨는걸 막아준다. 
         "width=300 height=500 to200 left=700");*/
   }
}

function checkIdInput(id){
    opener.document.getElementById("id").value = id;
	//opener.writeForm.id.value = $('#checkId').val();
	opener.document.getElementById("idtf").value = true;
	opener.document.getElementById("idDiv").innerText = "";
	window.close();
	//opener.writeForm.pwd.focus();
	
	//$('#id', opener.document).val($('#checkId').val());
	//$('#pwd', opener.document).focus();
}
$('#zipcodeBtn').click(function(){
	window.open("/mvcmember/member/checkPost.do", "checkPost", "width=500 height=500 top=200 left=700");
});

$('#addressA').click(function(){
	alert($('#zipcode').val() + ", " + $('#address'));
});

function idUnCheck(){
	document.getElementById("idtf").value = false;
	
}
//JQuery가 JS보다 최신에 나왔으므로, 더 간결하다
//JavaScript 방식은 Button, onclick 방식으로 작성한다
//JQuery는 버튼의 주소를 참조하는 방식으로 작성한다 (밑의 $ 부분참조)
$(function(){
   //회원가입
   $('#writeBtn').click(function(){
      $('#nameDiv').empty();
      $('#idDiv').empty();
      $('#pwdDiv').empty();
      $('#repwdDiv').empty();
      
      //name 속성
      if($('input[name="name"]').val() == '') {
         $('#nameDiv').html('이름 입력');
         $('#name').focus();
      }else if($('input[name="id"]').val()==''){
         $('#idDiv').html('아이디 입력');
		 $('#id').focus();
	  }else if($('input[name="pwd"]').val()==''){
         $('#pwdDiv').html('비밀번호 입력');
      }else if($('input[name="pwd"]').val() != $('input[name="repwd"]').val()){
         $('#repwdDiv').html('비밀번호 틀림');
      }else if($('input[name="idtf"]').val() == "false"){
		 $('#idDiv').html('아이디 중복체크 해주세요');
	  }else 
         $('form[name="writeForm"]').submit();
         
      //id 속성
      /*if($('#name').val() == '') $('#nameDiv').html('이름 입력'); */
   });
   
   //로그인
   $('#loginBtn').click(function(){
      $('#idDiv').empty();
         $('#pwdDiv').empty();

      if($('input[name="id"]').val()=='')
         $('#idDiv').html('아이디 입력');
      else if($('input[name="pwd"]').val()=='')
         $('#pwdDiv').html('비밀번호 입력');
      else 
         $('form[name="loginForm"]').submit();
   });
});