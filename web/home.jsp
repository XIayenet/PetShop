<%-- 
    Document   : home
    Created on : Mar 12, 2025, 3:08:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="excute" method="Post">
            <table>
                <tr>
                    <td>Enter :</td>
                    <td><input type="text"  name="x" id="x" ></td>
                </tr>        
                <!--================-->
                <tr>
                    <td>Enter y:</td>
                    <td><input type="text"  name="y" id="y" ></td>
                </tr>
                <!--================-->
                <tr>
                    <td>Result:</td>
                    <td><input type="text   "  name="result" id="rs" ></td>
                </tr>
                    
                <!--==========Drop list======-->
                <tr>                
                    <td>Select:</td>
                    <td>
                        <select name="select">
                            <option  value="option1" >Option1</option>
                            <option value="option2" >Option2</option>
                        </select>
                    </td>
                        
                
                <tr>
                    <td>
                        <input type="Submit" value="Submit">
                    </td>
                    <td style="color:red">err</td>
                </tr>
            </table>
        </form>
            
    </body>
</html>
