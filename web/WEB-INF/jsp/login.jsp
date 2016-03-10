<%--
  Created by IntelliJ IDEA.
  User: Summer
  Date: 09-Mar-16
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1>Login</h1><br/>
            <form style="margin-bottom: 5px;">
                <input type="text" name="user" placeholder="Username">
                <input type="submit" name="login" class="btn btn-primary" style="width: 100%" value="Login">
            </form>
            <button class="btn btn-success" style="width: 100%; margin-bottom: 15px;">Register</button>

            <div class="login-help">
                <a href="#">Forgot Password</a>
            </div>
        </div>
    </div>
</div>