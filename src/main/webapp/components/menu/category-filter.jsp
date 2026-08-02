<%@ page import="java.util.List" %>
<%@ page import="com.cafe.Model.Category" %>

<%
List<Category> categories =
(List<Category>)request.getAttribute("categories");
%>

<section class="menu-category">

    <div class="container">

        <div class="category-list">

            <a href="#" class="category-pill active">

                All

            </a>

            <%
            if(categories != null){

                for(Category category : categories){
            %>

                <a href="#"
                   class="category-pill">

                    <%=category.getCategoryName()%>

                </a>

            <%
                }
            }
            %>

        </div>

    </div>

</section>