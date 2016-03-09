<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:layout_simple>
    <jsp:body>
        <header class="intro-header" style="background-image: url('/resources/img/Easylift_profile.jpg');" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1" style="height: 300px;">
                        <div class="site-heading" style="padding: 90px 0 50px;">
                            <h1>Profile</h1>
                            <hr class="small">
                            <span class="subheading">Here you can see your profile and edit it.</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div class="container" style="padding-bottom: 15px; padding-top: 30px;">
            <div class="col-md-7">
                <div class="row">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Informations <a href="#" class="fa fa-edit pull-right" style="text-decoration: none;"></a></h3>
                        </div>
                        <div class="panel-body">
                            <div class="row row-centered">
                                <div class="col-md-4">
                                    <img class="img-circle-high" width="128" height="128" src="https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg" alt="Avatar">
                                    <div>@JozeZorro</div>
                                </div>
                                <div class="col-md-8 col-centered">
                                    <fieldset>
                                        <legend>General</legend>
                                        <p>Name : Juan Jose</p>
                                        <p>School : Ingesup</p>
                                        <p>Class : Master 2</p>
                                        <p>Gender : M</p>
                                    </fieldset>
                                    <fieldset>
                                        <legend>Car</legend>
                                        <p>Brand : Audi</p>
                                        <p>Seat : 12</p>
                                    </fieldset>
                                    </hr>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Hours <a href="#" class="fa fa-edit pull-right" style="text-decoration: none;"></a></h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-bordered text-center">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Monday</th>
                                    <th>Tuesday</th>
                                    <th>Wednesday</th>
                                    <th>Thursday</th>
                                    <th>Friday</th>
                                    <th>Sunday</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td style="font-weight: bold">Aller</td>
                                    <td>8H00</td>
                                    <td>8H00</td>
                                    <td>8H00</td>
                                    <td>8H00</td>
                                    <td>8H00</td>
                                    <td>8H00</td>
                                </tr>
                                <tr>
                                    <td style="font-weight: bold">Retour</td>
                                    <td>17H30</td>
                                    <td>17H30</td>
                                    <td>17H30</td>
                                    <td>17H30</td>
                                    <td>17H30</td>
                                    <td>17H30</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        <div class="col-md-5">
            <h2 style="margin-bottom: 30px; color: #F46C7C; margin-top: 0px;" class="col-md-12 text-center">Your journeys <a href="#" class="fa fa-plus" style="text-decoration: none; float: right; color:#6CCDDA;"></a></h2>
            <c:forEach var="tile" items="${Tiles}">
            <div style="height:97px;" class="tiles col-md-4 col-sm-4 col-xs-6">
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
            </div>
            </c:forEach>
        </div>
        </div>
        <jsp:include page="/WEB-INF/jsp/login.jsp"></jsp:include>
    </jsp:body>
</t:layout_simple>