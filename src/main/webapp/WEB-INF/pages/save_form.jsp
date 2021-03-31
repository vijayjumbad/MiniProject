
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">Employee Registration form</h1>

<script language="JavaScript"  src="js/validation.js">
</script>
<frm:form method="POST" modelAttribute="empfrm" onsubmit="return  validate(this)">
<table>
  <tr>
  <td>EmpName::</td>
  <td><frm:input path="eName"/><span id="nameError"></span><frm:errors cssStyle="color:red" path="eName"/></td>
  </tr>
  <tr>
  <td>Emp Addrs::</td>
  <td><frm:select path="addrs">
           <frm:options items="${addrses}"/>
  </frm:select>
  </tr>
  <tr>
  <td>Emp salary::</td>
  <td><frm:input path="salary"/><span id="salaryError"></span><frm:errors cssStyle="color:red" path="salary"/></td>
  </tr>
  <tr>
  <td><frm:hidden path="vflag"/></td>
  <td><input type="submit" value="register"></td>
  </tr>
  </table>
</frm:form>



