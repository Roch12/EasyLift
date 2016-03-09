<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:layout>
    <jsp:body>
        <div class="col-md-6">
            <h2 style="margin-bottom: 30px; color: #6CCDDA;" class="col-md-12 text-center">Aller</h2>
       <c:forEach var="tile" items="${Tiles}">
            <div style="height:194px;" class="tiles col-md-4 col-sm-4 col-xs-6">
                <div class="row">
                    <div class="col-md-6 prn">
                        <div class="bg-notification">
                            <div class="row">
                                <div class="col-xs-12 latest-left text-center">
                                    <div class="col-xs-6">
                                        <img class="img-circle display-ib v-middle mrs" width="64" height="64" src="https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg" alt="Avatar">
                                    </div>
                                    <div style="margin-top:6px; padding-left: 0px;" class="col-xs-6 display-ib latesttripname">
                                        <div class="font18 font-bold">${tile.username}</div>
                                        <div>${tile.promo}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 pln prn">
                        <div class="bg-journey">
                            <div class="row latesttripbottom pvs plm">
                                <div class="col-xs-2">
                                    <div id="trajetCircleDiv">
                                        <span id="trajetCircleSpan1"></span>
                                        <span id="trajetCircleSpan2"></span>
                                        <span id="trajetCircleSpan3Bis"></span>
                                    </div>
                                </div>
                                <div class="col-xs-10 p-rel">
                                    <div class="place place-origin">
                                        <a href="">
                                                ${tile.startLocation}
                                        </a>
                                    </div>
                                    <div class="latesttripdate font18 font-bold">
                                        <fmt:formatDate value="${tile.dateStart}" pattern="d MMM" />
                                        <span class="font-bold font18 mlx"> / 2€</span>
                                    </div>
                                    <div class="place place-dest">
                                        Places restantes : ${tile.placeAvailable}/${tile.placeMaximum}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <img style="height: 97px; width: 100%" src="http://maps.google.com/maps/api/staticmap?center=43.6249529,1.4318564&zoom=17&markers=icon:http://icons.iconarchive.com/icons/paomedia/small-n-flat/128/map-marker-icon.png|43.6249529,1.4318564&path=color:0x0000FF80|weight:5|25.3176452,82.97391440000001&size=600x97" alt="22 impasse charles fourier toulouse">
                </div>
            </div>

        </c:forEach>
        </div>

        <div class="col-md-6">
            <h2 style="margin-bottom: 30px; color: #F46C7C;" class="col-md-12 text-center">Retour</h2>
            <c:forEach var="tile" items="${Tiles}">
                <div style="height:194px;" class="tiles col-md-4 col-sm-4 col-xs-6">
                    <div class="row">
                        <div class="col-md-6 prn">
                            <div class="bg-notification">
                                <div class="row">
                                    <div class="col-xs-12 latest-left text-center">
                                        <div class="col-xs-6">
                                            <img class="img-circle display-ib v-middle mrs" width="64" height="64" src="https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg" alt="Avatar">
                                        </div>
                                        <div style="margin-top:6px; padding-left: 0px;" class="col-xs-6 display-ib latesttripname">
                                            <div class="font18 font-bold">${tile.username}</div>
                                            <div>${tile.promo}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 pln prn">
                            <div class="bg-journey">
                                <div class="row latesttripbottom pvs plm">
                                    <div class="col-xs-2">
                                        <div id="trajetCircleDiv">
                                            <span id="trajetCircleSpan1Bis"></span>
                                            <span id="trajetCircleSpan2Bis"></span>
                                            <span id="trajetCircleSpan3"></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-10 p-rel">
                                        <div class="place place-origin">
                                            <a href="">
                                                    ${tile.startLocation}
                                            </a>
                                        </div>
                                        <div class="latesttripdate font18 font-bold">
                                            <fmt:formatDate value="${tile.dateStart}" pattern="d MMM" />
                                            <span class="font-bold font18 mlx"> / 2€</span>
                                        </div>
                                        <div class="place place-dest">
                                            Places restantes : ${tile.placeAvailable}/${tile.placeMaximum}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <img style="height: 97px; width: 100%" src="http://maps.google.com/maps/api/staticmap?center=43.6249529,1.4318564&zoom=17&markers=icon:http://icons.iconarchive.com/icons/paomedia/small-n-flat/128/map-marker-icon.png|43.6249529,1.4318564&path=color:0x0000FF80|weight:5|25.3176452,82.97391440000001&size=600x97" alt="22 impasse charles fourier toulouse">
                    </div>
                </div>

            </c:forEach>
        </div>
    </jsp:body>
</t:layout>