<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Big_Boss
  Date: 2017/7/19
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:iterator value="list">
    <div>
    <h4><s:property value="author"/>说：</h4>
    <small>@<s:property value="time"/></small>
    <p>
    <s:property value="content"/>
    </p>
    </div>
    <hr>
</s:iterator>


