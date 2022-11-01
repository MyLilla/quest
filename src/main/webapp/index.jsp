<%@ page import="com.example.quest.dates.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Quest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>

<header>
    <div class="container">
        <div class="row">
            <div class="rol-12">
                <h1 class="text-center text-white">
                    Quest
                </h1>

                <div class="test">
                    <button id="btnRule" class="btn ruleButton">О правилах квеста</button>
                    <p id="aboutText" class="hideText">Это квест игра, в которой нужно принимать решения.
                        На каждом уровне ты будешь получать вопрос и два варианта ответа. Если ты выберишь правильный
                        вариант,
                        ты перейдешь на новый уровень. А в конце можно выиграть.</p>
                </div>
                <script>
                    btnRule.onclick = function () {
                        aboutText.classList.toggle('hideText');
                        this.innerHTML.indexOf('О правилах квеста') > -1 ? this.innerHTML = "Спрятать текст" :
                            this.innerHTML = "О правилах квеста";
                    }
                </script>
            </div>
        </div>
    </div>
    </div>
</header>

<section id="Page" class="text-center">

    <c:if test="${user == null}">
    <figure class="text-center">
        <p id="helloText">
            Чтобы начать квест, нужно представиться
        </p>

        <form action="/init">
            Твое имя: <input name="name"/>
            <br><br>
            <input type="submit" class="btn btn-danger" value="Продолжить"/>
            </c:if>

            <c:if test="${user != null}">

           <% User user = (User) request.getSession().getAttribute("user"); %>

            <c:if test="${isReady == false}">

            <p>Привет <%=user.getName()%>! Тебе будут даны 2 варианта, правильный
                только 1. Нажми "Начать" когда будешь готов.
                И да, у тебя только 1 попытка на ответ <span>&#128513</span></p>
            <button onclick="window.location='/logic'" class="btn btn-danger">
                Начать
            </button>
            </c:if>
            <br>
    </figure>
</section>

<c:if test="${isWinner != true && isReady == true && isFail != true}">

<div class="container">
    <div class="row">
        <h1 class="text-center text-white">
            <p>
                <%=user.getLevel().getQuestion()%>
            </p>
        </h1>
    </div>
</div>

<div class="container text-center">
    <button onclick="window.location='/logic'" class="col">
        <%=user.getLevel().getPositiveText()%>
    </button>
    <button onclick="window.location='/logic?isFail=true'" class="col">
        <%=user.getLevel().getNegativeText()%>
    </button>
    </c:if>

    <c:if test="${isWinner == true}">
    <div class="container text-center">
        <h1 class="text-center text-white">
            Победа <%=user.getName()%>, тебя вернули домой, ура
        </h1>
        <button onclick="window.location='/logic'" class="col">
            Начать снова
        </button>
    </div>
    </c:if>

    <c:if test="${isFail == true}">
        <h1 class="text-center text-white">
            <%=user.getName()%>, ты проиграл, печально
        </h1>
        <button onclick="window.location='/logic'" class="col">
            Повторить
        </button>
    </c:if>
    </c:if>

</div>
</body>
</html>
