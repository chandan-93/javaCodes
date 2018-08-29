<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ABC Bank Net Banking</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- 
		Coded by Chandan Kumar Singh: live.cksingh@gmail.com
				GitHub id: Chandan
	 -->
<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	
	<div align="center">
	 <h3 style="color: green">
		<%
			String success = (String)request.getAttribute("Success");
				if(success!=null)
					out.print(success);
		%>
		</h3>
		
		<h3 style="color: red">
		<%
			String error = (String)request.getAttribute("Error");
			if(error!=null)
				out.print(error);
		%>
		</h3>
	</div>
    
    <div id="templatemo_top_dishes">

    	<h1 align="center">Welcome to Bank ABC Online Banking</h1>
    	
    	<h2 align="center">Our Customer enjoys</h2>
    	
        <div class="top_dishes_box">
       	  <img src="images/bank1.jpg" alt="image" />
          <h2>24x7 Banking</h2>
            <p>Get all your branch services here online with no queue. Our Banking facility is open 24x7. No more worries about bank timing.</p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/bank2.jpg" alt="image" />
            <h2>Transfer Money</h2>
          <p>Keep your loved one happy, Transfer Money instantly to anyone and to any bank anywhere in India 24x7.</p>
        </div>
        
        <div class="top_dishes_box">
       	  <img src="images/bank3.jpg" alt="image" />
            <h2>All Transactions</h2>
          <p>Your new passbook. All your transactions into one place. Every transactions is placed into records instantly.</p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/bank4.jpg" alt="image" />
            <h2>Safety</h2>
          <p>we have state of the art infrastructure and safety technical team, so that you do online banking without any fear.  </p>
        </div>
        
        
        <div class="cleaner">&nbsp;</div>
    
    </div>
    
    <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>About Us</h1>
                <img src="images/bank5.jpg" alt="image" />
                   
                    <p>We are one of the largest private bank in India. We have overs 2500 branches in India.
                    	
                    	<br><br>Branch timing
                    	
                       <br><br>Business time: 9am - 5pm	
                    </p>
                    
                    
                    
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 
        
        <jsp:include page="footer.jsp"></jsp:include>
		
    </div>


</body>
</html>