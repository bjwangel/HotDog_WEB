<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HotDog Test</title>

  <title>Material Kit by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/assets/css/material-kit.css" rel="stylesheet"/>
   
    
	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="${pageContext.request.contextPath }/assets/css/demo.css" rel="stylesheet" />
    
</head>
    
    <script>
    
    	var email;
    	var password;
    	var code;
    
    	$(function(){
    		
    		$("#joinNextButton").prop("disabled",true);
    		
// 			회원가입 폼    		
    		$("#sendMailButton").click(function() {
    			
    			var formData = new FormData();
                email=$("#inputEmail").val();
                password=$("#inputPassword").val();
                formData.append("email",email);
            	formData.append("password",password);	
    			
    			if($("#inputEmail").val()==""){
					alert("이메일을 입력해주세요");
					$("#inputEmail").focus();
					return false;
				}
				if($("#inputPassword").val()==""){
					alert("패스워드를 입력해주세요");
					$("#inputPassword").focus();
					return false;
				}
				if($("#inputPassword").val()!=$("#inputPassword2").val()){
					alert("입력한 비밀번호가 다릅니다.");
					$("#inputPassword2").focus();
					return false;
					
				}
				// 배열에 TempUser 정보 넣어서 JSON 으로 던지기         {"data":arr}
				
// 				var arr=[ $("#inputEmail").val() ,$("#inputPassword").val() ];
    		
				$.ajax({
					url:"${pageContext.request.contextPath }/user/signupform",
					type:"post",
					data: formData , 
					processData : false,
		            contentType : false
				})
				
				alert("입력하신 이메일에 인증 코드가 발송되었습니다.");
				$("#joinNextButton").prop("disabled",false);
				
				return true;
			});
    		
			//  약관동의 체크
        	$("#joinNext").prop("disabled",true);
        	
    		$("#accessCheck").change(function(){
    			if($("#accessCheck").is(":checked")){
    				console.log("체크됨");
    				$("#joinNext").prop("disabled",false);
    			}else{
    				console.log("체크 풀림");
    				$("#joinNext").prop("disabled",true);
    			}
    		})
    		
    		//  코드 체크
    		$("#checkNext").prop("disabled",true);
    		
    		$("#inputCodeCheck").click(function(){
    			
    			code=$("#inputCode").val();
            	
    			if(code==""){	
    				return;
    			}
            	
    			$.ajax({
    				url:"${pageContext.request.contextPath}/user/checkcode?code="+code,
    				type:"get",
    				dataType:"json",
    				data:"",
    				success: function(response){
    					
   					// 통신에러
   					if( response.result == "fail" ) {
   						console.log( response.message );
   						return;
   					}
					
   					// 코드가 일치할 때
					if(response.data=="yes"){
						alert("코드가 일치합니다.");
						$("#checkNext").prop("disabled",false);
					}
   					if(response.data=="no"){
   						alert("코드가 일치하지 않습니다.")
   					}
    				}
    			})
    			
    		})
    	})
    </script>
    
    
    	
				
<body>
         <nav class="navbar navbar-warning" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">HotDog</a>
                </div>
                  

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="#"><a href="#">NOTICE</a></li>
                        <li><a href="#">Community</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">personal menu <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                              <li data-toggle="modal" data-target="#info"><a href="#">Streaming</a></li>
                              <li><a href="#">Blog</a></li>
                              <li><a href="#">People</a></li>
                              <li class="divider"></li>
                              <li><a href="#">MENU</a></li>
                              <li class="divider"></li>
                              <li><a href="#">MENU</a></li>
                            </ul>
                        </li>
                    </ul>
                    
                    <!-- Button trigger modal -->
                   <div class="button col-sm-0 pull-right">
                        <button class="btn btn-danger" data-toggle="modal" data-target="#info">Info</button>
                        <button class="btn btn-info" data-toggle="modal" data-target="#downloads">DownLoad</button>
                        <button class="btn btn-success" data-toggle="modal" data-target="#signIn">sign in</button>
                        <button class="btn btn-" data-toggle="modal" data-target="#signUp">sign up</button>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#search">Search</button>
                         
                  </div>
                </div>
                
                </div>
            </nav>
	    	
    <button class="btn btn-primary" data-toggle="modal" data-target="#streamSecurity">Stream</button>
    
     <button class="btn btn-primary" data-toggle="modal" data-target="#accessTerms">join test</button>
      
    
   
    <!--*******************   Modal   **********************-->
    
    <!-- Info Modal -->
    <div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Info</h4>
			</div>
            <div class="modal-body">
				<p>Hot Dog Info</p>
	                   
               
			</div>
            
              
			<div class="modal-footer">
				<button type="button" class="btn btn-success btn-simple">More</button>
				<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
			</div>
		  </div>
	   </div>
    </div>
    <!--  End Modal -->
    
    
    <!-- Downloads Modal -->
    <div class="modal fade" id="downloads" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Download</h4>
			</div>
            <div class="modal-body">
                <p> App Download view</p>
			</div>
            
              
			<div class="modal-footer">
				<button type="button" class="btn btn-success btn-simple">Link</button>
				<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
			</div>
		  </div>
	   </div>
    </div>
    <!--  End Modal -->
    
    
    
    <!-- Sign in Modal -->
    <div class="modal fade" id="signIn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Sign in</h4>
			</div>
            <div class="modal-body">
				    
                <div class="signin">
	               <div class="form-group label-floating">
                        <label class="control-label">Email</label>
                        <input type="email" class="form-control">
	               </div>
                
                   <div class="form-group label-floating">
                        <label class="control-label">Password</label>
                        <input type="password" class="form-control">
	               </div>
                </div>
			</div>
            
              
			<div class="modal-footer">
                <button type="button" class="btn btn-warning btn-simple">Forgot Password </button>
				<button type="button" class="btn btn-success btn-simple"> Enter</button>
				<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">quit</button>
			</div>
		  </div>
	   </div>
    </div>
    <!--  End Modal -->
    
    <!-- Sign up Modal -->
    <div class="modal fade" id="signUp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Welcome to HotDog</h4>
			</div>
            <div class="modal-body">
				  <div class="form-group label-floating">
                        <label class="control-label">Name</label>
                        <input type="email" class="form-control">
	               </div>
                
                  <div class="form-group label-floating">
                        <label class="control-label">Email</label>
                        <input type="email" class="form-control">
	               </div>
                
                  <div class="form-group label-floating">
                        <label class="control-label">password</label>
                        <input type="email" class="form-control">
	               </div>
                
	           
			</div>
            
              
			<div class="modal-footer">
				<button type="button" class="btn btn-success btn-simple">Next</button>
				<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">quit</button>
			</div>
		  </div>
	   </div>
    </div>
    
    <!-- Search Modal -->
    
    <div class="modal fade" id="search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Search</h4>
			</div>
            <div class="modal-body">
				  <div class="form-group label-floating">
                        <label class="control-label">i am looking for</label>
                        <input type="email" class="form-control">
	               </div>
                
                         
	           
			</div>
            
              
			<div class="modal-footer">
                <button type="button" class="btn btn-success btn-simple">Search</button>
			</div>
		  </div>
	   </div>
    </div>
    
     <!-- StreamSecurity Modal -->
    <div class="modal fade" id="streamSecurity" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Download</h4>
			</div>
            <div class="modal-body">
                <p> App Download view</p>
			</div>
            
              
			<div class="modal-footer">
				<button type="button" class="btn btn-success btn-simple">Link</button>
				<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
			</div>
		  </div>
	   </div>
    </div>
    
    
    <!--  access terms Modal -->
    <div class="modal fade" id="accessTerms" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">이용 약관</h4>
			</div>
				<div class="modal-body">
	            	<div class="checkbox">
						<label>
							<a>약관내용 ~~~~~~~~~~~~*******************************</a>
							<a>약관내용 ~!!!~@!#!@#!@#(*!@#(#(*!@#(*$*()!@#</a>
							
							<input type="checkbox" id="accessCheck" name="optionsCheckboxes">
							약관에 동의합니다.
						</label>
					</div>
	               
	               <button id="joinNext" class="btn btn-primary" data-toggle="modal" data-target="#join">Next</button>
				   <button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
				</div>
		  </div>
	   </div>
    </div>
    
     <!-- join Modal -->
    <div class="modal fade" id="join" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">회원 가입</h4>
			</div>
			
			<div id="joinform">
	            	<div class="modal-body">
		               <div class="form-group label-floating">
		                        <label class="control-label">email</label>
		                        <input id="inputEmail" type="email" class="form-control" name="email">
		               </div>
		               <div class="form-group label-floating">
		                        <label class="control-label">password</label>
		                        <input id="inputPassword" type="password" class="form-control" name="password">
		               </div>
		               <div class="form-group label-floating">
		                        <label class="control-label">password</label>
		                        <input id="inputPassword2" type="password" class="form-control">
		               </div>
		               
		               <button type="button"  id="sendMailButton"class="btn btn-success btn-simple">Send Mail</button>
		               <button type="button"  id="joinNextButton"class="btn btn-warning btn-simple" data-toggle="modal" data-target="#CodeCheckModal" >Next</button>
					   <button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
					</div>
			</div>
			
		  </div>
	   </div>
    </div>
    
    
    <!-- Code Check Modal -->
    <div class="modal fade" id="CodeCheckModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	   <div class="modal-dialog">
		  <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
				<h4 class="modal-title">Code Check</h4>
			</div>
			
			<div id="check">
				<form>
	            	<div class="modal-body">
	            	
		               <div class="form-group label-floating">
		                        <label class="control-label">Input Your Code..</label>
		                        <input id="inputCode" type="text" class="form-control" name="code">
		               </div>
		               
		               <button type="button" id="inputCodeCheck" class="btn btn-warning btn-simple" >Check</button>
		               <input id="checkNext" type="submit"  class="btn btn-success btn-simple" value="next"/>
					   <button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
			
		  </div>
	   </div>
    </div>
    
    
    
    <!--  End Modal -->
 

    
    <!--   Core JS Files   -->
	<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/assets/js/material.min.js"></script>
	

	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="${pageContext.request.contextPath }/assets/js/nouislider.min.js" type="text/javascript"></script>

	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
	<script src="${pageContext.request.contextPath }/assets/js/material-kit.js" type="text/javascript"></script>

	
    </body>
</html>