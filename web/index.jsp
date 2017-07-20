<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Big_Boss
  Date: 2017/7/18
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="http://localhost:8080/gallery/css/bootstrap.min.css">
    <script src="http://localhost:8080/gallery/js/jquery-3.2.1.js"></script>
    <script src="http://localhost:8080/gallery/js/bootstrap.min.js"></script>
    <title>gallery</title>
  </head>
  <style>
    img{
      max-width: 100%;
      margin-top: 10px;
    }
    .input-group{
      margin-top: 5px;
    }
    @media (max-width: 768px) {
      body
      {
        font-size: 26px;
      }
      input{
        font-size: 26px;
      }
    }
    @media (max-width: 1200px) {
      body{
        font-size: 20px;
      }
      input{
        font-size: 20px;
      }
    }
  </style>
  <script>
    function updatacollapse(link) {
      var number=link.href;
      number=number.charAt(number.length-1);
      if($("#panel-body"+number).html()!="")
        return;
      $.ajax({
        type:"post",
        url:'http://localhost:8080/gallery/act/loadwhisp',
        data:{serialNumber:number},
        async:false,
        success:function (data) {
          $("#panel-body"+number).append(data);
          }
      })
    }
    function updataone(btn) {
      var id=btn.id;
      id=id.charAt(id.length-1);
      var content=$("#content"+id).val();
      var author=$("#name"+id).val();
      if(author==""){
        alert("请留名，谢谢")
        return;
      }
      if(content==""){
        alert("请留字，谢谢")
        return;
      }
      $.ajax({
        type:"post",
        url:'http://localhost:8080/gallery/act/updataWhisp',
        data:{serialNumber:id,content:content,author:author},
        async:false,
        success:function (data) {
          $("#panel-body"+id).append(data);
          $("#content"+id).val("");
          $("#name"+id).val("");
        }
      })
    }
    window.onload = function() {
      var id=$("#contentIMG").attr("id");
      if(id==null)
        alert("你将前往内容的边缘");
    }
  </script>
  <body>
  <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
          <span class="sr-only">切换导航</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="http://localhost:8080/gallery/act/load?page=<s:property value="homepage"/>">首页</a>
      </div>
      <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="http://localhost:8080/gallery/act/load?page=<s:property value="homepage"/>">img</a></li>
          <li><a href="http://localhost:8080/gallery/updata.html">上传</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
    <div class="row">
      <s:iterator value="list">
        <div id="contentIMG" class="col-sm-12 col-md-6">
          <img src="<s:property value="path"/>">

          <div class="col-sm-2 col-sm-offset-10 col-xs-6 col-xs-offset-6">
            <a class="text-right" data-toggle="collapse" data-parent="#accordion" href="#collapse<s:property value="serialNumber"/>" onclick="updatacollapse(this)">
              吐槽
            </a>
          </div>

          <div id="collapse<s:property value="serialNumber"/>" class="panel-collapse collapse">
            <div class="panel-body" id="panel-body<s:property value="serialNumber"/>"></div>

            <form>
              <div class="input-group col-xs-12">
                <textarea id="content<s:property value="serialNumber"/>" type="text" class="form-control" style="height: 150px"></textarea>
              </div>
              <div class="input-group col-xs-12">
                <input id="name<s:property value="serialNumber"/>" class="form-control" type="text" placeholder="大侠留名！">
              </div>
              <div class="input-group col-xs-12">
                <button type="button" class="btn btn-primary btn-lg btn-block" id="btn<s:property value="serialNumber"/>" onclick="updataone(this)">吐槽</button>
              </div>
            </form>

          </div>

        </div>
        <hr>
      </s:iterator>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <ul class="pagination pagination-lg">
          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page-1"/>">&laquo;</a></li>

          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page-2"/>"><s:property value="page-2"/></a></li>
          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page-1"/>"><s:property value="page-1"/></a></li>
          <li class="active"><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page"/>"><s:property value="page"/></a></li>
          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page+1"/>"><s:property value="page+1"/></a></li>
          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page+2"/>"><s:property value="page+2"/></a></li>

          <li><a href="http://localhost:8080/gallery/act/load?page=<s:property value="page+1"/>">&raquo;</a></li>
        </ul>
      </div>
    </div>
  </div>
  </body>
</html>
