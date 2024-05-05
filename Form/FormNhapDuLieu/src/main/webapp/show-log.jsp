<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 5/3/2024
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logs</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.5/css/dataTables.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/2.0.5/js/dataTables.js"></script>
</head>
<body>
<table id="myTable">
    <thead>
    <tr>
        <td></td>
        <td>Id</td>
        <td>Action</td>
        <td>Level</td>
        <td>User</td>
        <td>Ip</td>
        <td>Table</td>
        <td>Time</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
<script>
    $(document).ready(function () {
        $('#myTable').DataTable({
            ajax: {
                url: '/logAPI',
                dataSrc: ''
            },
            columns: [
                {
                    data: null,
                    render: function(data, type, row) {
                        return '<input type="checkbox" name="select" value="' + data.id + '">';
                    }
                },
                {data: 'id'},
                {data: 'action'},
                {data: 'level'},
                {
                    data: 'username',
                    defaultContent: 'Unknown User'
                },
                {data: 'ip'},
                {data: 'value'},
                {data: 'time'}
            ]
        });
    });
</script>
</html>
