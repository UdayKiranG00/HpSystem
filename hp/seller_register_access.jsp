<html>
<head>
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(function(){ $("title").load("head.html") });
        </script>
        <link rel="stylesheet" href="seller_register_access.css">
    </head>
    <body>
        <div class="main">
            <form action="registeraccess" method="post">
                <h4>
                    Enter email and access code for registration.
                </h4>
                <div class="field">
                    <label for="email">Email<p>*</p></label>
                    <input type="text" name="email" id="email" required>
                </div>
                <div class="field">
                    <label for="accesskey">Access Key<p>*</p></label>
                    <input type="text" name="accesskey" id="accesskey" required>
                </div>
                <div class="main-bottom">
                    <input type="submit" value="submit">
                    <button><a href="seller_accesskey_register.jsp" style="text-decoration:none;color:white;">Get Access Key</a></button>
                </div>
            </form>
        </div>
    </body>
</html>