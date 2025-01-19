<%-- 
    Document   : AccountProfile
    Created on : Oct 24, 2023, 7:39:22 PM
    Author     : wongun78
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apple</title>
    </head>
    <body>
        <form action = 'CreateProfile' method = "post">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type='text' name = 'firstName' ></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type='text' name = 'lastName'></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type='email' name = 'email' ></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type='text' name = 'phone' ></td>
                </tr>
                <tr>
                    <td>Birthday</td>
                    <td><input type='date' name = 'birthDay'></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><input type='radio' name = 'gender' value='M'
                               }
                               > Male &nbsp;
                        <input type='radio' name = 'gender' value='F' 
                               }
                               > Female 
                    </td>
                </tr>
                <tr>
                    <td>Region</td>
                    <td><input type='text' name = 'region'></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><textarea name = 'address'></textarea></td>
                </tr>

            </table>
            <input type='submit' name='btnInsert' value='Insert'>
            <input type='reset' name='btnClear' value='Clear'>
        </form>
    </body>
</html>
