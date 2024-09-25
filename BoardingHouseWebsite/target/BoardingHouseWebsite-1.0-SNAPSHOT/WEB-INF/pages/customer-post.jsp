<%-- 
    Document   : customer-post
    Created on : May 1, 2024, 2:58:54 PM
    Author     : tongh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="card-box mb-30">
    <div class="pd-20">
        <h4 class="text-blue h4">Quản lý bài đăng khách hàng</h4>
    </div>
    <div class="pb-20">
        <table class="table hover multiple-select-row data-table-export nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Tiêu đề</th>
                    <th>Mô tả</th>
                    <th>Địa chỉ</th>
                    <th>Tên chủ bài viết</th>
                    <th>Ngày tạo</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cposts}" var="cp">
                    <tr>
                        <td>${cp[0]}</td>
                        <td>${cp[1]}</td>
                        <td>${cp[2]}</td>
                        <td>${cp[3]}</td>
                        <td>${cp[4]} ${cp[5]}</td>
                        <td>${cp[7]}</td>
                        <td>
                            <c:url value="/customer-post/${lp[0]}" var="url" />
                            <c:url value="/api/customer-post/${lp[0]}/" var="urlDelete" />
                            <button class="btn btn-danger" 
                                    onclick="eDelete('${urlDelete}', ${lp[0]})">Xóa</button>

                        </td>
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

