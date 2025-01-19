<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/profile.css"/>
        <link rel="stylesheet" href="css/style2.css"/>

        <title>Update Profile</title>
    </head>
    <body>
        <form class="update-form" action="" method="post">
            <div class="modal-body">
                <input type="hidden" name="username" value="${sessionScope.account.username}">
                <div class="form-group">
                    <h2>Update Profile</h2>
                </div>
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" name="firstName" class="form-control" value="${sessionScope.account.firstName}"
                           required>
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" name="lastName" class="form-control" value="${sessionScope.account.lastName}"
                           required>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" name="email" class="form-control" value="${sessionScope.account.email}" required>
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phone" class="form-control" value="${sessionScope.account.phone}" required>
                </div>
                <div class="form-group">
                    <label>Birthday</label>
                    <input type="text" name="birthDay" class="form-control" value="${sessionScope.account.birthDay}"
                           required>
                </div>
<!--                <div class="form-group gender">
                    <label>Gender</label>
                    <input type='radio' name='gender' value='M' ${sessionScope.account.gender?"checked":""}> Male &nbsp;
                    <input type='radio' name='gender' value='F' ${sessionScope.account.gender?"":"checked"}> Female
                </div>-->
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" class="form-control" value="${sessionScope.account.address}" required>
                </div>
            </div>
            <div class="modal-footer">
                <input type="submit" class="btn btn-info" name='btnUpdate' value="Save Changed">
            </div>
        </form>
    </body>
</html>
