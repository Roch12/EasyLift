<%--
  Created by IntelliJ IDEA.
  User: Summer
  Date: 09-Mar-16
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="journey-modal" tabindex="-1" role="dialog" aria-labelledby="myModalJourney" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h1>Create a Journey</h1><br/>
            <form style="margin-bottom: 5px;">
                <input type="text" name="start" placeholder="Start Location">
                <input type="text" name="price" placeholder="Price">
                <div class="form-group" style="padding: 0">
                    <label class="col-md-4 control-label" style="padding: 0; top: 7px;" for="">Start Date</label>
                    <div class="col-md-8">
                        <input type="date" name="startDate">
                    </div>
                </div>
                <br/>
                <div class="form-group" style="padding: 0">
                    <label class="col-md-4 control-label" style="padding: 0; top: 7px;" for="passenger">Passengers</label>
                    <div class="col-md-4">
                        <select id="passenger" name="passenger" class="form-control">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                </div>
                <br/>
                <!-- Select Multiple -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="selectDays" style="padding: 0; top: 7px;">Select Days</label>
                    <div class="col-md-8">
                        <select id="selectDays" name="selectDays" class="form-control" multiple="multiple" style="height: 60px; margin-bottom: 15px;">
                            <option value="1">Monday</option>
                            <option value="2">Tuesday</option>
                            <option value="3">Wednesday</option>
                            <option value="4">Thursday</option>
                            <option value="5">Friday</option>
                            <option value="6">Saturday</option>
                        </select>
                    </div>
                </div>
                <br/>
                <input type="submit" name="create" class="btn btn-primary" style="width: 100%" value="Create">
            </form>
        </div>
    </div>
</div>