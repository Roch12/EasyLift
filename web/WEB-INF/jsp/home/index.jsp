<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout>
    <jsp:body>
        <c:forEach var="tile" items="${Tiles}">
            <div class="tiles col-md-4 col-sm-4 col-xs-6">
                <div class="row">
                    <div class="col-md-8">
                        <div class="row">
                            <div class="col-md-4">
                                <img src="https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"/>
                            </div>
                            <div class="col-md-8">
                                <div class="row">${tile.username}</div>
                                <div class="row">${tile.firstName} ${tile.lastName}</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="row">${tile.placeAvailable}/${tile.placeMaximum}</div>
                        <div class="row">${tile.dateStart.toString()}</div>
                    </div>
                </div>
                <div class="row">
                    <img style="width:100%" src="http://www.brandeis.edu/about/images/newformat/map2.jpg" height="200"/>
                </div>
            </div>
        </c:forEach>

    </jsp:body>
</t:layout>