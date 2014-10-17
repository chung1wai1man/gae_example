<%--
  Created by IntelliJ IDEA.
  User: cjemison
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Hello World Example</title>
    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/assets/css/main.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script>
        $( document ).ready(function() {
            $.getJSON( "/_ah/api/helloworld/v1/helloworldeo", function( data )
            {
                $.each(data.items, function(index, value)
                {
                    var tmp = "<tr><td>"+value.id+"</td><td>"+value.greeting+"</td></tr>" ;

                    $('#greetingTable > tbody').append(tmp);
                })
            });
        });
    </script>

</head>
<body>
<!-- Static navbar -->
<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Hello World</a>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

<!-- +++++ Welcome Section +++++ -->
<div id="ww">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 centered">
                Greetings!
            </div>
        </div>
    </div>
    <div class="container pt">
        <table id="greetingTable" class="table table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>greeting</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>\
</body>
</html>
