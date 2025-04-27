[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&width=435&lines=Apocalypse)](https://git.io/typing-svg)

<h2><a>game-text-quest</a></h2>

Extra project for JavaRush course (module WEB)

<h3><a>About: </a></h3>

> The purpose of the quest is to alternately choosing the correct answers,
> get to the point where it leads to victory

After initialization, the user is given questions and two possible answers.
* There is only one correct answer
* If you answer incorrectly or win, you can restart the quest
* During the session with the user, game statistics are kept

<h3><a>Build: </a></h3>

```$ docker build -t quest .```

<h3 ><a>Lounch:</a></h3>

```$ docker run -p 1111:8080 quest```

link: ```localhost:1111```

<h3><a>Technology</a></h3>

- Maven
- UI: JSP, JSTL, Bootstrap, CSS
- Tests: JUnit5, Mockito
- lib's: lombok
