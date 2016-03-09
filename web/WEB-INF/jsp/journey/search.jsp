<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:layout_simple>
    <jsp:body>
        <div class="container" style="padding-bottom: 15px; padding-top: 65px;">
            <div class="row" style="margin-bottom: 30px;">
                <div class="col-md-12">
                    <div id="custom-search-input">
                        <div class="input-group col-md-12">
                            <input type="text" class="form-control input-lg" placeholder="Search..." />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                    <div class="col-md-6">
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
                    </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/jsp/login.jsp"></jsp:include>
    </jsp:body>
</t:layout_simple>