<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Big_Boss
  Date: 2017/7/19
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h4><s:property value="author"/> 说：</h4>
    <small>@刚刚</small>
    <p>
        <s:property value="content"/>
    </p>
</div>
<hr>
