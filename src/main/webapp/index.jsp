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

                <div class="text-center">
                    <button id="btnRule" class="btn ruleButton">О правилах квеста</button>
                    <p id="aboutText" class="hideText text-white">Это квест игра, в которой нужно принимать решения.
                        На каждом уровне ты будешь получать вопрос и только два варианта ответа. Если ты выберишь правильный
                        вариант, ты перейдешь на новый уровень. А в конце можно выиграть.</p>
                </div>
                <script>
                    btnRule.onclick = function () {
                        aboutText.classList.toggle('hideText');
                        this.innerHTML.indexOf('О правилах квеста') > -1 ? this.innerHTML = "Спрятать текст правил" :
                            this.innerHTML = "О правилах квеста";
                    }
                </script>
            </div>
        </div>
    </div>
</header>

<!--Инициальзация пользователя-->
<section id="newUser">
    <div class="row text-center">
        <div class="rol-12">

    <c:if test="${user == null}">
        <h2 id="helloText" class="color2">
            Чтобы начать квест, нужно представиться
        </h2>
        <br>
            Твое имя: <input name="name"/>
            <br><br>
            <button onclick="window.location='/init'" class="btn btn-primary">
                Продолжить
            </button>
            </c:if>
    </div>
    </div>
</section>

<c:if test="${user != null}">

    <% User user = (User) request.getSession().getAttribute("user"); %>

<!--Предистория-->
<section id="preview">
    <div class="row text-center">
        <div class="rol-12">

    <c:if test="${isReady == false}">

        <h3 class="container text-center color2"> События квеста начинаются в ближайшем будущем, когда люди все ж создали полноценный
            разум. Люди его контролировали, но в испытательном центре произошел сбой,
            и Разум получил доступ к интернету.</h3>
        <br><br>
        <h5 class="color1"> Нажми "Начать" когда будешь готов.
            И да, у тебя только 1 попытка на ответ <span>&#128513</span></h5>
        <br>
        <button onclick="window.location='/logic'" class="btn btn-primary">
            Начать
        </button>
    </c:if>
        </div>
    </div>
</section>

<!--Шаги квеста-->
<section id="questSteps">

<c:if test="${isReady == true}">

<div class="container">
    <div class="row">
        <div class="rol-12">
            <h1 class="text-center color2">
                <%=user.getLevel().getQuestion()%>
        </h1>
    </div>
</div>
</div>
    <br><br>
<div class="container text-center">
    <div class="row">
    <button onclick="window.location='/logic'" class="btn next_btn">
        <%=user.getLevel().getPositiveText()%>
    </button>
    <button onclick="window.location='/finish'" class="btn next_btn">
        <%=user.getLevel().getNegativeText()%>
    </button>
        </c:if>
    </div>
    </div>
</section>

<section id="result">
    <c:if test="${isFinished == true}">
    <c:if test="${win == true}">

    <div class="container text-center">
        <h2 class="text-center text-success">
            Победа, теперь ты живешь в лесу. Зато, никакого программирования <span>&#129445</span>
        </h2>
        <br>
        <button onclick="window.location='/logic'" class="btn next_btn">Повторить</button>
    </div>
    </c:if>

    <c:if test="${win == false}">
    <div class="container text-center">
        <h2 class="text-center text-danger">
            <p>
            Ты проиграл, ${failText}
            <p/>
        </h2>
        <br>
        <button onclick="window.location='/logic'" class="btn next_btn">
            Начать снова
        </button>
        </div>
    </c:if>
    </c:if>
</section>

    </c:if>

</div>

</body>
</html>
