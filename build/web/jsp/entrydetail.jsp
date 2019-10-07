<%-- 
    Document   : home
    Created on : 01-10-2019, 19:01:05
    Author     : dattv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div class="container">

            <div class="header">
                <h1 class="title">Blogging About My Life</h1>
                <p class="subtitle">Welcome to my blog</p>
                <div class="menu">
                    <a id="menuMyBlog" class="link-banner" href="MyBlogController">My Blog</a>
                    <a id="menuAbout"class="link-banner" href="AboutMeController">About Me</a>
                </div>
            </div>



            <div class="content">
                <div class="block1">
                    <p class="content-header"> My Blog</p>

                    <div class="entry">
                        <table class="header-entry">
                            <tr>
                                
                                <td class="mid"><a href=""><h4 class="entry-name">Post Name </h4></a></td>
                                <td class="last"> <p class="createdate">Time</p></td>
                            </tr>
                        </table>
                        <div class="content">
                            <div class="entry-image">
                                <img  src="img/happy_life.jpg">
                            </div>
                            <div class="entry-content">
                                <p >Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                                <p> At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro ridens intellegam ut, sea at graecis scriptorem eloquentiam.
                                </p><p>  Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.
                                </p>
                            </div>


                        </div>

                    </div>

         
                    
                    <div class="overview">
                        <a href="">Over View</a>
                    </div>

                </div>

                <div class="block2">
                    <div class="share">
                        <p class="share-title">Share this page</p>

                        <ul>
                            <li><a class="share-link" href="">Share on Facebook</a></li>
                            <li><a class="share-link" href="">Share on Twitter</a></li>
                            <li> <a class="share-link" href="">Share on Google+</a></li>
                        </ul>

                    </div>
                </div>



                <div class="clear">
                </div>
            </div>
            <div class="footer">
                adasd
            </div>
        </div>

    </body>
</html>
