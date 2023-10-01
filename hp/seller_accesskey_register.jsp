<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(function(){ $("title").load("head.html") });
        </script>
        <link rel="stylesheet" href="seller_accesskey_register.css">
    </head>
    <body>
        <div class="main">
            <form action="accesskeyregister" method="post" enctype="multipart/form-data">
                <h4>
                    Get Access Key By Applying.
                </h4>
                <div class="field">
                    <label for="email">Email<p>*</p></label>
                    <input type="text" name="email" id="email" required>
                </div>
                <div class="field">
                    <label for="file1">Upload License<p>*</p></label>
                    <input type="file" accept="application/pdf" name="file1" id="file1" required>
                </div>
                <div class="main-bottom">
                    <input type="submit" value="submit">
                    <button>Go Back</button>
                </div>
            </form>
        </div>
    </body>
</html>