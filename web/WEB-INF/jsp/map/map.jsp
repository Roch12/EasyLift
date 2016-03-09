<%--
  Created by IntelliJ IDEA.
  User: swann
  Date: 07/03/2016
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;
charset=UTF-8"/>
    <!--importation de l'API google MAP Version 3-->
    <script type="text/javascript"
            src="http://maps.google.com/maps/api/js?
sensor=false"></script>
    <script type="text/javascript" src="googleMaps.js" language =
            "javascript"></script>
</head>
<script>
    var directionsService = new
            google.maps.DirectionsService(); // service GoogleMaps
    var map,geocoder, marker, marker2;
    var depart,arrivee,ptCheck;

    /*initialise google MAP V3*/
    function init() {
        /*gestion des routes*/
        directionsDisplay = new google.maps.DirectionsRenderer();

        var maison = new google.maps.LatLng(43.6042600,1.4436700);
        /*option par défaut de la carte*/
        var myOptions = {
            zoom:8,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            center: maison
        }
        /*creation de la map*/
        map = new
                google.maps.Map(document.getElementById("divMap"),myOptions);
        /*connexion de la map + le panneau de l'itinéraire*/
        directionsDisplay.setMap(map);
        directionsDisplay.setPanel(document.getElementById("divRoute"));
        /*intialise le geocoder pour localiser les adresses */
        geocoder = new google.maps.Geocoder();
    }

    function trouveRoute() {
        /*test si les variables sont bien initialisés*/
        if (depart && arrivee){
            var request = {
                origin:depart,
                destination:arrivee,
                travelMode:
                        google.maps.DirectionsTravelMode["DRIVING"]
            };
            /*appel à l'API pour tracer l'itinéraire*/
            directionsService.route(request, function(response,
                                                      status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                }
            });
        }
    }

    function rechercher(src,src2){
// ptCheck = code; /*adresse de départ ou arrivée ? */
        if (geocoder) {
            geocoder.geocode( { 'address':
            document.getElementById(src).value}, function(results,
                                                          status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    /*ajoute un marqueur à l'adresse choisie*/
                    map.setCenter(results[0].geometry.location);
                    if (marker) { marker.setMap(null);}
                    marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                    /*on remplace l'adresse par celle fournie du
                     geocoder*/
                    document.getElementById(src).value =
                            results[0].formatted_address;
                    depart = results[0].formatted_address;
                    /*trace la route*/}
            });
            geocoder.geocode( { 'address':
            document.getElementById(src2).value}, function(results,
                                                           status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    /*ajoute un marqueur à l'adresse choisie*/
                    if (marker2) { marker2.setMap(null);}
                    marker2 = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                    /*on remplace l'adresse par celle fournie du
                     geocoder*/
                    document.getElementById(src2).value =
                            results[0].formatted_address;
                    arrivee = results[0].formatted_address;
                    /*trace la route*/
                }
                trouveRoute();
            });
        }
    }
    directionsDisplay.setDirections(response);
    var monTrajet=response.routes[0] ;

    var point0=monTrajet.overview_path[0];// Position (B:,K:)
    var latPoint0=point0.K;
    var longPoint0=point0.B; //
</script>
<body onload="init();">
<div>

    <table>
        <tr><td><b>Départ: </b></td>
            <td><input type="text" id="adrDep" value=""
                       style="width:300px;"></td>
            <!-- <b>Transport: </b>
            <select id="mode" onchange="calcRoute();">
            <option value="DRIVING">voiture</option>
            <option value="WALKING">marche</option>
            <option value="BICYCLING">vélo</option>
            </select></td></tr> -->
        <tr><td><b>Arrivée: </b></td><td><input type="text"
                                                id="adrArr" value="22 Impasse Charles Fourier, 31200 Toulouse" style="width:300px;"></td><td>
            <input type="button" value="Recherche"
                   onclick="rechercher('adrDep','adrArr')">
        </td></tr>
    </table>
</div>
<div id="divMap" style="float:left;width:70%;
height:80%"></div>
<div id="divRoute" style="float:right;width:30%;height:
80%"></div>
<br/>


                         patate //   <div class="row">${result}</div> // patate





<center>
</center>
</body>
</html>
