<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Quest</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/style.css">
</head>
<body>

<script src="../front/bootstrap.bundle.min.js"></script>

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
                        На каждом уровне ты будешь получать вопрос и два варианта ответа. Если ты выберишь
                        правильный, ты перейдешь на новый уровень. Если нет - ты проиграл, но можно попробовать
                        снова</p>
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
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/init">Продолжить</a>
            </c:if>
        </div>
    </div>
</section>

<c:if test="${user != null}">

    <!--Предистория-->
    <section id="preview">
        <div class="row text-center">
            <div class="rol-12">

                <c:if test="${isReady == false}">

                    <h3 class="container text-center color2"> События квеста начинаются в ближайшем будущем, когда люди
                        все ж создали полноценный
                        разум. Люди его контролировали, но в испытательном центре произошел сбой,
                        и Разум получил доступ к интернету.</h3>
                    <br><br>
                    <h5 class="color1"> Нажми "Начать" когда будешь готов </h5>
                    <br>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/logic">Начать</a>
                </c:if>
            </div>
        </div>
    </section>

    <!--Шаги квеста-->
    <section id="questSteps">
        <div class="row text-center">
            <div class="rol-12">

                <c:if test="${isReady == true}">

                <div class="container">
                    <div class="row">
                        <div class="rol-12">
                            <h2 class="text-center color2">
                                    ${user.getLevel().getQuestion()}
                            </h2>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="container text-center">
                    <div class="row">
                        <a class="btn next_btn" href="${pageContext.request.contextPath}/logic">
                                ${user.getLevel().getPositiveText()}</a>
                        <a class="btn next_btn" href="${pageContext.request.contextPath}/finish">
                                ${user.getLevel().getNegativeText()}
                        </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!--Результаты-->
    <section id="result">
        <div class="row">
            <div class="rol-12">
                <c:if test="${isFinished == true}">
                    <c:if test="${win == true}">

                        <div class="container text-center">
                            <h2 class="text-center text-success">
                                Победа, теперь ты живешь в лесу. Зато, никакого программирования <span>&#129445</span>
                            </h2>
                            <br><br>
                            <a class="btn next_btn" href="${pageContext.request.contextPath}/logic">Повторить
                            </a>
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
                            <a class="btn statistic_btn" href="${pageContext.request.contextPath}/logic">
                                Начать снова
                            </a>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </div>
    </section>

    <section id="statistic">
        <!--Статистика-->
        <!-- Button trigger -->
        <button class="btn statistic_btn" data-bs-toggle="modal" data-bs-target="#statisticModal">
            Статистка игр
        </button>

        <div class="modal fade" id="statisticModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <h2 class="modal-title fs-5" id="modalLabel">Твой результат</h2>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <h4 class="text-center statistic">Всего попыток пройти квест: ${user.getCountGames()}
                        </h4>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn statistic_btn" data-bs-dismiss="modal">Скрыть</button>
                    </div>

                </div>
            </div>
        </div>
    </section>

</c:if>

</body>
</html>
