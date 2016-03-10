<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout_simple>

    <jsp:body>


        <header class="intro-header">
            <div id="divMap" style="width:100%; height:400px; padding-bottom:30px;"></div>
        </header>

        <div class="container" style="padding-bottom: 15px; padding-top: 30px;">



        <div class="col-md-9">
            <div class="row">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Informations</h3>
                </div>
                <div class="panel-body">
                    <div class="row row-centered">
                        <div class="col-md-4">
                            <img class="img-circle-high" width="128" height="128" src="data:image/png;base64,<c:out value="${journey.driver.picture}"/>" alt="Avatar">
                            <div>@${journey.driver.pseudo}</div>
                        </div>
                        <div class="col-md-8 col-centered">
                            <fieldset>
                                <legend>User</legend>
                                <p>Nom : ${journey.driver.name}</p>
                                <p>Ecole : ${journey.driver.school}</p>
                                <p>Classe : ${journey.driver.promotion}</p>
                                <p>Sexe : ${journey.driver.sex}</p>
                            </fieldset>
                            <fieldset>
                                <legend>Car</legend>
                                <p>Marque : ${journey.driver.userCar.brand}</p>
                                <p> Nombre de place : ${journey.driver.userCar.seats}</p>
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
                        <h3 class="panel-title">Horaires</h3>
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
                                <td>${journey.schedule.monday.start}</td>
                                <td>${journey.schedule.tuesday.start}</td>
                                <td>${journey.schedule.wenesday.start}</td>
                                <td>${journey.schedule.thursday.start}</td>
                                <td>${journey.schedule.friday.start}</td>
                                <td>${journey.schedule.saturday.start}</td>
                            </tr>
                            <tr>
                                <td style="font-weight: bold">Retour</td>
                                <td>${journey.schedule.monday.end}</td>
                                <td>${journey.schedule.tuesday.end}</td>
                                <td>${journey.schedule.wenesday.end}</td>
                                <td>${journey.schedule.thursday.end}</td>
                                <td>${journey.schedule.friday.end}</td>
                                <td>${journey.schedule.saturday.end}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        <div>
            <div class="col-md-12" style="padding: 0;">
                <button class="btn btn-rouge" style="width:100%">
                    <i style="padding-right: 15px;" class="fa fa-car fa-2x"></i> I want to join this journey !
                </button>
            </div>
        </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Journey</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4">
                            <div id="trajetCircleDivBis">
                                <span id="trajetCircleSpanImage" style="background: url(data:image/png;base64,${journey.driver.picture});     background-size: 64px 64px;"></span>
                                <span id="trajetCircleSpanBarre"></span>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <span style="font-size: 13px; line-height: 64px;">Départ</span>
                        </div>
                    </div>

        <c:forEach var="user" items="${journey.passengers}">
            <div class="row">
                <div class="col-md-4">
                    <div id="trajetCircleDivBis">
                        <span id="trajetCircleSpanImage" style="background: url(data:image/png;base64,${user.picture});     background-size: 64px 64px;"></span>
                        <span id="trajetCircleSpanBarre"></span>
                    </div>
                </div>
                <div class="col-md-8">
                    <span style="font-size: 13px; line-height: 64px;">${user.name}</span>
                </div>
            </div>
        </c:forEach>

                    <div class="row">
                        <div class="col-md-4">
                    <div id="trajetCircleDivBis" style="height:64px;" >
                        <span id="trajetCircleSpanImageRed" style="background: url('https://pbs.twimg.com/profile_images/582850767410724864/RxIJQoRR.png'); background-size: 64px 64px;"></span>
                        </div>
                        </div>
                        <div class="col-md-8">
                            <span style="font-size: 13px; line-height: 64px;">Arrivée</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div><!-- /.container -->
        <jsp:include page="/WEB-INF/jsp/login.jsp"></jsp:include>
        <script>
            $(document).ready(function() {
                init();
                console.log( "ready!" );
                trouveRoute('<c:out value="${journey.startLocation}"/>'); //stcyp
                //trouveRoute(); //cugnaux
            });
        </script>
    </jsp:body>
</t:layout_simple>