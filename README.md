[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&width=435&lines=Quest)](https://git.io/typing-svg)
<h2><a>text web quest</a></h2>

After initialization, the user is given questions and two possible answers.

> The purpose of the quest is to alternately choosing the correct answers,
> get to the point where it leads to victory
>
* There is only one correct answer
* If you answer incorrectly or win, you can restart the quest
* During the session with the user, game statistics are kept

<h3><a>Build: </a></h3>

```$ docker build -t quest .```

<h3 ><a>Lounch:</a></h3>

```$ docker run -p 1111:8080 quest```

link: ```localhost:1111/Quest```

<h3 ><a>Description of classes</a></h3>

>Root package:
- ```main``` - start point to app
-  ```test``` - start point to tests

>Package ```main/java/com/example/quest``` has subpackage:
- ```dates``` - main object structures and interface
- ```exceptions``` - app's exceptions
- ```service``` - contains application business logic and quest content
- ```servlits``` - subpackage with servlets

>also has class:

- ```ContextListener``` - loads application objects into the context

>File ```main/resources```: 

- ```log4j2.xml``` - !For correct logging, you must specify the save path
- ```content.json``` - text content of quests

>in derrectory ```src/main/webapp/WEB-INF```:
- ```index.jsp``` - main page

<h3><a>Technology</a></h3>

- Maven
- JSP, JSTL
- Bootstrap, CSS
- JUnit5, Mockito
- lombok
