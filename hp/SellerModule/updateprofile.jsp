<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(function(){ $("title").load("../head.html") });
            $(function(){ $("nav").load("navigator.html") });
        </script>
        <link rel="stylesheet" href="navigator.css">
        <link rel="stylesheet" href="updateprofile.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    </head>
    <body>
    <%
    try{
    	String semail = "kn";
    	String smobile = session.getAttribute("sellermobile").toString();
    	String saddress = session.getAttribute("selleraddress").toString();
    	
    }catch(Exception e){
    	
    }
    %>
        <nav></nav>
        <section class="content">
            <div class="container">
                <h2>
                    Update Profile
                </h2>
                <form action="updatesellerprofile" method="post">
                    <div class="fields">
                        <label for="email">Email<p>*</p></label>
                        <input type="text" name="email" id="email" value="" required>
                    </div>
                    <div class="fields">
                        <label for="mobile">Mobile Number <p>*</p></label>
                        <input type="text" name="mobile" id="mobile" value="" required>
                    </div>
                    <div class="fields">
                        <label for="address">Address<p>*</p></label>
                        <textarea  type="text" name="address" id="address" value="" required></textarea>
                    </div>
                    <div class="btns">
                        <input type="submit" value="update">
                        <button onclick="">clear</button>
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>