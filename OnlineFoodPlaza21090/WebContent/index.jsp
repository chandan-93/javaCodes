<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodplaza.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online FoodPlaza - Fresh & Healthy Snacks</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%
		String adminLog = (String)session.getAttribute("adminLog");
		String customerLog = (String)session.getAttribute("customerLog");
	%>
	
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	
    <div align="center" style="color: green"> 
    	 <% if(adminLog!=null) 
    		{
    			String s=(String)request.getAttribute("Success");
    			if(s!=null)
    			{
    				out.print(s);
    			}
    		}
    	 	else if(customerLog!=null)
    	 	{
    	 		String s = (String)request.getAttribute("Success");
    	 		if(s!=null)
    	 		{
    	 			out.print(s);
    	 		}
    	 	} 
    	 	else
    	 	{
    	 		String s = (String)request.getAttribute("Success");
    	 		if(s!=null)
    	 		{
    	 			out.print(s);
    	 		}
    	 	}
    	 %>
    </div>
    
    <div id="templatemo_top_dishes">

    	<h1 align="center">Welcome to Online FoodPlaza. A Place for Healthy Snacks.</h1>
    	
    	<h2 align="center">Recommended Snacks</h2>
    	
        <div class="top_dishes_box">
       	  <img src="images/sandwich.jpg" alt="image" />
          <h2>Sandwich</h2>
            <p>Our Sandwich is tasty as well as healthy. Made up of fresh salad.</p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/chickenPizza.jpg" alt="image" />
            <h2>Chicken Pizza</h2>
          <p>Our Chicken Pizza is tasty and low in calories.</p>
        </div>
        
        <div class="top_dishes_box">
       	  <img src="images/vegBurger.jpg" alt="image" />
            <h2>Veg Burger</h2>
          <p>Our Veg Burger is low in calories and filled with tasty salad.</p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/chickenBurger.jpg" alt="image" />
            <h2>Chicken Burger</h2>
          <p>Our Chicken Burger is tasty and high in protein.</p>
        </div>
        
        <div class="cleaner">&nbsp;</div>
    
    </div> <!-- end of top dishes -->
    
    <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to Online FoodPlaza</h1>
                <img src="images/pizza2.jpg" alt="image" />
                   
                    <p>We make fresh & healthy snacks for you and delivers in 30mins.
                    	
                    	<br><br>Cash on Delivery.
                    	
                    
                       <br><br>Business time: 9am - 9pm	
                    </p>
                    
                    
                    
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    <h1>Healthy Snacks</h1>
                    <div class="right_column_section">
	                    <h2>In 30 Mins</h2>
                        <img src="images/snacks.jpg" alt="image" />
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 	
    </div>


<jsp:include page="Footer.jsp"></jsp:include> 
</div><!-- end of container -->

</body>
</html>