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
        <link rel="icon" type="image/png" href="../assets/img/logo.png" sizes="16x16">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    </head>

    <body class="sb-nav-fixed jumbotron">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">MoonHostel
                <img src="../assets/img/logo.png" class="rounded-circle"  alt="logo"width="40" height="36">
            </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Tìm Kiếm..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">                       
                        <li><a class="dropdown-item" href="#!">Cài đặt</a></li>

                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="#!">Đăng Xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-palette"></i></div>
                                Trang Chủ
                            </a>
                            <a class="nav-link collapsed" href="room.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-house"></i></div>
                                Phòng                                
                            </a>
                            <a class="nav-link collapsed" href="service.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-cubes"></i></div>
                                Dịch Vụ                                
                            </a>                                               
                            <div class="sb-sidenav-menu-heading">Khác</div>                            
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-address-card"></i></div>
                                Liên Hệ
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        MoonHostel
                        <img src="../assets/img/logo.png" class="rounded-circle"  alt="regisster"width="40" height="36">
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <h1 class="mt-4 col-md-4"><i class="fa fa-house"></i> Quản Lí Phòng</h1>
                <table>
                    <div class="card mb-4">
                        <div class="card-header">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>Quản Lí Nhà Trọ                              
                            </div>
                            <div class="row " style="float:right; display: flex">
                                <a href="addNewHostel.jsp">
                                    <button type="button"  class="btn btn-success m-2"><i class="fa fa-bank"></i> Thêm Nhà Trọ</button>
                                </a>
                            </div>
                            <div class="row " style="float:right; display: flex">
                                <a href="#">
                                    <button type="button"  class="btn btn-danger m-2"><i class="fa fa-remove"></i> Xóa Nhà Trọ</button>
                                </a>
                            </div> 

                        </div>
                    </div>
                </table>

                <main class="container-fluid">

                    <div class="room container-fluid px-4">                        

                        <ul class=" col-12 nav nav-tabs mb-4">
                            <li class="nav-item">
                                <a class="nav-link active" href="#District9" role="tab" data-toggle="tab">Quận 9</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#District1" role="tab" data-toggle="tab">Quận 1</a>
                            </li>
                        </ul>

                        <div class="breadcrumb mb-4 " style="margin-left: 85%">
                            <div class="row">
                                <a href="addNewRoom.jsp">
                                    <button type="button"  class="btn btn-success"><i class="fa fa-add"></i> Thêm Phòng</button>
                                </a>
                            </div>                             
                            <!-- comment -->
                        </div>
                        <div class="tab-content ">
                            <div role="tabpanel" class=" tab-pane fade show active" id="District9" >
                                <div class="card-body">
                                    <table id="datatablesSimple">
                                        <thead>
                                            <tr>
                                                <th>Phòng</th>
                                                <th>Người Thuê</th>
                                                <th>Số Điện Thoại</th> 
                                                <th>Email</th>                                     
                                                <th>Ngày Thuê</th>
                                                <th>Giá</th>
                                                <th>Trạng Thái</th>
                                                <th>Chức Năng</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Phòng</th>
                                                <th>Người Thuê</th>
                                                <th>Số Điện Thoại</th> 
                                                <th>Email</th>                                     
                                                <th>Ngày Thuê</th>
                                                <th>Giá</th>
                                                <th>Trạng Thái</th>
                                                <th>Chức Năng</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr>                                                
                                                <td>1</td>
                                                <td>
                                                    <a href="viewCus.jsp">
                                                        Nguyễn Nhựt Minh
                                                    </a>
                                                </td>
                                                <td>0382694825</td>
                                                <td>minhnnse150140@gmail.com</td>
                                                <td>08/06/2022</td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-success">Hoạt Động</td>
                                                <td>                                                    
                                                    <a href="viewRoom.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-eye"></i></button>
                                                    </a>
                                                    <a href="editRoom.jsp">
                                                        <button class="btn btn-primary" title="Edit"><i class="fa fa-edit"></i></button>
                                                    </a>
                                                    <button class="btn btn-danger" title="Remove"><i class="fa fa-remove"></i></button>                                                    
                                                </td>
                                            </tr>                                       

                                            <tr>                                                
                                                <td>2</td>
                                                <td>
                                                    <a href="viewCus.jsp">
                                                        Nguyễn Nhựt Trí
                                                    </a>
                                                </td>
                                                <td>0987890989</td>
                                                <td>tripmse150151@gmail.com</td>
                                                <td>08/05/2021</td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-success">Hoạt Động</td>
                                                <td>                                                    
                                                    <a href="viewRoom.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-eye"></i></button>
                                                    </a>
                                                    <a href="editRoom.jsp">
                                                        <button class="btn btn-primary" title="Edit"><i class="fa fa-edit"></i></button>
                                                    </a>
                                                    <button class="btn btn-danger" title="Remove"><i class="fa fa-remove"></i></button>                                                     
                                                </td>
                                            </tr>
                                            <tr>                                                
                                                <td>3</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-danger">Chưa hoạt động</td>
                                                <td>                                                    
                                                    <a href="AddNewCustomer.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-add"></i> Thêm Khách</button>
                                                    </a>

                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            <div role="tabpanel" class="tab-pane fade show " id="District1" >
                                <div class="card-body">
                                    <table id="datatablesSimple1">
                                        <thead>
                                            <tr>
                                                 <th>Phòng</th>
                                                <th>Người Thuê</th>
                                                <th>Số Điện Thoại</th> 
                                                <th>Email</th>                                     
                                                <th>Ngày Thuê</th>
                                                <th>Giá</th>
                                                <th>Trạng Thái</th>
                                                <th>Chức Năng</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                 <th>Phòng</th>
                                                <th>Người Thuê</th>
                                                <th>Số Điện Thoại</th> 
                                                <th>Email</th>                                     
                                                <th>Ngày Thuê</th>
                                                <th>Giá</th>
                                                <th>Trạng Thái</th>
                                                <th>Chức Năng</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr>                                                
                                                <td>1</td>
                                                <td>
                                                    <a href="viewCus.jsp">
                                                        Nguyễn Nhựt Hùng
                                                    </a>
                                                </td>
                                                <td>0398098908</td>
                                                <td>hungtq272@gmail.com</td>
                                                <td>03/12/2020</td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-success">Hoạt Động</td>
                                                <td>                                                    
                                                    <a href="viewRoom.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-eye"></i></button>
                                                    </a>
                                                    <a href="editRoom.jsp">
                                                        <button class="btn btn-primary" title="Edit"><i class="fa fa-edit"></i></button>
                                                    </a>
                                                    <button class="btn btn-danger" title="Remove"><i class="fa fa-remove"></i></button>                                                    
                                                </td>
                                            </tr>                                       

                                            <tr>                                                
                                                <td>2</td>
                                                <td>
                                                    <a href="viewCus.jsp">
                                                        Nguyễn Nhựt Anh
                                                    </a>
                                                </td>
                                                <td>09876665438</td>
                                                <td>baoanhnc3@gmail.com</td>
                                                <td>18/05/2019</td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-success">Hoạt Động</td>
                                                <td>                                                    
                                                    <a href="viewRoom.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-eye"></i></button>
                                                    </a>
                                                    <a href="editRoom.jsp">
                                                        <button class="btn btn-primary" title="Edit"><i class="fa fa-edit"></i></button>
                                                    </a>
                                                    <button class="btn btn-danger" title="Remove"><i class="fa fa-remove"></i></button>                                                    
                                                </td>
                                            </tr>
                                            <tr>                                                
                                                <td>3</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>2,300,000 VND</td>
                                                <td class="text-danger">Chưa Hoạt Động</td>
                                                <td>                                                    
                                                    <a href="AddNewCustomer.jsp">
                                                        <button class="btn btn-warning" title="View"><i class="fa fa-add"></i> Thêm Khách</button>
                                                    </a>

                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto jumbotron">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted ">Copyright &copy; by MoonHostel</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}../js/scripts.js"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>    
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

    </body>

</html>