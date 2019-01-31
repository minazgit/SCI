<aside id="left-panel" class="left-panel" >
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
<!--                <a class="navbar-brand" href="./"><img src="images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>-->
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                   
                    <h3 class="menu-title">Master Detail</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Item Master</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="ItemMasterInsert.jsp">Add</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="<%= application.getContextPath()%>/SerItemmMaster?op1=2">View</a></li>                            
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Person Master</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="<%= application.getContextPath()%>/SerItemmMaster?op=1">Add</a></li>
                            <li><i class="fa fa-table"></i><a href="<%= application.getContextPath()%>/SerPersonMaster?op=2">View</a></li>
                        </ul>
                    </li>
                    
                    
                    
<!--                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i> Security Guard Master</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="SecurityGuardInsert.jsp">Add</a></li>
                            <li><i class="fa fa-table"></i><a href="<%= application.getContextPath()%>/SerSecurityGuard?op=2">View</a></li>
                        </ul>
                    </li>-->


                    <h3 class="menu-title">Stock Management</h3><!-- /.menu-title -->

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Stock inwards </a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
                    </li>

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Stock outwards</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%=application.getContextPath()%>/SerItemOutwards?op=pn1">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%=application.getContextPath()%>/SerItemOutwards?op=pn2">View</a></li>
                        </ul>
                    </li>
                    
                    
 <h3 class="menu-title">Stock Summary</h3><!-- /.menu-title -->

                    <li >
                        <a href="<%=application.getContextPath()%>/SerItemOutwards?op=balance"   aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Stock</a>
<!--                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
-->                    </li>
                      <li >
                        <a href="PurchaseReport.jsp"   aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Purchase Summary </a>
<!--                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
-->                    </li>
                      <li >
                        <a href="IssueReport.jsp"   aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Issue Summary </a>
<!--                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
-->                    </li>
                      <li >
                        <a href="<%=application.getContextPath()%>/SerItemInward?op=reorder"   aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Reorder Level </a>
<!--                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
-->                    </li>
 <li >
                        <a href="<%=application.getContextPath()%>/purchaseOrderServlet"   aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Purchase Order </a>
<!--                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=pn">Add</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="<%= application.getContextPath()%>/SerItemInward?op=view">View</a></li>
                        </ul>
-->                    </li>
                 
                    
<!--                    <h3 class="menu-title">Security Guard Management</h3>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Uniform issue details</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=application.getContextPath()%>/SerSecurityGuard?op=unitname&ui=issue">Add</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=application.getContextPath()%>/SerUniformIssue?op=get">View</a></li>                         
                        </ul>
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Uniform return</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=application.getContextPath()%>/SerSecurityGuard?op=unitname&ui=return">Add</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=application.getContextPath()%>/SerUniformReturn?op=get">View</a></li>                         
                        </ul>
                    </li>-->
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>