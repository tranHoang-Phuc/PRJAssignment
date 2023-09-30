<%-- 
    Document   : schedule
    Created on : Sep 30, 2023, 10:34:25 AM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FPT University Academic Portal</title>
        <link rel="stylesheet" href="../../css/teacher/schedule.css"/>
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <th class="table-heading" rowspan="2">
                        <span>
                            <strong>YEAR</strong>
                        </span>
                        <select name="year" id="year">
                            <option value="2020">2023</option>
                        </select><br> WEEK
                        <select name="week" id="week">
                        </select>
                    </th>
                    <th class="table-heading">Monday</th>
                    <th class="table-heading">Tuesday</th>
                    <th class="table-heading">Wednesday</th>
                    <th class="table-heading">Thursday</th>
                    <th class="table-heading">Friday</th>
                    <th class="table-heading">Saturday</th>
                    <th class="table-heading">Sunday</th>
                </tr>
                <tr>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                    <th class="table-heading day"></th>
                </tr>
                <tr>
                    <td>Slot 1</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
                <tr>
                    <td>Slot 2</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
                <tr>
                    <td>Slot 3</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
                <tr>
                    <td>Slot 4</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
                <tr>
                    <td>Slot 5</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
                <tr>
                    <td>Slot 6</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td>
                    <td class="lession">-</td> 
                </tr>
            </table>
        </div>
        <script src="../../js/teacher/schedule.js"></script>
    </body>
</html>
