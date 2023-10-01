<html>
    <head>
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(function(){ $("title").load("../head.html") });

            $(function(){ $("nav").load("navigator.html")});
        </script>
        <link rel="stylesheet" href="navigator.css">
        <link rel="stylesheet" href="updateprofile.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    </head>
    <body>
        <nav></nav>
        <section class="content">
            <div class="container">
                <h2>
                    Change Password
                </h2>
                <form action="changesellerpassword" method="post">
                    <div class="fields">
                        <label for="oldpassword">Old Password<p>*</p></label>
                        <input type="text" name="oldpassword" id="oldpassword" required>
                    </div>
                    <div class="fields">
                        <label for="newpassword">Enter New Password <p>*</p></label>
                        <input type="text" name="newpassword" id="newpassword" required>
                    </div>
                    <div class="fields">
                        <label for="repassword">Re-Enter Password<p>*</p></label>
                        <input type="text" name="repassword" id="repassword" required>
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
