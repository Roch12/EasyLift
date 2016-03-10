<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 04/03/2016
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<html>
<head>
    <title>EasyLift</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/resources/css/clean-blog.css" />
    <link rel="stylesheet" href="/resources/css/main.css" />

    <!-- Custom fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom-simple navbar-fixed-top">
    <div class="container-fluid">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <li style="color: black"><a href="/">Home</a></li>
                <li style="color: black"><a href="/Journey/Search">Search</a></li>
                <li><a style="cursor: pointer" data-toggle="modal" data-target="#login-modal">Login</a></li>
                <li><a href="/Profile" class="fa fa-user"></a></li>
            </ul>
            <a style=" padding: 8px 15px;" class="navbar-brand" href="/">
                <img style="height: 40px;" src="/resources/img/Easylift_logo.png"/>
            </a>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->

<jsp:doBody/>

<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </div>
</footer>
<script src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    var directionsService = new google.maps.DirectionsService();
    var map,geocoder, marker;
    var depart,arrivee = new google.maps.LatLng(43.5446257,1.3256384) ,ptCheck;

    /*initialise google MAP V3*/
    function init() {
        console.log("init");
        /*gestion des routes*/
        directionsDisplay = new google.maps.DirectionsRenderer();
        /*option par défaut de la carte*/
        var myOptions = {
            zoom:4,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            center: arrivee
        }
        /*creation de la map*/
        map = new google.maps.Map(document.getElementById("divMap"), myOptions);
        /*connexion de la map + le panneau de l'itinéraire*/
        directionsDisplay.setMap(map);
        /*intialise le geocoder pour localiser les adresses */
        geocoder = new google.maps.Geocoder();
    }


    function trouveRoute(origin) {
        /*test si les variables sont bien initialisés*/
        var listlocation = origin.split(',');
        var location = new google.maps.LatLng(parseFloat(listlocation[0]), parseFloat(listlocation[1]));
            /*mode de transport*/
            var choixMode = "DRIVING";
            var request = {
                origin:location,
                destination:new google.maps.LatLng(43.6249627,1.4304408),
                travelMode: google.maps.DirectionsTravelMode[choixMode]
            };
            console.log(request);
            /*appel à l'API pour tracer l'itinéraire*/
            directionsService.route(request, function(response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                    console.log("Itineraire OK");
                }
            });
    }
</script>
</body>
</html>
