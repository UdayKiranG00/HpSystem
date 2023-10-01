<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>
            Ferti market 
        </title>
        <link rel="stylesheet" href="register.css">
    </head>
    <body>
        <div class="main">
            <form action="sellerregistration" method="post">
                <h2>Seller Registration</h2>
                <div class="field">
                    <label for="firstname">First Name<p>*</p></label>
                    <input type="text" name="firstname" id="firstname" required>
                </div>
                <div class="field">
                    <label for="lastname">Last Name<p>*</p></label>
                    <input type="text" name="lastname" id="lastname" required>
                </div>
                <div class="field">
                    <label for="email">Email<p>*</p></label>
                    <input type="text" name="email" id="email" required>
                </div>
                <div class="field">
                    <label for="mobile">Mobile Number<p>*</p></label>
                    <input type="number" name="mobile" id="mobile" required>
                </div>
                <div class="field radio">
                    <p>*</p>
                    <input type="radio" name="gender" id="male" value="male" required>
                    <label for="male">Male</label>
                    <input type="radio" name="gender" id="female" value="female" required>
                    <label for="female">Female</label>
                    <input type="radio" name="gender" id="other" value="other" required>
                    <label for="other">Other</label>
                </div>
                <div class="field">
                    <label for="password">Password<p>*</p></label>
                    <input type="text" name="password" id="password" required>
                </div>
                <div class="field">
                    <label for="repeatpassword">Re-enter Password<p>*</p></label>
                    <input type="text" name="repassword" id="repeatpassword"  required>
                </div>
                <div class="field">
                    <label for="address">Address<p>*</p></label>
                    <textarea  name="address" id="address" rows="1" columns="30" required></textarea>
                </div>
                <h4>Shop Details</h4>
                <div class="field">
                    <label for="shopname">Shop Name<p>*</p></label>
                    <input type="text" name="shopname" id="shopname" required>
                </div>
                <div class="field">
                    <label for="streetname">Street Name<p>*</p></label>
                    <input type="text" name="streetname" id="streetname" required>
                </div>
                <div class="field">
                    <label for="locality">Locality<p>*</p></label>
                    <input type="text" name="locality" id="locality" required>
                </div>
                <div class="field">
                    <label for="mandal">Mandal</label>
                    <input type="text" name="mandal" id="mandal">
                </div>
                <div class="field">
                    <label for="district">District<p>*</p></label>
                    <input type="text" name="district" id="district">
                </div>
                <div class="field">
                    <label for="state">State<p>*</p></label>
                    <input type="text" name="state" id="state">
                </div>
                <div class="field">
                    <label for="pincode">Pincode<p>*</p></label>
                    <input type="number" name="pincode" id="pincode">
                </div>
                <input type="submit" value="submit">
            </form>
        </div>
    </body>
</html>