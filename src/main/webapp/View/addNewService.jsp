<%-- 
    Document   : addnewrom
    Created on : May 31, 2022, 7:17:06 AM
    Author     : Dell
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>MoonHostel</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/logo.png" sizes="16x16">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />

    </head>
    <body class="sb-nav-fixed">

        <%@include file="/View/layout/header.jsp" %>

        <div id="layoutSidenav_content">
            <main class="container-fluid">
                <div class="container-fluid px-4">
                    <div class="card mt-4">
                        <div class="card-header">
                            <h1 class="text-info">Thêm Dịch Vụ</h1>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/MainController?action=AddService" method="POST">
                                <div class="row">
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label">Tên dịch vụ:</label>
                                        <div class="col col-sm-8">
                                            <input name="detail_name" type="text" class="form-control" placeholder="Tên dịch vụ" required pattern="\S+">
                                        </div>
                                    </div>
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label">Loại dịch vụ:</label>
                                        <div class="col-sm-8">
                                            <select id="#" name="service_id" style="padding:6px 0; border-radius: 3px; width: 50%" >
                                                <c:forEach items="${ServiceTypeList}" var="ST">
                                                    <option value="${ST.serviceID}">${ST.service_name}</option>                                                
                                                </c:forEach>
                                            </select> 
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label">Ngày thêm:</label>
                                        <div class="col col-sm-8">
                                            <input type="date" name="updated_date"class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label">Địa điểm:</label>
                                        <div class="col-sm-8">
                                            <select id="#" name="hostel_id" style="padding:6px 0; border-radius: 3px; width: 50%" >
                                                <c:forEach items="${HostelList}" var="H">
                                                    <option value="${H.hostelID}">${H.hostelname}</option>                                                
                                                </c:forEach>
                                            </select> 

                                        </div>
                                    </div>
                                </div>                                 

                                <div class="row">
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label">Giá:</label>
                                        <div class="col col-sm-8">
                                            <input type="number" name="unit_price" class="form-control" placeholder="Giá" required pattern="[0-9]">
                                        </div>
                                    </div>
                                    <div class="form-group row col-md-6 mt-2">
                                        <label  class="col-sm-4 col-form-label"></label>
                                        <label class="col-sm-8">

                                        </label>
                                    </div>
                                </div> 
                                    <div class="form-group">
                                        <label for="inputAddress2">Mô Tả:</label>
                                        <textarea rows="3" class="form-control" id="remarks" name="description"></textarea>
                                    </div>

                                <div class="mt-3 text-center">
                                    <a href="${pageContext.request.contextPath}/MainController?action=ServicePage">
                                        <button class="btn btn-warning" type="button" id="cancelButton"><i class="fa fa-mail-reply"></i> Trở Về</button>
                                    </a>
                                    <button class="btn btn-success" type="submit" name="action" id="sumbitButton" value="AddService"><i class="fa fa-check"></i> Lưu</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted ">Copyright &copy; by MoonHostel</div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
    <script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
    <script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>    
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

</body>

</html>