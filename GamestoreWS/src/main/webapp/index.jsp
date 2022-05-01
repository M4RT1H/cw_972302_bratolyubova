<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" ng-app="main">



<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameStore</title>
    <base href="/">
    <link rel="icon" type="image/ico" href="Images/favicon.ico"/>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/Site.css"/>


    <script src="js/angular.js"></script>
    <script src="js/angular-route.js"></script>
    <script src="js/angular-touch.js"></script>
    <script src="js/angular-animate.js"></script>
    <script src="js/angular-ui/ui-bootstrap.js"></script>
    <script src="js/checklist-model.js"></script>
    <script src="js/Chart.js"></script>
    <script src="js/angular-chart.js"></script>
    <script src="js/main.js"></script>

</head>

<body>

<div ng-controller="NavBarController">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" ng-click="isCollapsed = !isCollapsed"
                        data-toggle="collapse" data-target="#navBar" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-left" href="/"><img alt="GameStore" src="Images/logo.png" id="img_logo"></a>
            </div>
            <div class="collapse navbar-collapse" uib-collapse="isCollapsed" id="navBar">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <div class="navbar-form">
                            <div class="input-group">
                                <input type="text" class="form-control no-right-border" ng-model="SearchText"
                                       placeholder="Игра...">
                                <div class="input-group-btn">
                                    <button class="btn btn-danger no-left-border" ng-click="Search()">
                                        Поиск
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li uib-dropdown ng-if="isAuthenticated.Value">
    <span class="navbar-brand" style="font-size: 12px; color: grey">
        Потрачено: {{User.data.balance}}$
    </span>

                    </li>
                    <li id="userDropdown" uib-dropdown ng-if="isAuthenticated.Value">
                        <a href="#" uib-dropdown-toggle data-toggle="userDropdown" class="userBtn">
                            <span class="glyphicon glyphicon-user"></span> {{User.data.login}} <span
                                class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" uib-dropdown-menu>
                            <li><a href="/UpdateUser">Настройки</a></li>
                            <li class="divider"></li>
                            <li><a href="#" id="logOffBtn" ng-click="logOff()">Выйти</a></li>
                        </ul>
                    </li>
                    <li ng-if="!isAuthenticated.Value"><a href="/Registration"><span
                            class="glyphicon glyphicon-user"></span> Регистрация</a></li>
                    <li ng-if="!isAuthenticated.Value"><a href="/Login" id="loginBtn"><span
                            class="glyphicon glyphicon-log-in"></span> Войти</a></li>

                </ul>

            </div>
        </div>
        <div>
            <div class="progress barAnimation" style="margin: 0;" ng-class="{'barOpen': loadBar.show}">
                <div class="progress-bar progress-bar-striped progress-bar-danger active" role="progressbar"
                     aria-valuemin="0" aria-valuemax="100" style="width:100%">

                </div>
            </div>
        </div>
    </nav>
</div>


<div class="top-buffer" style="z-index: 3">
    <div class="" style="margin: 40px; padding: 10px;">

        <div class="row">


            <div class="col-md-3">
                <div class="affix" resizer="affix" win-size="991" style="width: 200px">
                    <div class="list-group" ng-controller="SideMenuController">
                        <div ng-repeat="item in Items">
                            <div ng-if="item.show">
                                <a ng-if="item.name !== 'Separator'" href="{{item.url}}"
                                   ng-class="item.checked ? 'list-group-item menuActive menuItem' : 'list-group-item menuItem'">{{item.name}}
                                    <span class="{{item.icon}}"></span></a>
                                <hr ng-if="item.name === 'Separator'"/>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div ng-view>
            </div>
        </div>
    </div>

    <div style="margin: 0; padding-left: 20px;padding-right: 20px;" id="footer">

        <hr>

        <!-- Footer -->
        <div>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Course work - GameStore 2017</p>
                </div>
            </div>
        </div>

    </div>
</div>


</body>

</html>

