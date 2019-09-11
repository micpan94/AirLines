<%--
  Created by IntelliJ IDEA.
  User: PanczoPC
  Date: 11.09.2019
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>World Adventures Airlines</title>
</head>
<body>
<div id="container">
    <div id="title">Add a passenger</div>

    <fieldset>
        <legend>Passenger details</legend>
        <form action="AddPassenger" method="post">
            <div class="inputField">
                <label for="first-name" class="inputLabel">First name :</label>
                <input name="first-name" type="text" id="first-name">
            </div>

            <div class="inputField">
                <label for="last-name" class="inputLabel">Last name :</label>
                <input name="last-name" type="text" id="last-name">
            </div>

            <div class="inputField">
                <label for="dob" class="inputLabel">Date of birth :</label>
                <input name="dob" type="text" id="dob">
            </div>

            <div class="inputField">
                <label for="gender" class="inputLabel">Gender: </label>
                <select name="gender" id="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>


        </form>
    </fieldset>

    <div class="inputField" id="submitField">
        <input id="submitBtn" type="submit" value="Add new passenger">
    </div>
</div>

</body>
</html>
