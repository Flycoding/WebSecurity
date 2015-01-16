<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="">
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
        var released = false;
        function closePage() {
            if (!released) {
                $.ajax({
                    type: 'GET',
                    async: false,
                    url: 'window/unload',
                    success: function () {
                        released = true;
                    }
                });
            }
        }
        window.onbeforeunload=closePage;
        window.onunload=closePage;
    </script>
</head>
<body>
	<h1>Hello world!</h1>
</body>
</html>