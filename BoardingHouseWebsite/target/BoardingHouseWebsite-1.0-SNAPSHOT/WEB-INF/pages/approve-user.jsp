<%-- 
    Document   : approve-user
    Created on : Apr 28, 2024, 8:48:33 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card-box mb-30">
    <div class="pd-20">
        <h4 class="text-blue h4">Quản lý tài khoản</h4>
    </div>
    <div class="pb-20">
        <table class="table hover multiple-select-row data-table-export nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Ảnh đại diện</th>
                    <th>Tên tài khoản</th>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Ngày tạo</th>
                    <th>Thao tác</th>
                    <th>Xem chi tiết</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lessors}" var="l">

                    <tr>
                        <td>${l[0]}</td>
                        <td style="width:260px"><img class="card-img-top" 
                                                     src="${l[5]}"
                                                     alt="Card image"></td>
                        <td>${l[1]}</td>
                        <td>${l[2]}</td>
                        <td>${l[3]}</td>
                        <td>${l[4]}</td>
                        <td>
                            <c:url value="/approve-user/${l[0]}" var="url" />
                            <c:url value="/api/approve-user/${l[0]}/" var="urlOperation" />
                            <button class="btn btn-primary" 
                                    onclick="approvePost('${urlOperation}', ${l[0]})">Duyệt</button>
                            <button class="btn btn-danger" 
                                    onclick="eDelete('${urlOperation}', ${l[0]})">Từ chối</button>

                        </td>
                        <td><a class="nav-link" href="<c:url value="/approve-user/${l[0]}"/>">Xem chi tiết</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="col-sm-12 col-md-7">

            <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_2_paginate">
                <ul class="pagination">
                    <li class="paginate_button page-item">
                        <a href="#" aria-controls="DataTab1es Table 2" data-dt-idx="0" tabindex="1"
                           class="page-link">1</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value="/js/main.js"/>"></script>


