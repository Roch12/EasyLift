<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout_simple>
    <jsp:body>
        <div class="col-md-9">
            <div class="row">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Informations</h3>
                </div>
                <div class="panel-body">
                    <div class="row row-centered">
                        <div class="col-md-4">
                            <img class="img-circle-high" width="128" height="128" src="https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg" alt="Avatar">
                            <div>@JozeZorro</div>
                        </div>
                        <div class="col-md-8 col-centered">
                            <fieldset>
                                <legend>User</legend>
                                <p>Nom : Juan Jose</p>
                                <p>Ecole : Ingesup</p>
                                <p>Classe : Master 2</p>
                                <p>Sexe : F</p>
                            </fieldset>
                            <fieldset>
                                <legend>Car</legend>
                                <p>Marque : Audi</p>
                                <p> Nombre de place : 12</p>
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
                                <td>8H00</td>
                                <td>8H00</td>
                                <td>8H00</td>
                                <td>8H00</td>
                                <td>8H00</td>
                                <td>8H00</td>
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
                                <span id="trajetCircleSpanImage" style="background: url('/resources/img/Easylift_cover.jpg');     background-size: 64px 64px;"></span>
                                <span id="trajetCircleSpanBarre"></span>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <span style="font-size: 13px; line-height: 64px;">Départ</span>
                        </div>
                    </div>

        <c:forEach var="i" begin="1" end="4">
            <div class="row">
                <div class="col-md-4">
                    <div id="trajetCircleDivBis">
                        <span id="trajetCircleSpanImage" style="background: url('/resources/img/Easylift_cover.jpg');     background-size: 64px 64px;"></span>
                        <span id="trajetCircleSpanBarre"></span>
                    </div>
                </div>
                <div class="col-md-8">
                    <span style="font-size: 13px; line-height: 64px;">Jose ${i}</span>
                </div>
            </div>
        </c:forEach>

                    <div class="row">
                        <div class="col-md-4">
                    <div id="trajetCircleDivBis" style="height:64px;" >
                        <span id="trajetCircleSpanImageRed" style="background: url('/resources/img/Easylift_cover.jpg');     background-size: 64px 64px;"></span>
                        </div>
                        </div>
                        <div class="col-md-8">
                            <span style="font-size: 13px; line-height: 64px;">Arrivée</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout_simple>