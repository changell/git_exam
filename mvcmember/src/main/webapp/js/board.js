$(function(){
	$('#boardWriteBtn').click(function(){
		//초기화과정
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
				
		if($('input[name=subject]').val() == ''){
			$('#subjectDiv').html('제목 입력');
			$('#subject').focus();
		}else if($('textarea[name=content]').val() == ''){
			$('#contentDiv').html('제목 입력');
			$('#text').focus();		
		}else{
			
			$('form[name=boardWriteForm]').submit();	
		}

	});
});